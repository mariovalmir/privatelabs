
package com.procergs.privatelabs.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

@FacesConverter("produto")
public class ProdutoConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	    PickList p = (PickList) component;
	    DualListModel dl = (DualListModel) p.getValue();
	    for (int i = 0; i < dl.getSource().size(); i++) {
	        if (dl.getSource().get(i).toString().contentEquals(submittedValue)) {
	            return dl.getSource().get(i);
	        }
	    }
	    for (int i = 0; i < dl.getTarget().size(); i++) {
	        if (dl.getTarget().get(i).toString().contentEquals(submittedValue)) {
	            return dl.getTarget().get(i);
	        }
	    }
	    return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
	    return value.toString();
	}
	}
