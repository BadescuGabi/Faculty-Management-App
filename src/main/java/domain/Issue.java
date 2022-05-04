package domain;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Issue {

    private Student student;
    private String subject; //message not student subject study
    private Date date;
}
