package svp.test;


//pinyin4j entry point 
import net.sourceforge.pinyin4j.PinyinHelper;

//only when you need formating the output 
import net.sourceforge.pinyin4j.format.*; 
import net.sourceforge.pinyin4j.format.exception.*;

public class PinyinConverterTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanyuPinyinOutputFormat hpof = new HanyuPinyinOutputFormat();
		hpof.setVCharType(null);
		hpof.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
		try {
			char chineseCharacter = '你';
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, hpof);
            String outputString = concatPinyinStringArray(pinyinArray);
            System.out.println(outputString);
            
			chineseCharacter = '我';
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, hpof);
            outputString = concatPinyinStringArray(pinyinArray);
            System.out.println(outputString);
            
            
        } catch (BadHanyuPinyinOutputFormatCombination e1)
        {
            e1.printStackTrace();
        }
		//String[] str;
		/*
		try {
			str = PinyinHelper.toHanyuPinyinStringArray('你', hpof);
			PinyinHelper.to
			System.out.println(str.toString());
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
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
