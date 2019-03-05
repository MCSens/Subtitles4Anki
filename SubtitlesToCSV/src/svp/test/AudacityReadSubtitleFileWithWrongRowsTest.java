package svp.test;

import svp.files.AudacityFileReader;
import svp.files.SRTFileReader;

public class AudacityReadSubtitleFileWithWrongRowsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		AudacityFileReader afr = new AudacityFileReader("BossAndMoe_Episode2", "resources/AudacityTestSubtitleWrongRows.txt", "Noaudio.mp3");
		afr.readFile();
		afr.mergeCommas();
		System.out.println(afr);
	}
}
