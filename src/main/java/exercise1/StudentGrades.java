package exercise1;

public class StudentGrades {
    private static String graduate(Student student, String gradeRank) {
        return student.name() + ": " + gradeRank;
    }

    public static String gradeStudent(int index, Student student) {
        return switch (index) {
            case 0, 1, 2 -> graduate(student, "1st grade");
            case 3 -> graduate(student, "5th grade");
            default -> graduate(student, "7th grade");
        };
    }
}
