package marcozagaria.u2_d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "utente")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String username;
    private String nomeCognome;
    private String email;

    public Utente(String username, String nomeCognome, String email) {
        this.username = username;
        this.nomeCognome = nomeCognome;
        this.email = email;
    }
}
