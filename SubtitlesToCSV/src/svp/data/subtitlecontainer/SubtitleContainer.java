package svp.data.subtitlecontainer;

import java.util.ArrayList;

public abstract class SubtitleContainer {
	int ccId; //ID of Subtitle, unique for each file
	protected ArrayList<SubtitleLiteral> translations;
	protected String startTimestamp;
	protected String endTimestamp;
	protected String text = ""; //DAS HIER MUSS EIN ARRAY WERDEN! Jede Sprache eins, es gibt kein Sprach literal dazu
	protected String outputFileName;
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
	public ArrayList<String> getLiteralTexts() {
		// Method is used to create the Data for the TableModel
		ArrayList<String> literalTexts = new ArrayList<String>();
		for(SubtitleLiteral sl: translations) {
			literalTexts.add(sl.getText());
		}
		return literalTexts;
	}
	
	public String getLiteralOnColumn(int column) {
		return translations.get(column).getText();
	}
	
	public String setLiteralOnColumn(String value, int column) {
		SubtitleLiteral sc = translations.get(column);
		String before = sc.toString();
		sc.setText(value);
		System.out.println("TRACE Changed SubtitleLiteral from ||"+before+" to "+sc.toString());
		return translations.get(column).getText();
	}
}
