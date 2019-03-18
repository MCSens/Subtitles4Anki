package svp.test;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.AudacityFileReader;
import svp.data.main.ConfigurationTable;
import svp.util.CSVGenerator;
import svp.util.MP3Splitter;

public class NPCR2Text1Dialog1 {
	private static Logger log = (Logger) LoggerFactory.getLogger(NPCR2Text1Dialog1.class);

	public static void main(String[] args) {
		String movieName = "NPCR2-Text1-Dialog2";
		String subtitleFilePath = "C:\\Users\\MCSens\\Subtitles\\SubtitleFiles\\NPC2-Text1-Dialog2.txt";
		String audioFilePath = "C:\\Users\\MCSens\\Subtitles\\Audio\\02_Text1_Dialog2.mp3";
		String[] languages = new String[]{"Hanzi","Pinyin","English"};
		AudacityFileReader afr = new AudacityFileReader(movieName, 
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
	}
}
