package lk.gov.health.beans;

import lk.gov.health.schoolhealth.MonthlyStatementOfSchoolHealthActivities;
import lk.gov.health.beans.util.JsfUtil;
import lk.gov.health.beans.util.JsfUtil.PersistAction;
import lk.gov.health.faces.MonthlyStatementOfSchoolHealthActivitiesFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lk.gov.health.schoolhealth.HealthProblem;
import lk.gov.health.schoolhealth.Month;
import lk.gov.health.schoolhealth.MonthlyStatementSummeryDataForSingleInspection;
import lk.gov.health.schoolhealth.SummeryOfSchoolMedicalInspection;

@Named("monthlyStatementOfSchoolHealthActivitiesController")
@SessionScoped
public class MonthlyStatementOfSchoolHealthActivitiesController implements Serializable {

    @EJB
    private lk.gov.health.faces.MonthlyStatementOfSchoolHealthActivitiesFacade ejbFacade;
    @Inject
    SummeryOfSchoolMedicalInspectionController summeryOfSchoolMedicalInspectionController;
    @Inject
    WebUserController webUserController;

    private List<MonthlyStatementOfSchoolHealthActivities> items = null;
    private MonthlyStatementOfSchoolHealthActivities selected;

    int year;
    Month month;
    List<Integer> years;
    Area phiArea;

    public String toGenerateMonthlyStatement() {
        return "/monthlyStatementOfSchoolHealthActivities/generate";
    }

    public void updateMonthlyStatement() {
        getFacade().edit(selected);
        JsfUtil.addErrorMessage("Updated");
    }

    public String generateMonthlyStatement() {
        MonthlyStatementOfSchoolHealthActivities s;
        String j;
        Map m = new HashMap();
        j = " select m from MonthlyStatementOfSchoolHealthActivities m "
                + " where m.phiArea=:phi "
                + " and m.statementYear=:y "
                + " and m.statementMonthEnum=:m";
        m.put("phi", phiArea);
        m.put("y", year);
        m.put("m", month);
        s = getFacade().findFirstBySQL(j, m);
        if (s == null) {
            s = new MonthlyStatementOfSchoolHealthActivities();
            s.setStatementDate(webUserController.getLastDayOfMonth(year, month));
            s.setStatementYear(year);
            s.setStatementMonthEnum(month);
            s.setStatementMonth(webUserController.getIntMonth(month));
            s.setPhiArea(phiArea);
            s.setMohArea(phiArea.getParentArea());
            s.setRdhsArea(phiArea.getParentArea().getParentArea());
            getFacade().create(s);
        } else {
            JsfUtil.addErrorMessage("Already Generated. Please selete and generate again");
            return "";
        }
        Date fd = webUserController.getFirstDayOfMonth(year, month);
        Date td = webUserController.getLastDayOfMonth(year, month);
        List<SummeryOfSchoolMedicalInspection> summeries = summeryOfSchoolMedicalInspectionController.getPhiAreaSummeries(fd, td, phiArea);
        List<MonthlyStatementSummeryDataForSingleInspection> sumRows = new ArrayList<MonthlyStatementSummeryDataForSingleInspection>();

        for (SummeryOfSchoolMedicalInspection sum : summeries) {
            MonthlyStatementSummeryDataForSingleInspection ssi = new MonthlyStatementSummeryDataForSingleInspection();
            ssi.setMonthlyStatementOfSchoolHealthActivities(s);
            ssi.setSummeryOfSchoolMedicalInspection(sum);
            //
            ssi.setTotalNoOfChildren1Male(sum.getTotalNoOfChildren1Male());
            ssi.setTotalNoOfChildren1Female(sum.getTotalNoOfChildren1Female());
            ssi.setTotalNoOfChildren4Male(sum.getTotalNoOfChildren4Male());
            ssi.setTotalNoOfChildren4Female(sum.getTotalNoOfChildren4Female());
            ssi.setTotalNoOfChildren7Male(sum.getTotalNoOfChildren7Male());
            ssi.setTotalNoOfChildren7Female(sum.getTotalNoOfChildren7Female());
            ssi.setTotalNoOfChildren10Male(sum.getTotalNoOfChildren10Male());
            ssi.setTotalNoOfChildren10Female(sum.getTotalNoOfChildren10Female());
            ssi.setTotalNoOfChildrenOtherMale(sum.getTotalNoOfChildrenOtherMale());
            ssi.setTotalNoOfChildrenOtherFemale(sum.getTotalNoOfChildrenOtherFemale());
            ssi.setTotalNoOfChildrenMale(sum.getTotalNoOfChildrenMale());
            ssi.setTotalNoOfChildrenFemale(sum.getTotalNoOfChildrenFemale());
            ssi.setTotalNoOfChildrenMalePercentage(sum.getTotalNoOfChildrenMalePercentage());
            ssi.setTotalNoOfChildren1FemalePercentage(sum.getTotalNoOfChildren1FemalePercentage());
//
            ssi.setNumberExaminedOfChildren1Male(sum.getNumberExaminedOfChildren1Male());
            ssi.setNumberExaminedOfChildren1Female(sum.getNumberExaminedOfChildren1Female());
            ssi.setNumberExaminedOfChildren4Male(sum.getNumberExaminedOfChildren4Male());
            ssi.setNumberExaminedOfChildren4Female(sum.getNumberExaminedOfChildren4Female());
            ssi.setNumberExaminedOfChildren7Male(sum.getNumberExaminedOfChildren7Male());
            ssi.setNumberExaminedOfChildren7Female(sum.getNumberExaminedOfChildren7Female());
            ssi.setNumberExaminedOfChildren10Male(sum.getNumberExaminedOfChildren10Male());
            ssi.setNumberExaminedOfChildren10Female(sum.getNumberExaminedOfChildren10Female());
            ssi.setNumberExaminedOfChildrenOtherMale(sum.getNumberExaminedOfChildrenOtherMale());
            ssi.setNumberExaminedOfChildrenOtherFemale(sum.getNumberExaminedOfChildrenOtherFemale());
            ssi.setNumberExaminedOfChildrenMale(sum.getNumberExaminedOfChildrenMale());
            ssi.setNumberExaminedOfChildrenFemale(sum.getNumberExaminedOfChildrenFemale());
            ssi.setNumberExaminedOfChildrenMalePercentage(sum.getNumberExaminedOfChildrenMalePercentage());
            ssi.setNumberExaminedOfChildren1FemalePercentage(sum.getNumberExaminedOfChildren1FemalePercentage());
//            
            ssi.setStuntingOfChildren1Male(sum.getStuntingOfChildren1Male());
            ssi.setStuntingOfChildren1Female(sum.getStuntingOfChildren1Female());
            ssi.setStuntingOfChildren4Male(sum.getStuntingOfChildren4Male());
            ssi.setStuntingOfChildren4Female(sum.getStuntingOfChildren4Female());
            ssi.setStuntingOfChildren7Male(sum.getStuntingOfChildren7Male());
            ssi.setStuntingOfChildren7Female(sum.getStuntingOfChildren7Female());
            ssi.setStuntingOfChildren10Male(sum.getStuntingOfChildren10Male());
            ssi.setStuntingOfChildren10Female(sum.getStuntingOfChildren10Female());
            ssi.setStuntingOfChildrenOtherMale(sum.getStuntingOfChildrenOtherMale());
            ssi.setStuntingOfChildrenOtherFemale(sum.getStuntingOfChildrenOtherFemale());
            ssi.setStuntingOfChildrenMale(sum.getStuntingOfChildrenMale());
            ssi.setStuntingOfChildrenFemale(sum.getStuntingOfChildrenFemale());
            ssi.setStuntingOfChildrenMalePercentage(sum.getStuntingOfChildrenMalePercentage());
            ssi.setStuntingOfChildren1FemalePercentage(sum.getStuntingOfChildren1FemalePercentage());
//
            ssi.setWastingOfChildren1Male(sum.getWastingOfChildren1Male());
            ssi.setWastingOfChildren1Female(sum.getWastingOfChildren1Female());
            ssi.setWastingOfChildren4Male(sum.getWastingOfChildren4Male());
            ssi.setWastingOfChildren4Female(sum.getWastingOfChildren4Female());
            ssi.setWastingOfChildren7Male(sum.getWastingOfChildren7Male());
            ssi.setWastingOfChildren7Female(sum.getWastingOfChildren7Female());
            ssi.setWastingOfChildren10Male(sum.getWastingOfChildren10Male());
            ssi.setWastingOfChildren10Female(sum.getWastingOfChildren10Female());
            ssi.setWastingOfChildrenOtherMale(sum.getWastingOfChildrenOtherMale());
            ssi.setWastingOfChildrenOtherFemale(sum.getWastingOfChildrenOtherFemale());
            ssi.setWastingOfChildrenMale(sum.getWastingOfChildrenMale());
            ssi.setWastingOfChildrenFemale(sum.getWastingOfChildrenFemale());
            ssi.setWastingOfChildrenMalePercentage(sum.getWastingOfChildrenMalePercentage());
            ssi.setWastingOfChildren1FemalePercentage(sum.getWastingOfChildren1FemalePercentage());
//
            ssi.setOverweightOfChildren1Male(sum.getOverweightOfChildren1Male());
            ssi.setOverweightOfChildren1Female(sum.getOverweightOfChildren1Female());
            ssi.setOverweightOfChildren4Male(sum.getOverweightOfChildren4Male());
            ssi.setOverweightOfChildren4Female(sum.getOverweightOfChildren4Female());
            ssi.setOverweightOfChildren7Male(sum.getOverweightOfChildren7Male());
            ssi.setOverweightOfChildren7Female(sum.getOverweightOfChildren7Female());
            ssi.setOverweightOfChildren10Male(sum.getOverweightOfChildren10Male());
            ssi.setOverweightOfChildren10Female(sum.getOverweightOfChildren10Female());
            ssi.setOverweightOfChildrenOtherMale(sum.getOverweightOfChildrenOtherMale());
            ssi.setOverweightOfChildrenOtherFemale(sum.getOverweightOfChildrenOtherFemale());
            ssi.setOverweightOfChildrenMale(sum.getOverweightOfChildrenMale());
            ssi.setOverweightOfChildrenFemale(sum.getOverweightOfChildrenFemale());
            ssi.setOverweightOfChildrenMalePercentage(sum.getOverweightOfChildrenMalePercentage());
            ssi.setOverweightOfChildren1FemalePercentage(sum.getOverweightOfChildren1FemalePercentage());
//
            ssi.setObesityChildren1Male(sum.getObesityChildren1Male());
            ssi.setObesityChildren1Female(sum.getObesityChildren1Female());
            ssi.setObesityChildren4Male(sum.getObesityChildren4Male());
            ssi.setObesityChildren4Female(sum.getObesityChildren4Female());
            ssi.setObesityChildren7Male(sum.getObesityChildren7Male());
            ssi.setObesityChildren7Female(sum.getObesityChildren7Female());
            ssi.setObesityChildren10Male(sum.getObesityChildren10Male());
            ssi.setObesityChildren10Female(sum.getObesityChildren10Female());
            ssi.setObesityChildrenOtherMale(sum.getObesityChildrenOtherMale());
            ssi.setObesityChildrenOtherFemale(sum.getObesityChildrenOtherFemale());
            ssi.setObesityChildrenMale(sum.getObesityChildrenMale());
            ssi.setObesityChildrenFemale(sum.getObesityChildrenFemale());
            ssi.setObesityChildrenMalePercentage(sum.getObesityChildrenMalePercentage());
            ssi.setObesityChildren1FemalePercentage(sum.getObesityChildren1FemalePercentage());
//
            ssi.setVisualDefects(sum.getVisualDefectsChildren1Male()
                    + sum.getVisualDefectsChildren1Female()
                    + sum.getVisualDefectsChildren4Male()
                    + sum.getVisualDefectsChildren4Female()
                    + sum.getVisualDefectsChildren7Male()
                    + sum.getVisualDefectsChildren7Female()
                    + sum.getVisualDefectsChildren10Male()
                    + sum.getVisualDefectsChildren10Female()
                    + sum.getVisualDefectsChildrenOtherMale()
                    + sum.getVisualDefectsChildrenOtherFemale());

            ssi.setHearingDefects(sum.getHearingDefectsChildren1Male()
                    + sum.getHearingDefectsChildren1Female()
                    + sum.getHearingDefectsChildren4Male()
                    + sum.getHearingDefectsChildren4Female()
                    + sum.getHearingDefectsChildren7Male()
                    + sum.getHearingDefectsChildren7Female()
                    + sum.getHearingDefectsChildren10Male()
                    + sum.getHearingDefectsChildren10Female()
                    + sum.getHearingDefectsChildrenOtherMale()
                    + sum.getHearingDefectsChildrenOtherFemale());

            ssi.setSpeechDeefcts(sum.getSpeechDeefctsChildren1Male()
                    + sum.getSpeechDeefctsChildren1Female()
                    + sum.getSpeechDeefctsChildren4Male()
                    + sum.getSpeechDeefctsChildren4Female()
                    + sum.getSpeechDeefctsChildren7Male()
                    + sum.getSpeechDeefctsChildren7Female()
                    + sum.getSpeechDeefctsChildren10Male()
                    + sum.getSpeechDeefctsChildren10Female()
                    + sum.getSpeechDeefctsChildrenOtherMale()
                    + sum.getSpeechDeefctsChildrenOtherFemale());

            if (sum.getOtherHealthProblem1() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem1Children1Male()
                        + sum.getOtherHealthProblem1Children1Female()
                        + sum.getOtherHealthProblem1Children4Male()
                        + sum.getOtherHealthProblem1Children4Female()
                        + sum.getOtherHealthProblem1Children7Male()
                        + sum.getOtherHealthProblem1Children7Female()
                        + sum.getOtherHealthProblem1Children10Male()
                        + sum.getOtherHealthProblem1Children10Female()
                        + sum.getOtherHealthProblem1ChildrenOtherMale()
                        + sum.getOtherHealthProblem1ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem2() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem2Children1Male()
                        + sum.getOtherHealthProblem2Children1Female()
                        + sum.getOtherHealthProblem2Children4Male()
                        + sum.getOtherHealthProblem2Children4Female()
                        + sum.getOtherHealthProblem2Children7Male()
                        + sum.getOtherHealthProblem2Children7Female()
                        + sum.getOtherHealthProblem2Children10Male()
                        + sum.getOtherHealthProblem2Children10Female()
                        + sum.getOtherHealthProblem2ChildrenOtherMale()
                        + sum.getOtherHealthProblem2ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem3() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem3Children1Male()
                        + sum.getOtherHealthProblem3Children1Female()
                        + sum.getOtherHealthProblem3Children4Male()
                        + sum.getOtherHealthProblem3Children4Female()
                        + sum.getOtherHealthProblem3Children7Male()
                        + sum.getOtherHealthProblem3Children7Female()
                        + sum.getOtherHealthProblem3Children10Male()
                        + sum.getOtherHealthProblem3Children10Female()
                        + sum.getOtherHealthProblem3ChildrenOtherMale()
                        + sum.getOtherHealthProblem3ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem4() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem1Children1Male()
                        + sum.getOtherHealthProblem4Children1Female()
                        + sum.getOtherHealthProblem4Children4Male()
                        + sum.getOtherHealthProblem4Children4Female()
                        + sum.getOtherHealthProblem4Children7Male()
                        + sum.getOtherHealthProblem4Children7Female()
                        + sum.getOtherHealthProblem4Children10Male()
                        + sum.getOtherHealthProblem4Children10Female()
                        + sum.getOtherHealthProblem4ChildrenOtherMale()
                        + sum.getOtherHealthProblem4ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem5() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem5Children1Male()
                        + sum.getOtherHealthProblem5Children1Female()
                        + sum.getOtherHealthProblem5Children4Male()
                        + sum.getOtherHealthProblem5Children4Female()
                        + sum.getOtherHealthProblem5Children7Male()
                        + sum.getOtherHealthProblem5Children7Female()
                        + sum.getOtherHealthProblem5Children10Male()
                        + sum.getOtherHealthProblem5Children10Female()
                        + sum.getOtherHealthProblem5ChildrenOtherMale()
                        + sum.getOtherHealthProblem5ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem6() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem1Children1Male()
                        + sum.getOtherHealthProblem6Children1Female()
                        + sum.getOtherHealthProblem6Children4Male()
                        + sum.getOtherHealthProblem6Children4Female()
                        + sum.getOtherHealthProblem6Children7Male()
                        + sum.getOtherHealthProblem6Children7Female()
                        + sum.getOtherHealthProblem6Children10Male()
                        + sum.getOtherHealthProblem6Children10Female()
                        + sum.getOtherHealthProblem6ChildrenOtherMale()
                        + sum.getOtherHealthProblem6ChildrenOtherFemale());
            }

            if (sum.getOtherHealthProblem7() == HealthProblem.Pediculosis) {
                ssi.setPediculosis(sum.getOtherHealthProblem7Children1Male()
                        + sum.getOtherHealthProblem7Children1Female()
                        + sum.getOtherHealthProblem7Children4Male()
                        + sum.getOtherHealthProblem7Children4Female()
                        + sum.getOtherHealthProblem7Children7Male()
                        + sum.getOtherHealthProblem7Children7Female()
                        + sum.getOtherHealthProblem7Children10Male()
                        + sum.getOtherHealthProblem7Children10Female()
                        + sum.getOtherHealthProblem7ChildrenOtherMale()
                        + sum.getOtherHealthProblem7ChildrenOtherFemale());
            }
            
            

            sumRows.add(ssi);
        }
        s.setMonthlyStatementSummeryDataForSingleInspections(sumRows);
        getFacade().edit(s);
        selected = s;
        return "/monthlyStatementOfSchoolHealthActivities/monthly_statement";
    }

    public String saveMonthlyStatement() {
        return "";
    }

    public String toSearchMonthlyStatements() {
        items = new ArrayList<MonthlyStatementOfSchoolHealthActivities>();
        return "/monthlyStatementOfSchoolHealthActivities/search";
    }

    public String searchMonthlyStatements() {
        items = new ArrayList<MonthlyStatementOfSchoolHealthActivities>();
        String j;
        Map m = new HashMap();
        j = " select m from MonthlyStatementOfSchoolHealthActivities m "
                + " where m.phiArea=:phi "
                + " and m.statementYear=:y ";
        m.put("phi", phiArea);
        m.put("y", year);
        items = getFacade().findBySQL(j, m);
        return "/monthlyStatementOfSchoolHealthActivities/search";
    }

    public String viewMonthlyStatement() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to show");
            return "";
        }
        for (MonthlyStatementSummeryDataForSingleInspection s : selected.getMonthlyStatementSummeryDataForSingleInspections()) {
            System.out.println("s = " + s);
        }
        return "/monthlyStatementOfSchoolHealthActivities/monthly_statement";
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
