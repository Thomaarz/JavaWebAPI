package fr.thomarz.container.container;

import fr.thomarz.container.WebElement;

public class ContainerDiv extends WebElement {

    public ContainerDiv(String contentMessage) {
        super("div", contentMessage);
    }

    public ContainerDiv() {
        super("div");
    }

}
