package ketaetc.travian.util;

import java.io.*;
import java.util.Scanner;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * Date: 15.07.16 0:13
 */
public class PropertyCreator {
    final String propPath = "conf.properties";

    public PropertyCreator() {
    }

    private String[] setProperties() {
        String[] props = {"login = ", "password = ", "url = "};
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter LOGIN: ");
        props[0] = props[0] + sc.next();
        System.out.println("Please enter PASSWORD: ");
        props[1] = props[1] + sc.next();
        System.out.println("Please enter URL: ");
        props[2] = props[2] + sc.next();

        System.out.println(StringTemplates.LINE);
        System.out.println("Properties are:");
        for (String s : props) {
            System.out.println(s);
        }
        System.out.println(StringTemplates.LINE);

        return props;
    }

    File createPropFile() throws IOException {
        String propContent = new String();
        String[] props;

        File file = new File(propPath);
        if (!file.exists()) {
            file.createNewFile();

            props = setProperties();
            for (String s : props) {
                propContent = propContent + s + "\n";
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(propContent);
            bw.close();
        }
        return file;
    }
}
