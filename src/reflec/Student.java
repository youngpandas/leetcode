package reflec;


public class Student {
    private Integer height;
    public String sex;
    private Integer age;

    public Student() {
    }

    public Student(Integer height, String sex, Integer age) {
        this.height = height;
        this.sex = sex;
        this.age = age;
    }

    public double getCTC() {
        return (double) this.height / this.age;
    }

    public static double getStaticCTC() {
        return 1;
    }


    @Override
    public String toString() {
        return "Student{" +
                "height=" + height +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}