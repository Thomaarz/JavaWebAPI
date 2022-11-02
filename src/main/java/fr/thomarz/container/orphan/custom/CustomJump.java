package fr.thomarz.container.orphan.custom;

import fr.thomarz.container.orphan.WebElementOrphan;

public class CustomJump extends WebElementOrphan {

    public CustomJump() {
        super(null);
    }

    @Override
    public String export(int tab) {
        return "";
    }
}

