package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.procergs.privatelabs.infra.AppED;

@Entity
@Table(name="UNIDADE")
@NamedQuery(name = "UnidadeED.consulta", query = "select c from UnidadeED c where c.idUnidade = :id")
public class UnidadeED extends AppED<Long>{

	private static final long serialVersionUID = 2365056880056438252L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_UNIDADE")
    private Long idUnidade;
	
	@Column
	private String nome;

	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	@Override
	public Long getId() {
		return idUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
