package svp.data.subtitlecontainer;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.AudacityFileReader;

public class AudacitySubtitleContainer extends SubtitleContainer{
	private static Logger log = (Logger) LoggerFactory.getLogger(AudacitySubtitleContainer.class);
	
	public AudacitySubtitleContainer(String movieName, String[] split, String[] languages) { //Should also get an Array of elements to remove
		if(languages == null) {
			languages = new String[] {"Chinese"};
		}
		// TODO Auto-generated constructor stub
		if(split.length<4) {
			log.warn("This row contained less than 4 Elements and thus is not correct "+Arrays.toString(split));
			this.valid = false;
		}
		else {
			try {
				this.ccId = Integer.valueOf(split[0].replaceAll("﻿", ""));
			}
			catch(Exception e) {
				this.ccId = -1;
			}
			
// 2019-02-24 BEGIN -- Instead of one field text use a array list to support multiple languages
/*			this.startTimestamp = convertStartTimestamp(split[0]);
			this.text = Normalizer.normalize(this.text, Form.NFD);
			this.text = split[2];
			this.ccId = Integer.valueOf(split[3]);
			this.valid = true;
*/		
			this.startTimestamp = convertStartTimestamp(split[0]);
			ArrayList<SubtitleLiteral> subtitles = new ArrayList<>();
			for(int i = 0; i<languages.length;i++) {
				if(languages[i]!="-" && languages[i] != "" && i<split.length+2) {
					String language = languages[i];
					String translation = split[i+2];
					log.trace("Language: "+language +" Translation: "+translation);
					SubtitleLiteral sl = new SubtitleLiteral(language, translation);
					subtitles.add(sl);
					log.trace("Added "+sl);
				}
			}
			this.translations = subtitles;
			this.text = Normalizer.normalize(this.text, Form.NFD);
			this.text = split[2];
			this.ccId = Integer.valueOf(split[split.length-1]);
			this.valid = true;

// 2019-02-24 END
			
			  ////////////////////////////////
			 //			Clean Up 		   //
			////////////////////////////////
			this.endTimestamp = convertEndTimestamp(split[1]);
			this.text = this.text.replaceAll("<i>", "");
			this.text = this.text.replaceAll("</i>", "");
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
			int millisecond = Integer.valueOf(tempTsp[1]);
			//double value = second/60;
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
			int millisecond = Integer.valueOf(tempTsp[1]);

			if(((double)second/(double)60) > 1) {
				minutes = Integer.valueOf((second/60));
				int seconds = second - minutes*60;
				if(seconds==59) {
					minutes += 1;
					seconds = 0;
				}
				else {
					//Add one Second to make up for cut of Miliseconds
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
