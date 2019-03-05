package svp.test;

import svp.data.files.AudacityFileReader;

public class AudacityReadMultipleLanguagesSkipLanguageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		String[] languages = new String[] {"Chinese", "-", "Deutsch"};
		AudacityFileReader afr = new AudacityFileReader("Multiple Languages", "resources/AudacityMultipleLanguagesTest.txt", "Noaudio.mp3", languages);
		afr.readFile();
		afr.mergeCommas();
		System.out.println(afr);
		//Expected Result: "Only Chinese and German subtitles are visible
	}

}
