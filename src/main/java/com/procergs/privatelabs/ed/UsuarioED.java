package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.procergs.privatelabs.enums.TipoUsuarioEnum;
import com.procergs.privatelabs.infra.AppED;

@Entity
@Table(name="USUARIO")
@NamedQuery(name = "UsuarioED.consulta", query = "select c from UsuarioED c where c.usuario = :id")
public class UsuarioED extends AppED<String>{

	private static final long serialVersionUID = 1L;
	@Id
	private String usuario;
    @Column
	private String senha;
    @Column
    private String nome;
    @Column(name = "TIPO_USUARIO")
    @Enumerated(EnumType.ORDINAL)
    private TipoUsuarioEnum tipoUsuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String getId() {
		return usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}