package ketaetc.travian.html;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import ketaetc.travian.util.PropertyReader;
import ketaetc.travian.util.StringTemplates;
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
    private String targetUrl;

    final String USER_AGENT_L = "Mozilla/5.0 (X11; Linux x86_64)"
                                + " AppleWebKit/537.36 (KHTML, like Gecko)"
                                + " Ubuntu Chromium/51.0.2704.79 Chrome/51.0.2704.79 Safari/537.36";
    final String DORF_1 = "/dorf1.php";
    final String DORF_2 = "/dorf2.php";

    public Connector(String login, String password, String url) throws Exception {
        handleParam(login);
        handleParam(password);
        handleParam(url);

        this.login = login;
        this.password = password;
        this.url = url;
    }

    public Connector(PropertyReader pr) {
        this.login = pr.getLogin();
        this.password = pr.getPassword();
        this.url = pr.getUrl();
    }

    private void handleParam(String p) throws Exception {
        if (p == null || p.equals("") || p.trim().length() == 0) {
            throw new Exception("Parameter " + p + " shouldn't be null!");
        }
    }

    public void setConnection() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
                .setLevel(java.util.logging.Level.OFF);

        wd = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
        wd.getBrowserVersion().setUserAgent(USER_AGENT_L);
        wd.setJavascriptEnabled(true);
        wd.get(this.url);

        tryToLogin();
    }

    public void closeBrowser() {
        wd.close();
        wd.quit();
    }

    public void tryToLogin() {
        try {
            wd.findElement(By.xpath("//input[@name='name']")).sendKeys(this.login);
            wd.findElement(By.xpath("//input[@name='password']")).sendKeys(this.password);
            wd.findElement(By.xpath("//*[@name='lowRes']")).sendKeys("1");
            wd.findElement(By.xpath("//button[@type='submit']")).click();
        } catch (Exception e) {
            e.printStackTrace();
            StringTemplates.pringSGW();
        }
    }

    public HtmlUnitDriver getDriver() {
        return wd;
    }
}
