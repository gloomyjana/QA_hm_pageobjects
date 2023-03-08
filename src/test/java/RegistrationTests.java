import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationTests {
    @Test
    void fillRegistrationFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("5553331234");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").$(byText("1990")).click();
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__month-container").$(byText("22")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/pic.jpg"));
        $("#currentAddress").setValue("Current Address");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("John Doe"), text("johndoe@gmail.com"), text("Male"),
                text("5553331234"), text("22 April,1990"), text("Arts, Physics"), text("Music"), text("pic.jpg"),
                text("Current Address"), text("Rajasthan Jaiselmer"));

        $("#closeLargeModal").click();
    }
}
