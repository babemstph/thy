package org.sid.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Axe {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String etat;
	private int indicateur;
	private Date date_Debut;
	private  Date date_Fin;
	private Date date_Debut_Prevue;
	private Date date_Fin_Prevue;
	 @ManyToOne
	 @JoinColumn(name="planAction_Id", referencedColumnName="id") 
	private PlanAction planAction;
	 @OneToMany(mappedBy="axe",fetch=FetchType.EAGER )
		private List<Objectif> objectif;
	 
	public Axe(String etat, int indicateur, Date date_Debut, Date date_Fin, Date date_Debut_Prevue,
			Date date_Fin_Prevue) {
		super();
		this.etat = etat;
		this.indicateur = indicateur;
		this.date_Debut = date_Debut;
		this.date_Fin = date_Fin;
		this.date_Debut_Prevue = date_Debut_Prevue;
		this.date_Fin_Prevue = date_Fin_Prevue;
	}
	 

}
