package edu.pnu.admin;
import edu.pnu.collection.GenericList;

public class School {
    private final String name;
    private GenericList<Student> students = new GenericList<Student>();

    public School(final String name) { this.name = name; }
    public School(final String name, int size) {
        this.name = name;
        students = new GenericList<Student>(size);
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public void removeAllStudent(){
        students = new GenericList<Student>();
    }
    public Student findStudent(String studentName, int schoolYear){
        Student s = new Student(studentName, schoolYear);
        Student findStudent = students.find(s);
        return findStudent;
    }

    @Override
    public String toString(){
        return String.format("School Name: %s Student Count: %d\n%s", name, students.getSize(), students);
    }
}
