/* This work has been placed into the public domain. */

package kiyut.alkitab.options;

import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;

@OptionsPanelController.SubRegistration(
    location = "BookViewer",
    displayName="kiyut.alkitab.options.GeneralOptionsPanel#DisplayName",
    keywords="kiyut.alkitab.options.GeneralOptionsPanel#Keywords",
    keywordsCategory="BookViewer/General"    
)
public final class GeneralOptionsPanelController extends OptionsPanelController {
    private GeneralOptionsPanel panel;

    @Override
    public void update() {
        getOptionsPanel().update();
    }

    @Override
    public void applyChanges() {
        getOptionsPanel().applyChanges();
    }

    @Override
    public void cancel() {
        getOptionsPanel().cancel();
    }

    @Override
    public boolean isValid() {
        return getOptionsPanel().isOptionsValid();
    }

    @Override
    public boolean isChanged() {
        return getOptionsPanel().isChanged();
    }

    @Override
    public HelpCtx getHelpCtx() {
        return null; // new HelpCtx("...ID") if you have a help set
    }
    
    private GeneralOptionsPanel getOptionsPanel() {
        if (panel == null) {
            panel = new GeneralOptionsPanel();
        }
        return panel;
    }    

    @Override
    public JComponent getComponent(Lookup masterLookup) {
        return getOptionsPanel();
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        getOptionsPanel().addPropertyChangeListener(l);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {
        getOptionsPanel().removePropertyChangeListener(l);
    }    
}
