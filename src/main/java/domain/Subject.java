package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subject {

    private int credit;
    private Integer grade;
    private String name;
}
