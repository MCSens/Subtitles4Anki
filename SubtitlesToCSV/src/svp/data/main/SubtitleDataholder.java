package svp.data.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import svp.data.subtitlecontainer.SubtitleContainer;

public class SubtitleDataholder extends AbstractTableModel{
	/*
	 * Subtitle Container 1 -> SubtitleLiteral1 [Literal1, Literal2, Literal3]
	 * SubtitleContainer2 -> SubtitleLiteral2 ..........
	 * If this would be a table, the Rows are the SubtitleContainers
	 * The Columns are the ID and Literals of the SubtitleLiterals
	 */
	private static SubtitleDataholder instance = new SubtitleDataholder();
	private List<SubtitleContainer> subtitles = new ArrayList<SubtitleContainer>();
	private String[] languages;
	
	private SubtitleDataholder() {
		//Do nothing, enforce usages of getInstance Method
	}
	
	public static SubtitleDataholder getSubtitleDataholder() {
		return instance;
	}
	
	public List<SubtitleContainer> getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(List<SubtitleContainer> subtitles) {
		this.subtitles = subtitles;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
		//this.columnNames = languages;
	}

	public void addSubtitleContainer(SubtitleContainer sc) {
		System.out.println("INFO added SubtitleContainer "+sc+" to SubtitleDataholder");
		this.subtitles.add(sc);
	}
	
	public ArrayList<String[]> getSplitTimestamps(){
		ArrayList<String[]> timestamps = new ArrayList<>();
		for(SubtitleContainer sc: subtitles) {
			String start = sc.getStartTimestamp();
			String end = sc.getEndTimestamp();
			String[] timestampArray = new String[] {start, end};
			timestamps.add(timestampArray);
			System.out.println("TRACE - FileReader.getSplitTimestamps - Start:"+start+", End: "+end);
		}
		return timestamps;
	}
	
	public SubtitleTableModel createTableModel() {
		SubtitleTableModel stm = SubtitleTableModel.getSubtitleTableModel();
		if(languages!=null && subtitles!=null) {
			  ///////////////////////////
			 //		 Table Header 	  //
			///////////////////////////
			ArrayList<String> tableHeader = new ArrayList<String>();
			tableHeader.add("ID");
			for(int i = 0; i<languages.length;i++) {
				tableHeader.add(languages[i]);
			}
			Object[] objectArray = tableHeader.toArray();
			//Columns are not correct
			if(objectArray==null) {
				stm.setColumnNames(null);
				stm.setData(null);
				return null;
			}
			else {
				String[] columnNames = Arrays.asList(objectArray).toArray(new String[objectArray.length]);
				stm.setColumnNames(columnNames);
				int columnCount = objectArray.length;
				  ///////////////////////////
				 //		 Table Data 	  //
				///////////////////////////
				ArrayList<Object[]> tableDataList = new ArrayList<Object[]>();
				int rowCount = subtitles.size();
				Object[][] tableData = new Object[rowCount][columnCount];
				for(int i = 0; i<subtitles.size();i++) {
					SubtitleContainer sc = subtitles.get(i);
					ArrayList<String> tableRow = new ArrayList<String>();
					tableRow.add(""+i);
					tableRow.addAll(sc.getLiteralTexts());
					//ArrayList<String> subtitleLiteralTexts = sc.getLiteralTexts();
					System.out.println(tableRow);
					Object[] tableRowObjectArray = tableRow.toArray();
					if(i==4) {
						int huhu=1;
						huhu+=1;
					}
					for(int j = 0; j<tableRowObjectArray.length;j++) {
						System.out.println("TRACE Table Data on Coordinates "+i+","+j+" has been set to "+tableRowObjectArray[j]);
						tableData[i][j] = tableRowObjectArray[j];
					}
					tableDataList.add(tableRowObjectArray);
				}	
				Object[] rowData = tableDataList.toArray();
				//int rowCount = rowData.length;
				
				
				//Object[][] tableDataObjectArray= (Object[][]) tableDataList.toArray();
				stm.setData(tableData);
			}
		}
		return stm;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		//The Table consists of ID + the languages
		return languages.length+1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return subtitles.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		SubtitleContainer sc = subtitles.get(rowIndex);
		String result;
		if(columnIndex==0) {
			result = ""+rowIndex;
		}
		else {
			result = sc.getLiteralOnColumn(columnIndex-1);
		}
		return result;
	}
	
    @Override
    public void setValueAt(Object value, int row, int col) {
    	SubtitleContainer sc = subtitles.get(row);
    	sc.setLiteralOnColumn((String) value, (col-1));
    	subtitles.set(row, sc);
    }
    
    @Override
	public boolean isCellEditable(int row, int col) { 
		if(col==0)return false;
		else return true; 
	}
	
    @Override
	public String getColumnName(int column) {
    	if(column==0)return "ID";
    	else return languages[column-1];
	}
}