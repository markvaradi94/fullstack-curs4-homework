package exercise1;

import java.util.*;
import java.util.stream.Collectors;

public class CourseHelperService {

    private final List<String> courseJsons;
    private final StudentService service;

    public CourseHelperService(List<String> courseJsons, StudentService service) {
        this.courseJsons = Optional.of(courseJsons)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.service = service;
    }

    public List<String> getCourseJsons() {
        return Collections.unmodifiableList(courseJsons);
    }

    public List<String> mapStudentsToRandomCourses() {
        return service.getStudents().stream()
                .map(this::assignCourseToStudent)
                .collect(Collectors.toList());
    }

    private String assignCourseToStudent(Student student) {
        return student.name() + " will participate to course " + getRandomCourse();
    }

    private String getRandomCourse() {
        int index = new Random().nextInt(courseJsons.size());
        return courseJsons.get(index);
    }
}
