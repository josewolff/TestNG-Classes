package generateXmlFile;

/**
 * Created by josea.wolff on 3/14/19.
 */
public class ConfigurationFile {

    private String env;
    private String host;
    private String seleniumHost;
    private String browser;

    public String getEnv() { return env; }

    public String getHost(){
        return host;
    }

    public String getSeleniumHost() {
        return seleniumHost;
    }

    public String getBrowser() { return  browser;}
}
