package marcozagaria.u2_d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDate data;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Postazione postazione;

    public Prenotazione(LocalDate data, Utente utente, Postazione postazione) {
        this.data = data;
        this.utente = utente;
        this.postazione = postazione;
    }

}
