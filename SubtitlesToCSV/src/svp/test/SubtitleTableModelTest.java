package svp.test;

import svp.data.filereader.AudacityFileReader;
import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.gui.main.TestCardLayout;
import svp.util.CSVGenerator;
import svp.util.MP3Splitter;

public class SubtitleTableModelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		SubtitleDataholder sdh = SubtitleDataholder.getSubtitleDataholder();
		//SubtitleTableModel stm = sdh.createTableModel();
		//System.out.println(stm);
		new TestCardLayout();
	}

}
