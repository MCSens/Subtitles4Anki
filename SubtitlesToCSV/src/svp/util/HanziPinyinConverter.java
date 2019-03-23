package svp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class HanziPinyinConverter {
	private static Logger log = (Logger) LoggerFactory.getLogger(HanziPinyinConverter.class);
	
	public static String convertSentence(String chineseSentence) {
		log.debug("Received Sentence: "+chineseSentence);
		HanyuPinyinOutputFormat hpof = new HanyuPinyinOutputFormat();
		hpof.setVCharType(null);
		hpof.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
            
		String result="";
		char[] chineseCharArray = chineseSentence.toCharArray();
		for(int i = 0; i<chineseCharArray.length;i++) {
			char chineseCharacter = chineseCharArray[i];
			String[] pinyinArray;
			try {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, hpof);
				if(pinyinArray==null) {
					result+=chineseCharacter;
				}
				else {
					for(int j = 0; j<pinyinArray.length;j++) {
						if(pinyinArray.length>1) {
							log.warn("Found more than one Pinyin for character "+chineseCharacter);
						}
						result+=pinyinArray[j];
						log.info(result);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.debug("Converted Sentence: "+result);
		return result;
	}
	
    public static String concatPinyinStringArray(String[] pinyinArray)
    {
        StringBuffer pinyinStrBuf = new StringBuffer();

        if ((null != pinyinArray) && (pinyinArray.length > 0))
        {
            for (int i = 0; i < pinyinArray.length; i++)
            {
                pinyinStrBuf.append(pinyinArray[i]);
                pinyinStrBuf.append(System.getProperty("line.separator"));
            }
        }
        String outputString = pinyinStrBuf.toString();
        return outputString;
    }
}
