package svp.data.subtitlecontainer;

public class SubtitleLiteral {
	String language;
	String text;
	
	public SubtitleLiteral(String language, String text) {
		super();
		this.language = language;
		this.text = text;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "SubtitleLiteral [language=" + language + ", text=" + text + "]";
	}
	
}
