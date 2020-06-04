import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyTester {

    public static void start(Class myTest) throws InvocationTargetException, IllegalAccessException {
        List<Method> mList = new ArrayList<Method>();
        Method[] methods = myTest.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class))
                mList.add(m);
        }
        mList.sort(new Comparator<Method>() {
            public int compare(Method m1, Method m2) {
                return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();
            }
        });
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (mList.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("Duplicated '@BeforeSuite'");
                mList.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (mList.get(mList.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("Duplicated '@AfterSuite'");
                mList.add(mList.size(), m);
            }
        }
        for (Method m : mList) {
                m.invoke(null);
        }
    }

    public static void assertArrayEquals(int[] output, int[] extractFromPacket) {
        System.out.println("Результат теста:" + Arrays.equals(output, extractFromPacket));
    }
}
