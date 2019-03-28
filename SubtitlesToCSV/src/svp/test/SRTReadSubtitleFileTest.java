package svp.test;

import svp.data.filereader.AudacityFileReader;
import svp.data.filereader.SRTFileReader;
import svp.data.main.ConfigurationTable;
import svp.util.CSVGenerator;
import svp.util.MP3Splitter;

public class SRTReadSubtitleFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movieName = "BossAndMoe_Episode2";
		String subtitleFilePath = "C:\\Users\\MCSens\\Documents\\Subtitles\\SubtitleFiles\\subtitles_BossAndMe_Episode2.txt";
		String audioFilePath = "C:\\Users\\MCSens\\Documents\\Subtitles\\Audio\\to_split_ep2.mp3";
		String[] languages = new String[]{"Hanzi","Pinyin","English"};
		SRTFileReader afr = new SRTFileReader(movieName, 
				subtitleFilePath, 
				audioFilePath, 
				languages);
		afr.readFile();
		//afr.mergeCommas();
		MP3Splitter.splitMP3File();
		String outputPath = "C:\\Users\\MCSens\\Subtitles\\SubtitleFiles\\";
		ConfigurationTable config = ConfigurationTable.getConfigurationTable();
		config.setPathToOutputFolder(outputPath);
		CSVGenerator.createCSV();
		
		/*
		SRTFileReader sst = new SRTFileReader("BossAndMoe_Episode2", "resources/subtitles_BossAndMe_Episode2.txt");
		sst.readFile();
		sst.mergeCommas();
		System.out.println(sst);
		*/
	}

}
