package com.Pasta.JustMeet.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

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
}