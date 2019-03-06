package svp.test;

import svp.data.filereader.AudacityFileReader;
import svp.data.filereader.SRTFileReader;
import svp.util.CSVGenerator;
import svp.util.MP3Splitter;

public class NPCR2Text1Dialog1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		AudacityFileReader afr = new AudacityFileReader("NPCR2-Text1-Dialog2", 
				"C:\\Users\\MCSens\\Subtitles\\SubtitleFiles\\NPC2-Text1-Dialog2-correction.txt", 
				"C:\\Users\\MCSens\\Subtitles\\Audio\\02_Text1_Dialog2.mp3", 
				new String[]{"Hanzi","Pinyin","English"});
		afr.readFile();
		//afr.mergeCommas();
		MP3Splitter.splitMP3File();
		CSVGenerator.createCSV(afr, "C:\\Users\\MCSens\\Subtitles\\SubtitleFiles\\");
		//System.out.println(afr);
	}
}
