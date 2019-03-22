package svp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import svp.util.HanziPinyinConverter;

public class HanziToPinyinTest {

	@Test
	public void test() {
		String chineseSentence = "你好 老师，我 是 你的 学生";
        String outputString = HanziPinyinConverter.convertSentence(chineseSentence);
        System.out.println(outputString);
		fail("Not yet implemented");
	}

}
