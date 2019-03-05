package svp.subtitles;

import java.util.ArrayList;

public abstract class SubtitleContainer {
	int ccId; //ID of Subtitle, unique for each file
	protected String startTimestamp;
	protected String endTimestamp;
	protected String text = ""; //DAS HIER MUSS EIN ARRAY WERDEN! Jede Sprache eins, es gibt kein Sprach literal dazu
	protected String outputFileName;
	protected ArrayList<SubtitleLiteral> translations;
	protected boolean valid;
	
	public abstract String convertStartTimestamp(String timestamp);
	public abstract String convertEndTimestamp(String timestamp);
	
	/**
	 * Returns the Output Filename. The Name of the created MP3 File
	 */
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}


	//public abstract void validityCheck();
	
	/*
	public String getSplitCommand() {
		return startTimestamp + " "+endTimestamp;
	}
	*/
	
	public ArrayList<SubtitleLiteral> getTranslations() {
		return translations;
	}
	public void setTranslations(ArrayList<SubtitleLiteral> translations) {
		this.translations = translations;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String toString() {
		String result =  "SubtitleContainer [ccId=" + ccId;
		if(translations!=null) {
			for(SubtitleLiteral s: translations) {
				result += ", "+s;
			}
		}
		result += ", outputFileName="+outputFileName+ ", startTimestamp="+ startTimestamp + ", endTimestamp=" +endTimestamp; 
		result += "]";
		return result;
	}
	
	public int getCcId() {
		return ccId;
	}

	public void setCcId(int ccId) {
		this.ccId = ccId;
	}

	public String getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(String startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public String getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(String endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public boolean getValid() {
		return valid;
	}
	
}
