# Custom Class Loader Example

## Overview

This project demonstrates a simple implementation of a custom class loader in Java. The custom class loader allows you to load classes from a specified directory instead of the default classpath. This can be especially useful for applications that need to load plugins or modules dynamically.

## Project Structure

TO run tha app you need to push 

## javac -d out src/CustomClassLoader.java src/TestClass.java

## java -cp out CustomClassLoader TestClass




Types of Classloaders in Java
Bootstrap Classloader
Loads all the Java core libraries, primarily from the java.lang package.
Extension Classloader
Loads classes defined in the JDK_HOME\lib\ext directory.
System Classloader
Loads classes from the CLASSPATH.
Additional Notes
Classloaders are crucial in Java for loading classes and managing namespaces.
The classes you write in your program and any classes from imported JARs are loaded by the system classloader.