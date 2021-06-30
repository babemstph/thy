package org.sid.model;

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
public class Commentaire {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String message;
	 @ManyToOne
	 @JoinColumn(name="user_Id", referencedColumnName="id") 
	private User user;
	 @ManyToOne
	 @JoinColumn(name="acivite_Id", referencedColumnName="id") 
	private Activite activite;
	

}
