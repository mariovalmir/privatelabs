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
        return bd.consulta(id);
    }

    public ED inclui(ED ed) {
        return bd.inclui(ed);
    }

    public ED altera(ED ed) {
        return bd.altera(ed);
    }

    public void exclui(ED ed) {
        bd.exclui(ed);
    }

    public void exclui(List<ED> eds) {
        for (ED ed : eds) {
            exclui(ed);
        }
    }

    @TransactionAttribute(SUPPORTS)
    public List<ED> lista(ED ped){
        return bd.lista(ped);
    }

    @TransactionAttribute(SUPPORTS)
    public int conta(ED ped){
        return bd.conta(ped);
    }

    public void setBD(AppBD<ED, PK> bd) {
        this.bd = bd;
    }
}
