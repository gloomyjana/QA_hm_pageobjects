package pages;

import pages.components.RegistrationResultsModal;

public class ModalPage {
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public ModalPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public ModalPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
