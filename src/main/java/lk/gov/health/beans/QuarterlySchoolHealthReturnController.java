package lk.gov.health.beans;

import lk.gov.health.schoolhealth.QuarterlySchoolHealthReturn;
import lk.gov.health.beans.util.JsfUtil;
import lk.gov.health.beans.util.JsfUtil.PersistAction;
import lk.gov.health.faces.QuarterlySchoolHealthReturnFacade;

import java.io.Serializable;
import java.util.ArrayList;
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
import lk.gov.health.schoolhealth.Month;
import lk.gov.health.schoolhealth.MonthlyStatementOfSchoolHealthActivities;
import lk.gov.health.schoolhealth.MonthlyStatementSummeryDataForSingleInspection;
import lk.gov.health.schoolhealth.Quarter;

@Named
@SessionScoped
public class QuarterlySchoolHealthReturnController implements Serializable {

    @EJB
    private lk.gov.health.faces.QuarterlySchoolHealthReturnFacade ejbFacade;

    @Inject
    WebUserController webUserController;
    @Inject
    MonthlyStatementOfSchoolHealthActivitiesController monthlyStatementOfSchoolHealthActivitiesController;

    private List<QuarterlySchoolHealthReturn> items = null;
    private QuarterlySchoolHealthReturn selected;

    private int year;
    private Quarter quarter;
    private Area rdhs;
    private Area moh;

    public String toGenerateReturn() {

        return "/quarterlySchoolHealthReturn/generate";
    }

    public String generateReturn() {

        QuarterlySchoolHealthReturn s;
        String j;
        Map m = new HashMap();
        j = " select q from QuarterlySchoolHealthReturn q "
                + " where q.mohArea=:moh "
                + " and q.report_year=:y "
                + " and q.report_quarter=:q";
        m.put("moh", moh);
        m.put("y", year);
        m.put("q", quarter);
        s = getFacade().findFirstBySQL(j, m);
        if (s == null) {
            s = new QuarterlySchoolHealthReturn();
            s.setReturnDate(webUserController.getLastDayOfQuarter(year, quarter));
            s.setReport_year(year);
            s.setReport_quarter(webUserController.getIntQuarter(quarter));
            s.setReport_quarter_enum(quarter);
            s.setRdhs_division(rdhs);
            s.setPreparedDate(new Date());
            s.setPreparedBy(webUserController.getLoggedUser());
            getFacade().create(s);
        } else {
            JsfUtil.addErrorMessage("Already Generated. Please delete and generate again");
            return "";
        }

        List<MonthlyStatementOfSchoolHealthActivities> m1s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatements(year, moh, webUserController.getFirstMonthOfQuarter(quarter));
        List<MonthlyStatementOfSchoolHealthActivities> m2s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatements(year, moh, webUserController.getFirstMonthOfQuarter(quarter));
        List<MonthlyStatementOfSchoolHealthActivities> m3s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatements(year, moh, webUserController.getFirstMonthOfQuarter(quarter));

        for (MonthlyStatementOfSchoolHealthActivities m1 : m1s) {
//            ********************************************
            s.setStunting_1_m_fm(s.getStunting_1_m_fm() + m1.getTotalForTheMonth().getStuntingOfChildren1Male());
            s.setStunting_1_f_fm(s.getStunting_1_f_fm() + m1.getTotalForTheMonth().getStuntingOfChildren1Female());
            s.setStunting_4_m_fm(s.getStunting_4_m_fm() + m1.getTotalForTheMonth().getStuntingOfChildren4Male());
            s.setStunting_4_f_fm(s.getStunting_4_f_fm() + m1.getTotalForTheMonth().getStuntingOfChildren4Female());
//            ********************************************            
            s.setWasting_1_m_fm(s.getWasting_1_m_fm() + m1.getTotalForTheMonth().getWastingOfChildren1Male());
            s.setWasting_1_f_fm(s.getWasting_1_f_fm() + m1.getTotalForTheMonth().getWastingOfChildren1Female());
            s.setWasting_4_m_fm(s.getWasting_4_m_fm() + m1.getTotalForTheMonth().getWastingOfChildren4Male());
            s.setWasting_4_f_fm(s.getWasting_4_f_fm() + m1.getTotalForTheMonth().getWastingOfChildren4Female());
            s.setWasting_7_m_fm(s.getWasting_7_m_fm() + m1.getTotalForTheMonth().getWastingOfChildren7Male());
            s.setWasting_7_f_fm(s.getWasting_7_f_fm() + m1.getTotalForTheMonth().getWastingOfChildren7Female());
            s.setWasting_10_m_fm(s.getWasting_10_m_fm() + m1.getTotalForTheMonth().getWastingOfChildren10Male());
            s.setWasting_10_f_fm(s.getWasting_10_f_fm() + m1.getTotalForTheMonth().getWastingOfChildren10Female());
            s.setWasting_other_m_fm(s.getWasting_other_m_fm() + m1.getTotalForTheMonth().getWastingOfChildrenOtherMale());
            s.setWasting_other_f_fm(s.getWasting_other_f_fm() + m1.getTotalForTheMonth().getWastingOfChildrenOtherFemale());
//            ********************************************            
            s.setOverweight_1_m_fm(s.getOverweight_1_m_fm() + m1.getTotalForTheMonth().getOverweightOfChildren1Male());
            s.setOverweight_1_f_fm(s.getOverweight_1_f_fm() + m1.getTotalForTheMonth().getOverweightOfChildren1Female());
            s.setOverweight_4_m_fm(s.getOverweight_4_m_fm() + m1.getTotalForTheMonth().getOverweightOfChildren4Male());
            s.setOverweight_4_f_fm(s.getOverweight_4_f_fm() + m1.getTotalForTheMonth().getOverweightOfChildren4Female());
            s.setOverweight_7_m_fm(s.getOverweight_7_m_fm() + m1.getTotalForTheMonth().getOverweightOfChildren7Male());
            s.setOverweight_7_f_fm(s.getOverweight_7_f_fm() + m1.getTotalForTheMonth().getOverweightOfChildren7Female());
            s.setOverweight_10_m_fm(s.getOverweight_10_m_fm() + m1.getTotalForTheMonth().getOverweightOfChildren10Male());
            s.setOverweight_10_f_fm(s.getOverweight_10_f_fm() + m1.getTotalForTheMonth().getOverweightOfChildren10Female());
            s.setOverweight_other_m_fm(s.getOverweight_other_m_fm() + m1.getTotalForTheMonth().getOverweightOfChildrenOtherMale());
            s.setOverweight_other_f_fm(s.getOverweight_other_f_fm() + m1.getTotalForTheMonth().getOverweightOfChildrenOtherFemale());
//            ********************************************            
            s.setObesity_1_m_fm(s.getObesity_1_m_fm() + m1.getTotalForTheMonth().getObesityChildren1Male());
            s.setObesity_1_f_fm(s.getObesity_1_f_fm() + m1.getTotalForTheMonth().getObesityChildren1Female());
            s.setObesity_4_m_fm(s.getObesity_4_m_fm() + m1.getTotalForTheMonth().getObesityChildren4Male());
            s.setObesity_4_f_fm(s.getObesity_4_f_fm() + m1.getTotalForTheMonth().getObesityChildren4Female());
            s.setObesity_7_m_fm(s.getObesity_7_m_fm() + m1.getTotalForTheMonth().getObesityChildren7Male());
            s.setObesity_7_f_fm(s.getObesity_7_f_fm() + m1.getTotalForTheMonth().getObesityChildren7Female());
            s.setObesity_10_m_fm(s.getObesity_10_m_fm() + m1.getTotalForTheMonth().getObesityChildren10Male());
            s.setObesity_10_f_fm(s.getObesity_10_f_fm() + m1.getTotalForTheMonth().getObesityChildren10Female());
            s.setObesity_other_m_fm(s.getObesity_other_m_fm() + m1.getTotalForTheMonth().getObesityChildrenOtherMale());
            s.setObesity_other_f_fm(s.getObesity_other_f_fm() + m1.getTotalForTheMonth().getObesityChildrenOtherFemale());
//            ********************************************            
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setHearing_defects(s.getHearing_defects() + m1.getTotalForTheMonth().getHearingDefects());
            s.setSpeech_defects(s.getSpeech_defects() + m1.getTotalForTheMonth().getSpeechDeefcts());
            s.setPediculosis(s.getPediculosis()+ m1.getTotalForTheMonth().getPediculosis());
            
            s.setNight_blindness(s.getNight_blindness()+ m1.getTotalForTheMonth().getNightBlindness());
            
            s.setBitot_spots(s.getBitot_spots()+ m1.getTotalForTheMonth().getBitotSpots());
            
            s.setSquint(s.getSquint()+ m1.getTotalForTheMonth().getSquint());
            
            s.setPallor(s.getPallor()+ m1.getTotalForTheMonth().getPallor());
            
            s.setXeropthalmia(s.getXeropthalmia()+ m1.getTotalForTheMonth().getXeropthalmia());
            
            s.setAngular_stomatitis_or_glossitis(s.getAngular_stomatitis_or_glossitis()+ m1.getTotalForTheMonth().getAngularStomatitisGlossitis());
            
            s.setDental_caries(s.getDental_caries()+ m1.getTotalForTheMonth().getDentalCaries());
            
            s.setCalculus(s.getCalculus()+ m1.getTotalForTheMonth().getCalculus());
            
            s.setFluorosis(s.getFluorosis()+ m1.getTotalForTheMonth().getFluorosis());
            
            s.setMalocclusion(s.getMalocclusion()+ m1.getTotalForTheMonth().getMalocclusion());
            
            s.setGoitre(s.getGoitre()+ m1.getTotalForTheMonth().getGoitre());
            
            s.setEnt_defects(s.getEnt_defects()+ m1.getTotalForTheMonth().getEntDefects());
            
            s.setLymphadenopathy(s.getLymphadenopathy()+ m1.getTotalForTheMonth().getLympahdenopathy());
            
            s.setScabies(s.getScabies()+ m1.getTotalForTheMonth().getScabies());
            
            s.setHypopigmented_skin_patches(s.getHypopigmented_skin_patches() + m1.getTotalForTheMonth().getHypopigmentedAnaestheticPatches());
            
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setVisual_defects(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            

        }

        return "/quarterlySchoolHealthReturn/quarterly_health_return";
    }

    public String listMohReturns() {
        items = new ArrayList<QuarterlySchoolHealthReturn>();
        return "/quarterlySchoolHealthReturn/moh_returns";
    }

    public String listRdhsReturns() {
        items = new ArrayList<QuarterlySchoolHealthReturn>();
        return "/quarterlySchoolHealthReturn/rdhs_returns";
    }

    public String toEditReturn() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to Delete");
            return "";
        }
        return "/quarterlySchoolHealthReturn/quarterly_health_return";
    }

    public String deleteReturn() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to Delete");
            return "";
        }
        getFacade().remove(selected);
        JsfUtil.addSuccessMessage("Deleted");
        return "";
    }

    public String updateReturn() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to Save");
            return "";
        }
        if (selected.getId() == null) {
            getFacade().create(selected);
            JsfUtil.addSuccessMessage("Saved");
        } else {
            getFacade().edit(selected);
            JsfUtil.addSuccessMessage("Updated");
        }

        return "";
    }

    public QuarterlySchoolHealthReturnController() {
    }

    public QuarterlySchoolHealthReturn getSelected() {
        return selected;
    }

    public void setSelected(QuarterlySchoolHealthReturn selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private QuarterlySchoolHealthReturnFacade getFacade() {
        return ejbFacade;
    }

    public QuarterlySchoolHealthReturn prepareCreate() {
        selected = new QuarterlySchoolHealthReturn();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("QuarterlySchoolHealthReturnCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("QuarterlySchoolHealthReturnUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("QuarterlySchoolHealthReturnDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<QuarterlySchoolHealthReturn> getItems() {
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

    public List<QuarterlySchoolHealthReturn> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<QuarterlySchoolHealthReturn> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Area getRdhs() {
        return rdhs;
    }

    public void setRdhs(Area rdhs) {
        this.rdhs = rdhs;
    }

    public Area getMoh() {
        return moh;
    }

    public void setMoh(Area moh) {
        this.moh = moh;
    }

    @FacesConverter(forClass = QuarterlySchoolHealthReturn.class)
    public static class QuarterlySchoolHealthReturnControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuarterlySchoolHealthReturnController controller = (QuarterlySchoolHealthReturnController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "quarterlySchoolHealthReturnController");
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
            if (object instanceof QuarterlySchoolHealthReturn) {
                QuarterlySchoolHealthReturn o = (QuarterlySchoolHealthReturn) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), QuarterlySchoolHealthReturn.class.getName()});
                return null;
            }
        }

    }

}
