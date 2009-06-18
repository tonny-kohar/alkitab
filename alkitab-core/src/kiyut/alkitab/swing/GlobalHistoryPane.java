/* This work has been placed into the public domain. */

package kiyut.alkitab.swing;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import kiyut.alkitab.api.BookViewManager;
import kiyut.alkitab.api.GlobalHistory;
import kiyut.alkitab.api.SwordURI;

/**
 * Panel which display user's history
 * 
 */
public class GlobalHistoryPane extends javax.swing.JPanel {
    protected ListModel listModel;

    /** Creates new form GlobalHistoryPane */
    public GlobalHistoryPane() {
        initComponents();
        initCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyList = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(historyList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList historyList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    protected void initCustom() {
        listModel = new HistoryListModel();
        historyList.setModel(listModel);
        historyList.setCellRenderer(new HistoryCellRenderer());

        historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() < 2) { return; }
                
                int index = historyList.getSelectedIndex();
                if (index < 0) { return; }

                String str = GlobalHistory.getInstance().getHistory(index).getHistory();
                SwordURI uri = SwordURI.createURI(SwordURI.BIBLE_SCHEME, "", str);
                BookViewManager.getInstance().openURI(uri, false);
            }
        });

    }

    private class HistoryListModel extends AbstractListModel {
        public HistoryListModel() {
           ListDataListener listDataListener = new ListDataListener() {
                public void contentsChanged(ListDataEvent evt) {
                    fireContentsChanged(this, evt.getIndex0(), evt.getIndex1());
                }

                public void intervalAdded(ListDataEvent evt) {
                    fireIntervalAdded(this, evt.getIndex0(), evt.getIndex1());
                }

                public void intervalRemoved(ListDataEvent evt) {
                    fireIntervalRemoved(this, evt.getIndex0(), evt.getIndex1());
                }
            };
            GlobalHistory.getInstance().addListDataListener(listDataListener);
        }

        public Object getElementAt(int index) {
            return GlobalHistory.getInstance().getHistory(index);
        }

        public int getSize() {
            return  GlobalHistory.getInstance().size();
        }
    }

    private class HistoryCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            GlobalHistory.Entry entry = GlobalHistory.getInstance().getHistory(index);
            if (entry != null ) {
                String display = entry.getHistory();
                value = display;
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }

    }

}
