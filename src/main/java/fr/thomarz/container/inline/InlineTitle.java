package fr.thomarz.container.inline;

public class InlineTitle extends WebElementInline {

    private String content;

    public InlineTitle(String content) {
        super("title", content);
        this.content = content;
    }
}
