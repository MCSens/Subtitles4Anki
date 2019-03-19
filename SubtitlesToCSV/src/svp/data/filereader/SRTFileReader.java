package svp.data.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.subtitlecontainer.SRTSubtitleContainer;
import svp.data.subtitlecontainer.SubtitleContainer;

/**
 * This file is responsible for reading the File for Subtitle Type Audacity has been selected.
 * 
 * <p>
 * Each line of the file will be converted into Subtitle Containers.
 * The created Subtitle Containers are stored in SubtitleDataholder.
 * </p>
 * @see SubtitleDataholder
 * 
 */
public class SRTFileReader extends FileReader{

	public SRTFileReader(String movieName, String pathToSubtitleFile){	
		/*
		 * I should somehwat validate the file
		 * Are there enough blank spaces?
		 * 
		 */
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.movieName = movieName;
		this.subtitles = new ArrayList();
		this.pathToSubtitleFile = pathToSubtitleFile;
	}
	
	public void readFile() {
		Scanner sc;
		try {
			
			//File.createNewFile();
			//sc = new Scanner(new File("lib/mynums.txt"));
			int id = -1;
			String fromTimestamp;
			String toTimestamp;
			String text;
			//sc = new Scanner(new File("lib/subtitles_BossAndMe_Episode2.txt"));
			sc = new Scanner(new File(this.pathToSubtitleFile));
			//sc.nextLine(); //Get rid of crazy initial value?
			while(sc.hasNextLine()) {
				String fileLine ="";
				String fileFormattedLine = "";
				do
				{
					//System.out.print("FileLine": );
					fileLine = sc.nextLine();
					fileFormattedLine += fileLine+"|";
				
				}while(!fileLine.equals("") && sc.hasNextLine());
				System.out.println(fileFormattedLine);
				
				String[] splitted = fileFormattedLine.split("\\|");
				//System.out.println(splitted[0]);
 				SRTSubtitleContainer ysh = new SRTSubtitleContainer(splitted);
				//System.out.println(ysh);
				subtitles.add(ysh);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		} finally {
			for(SubtitleContainer ysh: subtitles) {
				System.out.println(ysh);
			}
		}
	}
	
	public String toString() {
		String result = "";
  		for(SubtitleContainer sr: subtitles) {
  			//System.out.println(sr);
  			result+=sr+"\n";
		}
		return result;
	}
	
	public List<SubtitleContainer> getSubtitles(){
		return subtitles;
	}
}
