package com.Pasta.JustMeet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Pasta.JustMeet.model.*;
import com.Pasta.JustMeet.repository.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private NotificheRepository notificheRepository;
	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public void save(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
	    Role userRole = roleRepository.findByName("USER");
	    
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(Events eventForm) {

		
		// nome del tizio che cerco
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userRepository.findByUsername(currentPrincipalName);
		eventForm.setOwner(currentPrincipalName);
		eventsRepository.save(eventForm);
		LocalDateTime now = LocalDateTime.now();
		Notifiche notifica = new Notifiche(
				"L'utente "+user.getUsername()+" ha creato l'evento "+eventForm.getName()+ " e si è unito ad esso.",
				"comune",
				"System",
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth());			
		notificheRepository.save(notifica);
		user.getNotifiche().add(notifica);
		user.getEventi().add(eventForm);
		
		userRepository.save(user);
		

	}

	@Override
	public void joinEvento(String userForm, int idEvento) throws SQLException {

		User user = userRepository.findByUsername(userForm);
		Events event = eventsRepository.findById(idEvento);
		if (user.getEventi().contains(event)) {
			System.out.println("L'utente ha gia fatto la join all'evento");
		} else {
			LocalDateTime now = LocalDateTime.now();
			Notifiche notifica = new Notifiche(
					"L'utente "+user.getUsername()+" si è unito all'evento "+event.getName(),
					"comune",
					"System",
					now.getHour(),
					now.getMinute(),
					now.getYear(),
					now.getMonthValue(),
					now.getDayOfMonth()
					 );			
			notificheRepository.save(notifica);
			user.getNotifiche().add(notifica);
			user.getEventi().add(event);			
			userRepository.save(user);
		}

	}

	@Override
	public Events findByName(String name) {
		// TODO Auto-generated method stub
		return eventsRepository.findByName(name);
	}

	@Override
	public void disdiciEvento(String currentPrincipalName, int idEvento) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(currentPrincipalName);
		Events event = eventsRepository.findById(idEvento);

		if (user.getEventi().contains(event)) {
			user.getEventi().remove(event);
			LocalDateTime now = LocalDateTime.now();
			Notifiche notifica = new Notifiche(
					"L'utente "+user.getUsername()+" è uscito dall'evento "+event.getName(),
					"comune",
					"System",
					now.getHour(),
					now.getMinute(),
					now.getYear(),
					now.getMonthValue(),
					now.getDayOfMonth() );			
			notificheRepository.save(notifica);
			user.getNotifiche().add(notifica);
			userRepository.save(user);
		}

	}

	@Override
	public List<Events> myMatch(User user) {
		// TODO Auto-generated method stub
		ArrayList<Events> myMatchEvents = new ArrayList<Events>();
		List<Events> listaEventi = this.listaEventi(user);
		for (Events evento : listaEventi) {
			if (evento.getName().toLowerCase().contains(user.getPreferenceUno().toLowerCase())
					|| evento.getName().toLowerCase().contains(user.getPreferenceDue().toLowerCase())
					|| evento.getName().toLowerCase().contains(user.getPreferenceTre().toLowerCase())
					|| evento.getDescription().toLowerCase().contains(user.getPreferenceUno().toLowerCase())
					|| evento.getDescription().toLowerCase().contains(user.getPreferenceDue().toLowerCase())
					|| evento.getDescription().toLowerCase().contains(user.getPreferenceTre().toLowerCase())
					|| evento.getLuogo().toLowerCase().contains(user.getCitta().toLowerCase())) {
				myMatchEvents.add(evento);
			}

		}
		return myMatchEvents;
	}

	@Override
	public List<Events> getEventsByCategory(String categoria , User user) {
		ArrayList<Events> eventsByCategory = new ArrayList<Events>();

		List<Events> listaEventi = this.listaEventi(user);

		for (Events events : listaEventi) {
			if (events.getCategory().equals(categoria)) {
				eventsByCategory.add(events);
			}
		}

		return eventsByCategory;
	}

	@Override
	public void controlloScadenzaEventi() {
		List<Events> eventi = eventsRepository.findAll();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		now.format(dtf);
		for (Events events : eventi) {

			LocalDateTime eventDate = LocalDateTime.of(events.getYear(), events.getMonth(), events.getDay(),
					events.getOra(), events.getMinuti());

			if (now.isAfter(eventDate)) {
				User user = userRepository.findByUsername(events.getOwner());
				//LocalDateTime now = LocalDateTime.now();
				Notifiche notifica = new Notifiche(
						"L'evento "+events.getName()+ "che hai creato è scaduto.",
						"comune",
						"System",
						now.getHour(),
						now.getMinute(),
						now.getYear(),
						now.getMonthValue(),
						now.getDayOfMonth() );			
				notificheRepository.save(notifica);
				user.getNotifiche().add(notifica);
				user.getEventi().remove(events);
				userRepository.save(user);
				eventsRepository.delete(events);
			}
		}

	}

	@Override
	public List<Notifiche> getNotificheByTipologia(String tipologia, User user) {
		
		ArrayList<Notifiche> notificheByTipologia = new ArrayList<Notifiche>();
				
		for (Notifiche notifica : user.getNotifiche()) {
			
			if(notifica.getTipologia().toLowerCase().equals(tipologia.toLowerCase())) {
				
				notificheByTipologia.add(notifica);
				
			}
		}
		return notificheByTipologia;
	}

	@Override
	public void save(Notifiche notifica) {
		// TODO Auto-generated method stub
		notificheRepository.save(notifica);
	}
	
	@Override
	public List<Events> listaEventi(User user){
		ArrayList<Events> eventiBuoni = new ArrayList<Events>();
		
		List<Events> eventi = eventsRepository.findAll();
		for (Events evento : eventi) {
			if(!(user.getEventi().contains(evento))) {
				eventiBuoni.add(evento);
			}
		}	
		return eventiBuoni;
	}

	@Override
	public void notifyOwnerThatUserWantsToJoin(String currentPrincipalName, Integer idevento) {
		LocalDateTime now = LocalDateTime.now();
		int id=idevento;
		Events evento=eventsRepository.findById(id);
		Notifiche notifica=new Notifiche(
        "L'utente "+currentPrincipalName+" desidera partecipare all'evento"+evento.getName()+"che hai creato. Accetti o rifiuti ?" ,
		"richiesta", 
		currentPrincipalName,
		now.getHour(),
		now.getMinute(),
		now.getYear(),
		now.getMonthValue(),
		now.getDayOfMonth() );
		notifica.setIdEventoToJoin(id);
		User owner=userRepository.findByUsername(evento.getOwner());
		owner.getNotifiche().add(notifica);
		notificheRepository.save(notifica);
		userRepository.save(owner);
	}

	@Override
	public void rifiutaRichiestaJoinEvento(String user, int idevento) {
		LocalDateTime now = LocalDateTime.now();
		Events evento=eventsRepository.findById(idevento);
		Notifiche notifica=new Notifiche(
		        "La tua richiesta di partecipazione all'evento  "+evento.getName()+" è stata rifiutata dall'admin "+evento.getOwner(),
				"comune", 
				"System",
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth() );
		User utente = userRepository.findByUsername(user);
		utente.getNotifiche().add(notifica);
		notificheRepository.save(notifica);
		userRepository.save(utente);
		
	}

	@Override
	public List<Events> getOwnerEvents(User user) {
		List<Events> eventi= eventsRepository.findAll();
		ArrayList<Events>ownerEvents= new ArrayList<Events>();
		
		for (Events event : eventi) {
			if(event.getOwner().toLowerCase().equals(user.getUsername().toLowerCase())) {
				ownerEvents.add(event);
			}
		}
		return ownerEvents;
	}

	@Override
	public void deleteEvento(int idEvento) {
		Events evento = eventsRepository.findById(idEvento);
		User owner = userRepository.findByUsername(evento.getOwner());
		List<User> utenti = userRepository.findAll();
		LocalDateTime now = LocalDateTime.now();
		Notifiche notifica = new Notifiche(
				"Hai eliminato l'evento "+evento.getName()+ "che avevi creato.",
				"comune",
				"System",
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth() );
		notificheRepository.save(notifica);
		owner.getNotifiche().add(notifica);
		//elimino i partecipanti dell'evento
		for (User user : utenti) {
			if(user.getEventi().contains(evento)) {
				user.getEventi().remove(evento);
				userRepository.save(user);
			}
		}
		//evento.getUsers().clear();
		//owner.getEventi().remove(evento);
		userRepository.save(owner);
		eventsRepository.delete(evento);
	}

	@Override
	public void modifyEvent(Events eventoVecchio, Events eventoNuovo) {
		
		eventoVecchio.setName(eventoNuovo.getName());
		eventoVecchio.setDescription(eventoNuovo.getDescription());
		eventoVecchio.setYear(eventoNuovo.getYear());
		eventoVecchio.setMonth(eventoNuovo.getMonth());
		eventoVecchio.setDay(eventoNuovo.getDay());
		eventoVecchio.setOra(eventoNuovo.getOra());
		eventoVecchio.setMinuti(eventoNuovo.getMinuti());
		eventoVecchio.setOwner(eventoNuovo.getOwner());
		eventoVecchio.setCategory(eventoNuovo.getCategory());
		eventoVecchio.setLuogo(eventoNuovo.getLuogo());
		eventsRepository.save(eventoVecchio);
		
	}

	@Override
	public List<Events> searchEvents(User user ,String searchEvent) {
		ArrayList<Events> lista = new ArrayList<>();
		List<Events> tutti= eventsRepository.findAll();
		for (Events e : tutti) {
			if(!(user.getEventi().contains(e))) {
				if(e.getName().toLowerCase().contains(searchEvent.toLowerCase())
						||e.getDescription().toLowerCase().contains(searchEvent.toLowerCase())
						||e.getLuogo().toLowerCase().contains(searchEvent.toLowerCase())) {
					lista.add(e);
				}
			}
		}
		return lista;
	}

	@Override
	public List<User> listaPersone(User user) {
		ArrayList<User> lista = new ArrayList<>();
		List<User> tutti= userRepository.findAll();
		for (User u : tutti) {
			if(!(user.getAmici().contains(u))&&u!=user) {
				lista.add(u);
			}
		}
		
		return lista;
	}

	@Override
	public void richiestaAmicizia(User user1, User user2) {
		LocalDateTime now = LocalDateTime.now();
		Notifiche notifica=new Notifiche(
		        "L'utente "+user1.getUsername()+" ti ha inviato una richiesta di amicizia . Accetti o rifiuti ?" ,
				"richiestaAmicizia", 
				user1.getUsername(),
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth() );
		notificheRepository.save(notifica);
		user2.getNotifiche().add(notifica);
		userRepository.save(user2);
		
		
	}

	@Override
	public void accettaRichiestaAmicizia(User user, User sender) {
		LocalDateTime now = LocalDateTime.now();
		Notifiche notifica=new Notifiche(
		        "L'utente "+user.getUsername()+" ha accettato la tua richiesta di amicizia." ,
				"comune", 
				"System",
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth() );
		notificheRepository.save(notifica);
		sender.getNotifiche().add(notifica);
		userRepository.save(sender);
		user.getAmici().add(sender);
		sender.getAmici().add(user);
		userRepository.save(user);
		userRepository.save(sender);
		
		
	}

	@Override
	public void rifiutaRichiestaAmicizia(User user, User sender) {
		LocalDateTime now = LocalDateTime.now();
		Notifiche notifica=new Notifiche(
		        "L'utente "+user.getUsername()+" ha rifiutato la tua richiesta di amicizia." ,
				"comune", 
				"System",
				now.getHour(),
				now.getMinute(),
				now.getYear(),
				now.getMonthValue(),
				now.getDayOfMonth() );
		notificheRepository.save(notifica);
		sender.getNotifiche().add(notifica);
		userRepository.save(sender);
	}

	@Override
	public List<User> cercaPersone(User user, String searchFriend) {
		ArrayList<User> lista = new ArrayList<>();
		List<User> tutti= userRepository.findAll();
		for (User u : tutti) {
			if(!(user.getAmici().contains(u))&&u!=user) {
				if(u.getUsername().toLowerCase().contains(searchFriend.toLowerCase())
						|| u.getCognome().toLowerCase().contains(searchFriend.toLowerCase()) ) {
					
					lista.add(u);
				
				}
			}
		}
		
		return lista;
	}

}