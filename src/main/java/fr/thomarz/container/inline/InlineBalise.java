package fr.thomarz.container.inline;

public class InlineBalise extends WebElementInline {

    private String content;

    public InlineBalise(String name, String content) {
        super(name, content);
        this.content = content;
    }
}
