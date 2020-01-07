package com.Pasta.JustMeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JustMeet extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JustMeet.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JustMeet.class, args);
    }
}


// TODO : 1.controlli per non fare accedere a determinate url chi non puo esempio: adminEvent nel getmappingdevi essere l'owner dell'event senno fanculo
// TODO : 4.Funzione search tra gli eventi
// TODO : 5.SpringTest
// TODO : 6.Rivisitare myMatch per aggiungere anche un filtro per eventi in base alla geolocalizzazione
// TODO : 7. factory per la creazione delle notifiche
// TODO : 8. fare pagina adminevent dove l'admin puo modificare l'evento
// TODO : 9. l'utente deve poter modificare il proprio account

 