package marcozagaria.u2_d5.repository;

import marcozagaria.u2_d5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    List<Prenotazione> findByPostazioneIdAndData(UUID postazioneId, LocalDate data);

    List<Prenotazione> findByUtenteIdAndData(UUID utenteId, LocalDate data);
}
