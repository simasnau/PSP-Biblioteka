package lt.vu.laboratorinisdarbas3.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vardas;
    private String pavarde;
    private String telefonoNumeris;
    private String email;
    private String adresas;
    private String slaptazodis;

}
