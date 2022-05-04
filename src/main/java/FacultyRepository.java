import domain.*;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FacultyRepository {

    private List<User> users = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Issue> issues = new ArrayList<>();
    private List<Catalog> catalog = new ArrayList<>();
    private List<Campus> campuses = new ArrayList<>();
    private Scholarship scholarship;

    private static FacultyRepository single_instance = null;

    public static FacultyRepository getInstance() throws ParseException {
        if (single_instance == null)
            single_instance = new FacultyRepository();
        return single_instance;
    }

    private FacultyRepository() throws ParseException {

        Subject subject1 = Subject.builder()
                .name("Algebra")
                .credit(5)
                .grade(0)
                .build();
        Subject subject2 = Subject.builder()
                .name("Data Structures")
                .credit(6)
                .grade(0)
                .build();

        subjects.add(subject1);
        subjects.add(subject2);


        Campus campus1 = Campus.builder()
                .location("Bucharest militari")
                .rent(320)
                .build();
        Campus campus2 = Campus.builder()
                .location("Bucharest vitan")
                .rent(540)
                .build();

        campuses.add(campus1);
        campuses.add(campus2);

        Scholarship scholarship1 = Scholarship.builder()
                .scholarshipType(ScholarshipType.PERFORMANCE)
                .value(600)
                .build();

        Student student1 = Student.builder()
                .name("Popa Alex")
                .address("Bucharest")
                .age(23)
                .gender(true)
                .field(StudyField.COMPUTER_SCIENCE)
                .CNP("1928347589")
                .year(1)
                .studyForm(true)
                .subjects(subjects)
                .scholarship(scholarship1)
                .campus(campus1)
                .annualGrade(9.03)
                .build();

        Student student2 = Student.builder()
                .name("Popescu Andrei")
                .address("Pitesti")
                .age(25)
                .gender(true)
                .field(StudyField.COMPUTER_SCIENCE)
                .CNP("1928347489")
                .year(2)
                .studyForm(false)
                .subjects(subjects)
                .scholarship(scholarship1)
                .campus(campus1)
                .annualGrade(6.24)
                .build();

        users.add(student1);
        users.add(student2);

        Issue issue = Issue.builder()
                .date(new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2022"))
                .student(student1)
                .subject("Student act")
                .build();

        issues.add(issue);

        Secretary secretary1 = Secretary.builder()
                .name("Avram Ana")
                .address("Bucharest")
                .age(36)
                .gender(false)
                .field(StudyField.COMPUTER_SCIENCE)
                .employmentDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"))
                .issues(issues)
                .build();
    }
}
