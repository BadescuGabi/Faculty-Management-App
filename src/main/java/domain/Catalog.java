package domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Catalog {

    private List<Student> students;
    private int year;
}
