package svp.test;

import svp.files.AudacityFileReader;
import svp.files.SRTFileReader;
import svp.mp3splitter.MP3Splitter;

public class AudacityGenerateSplitTimestampsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		AudacityFileReader afr = new AudacityFileReader("BossAndMoe_Episode2", "resources/AudacityCSVSubtitleFile.txt", "C:\\Users\\MCSens\\Audio\\to_split_ep2.mp3");
		afr.readFile();
		afr.mergeCommas();
		MP3Splitter.splitMP3File(afr);
		//System.out.println(afr);
	}
}
