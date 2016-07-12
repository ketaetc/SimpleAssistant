package ketaetc.travian.html;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import ketaetc.travian.util.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * Date: 13.07.16 1:07
 */
public class Connector {

    private String login;
    private String password;
    private String url;

    private int wood;
    private int clay;
    private int iron;
    private int wheat;

    private HtmlUnitDriver wd;

    final String USER_AGENT_L = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)" +
            " Ubuntu Chromium/51.0.2704.79 Chrome/51.0.2704.79 Safari/537.36";
    final String USER_AGENT_W = "";


    public Connector (String login, String password, String url) throws Exception {

        handleParam(login);
        handleParam(password);
        handleParam(url);


        this.login = login;
        this.password = password;
        this.url = url;

        System.out.println("LOGIN:  " + login + "\n"
                + "PASSWORD:    " + password + "\n"
                + "URL: " + url);

    }

    public Connector (PropertyReader pr) {

        this.login =  pr.getLogin();
        this.password = pr.getPassword();
        this.url = pr.getUrl();

        System.out.println("LOGIN:  " + this.login + "\n"
                + "PASSWORD:    " + this.password + "\n"
                + "URL: " + this.url);

    }

    private void handleParam (String p) throws Exception {
        if (p == null || p.equals("") || p.trim().length() == 0) {
            throw new Exception("Параметр " + p + " не должен быть пустым");
        }
    }

    public void setConnection () {

        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);

//        wd = new HtmlUnitDriver(new BrowserVersion("Firefox", "5.0", USER_AGENT_L, 47.0f), true);
        wd = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        wd.getBrowserVersion().setUserAgent(USER_AGENT_L);
        wd.setJavascriptEnabled(true);

//        wd.navigate().to(this.url);
        wd.get(this.url);

    }

    public void closeBrowser () {
        wd.close();
        wd.quit();
    }

    public void tryToLogin () {

        wd.findElement(By.xpath("//input[@name='name']")).sendKeys(this.login);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(this.password);
        wd.findElement(By.xpath("//*[@name='lowRes']")).sendKeys("1");
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public void getResources () {

        this.wood = Integer.parseInt(wd.findElement(By.id("l1")).getText().replace(".", ""));
        this.clay = Integer.parseInt(wd.findElement(By.id("l2")).getText().replace(".", ""));
        this.iron = Integer.parseInt(wd.findElement(By.id("l3")).getText().replace(".", ""));
        this.wheat = Integer.parseInt(wd.findElement(By.id("l4")).getText().replace(".", ""));

    }

    public int getWood () {
        return this.wood;
    }

    public int getClay () {
        return this.clay;
    }

    public int getIron () {
        return this.iron;
    }

    public int getWheat () {
        return this.wheat;
    }




}
