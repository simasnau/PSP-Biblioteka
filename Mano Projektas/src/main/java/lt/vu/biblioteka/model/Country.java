package lt.vu.biblioteka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private String name;
    private String prefix;
    private int length;
}
