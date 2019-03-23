package svp.data.subtitlecontainer;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.main.ConfigurationTable;
import svp.util.HanziPinyinConverter;

/**
 * 
 * @author MCSens
 *
 * Represents a single Row of Data, one Flashcard if Subtitle Type Audacity is selected.
 * Contains Text for the languages, start/end of Audio Snippet.
 * 
 */
public class AudacitySubtitleContainer extends SubtitleContainer{
	private static Logger log = (Logger) LoggerFactory.getLogger(AudacitySubtitleContainer.class);
	
	public AudacitySubtitleContainer(String movieName, String[] split, String[] languages) { //Should also get an Array of elements to remove
		if(languages == null) {
			languages = new String[] {"Chinese"};
		}
		if(split.length<4) {
			log.warn("This row contained less than 4 Elements and thus is not correct "+Arrays.toString(split));
			this.valid = false;
		}
		else {
			try {
				this.ccId = Integer.valueOf(split[0]);
			}
			catch(Exception e) {
				this.ccId = -1;
			}
			
			this.startTimestamp = convertStartTimestamp(split[0]);
			
			ConfigurationTable configurationTable = ConfigurationTable.getConfigurationTable();
			boolean isGeneratePinyinEnabled = configurationTable.isGeneratePinyinEnabled();
			//Split the Array to create the Literals
			ArrayList<SubtitleLiteral> subtitles = new ArrayList<>();
			String chineseSentence="";
			for(int i = 0; i<languages.length;i++) {
				if(languages[i]!="-" && languages[i] != "" && i<split.length+2) {
					String language = languages[i];
					String translation = split[i+2];
					if(isGeneratePinyinEnabled&&language.equals("Hanzi")) {
						chineseSentence=translation;
						log.trace("Language: "+language +" Translation: "+translation);
						SubtitleLiteral sl = new SubtitleLiteral(language, translation);
						subtitles.add(sl);
						log.trace("Added "+sl);
					}
					else if(isGeneratePinyinEnabled&&language.equals("Pinyin")) {
						String chineseSentenceInPinyin = HanziPinyinConverter.convertSentence(chineseSentence);
						SubtitleLiteral sl = new SubtitleLiteral("Pinyin", chineseSentenceInPinyin);
						subtitles.add(sl);
					}
					else {
						log.trace("Language: "+language +" Translation: "+translation);
						SubtitleLiteral sl = new SubtitleLiteral(language, translation);
						subtitles.add(sl);
						log.trace("Added "+sl);
					}
				}
			}
			this.translations = subtitles;
			this.text = Normalizer.normalize(this.text, Form.NFD);
			this.text = split[2];
			this.ccId = Integer.valueOf(split[split.length-1]);
			this.valid = true;

			  ////////////////////////////////
			 //			Clean Up 		   //
			////////////////////////////////
			this.endTimestamp = convertEndTimestamp(split[1]);
			//this.text = this.text.replaceAll("<i>", "");
			//this.text = this.text.replaceAll("</i>", "");
			this.outputFileName = movieName+"_"+ccId+"_"+this.startTimestamp.replace(".", "")+"_"+this.endTimestamp.replace(".", "");
			this.valid = true;
		}
	}
	
	public AudacitySubtitleContainer(int ccId, String startTimestamp, String endTimestamp, String text) {
		super();
		this.ccId = ccId;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.text = text;
		this.valid = true;
	}

	public String convertStartTimestamp(String timestamp) {
		log.trace("Got Timestamp: "+timestamp);
		timestamp = timestamp.replaceAll("\\s+","");
		String[] tempTsp = timestamp.split("\\.");
		String result="";
		if(tempTsp.length==2) {
			int minutes = 0;
			int second = Integer.valueOf(tempTsp[0]); //always two digit, get rid of milli seconds
			//int millisecond = Integer.valueOf(tempTsp[1]);
			if(((double)second/(double)60) > 1) {
				minutes = Integer.valueOf((second/60));
				int seconds = second - minutes*60;
				result = minutes+"."+seconds;				
			}
			else {
				result = "00."+(second);		
			}
		}
		log.trace("Result Timestamp: "+result);
		return result;
	}
	
	public String convertEndTimestamp(String timestamp) {
		log.trace("Got Timestamp: "+timestamp);
		timestamp = timestamp.replaceAll("\\s+","");
		String[] tempTsp = timestamp.split("\\.");
		String result="";
		if(tempTsp.length==2) {
			int minutes = 0;
			int second = Integer.valueOf(tempTsp[0]); //always two digit, get rid of milli seconds
			//int millisecond = Integer.valueOf(tempTsp[1]);

			if(((double)second/(double)60) > 1) {
				minutes = Integer.valueOf((second/60));
				int seconds = second - minutes*60;
				if(seconds==59) {
					minutes += 1;
					seconds = 0;
				}
				else {
					seconds +=1;
				}
				result = minutes+"."+seconds;				
			}
			else {
				result = "00."+(second+1);		
			}
		}
		log.trace("Result Timestamp: "+result);
		return result;
	}
}
