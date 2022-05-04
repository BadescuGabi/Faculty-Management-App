import domain.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FacultyService {
    FacultyRepository facultyRepository = FacultyRepository.getInstance();

    private static FacultyService single_instance = null;

    private FacultyService() throws ParseException {
    }

    public static FacultyService getInstance() throws ParseException {
        if (single_instance == null)
            single_instance = new FacultyService();
        return single_instance;
    }

    public void addSubject() {

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Subject's name: ");
        String name = scanner1.nextLine();

        System.out.println("Credits: ");
        Integer credits = scanner1.nextInt();

        System.out.println("Grade: ");
        Integer grade = scanner1.nextInt();
        List<Subject> subjects = facultyRepository.getSubjects();
        Subject subject = Subject.builder()
                .name(name)
                .grade(grade)
                .credit(credits)
                .build();
        subjects.add(subject);
    }

    public void editSubject(String subjectName) {

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Subject's name: ");
        String name = scanner1.nextLine();
        System.out.println("Credits: ");
        Integer credits = scanner1.nextInt();
        System.out.println("Grade: ");
        Integer grade = scanner1.nextInt();
        Subject subject = Subject.builder()
                .name(name)
                .grade(grade)
                .credit(credits)
                .build();
        for (Subject subj : facultyRepository.getSubjects()) {
            if (subj.getName().equals(name)) {
                subj = subject;
            }
        }
    }

    public Stream<Catalog> getCatlogByYear(int year) {
        return facultyRepository.getCatalog().stream().filter(p -> p.getYear() == year);
    }

    public void getRestantStudents() {

        List<Student> students = new ArrayList<>();
        for (User user : facultyRepository.getUsers()) {
            if (user.getClass().getSimpleName().equals("Student")) {
                Student stud = (Student) user;
                for (Subject subj : stud.getSubjects())
                    if (subj.getGrade() < 5) {
                        students.add(stud);
                    }
            }
        }
    }

    public float getCampusIncome(Campus campus) {

        float income = 0;
        List<Student> students = new ArrayList<>();
        for (User user : facultyRepository.getUsers()) {
            if (user.getClass().getSimpleName().equals("Student")) {
                Student stud = (Student) user;
                if (stud.getCampus().equals(campus)) {
                    income += stud.getCampus().getRent();
                }
            }
        }
        return income;
    }
}