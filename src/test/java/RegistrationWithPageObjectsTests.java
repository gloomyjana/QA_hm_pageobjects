import org.junit.jupiter.api.Test;
import pages.ModalPage;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalPage modalPage = new ModalPage();

    @Test
    void successfulRegistrationFormTest() {
        String firstname = "John", lastname = "Doe",
                email = "johndoe@gmail.com",
                gender = "Male",
                number = "5553331234",
                year = "1990", month = "April", day = "22",
                subject1 = "Arts", subject2 = "Physics",
                hobby = "Music",
                pathname = "src/test/resources/pictures/pic.jpg",
                address = "Current Address",
                stateName = "Rajasthan", cityName = "Jaiselmer";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(number)
                .setBirthDate(day, month, year)
                .setSubject(subject1).setSubject(subject2)
                .setHobby(hobby)
                .uploadPicture(pathname)
                .setCurrentAddress(address)
                .setState(stateName)
                .setCity(cityName)
                .submitForm();

        modalPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstname + " " + lastname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject1 + ", " + subject2)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "pic.jpg")
                .verifyResult("Address", address)
                .verifyResult("State and City", stateName + " " + cityName);
    }
}
