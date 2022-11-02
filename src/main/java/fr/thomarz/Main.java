package fr.thomarz;

import fr.thomarz.container.HTMLPage;
import fr.thomarz.container.WebElement;
import fr.thomarz.container.container.ContainerDiv;
import fr.thomarz.container.container.ContainerP;
import fr.thomarz.events.EventType;
import fr.thomarz.events.WebEvent;
import fr.thomarz.exporter.ExporterUtils;
import fr.thomarz.identifier.WebIdentifiers;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create the default page with selected language
        HTMLPage htmlPage = new HTMLPage("en");

        // Create the directories
        ExporterUtils.initDirectories();

        // Generate the index.html file based on htmlPage value (Call this method after editing htmlPage object)
        ExporterUtils.createFile(htmlPage, "test.html");

        htmlPage.getElementByUUID(10);

        WebElement element = null;
        element.addEvent(EventType.CLICK, new WebEvent() {
            @Override
            public void action(WebElement element) {
                element.setContentMessage("You just clicked !");
            }
        });
    }
}
