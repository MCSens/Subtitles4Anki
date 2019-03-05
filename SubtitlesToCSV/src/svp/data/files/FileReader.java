package svp.files;

import java.util.ArrayList;
import java.util.List;

import svp.gui.model.ConfigurationTable;
import svp.gui.model.SubtitleDataholder;
import svp.subtitles.SRTSubtitleContainer;
import svp.subtitles.SubtitleContainer;

public abstract class FileReader {
	protected ConfigurationTable configurationTable;
	protected SubtitleDataholder subtitleDataholder;
	protected List<SubtitleContainer> subtitles;
	protected String[] languages;
	protected String pathToSubtitleFile;
	protected String pathToAudioFile;
	protected String movieName;
	
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
	}


	public String getPathToSubtitleFile() {
		return pathToSubtitleFile;
	}

	public void setPathToSubtitleFile(String pathToSubtitleFile) {
		this.pathToSubtitleFile = pathToSubtitleFile;
	}

	public String getPathToAudioFile() {
		return pathToAudioFile;
	}

	public void setPathToAudioFile(String pathToAudioFile) {
		this.pathToAudioFile = pathToAudioFile;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	
	public abstract void readFile();
	
	public void mergeCommas() {
		List<SubtitleContainer> tempSubtitles = this.subtitles;
		for(int i = 0; i < subtitles.size()-1; i++) {
			SubtitleContainer sr1 = tempSubtitles.get(i);
			String sr1Text = sr1.getText();
			char lastDigit = '-';
			try {
				 lastDigit = sr1Text.charAt(sr1Text.length()-1);
			}
			catch(Exception e) {
				
			}
			if(lastDigit==',') {
				SRTSubtitleContainer newSR = (SRTSubtitleContainer) this.mergeRows(sr1, tempSubtitles.get(i+1));
				tempSubtitles.set(i, newSR);
				tempSubtitles.remove(i+1);
				i--;
			}
		}
		this.subtitles = tempSubtitles;
	}
	
	public SubtitleContainer mergeRows(SubtitleContainer sr1, SubtitleContainer sr2) {
		//Merge to subtitles if the end on a comma
		SRTSubtitleContainer newSr = new SRTSubtitleContainer(sr1.getCcId(), sr1.getStartTimestamp(), sr2.getEndTimestamp(), sr1.getText()+" "+sr2.getText());
		return newSr;
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
}
