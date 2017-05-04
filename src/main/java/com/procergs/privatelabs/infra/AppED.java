package com.procergs.privatelabs.infra;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.procergs.arqjava4.persistence.FrameworkED;
import com.procergs.arqjava4.persistence.PropLista;

@MappedSuperclass
public abstract class AppED<PK> implements FrameworkED<PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CTR_NRO_IP_ATU")
	private String ctrNroIpAtu;

	@Column(name = "CTR_USU_INC")
	private Long ctrUsuInc;
	
	@Column(name = "CTR_DTH_ATU")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ctrDthAtu;

	@Column(name = "CTR_NRO_IP_INC")
	private String ctrNroIpInc;

	@Column(name = "CTR_DTH_INC")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ctrDthInc;

	@Column(name = "CTR_USU_ATU")
	private Long ctrUsuAtu;
	
	@Transient
	private PropLista propLista = new PropLista();
	
	@Transient
	private boolean delete = false;

	public String getCtrNroIpAtu() {
		return ctrNroIpAtu;
	}

	public void setCtrNroIpAtu(String ctrNroIpAtu) {
		this.ctrNroIpAtu = ctrNroIpAtu;
	}

	public Long getCtrUsuInc() {
		return ctrUsuInc;
	}

	public void setCtrUsuInc(Long ctrUsuInc) {
		this.ctrUsuInc = ctrUsuInc;
	}

	public Calendar getCtrDthAtu() {
		return ctrDthAtu;
	}

	public void setCtrDthAtu(Calendar ctrDthAtu) {
		this.ctrDthAtu = ctrDthAtu;
	}

	public String getCtrNroIpInc() {
		return ctrNroIpInc;
	}

	public void setCtrNroIpInc(String ctrNroIpInc) {
		this.ctrNroIpInc = ctrNroIpInc;
	}

	public Calendar getCtrDthInc() {
		return ctrDthInc;
	}

	public void setCtrDthInc(Calendar ctrDthInc) {
		this.ctrDthInc = ctrDthInc;
	}

	public Long getCtrUsuAtu() {
		return ctrUsuAtu;
	}

	public void setCtrUsuAtu(Long ctrUsuAtu) {
		this.ctrUsuAtu = ctrUsuAtu;
	}

	public AppED() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrameworkED other = (FrameworkED) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	@Override
	public PropLista getPropLista() {
		return propLista;
	}

}