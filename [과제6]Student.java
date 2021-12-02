package edu.pnu.admin;

import java.util.Objects;

public class Student {
    private final String name;
    private int year;
    private final School theSchool;

    public Student(String name, int year) {
        this.name = name; this.year = year;
        theSchool = new School("PNU");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, theSchool);
    }

    @Override
    public String toString() {
        return "\t["+
                name + ", " +
                year + "학년" +
                "]\n";
    }
}
