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
import svp.data.subtitlecontainer.SRTSubtitleContainer;
import svp.data.subtitlecontainer.SubtitleContainer;

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
public class SRTFileReader extends FileReader{
	private static Logger log = (Logger) LoggerFactory.getLogger(SRTFileReader.class);
	
	public SRTFileReader(String movieName, String pathToSubtitleFile){	
		/*
		 * I should somehwat validate the file
		 * Are there enough blank spaces?
		 * 
		 */
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.movieName = movieName;
		this.subtitles = new ArrayList<SubtitleContainer>();
		this.pathToSubtitleFile = pathToSubtitleFile;
	}
	
	public SRTFileReader(String movieName, String pathToSubtitleFile, String pathToAudioFile, String[] languages){	
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
		
		this.subtitles = new ArrayList<SubtitleContainer>();
	}
	
	public void readFile() {
		Scanner sc;
		try {
			log.info("Start Reading of File "+this.pathToSubtitleFile);
			
			sc = new Scanner(new File(this.pathToSubtitleFile));
			while(sc.hasNextLine()) {
				String fileLine ="";
				String fileFormattedLine = "";
				do
				{
					fileLine = sc.nextLine();
					fileFormattedLine += fileLine+"|";
				
				}while(!fileLine.equals("") && sc.hasNextLine());
				log.trace(fileFormattedLine);
				
				String[] splitted = fileFormattedLine.split("\\|");
 				SRTSubtitleContainer ssc = new SRTSubtitleContainer(this.movieName, splitted, this.languages);
 				if(ssc.getValid()) {
 					this.subtitleDataholder.addSubtitleContainer(ssc);
 				}
 				else {
 					log.warn("Issue found with "+ssc+" and thus is being skipped");
 				}
 				
 				//subtitles.add(ssc);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			log.info("Finished Reading of File "+this.pathToSubtitleFile);
			log.trace("Added following SubtitleContainers: ");
			for(SubtitleContainer ssc: subtitles) {
				log.trace(ssc.toString());
			}
		}
	}
	
	public String toString() {
		String result = "";
  		for(SubtitleContainer sr: subtitles) {
  			//System.out.println(sr);
  			result+=sr+"\n";
		}
		return result;
	}
	
	public List<SubtitleContainer> getSubtitles(){
		return subtitles;
	}
}
