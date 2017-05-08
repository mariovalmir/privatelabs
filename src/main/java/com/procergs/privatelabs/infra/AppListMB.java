package com.procergs.privatelabs.infra;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.component.datatable.DataTable;
import org.slf4j.Logger;

public class AppListMB<ED extends AppED<?>, PED extends ED> implements Serializable {

    private static final long serialVersionUID = 1L;

    public void pesquisa() {
        pesquisa("form:lista");
    }

    public void pesquisa(String id) {
        DataTable datatable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        if (datatable != null) {
            datatable.setFirst(0);
        }
    }

    @Inject
    Logger logger;

    /**
     * RN que o MB chama.
     */
    AppRN<ED, ?> rn;

    /**
     * ED de pesquisa.
     */
    PED ped;

    @Inject
    MessageProvider provider;

    @Inject
    SessionFilter sessionFilter;

    // Actions

    @PostConstruct
    public void init() {
        initPesqED();
    }

    /**
     * Inicializa PesqED do ListMB com a instância que está na sessão do usuário. Caso não exista,
     * cria uma nova instância e adiciona na sessão.
     *
     */
    protected void initPesqED() {
        PED ped = sessionFilter.get(this.getClass());
        if (ped == null) {
            ped = criaPesqED();
            sessionFilter.add(getClass(), ped);
        }
        setPed(ped);
    }

    /**
     * Cria uma instância de PesqED.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected PED criaPesqED() {
        try {
            return ((Class<PED>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
        } catch (InstantiationException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Limpa os critérios de pesquisa.
     *
     */
    public void limpa() {
        sessionFilter.clear(this.getClass());
        setPed(criaPesqED());
    }

    public PED getPed() {
        return ped;
    }

    public void setPed(PED ped) {
        this.ped = ped;
    }

    public void setRN(AppRN<ED, ?> rn) {
        this.rn = rn;
    }

    public AppRN<ED, ?> getRN() {
        return rn;
    }

}
