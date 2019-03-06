package svp.test;

import svp.data.filereader.AudacityFileReader;
import svp.data.filereader.SRTFileReader;
import svp.util.CSVGenerator;
import svp.util.MP3Splitter;

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
