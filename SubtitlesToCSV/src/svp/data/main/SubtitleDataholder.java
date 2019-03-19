package svp.data.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.AudacityFileReader;
import svp.data.subtitlecontainer.SubtitleContainer;

/**
 * Singleton that contains the converted Subtitles.
 * This will be accessed by all other classes.
 * It will be filled by the implementations of FileReader.
 * It extends Abstract Table Model and is used to fill the JTable to Check/Edit the data.
 * Changing the Data will call the method {@link #setValueAt(Object, int, int)}.
 * 
 * 	@see AudacityFileReader
 * 	@see SRTFileReader
 * 
 * @author MCSens
 *
 */
public class SubtitleDataholder extends AbstractTableModel{
	private static Logger log = (Logger) LoggerFactory.getLogger(SubtitleDataholder.class);
	
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
		log.debug("Added SubtitleContainer "+sc+" to SubtitleDataholder");
		this.subtitles.add(sc);
	}
	
	public ArrayList<String[]> getSplitTimestamps(){
		ArrayList<String[]> timestamps = new ArrayList<>();
		for(SubtitleContainer sc: subtitles) {
			String start = sc.getStartTimestamp();
			String end = sc.getEndTimestamp();
			String[] timestampArray = new String[] {start, end};
			timestamps.add(timestampArray);
			log.trace("FileReader.getSplitTimestamps - Start:"+start+", End: "+end);
		}
		return timestamps;
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