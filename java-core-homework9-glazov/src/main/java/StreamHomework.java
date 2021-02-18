import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Student {
    String getName();

    List<Course> getAllCourses();
}

interface Course {
    String getCourseTitle();
}

public class StreamHomework {

    public static final Course MATHS = new CourseTitle("Maths");
    public static final Course ASTRONOMY = new CourseTitle("Astronomy");
    public static final Course PHYSICS = new CourseTitle("Physics");

    public static void main(String[] args) {
        List<Student> studentList = createStudentList();

        System.out.println("DISTINCT COURSES");
        List<Course> distinctCourses = distinctCourses(studentList);
        distinctCourses.forEach(course -> System.out.println(course));

        System.out.println("\nCURIOUS STUDENTS");
        List<Student> mostCurious = mostCurious(studentList);
        mostCurious.forEach(student -> System.out.println(student));

        System.out.println("\nENROLLED TO PHYSICS");
        List<Student> physics = enrolledStudents(studentList, PHYSICS);
        physics.forEach(student -> System.out.println(student));
    }

    private static List<Student> createStudentList() {
        Student first = new StudentImpl("First", Arrays.asList(MATHS, ASTRONOMY));
        Student second = new StudentImpl("Second", Arrays.asList(MATHS));
        Student third = new StudentImpl("Third", Arrays.asList(MATHS, ASTRONOMY, PHYSICS));
        Student fourth = new StudentImpl("Fourth", Arrays.asList(ASTRONOMY, PHYSICS));

        return Arrays.asList(first, second, third, fourth);
    }

    // 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.

    static List<Course> distinctCourses(List<Student> students) {
        return students.stream()
                .map(student -> student.getAllCourses())
                .flatMap(courses -> courses.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).

    static List<Student> mostCurious(List<Student> students) {
        return students.stream()
                .sorted((first, second) -> second.getAllCourses().size() - first.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    //3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.

    static List<Student> enrolledStudents(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
