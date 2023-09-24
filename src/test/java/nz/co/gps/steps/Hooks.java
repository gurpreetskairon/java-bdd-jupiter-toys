package nz.co.gps.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Hooks {

    public static WebDriver driver;
    public static Properties properties;

    @Before
    public void setup() throws IOException {


        // read the properties
        //properties = new PropertiesHandler().loadProperties("src/test/resources/global.properties");
        properties = new Properties();
        properties.load(Hooks.class.getClassLoader().getResourceAsStream("global.properties"));

        // read from the property file the browse to run the tests on
        String browser = properties.getProperty("BROWSER");
        System.out.println("Browser being passed is: " + browser);

        // create driver object based on the browser requested
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
            case "safari":
                driver = new SafariDriver();
        }
        driver.manage().window().maximize();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
