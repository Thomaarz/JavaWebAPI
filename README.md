<h1>JavaWebAPI</h1>
An easy java api to create html webpage.
Required org.projectlombok dependency.

<h1>Main Class & Generate Default Page</h1>


```java
public class Main {

    public static void main(String[] args) {
    
        // Create the default page (with head, body)
        HTMLPage htmlPage = new HTMLPage("en");
        
        // Create the directories
        ExporterUtils.initDirectories();
        
        // Create the files
        ExporterUtils.initFiles();
        
        // Generate the index.html file based on htmlPage value (Call this method after editing htmlPage object)
        ExporterUtils.createFile(htmlPage);
    }
}
```

<h1>Default Page</h1>

```java
    // Create the default page (with head, body)
    HTMLPage htmlPage = new HTMLPage("en");
        
    // Get the head balise
    WebElement head = htmlPage.getHead();

    // Get the body balise
    WebElement body = htmlPage.getBody();
        
    
        body.addContent(
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
```
