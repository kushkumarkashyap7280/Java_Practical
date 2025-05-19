# Java Practical Exercises

This repository contains implementations of various Java practical exercises covering topics such as:
- Object-oriented programming
- Inheritance and polymorphism
- Packages
- Exception handling
- File handling
- Swing GUI programming

## Project Structure
Each practical is organized in its own package/folder for clarity.

## How to Compile and Run
Each practical can be compiled and run using standard Java commands:

```
javac <filename>.java
java <classname>
```

For programs with packages, use:
```
javac -d . <filename>.java
java <packagename>.<classname>
```

## Practical Exercises

### Practical 1: Complex Number Operations
**Location**: `practical1/Complex.java`

**Description**:
Implements a class `Complex` with real and imaginary parts that supports:
- Addition and multiplication of complex numbers
- String representation in the form x + iy

**How to Run**:
```
javac -d . practical1/Complex.java
java practical1.Complex
```

### Practical 2: Package and Inheritance (2D and 3D Coordinates)
**Location**: 
- `practical2/P1/TwoDim.java`
- `practical2/P2/ThreeDim.java`
- `practical2/P/Main.java`

**Description**:
Demonstrates package creation and inheritance:
- `TwoDim` class in package P1 with x,y coordinates
- `ThreeDim` class in package P2 extending TwoDim, adding z coordinate
- Main class in package P showing dynamic method dispatch

**How to Run**:
```
javac -d . practical2/P1/TwoDim.java practical2/P2/ThreeDim.java practical2/P/Main.java
java P.Main
```

### Practical 3: Abstract Classes and Dynamic Method Dispatch
**Location**: 
- `practical3/P1/Shape.java`
- `practical3/P2/Rectangle.java`
- `practical3/P3/Circle.java`
- `practical3/Main.java`

**Description**:
Demonstrates abstract classes and dynamic method dispatch:
- Abstract class `Shape` in package P1
- `Rectangle` class in package P2 extending Shape
- `Circle` class in package P3 extending Shape
- Main class (not in any package) using dynamic method dispatch to calculate area

**How to Run**:
```
javac -d . practical3/P1/Shape.java practical3/P2/Rectangle.java practical3/P3/Circle.java practical3/Main.java
java Main
```

### Practical 4: Custom Exception Handling
**Location**: 
- `practical4/UnderAge.java`
- `practical4/ExceptionDemo.java`

**Description**:
Creates a custom exception class `UnderAge` that is thrown when age is less than 18.

**How to Run**:
```
javac -d . practical4/UnderAge.java practical4/ExceptionDemo.java
java practical4.ExceptionDemo
```

### Practical 6: File Copy Program
**Location**: `practical6/FileCopy.java`

**Description**:
Copies content from one file to another using command-line arguments for file names.

**How to Run**:
```
javac -d . practical6/FileCopy.java
java practical6.FileCopy source.txt destination.txt
```

### Practical 7: Comment Line Reader
**Location**: `practical7/CommentReader.java`

**Description**:
Reads a file and displays only those lines that start with "//" (comment lines).
Uses try-with-resources for automatic resource management.

**How to Run**:
```
javac -d . practical7/CommentReader.java
java practical7.CommentReader
```
Then enter the path to the file when prompted.

### Practical 8: Mouse Event Handling
**Location**: `practical8/MouseEventDemo.java`

**Description**:
A Swing application that demonstrates mouse events:
- Shows a frame when mouse enters the main panel
- Hides the frame when mouse exits the main panel
- Displays mouse click coordinates

**How to Run**:
```
javac -d . practical8/MouseEventDemo.java
java practical8.MouseEventDemo
```

### Practical 9: Pink Background Frame
**Location**: `practical9/PinkBackgroundFrame.java`

**Description**:
A simple Swing application that displays a string in a frame window with pink background.

**How to Run**:
```
javac -d . practical9/PinkBackgroundFrame.java
java practical9.PinkBackgroundFrame
```

### Practical 10: Color Buttons Demo
**Location**: `practical10/ColorButtonsDemo.java`

**Description**:
A Swing application with two buttons named "Red" and "Blue" that change the background color of the panel when clicked.

**How to Run**:
```
javac -d . practical10/ColorButtonsDemo.java
java practical10.ColorButtonsDemo
```

### Practical 11: Key Event Handling
**Location**: `practical11/KeyEventDemo.java`

**Description**:
A Swing application that responds to KEY_TYPED events and updates a status window with the message "Typed character is: X".
Uses adapter class for other key events.

**How to Run**:
```
javac -d . practical11/KeyEventDemo.java
java practical11.KeyEventDemo
```

### Practical 12: Information Display Buttons
**Location**: `practical12/InfoButtonsDemo.java`

**Description**:
A Swing application with two buttons labeled 'A' and 'B':
- Button A displays personal information (name, course, roll number, college)
- Button B displays CGPA information

**How to Run**:
```
javac -d . practical12/InfoButtonsDemo.java
java practical12.InfoButtonsDemo
```

### Practical 13: Scrolling Banner
**Location**: `practical13/ScrollingBannerDemo.java`

**Description**:
A Swing application that creates a banner and scrolls a message from left to right across the window using a separate thread.

**How to Run**:
```
javac -d . practical13/ScrollingBannerDemo.java
java practical13.ScrollingBannerDemo
```

### Practical 14: Comprehensive Swing Demo
**Location**: `practical14/ComprehensiveSwingDemo.java`

**Description**:
A comprehensive Swing application that combines various GUI elements from previous exercises:
- Tabbed interface with different demo panels
- Color changing functionality
- Event handling (mouse and keyboard)
- Information display
- Scrolling banner
- Menu system

**How to Run**:
```
javac -d . practical14/ComprehensiveSwingDemo.java
java practical14.ComprehensiveSwingDemo
```
