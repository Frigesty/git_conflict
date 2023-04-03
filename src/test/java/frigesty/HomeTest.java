package frigesty;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeTest extends TestBase {
    @Test
    void practiceFormTest() {

        String firstName = "Airat",
                lastName = "Karimov",
                number = "9991111000",
                address = "5212 CHURCH AVE BROOKLYN NY 11203-3555 USA",
                email = "test@test.ru",
                year = "1996",
                moth = "August",
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
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-select").$(byText(moth)).click();
        $(".react-datepicker__day--00" + day).click();
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
