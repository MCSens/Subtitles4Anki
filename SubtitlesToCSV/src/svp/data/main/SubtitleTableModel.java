package svp.data.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import svp.data.subtitlecontainer.SubtitleContainer;

public class SubtitleTableModel extends AbstractTableModel {
	private static SubtitleTableModel instance = new SubtitleTableModel();
	private String[] columnNames;
	private Object[][] data;
	/*
	private String[] columnNames = { "ID", "Hanzi", "English",
	        "# of Years", "Vegetarian" };
	
    private Object[][] data = {
            { "Mary", "Campione", "Snowboarding", new Integer(5),
                new Boolean(false) },
            { "Alison", "Huml", "Rowing", new Integer(3), new Boolean(true) },
            { "Kathy", "Walrath", "Knitting", new Integer(2),
                new Boolean(false) },
            { "Sharon", "Zakhour", "Speed reading", new Integer(20),
                new Boolean(true) },
            { "Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false) } };
    */
	public boolean isCellEditable(int row, int col) { 
	    return true; 
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
		fireTableStructureChanged();
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
		fireTableStructureChanged();
	}

	private SubtitleTableModel() {
		//Do nothing, enforce usages of getInstance Method
		//subtitles = SubtitleDataholder.getSubtitleData
	}
	
	public static SubtitleTableModel getSubtitleTableModel() {
		return instance;
	}
	
    public int getColumnCount() {
        return columnNames.length;
      }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
    	SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
    	int id = (int) this.getValueAt(row, col);
    	
        data[row][col] = value;
    }
    
}