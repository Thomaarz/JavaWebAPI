package fr.thomarz.container.orphan;

import fr.thomarz.container.WebElement;

public abstract class WebElementOrphan extends WebElement {

    public WebElementOrphan(String name, String contentMessage) {
        super(name, contentMessage);
    }

    public WebElementOrphan(String name) {
        super(name);
    }

    @Override
    public String export(int tab) {
        return "<" + getName() + getWebIdentifier() + ">";
    }
}
