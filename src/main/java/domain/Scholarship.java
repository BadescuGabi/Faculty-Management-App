package domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Scholarship {

    private ScholarshipType scholarshipType;
    private int value;
}
