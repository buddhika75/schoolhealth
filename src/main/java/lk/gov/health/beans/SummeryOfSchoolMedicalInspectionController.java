package lk.gov.health.beans;

import lk.gov.health.schoolhealth.SummeryOfSchoolMedicalInspection;
import lk.gov.health.beans.util.JsfUtil;
import lk.gov.health.beans.util.JsfUtil.PersistAction;
import lk.gov.health.faces.SummeryOfSchoolMedicalInspectionFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.inject.Inject;
import javax.inject.Named;
import lk.gov.health.schoolhealth.Area;

@Named
@SessionScoped
public class SummeryOfSchoolMedicalInspectionController implements Serializable {

    @Inject
    WebUserController webUserController;

    @EJB
    private lk.gov.health.faces.SummeryOfSchoolMedicalInspectionFacade ejbFacade;
    private List<SummeryOfSchoolMedicalInspection> items = null;
    private SummeryOfSchoolMedicalInspection selected;
    Area area;
    Date fromDate;
    Date toDate;

    public String toAddSummery() {
        selected = new SummeryOfSchoolMedicalInspection();
        return "/summeryOfSchoolMedicalInspection/add";
    }

    public String toViewMySummeries() {
        return "/summeryOfSchoolMedicalInspection/view_my_summery";
    }

    public String toViewPhiAreaSummeries() {
        return "/summeryOfSchoolMedicalInspection/view_phi_summeries";
    }

    public String toViewMohAreaSummeries() {
        return "/summeryOfSchoolMedicalInspection/view_moh_summeries";
    }

    public String toViewRdhsAreaSummeries() {
        return "/summeryOfSchoolMedicalInspection/view_rdhs_summeries";
    }

    public String toViewPdhsAreaSummeries() {
        return "/summeryOfSchoolMedicalInspection/view_pdhs_summeries";
    }

    public String viewMySummeries() {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.creator=:c and "
                + " s.dateExamined between :fd and :td ";
        m.put("c", webUserController.getLoggedUser());
        m.put("fd", fromDate);
        m.put("td", toDate);
        items = getFacade().findBySQL(j, m);
        return "/summeryOfSchoolMedicalInspection/view_my_summery";
    }

    public List<SummeryOfSchoolMedicalInspection> getPhiAreaSummeries(Date fd, Date td, Area phiArea) {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.dateExamined between :fd and :td and "
                + " s.phiArea=:a ";
        m.put("fd", fd);
        m.put("td", td);
        m.put("a", phiArea);
        return getFacade().findBySQL(j, m);
    }

    public String viewPhiAreaSummeries() {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.dateExamined between :fd and :td and "
                + " s.phiArea=:a ";
        m.put("fd", fromDate);
        m.put("td", toDate);
        m.put("a", area);
        items = getFacade().findBySQL(j, m);
        return "/summeryOfSchoolMedicalInspection/view_phi_summeries";
    }

    public String viewMohAreaSummeries() {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.dateExamined between :fd and :td and "
                + " s.mohArea=:a ";
        m.put("fd", fromDate);
        m.put("td", toDate);
        m.put("a", area);
        items = getFacade().findBySQL(j, m);
        return "/summeryOfSchoolMedicalInspection/view_moh_summeries";
    }

    public String viewRdhsAreaSummeries() {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.dateExamined between :fd and :td and "
                + " s.mohArea.parentArea=:a ";
        m.put("fd", fromDate);
        m.put("td", toDate);
        m.put("a", area);
        items = getFacade().findBySQL(j, m);
        return "/summeryOfSchoolMedicalInspection/view_rdhs_summeries";
    }

    public String viewPdhsAreaSummeries() {
        String j;
        Map m = new HashMap();
        j = "select s from SummeryOfSchoolMedicalInspection s "
                + " where s.dateExamined between :fd and :td and "
                + " s.mohArea.parentArea.parentArea=:a ";
        m.put("fd", fromDate);
        m.put("td", toDate);
        m.put("a", area);
        items = getFacade().findBySQL(j, m);
        return "/summeryOfSchoolMedicalInspection/view_pdhs_summeries";
    }

    public String saveSummery() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to save");
            return "";
        }
        if (selected.getId() == null) {
            selected.setCreatedAt(new Date());
            selected.setCreator(webUserController.getLoggedUser());
            getFacade().create(selected);
            JsfUtil.addSuccessMessage("Saved");
            return "";
        } else {
            getFacade().edit(selected);
            JsfUtil.addSuccessMessage("Updated");
            return "";
        }
    }

    public SummeryOfSchoolMedicalInspectionController() {
    }

    public SummeryOfSchoolMedicalInspection getSelected() {
        return selected;
    }

    public void setSelected(SummeryOfSchoolMedicalInspection selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SummeryOfSchoolMedicalInspectionFacade getFacade() {
        return ejbFacade;
    }

    public SummeryOfSchoolMedicalInspection prepareCreate() {
        selected = new SummeryOfSchoolMedicalInspection();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle2").getString("SummeryOfSchoolMedicalInspectionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle2").getString("SummeryOfSchoolMedicalInspectionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle2").getString("SummeryOfSchoolMedicalInspectionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SummeryOfSchoolMedicalInspection> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle2").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle2").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<SummeryOfSchoolMedicalInspection> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SummeryOfSchoolMedicalInspection> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public void calTotalNoOfChildren() {
        if (selected == null) {
            return;
        }
        selected.setTotalNoOfChildrenMale(
                selected.getTotalNoOfChildren1Male()
                + selected.getTotalNoOfChildren4Male()
                + selected.getTotalNoOfChildren7Male()
                + selected.getTotalNoOfChildren10Male()
                + selected.getTotalNoOfChildrenOtherMale()
        );
        selected.setTotalNoOfChildrenFemale(
                selected.getTotalNoOfChildren1Female()
                + selected.getTotalNoOfChildren4Female()
                + selected.getTotalNoOfChildren7Female()
                + selected.getTotalNoOfChildren10Female()
                + selected.getTotalNoOfChildrenOtherFemale()
        );
        int imp;
        int ifp;
        int tm = selected.getTotalNoOfChildrenMale();
        int tf = selected.getTotalNoOfChildrenFemale();
        if (tm + tf == 0) {
            imp = 0;
            ifp = 0;
        } else {
            imp = tm * 100 / (tm + tf);
            ifp = tf * 100 / (tm + tf);
        }
        selected.setTotalNoOfChildren1FemalePercentage(ifp);
        selected.setTotalNoOfChildrenMalePercentage(imp);
    }

    public void calNoOfChildrenExamined() {
        if (selected == null) {
            return;
        }
        selected.setNumberExaminedOfChildrenMale(
                selected.getNumberExaminedOfChildren1Male()
                + selected.getNumberExaminedOfChildren4Male()
                + selected.getNumberExaminedOfChildren7Male()
                + selected.getNumberExaminedOfChildren10Male()
                + selected.getNumberExaminedOfChildrenOtherMale()
        );
        selected.setNumberExaminedOfChildrenFemale(
                selected.getNumberExaminedOfChildren1Female()
                + selected.getNumberExaminedOfChildren4Female()
                + selected.getNumberExaminedOfChildren7Female()
                + selected.getNumberExaminedOfChildren10Female()
                + selected.getNumberExaminedOfChildrenOtherFemale()
        );
        int imp;
        int ifp;
        int tm = selected.getNumberExaminedOfChildrenMale();
        int tf = selected.getNumberExaminedOfChildrenFemale();
        if (tm + tf == 0) {
            imp = 0;
            ifp = 0;
        } else {
            imp = tm * 100 / (tm + tf);
            ifp = tf * 100 / (tm + tf);
        }
        selected.setNumberExaminedOfChildren1FemalePercentage(ifp);
        selected.setNumberExaminedOfChildrenMalePercentage(imp);
    }

    public Date getFromDate() {
        if (fromDate == null) {
            fromDate = webUserController.getFirstDayOfYear();
        }
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        if (toDate == null) {
            toDate = webUserController.getLastDayOfYear();
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @FacesConverter(forClass = SummeryOfSchoolMedicalInspection.class)
    public static class SummeryOfSchoolMedicalInspectionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SummeryOfSchoolMedicalInspectionController controller = (SummeryOfSchoolMedicalInspectionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "summeryOfSchoolMedicalInspectionController");
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
            if (object instanceof SummeryOfSchoolMedicalInspection) {
                SummeryOfSchoolMedicalInspection o = (SummeryOfSchoolMedicalInspection) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SummeryOfSchoolMedicalInspection.class.getName()});
                return null;
            }
        }

    }

}
