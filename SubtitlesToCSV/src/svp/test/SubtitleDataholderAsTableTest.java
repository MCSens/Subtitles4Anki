package svp.test;

import svp.data.filereader.AudacityFileReader;
import svp.data.main.SubtitleDataholder;
import svp.gui.main.TestCardLayout;

public class SubtitleDataholderAsTableTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movieName = "NPCR2-Text1-Dialog2";
		String subtitleFilePath = "C:\\Users\\MCSens\\git\\S2Anki\\SubtitlesToCSV\\resources\\SubtitleDataholderAsTableTest.txt";
		String audioFilePath = "C:\\Users\\MCSens\\Subtitles\\Audio\\02_Text1_Dialog2.mp3";
		String[] languages = new String[]{"Hanzi","Pinyin","English"};
		AudacityFileReader afr = new AudacityFileReader(movieName, 
				subtitleFilePath, 
				audioFilePath, 
				languages);
		afr.readFile();
		//afr.mergeCommas();
		
		SubtitleDataholder sdh = SubtitleDataholder.getSubtitleDataholder();
		int rows = sdh.getRowCount();
		int columns = sdh.getColumnCount();
		for(int i = 0; i<rows;i++) {
			for(int j = 0; j<columns;j++) {
				System.out.println(sdh.getValueAt(i, j));
			}
		}
	}
}
