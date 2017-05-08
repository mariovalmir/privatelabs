package com.procergs.privatelabs.login;

import javax.ejb.Stateless;

import br.com.privatelabs.ed.UsuarioED;

@Stateless
public class UsuarioRN {

	public boolean login(UsuarioED usuarioED){
		return usuarioED.getUsuario().equals("admin") && usuarioED.getSenha().equals("admin");
	}
}
