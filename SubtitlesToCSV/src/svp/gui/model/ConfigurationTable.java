package svp.gui.model;

import java.util.ArrayList;

public class ConfigurationTable {
	private static ConfigurationTable instance = new ConfigurationTable();
	private SubtitleType subtitleFormat;
	private boolean isAudioEnabled;
	private boolean isMergeCommasEnabled;
	private String movieName;
	private String pathToSubtitleFile;
	private String pathToAudioFile;
	private String pathToOutputFolder;
	
	public String getPathToOutputFolder() {
		return pathToOutputFolder;
	}


	public void setPathToOutputFolder(String pathToOutputFolder) {
		System.out.println("TRACE Output Path has been set to "+pathToOutputFolder);
		this.pathToOutputFolder = pathToOutputFolder;
	}

	private ArrayList<String> listOfRemovableCharacters;
	
	private ConfigurationTable() {
		
	}
	

	public SubtitleType getSubtitleFormat() {
		return subtitleFormat;
	}

	public void setSubtitleFormat(SubtitleType subtitleFormat) {
		System.out.println("TRACE Subtitle Format has been set to "+subtitleFormat);
		this.subtitleFormat = subtitleFormat;
	}

	public boolean isAudioEnabled() {
		return isAudioEnabled;
	}

	public void setAudioEnabled(boolean isAudioEnabled) {
		System.out.println("TRACE Audio Enabled has been set to "+isAudioEnabled);
		this.isAudioEnabled = isAudioEnabled;
	}

	public boolean isMergeCommasEnabled() {
		return isMergeCommasEnabled;
	}

	public void setMergeCommasEnabled(boolean isMergeCommasEnabled) {
		System.out.println("TRACE Merge Commas Enabled has been set to "+isMergeCommasEnabled);
		this.isMergeCommasEnabled = isMergeCommasEnabled;
	}

	public ArrayList<String> getListOfRemovableCharacters() {
		return listOfRemovableCharacters;
	}

	public void setListOfRemovableCharacters(ArrayList<String> listOfRemovableCharacters) {
		this.listOfRemovableCharacters = listOfRemovableCharacters;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		System.out.println("TRACE Movie Name has been set to "+movieName);
		this.movieName = movieName;
	}
	
	public String getPathToSubtitleFile() {
		return pathToSubtitleFile;
	}
	
	public void setPathToSubtitleFile(String pathToSubtitleFile) {
		System.out.println("TRACE Subtitle Path has been set to "+pathToSubtitleFile);
		this.pathToSubtitleFile = pathToSubtitleFile;
	}
	
	public String getPathToAudioFile() {
		return pathToAudioFile;
	}
	
	public void setPathToAudioFile(String pathToAudioFile) {
		System.out.println("TRACE Audio Path has been set to "+pathToAudioFile);
		this.pathToAudioFile = pathToAudioFile;
	}
	
	public static ConfigurationTable getConfigurationTable() {
		return instance;
	}
}
