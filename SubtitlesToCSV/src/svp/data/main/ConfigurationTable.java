package svp.data.main;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.AudacityFileReader;

public class ConfigurationTable {
	private static Logger log = (Logger) LoggerFactory.getLogger(ConfigurationTable.class);
	
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
		log.trace("Output Path has been set to "+pathToOutputFolder);
		this.pathToOutputFolder = pathToOutputFolder;
	}
	
	private ArrayList<String> listOfRemovableCharacters;
	

	public SubtitleType getSubtitleFormat() {
		return subtitleFormat;
	}

	public void setSubtitleFormat(SubtitleType subtitleFormat) {
		log.trace("Subtitle Format has been set to "+subtitleFormat);
		this.subtitleFormat = subtitleFormat;
	}

	public boolean isAudioEnabled() {
		return isAudioEnabled;
	}

	public void setAudioEnabled(boolean isAudioEnabled) {
		log.trace("Audio Enabled has been set to "+isAudioEnabled);
		this.isAudioEnabled = isAudioEnabled;
	}

	public boolean isMergeCommasEnabled() {
		return isMergeCommasEnabled;
	}

	public void setMergeCommasEnabled(boolean isMergeCommasEnabled) {
		log.trace("Merge Commas Enabled has been set to "+isMergeCommasEnabled);
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
		log.trace("Movie Title has been set to "+movieTitle);
		this.movieTitle = movieTitle;
	}
	
	public String getPathToSubtitleFile() {
		return pathToSubtitleFile;
	}
	
	public void setPathToSubtitleFile(String pathToSubtitleFile) {
		log.trace("Subtitle Path has been set to "+pathToSubtitleFile);
		this.pathToSubtitleFile = pathToSubtitleFile;
	}
	
	public String getPathToAudioFile() {
		return pathToAudioFile;
	}
	
	public void setPathToAudioFile(String pathToAudioFile) {
		log.trace("Audio Path has been set to "+pathToAudioFile);
		this.pathToAudioFile = pathToAudioFile;
	}
	
}
