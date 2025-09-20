package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {

    List<Person> table1 = new ArrayList<>();    @BeforeClass
    void getTable1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
        .forEach(row -> {
            String firstName = row.findElement(By.xpath("./td[2]")).getText();
            String lastName = row.findElement(By.xpath("./td[1]")).getText();
            String due = row.findElement(By.xpath("./td[4]")).getText();
            table1.add(new Person(firstName, lastName, due));
        });
        driver.quit();
    }

    @Test
    void verifyLargestDuePerson() {
        double maxDue = table1.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> maxDuePerson = table1.stream().filter(person -> person.getDue() == maxDue).map(Person::getFullName).toList();
        Assert.assertEquals(maxDuePerson, List.of("Jason Doe"));
    }

    @Test
    void verifyMinDuePerson() {
        double minDue = table1.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> minDuePerson = table1.stream().filter(person -> person.getDue() == minDue).map(Person::getFullName).toList();
        Assert.assertEquals(minDuePerson, List.of("John Smith","Tim Conway"));
    }

}
