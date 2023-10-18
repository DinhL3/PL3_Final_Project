import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Table {
    private JTable table;
    private DefaultTableModel model;
    private String[] columnNames;

    public Table(String[] columnNames) {
        this.columnNames = columnNames;
        model = new DefaultTableModel();
        table = new JTable(model);
        for (String columnName : columnNames) {
            model.addColumn(columnName);
        }
    }

    public void addRow(Object[] data) {
        model.addRow(data);
    }

    public JTable getTable() {
        return table;
    }
}

