package fr.thomarz.container.container;

import fr.thomarz.container.WebElement;

public class ContainerP extends WebElement {

    public ContainerP(String contentMessage) {
        super("p", contentMessage);
    }

    public ContainerP() {
        super("p");
    }
}
