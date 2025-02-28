import org.junit.Test;

import static org.junit.Assert.*;

public class CustomClassLoaderTest {

    @Test
    public void findClass() throws ClassNotFoundException {
        // Arrange
        String classPath = "out"; // Path where compiled classes are located
        CustomClassLoader loader = new CustomClassLoader(classPath);

        // Act
        Class<?> loadedClass = loader.loadClass("TestClass");

        // Assert
        assertNotNull(" class loaded", loadedClass);
        assertEquals("class  match", "TestClass", loadedClass.getSimpleName());
    }
}
