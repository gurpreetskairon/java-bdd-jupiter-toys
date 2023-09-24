package nz.co.gps.pages;
import static nz.co.gps.steps.Hooks.*;

public class HomePage extends Header{

    public HomePage(){

        this.navigate();
    }

    public void navigate(){

        driver.get(properties.getProperty("URL"));
    }
}
