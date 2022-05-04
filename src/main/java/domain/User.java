package domain;

import lombok.Data;
import lombok.Getter;

@Getter
public abstract class User {

    protected String name;
    protected String address;
    protected int age;
    protected boolean gender;
    protected StudyField field;
}
