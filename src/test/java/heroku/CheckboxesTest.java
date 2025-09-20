package heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxesTest {
    /**
     *
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/checkboxes
     3. Check on checkbox1
     4. Verify checkbox1 is checked
     5. Check on checkbox2
     6. Verify checkbox2 is checked
     */
    @Test
    void tc02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");


    }
}
