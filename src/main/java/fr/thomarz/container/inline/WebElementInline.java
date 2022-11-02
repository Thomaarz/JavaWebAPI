package fr.thomarz.container.inline;

import fr.thomarz.container.WebElement;

public abstract class WebElementInline extends WebElement {

    public WebElementInline(String name, String contentMessage) {
        super(name, contentMessage);
    }

    @Override
    public String export(int tab) {
        return "<" + getName() + getWebIdentifier() + ">" + getContentMessage() + "</" + getName() + ">";
    }
}
