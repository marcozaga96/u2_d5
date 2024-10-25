package marcozagaria.u2_d5.repository;

import marcozagaria.u2_d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {
    Utente findByUsername(String username);
}
