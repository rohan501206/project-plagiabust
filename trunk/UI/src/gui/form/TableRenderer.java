/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Kasun
 */
public class TableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int col) {
        JComponent c = (JComponent) super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, col);
        c.setToolTipText(value.toString());
        return c;
    }
}
