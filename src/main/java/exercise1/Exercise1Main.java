package exercise1;

import java.time.LocalDate;
import java.util.List;

public class Exercise1Main {
    public static void main(String[] args) {
        Student pista = new Student("pista", LocalDate.now().minusYears(27), 10);
        Student pityu = new Student("pityu", 21, 8);
        Student laci = new Student("laci", 50, 8);

        System.out.println(pityu.birthDate());

        List<Student> students = List.of(
                pista,
                pityu,
                new Student("karcsi", LocalDate.now().minusYears(41), 7),
                new Student("ioane", LocalDate.now().minusYears(26), 7),
                new Student("ludmila", LocalDate.now().minusYears(25), 6),
                new Student("gogu", 33, 9),
                new Student("vasile", 60, 5),
                new Student("fanu", 19, 7)
        );

        StudentService studentService = new StudentService(students);
        System.out.println("\n" + studentService.printAverageGradeOfAllStudents());

        System.out.println("\n" + laci.birthDate());
        System.out.println("\n" + pityu.birthDate());

        List<String> jsons = generateCourses();

        CourseService helperService = new CourseService(jsons, studentService);
        System.out.println();
        System.out.println(helperService.mapStudentsToRandomCourses());

    }

    private static List<String> generateCourses() {
        return List.of("""
                        {
                            "course":"Math 101",
                            "semester":2
                        }
                        """,
                """
                        {
                            "course":"Chemistry 205",
                            "semester":1
                        }
                        """,
                """
                        {
                            "course":"Physics 101",
                            "semester":1
                        }
                        """,
                """
                        {
                            "course":"Spanish 201",
                            "semester":2
                        }
                        """);
    }
}
