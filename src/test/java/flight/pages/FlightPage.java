package flight.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

import static common.Browser.*;

public class FlightPage {
    By departDatePicker = By.id("roundtrip-date-depart");
    By calendarMonthTable = By.className("ui-datepicker-calendar");
    By acceptCookieButton =By.id("cookie-agree");

    public FlightPage open() {
        visit("https://www.vietnamairlines.com/vn/vi/home");
        click(acceptCookieButton);
        return this;
    }

    public void selectDepartDate(LocalDate departDate) {
        click(departDatePicker);
        LocalDate today = LocalDate.now();
        WebElement departMonthTable;
        try {
            if (today.getMonthValue() < departDate.getMonthValue()) {
                departMonthTable = findAll(calendarMonthTable)
                        .get(1);
            } else {
                departMonthTable = findAll(calendarMonthTable)
                        .getFirst();
            }
            departMonthTable.findElements(By.xpath("./tbody/tr/td/a"))
                    .forEach(dateCell -> {
                        if (dateCell.getText().contains(String.valueOf(departDate.getDayOfMonth()))) dateCell.click();
                    });
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public String getSelectedDepartDate() {
        return getValue(departDatePicker);
    }
}
