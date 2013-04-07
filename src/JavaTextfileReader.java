import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * An example of how 10-20 lines of Java code
 * is equivalent to 1 line of Groovy code
 */
public class JavaTextfileReader {
    public static void main(String[] args) throws IOException {
        File file = new File("wtfpl.txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        while (reader.ready()) { // exception possible here
            System.out.println(reader.readLine());
        }
    }
}
