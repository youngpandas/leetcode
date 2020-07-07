package reflec;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Annotate {


    public static Object copyOf(Object a, int newLength) {
        Class c = a.getClass();
        if (!c.isArray()) return null;
        Class component = c.getComponentType();
        int length = Array.getLength(a);
        Object res = Array.newInstance(component, newLength);
        System.arraycopy(a, 0, res, 0, Math.min(length, newLength));
        return res;
    }

    public static void main(String[] args) throws Exception {
        Student s = new Student(20, "man", 32);
        System.out.println(s.getClass());
        System.out.println(Student.class);
        System.out.println(Student.class == s.getClass());

        //Class.newInstance() 只能够调用无参的构造函数，即默认的构造函数；
        Student e = Student.class.newInstance();
        System.out.println(e);

        //Constructor.newInstance() 可以根据传入的参数，调用任意构造构造函数。
//        Constructor ct = Student.class.getDeclaredConstructor(new Class[]{int.class, String.class, int.class});
//        e = (Student) ct.newInstance(new Object[]{20, "man", 20});
//        System.out.println(e);

        System.out.println(Arrays.toString(Student.class.getFields()));
        System.out.println(Arrays.toString(Student.class.getMethods()));

        //覆盖访问权限
        Field f = Student.class.getDeclaredField("age");
        f.setAccessible(true);
        Object v = f.get(s);
        System.out.println(v);

        //反射修改string
        String str = "1234567890";
        Field f1 = String.class.getDeclaredField("value");
        f1.setAccessible(true);
        char[] v1 = (char[]) f1.get(str);
        v1[0] = '7';
        System.out.println(str);


        //反射修改string
        String str1 = "1234567890";
        Field f2 = String.class.getDeclaredField("hash");
        f2.setAccessible(true);
        int res = (int) f2.get(str1);
        System.out.println(res);
    }


}
