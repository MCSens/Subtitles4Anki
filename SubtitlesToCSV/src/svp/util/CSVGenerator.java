package svp.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.FileReader;
import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.subtitlecontainer.SubtitleContainer;
import svp.data.subtitlecontainer.SubtitleLiteral;

public class CSVGenerator {
	private static Logger log = (Logger) LoggerFactory.getLogger(CSVGenerator.class);

	public static void createCSV() {
	    try {
	    	log.info("Begin Generation of CSV File");
	    	ConfigurationTable configurationTable = ConfigurationTable.getConfigurationTable();
	    	SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
	    	
			String pathToAudioFile = configurationTable.getPathToAudioFile();
			ArrayList<String[]> splitTimestamps = subtitleDataholder.getSplitTimestamps();
			ArrayList<SubtitleContainer> subtitles = (ArrayList<SubtitleContainer>) subtitleDataholder.getSubtitles();
			String[] languages = subtitleDataholder.getLanguages();
			//String outputPath = configurationTable.getPathToOutputFolder();
			String movieName = configurationTable.getMovieTitle();
			
			String outputPath = configurationTable.getPathToOutputFolder();
			//Open Writer to write into File
			String csvFileName = outputPath+"\\"+movieName+".csv";
			log.trace("Full CSV Name: "+csvFileName);
	    	PrintWriter writer = new PrintWriter(new File(csvFileName)); 
	    	
			  ////////////////////////////////
			 //			Write Content	   //
			////////////////////////////////
	    	for(SubtitleContainer sc: subtitles) {
	    		String row = "";
	    		ArrayList<SubtitleLiteral> literals = sc.getTranslations();
	    		for(SubtitleLiteral sl: literals) {
	    			row += sl.getText() +";";
	    		}
	    		row += "[sound:"+sc.getOutputFileName()+".mp3]";
	    		log.debug("Row to add to CSV File: "+row);
	    		row +="\n"; //Add line break after logging to prevent empty row in logfile
	    		writer.write(row);
	    	}
	    	
	    	//Close Writer and Commit to file;
	        writer.close();
	        log.info("Finished Creation of CSV File");
	        
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	//To be removed
	public static void createCSV(FileReader fr, String outputPath) {
	    try {
	    	ConfigurationTable configurationTable = ConfigurationTable.getConfigurationTable();
	    	SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
			String pathToAudioFile = configurationTable.getPathToAudioFile();
			ArrayList<String[]> splitTimestamps = fr.getSplitTimestamps();
			ArrayList<SubtitleContainer> subtitles = (ArrayList<SubtitleContainer>) fr.getSubtitles();
			String[] languages = fr.getLanguages();
			
			//Open Writer to write into File
	    	PrintWriter writer = new PrintWriter(new File(outputPath+"\\"+fr.getMovieName()+".csv")); 
	    	
			  ////////////////////////////////
			 //			Write Content	   //
			////////////////////////////////
	    	for(SubtitleContainer sc: subtitles) {
	    		String row = "";
	    		ArrayList<SubtitleLiteral> literals = sc.getTranslations();
	    		for(SubtitleLiteral sl: literals) {
	    			row += sl.getText() +";";
	    		}
	    		row += "[sound:"+sc.getOutputFileName()+".mp3]\n";
	    		log.debug(" Row to add to CSV File: "+row);
	    		
	    		writer.write(row);
	    	}
	    	
	    	//Close Writer and Commit to file;
	        writer.close();
	        System.out.println("done!");
	        
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}
