package fr.thomarz.container.orphan;

public class OrphanMeta extends WebElementOrphan {

    private String info;

    public OrphanMeta(String info) {
        super("meta", info);
        this.info = info;
    }

    @Override
    public String export(int tab) {
        return "<" + getName() + " " + info + ">";
    }
}
