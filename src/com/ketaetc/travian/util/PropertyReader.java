package ketaetc.travian.util;

import com.sun.deploy.config.Config;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * DateFormatter: 07.07.16 0:14
 */
public class PropertyReader {

    private Properties prop;
    private Scanner sc;
    private OutputStream out;
//    private Map<String, String> propMap = new HashMap<String, String>();

    private String login;
    private String password;
    private String url;

    public PropertyReader() {

        getProperties();

    }

    boolean checkProperty (String p) {

        try {
            if (!(prop.getProperty(p) == null) &&
                    !prop.getProperty(p).equals("")){
                return true;
            }
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void getProperties(){

        String propPath = "conf.properties";
        String appPropPath = "jar/app/conf.properties";

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

//                System.out.println("LOGIN:  " + login + "\n"
//                        + "PASSWORD:    " + password + "\n"
//                        + "URL: " + url);
            } catch (NullPointerException e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
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
