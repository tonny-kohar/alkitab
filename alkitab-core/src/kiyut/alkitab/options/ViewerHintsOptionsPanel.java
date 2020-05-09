/* This work has been placed into the public domain. */

package kiyut.alkitab.options;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;
import kiyut.alkitab.bookviewer.ViewerHints;
import org.netbeans.spi.options.OptionsPanelController;

@OptionsPanelController.Keywords(
    location="BookViewer",
    tabTitle="kiyut.alkitab.options.ViewerHintsOptionsPanel#DisplayName",
    keywords={"kiyut.alkitab.options.ViewerHintsOptionsPanel#Keywords"}    
)
final class ViewerHintsOptionsPanel extends javax.swing.JPanel {

    private final ResourceBundle bundle = ResourceBundle.getBundle(this.getClass().getName());
    
    /** updating flag */
    private boolean updating;
    
    /** changed flag */
    private boolean changed;

    ViewerHintsOptionsPanel() {
        initComponents();
        initCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        verseButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        noVNumCheckBox = new javax.swing.JCheckBox();
        verseNumbersPane = new javax.swing.JPanel();
        vNumRadioButton = new javax.swing.JRadioButton();
        cvNumRadioButton = new javax.swing.JRadioButton();
        bcvNumRadioButton = new javax.swing.JRadioButton();
        tinyVNumCheckBox = new javax.swing.JCheckBox();
        vLineCheckBox = new javax.swing.JCheckBox();
        headingsCheckBox = new javax.swing.JCheckBox();
        notesCheckBox = new javax.swing.JCheckBox();
        strongsCheckBox = new javax.swing.JCheckBox();
        morphCheckBox = new javax.swing.JCheckBox();
        tooltipPopupCheckBox = new javax.swing.JCheckBox();
        xRefCheckBox = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 18, 18, 18));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(noVNumCheckBox, bundle.getString("CTL_NoVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(noVNumCheckBox, gridBagConstraints);

        verseNumbersPane.setLayout(new java.awt.GridBagLayout());

        verseButtonGroup.add(vNumRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(vNumRadioButton, bundle.getString("CTL_VNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        verseNumbersPane.add(vNumRadioButton, gridBagConstraints);

        verseButtonGroup.add(cvNumRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(cvNumRadioButton, bundle.getString("CTL_CVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        verseNumbersPane.add(cvNumRadioButton, gridBagConstraints);

        verseButtonGroup.add(bcvNumRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(bcvNumRadioButton, bundle.getString("CTL_BCVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        verseNumbersPane.add(bcvNumRadioButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(tinyVNumCheckBox, bundle.getString("CTL_TinyVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        verseNumbersPane.add(tinyVNumCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 40, 6, 0);
        jPanel1.add(verseNumbersPane, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(vLineCheckBox, bundle.getString("CTL_VLine.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(vLineCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(headingsCheckBox, bundle.getString("CTL_Headings.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(headingsCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(notesCheckBox, bundle.getString("CTL_Notes.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(notesCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(strongsCheckBox, bundle.getString("CTL_Strongs.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(strongsCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(morphCheckBox, bundle.getString("CTL_Morph.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(morphCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(tooltipPopupCheckBox, bundle.getString("CTL_TooltipPopup.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(tooltipPopupCheckBox, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(xRefCheckBox, bundle.getString("CTL_XRef.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel1.add(xRefCheckBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel5, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bcvNumRadioButton;
    private javax.swing.JRadioButton cvNumRadioButton;
    private javax.swing.JCheckBox headingsCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JCheckBox morphCheckBox;
    private javax.swing.JCheckBox noVNumCheckBox;
    private javax.swing.JCheckBox notesCheckBox;
    private javax.swing.JCheckBox strongsCheckBox;
    private javax.swing.JCheckBox tinyVNumCheckBox;
    private javax.swing.JCheckBox tooltipPopupCheckBox;
    private javax.swing.JCheckBox vLineCheckBox;
    private javax.swing.JRadioButton vNumRadioButton;
    private javax.swing.ButtonGroup verseButtonGroup;
    private javax.swing.JPanel verseNumbersPane;
    private javax.swing.JCheckBox xRefCheckBox;
    // End of variables declaration//GEN-END:variables

    private void initCustom() {
        noVNumCheckBox.addItemListener((ItemEvent evt) -> {
            boolean sel = noVNumCheckBox.isSelected();
            for (int i = 0; i < verseNumbersPane.getComponentCount(); i++) {
                verseNumbersPane.getComponent(i).setEnabled(!sel);
            }
        });
        
        // listener for tracking change
        ItemListener listener = (ItemEvent evt) -> {
            if (updating == false && changed == false) {
                changed = true;
            }
        };
        
        noVNumCheckBox.addItemListener(listener);
        vNumRadioButton.addItemListener(listener);
        cvNumRadioButton.addItemListener(listener);
        bcvNumRadioButton.addItemListener(listener);
        
        tinyVNumCheckBox.addItemListener(listener);
        vLineCheckBox.addItemListener(listener);
        headingsCheckBox.addItemListener(listener);
        notesCheckBox.addItemListener(listener);
        strongsCheckBox.addItemListener(listener);
        morphCheckBox.addItemListener(listener);
        tooltipPopupCheckBox.addItemListener(listener);
        xRefCheckBox.addItemListener(listener);
        
        updating = false;
        changed = false;
    }
    
    void update() {
        updating = true;
        
        ViewerHints<ViewerHints.Key,Object> hints = ViewerHintsOptions.getInstance().getViewerHints();
        Object hintsVal;

        hintsVal = hints.get(ViewerHints.NO_VERSE_NUMBERS);
        noVNumCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.VERSE_NUMBERS);
        boolean vNum = ((Boolean)hintsVal);
        hintsVal = hints.get(ViewerHints.CHAPTER_VERSE_NUMBERS);
        boolean cvNum = ((Boolean)hintsVal);

        if (vNum) {
            vNumRadioButton.setSelected(true);
        } else {
            if (cvNum) {
                cvNumRadioButton.setSelected(true);
            } else {
                bcvNumRadioButton.setSelected(true);
            }
        }

        hintsVal = hints.get(ViewerHints.TINY_VERSE_NUMBERS);
        tinyVNumCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.START_VERSE_ON_NEWLINE);
        vLineCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.HEADINGS);
        headingsCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.NOTES);
        notesCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.STRONGS_NUMBERS);
        strongsCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.MORPH);
        morphCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.TOOLTIP_POPUP);
        tooltipPopupCheckBox.setSelected(((Boolean)hintsVal));
        hintsVal = hints.get(ViewerHints.XREF);
        xRefCheckBox.setSelected(((Boolean)hintsVal));
        
        updating = false;
        changed = false;
    }

    void applyChanges() {
        ViewerHintsOptions viewerHintsOpts = ViewerHintsOptions.getInstance();
        ViewerHints<ViewerHints.Key,Object> hints = viewerHintsOpts.getViewerHints();
        hints.put(ViewerHints.NO_VERSE_NUMBERS, noVNumCheckBox.isSelected());
        hints.put(ViewerHints.VERSE_NUMBERS, vNumRadioButton.isSelected());
        hints.put(ViewerHints.CHAPTER_VERSE_NUMBERS, cvNumRadioButton.isSelected());
        hints.put(ViewerHints.BOOK_CHAPTER_VERSE_NUMBERS, bcvNumRadioButton.isSelected());
        hints.put(ViewerHints.TINY_VERSE_NUMBERS, tinyVNumCheckBox.isSelected());
        hints.put(ViewerHints.START_VERSE_ON_NEWLINE, vLineCheckBox.isSelected());
        hints.put(ViewerHints.HEADINGS, headingsCheckBox.isSelected());
        hints.put(ViewerHints.NOTES, notesCheckBox.isSelected());
        hints.put(ViewerHints.STRONGS_NUMBERS, strongsCheckBox.isSelected());
        hints.put(ViewerHints.MORPH, morphCheckBox.isSelected());
        hints.put(ViewerHints.TOOLTIP_POPUP, tooltipPopupCheckBox.isSelected());
        hints.put(ViewerHints.XREF, xRefCheckBox.isSelected());

        viewerHintsOpts.store();
        changed = false;
    }
    
    boolean isOptionsValid() {
        return true;
    }
    
    void cancel() {
        // need not do anything special, if no changes have been persisted yet
    }
    
    boolean isChanged() {
        return changed;
    }
}
