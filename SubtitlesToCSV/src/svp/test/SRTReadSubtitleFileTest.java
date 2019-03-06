package svp.test;

import svp.data.filereader.SRTFileReader;

public class SRTReadSubtitleFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SRTFileReader sst = new SRTFileReader("BossAndMoe_Episode2", "resources/subtitles_BossAndMe_Episode2.txt");
		sst.readFile();
		sst.mergeCommas();
		System.out.println(sst);
	}

}
