package com.Pasta.JustMeet.service;

import java.sql.SQLException;
import java.util.List;


import com.Pasta.JustMeet.model.*;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    void save(Notifiche notifica);
	void save(Events eventForm);

	void joinEvento(String currentPrincipalName, int idEvento) throws SQLException;

	
	Events findByName(String name);
	

	void disdiciEvento(String currentPrincipalName, int idEvento);

	List<Events> myMatch(User user);

	List<Events> getEventsByCategory(String string , User user);

	void controlloScadenzaEventi();

	List<Notifiche> getNotificheByTipologia(String string, User user);

	List<Events> listaEventi(User user);

	void notifyOwnerThatUserWantsToJoin(String currentPrincipalName, Integer idevento);

	void rifiutaRichiestaJoinEvento(String user, int idevento);

	List<Events> getOwnerEvents(User user);

	void deleteEvento(int idEvento);

	void modifyEvent(Events eventoVecchio, Events eventoNuovo);

	List<Events> searchEvents(User user, String searchEvent);

	List<User> listaPersone(User user);

	void richiestaAmicizia(User user1, User user2);

	void accettaRichiestaAmicizia(User user, User sender);

	void rifiutaRichiestaAmicizia(User user, User sender);

	List<User> cercaPersone(User user, String searchFriend);

	void modifyAccount(User autenticato, User modifyAccount);

	void deleteAccount(User user);
}