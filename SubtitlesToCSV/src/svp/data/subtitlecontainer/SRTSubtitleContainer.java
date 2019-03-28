package svp.data.subtitlecontainer;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author MCSens
 *
 * Represents a single Row of Data, one Flashcard if Subtitle Type SRT is selected.
 * Contains Text for the languages, start/end of Audio Snippet.
 * 
 */
public class SRTSubtitleContainer extends SubtitleContainer{
	private static Logger log = (Logger) LoggerFactory.getLogger(SRTSubtitleContainer.class);
	
	public SRTSubtitleContainer(int ccId, String startTimestamp, String endTimestamp, String text) {
		super();
		this.ccId = ccId;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.text = text;
		this.valid = true;
	}
	
	public SRTSubtitleContainer(String movieName, String[] split, String[] languages) {
		// TODO Auto-generated constructor stub
		if(split.length<2) {
			log.warn("Array "+split.toString()+"contains less than 2 two rows and thus is not correct");
			this.valid = false;
		}
		else if(split.length >= 3) {
			try {
				this.ccId = Integer.valueOf(split[0].replaceAll("﻿", ""));
			}
			catch(Exception e) {
				this.ccId = -1;
			}
			
			//String fromToTimestamp = split[1]; //in format 00:00:00.000 --> 00:00:00.000
			String[] timestamps = split[1].split("\\-->");
			if(timestamps.length==2) {
				this.startTimestamp = convertStartTimestamp(timestamps[0]);
				this.endTimestamp = convertEndTimestamp(timestamps[1]);
			}
			
			ArrayList<SubtitleLiteral> subtitles = new ArrayList<>();
			String text="";
			if(split.length==3) {
				text = split[2];
			}
			else {
				for(int i = 2; i<split.length;i++) {
					text+=split[i]+"\n";
				}
				
			}
			//TODO
			////////////////////////////////
			//	   Clean Up, Temporary!	   //
			////////////////////////////////
			text = Normalizer.normalize(text, Form.NFD);
			text = text.replaceAll("<i>", "");
			text = text.replaceAll("</i>", "");
			
			SubtitleLiteral sl = new SubtitleLiteral("Language", text);
			log.info(sl.toString());
			subtitles.add(sl);
			this.translations = subtitles;
			
			this.outputFileName = movieName+"_"+ccId+"_"+this.startTimestamp.replace(".", "")+"_"+this.endTimestamp.replace(".", "");
			this.valid = true;
			
		}
	}
	

	public String convertStartTimestamp(String timestamp) {
		log.trace("Got Timestamp: "+timestamp);
		timestamp = timestamp.replaceAll("\\s+","");
		String[] tempTsp = timestamp.split("\\:");
		String result="";
		if(tempTsp.length>2) {
			int hour = Integer.valueOf(tempTsp[0]);
			int minute = Integer.valueOf(tempTsp[1]);
			int second = Integer.valueOf(tempTsp[2].substring(0, 2)); //always two digit, get rid of milli seconds
			if(second==59) {
				int minutes = hour*60+minute+1;
				result = minutes+".00";				
			}
			else {
				int minutes = hour*60+minute;
				result = minutes+"."+(second);		
			}
		}
		log.trace("Result Timestamp: "+result);
		return result;
	}
	
	public String convertEndTimestamp(String timestamp) {
		log.trace("Got Timestamp: "+timestamp);
		timestamp = timestamp.replaceAll("\\s+","");
		String[] tempTsp = timestamp.split("\\:");
		String result="";
		if(tempTsp.length>2) {
			int hour = Integer.valueOf(tempTsp[0]);
			int minute = Integer.valueOf(tempTsp[1]);
			int second = Integer.valueOf(tempTsp[2].substring(0, 2)); //always two digit, get rid of milli seconds
			if(second==59) {
				int minutes = hour*60+minute+1;
				result = minutes+".00";				
			}
			else {
				int minutes = hour*60+minute;
				result = minutes+"."+(second+1);		
			}
		}
		log.trace("Result Timestamp: "+result);
		return result;
	}
}
