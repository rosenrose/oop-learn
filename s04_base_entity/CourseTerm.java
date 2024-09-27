package s04_base_entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseTerm extends BaseEntity {
    private final int term;
    private final Course course;
    private List<Student> students;

    public CourseTerm(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime,
                      Course course, int term) {
        super(id, createdDateTime, modifiedDateTime);
        this.course = course;
        this.term = term;
        this.students = new ArrayList<>();
    }

    public int getTerm() {
        return this.term;
    }

    public Course getCourse() {
        return this.course;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public int getStudentCnt() {
        return this.students.size();
    }
}
