import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Karanbir", 55.5),
            new Student("Saksham", 72.0),
            new Student("Naman", 90.0),
            new Student("Arnav", 65.0),
            new Student("Nitesh", 78.5)
        );

        List<String> topStudents = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75% sorted by marks:");
        topStudents.forEach(System.out::println);
    }
}
