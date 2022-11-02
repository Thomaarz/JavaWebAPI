package fr.thomarz.exporter;

import fr.thomarz.container.HTMLPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExporterUtils {

    public static final String INFO = "[INFO]";
    public static final String ERROR = "[ERROR]";

    public static final String EXPORT_PATH = "export/website/";

    public static void initDirectories() {
        List<File> directories = new ArrayList<>();

        File home = new File(EXPORT_PATH);
        File style = new File(EXPORT_PATH + "style");
        File scripts = new File(EXPORT_PATH + "scripts");

        directories.add(home);
        directories.add(style);
        directories.add(scripts);

        for (File directory : directories) {
            directory.mkdirs();
        }
    }

    public static void createFile(HTMLPage htmlPage) {
        createFile(htmlPage, "index.html");
    }

    public static void createFile(HTMLPage htmlPage, String fileName) {
        File file = new File(EXPORT_PATH + fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(INFO + " Created " + file.getName() + " file !");
            } catch (IOException e) {
                System.out.println(INFO + " " + file.getName() + " already exist");
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String text = htmlPage.toString();
            String[] lines = text.split("\n");

            for (String line : lines) {
                printWriter.println(line);
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
