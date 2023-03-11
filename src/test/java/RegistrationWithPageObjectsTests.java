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
                subjects_str = "Arts, Physics",
                hobbies_str = "Music, Sports",
                pathname = "src/test/resources/pictures/pic.jpg",
                address = "Current Address",
                stateName = "Rajasthan", cityName = "Jaiselmer";
        String[] subjects = subjects_str.split(", "),
                hobbies = hobbies_str.split(", ");

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
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
                .verifyResult("Subjects", subjects_str)
                .verifyResult("Hobbies", hobbies_str)
                .verifyResult("Picture", "pic.jpg")
                .verifyResult("Address", address)
                .verifyResult("State and City", stateName + " " + cityName);
    }
}
