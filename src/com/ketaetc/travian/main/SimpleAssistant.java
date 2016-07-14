package ketaetc.travian.main;

import ketaetc.travian.html.Connector;
import ketaetc.travian.util.DateFormatter;
import ketaetc.travian.util.PropertyReader;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * <p>
 * Hoc fac et vinces
 * Сделай это, и ты победишь
 */
public class SimpleAssistant {

    public static void main(String[] args) throws Exception {
        System.out.println("########################################");
        System.out.println("START at:   " + DateFormatter.getTime());
        System.out.println("########################################\n");

        PropertyReader pr = new PropertyReader();
        Connector conn = new Connector(pr);

        conn.setConnection();
        conn.tryToLogin();
        conn.getResources();

        System.out.println("\n########################################");
        System.out.println("END at: " + DateFormatter.getTime());
        System.out.println("########################################");
    }
}
