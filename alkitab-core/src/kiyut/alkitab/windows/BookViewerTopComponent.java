/* This work has been placed into the public domain. */

package kiyut.alkitab.windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import kiyut.alkitab.bookviewer.BookViewer;
import kiyut.alkitab.bookviewer.BookViewerNode;
import kiyut.alkitab.bookviewer.SwordURI;
import kiyut.alkitab.options.BookViewerOptions;
import org.openide.nodes.Node;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * 
 * TopComponent which displays {@link kiyut.alkitab.api.BookViewer BookViewer}.
 * 
 * @author Tonny Kohar <tonny.kohar@gmail.com>
 */
public abstract class BookViewerTopComponent extends TopComponent {
    protected BookViewerNode bookViewerNode;

    protected PropertyChangeListener backgroundPropertyChangeListener;
    
    public abstract BookViewer getBookViewer();
    
    public abstract void openURI(SwordURI uri, String info);

    public BookViewerTopComponent() {
        backgroundPropertyChangeListener = (PropertyChangeEvent evt) -> {
            if (!evt.getPropertyName().equals(BookViewerOptions.BACKGROUND)) {
                return;
            }
            BookViewer bookViewer = getBookViewer();
            if (bookViewer == null) {
                return;
            }
            /*Color bg = null;
            if (evt.getNewValue() instanceof Color) {
            bg = (Color) evt.getNewValue();
            }
            bookViewer.getBookRenderer().getComponent().setBackground(bg);
            */
            bookViewer.reload();
        };
    }

    @Override
    public void componentActivated() {
        if (bookViewerNode != null) {
            setActivatedNodes(new Node[]{bookViewerNode});
        }
    }

    @Override
    public void componentOpened() {
        BookViewerOptions.getInstance().addPropertyChangeListener(backgroundPropertyChangeListener);

        BookViewer bookViewer = getBookViewer();
        if (bookViewer != null) {
            Color bg = BookViewerOptions.getInstance().getBackground();
            //System.out.println("this is executed");
            bookViewer.getBookRenderer().getComponent().setBackground(bg);
        }
    }

    
    @Override
    public void componentClosed() {
        if (bookViewerNode != null) {
            bookViewerNode.closed();
        }
        BookViewerOptions.getInstance().removePropertyChangeListener(backgroundPropertyChangeListener);
    }

    @Override
    public javax.swing.Action[] getActions() {
        List<Action> actionList = new ArrayList<>();
        
        // add 
        actionList.add(new RenameTabAction());
        actionList.add(new ViewSourceAction());
        actionList.add(null);  // separator
        actionList.addAll(Arrays.asList(super.getActions()));
        
        return actionList.toArray(new Action[0]);
    }
    
    public class ViewSourceAction extends AbstractAction {
        public ViewSourceAction() {
            putValue(Action.NAME, NbBundle.getMessage(ViewSourceAction.class, "CTL_ViewSourceAction"));
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            BookViewer bookViewer = getBookViewer();
            if (bookViewer == null) {
                return;
            }
            bookViewer.viewSource();
        }
    }
    
    public class RenameTabAction extends AbstractAction {
        public RenameTabAction() {
            putValue(Action.NAME, NbBundle.getMessage(RenameTabAction.class, "CTL_RenameTabAction"));
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //JOptionPane.showMessageDialog(BookViewerTopComponent.this, "Not Implemented Yet", "Error", JOptionPane.ERROR_MESSAGE);
            
            String newName =  JOptionPane.showInputDialog(BookViewerTopComponent.this, "Please enter the new name: ", getName(), JOptionPane.QUESTION_MESSAGE);
            
            // validate 
            if (newName != null) {
                newName = newName.trim();
                if (newName.isEmpty()) {
                    newName = null;
                }
            }
            
            if (newName == null) {
                return;
            }
            
            BookViewer bookViewer = getBookViewer();
            if (bookViewer == null) { return; }
            bookViewer.setName(newName);
            //BookViewerTopComponent.this.setName(newName);
            //firePropertyChange(newName, newName, newName);
            
            /*Logger logger = Logger.getLogger(this.getClass().getName());
            
            if (newName == null) {
                logger.log(Level.WARNING, "new name is null");
            } else if (newName.isEmpty()) {
                logger.log(Level.WARNING, "new name is empty");
            } else {
                logger.log(Level.WARNING, newName);
            }*/
        }
    }
}
