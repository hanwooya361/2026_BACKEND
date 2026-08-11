package day10;
// 1.
class Person{
    String name;
}
class Student extends Person{
    int studentId;
}

public class Practice12 {
    public static void main(String[] args) {
        // 1.
        Student 학생 = new Student();
        학생.studentId = 20210959;
        학생.name = "조현우";     
        System.out.println(학생.name+학생.studentId);  
    }
}
