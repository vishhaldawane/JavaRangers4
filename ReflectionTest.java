import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {

        Sample sample = new Sample();


        Class infoOfThisClass = sample.getClass();

        Method methods[] = infoOfThisClass.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("-------------");

        Constructor ctor[] = infoOfThisClass.getConstructors();
        for (Constructor c : ctor) {
            System.out.println(c.getName() + " with "+c.getParameterTypes().length);
        }

    }
}


