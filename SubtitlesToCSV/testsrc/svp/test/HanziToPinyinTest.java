package svp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import svp.util.HanziPinyinConverter;

public class HanziToPinyinTest {
	private static Logger log = (Logger) LoggerFactory.getLogger(HanziToPinyinTest.class);
	
	@Test
	public void test1() {
		String chineseSentence = "我 是 学生";
		String expectedResult = "wŏ shì xuéshēng";
        String outputString = HanziPinyinConverter.convertSentence(chineseSentence);
        log.info(outputString);
		assertEquals(outputString,expectedResult);
	}
	
	@Test
	public void test2() {
		String chineseSentence = "我 爱 你";
		String expectedResult = "wŏ ài nĭ";
		String  outputString = HanziPinyinConverter.convertSentence(chineseSentence);
        log.info(outputString);
		assertEquals(outputString,expectedResult);
	}
	
	@Test
	public void test3() {
		String chineseSentence = ",.-!";
		String expectedResult = ",.-!";
		String  outputString = HanziPinyinConverter.convertSentence(chineseSentence);
        log.info(outputString);
		assertEquals(outputString,expectedResult);
	}

}
