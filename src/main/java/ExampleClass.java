import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Calculates the amount of times "Prince" is said in Hamlet.
 * @author jordan kahn
 *
 */
public class ExampleClass {

    /**
     * cOol mAiN mEtHoD. See class description
     * @param args arguments
     */
    public static void main(final String[] args) {
        /**
         * the stoppage point in the text and the length of the word prince
         */
        final int stop = 6;

        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = 0;
        for (int i = 0; i < hamlet.length() - stop; i++) {
            if (hamlet.substring(i, i + stop).equalsIgnoreCase("prince")) {
                count++;
            }
        }
        System.out.println("Hamlet has the word Prince " + count + " times.");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
