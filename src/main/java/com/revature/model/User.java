package com.revature.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="u_id")
	private int userId;
	
	@Column(name="u_username", unique = true, nullable = false)
	private String username;
	
	@Column(name="u_password", nullable = false, length = 65)
	private String password;
	
	@Column(name="u_first_name", nullable = false, length = 20)
	private String firstName;
	
	@Column(name="u_last_name", nullable = false, length = 20)
	private String lastName;
	
	@Column(name="u_email", nullable = false, length = 45)
	private String email;
	
	@Column(name="u_user_role", nullable = false)
	//@ManyToOne
	private String userRole;
	//importing UserRole useRole later?

	public User() {
	}

	public User(String username, String password, String firstName, String lastName, String email, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}

	public User(int userId, String username, String password, String firstName, String lastName, String email,
			String userRole) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}
	
}
