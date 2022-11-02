<h1>JavaWebAPI</h1>
An easy java api to create html webpage.
Required org.projectlombok dependency.

<h1>Main Class & Generate Default Page</h1>


```java
public class Main {

    public static void main(String[] args) {
    
        // Create the default page with selected language
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

<h1>Usefull Methods</h1>


```java
// Your HTMLPage Object
HTMLPage htmlPage;
        
// Get the head balise
WebElement head = htmlPage.getHead();

// Get the body balise
WebElement body = htmlPage.getBody();
        
   
// Create a <div>
WebElement myDiv = new ContainerDiv()
        .addIdentifier(WebIdentifiers.ID, "myId");
        
// Create a <p>
WebElement myP = new ContainerP("This is the text in the <p> !")
        .addIdentifier(WebIdentifiers.ID, "myP");
        
        
// Add myP in myDiv
myDiv.addContent(myP);

// Add myDiv in body
body.addContent(myDiv);


// Get a balise with an ID (It will search an element withe the id "myId" for each children of "htmlPage"
WebElement myElement = htmlPage.getElementById("myId");

```
