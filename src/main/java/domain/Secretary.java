package domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Secretary extends User{

    private Date employmentDate;
    private List<Issue> issues;

    @Builder
    public Secretary(String name, String address, int age, boolean gender, StudyField field,
                     Date employmentDate, List<Issue> issues){
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.field = field;
        this.employmentDate = employmentDate;
        this.issues = issues;
    }
}
