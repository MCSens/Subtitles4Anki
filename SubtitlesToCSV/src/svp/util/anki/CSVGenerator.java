package svp.util.anki;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import svp.data.files.FileReader;
import svp.data.subtitles.SubtitleContainer;
import svp.data.subtitles.SubtitleLiteral;

public class CSVGenerator {

	public static void createCSV(FileReader fr, String outputPath) {
	    try {
			String pathToAudioFile = fr.getPathToAudioFile();
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
	    		System.out.println("TRACE - Row to add to CSV File: "+row);
	    		
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
