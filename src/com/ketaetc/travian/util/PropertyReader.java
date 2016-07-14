package ketaetc.travian.util;

import com.sun.deploy.config.Config;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 */
public class PropertyReader {

    private Properties prop;
    private Scanner sc;
    private OutputStream out;
    private String login;
    private String password;
    private String url;

    public PropertyReader() {
        getProperties();
    }

    boolean checkProperty(String p) {
        try {
            if (!(prop.getProperty(p) == null) && !prop.getProperty(p).equals("")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getProperties() {
        final String propPath = "conf.properties";
        final String appPropPath = "jar/app/conf.properties";

        prop = new Properties();

        try {
            File f = new File(propPath);
            FileInputStream fis;
            sc = new Scanner(System.in);
            if (f.exists()) {
                fis = new FileInputStream(f);
            } else {
                f = new File(appPropPath);
                fis = new FileInputStream(f);
            }
            prop.load(fis);
            out = new FileOutputStream(f);

            try {
                if (checkProperty("login")) {
                    login = prop.getProperty("login");
                } else {
                    System.out.println("PLEASE ENTER login:");
                    login = sc.next();
                    prop.setProperty("login", login);
                }
                if (checkProperty("password")) {
                    password = prop.getProperty("password");
                } else {
                    System.out.println("PLEASE ENTER password:");
                    password = sc.next();
                    prop.setProperty("password", password);
                }
                if (checkProperty("url")) {
                    url = prop.getProperty("url");
                } else {
                    System.out.println("PLEASE ENTER url:");
                    url = sc.next();
                    prop.setProperty("url", url);
                }
                prop.store(out, "");

                System.out.println("Property file read successfully!");
                System.out.println("Properties are:");
                System.out.println("LOGIN: " + login);
                System.out.println("PASSWORD: " + password);
                System.out.println("URL: " + url);
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("Something goes wrong...");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something goes wrong...");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
