package exercise1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.*;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = ofNullable(students)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<Student> getStudents() {
        return unmodifiableList(students);
    }

    public String printAverageGradeOfAllStudents() {
        return students.stream()
                .collect(teeing(
                        mapping(Student::name, joining(", ")),
                        averagingDouble(Student::grade),
                        (names, average) -> names + " have an average grade of " + average
                ));
    }
}
