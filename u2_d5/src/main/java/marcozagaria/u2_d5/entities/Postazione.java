package marcozagaria.u2_d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marcozagaria.u2_d5.enums.TipoEvento;

import java.util.UUID;

@Entity
@Table(name = "postazione")
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String descrizione, TipoEvento tipoEvento, int numeroOccupanti) {
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroOccupanti = numeroOccupanti;
    }
}
