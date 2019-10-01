package changes.versions.seven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * New Java I/O API
 *
 * This new API was created to solve some issues around {@link java.io.File}
 *
 * Problems Before Java 7
 * - No proper exception handler
 * - Performance issues
 * - Verbose/Complex code
 * - Methods not consistent with all operating systems
 * - Missing basic file operations
 * - Limited support for file attribute
 *
 * Advantages:
 * - No need to close resources explicitly
 * - Readable/Simple code
 *
 * Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/io/enhancements.html#7
 */
public class NewIO {

    public static void main(String[] args) {
        beforeJava7();
        java7();
    }

    //Reading a File
    private static void beforeJava7() {
        FileInputStream fis = null;
        String filename = "file.txt";
        String content = "";
        try {
            File file = new File(NewIO.class.getClassLoader().getResource(filename).getFile());
            fis = new FileInputStream(file);
            int i;
            while ((i = fis.read()) != -1) {
                content += (char) i;
            }
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    //Reading a File
    private static void java7() {
        try {
            String filename = "file.txt";
            Path path = Paths.get(NewIO.class.getClassLoader().getResource(filename).toURI());
            String content = new String(Files.readAllBytes(path));
            System.out.println(content);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
