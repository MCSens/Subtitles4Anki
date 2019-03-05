package svp.test;

import svp.data.files.AudacityFileReader;
import svp.data.files.SRTFileReader;
import svp.util.anki.CSVGenerator;
import svp.util.mp3splitter.MP3Splitter;

public class NPCR2Text1Dialog1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		AudacityFileReader afr = new AudacityFileReader("NPCR2-Text2-Dialog2", 
				"C:\\Users\\MCSens\\SubtitleFiles\\NPCR2-Text2-Dialog2.txt", 
				"C:\\Users\\MCSens\\Audio\\16_Text2_Dialog2.mp3", 
				new String[]{"Hanzi","Pinyin","English"});
		afr.readFile();
		//afr.mergeCommas();
		MP3Splitter.splitMP3File(afr);
		CSVGenerator.createCSV(afr, "C:\\Users\\MCSens\\SubtitleFiles\\");
		//System.out.println(afr);
	}
}
