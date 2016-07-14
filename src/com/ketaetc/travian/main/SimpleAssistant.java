package ketaetc.travian.main;

import ketaetc.travian.html.Connector;
import ketaetc.travian.html.Resources;
import ketaetc.travian.util.DateFormatter;
import ketaetc.travian.util.PropertyReader;
import ketaetc.travian.util.StringTemplates;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * <p>
 * Hoc fac et vinces
 * Сделай это, и ты победишь
 */
public class SimpleAssistant {

    public static void main(String[] args) throws Exception {
        System.out.println(StringTemplates.LINE);
        System.out.println("START at:   " + DateFormatter.getTime());
        System.out.println(StringTemplates.LINE + "n");

        PropertyReader pr = new PropertyReader();
        Connector conn = new Connector(pr);

        conn.setConnection();

        Resources res = new Resources(conn);
        res.prinResources();

        System.out.println("\n" + StringTemplates.LINE);
        System.out.println("END at: " + DateFormatter.getTime());
        System.out.println(StringTemplates.LINE);
    }
}
