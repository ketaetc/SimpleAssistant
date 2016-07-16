package ketaetc.travian.html;

import ketaetc.travian.util.StringTemplates;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.HashMap;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * Date: 15.07.16 1:35
 */
public class ResourcesInfo {
    private final String WOOD = "wood";
    private final String CLAY = "clay";
    private final String IRON = "iron";
    private final String WHEAT = "wheat";
    private Map<String, Integer> resources = new HashMap<>();

    private int wood = 0;
    private int clay = 0;
    private int iron = 0;
    private int wheat = 0;

    Connector conn;

    public ResourcesInfo(Connector conn) {
        this.conn = conn;

        try {
            resources.put(WOOD, (findResource(WOOD) >= 0 ? findResource(WOOD) : -1));
            resources.put(CLAY, (findResource(CLAY) >= 0 ? findResource(CLAY) : -1));
            resources.put(IRON, (findResource(IRON) >= 0 ? findResource(IRON) : -1));
            resources.put(WHEAT, (findResource(WHEAT) >= 0 ? findResource(WHEAT) : -1));
        } catch (Exception e) {
            e.printStackTrace();
            StringTemplates.pringSGW();
        }
        wood = resources.get(WOOD);
        clay = resources.get(CLAY);
        iron = resources.get(IRON);
        wheat = resources.get(WHEAT);
    }

    int findResource(String s) {
        int resource;

        if (s.equals("wood")) {
            resource = Integer.parseInt(conn.getDriver().findElement(By.id("l1")).getText()
                    .replace(".", ""));
        } else if (s.equals("clay")) {
            resource = Integer.parseInt(conn.getDriver().findElement(By.id("l2")).getText()
                    .replace(".", ""));
        } else if (s.equals("iron")) {
            resource = Integer.parseInt(conn.getDriver().findElement(By.id("l3")).getText()
                    .replace(".", ""));
        } else if (s.equals("wheat")) {
            resource = Integer.parseInt(conn.getDriver().findElement(By.id("l4")).getText()
                    .replace(".", ""));
        } else {
            resource = -1;
        }
        return resource;
    }

    public void prinResources() {
        System.out.println(StringTemplates.LINE);
        System.out.println("WOOD: " + wood + "\n"
                           + "CLAY: " + clay + "\n"
                           + "IRON: " + iron + "\n"
                           + "WHEAT: " + wheat);
        System.out.println(StringTemplates.LINE);
    }

    public int getWood() {
        System.out.println(StringTemplates.LINE);
        return this.wood;
    }

    public int getClay() {
        System.out.println(StringTemplates.LINE);
        return this.clay;
    }

    public int getIron() {
        System.out.println(StringTemplates.LINE);
        return this.iron;
    }

    public int getWheat() {
        System.out.println(StringTemplates.LINE);
        return this.wheat;
    }
}
