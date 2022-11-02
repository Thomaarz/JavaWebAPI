package fr.thomarz;

import fr.thomarz.container.HTMLPage;
import fr.thomarz.container.container.ContainerDiv;
import fr.thomarz.container.container.ContainerP;
import fr.thomarz.exporter.ExporterUtils;

public class Main {

    public static void main(String[] args) {
        HTMLPage htmlPage = new HTMLPage("en");

        htmlPage.getBody().addContent(
                new ContainerDiv()
                .addContent(
                        new ContainerDiv()
                        .addContent(
                                new ContainerP("eu")
                        )
                )
        );

        ExporterUtils.initDirectories();
        ExporterUtils.initFiles();
        ExporterUtils.createFile(htmlPage);
    }
}
