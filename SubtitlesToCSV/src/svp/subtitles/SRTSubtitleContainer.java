package svp.subtitles;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class SRTSubtitleContainer extends SubtitleContainer{
	
	public SRTSubtitleContainer(int ccId, String startTimestamp, String endTimestamp, String text) {
		super();
		this.ccId = ccId;
		this.startTimestamp = startTimestamp;
		this.endTimestamp = endTimestamp;
		this.text = text;
		this.valid = true;
	}
	
	public SRTSubtitleContainer(String[] split) {
		// TODO Auto-generated constructor stub
		if(split.length<2) {
			System.out.println("This one was not correct :( ");
			this.valid = false;
		}
		else if(split.length >= 3) {
			try {
				this.ccId = Integer.valueOf(split[0].replaceAll("﻿", ""));
			}
			catch(Exception e) {
				this.ccId = -1;
			}
			
			String fromToTimestamp = split[1]; //in format 00:00:00.000 --> 00:00:00.000
			String[] timestamps = split[1].split("\\-->");
			if(timestamps.length==2) {
				this.startTimestamp = convertStartTimestamp(timestamps[0]);
				this.endTimestamp = convertEndTimestamp(timestamps[1]);
			}
			if(split.length==3) {
				this.text = split[2];
			}
			else {
				for(int i = 2; i<split.length;i++) {
					this.text+=split[i]+"\n";
				}
			}
			this.text = Normalizer.normalize(this.text, Form.NFD);
			this.text = this.text.replaceAll("<i>", "");
			this.text = this.text.replaceAll("</i>", "");
			this.valid = true;
		}
	}
	

	public String convertStartTimestamp(String timestamp) {
		System.out.println("Got Timestamp: "+timestamp);
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
		System.out.println("Result Timestamp: "+result);
		return result;
	}
	
	public String convertEndTimestamp(String timestamp) {
		System.out.println("Got Timestamp: "+timestamp);
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
		System.out.println("Result Timestamp: "+result);
		return result;
	}
}
