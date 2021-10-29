package br.com.alura.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
/*Quando extendemos esta classe, nossa entidade se tonar capaz de manipular os dados no banco. 
No entanto, esta pode ser uma abordagem ruim, pois nossa entidade acaba tendo muita responsabilidade.*/
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	
	@Username
	private String username;
	@Password
	private String password;
	@Roles
	private String role;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonbTransient//nao enviar quando um usuario for recuperado
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public static void inserir(Usuario usuario) {
		usuario.password = BcryptUtil.bcryptHash(usuario.password);
		usuario.role = validarUsername(usuario.username);
		usuario.persist();
	}

	private static String validarUsername(String username) {
		return username.equals("alura") ? "admin" : "user";
	}

}