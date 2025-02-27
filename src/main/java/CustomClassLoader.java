import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {
    private final String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = classPath + File.separator + name.replace('.', File.separatorChar) + ".class";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            byte[] classData = new byte[inputStream.available()];
            inputStream.read(classData);
            inputStream.close();
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class not found: " + name);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please provide the class name to load.");
            return;
        }


        CustomClassLoader loader = new CustomClassLoader("out");
        Class<?> clazz = loader.loadClass(args[0]);
        Method mainMethod = clazz.getMethod("main", String[].class);
        String[] mainArgs = {};
        mainMethod.invoke(null, (Object) mainArgs);
    }
}