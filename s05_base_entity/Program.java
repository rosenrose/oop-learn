package s05_base_entity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        Student student1 = new Student(id, now, now, "John", "Kim", "kjw4569");
        printStudent(student1);

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        BaseEntity student2 = new Student(id, now, now, "Pope", "POCU", "academy");
        printStudent((Student) student2);

        ((Student) student2).setNickname("Park");
        now = OffsetDateTime.now(ZoneOffset.UTC);
        student2.setModifiedDateTime(now);
        printStudent((Student) student2);

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        Course comp2500 = new Course(id, now, now, "COMP2500", "OOP");

        id = UUID.randomUUID();
        now = OffsetDateTime.now(ZoneOffset.UTC);

        CourseTerm term202409 = new CourseTerm(id, now, now, comp2500, 202409);
        comp2500.getCourseTerms().add(term202409);
        printCourse(comp2500);

        comp2500.addCourseTerm(202412);
        printCourse(comp2500);

        term202409.addStudent(student1);
        term202409.addStudent((Student) student2);

        comp2500.setTitle("Object-Oriented Programming and Design");
        printCourse(comp2500);
    }

    private static void printStudent(Student student) {
        System.out.println("Student: ");

        printBaseEntity(student);

        System.out.printf("  name: %s%n", student.getName());
        System.out.printf("  email: %s%n", student.getEmail());
        System.out.printf("  nickname: %s%n%n", student.getNickname());
    }

    private static void printCourse(Course course) {
        System.out.println("Course: ");

        printBaseEntity(course);

        System.out.printf("  course code: %s%n", course.getCourseCode());
        System.out.printf("  title: %s%n", course.getTitle());
        System.out.println("  course terms:");

        for (CourseTerm courseTerm : course.getCourseTerms()) {
            System.out.printf("    term: %s%n", courseTerm.getTerm());
            System.out.printf("    student counts: %s%n", courseTerm.getStudentCnt());
        }

        System.out.println();
    }

    private static void printBaseEntity(BaseEntity entity) {
        System.out.printf("  id: %s%n", entity.getId());
        System.out.printf("  created: %s%n", entity.getCreatedDateTime());
        System.out.printf("  modified: %s%n", entity.getModifiedDateTime());
    }
}
