package svp.playground;

import java.io.IOException;


public class ExecuteCmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//mp3splt "C:\Users\MCSens\Audio\to_split_ep2.mp3" 00.00 01.00
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("mp3splt \"C:\\Users\\MCSens\\Audio\\to_split_ep2.mp3\" 10.00 10.05");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
