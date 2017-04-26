package production.DanChunn.Chess;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by jotsandhu on 4/25/17.
 */
public class SpeechRecognition {
    public SpeechRecognition() {

    }

    public static String getResponse() {
        {
            String s = null;

            try {
                Process p = Runtime.getRuntime().exec("python  /Users/jotsandhu/RecognizeSpeech.py");
                p.waitFor();
                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(p.getInputStream()));

                BufferedReader stdError = new BufferedReader(new
                        InputStreamReader(p.getErrorStream()));

                // read the output from the command
                //System.out.println("Here is the standard output of the command:");
                //System.out.println("_______");
                while ((s = stdInput.readLine()) != null) {
                    return (s);
                }
                // read any errors from the attempted command
                //System.out.println("Here is the standard error of the command (if any):");
                //System.out.println("_______");
            /*
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
            */
            } catch (Exception e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
                return ("error");
            }
            return null;
        }
    }
}
