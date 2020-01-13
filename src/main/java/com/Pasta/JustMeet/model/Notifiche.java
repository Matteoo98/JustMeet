/**
 * 
 */
package com.Pasta.JustMeet.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author matti
 *
 */
@Entity
@Table(name = "notifiche")
public class Notifiche {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String tipologia;
	
	private String descrizione;
	
	private String sender;
	
	private int idEventoToJoin;
	
    private int Ora;
    
    private int Minuti;
    
    private int Year;
    
    private int Month;
    
    private int Day;
    
    @ManyToMany(mappedBy = "notifiche")
    private Set<User> users;
    
    public Notifiche() {
    	
    }
    
    public Notifiche(String descrizione , String tipologia , String sender , int ora , int minuti,int year ,int month,int day) {
		this.descrizione=descrizione;
		this.tipologia=tipologia;
		this.sender=sender;
		this.Ora=ora;
		this.Minuti=minuti;
		this.Year=year;
		this.Month=month;
		this.Day=day;
	}
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getIdEventoToJoin() {
		return idEventoToJoin;
	}

	public void setIdEventoToJoin(int idEventoToJoin) {
		this.idEventoToJoin = idEventoToJoin;
	}

	public int getOra() {
		return Ora;
	}

	public void setOra(int ora) {
		Ora = ora;
	}

	public int getMinuti() {
		return Minuti;
	}

	public void setMinuti(int minuti) {
		Minuti = minuti;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
