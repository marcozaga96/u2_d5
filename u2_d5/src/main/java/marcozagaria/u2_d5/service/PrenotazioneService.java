package marcozagaria.u2_d5.service;

import lombok.extern.slf4j.Slf4j;
import marcozagaria.u2_d5.entities.Edificio;
import marcozagaria.u2_d5.entities.Postazione;
import marcozagaria.u2_d5.entities.Prenotazione;
import marcozagaria.u2_d5.entities.Utente;
import marcozagaria.u2_d5.enums.TipoEvento;
import marcozagaria.u2_d5.repository.EdificioRepository;
import marcozagaria.u2_d5.repository.PostazioneRepository;
import marcozagaria.u2_d5.repository.PrenotazioneRepository;
import marcozagaria.u2_d5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PrenotazioneService {
    @Autowired
    EdificioRepository edificioRepository;
    @Autowired
    PostazioneRepository postazioneRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    UtenteRepository utenteRepository;

    public void saveUtente(Utente newUtente) {
        utenteRepository.save(newUtente);
        log.info("l'utente " + newUtente.getUsername() + " è stato salvato correttamente!");
    }

    public void saveAllUtente(List<Utente> newUtente) {
        for (Utente utente : newUtente) {
            try {
                this.saveUtente(utente);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public void saveEdificio(Edificio newEdificio) {
        edificioRepository.save(newEdificio);
        log.info("l'edificio " + newEdificio.getNome() + " è stato salvato correttamente!");
    }

    public void saveAllEdificio(List<Edificio> newEdificio) {
        for (Edificio edificio : newEdificio) {
            try {
                this.saveEdificio(edificio);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public Edificio findEdificio(String nome) {
        return edificioRepository.findByNome(nome);
    }

    public Utente findUtente(String username) {
        return utenteRepository.findByUsername(username);
    }

    public Postazione findPostazione(TipoEvento tipoEvento) {
        return postazioneRepository.findByTipoEvento(tipoEvento);
    }

    public void savePostazione(Postazione newPostazione) {
        postazioneRepository.save(newPostazione);
        log.info("la postazione con evento tipo " + newPostazione.getTipoEvento() + " nell'edificio " + newPostazione.getEdificio() + " è stata salvata correttamente!");
    }

    public void savePrenotazione(Prenotazione newPrenotazione) {
        prenotazioneRepository.save(newPrenotazione);
        log.info("la prenotazione in data " + newPrenotazione.getData() + " nella postazione " + newPrenotazione.getPostazione() + " è stata salvata correttamente!");
    }

    public void creaPrenotazione(Prenotazione prenotazione) {

        List<Prenotazione> prenotazioniPerData = prenotazioneRepository.findByPostazioneIdAndData(prenotazione.getPostazione().getId(), prenotazione.getData());
        if (!prenotazioniPerData.isEmpty()) {
            throw new RuntimeException("La postazione è già prenotata per questa data.");
        }

        List<Prenotazione> prenotazioniUtentePerData = prenotazioneRepository.findByUtenteIdAndData(prenotazione.getUtente().getId(), prenotazione.getData());
        if (!prenotazioniUtentePerData.isEmpty()) {
            throw new RuntimeException("L'utente ha già una prenotazione per questa data.");
        }
        this.savePrenotazione(prenotazione);
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public List<Postazione> searchPostazione(TipoEvento tipoEvento, String città) {
        return postazioneRepository.findByTipoEventoAndEdificio_città(tipoEvento, città);
    }

}
