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
        
        // Create the files
        ExporterUtils.initFiles();
        
        // Generate the index.html file based on htmlPage value (Call this method after editing htmlPage object)
        ExporterUtils.createFile(htmlPage);
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

// You can now get all children of your element
List<WebElement> elements = myElement.getContents();

// You can also edit the content of your element
myElement.setContentMessage("This is the new text !");

// You can add Identifiers
myElement.addIdentifier("id", "theNewId");
myElement.addIdentifier("class", "myFirstClass anotherClass");
myElement.addIdentifier("style", "background-color: red; font-size: 12px");

```

<h2>Result</h2>

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
	<div style="background-color: red; font-size: 12px" id="myId" class="myFirstClass anotherClass">
		<p id="myP">
			This is the text in the <p> !
		</p>
	</div>
</body>
</html>
```
