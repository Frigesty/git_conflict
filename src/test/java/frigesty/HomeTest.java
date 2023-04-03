package frigesty;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;

public class HomeTest extends TestBase {
    @Test
    void practiceFormTest() {

        String firstName = "Airat",
                lastName = "Karimov",
                number = "9991111000",
                address = "5212 CHURCH AVE BROOKLYN NY 11203-3555 USA",
                email = "test@test.ru",
                year = "1996",
                month = "August",
                day = "2",
                subject = "maths",
                hobbies = "Sports",
                hobbies1 = "Music",
                picture = "duck.jpg",
                state = "NCR",
                city = "Delhi",
                gender = "Male";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userEmail").setValue(email);
        $("#dateOfBirthInput").sendKeys(CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("08.02.1996");
        $("#dateOfBirthInput").pressEnter();
        $("#userNumber").setValue(number);
        $("#subjectsContainer input").setValue(subject).pressEnter();
        $("#currentAddress").setValue(address);
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#hobbiesWrapper").$(byText(hobbies1)).click();
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(number),
                text(day + " " + month + "," + year),
                text(subject),
                text(hobbies),
                text(picture),
                text(address),
                text(state + " " + city)
        );
    }
}