package svp.test;

import svp.data.files.AudacityFileReader;

public class AudacityReadMultipleLanguagesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AudacityTestSubtitleFile
		String[] languages = new String[] {"Chinese", "English", "Deutsch"};
		AudacityFileReader afr = new AudacityFileReader("MultipleLanguages", "resources/AudacityMultipleLanguagesTest.txt", "Noaudio.mp3", languages);
		afr.readFile();
		afr.mergeCommas();
		System.out.println(afr);
	}

}
