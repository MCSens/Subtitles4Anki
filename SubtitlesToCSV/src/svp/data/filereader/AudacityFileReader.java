package svp.data.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.subtitlecontainer.AudacitySubtitleContainer;
import svp.data.subtitlecontainer.SRTSubtitleContainer;
import svp.data.subtitlecontainer.SubtitleContainer;

public class AudacityFileReader extends FileReader{

	public AudacityFileReader(String movieName, String pathToSubtitleFile, String pathToAudioFile){	
		// TODO Auto-generated method stub
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = movieName;   //Alles in der Config Table, nicht mehr lokal hier drin!
		this.subtitles = new ArrayList();
		this.pathToSubtitleFile = pathToSubtitleFile;
		this.pathToAudioFile = pathToAudioFile;
	}
	
	public AudacityFileReader(String movieName, String pathToSubtitleFile, String pathToAudioFile, String[] languages){	
		// TODO Auto-generated method stub
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = movieName;
		configurationTable.setMovieTitle(movieName);
		
		this.pathToSubtitleFile = pathToSubtitleFile;
		configurationTable.setPathToSubtitleFile(pathToSubtitleFile);
		
		this.pathToAudioFile = pathToAudioFile;
		configurationTable.setPathToAudioFile(pathToAudioFile);
		
		this.languages = languages;
		subtitleDataholder.setLanguages(languages);
		
		this.subtitles = new ArrayList();
	}
	
	public AudacityFileReader() {
		this.configurationTable = ConfigurationTable.getConfigurationTable();
		this.subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
		this.movieName = configurationTable.getMovieTitle();
		this.pathToSubtitleFile = configurationTable.getPathToSubtitleFile();
		this.pathToAudioFile = configurationTable.getPathToAudioFile();
		this.languages = subtitleDataholder.getLanguages();
		this.subtitles = new ArrayList();
	}
	
	public void readFile() {
		Scanner sc;
		try {
			System.out.println("INFO --- Start Reading of File "+this.pathToSubtitleFile+" ---");
			
			int id = 1;
			sc = new Scanner(new File(this.pathToSubtitleFile), "utf-8");
			
			while(sc.hasNextLine()) {
				String fileLine = sc.nextLine();

				System.out.println("DEBUG - Read Line: "+fileLine);
				fileLine+="\t"+(id++);
				String[] splitted = fileLine.split("\\t");
				for(int i = 0; i < splitted.length; i++) {
					System.out.println("TRACE - Splitted ["+i+"]: "+splitted[i]);
				}
 				AudacitySubtitleContainer asc = new AudacitySubtitleContainer(this.movieName, splitted, this.languages);
 				if(asc.getValid()) {
 					//subtitles.add(asc);
 					this.subtitleDataholder.addSubtitleContainer(asc);
 				}
 				else {
 					System.out.println("WARN - Issue found with "+asc+" and thus is being skipped");
 				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		} finally {
			System.out.println("INFO --- Reading of File Completed ---");
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
