package marcozagaria.u2_d5.service;

import marcozagaria.u2_d5.repository.EdificioRepository;
import marcozagaria.u2_d5.repository.PostazioneRepository;
import marcozagaria.u2_d5.repository.PrenotazioneRepository;
import marcozagaria.u2_d5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
