package svp.playground;

import java.io.File;
import java.net.URL;
import com.github.axet.vget.*;

/**
 *
 * @author Manindar
 */
public class JavaYoutubeDownloader {

    public static void main(String[] args) {
        try {
            String url = "https://www.youtube.com/watch?v=dNp_SxqPS0Y";
            String path = "C:\\Users\\MCSens\\Documents\\Subtitles\\Audio";
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}