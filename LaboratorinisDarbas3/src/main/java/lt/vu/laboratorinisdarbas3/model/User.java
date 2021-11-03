package lt.vu.laboratorinisdarbas3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vardas;
    private String pavarde;
    @Column(name = "TELEFONO_NUMERIS")
    private String telefonoNumeris;
    private String email;
    private String adresas;
    private String slaptazodis;

}
