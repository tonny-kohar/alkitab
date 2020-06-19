/* This work has been placed into the public domain. */

package kiyut.alkitab.windows;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import javax.swing.JPopupMenu;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import kiyut.alkitab.bookviewer.BookViewerManager;
import kiyut.alkitab.bookviewer.SwordURI;
import kiyut.alkitab.bookshelf.BookshelfTree;
import kiyut.alkitab.bookshelf.BookshelfTreeModel;
import kiyut.openide.util.NbUtilities;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileAttributeEvent;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileRenameEvent;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * TopComponent which displays available book as {@link kiyut.alkitab.bookshelf.BookshelfTree BookshelfTree}.
 * 
 * @author Tonny Kohar <tonny.kohar@gmail.com>
 */
@TopComponent.Description(preferredID = "BookshelfTopComponent",
    //iconBase="SET/PATH/TO/ICON/HERE", 
    persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true, position=100)
@ActionID(category = "Window", id = "kiyut.alkitab.actions.BookshelfAction")
@ActionReferences({
    @ActionReference(path = "Menu/Window", position = 100),
    @ActionReference(path = "Shortcuts", name = "DO-1")
})
@TopComponent.OpenActionRegistration(displayName = "#CTL_BookshelfAction",
    preferredID = "BookshelfTopComponent")
public final class BookshelfTopComponent extends TopComponent {

    
    private InstanceContent content;
    private Book selectedBook;
    
    private BookshelfTree booksTree;
    
    // popup menu related
    private JPopupMenu popupMenu;
    private boolean popupMenuValid = false;
    private String popupMenuFolderName = "Alkitab/Bookshelf/PopupMenu";
    
    private BookshelfTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(BookshelfTopComponent.class, "CTL_BookshelfTopComponent"));
        setToolTipText(NbBundle.getMessage(BookshelfTopComponent.class, "HINT_BookshelfTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));
        
        initCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();

        setLayout(new java.awt.BorderLayout());
        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtain the BookshelfTopComponent instance.
     * @return BookshelfTopComponent instance.
     */
    public static synchronized BookshelfTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent("BookshelfTopComponent");
        if (win instanceof BookshelfTopComponent) {
            return (BookshelfTopComponent) win;
        }
        
        return null;
    }
    
    @Override
    protected void componentActivated() {
        super.componentActivated();
        if (booksTree.getSelectionPath() == null) {
            TreeNode root = (TreeNode) booksTree.getModel().getRoot();
            if (root.getChildCount()>0) {
                booksTree.setSelectionRow(0);
            }
        }
        booksTree.requestFocusInWindow();
    }
    
    private void initCustom() {
        // registering lookup
        content = new InstanceContent();
        Lookup dynamicLookup = new AbstractLookup(content);
        associateLookup(dynamicLookup);
        
        booksTree = new BookshelfTree();
        scrollPane.setViewportView(booksTree);
        
        booksTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.isPopupTrigger()) { return; }
                if (evt.getClickCount() != 2) { return; }
                
                openSelectedBook();
            }
            
            @Override
            public void mousePressed(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopup(evt);
                }
            }
            @Override
            public void mouseReleased(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopup(evt);
                }
            }

            private void showPopup(MouseEvent evt) {
                if (popupMenuValid == false) {
                    createPopupMenu();
                }

                if (popupMenu == null) {
                    return;
                }

                TreePath treePath = booksTree.getSelectionPath();
                //TreePath treePath = booksTree.getPathForLocation(evt.getX(), evt.getY());
                if (treePath == null) { return; }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                if (!node.isLeaf()) { return; }

                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
        
        FileObject fo = FileUtil.getConfigRoot().getFileObject(popupMenuFolderName);
        
        // add listener to monitor layer.xml popup menu change
        fo.addFileChangeListener(new FileChangeAdapter() {
            @Override
            public void fileFolderCreated(FileEvent fe) { popupMenuValid = false; }
            @Override
            public void fileDataCreated(FileEvent fe) { popupMenuValid = false; }
            @Override
            public void fileChanged(FileEvent fe) { popupMenuValid = false; }
            @Override
            public void fileDeleted(FileEvent fe) { popupMenuValid = false; }
            @Override
            public void fileRenamed(FileRenameEvent fe) { popupMenuValid = false; }
            @Override
            public void fileAttributeChanged(FileAttributeEvent fe) { popupMenuValid = false; }
        });
        createPopupMenu();
        
        booksTree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
                    return;
                }
                openSelectedBook();
            }
        });

        booksTree.getSelectionModel().addTreeSelectionListener((TreeSelectionEvent evt) -> {
            if (selectedBook != null) {
                content.remove(selectedBook);
                selectedBook = null;
            }
            
            TreePath treePath = evt.getPath();
            if (treePath == null) {
                return;
            }
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            
            Object obj = node.getUserObject();
            if (obj instanceof Book) {
                selectedBook = (Book)obj;
                content.add(selectedBook);
            }
        });
    }
    
    private void createPopupMenu() {
        popupMenu = new JPopupMenu();
        NbUtilities.createMenu(popupMenu,popupMenuFolderName);
        
        if (popupMenu.getComponentCount() <= 0) {
            this.popupMenu = null;
        }
        
        popupMenuValid = true;
    }
    
    /** Reload the tree */
    public void reload() {
        ((BookshelfTreeModel)booksTree.getModel()).reload();
    }
    
    /** Open the selected book, if the currently selected node 
     * is not a book eg: category, it do nothing
     */
    public void openSelectedBook() {
        TreePath treePath = booksTree.getSelectionPath();
        if (treePath == null) {
            return;
        }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();

        Object obj = node.getUserObject();
        if (!(obj instanceof Book)) {
            return;
        }

        Book book = (Book)obj;
        boolean validKey = false;

        if (book.isLocked() || book.isEnciphered()) {
            if (book.isEnciphered() && !book.isLocked()) {
                // test the unlock key
                validKey = isUnlockKeyValid(book);
            }

            if (!validKey) {
                String title = NbBundle.getMessage(BookshelfTopComponent.class, "MSG_UnlockBook.Title");
                String msg = NbBundle.getMessage(BookshelfTopComponent.class, "MSG_UnlockBook.Text");

                Object[] args = {book.getName()};
                msg = MessageFormat.format(msg, args);

                boolean canceled = false;

                NotifyDescriptor.InputLine d = new NotifyDescriptor.InputLine(msg, title,
                    NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.QUESTION_MESSAGE);

                String unlockKey = book.getUnlockKey();

                while (!canceled) {
                    d.setInputText(unlockKey);
                    if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {
                        unlockKey = d.getInputText();
                        if (unlockKey != null && unlockKey.length() > 0) {
                            boolean unlocked = book.unlock(unlockKey);
                            validKey = isUnlockKeyValid(book);
                            if (!(unlocked && validKey)) {
                                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                                        NbBundle.getMessage(BookshelfTopComponent.class, "MSG_InvalidUnlockKey.Text"),
                                        NotifyDescriptor.ERROR_MESSAGE));
                            }
                            canceled = validKey;
                        }
                    } else {
                        canceled = true;
                    }
                }
            }
        } else {
            validKey = true;
        }

        if (!validKey) {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(NbBundle.getMessage(BookshelfTopComponent.class, "MSG_BookLocked.Text"), NotifyDescriptor.INFORMATION_MESSAGE));
            return;
        }

        SwordURI uri = SwordURI.createURI(book, null);
        if (uri != null) {
            BookViewerManager.getInstance().openURI(uri, null, true);
        }
    }

    /** XXX workaround for unimplemented unlock key validation in JSword.
     * Once it is implemented by JSword, remove this.
     * The checking is implemented by trying to query book rawtext
     * @return true if valid otherwise false
     */
    private boolean isUnlockKeyValid(Book book) {
        boolean valid;

        try {
            Key key = book.getGlobalKeyList();
            if (key == null) {
                // weird key == null, assume it is valid
                return true;
            }
            if (key.getCardinality() > 0) {
                key = key.get(0);
            }
            
            book.getRawText(key);
            valid = true;
        } catch (Exception ex) {
            valid = false;
        }

        return valid;
    }

    /** Return the selected book or null
     *  @return the selected book or null
     */
    public Book getSelectedBook() {
        TreePath treePath = booksTree.getSelectionPath();
        if (treePath == null) {
            return null;
        }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();

        Object obj = node.getUserObject();
        if (!(obj instanceof Book)) {
            return null;
        }
        
        return (Book)obj;
    }

    public BookshelfTree getBookshelf() {
        return booksTree;
    }
}
