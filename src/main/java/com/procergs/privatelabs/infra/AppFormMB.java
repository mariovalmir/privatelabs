package com.procergs.privatelabs.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.procergs.privatelabs.util.FacesUtil;

public abstract class AppFormMB<ED extends AppED<PK>, PK> implements Serializable {

    private static final long serialVersionUID = 1L;

    private AppRN<ED, PK> rn;
    private PK id;
    private ED ed;

    @Inject
    MessageProvider provider;

    // Actions
    @PostConstruct
    public void init() {
        // Não executar caso seja uma ajax-request
        if (FacesContext.getCurrentInstance().isPostback()) {
            return;
        }

        // Não passou id por parâmetro, logo é inclusão
        if (id == null) {
            ed = criaED();
            return;
        }

        // Consulta/Edição
        ed = rn.consulta(id);

        if (ed == null) {
            // throw new RuntimeException("Registro não encontrado!");
            FacesUtil.error("Registro não encontrado com id " + id);
        }
    }

    public void salva() {
        if (ed.getId() == null) {
            ed = rn.inclui(ed);
            FacesUtil.info(provider.getMessage("registro.inclui-sucesso"));
        } else {
            ed = rn.altera(ed);
            FacesUtil.info(provider.getMessage("registro.altera-sucesso"));
        }
        ed = rn.consulta(ed.getId());
    }

    public String exclui() {
        rn.exclui(ed);
        FacesUtil.info(provider.getMessage("registro.exclui-sucesso"));
        return getPaginaListaObjeto();
    }

    /**
     * Prepara o ED do objeto para ser incluído
     *
     * @return
     */
    public abstract ED criaED();

    // Getters & Setters

    public boolean isInclusao() {
        if (ed == null || ed.getId() == null) {
            return true;
        }
        return false;
    }

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public ED getEd() {
        return ed;
    }

    public void setEd(ED ed) {
        this.ed = ed;
    }

    private String getPaginaListaObjeto() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.delete(sb.length() - 6, sb.length()); // remove sufixo FormMB
        sb.append("-list?faces-redirect=true");
        return sb.toString().toLowerCase();
    }

    public void setRN(AppRN<ED, PK> rn) {
        this.rn = rn;
    }

    public AppRN<ED, PK> getRN() {
        return rn;
    }

}
