package domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student extends User {

    private String CNP;
    private int year;
    private boolean studyForm; //tax or budget
    private List<Subject> subjects;
    private Scholarship scholarship;
    private Campus campus;
    private double annualGrade;

    @Builder
    public Student(String name, String address, int age, boolean gender, StudyField field,
                   String CNP, int year, boolean studyForm, List<Subject> subjects,
                   Scholarship scholarship, Campus campus, double annualGrade){
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.field = field;
        this.CNP = CNP;
        this.year = year;
        this.studyForm = studyForm;
        this.subjects = subjects;
        this.scholarship = scholarship;
        this.campus = campus;
        this.annualGrade = annualGrade;
    }
}
