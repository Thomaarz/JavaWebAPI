package fr.thomarz.container.orphan.custom;

import fr.thomarz.container.orphan.WebElementOrphan;

public class CustomCommentary extends WebElementOrphan {

    private String commentary;

    public CustomCommentary(String commentary) {
        super(null);
        this.commentary = commentary;
    }

    @Override
    public String export(int tab) {
        return "<!-- " + commentary + " -->";
    }
}

