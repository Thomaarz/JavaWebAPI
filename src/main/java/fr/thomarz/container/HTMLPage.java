package fr.thomarz.container;

import fr.thomarz.container.container.ContainerBalise;
import fr.thomarz.container.inline.InlineTitle;
import fr.thomarz.container.orphan.OrphanLink;
import fr.thomarz.container.orphan.OrphanMeta;
import fr.thomarz.container.orphan.custom.CustomCommentary;
import fr.thomarz.container.orphan.custom.CustomJump;
import lombok.Getter;

@Getter
public class HTMLPage extends WebElement {

    private WebElement head;
    private WebElement body;

    private InlineTitle title;

    public HTMLPage(String lang) {
        super("html");
        getWebIdentifier().addParameter("lang", lang);

        title = new InlineTitle("Title");

        head = new ContainerBalise("head")
                .addContent(
                        new CustomCommentary("Meta"),
                        new OrphanMeta("charset=\"UTF-8\""),
                        new OrphanMeta("http-equiv=\"X-UA-Compatible\" content=\"ie=edge\""),
                        new OrphanMeta("name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\""),
                        new CustomJump(),
                        new CustomCommentary("Infos"),
                        title,
                        new CustomJump(),
                        new CustomCommentary("Links"),
                        new OrphanLink("style/my_style.css")
                );

        body = new ContainerBalise("body");

        addContent(head, body);
    }

    @Override
    public String export(int tab) {
        return "<!DOCTYPE html>\n" +
                super.export(tab);
    }
}
