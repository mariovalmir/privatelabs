package com.procergs.privatelabs.web;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.UsuarioED;
import com.procergs.privatelabs.login.UsuarioRN;
import com.procergs.privatelabs.util.FacesUtil;

@ManagedBean
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioED ed;

	@Inject
	private UsuarioRN usuarioRN;

	@PostConstruct
	private void init() {
		ed = new UsuarioED();
	}

	public void login() {
		boolean logou = usuarioRN.login(ed);
		if (!logou) {
			FacesUtil.error("Usuário ou senha inválidas");
			return;
		}

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String url = externalContext.getRequestContextPath() + "/";
		try {
			externalContext.getFlash().setKeepMessages(true);
			externalContext.redirect(url);
		} catch (IOException e) {
		}
	}

	public UsuarioED getEd() {
		return ed;
	}

	public void setEd(UsuarioED ed) {
		this.ed = ed;
	}
}
