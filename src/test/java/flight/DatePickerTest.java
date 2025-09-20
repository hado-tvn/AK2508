package flight;

import base.BaseTest;
import flight.pages.FlightPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static common.Utils.getDateAsString;
import static common.Utils.getDateInFuture;

public class DatePickerTest extends BaseTest {

    @Test
    void verifySelectDepartDateSuccessfully() {
        LocalDate next2Week = getDateInFuture(2);

        FlightPage flightPage = new FlightPage();
        flightPage
                .open()
                .selectDepartDate(next2Week);

        String departDate = flightPage.getSelectedDepartDate();
        Assert.assertEquals(departDate, getDateAsString(next2Week));
    }
}

