package lk.gov.health.beans;

import lk.gov.health.schoolhealth.SchoolMedicalExaminationRecordItem;
import lk.gov.health.beans.util.JsfUtil;
import lk.gov.health.beans.util.JsfUtil.PersistAction;
import lk.gov.health.faces.SchoolMedicalExaminationRecordItemFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@SessionScoped
public class SchoolMedicalExaminationRecordItemController implements Serializable {

    @EJB
    private lk.gov.health.faces.SchoolMedicalExaminationRecordItemFacade ejbFacade;
    private List<SchoolMedicalExaminationRecordItem> items = null;
    private SchoolMedicalExaminationRecordItem selected;

    public SchoolMedicalExaminationRecordItemController() {
    }

    public SchoolMedicalExaminationRecordItem getSelected() {
        return selected;
    }

    public void setSelected(SchoolMedicalExaminationRecordItem selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SchoolMedicalExaminationRecordItemFacade getFacade() {
        return ejbFacade;
    }

    public SchoolMedicalExaminationRecordItem prepareCreate() {
        selected = new SchoolMedicalExaminationRecordItem();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SchoolMedicalExaminationRecordItemCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SchoolMedicalExaminationRecordItemUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SchoolMedicalExaminationRecordItemDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SchoolMedicalExaminationRecordItem> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<SchoolMedicalExaminationRecordItem> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SchoolMedicalExaminationRecordItem> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SchoolMedicalExaminationRecordItem.class)
    public static class SchoolMedicalExaminationRecordItemControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SchoolMedicalExaminationRecordItemController controller = (SchoolMedicalExaminationRecordItemController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "schoolMedicalExaminationRecordItemController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SchoolMedicalExaminationRecordItem) {
                SchoolMedicalExaminationRecordItem o = (SchoolMedicalExaminationRecordItem) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SchoolMedicalExaminationRecordItem.class.getName()});
                return null;
            }
        }

    }

}
