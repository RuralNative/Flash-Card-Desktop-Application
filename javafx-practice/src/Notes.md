**LESSON 1**
    The JavaFX Stage is the equivalent of Swing JFrame. It shall serve as the main container for the GUI of the Java application. Meanwhile the JavaFX Scene decorates the Stage for the application. So to create a GUI, a Stage has to be instantiated for the sole purpose of holding the different graphical components of the application's user interface.     
    What about the Group? The Group is the set of nodes of graphical components that is responsible for the actual design of the Scene, which in turn designs the Stage. In my understanding, this meant that every component I might create from the libraries available from JavaFX are basically nodes of that composes a Group object. 
**INSTANTIATION OF IMAGE FOR ICON IN MAIN CLASS**
    In App.java, During the Instantiation of the Image object Necessary for setting the Stage's Icon*
    The value of the Image object is taken by returning the runtime class, through the getClass() method, of the Image URL which is located by finding the resource from the present module through the getResourceAsStream() method. This is a fix to make sure the icon is always shown, contrast to that of simply passing through the file URL as an argument of the Image Constructor .
**SETROOTFORSCENE() METHOD**
    Set the root node for the Scene of the Stage through the use of the loadFXML() method 
**LOADFXML() METHOD**
    Instantiates an FXMLLoader object which loads the FXML file in the resource package of the project. This is done by passing a String parameter - String combination that equates to the FXML path with the method's parameter as name of the file - to the FXMLLoader constructor, which subsequently returns a Parent object to load.