package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.procergs.privatelabs.infra.AppED;

public class CursoED extends AppED<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NRO_INT_CUR")
	@SequenceGenerator(name = "Curso_SEQ", sequenceName = "ID_CURSO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Curso_SEQ")
	private Integer nroIntCur;

	@Column(name = "VLR_PRECO")
	private Double vlrPreco;

	@Column(name = "TXT_SINOPSE_CUR")
	private String txtSinopseCur;

	@Column(name = "TITULO_CUR")
	private String tituloCur;

	public Integer getNroIntCur() {
		return this.nroIntCur;
	}

	public void setNroIntCur(Integer nroIntCur) {
		this.nroIntCur = nroIntCur;
	}

	public Double getVlrPreco() {
		return this.vlrPreco;
	}

	public void setVlrPreco(Double vlrPreco) {
		this.vlrPreco = vlrPreco;
	}

	public String getTxtSinopseCur() {
		return this.txtSinopseCur;
	}

	public void setTxtSinopseCur(String txtSinopseCur) {
		this.txtSinopseCur = txtSinopseCur;
	}

	public String getTituloCur() {
		return this.tituloCur;
	}

	public void setTituloCur(String tituloCur) {
		this.tituloCur = tituloCur;
	}

	@Override
	public Integer getId() {
		return nroIntCur;
	}

}
