package com.procergs.privatelabs.produto;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.procergs.privatelabs.ed.ProdutoED;

@Stateless
public class ProdutoRN {

	private static List<ProdutoED> produtos = new ArrayList<>();
	
	public List<ProdutoED> listar(ProdutoED ed) {
		return produtos;
	}
//			p -> p.getSubstancia().equals(ed.getSubstancia())).findFirst().get();
//	return produtos.stream().filter(
	
	public void incluir(ProdutoED ed) {
		produtos.add(ed);
	}

}
