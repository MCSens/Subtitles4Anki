package svp.util.mp3splitter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import svp.data.files.FileReader;
import svp.data.subtitles.SubtitleContainer;

public class MP3Splitter {

	public static void splitMP3File(FileReader fr) {
		String pathToAudioFile = fr.getPathToAudioFile();
		ArrayList<String[]> splitTimestamps = fr.getSplitTimestamps();
		ArrayList<SubtitleContainer> subtitles = (ArrayList<SubtitleContainer>) fr.getSubtitles();
		Runtime rt = Runtime.getRuntime();
		try {
			//If you want to use it yourself: mp3splt C:\Users\MCSens\Audio\to_split_ep2.mp3 10.00 10.05
			//Process pr = rt.exec("mp3splt \"C:\\Users\\MCSens\\Audio\\to_split_ep2.mp3\" 10.00 10.05");
			
			/*
			String pathToOutputFolder = "C:\\Users\\MCSens\\Audio\\S2C_"+fr.getMovieName();
			File f = new File(pathToOutputFolder);
			f.mkdir();
			*/
			System.out.println(pathToAudioFile);
			String movieName = fr.getMovieName();
			for(SubtitleContainer sc: subtitles) {
				String start = sc.getStartTimestamp();
				String end = sc.getEndTimestamp();
				String outputFileName = sc.getOutputFileName();
				Process pr = rt.exec("mp3splt "+pathToAudioFile+" "+start+" "+end+" -o S2C_"+movieName+"\\"+outputFileName);
			}
			//pr = rt.exec("mp3splt \"C:\\Users\\MCSens\\Audio\\to_split_ep2.mp3\" 10.00 10.05");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
