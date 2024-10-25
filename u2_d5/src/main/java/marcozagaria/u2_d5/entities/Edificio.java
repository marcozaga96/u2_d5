package marcozagaria.u2_d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String nome;
    private String idirizzo;
    private String città;

    public Edificio(String nome, String idirizzo, String città) {
        this.nome = nome;
        this.idirizzo = idirizzo;
        this.città = città;
    }
}
