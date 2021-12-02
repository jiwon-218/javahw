import java.util.Arrays;
import java.util.Objects;

public class School {
    private String name;
    private int limit;

    private Student[] students;
    private int studentCount;

    School(String name, int limit){
        this.name = name;
        this.limit = limit;
        studentCount = 0;
        students = new Student[limit];
    }

    public void addStudent(Student newStudent){
        students[studentCount] = newStudent;
        studentCount++;
    }

    public void removeAllStudent(){
        students = new Student[limit];
        studentCount = 0;
    }

    public Student findStudent(String studentName, int studentYear){
        Student stud = new Student(studentName, studentYear);
        for (int i=0; i<studentCount; i++){
            if (students[i].equals(stud))
                return students[i];
        }
        return null;
    }

    public String toString(){
        String msg = "School Name: " + name + " Student Count: " + studentCount + "\n";
        for (int i = 0; i < studentCount; i++){
            msg += "\t" + students[i] + "\n";
        }
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return limit == school.limit && studentCount == school.studentCount && Objects.equals(name, school.name)
                && Arrays.equals(students, school.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, limit, studentCount);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
