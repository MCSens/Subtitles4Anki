package svp.data.main;

import java.util.ArrayList;
import java.util.List;

import svp.data.subtitles.SubtitleContainer;

public class SubtitleDataholder {
	private static SubtitleDataholder instance = new SubtitleDataholder();
	private List<SubtitleContainer> subtitles = new ArrayList<SubtitleContainer>();
	private String[] languages;
	private String movieName;
	
	private SubtitleDataholder() {
		//Do nothing, enforce usages of getInstance Method
	}
	
	public static SubtitleDataholder getSubtitleDataholder() {
		return instance;
	}
	
	public List<SubtitleContainer> getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(List<SubtitleContainer> subtitles) {
		this.subtitles = subtitles;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public void addSubtitleContainer(SubtitleContainer sc) {
		System.out.println("INFO added SubtitleContainer "+sc+" to SubtitleDataholder");
		this.subtitles.add(sc);
	}
}