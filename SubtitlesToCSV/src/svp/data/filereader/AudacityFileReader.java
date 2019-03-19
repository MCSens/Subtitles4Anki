package svp.data.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.subtitlecontainer.AudacitySubtitleContainer;
import svp.data.subtitlecontainer.SRTSubtitleContainer;
import svp.data.subtitlecontainer.SubtitleContainer;
import svp.test.NPCR2Text1Dialog1;

/**
 * This file is responsible for reading the File for Subtitle Type Audacity has been selected.
 * 
 * <p>
 * Each line of the file will be converted into Subtitle Containers.
 * The created Subtitle Containers are stored in SubtitleDataholder.
 * </p>
 * @see SubtitleDataholder
 * 
 */
public class AudacityFileReader extends FileReader{
	private static Logger log = (Logger) LoggerFactory.getLogger(AudacityFileReader.class);

	public AudacityFileReader(String movieName, String pathToSubtitleFile, String pathToAudioFile){	
		// TODO Auto-generated method stub
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = movieName;   //Alles in der Config Table, nicht mehr lokal hier drin!
		this.subtitles = new ArrayList();
		this.pathToSubtitleFile = pathToSubtitleFile;
		this.pathToAudioFile = pathToAudioFile;
	}
	
	public AudacityFileReader(String movieName, String pathToSubtitleFile, String pathToAudioFile, String[] languages){	
		// TODO Auto-generated method stub
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = movieName;
		configurationTable.setMovieTitle(movieName);
		
		this.pathToSubtitleFile = pathToSubtitleFile;
		configurationTable.setPathToSubtitleFile(pathToSubtitleFile);
		
		this.pathToAudioFile = pathToAudioFile;
		configurationTable.setPathToAudioFile(pathToAudioFile);
		
		this.languages = languages;
		subtitleDataholder.setLanguages(languages);
		
		this.subtitles = new ArrayList();
	}
	
	public AudacityFileReader() {
		/**
		 * Constructor that is being used in regular Program Flow via GUI
		 * All Settings will be written into the Singletons 
		 * 
		 * @see #ConfigurationTable
		 * @see #SubtitleDataholder
		 */
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = configurationTable.getMovieTitle();
		this.pathToSubtitleFile = configurationTable.getPathToSubtitleFile();
		this.pathToAudioFile = configurationTable.getPathToAudioFile();
		this.languages = subtitleDataholder.getLanguages();
		this.subtitles = new ArrayList();
	}
	
	/**
	 * This Methods reads the Subtitle File.
	 * 
	 * Creats AudacitySubtitleContainer and adds them to Singleton Subtitle Dataholder
	 * 
	 */
	public void readFile() {
		Scanner sc;
		try {
			log.info("Start Reading of File "+this.pathToSubtitleFile);
			
			int id = 1;
			sc = new Scanner(new File(this.pathToSubtitleFile), "utf-8");
			
			while(sc.hasNextLine()) {
				String fileLine = sc.nextLine();

				log.debug("Read Line: "+fileLine);
				fileLine+="\t"+(id++);
				String[] splitted = fileLine.split("\\t");
				for(int i = 0; i < splitted.length; i++) {
					log.trace("Splitted ["+i+"]: "+splitted[i]);
				}
 				AudacitySubtitleContainer asc = new AudacitySubtitleContainer(this.movieName, splitted, this.languages);
 				if(asc.getValid()) {
 					this.subtitleDataholder.addSubtitleContainer(asc);
 				}
 				else {
 					log.warn("Issue found with "+asc+" and thus is being skipped");
 				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			log.info("Reading of File Completed");
		}
	}

	public String toString() {
		String result = "";
  		for(SubtitleContainer sr: subtitles) {
  			result+=sr+"\n";
		}
		return result;
	}
	
	public List<SubtitleContainer> getSubtitles(){
		return subtitles;
	}
}
