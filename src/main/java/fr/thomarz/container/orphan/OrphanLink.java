package fr.thomarz.container.orphan;

public class OrphanLink extends WebElementOrphan {

    public OrphanLink(String url) {
        super("link");
        getWebIdentifier().addParameter("href", url);
    }
}
