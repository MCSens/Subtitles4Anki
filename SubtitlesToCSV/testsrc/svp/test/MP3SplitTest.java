package svp.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class MP3SplitTest {

	@Test
	public void test() {
		Runtime rt = Runtime.getRuntime();
		try {
			String command = "mp3splt C:\\Users\\MCSens\\Documents\\Subtitles\\Audio\\01-1.mp3 00.24.51 00.26.30 -o S2C_HSK-3-01-1\\HSK-3-01-1_1_002451_002630";
			rt.exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

}
