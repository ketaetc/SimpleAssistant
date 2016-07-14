package ketaetc.travian.util;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * Date: 15.07.16 1:06
 */
public class StringTemplates {
    public static final String LINE = "########################################";

    public StringTemplates() {
    }

    public void printLoginInfo(String login, String password, String url) {
        System.out.println(LINE);
        System.out.println("Property file read successfully!");
        System.out.println("Properties are:");
        System.out.println("LOGIN: " + login);
        System.out.println("PASSWORD: " + password);
        System.out.println("URL: " + url);
        System.out.println(LINE);
    }

    //print message: "Something goes wrong..."
    public static void pringSGW() {
        System.out.println(LINE);
        System.out.println("Something goes wrong...");
        System.out.println(LINE);
    }
}
