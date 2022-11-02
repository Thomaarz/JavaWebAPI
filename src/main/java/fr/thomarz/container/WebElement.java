package fr.thomarz.container;

import fr.thomarz.events.EventType;
import fr.thomarz.events.WebEvent;
import fr.thomarz.identifier.WebIdentifier;
import fr.thomarz.identifier.WebIdentifiers;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public abstract class WebElement {

    public static int uuidAll = 0;

    private Map<EventType, WebEvent> events = new HashMap<>();

    private int uuid;

    private String name;
    private String contentMessage;
    private WebIdentifier webIdentifier;
    private List<WebElement> contents;

    public WebElement(String name, String contentMessage) {
        this(name);
        this.contentMessage = contentMessage;
    }

    public WebElement(String name) {
        this.uuid = uuidAll++;

        this.name = name;
        this.contentMessage = null;
        this.contents = new ArrayList<>();
        this.webIdentifier = new WebIdentifier();
    }

    public WebElement removeContent(WebElement webElement) {
        if (contents.contains(webElement)) {
            contents.remove(webElement);
            return this;
        }
        for (WebElement children : contents) {
            children.removeContent(webElement);
        }
        return this;
    }

    public WebElement addContent(int position, WebElement webElement) {
        contents.add(position, webElement);
        return this;
    }

    public WebElement addContent(WebElement... webElement) {
        contents.addAll(Arrays.asList(webElement));
        return this;
    }

    public WebElement addIdentifier(String key, String value) {
        webIdentifier.addParameter(key, value);
        return this;
    }

    public WebElement addIdentifier(WebIdentifiers key, String value) {
        webIdentifier.addParameter(key, value);
        return this;
    }

    public WebElement addEvent(EventType eventType, WebEvent event) {
        events.put(eventType, event);
        return this;
    }

    public WebElement getElementById(String id) {
        if (getWebIdentifier().get(WebIdentifiers.ID).equalsIgnoreCase(id)) {
            return this;
        }

        for (WebElement children : contents) {
            if (children.getWebIdentifier().get(WebIdentifiers.ID).equalsIgnoreCase(id)) {
                return children;
            }
            if (children.getElementById(id) != null) {
                return children.getElementById(id);
            }
        }

        return null;
    }

    public WebElement getElementByUUID(int id) {
        if (getUuid() == id) {
            return this;
        }

        for (WebElement children : contents) {
            if (children.getUuid() == id) {
                return children;
            }
            if (children.getElementByUUID(id) != null) {
                return children.getElementByUUID(id);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return export(0);
    }

    public String export(int tab) {
        StringBuilder tabulations = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            tabulations.append("\t");
        }
        tab++;

        StringBuilder back = new StringBuilder("<" + name + webIdentifier.toString() + ">\n");
        if (contentMessage != null) {
            back.append(tabulations.toString() + "\t" + contentMessage + "\n");
        } else {
            for (WebElement content : contents) {
                if (tab(content)) {
                    back.append(tabulations.toString() + "\t" + content.export(tab) + "\n");
                } else {
                    back.append(tabulations.toString() + content.export(tab - 1) + "\n");
                }
            }
        }
        back.append(tabulations.toString() + "</" + name + ">");

        return back.toString();
    }

    private boolean tab(WebElement content) {
        return !(content.getName() != null &&
                (content.getName().equalsIgnoreCase("head") || content.getName().equalsIgnoreCase("body"))
        );
    }
}
