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
public class Objectif {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String etat;
	private int indicateur;
	private Date date_Debut;
	private  Date date_Fin;
	private Date date_Debut_Prevue;
	private Date date_Fin_Prevue;
	 @ManyToOne
	 @JoinColumn(name="axe_Id", referencedColumnName="id") 
	private Axe axe;
	 @OneToMany(mappedBy="objectif",fetch=FetchType.EAGER )
	private List<Activite> activite;

}
