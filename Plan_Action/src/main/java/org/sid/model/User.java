package org.sid.model;


	

	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


	
	@Entity
	
	public class User {
		
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull(message="---------------")
		private String nom;
		@NotNull(message="---------------")
		private String prenom;
		@NotNull(message="---------------")
		@Column(unique=true)
		@Email(message = "Email should be valid")
		private String email;
		private String password;
		
		//ne mettre pas eager ici sinom exception duplacate eager engendre
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(
				name= "users_roles",
				joinColumns=@JoinColumn(
						name="user_id" ,referencedColumnName="id"),
				inverseJoinColumns=@JoinColumn(
						name="role_id",referencedColumnName="id"))
		
		private Collection<Role> roles;
		@OneToMany(mappedBy="user",fetch=FetchType.EAGER )
		private List<PlanAction> planAction;
		@OneToMany(mappedBy="user")
		private List<Commentaire> Commentaire;
		
		
		
		public User(String nom, String prenom, String email, String password, Collection<Role> roles) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.roles = roles;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Collection<Role> getRoles() {
			return roles;
		}
		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}
		public List<PlanAction> getPlanAction() {
			return planAction;
		}
		public void setPlanAction(List<PlanAction> planAction) {
			this.planAction = planAction;
		}
		public List<Commentaire> getCommentaire() {
			return Commentaire;
		}
		public void setCommentaire(List<Commentaire> commentaire) {
			Commentaire = commentaire;
		}
		
		
		

}
