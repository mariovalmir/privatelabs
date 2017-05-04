package com.procergs.privatelabs.infra;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.procergs.arqjava4.persistence.FrameworkBDImpl;
import com.procergs.arqjava4.security.SessionMB;

public class AppBD<ED extends AppED<PK>, PK> extends FrameworkBDImpl<ED, PK> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Inject
	SessionMB sessionMB;
	
	@PostConstruct
	public void init() {
		super.setEntityManager(entityManager);
	}
	
	@Override
	public ED inclui(ED ed) {
		ed.setCtrDthInc(Calendar.getInstance());
		ed.setCtrNroIpInc(sessionMB.getNroIP());
		ed.setCtrUsuInc(Long.valueOf(sessionMB.getUser().getId()));
		return super.inclui(ed);
	}
	
	@Override
	public ED altera(ED ed) {
		ed.setCtrDthAtu(Calendar.getInstance());
		ed.setCtrNroIpAtu(sessionMB.getNroIP());
		ed.setCtrUsuAtu(Long.valueOf(sessionMB.getUser().getId()));
		return super.altera(ed);
	}

}
