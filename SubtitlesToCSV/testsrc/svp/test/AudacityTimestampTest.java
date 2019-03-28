package svp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import svp.data.filereader.AudacityFileReader;
import svp.data.subtitlecontainer.AudacitySubtitleContainer;

public class AudacityTimestampTest {
	private static Logger log = (Logger) LoggerFactory.getLogger(AudacityTimestampTest.class);
	
	@Test
	public void testStartTSConversion1() {
		log.info("Start Testrun testStartTSConversion1");
		String[] split = {"1.0","2.0","Hi","Ni hao","1"};
		String[] languages = {"Chinese", "English"};
		AudacitySubtitleContainer asc = new AudacitySubtitleContainer(null, split, languages);
		String testTimestamp = "23.623867";
		String expectedResult = "00.23.623867";
		log.info("Start Conversion of Timestamp");
		String actualResult = asc.convertStartTimestamp(testTimestamp);
		log.info("Timestamp "+testTimestamp+" has been converted to "+actualResult);
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testStartTSConversion2() {
		log.info("Start Testrun testStartTSConversion2");
		String[] split = {"1.0","2.0","Hi","Ni hao","2"};
		String[] languages = {"Chinese", "English"};
		AudacitySubtitleContainer asc2 = new AudacitySubtitleContainer(null, split, languages);
		String testTimestamp = "151.623867";
		String expectedResult = "2.31.623867";
		log.info("Start Conversion of Timestamp");
		String actualResult = asc2.convertStartTimestamp(testTimestamp);
		log.info("Timestamp "+testTimestamp+" has been converted to "+actualResult);
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testStartTSConversion3() {
		log.info("Start Testrun testStartTSConversion3");
		String[] split = {"1.0","2.0","Hi","Ni hao","3"};
		String[] languages = {"Chinese", "English"};
		AudacitySubtitleContainer asc3 = new AudacitySubtitleContainer(null, split, languages);
		String testTimestamp = "62.623867";
		String expectedResult = "1.2.623867";
		log.info("Start Conversion of Timestamp");
		String actualResult = asc3.convertStartTimestamp(testTimestamp);
		log.info("Timestamp "+testTimestamp+" has been converted to "+actualResult);
		assertEquals(actualResult, expectedResult);
	}

}
