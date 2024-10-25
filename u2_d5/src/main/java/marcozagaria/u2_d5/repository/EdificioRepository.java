package marcozagaria.u2_d5.repository;

import marcozagaria.u2_d5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, UUID> {
    Edificio findByNome(String nome);
}
