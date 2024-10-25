package marcozagaria.u2_d5.entities;

import marcozagaria.u2_d5.enums.TipoEvento;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean(name = "utente_aldo")
    public Utente aldo() {
        return new Utente("Aldo il magnifico", "Aldo Baglio", "aldoIlMagnifico@gmail.com");
    }

    @Bean(name = "utente_giovanni")
    public Utente giovanni() {
        return new Utente("Giovanni l'intelligente", "Giovanni Storti", "GiovanniL'intelligente@gmail.com");
    }

    @Bean(name = "utente_giacomo")
    public Utente giacomo() {
        return new Utente("Giacomo lo sfigato", "Giacomo Poretti", "GiacomoLoSfigato@gmail.com");
    }

    @Bean(name = "edeficio_bari")
    public Edificio bari() {
        return new Edificio("Stadio San Nicola", "Strada Torrebella", "Bari");
    }

    @Bean(name = "edeficio_milano")
    public Edificio milano() {
        return new Edificio("Rho fiera", "Via del Sempione", "Milano");
    }

    @Bean(name = "edeficio_roma")
    public Edificio roma() {
        return new Edificio("CineCittà World", "Via Irina Alberti", "Roma");
    }

    @Bean(name = "postazione_privata")
    public Postazione privata() {
        return new Postazione("evento super privato", TipoEvento.PRIVATO, 1000);
    }

    @Bean(name = "postazione_openspace")
    public Postazione openspace() {
        return new Postazione("evento aperto a tutti", TipoEvento.OPENSPACE, 10000);
    }

    @Bean(name = "postazione_sala_riunioni")
    public Postazione salaRiunioni() {
        return new Postazione("evento sala riunioni", TipoEvento.SALA_RIUNIONI, 500);
    }

    @Bean(name = "prenotazione_oggi")
    public Prenotazione oggi() {
        return new Prenotazione(LocalDate.now());
    }

    @Bean(name = "prenotazione_evento1")
    public Prenotazione evento1() {
        return new Prenotazione(LocalDate.of(2025, 5, 10));
    }

    @Bean(name = "prenotazione_evento2")
    public Prenotazione evento2() {
        return new Prenotazione(LocalDate.of(2024, 12, 24));
    }

}
