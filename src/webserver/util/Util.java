
package webserver.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
public class Util {

    public Util() {
    }

    public static String getWWWPath() {
        return System.getProperties().getProperty("user.dir") + "/www/";
    }

    public static String getError404Path() {
        return System.getProperties().getProperty("user.dir") + "/error/error404.html";
    }

    public static void createTreeFodlers() {
        File dir1 = new File("error");
        if (!dir1.exists()) {
            dir1.mkdir();
        }
        File dir2 = new File("www");
        if (!dir2.exists()) {
            dir2.mkdir();
        }
    }

    public static void save404Page() {
        String html = ""
                + "<hmtl>"
                + "<head>"
                + "<title>Error 404</title>"
                + "</head>"
                + "<body>"
                + "<h2>page not found!!!</h2>"
                + "</body>"
                + "</html>";

        File file = new File(System.getProperties().getProperty("user.dir") + "/error/error404.html");
        if (!file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(fileWriter);
                buffer.write(html);
                buffer.flush();
                buffer.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}