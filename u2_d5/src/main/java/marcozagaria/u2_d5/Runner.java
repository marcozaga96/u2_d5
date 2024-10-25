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
            //prenotazioneService.savePrenotazione(prenotazione1);
            Edificio edificio2 = prenotazioneService.findEdificio("Stadio San Nicola");
            Postazione postazione2 = appConfig.openspace();
            postazione2.setEdificio(edificio2);
            //prenotazioneService.savePostazione(postazione2);
            Edificio edificio3 = prenotazioneService.findEdificio("Rho fiera");
            Postazione postazione3 = appConfig.salaRiunioni();
            postazione3.setEdificio(edificio3);
            //prenotazioneService.savePostazione(postazione3);
            Utente utente2 = prenotazioneService.findUtente("Giovanni l'intelligente");
            Postazione postazioneGiovanni = prenotazioneService.findPostazione(TipoEvento.OPENSPACE);
            Prenotazione prenotazione2 = appConfig.evento1();
            prenotazione2.setUtente(utente2);
            prenotazione2.setPostazione(postazioneGiovanni);
            //prenotazioneService.savePrenotazione(prenotazione2);
            Utente utente3 = prenotazioneService.findUtente("Giacomo lo sfigato");
            Postazione postazioneGiacomo = prenotazioneService.findPostazione(TipoEvento.SALA_RIUNIONI);
            Prenotazione prenotazione3 = appConfig.oggi();
            prenotazione3.setUtente(utente3);
            prenotazione3.setPostazione(postazioneGiacomo);
            //prenotazioneService.savePrenotazione(prenotazione3);
            Prenotazione prenotazione4 = appConfig.oggi();
            prenotazione4.setUtente(utente1);
            prenotazione4.setPostazione(postazioneGiacomo);
            //prenotazioneService.creaPrenotazione(prenotazione4); mi da l'errore della prenotazione gia occupata nella data
            Prenotazione prenotazione5 = appConfig.oggi();
            prenotazione5.setUtente(utente3);
            prenotazione5.setPostazione(postazioneAldo);
            //prenotazioneService.creaPrenotazione(prenotazione5);mi da l'errore dell'utente gia occupato nella data
            prenotazioneService.searchPostazione(TipoEvento.OPENSPACE, "Bari").forEach(System.out::println);
            Prenotazione prenotazione6 = appConfig.oggi();
            prenotazione5.setUtente(utente2);
            prenotazione5.setPostazione(postazioneAldo);
            prenotazioneService.creaPrenotazione(prenotazione6);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
