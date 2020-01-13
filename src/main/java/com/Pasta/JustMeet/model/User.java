package com.Pasta.JustMeet.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    
    private String preferenceUno;
    
    private String preferenceDue;
    
    private String preferenceTre;
    
    private String email;
    
    private String cognome;
    
    private String citta;
    

    public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Transient
    private String passwordConfirm;

    public Set<Events> getEventi() {
		return eventi;
	}

	public void setEventi(Set<Events> eventi) {
		this.eventi = eventi;
	}
	
	@ManyToMany
    private Set<User> amici;
	@ManyToMany(mappedBy = "amici")
	private Set<User> utente;

	public Set<User> getAmici() {
		return amici;
	}

	public void setAmici(Set<User> amici) {
		this.amici = amici;
	}

	public Set<User> getUtente() {
		return utente;
	}

	public void setUtente(Set<User> utente) {
		this.utente = utente;
	}

	@ManyToMany
    private Set<Events> eventi;
	
	@ManyToMany
    private Set<Notifiche> notifiche;
    
    public Set<Notifiche> getNotifiche() {
		return notifiche;
	}

	public void setNotifiche(Set<Notifiche> notifiche) {
		this.notifiche = notifiche;
	}

	@ManyToMany
    private Set<Role> roles;
    
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPreferenceUno() {
		return preferenceUno;
	}

	public void setPreferenceUno(String preferenceUno) {
		this.preferenceUno = preferenceUno;
	}

	public String getPreferenceDue() {
		return preferenceDue;
	}

	public void setPreferenceDue(String preferenceDue) {
		this.preferenceDue = preferenceDue;
	}

	public String getPreferenceTre() {
		return preferenceTre;
	}

	public void setPreferenceTre(String preferenceTre) {
		this.preferenceTre = preferenceTre;
	}
   
}