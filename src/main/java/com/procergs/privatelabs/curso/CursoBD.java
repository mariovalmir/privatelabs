package com.procergs.privatelabs.curso;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.ed.CursoPesqED;
import com.procergs.privatelabs.infra.AppBD;

class CursoBD extends AppBD<CursoED, Integer> {

	@Override
	public DetachedCriteria montaCriterios(CursoED ed) {
		DetachedCriteria dc = DetachedCriteria.forClass(CursoED.class);

        // Filtros
		CursoPesqED ped = (CursoPesqED) ed;
		if (ped.getTituloCur() != null) {
            dc.add(Restrictions.ilike("tituloCur", ped.getTituloCur(), MatchMode.ANYWHERE));
        }
        if (ped.getVlrPreco() != null) {
        	dc.add(Restrictions.ge("vlrPreco", ped.getVlrPreco()));
        }
        if (ped.getVlrPrecoFinal() != null) {
        	dc.add(Restrictions.le("vlrPreco", ped.getVlrPrecoFinal()));
        }
        
		return dc;
	}

}
