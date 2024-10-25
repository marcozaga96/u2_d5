package marcozagaria.u2_d5.repository;

import marcozagaria.u2_d5.entities.Postazione;
import marcozagaria.u2_d5.enums.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
    Postazione findByTipoEvento(TipoEvento tipoEvento);

    List<Postazione> findByTipoEventoAndEdificio_città(TipoEvento tipoEvento, String città);
}
