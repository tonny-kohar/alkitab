/* This work has been placed into the public domain. */

package kiyut.alkitab.bookviewer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Tonny Kohar <tonny.kohar@gmail.com> 
 */
public class ViewerHintsPane extends javax.swing.JPanel {
    protected ResourceBundle bundle = ResourceBundle.getBundle(this.getClass().getName()); 
    
    protected ViewerHints<ViewerHints.Key,Object> viewerHints;

    /** Creates new ViewerHintsPane */
    public ViewerHintsPane() {
        this(null);
    }
    
    public ViewerHintsPane(ViewerHints<ViewerHints.Key,Object> viewerHints) {
        initComponents();
        initCustom();
        if (viewerHints != null) {
            setViewerHints(viewerHints);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        verseButtonGroup = new javax.swing.ButtonGroup();
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

        setLayout(new java.awt.GridBagLayout());

        noVNumCheckBox.setText(bundle.getString("CTL_NoVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(noVNumCheckBox, gridBagConstraints);

        verseNumbersPane.setLayout(new java.awt.GridBagLayout());

        verseButtonGroup.add(vNumRadioButton);
        vNumRadioButton.setText(bundle.getString("CTL_VNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        verseNumbersPane.add(vNumRadioButton, gridBagConstraints);

        verseButtonGroup.add(cvNumRadioButton);
        cvNumRadioButton.setText(bundle.getString("CTL_CVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        verseNumbersPane.add(cvNumRadioButton, gridBagConstraints);

        verseButtonGroup.add(bcvNumRadioButton);
        bcvNumRadioButton.setText(bundle.getString("CTL_BCVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        verseNumbersPane.add(bcvNumRadioButton, gridBagConstraints);

        tinyVNumCheckBox.setText(bundle.getString("CTL_TinyVNum.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        verseNumbersPane.add(tinyVNumCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 24, 0, 0);
        add(verseNumbersPane, gridBagConstraints);

        vLineCheckBox.setText(bundle.getString("CTL_VLine.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(vLineCheckBox, gridBagConstraints);

        headingsCheckBox.setText(bundle.getString("CTL_Headings.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(headingsCheckBox, gridBagConstraints);

        notesCheckBox.setText(bundle.getString("CTL_Notes.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(notesCheckBox, gridBagConstraints);

        strongsCheckBox.setText(bundle.getString("CTL_Strongs.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(strongsCheckBox, gridBagConstraints);

        morphCheckBox.setText(bundle.getString("CTL_Morph.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(morphCheckBox, gridBagConstraints);

        tooltipPopupCheckBox.setText(bundle.getString("CTL_TooltipPopup.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(tooltipPopupCheckBox, gridBagConstraints);

        xRefCheckBox.setText(bundle.getString("CTL_XRef.Text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(xRefCheckBox, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bcvNumRadioButton;
    private javax.swing.JRadioButton cvNumRadioButton;
    private javax.swing.JCheckBox headingsCheckBox;
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

    
    protected void initCustom() {
        noVNumCheckBox.addItemListener((ItemEvent evt) -> {
            boolean sel = noVNumCheckBox.isSelected();
            for (int i = 0; i < verseNumbersPane.getComponentCount(); i++) {
                verseNumbersPane.getComponent(i).setEnabled(!sel);
            }
        });
    }
    
    /** Show as Dialog 
     * @param parentComponent {@code Component}
     * @return JOptionPane options
     */
    public int showDialog(Component parentComponent) {
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        pane.add(this,BorderLayout.CENTER);
        int choice = JOptionPane.showConfirmDialog(parentComponent,pane,bundle.getString("CTL_Title.Text"),JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        return choice;
    }
    
    public void setViewerHints(ViewerHints<ViewerHints.Key,Object> viewerHints) {
        this.viewerHints = viewerHints;
        if (viewerHints == null) {
            return;
        }
        
        Object val;
        
        val = viewerHints.get(ViewerHints.NO_VERSE_NUMBERS);
        noVNumCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.VERSE_NUMBERS);
        boolean vNum = ((Boolean)val).booleanValue();
        val = viewerHints.get(ViewerHints.CHAPTER_VERSE_NUMBERS);
        boolean cvNum = ((Boolean)val).booleanValue();
        
        if (vNum) {
            vNumRadioButton.setSelected(true);
        } else {
            if (cvNum) {
                cvNumRadioButton.setSelected(true);
            } else {
                bcvNumRadioButton.setSelected(true);
            }
        }
        
        val = viewerHints.get(ViewerHints.TINY_VERSE_NUMBERS);
        tinyVNumCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.START_VERSE_ON_NEWLINE);
        vLineCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.HEADINGS);
        headingsCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.NOTES);
        notesCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.STRONGS_NUMBERS);
        strongsCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.MORPH);
        morphCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.TOOLTIP_POPUP);
        tooltipPopupCheckBox.setSelected(((Boolean)val).booleanValue());
        val = viewerHints.get(ViewerHints.XREF);
        xRefCheckBox.setSelected(((Boolean)val).booleanValue());
    }
    
    public void updateViewerHintsValue() {
        viewerHints.put(ViewerHints.NO_VERSE_NUMBERS, noVNumCheckBox.isSelected());
        viewerHints.put(ViewerHints.VERSE_NUMBERS, vNumRadioButton.isSelected());
        viewerHints.put(ViewerHints.CHAPTER_VERSE_NUMBERS, cvNumRadioButton.isSelected());
        viewerHints.put(ViewerHints.BOOK_CHAPTER_VERSE_NUMBERS, bcvNumRadioButton.isSelected());
        viewerHints.put(ViewerHints.TINY_VERSE_NUMBERS, tinyVNumCheckBox.isSelected());
        viewerHints.put(ViewerHints.START_VERSE_ON_NEWLINE, vLineCheckBox.isSelected());
        viewerHints.put(ViewerHints.HEADINGS, headingsCheckBox.isSelected());
        viewerHints.put(ViewerHints.NOTES, notesCheckBox.isSelected());
        viewerHints.put(ViewerHints.STRONGS_NUMBERS, strongsCheckBox.isSelected());
        viewerHints.put(ViewerHints.MORPH, morphCheckBox.isSelected());
        viewerHints.put(ViewerHints.TOOLTIP_POPUP, tooltipPopupCheckBox.isSelected());
        viewerHints.put(ViewerHints.XREF, xRefCheckBox.isSelected());
    }
}
