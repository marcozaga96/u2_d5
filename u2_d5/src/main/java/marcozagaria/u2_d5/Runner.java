package marcozagaria.u2_d5;

import marcozagaria.u2_d5.entities.*;
import marcozagaria.u2_d5.enums.TipoEvento;
import marcozagaria.u2_d5.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AppConfig appConfig;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2D5Application.class);

        try {

            List<Utente> allUtente = Arrays.asList(appConfig.aldo(), appConfig.giacomo(), appConfig.giovanni());
            //prenotazioneService.saveAllUtente(allUtente);
            List<Edificio> allEdificio = Arrays.asList(appConfig.roma(), appConfig.bari(), appConfig.milano());
            //prenotazioneService.saveAllEdificio(allEdificio);
            Edificio edificio1 = prenotazioneService.findEdificio("CineCittà World");
            Postazione postazione1 = appConfig.privata();
            postazione1.setEdificio(edificio1);
            //prenotazioneService.savePostazione(postazione1);
            Utente utente1 = prenotazioneService.findUtente("Aldo il magnifico");
            Postazione postazioneAldo = prenotazioneService.findPostazione(TipoEvento.PRIVATO);
            Prenotazione prenotazione1 = appConfig.evento2();
            prenotazione1.setUtente(utente1);
            prenotazione1.setPostazione(postazioneAldo);
            prenotazioneService.savePrenotazione(prenotazione1);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
