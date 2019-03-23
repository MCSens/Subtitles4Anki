package svp.util;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.FileReader;
import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.subtitlecontainer.SubtitleContainer;

public class MP3Splitter {
	private static Logger log = (Logger) LoggerFactory.getLogger(MP3Splitter.class);
	
	public static void splitMP3File() {
		
		ConfigurationTable configurationTable = ConfigurationTable.getConfigurationTable();
		String pathToAudioFile = configurationTable.getPathToAudioFile();
		log.info("Start splitting of MP3 File "+pathToAudioFile);
		
		SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		
		ArrayList<SubtitleContainer> subtitles = (ArrayList<SubtitleContainer>) subtitleDataholder.getSubtitles();
		Runtime rt = Runtime.getRuntime();
		try {
			log.trace("Path to Audio File: - "+pathToAudioFile);
			String movieTitle = configurationTable.getMovieTitle();
			for(SubtitleContainer sc: subtitles) {
				String start = sc.getStartTimestamp();
				String end = sc.getEndTimestamp();
				String outputFileName = sc.getOutputFileName();
				String splitCommand = "mp3splt "+pathToAudioFile+" "+start+" "+end+" -o S2C_"+movieTitle+"\\"+outputFileName;
				log.debug(splitCommand);
				rt.exec(splitCommand);
			}
			log.info("Finished splitting of MP3 File into "+subtitles.size()+" Files");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//TODO remove
	public static void splitMP3File(FileReader fr) {
		String pathToAudioFile = fr.getPathToAudioFile();
		ArrayList<SubtitleContainer> subtitles = (ArrayList<SubtitleContainer>) fr.getSubtitles();
		Runtime rt = Runtime.getRuntime();
		try {
			System.out.println(pathToAudioFile);
			String movieName = fr.getMovieName();
			for(SubtitleContainer sc: subtitles) {
				String start = sc.getStartTimestamp();
				String end = sc.getEndTimestamp();
				String outputFileName = sc.getOutputFileName();
				rt.exec("mp3splt "+pathToAudioFile+" "+start+" "+end+" -o S2C_"+movieName+"\\"+outputFileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
