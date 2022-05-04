package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Campus {

    private String location;
    private int rent;
}
