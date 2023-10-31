package pages;
import static steps.Hooks.*;

public class HomePage extends Header{

    public HomePage(){

        this.navigate();
    }

    public void navigate(){

        driver.get(properties.getProperty("URL"));
    }
}
