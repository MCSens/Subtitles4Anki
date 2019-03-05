package svp.data.main;

import java.util.List;

import svp.data.subtitles.SubtitleContainer;

public class SubtitleDataholder {
	protected List<SubtitleContainer> subtitles;
	protected String[] languages;
	protected String movieName;
	
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
		this.subtitles.add(sc);
	}
}