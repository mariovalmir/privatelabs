package com.procergs.privatelabs.login;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.UsuarioED;
import com.procergs.privatelabs.infra.AppBD;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
public class UsuarioRN extends AppRN<UsuarioED, String> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBD bd;

	public boolean login(UsuarioED usuarioED) {
		return usuarioED.getUsuario().equals("admin") && usuarioED.getSenha().equals("admin");
	}

	@Override
	public AppBD<UsuarioED, String> getBd() {
		return bd;
	}
}
