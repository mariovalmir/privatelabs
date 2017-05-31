
package com.procergs.privatelabs.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.procergs.privatelabs.ed.ProdutoED;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		PickList p = (PickList) component;
		DualListModel<ProdutoED> dl = (DualListModel<ProdutoED>) p.getValue();
		return dl.getSource().get(Integer.valueOf(submittedValue));
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		PickList p = (PickList) component;
		DualListModel<ProdutoED> dl = (DualListModel<ProdutoED>) p.getValue();
        return  String.valueOf(dl.getSource().indexOf(value));
	}
}
