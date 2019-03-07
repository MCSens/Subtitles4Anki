package svp.data.main;

import java.util.ArrayList;

public class ConfigurationTable {
	private static ConfigurationTable instance = new ConfigurationTable();
	private SubtitleType subtitleFormat;
	private boolean isAudioEnabled;
	private boolean isMergeCommasEnabled;
	private String movieTitle;
	private String pathToSubtitleFile;
	private String pathToAudioFile;
	private String pathToOutputFolder;
	
	
	private ConfigurationTable() {
		//Do nothing, enforce usages of getInstance Method
	}
	
	public static ConfigurationTable getConfigurationTable() {
		return instance;
	}
	
	public String getPathToOutputFolder() {
		return pathToOutputFolder;
	}
	
	
	public void setPathToOutputFolder(String pathToOutputFolder) {
		System.out.println("TRACE Output Path has been set to "+pathToOutputFolder);
		this.pathToOutputFolder = pathToOutputFolder;
	}
	
	private ArrayList<String> listOfRemovableCharacters;
	

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
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public void setMovieTitle(String movieTitle) {
		System.out.println("TRACE Movie Title has been set to "+movieTitle);
		this.movieTitle = movieTitle;
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
	
}
