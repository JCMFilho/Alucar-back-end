package com.api.aluguelcarro.model;

import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private String phone;
    private String creationDate;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id")
    )
    private List<Role> roles;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
    
    public User() {
    }

    public User(String name, String email, String cpf) {
        super();
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
    public User(User user) {
        super();
        this.name = user.getName();
        this.email = user.getEmail();
		this.phone = user.getPhone();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.id = user.getId();
        this.cpf = user.getCpf();
    }
    public User(String name, String email, String password, List<Role> roles, String cpf) {
        super();
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.cpf = cpf;
    }
	
	
}
