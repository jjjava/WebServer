package webserver;

/**
 *
 * @author hudson.sales
 */
import webserver.core.Core;
import webserver.util.Util;

public class WebServer {

    public static void main(String argv[]) {

//            String pid[] = ManagementFactory.getRuntimeMXBean().getName().split("@");
//            Runtime.getRuntime().exec("wmic process where processid=\"" + pid[0] + "\" CALL 256");
        Util.createTreeFodlers();
        Util.save404Page();
        Core core = new Core();
    }
}