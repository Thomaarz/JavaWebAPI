package fr.thomarz.container.container;

import fr.thomarz.container.WebElement;

public class ContainerBalise extends WebElement {

    public ContainerBalise(String name) {
        super(name);
    }

    public ContainerBalise(String name, String contentMessage) {
        super(name, contentMessage);
    }

}
