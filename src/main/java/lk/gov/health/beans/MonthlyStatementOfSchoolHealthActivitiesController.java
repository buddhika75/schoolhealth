package lk.gov.health.beans;

import lk.gov.health.schoolhealth.MonthlyStatementOfSchoolHealthActivities;
import lk.gov.health.beans.util.JsfUtil;
import lk.gov.health.beans.util.JsfUtil.PersistAction;
import lk.gov.health.faces.MonthlyStatementOfSchoolHealthActivitiesFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import lk.gov.health.schoolhealth.Area;
import lk.gov.health.schoolhealth.Month;
import lk.gov.health.schoolhealth.SummeryOfSchoolMedicalInspection;

@Named("monthlyStatementOfSchoolHealthActivitiesController")
@SessionScoped
public class MonthlyStatementOfSchoolHealthActivitiesController implements Serializable {

    @EJB
    private lk.gov.health.faces.MonthlyStatementOfSchoolHealthActivitiesFacade ejbFacade;
    @Inject
    SummeryOfSchoolMedicalInspectionController summeryOfSchoolMedicalInspectionController;

    private List<MonthlyStatementOfSchoolHealthActivities> items = null;
    private MonthlyStatementOfSchoolHealthActivities selected;

    int year;
    Month month;
    List<Integer> years;
    Area phiArea;

    public String toGenerateMonthlyStatement() {
        return "";
    }

    public String generateMonthlyStatement() {
        List<SummeryOfSchoolMedicalInspection> summeries = summeryOfSchoolMedicalInspectionController.getItems();
        return "/monthlyStatementOfSchoolHealthActivities/monthly_statement";
    }

    public String saveMonthlyStatement() {
        return "";
    }

    public String toSearchMonthlyStatements() {
        return "/monthlyStatementOfSchoolHealthActivities/search";
    }

    public String searchMonthlyStatements() {
        return "/monthlyStatementOfSchoolHealthActivities/search";
    }

    public MonthlyStatementOfSchoolHealthActivitiesController() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Integer> getYears() {
        if (years == null) {
            years = new ArrayList<Integer>();
            Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            years.add(y - 5);
            years.add(y - 4);
            years.add(y - 3);
            years.add(y - 2);
            years.add(y - 1);
            years.add(y);
            years.add(y + 1);
        }
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public Area getPhiArea() {
        return phiArea;
    }

    public void setPhiArea(Area phiArea) {
        this.phiArea = phiArea;
    }

    public MonthlyStatementOfSchoolHealthActivities getSelected() {
        return selected;
    }

    public void setSelected(MonthlyStatementOfSchoolHealthActivities selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MonthlyStatementOfSchoolHealthActivitiesFacade getFacade() {
        return ejbFacade;
    }

    public MonthlyStatementOfSchoolHealthActivities prepareCreate() {
        selected = new MonthlyStatementOfSchoolHealthActivities();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle4").getString("MonthlyStatementOfSchoolHealthActivitiesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle4").getString("MonthlyStatementOfSchoolHealthActivitiesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle4").getString("MonthlyStatementOfSchoolHealthActivitiesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<MonthlyStatementOfSchoolHealthActivities> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle4").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle4").getString("PersistenceErrorOccured"));
            }
        }
    }

    public MonthlyStatementOfSchoolHealthActivities getMonthlyStatementOfSchoolHealthActivities(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<MonthlyStatementOfSchoolHealthActivities> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<MonthlyStatementOfSchoolHealthActivities> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = MonthlyStatementOfSchoolHealthActivities.class)
    public static class MonthlyStatementOfSchoolHealthActivitiesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MonthlyStatementOfSchoolHealthActivitiesController controller = (MonthlyStatementOfSchoolHealthActivitiesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "monthlyStatementOfSchoolHealthActivitiesController");
            return controller.getMonthlyStatementOfSchoolHealthActivities(getKey(value));
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
            if (object instanceof MonthlyStatementOfSchoolHealthActivities) {
                MonthlyStatementOfSchoolHealthActivities o = (MonthlyStatementOfSchoolHealthActivities) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MonthlyStatementOfSchoolHealthActivities.class.getName()});
                return null;
            }
        }

    }

}
