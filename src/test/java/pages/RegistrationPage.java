package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement FIRSTNAME_INPUT = $("#firstName"),
            LASTNAME_INPUT = $("#lastName"),
            USER_EMAIL_INPUT = $("#userEmail"),
            USER_GENDER_INPUT = $("#genterWrapper"),
            USER_NUMBER_INPUT = $("#userNumber"),
            DATE_OF_BIRTH_INPUT = $("#dateOfBirthInput"),
            SUBJECT_INPUT = $("#subjectsInput"),
            HOBBY_INPUT = $("#hobbiesWrapper"),
            UPLOAD_PICTURE_INPUT = $("#uploadPicture"),
            CURRENT_ADDRESS_INPUT = $("#currentAddress"),
            STATE_INPUT = $("#react-select-3-input"),
            CITY_INPUT = $("#react-select-4-input"),
            SUBMIT_BUTTON = $("#submit");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        FIRSTNAME_INPUT.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        LASTNAME_INPUT.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        USER_EMAIL_INPUT.setValue(email);
        return this;
    }

    public RegistrationPage setUserGender(String gender) {
        USER_GENDER_INPUT.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        USER_NUMBER_INPUT.setValue(number);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        DATE_OF_BIRTH_INPUT.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        SUBJECT_INPUT.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        HOBBY_INPUT.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String pathName) {
        UPLOAD_PICTURE_INPUT.uploadFile(new File(pathName));
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        CURRENT_ADDRESS_INPUT.setValue(address);
        return this;
    }

    public RegistrationPage setState(String stateName) {
        STATE_INPUT.setValue(stateName).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String cityName) {
        CITY_INPUT.setValue(cityName).pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        SUBMIT_BUTTON.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
