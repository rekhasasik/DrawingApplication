Drawing Problem:
JDK 11 has been used to develop the solution
Built the solution as a maven solution.
Additional Feature:
Apart from Create Canvas, Line and Rectangle, one more command H (displays History of commands) is also implemented.
Type H to list history commands.
Type Enter to see the set of available commands.
commands are implemented as case insensitive
Just Pressing Enter shows the supported commands.
input.txt contain sample input.

Import Project:
Import the project as Maven project from any IDE.
Maven -> Update Dependencies.
Run as Maven Build (Goals: install)
Go to the com.sasi.drawing.Application class, and Run it as Java Application from IDE

To Build the Application from command Prompt:
1. mvn clean compile install

To Run the application from command prompt:
2. mvn exec:java -D"exec.mainClass"="com.sasi.drawing.Application" 

Assumptions:
1. The solution is created and tested to run in a single threaded environment.
2. When the x2,y2 coordinates of Line or rectangle exceeds the width and height of Canvas, only the points inside the canvas is printed.
3. Only positive values accepted. A validation error is thrown hn negative values are provided.
4. The collision coordinate (while overlapping) will be updated with the latest shape coordinate. (Since Symbol(x) is same for all shapes. this may not show any impact in the current problem scope).
5. When second time Create Canvas is issued, First Canvas is no longer available. It prints a fresh Canvas
5. Validation of shape for example If the given coordinates actually repesent a rectangle(Like width and height should not be same etc) is not implemented. . Expected that user have to give the coordinates conciously.

Design:
A Class Diagram is available for reference.
Classes and methods are provided with javadoc representing the behaviour.
Application: Main class that takes the input from user.
ICoordinator: A moderator class that coordinates between Canvas and Shape(Line or Rectangle)
IDrawingGrid: Interface represinting a drawing grid in which Shapes can be drawn. Classes like Canvas can implement this interface.
IShape: Solid shapes like Line and Rectangle Implements this interface. 
Coordinator: Implementation of coordinator. Where it provess each input command. and initializes Canvas (which is referred as drawing grid). Whenever a new shape is created, addShape method of IDrawingGrid.
Canvas: Implementation of IDrawingGrid. Contains a drawing board which is 2X2 character matrix whose cells represents the coordinates of shapes. addShape method validates boundaries of shape. if x1 y1 coordinates of a shape is out of width and height of canvas an error message is displayes. If any of x2 y2 coordinates are out of canvas boundary(width and height), only coordinates that are within the boundary of canvas will be displayed.
Point :A class holding x and y coordinates
Range: A class holiding two points i.e, x1 y1 and x2 y2.
Line: A solid implemtation of IShape. getRanges method will fill the list of coordinates that needs to be printed in the drawing board. For a line it is just x1 y1 x2 y2 
Rectangle: Another Implentation of shape. getRanges method will return the list of coordinates of all the 4 walls(lines) of the rectangle.
If any of the shape wants to define a new sybmol it can be provided under getSymbol class. This method can be further extended to take input of a differnt symbol from user.
Junits are written under src/test/java directory.
