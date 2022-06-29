//Q4. //Write a program to map jbdc resultset to List of Student Objects. Filter the List of student objects based on their //age  by //using java8 streams and also without streams separately.

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

import static java.util.stream.Collectors.toMap;


class StudentData {
    private int id;
    private String name;
    private int age;
    public StudentData(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student {
    public static void main(String[] args) {
        List<StudentData> studentdatas = Arrays.asList(new StudentData(1, "Shubham", 25), new StudentData(2, "Spring", 24));
        StudentData p1 = new StudentData(34, "Michael", 45);
        StudentData p2 = new StudentData(17, "Jane", 34);
        StudentData p3 = new StudentData(28, "John", 12);

        List<StudentData> newstudentdata=new ArrayList<StudentData>();
        newstudentdata.add(p1);
        newstudentdata.add(p2);
        newstudentdata.add(p3);

        Collections.sort(newstudentdata, new Sortbyroll());

        System.out.println("\nSorted by Age Without Stream");
        for (int i=0; i<newstudentdata.size(); i++)
            System.out.println(newstudentdata.get(i));
        System.out.println("\nSorted by Age With Stream");
        java8_filter(studentdatas);
    }
    public static void java8_filter(List<StudentData> studentdatas) {

        Collection<StudentData> studentdata = studentdatas.stream()
                .collect(toMap(StudentData::getName,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(StudentData::getAge))))
                .values();
        studentdata.forEach(System.out::println);
    }

}

class Sortbyroll implements Comparator<StudentData>
{
    public int compare(StudentData a, StudentData b)
    {
        return a.getAge() - b.getAge();
    }
}