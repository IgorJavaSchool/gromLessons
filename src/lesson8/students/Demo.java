package lesson8.students;


public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.createHighestParent().toString());
        System.out.println(demo.createLowestChild().toString());
    }
    Student createHighestParent(){
        return new Student("Ivan", "Petrov", 24, new Course[]{});
    }
    SpecialStudent createLowestChild(){
        return new SpecialStudent("Petr", "Ivanov", 20, new Course[]{}, 123456l, "ivanov@mail.ru");
    }
}
