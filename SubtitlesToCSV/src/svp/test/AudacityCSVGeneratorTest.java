package svp.test;

import svp.data.files.AudacityFileReader;
import svp.data.files.SRTFileReader;
import svp.util.anki.CSVGenerator;
import svp.util.mp3splitter.MP3Splitter;

public class AudacityCSVGeneratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		AudacityFileReader afr = new AudacityFileReader("BossAndMoe_Episode2", 
				"resources/AudacityCSVSubtitleFile.txt", 
				"C:\\Users\\MCSens\\Audio\\to_split_ep2.mp3", 
				new String[]{"Chinese","English","Deutsch"});
		afr.readFile();
		afr.mergeCommas();
		CSVGenerator.createCSV(afr, "resources");
		//System.out.println(afr);
	}
}
