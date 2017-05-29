package com.procergs.privatelabs.infra;

import static javax.ejb.TransactionAttributeType.SUPPORTS;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;


public class AppRN<ED extends AppED<PK>, PK> implements Serializable{
    private static final long serialVersionUID = 1L;

    private AppBD<ED, PK> bd;

    @TransactionAttribute(SUPPORTS)
    public ED consulta(PK id) {
        return getBd().consulta(id);
    }

    public ED inclui(ED ed) {
        return getBd().inclui(ed);
    }

    public ED altera(ED ed) {
        return getBd().altera(ed);
    }

    public void exclui(ED ed) {
    	getBd().exclui(ed);
    }

    public void exclui(List<ED> eds) {
        for (ED ed : eds) {
            exclui(ed);
        }
    }

    @TransactionAttribute(SUPPORTS)
    public List<ED> lista(ED ped){
        return getBd().lista(ped);
    }

    @TransactionAttribute(SUPPORTS)
    public int conta(ED ped){
        return getBd().conta(ped);
    }

	public AppBD<ED, PK> getBd() {
		return bd;
	}
}
