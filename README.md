<h1>JavaWebAPI</h1>
An easy java api to create html webpage.
Required org.projectlombok dependency.

<h1>I) Main Class & Generate Default Page</h1>


```java
public class Main {

    public static void main(String[] args) {
    
        // Create the default page with selected language
        HTMLPage htmlPage = new HTMLPage("en");
        
        // Create the directories
        ExporterUtils.initDirectories();
        
        // Generate the index.html file based on htmlPage value (Call this method after editing htmlPage object)
        ExporterUtils.createFile(htmlPage);
	
	// You can also create another html file with custom name/path
	String path = "test/test.html";
	// /!\ The file will always be created in "export/website/" + your path 
	// /!\ The folders have to be created before
	ExporterUtils.createFile(htmlPage, path);
	// In this case, the output path will be "export/website/test/test.html"
    }
}
```

<h1>II) Usefull Methods & Result</h1>
<h2>Usefull Methods</h2>

```java
// Your HTMLPage Object
HTMLPage htmlPage;
        
// Get the head balise
WebElement head = htmlPage.getHead();

// Get the body balise
WebElement body = htmlPage.getBody();
        
   
// Create a <div> with id="myDiv"
WebElement myDiv = new ContainerDiv()
        .addIdentifier(WebIdentifiers.ID, "myId");
        
// Create a <p> with id="myP"
WebElement myP = new ContainerP("This is the text in the <p> !")
        .addIdentifier(WebIdentifiers.ID, "myP");
	
// Create a comment
CustomCommentary comment = new CustomCommentary("This is a test !");
        
// Add comment and myP in myDiv
myDiv.addContent(comment, myP);

// Advice
// You can add one or several WebElement at the same time
// myDiv.addContent(element1, element2, ...);
// You can do this to add few elements in a container for example.

// Add myDiv in body
body.addContent(myDiv);


// Get a balise with an ID (It will search an element with the id "myId" for each children of "htmlPage"
WebElement myElement = htmlPage.getElementById("myP");

// When a WebElement is created, he has an unique id, so you can also retrieve an element by this id
WebElement myElementById = htmlPage.getElementByUUID(10);

// You can now get all children of your element
List<WebElement> elements = myElement.getContents();

// You can also edit the content of your element
myElement.setContentMessage("This is the new text !");

// You can add Identifiers to your element
myElement.addIdentifier("id", "theNewId");
myElement.addIdentifier("class", "myFirstClass anotherClass");
myElement.addIdentifier("style", "background-color: red; font-size: 12px");

// You can add some events to your element
// If you click on your element, this will execute this method
myElement.addEvent(EventType.CLICK, new WebEvent() {
    @Override
    public void action(WebElement element) {
    
    	// Do some stuff...
        element.setContentMessage("You just clicked !");
    }
});

```

<h2>Result</h2>

The result will automatically generate the following directories and files:

![image](https://user-images.githubusercontent.com/49363524/199590883-c2c422d0-de88-4b11-929e-b6477802f3aa.png)


The html file will also automatically generate tabulations, etc...

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
    <!-- Infos -->
    <title>Title</title>
	
    <!-- Links -->
    <link href="style/my_style.css">
</head>
<body>
    <div id="myId">
        <!-- This is a test ! -->
        <p style="background-color: red; font-size: 12px" id="theNewId" class="myFirstClass anotherClass">
            This is the new text !
        </p>
    </div>
</body>
</html>
```
