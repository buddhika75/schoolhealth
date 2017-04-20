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

    public List<MonthlyStatementOfSchoolHealthActivities> getMonthlyStatements(int y, Area a, Month m) {
        String j;
        Map map = new HashMap();
        j = " select m from MonthlyStatementOfSchoolHealthActivities m "
                + " where m.phiArea.parentArea=:a "
                + " and m.statementYear=:y "
                + " and m.statementMonthEnum=:m";
        map.put("phi", phiArea);
        map.put("y", year);
        map.put("m", month);
        return getFacade().findBySQL(j, map);
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

        MonthlyStatementSummeryDataForSingleInspection totalColMonth = new MonthlyStatementSummeryDataForSingleInspection();
        MonthlyStatementSummeryDataForSingleInspection totalColYear = new MonthlyStatementSummeryDataForSingleInspection();
        MonthlyStatementSummeryDataForSingleInspection totalCorrectedMonth = new MonthlyStatementSummeryDataForSingleInspection();
        MonthlyStatementSummeryDataForSingleInspection totalCorrectedYear = new MonthlyStatementSummeryDataForSingleInspection();

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
            totalColMonth.setTotalNoOfChildrenMale(totalColMonth.getTotalNoOfChildrenMale() + ssi.getTotalNoOfChildrenMale());
            totalColMonth.setTotalNoOfChildrenFemale(totalColMonth.getTotalNoOfChildrenFemale() + ssi.getTotalNoOfChildrenFemale());
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
            totalColMonth.setNumberExaminedOfChildrenMale(totalColMonth.getNumberExaminedOfChildrenMale() + ssi.getNumberExaminedOfChildrenMale());
            totalColMonth.setNumberExaminedOfChildrenFemale(totalColMonth.getNumberExaminedOfChildrenFemale() + ssi.getNumberExaminedOfChildrenFemale());

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
            totalColMonth.setStuntingOfChildrenMale(totalColMonth.getStuntingOfChildrenMale() + ssi.getStuntingOfChildrenMale());
            totalColMonth.setStuntingOfChildrenFemale(totalColMonth.getStuntingOfChildrenFemale() + ssi.getStuntingOfChildrenFemale());

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
            totalColMonth.setWastingOfChildrenMale(totalColMonth.getWastingOfChildrenMale() + ssi.getWastingOfChildrenMale());
            totalColMonth.setWastingOfChildrenFemale(totalColMonth.getWastingOfChildrenFemale() + ssi.getWastingOfChildrenFemale());

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
            totalColMonth.setOverweightOfChildrenMale(totalColMonth.getOverweightOfChildrenMale() + ssi.getOverweightOfChildrenMale());
            totalColMonth.setOverweightOfChildrenFemale(totalColMonth.getOverweightOfChildrenFemale() + ssi.getOverweightOfChildrenFemale());

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
            totalColMonth.setObesityChildrenMale(totalColMonth.getObesityChildrenMale() + ssi.getObesityChildrenMale());
            totalColMonth.setObesityChildrenFemale(totalColMonth.getObesityChildrenFemale() + ssi.getObesityChildrenFemale());

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
            totalColMonth.setVisualDefects(totalColMonth.getVisualDefects() + ssi.getVisualDefects());

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
            totalColMonth.setHearingDefects(totalColMonth.getHearingDefects() + ssi.getHearingDefects());

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
            totalColMonth.setSpeechDeefcts(totalColMonth.getSpeechDeefcts() + ssi.getSpeechDeefcts());

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
            totalColMonth.setPediculosis(totalColMonth.getPediculosis() + ssi.getPediculosis());

//            *********************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Night_blindness) {
                ssi.setNightBlindness(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setNightBlindness(totalColMonth.getNightBlindness() + ssi.getNightBlindness());

//            *********************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Bitot_spots) {
                ssi.setBitotSpots(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setBitotSpots(totalColMonth.getBitotSpots() + ssi.getBitotSpots());

//            **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Squint) {
                ssi.setSquint(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setSquint(totalColMonth.getSquint() + ssi.getSquint());

            //            *********************************************************************************
            ssi.setPallor(sum.getPallorChildren1Male()
                    + sum.getPallorChildren1Female()
                    + sum.getPallorChildren4Male()
                    + sum.getPallorChildren4Female()
                    + sum.getPallorChildren7Male()
                    + sum.getPallorChildren7Female()
                    + sum.getPallorChildren10Male()
                    + sum.getPallorChildren10Female()
                    + sum.getPallorChildrenOtherMale()
                    + sum.getPallorChildrenOtherFemale());
            totalColMonth.setPallor(totalColMonth.getPallor() + ssi.getPallor());

//            **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Xeropthalmia) {
                ssi.setXeropthalmia(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setXeropthalmia(totalColMonth.getXeropthalmia() + ssi.getXeropthalmia());

//            **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Angular_stomatitis_Glossitis) {
                ssi.setAngularStomatitisGlossitis(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setAngularStomatitisGlossitis(totalColMonth.getAngularStomatitisGlossitis() + ssi.getAngularStomatitisGlossitis());

            //            *********************************************************************************   
            //            *********************************************************************************
            ssi.setDentalCaries(sum.getDentalCariesChildren1Male()
                    + sum.getDentalCariesChildren1Female()
                    + sum.getDentalCariesChildren4Male()
                    + sum.getDentalCariesChildren4Female()
                    + sum.getDentalCariesChildren7Male()
                    + sum.getDentalCariesChildren7Female()
                    + sum.getDentalCariesChildren10Male()
                    + sum.getDentalCariesChildren10Female()
                    + sum.getDentalCariesChildrenOtherMale()
                    + sum.getDentalCariesChildrenOtherFemale());
            totalColMonth.setDentalCaries(totalColMonth.getDentalCaries() + ssi.getDentalCaries());
            //            **************************************************************************************

            //            *********************************************************************************
            ssi.setCalculus(sum.getCalculusChildren1Male()
                    + sum.getCalculusChildren1Female()
                    + sum.getCalculusChildren4Male()
                    + sum.getCalculusChildren4Female()
                    + sum.getCalculusChildren7Male()
                    + sum.getCalculusChildren7Female()
                    + sum.getCalculusChildren10Male()
                    + sum.getCalculusChildren10Female()
                    + sum.getCalculusChildrenOtherMale()
                    + sum.getCalculusChildrenOtherFemale());
            totalColMonth.setCalculus(totalColMonth.getCalculus() + ssi.getCalculus());
            //            **************************************************************************************

//            **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Fluorosis) {
                ssi.setFluorosis(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setFluorosis(totalColMonth.getFluorosis() + ssi.getFluorosis());

//          **************************************************************            
//            **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Malocclusion) {
                ssi.setMalocclusion(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setMalocclusion(totalColMonth.getMalocclusion() + ssi.getMalocclusion());

//          **************************************************************************************
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Goitre) {
                ssi.setGoitre(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setGoitre(totalColMonth.getGoitre() + ssi.getGoitre());

//          **************************************************************    
            //            *********************************************************************************
            ssi.setEntDefects(sum.getEntDefectsChildren1Male()
                    + sum.getEntDefectsChildren1Female()
                    + sum.getEntDefectsChildren4Male()
                    + sum.getEntDefectsChildren4Female()
                    + sum.getEntDefectsChildren7Male()
                    + sum.getEntDefectsChildren7Female()
                    + sum.getEntDefectsChildren10Male()
                    + sum.getEntDefectsChildren10Female()
                    + sum.getEntDefectsChildrenOtherMale()
                    + sum.getEntDefectsChildrenOtherFemale());
            totalColMonth.setEntDefects(totalColMonth.getEntDefects() + ssi.getEntDefects());
            //            **************************************************************************************
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Lymphadenopathy) {
                ssi.setLympahdenopathy(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setLympahdenopathy(totalColMonth.getLympahdenopathy() + ssi.getLympahdenopathy());

//          **************************************************************    
            //            *********************************************************************************
            ssi.setEntDefects(sum.getEntDefectsChildren1Male()
                    + sum.getEntDefectsChildren1Female()
                    + sum.getEntDefectsChildren4Male()
                    + sum.getEntDefectsChildren4Female()
                    + sum.getEntDefectsChildren7Male()
                    + sum.getEntDefectsChildren7Female()
                    + sum.getEntDefectsChildren10Male()
                    + sum.getEntDefectsChildren10Female()
                    + sum.getEntDefectsChildrenOtherMale()
                    + sum.getEntDefectsChildrenOtherFemale());
            totalColMonth.setEntDefects(totalColMonth.getEntDefects() + ssi.getEntDefects());
            //            **************************************************************************************
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Scabies) {
                ssi.setScabies(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setScabies(totalColMonth.getScabies() + ssi.getScabies());

//          **************************************************************                
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Hypopigmented_anaesthetic_patches) {
                ssi.setHypopigmentedAnaestheticPatches(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setHypopigmentedAnaestheticPatches(totalColMonth.getHypopigmentedAnaestheticPatches() + ssi.getHypopigmentedAnaestheticPatches());

//          **************************************************************    
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Other_skin_disorders) {
                ssi.setOtherSkinDisorders(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setOtherSkinDisorders(totalColMonth.getOtherSkinDisorders() + ssi.getOtherSkinDisorders());

//          **************************************************************                
//          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Orthopaedic_defects) {
                ssi.setOrthopaedicDefects(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setOrthopaedicDefects(totalColMonth.getOrthopaedicDefects() + ssi.getOrthopaedicDefects());

//          **************************************************************               
            //          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Rheumatic_disorders) {
                ssi.setRheumaticDisorders(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setRheumaticDisorders(totalColMonth.getRheumaticDisorders() + ssi.getRheumaticDisorders());

//          **************************************************************               
            //            *********************************************************************************
            ssi.setHeartDeceases(sum.getHeartDeceasesChildren1Male()
                    + sum.getHeartDeceasesChildren1Female()
                    + sum.getHeartDeceasesChildren4Male()
                    + sum.getHeartDeceasesChildren4Female()
                    + sum.getHeartDeceasesChildren7Male()
                    + sum.getHeartDeceasesChildren7Female()
                    + sum.getHeartDeceasesChildren10Male()
                    + sum.getHeartDeceasesChildren10Female()
                    + sum.getHeartDeceasesChildrenOtherMale()
                    + sum.getHeartDeceasesChildrenOtherFemale());
            totalColMonth.setHeartDeceases(totalColMonth.getHeartDeceases() + ssi.getHeartDeceases());
            //            **************************************************************************************

            //          **************************************************************************************
            if (sum.getOtherHealthProblem1() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem2() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem2Children1Male()
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

            if (sum.getOtherHealthProblem3() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem3Children1Male()
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

            if (sum.getOtherHealthProblem4() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem5() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem5Children1Male()
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

            if (sum.getOtherHealthProblem6() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem1Children1Male()
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

            if (sum.getOtherHealthProblem7() == HealthProblem.Lung_diseases) {
                ssi.setLungDiseases(sum.getOtherHealthProblem7Children1Male()
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
            totalColMonth.setLungDiseases(totalColMonth.getLungDiseases() + ssi.getLungDiseases());

//          **************************************************************              
            //            *********************************************************************************
            ssi.setAsthma(sum.getAsthmaChildren1Male()
                    + sum.getAsthmaChildren1Female()
                    + sum.getAsthmaChildren4Male()
                    + sum.getAsthmaChildren4Female()
                    + sum.getAsthmaChildren7Male()
                    + sum.getAsthmaChildren7Female()
                    + sum.getAsthmaChildren10Male()
                    + sum.getAsthmaChildren10Female()
                    + sum.getAsthmaChildrenOtherMale()
                    + sum.getAsthmaChildrenOtherFemale());
            totalColMonth.setAsthma(totalColMonth.getAsthma() + ssi.getAsthma());
            //            **************************************************************************************
            //            *********************************************************************************
            ssi.setBehaviouralProblems(sum.getBehaviouralProblemsChildren1Male()
                    + sum.getBehaviouralProblemsChildren1Female()
                    + sum.getBehaviouralProblemsChildren4Male()
                    + sum.getBehaviouralProblemsChildren4Female()
                    + sum.getBehaviouralProblemsChildren7Male()
                    + sum.getBehaviouralProblemsChildren7Female()
                    + sum.getBehaviouralProblemsChildren10Male()
                    + sum.getBehaviouralProblemsChildren10Female()
                    + sum.getBehaviouralProblemsChildrenOtherMale()
                    + sum.getBehaviouralProblemsChildrenOtherFemale());
            totalColMonth.setBehaviouralProblems(totalColMonth.getBehaviouralProblems() + ssi.getBehaviouralProblems());
            //            **************************************************************************************
            //            *********************************************************************************
            ssi.setLearningDifficulties(sum.getLearningDifficultiesChildren1Male()
                    + sum.getLearningDifficultiesChildren1Female()
                    + sum.getLearningDifficultiesChildren4Male()
                    + sum.getLearningDifficultiesChildren4Female()
                    + sum.getLearningDifficultiesChildren7Male()
                    + sum.getLearningDifficultiesChildren7Female()
                    + sum.getLearningDifficultiesChildren10Male()
                    + sum.getLearningDifficultiesChildren10Female()
                    + sum.getLearningDifficultiesChildrenOtherMale()
                    + sum.getLearningDifficultiesChildrenOtherFemale());
            totalColMonth.setLearningDifficulties(totalColMonth.getLearningDifficulties() + ssi.getLearningDifficulties());
            //            **************************************************************************************

            /**
             *
             *
             *
             *
             *
             */
            sumRows.add(ssi);
        }
        s.setMonthlyStatementSummeryDataForSingleInspections(sumRows);
        s.setTotalForTheMonth(totalColMonth);
        s.setTotalForTheYear(totalColYear);
        s.setNumberCorrectedForTheMonth(totalCorrectedMonth);
        s.setNumberCorrectedForTheYear(totalCorrectedYear);

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

    public String deleteMonthlyStatement() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Nothing to show");
            return "";
        }
        try {
            getFacade().remove(selected);
            JsfUtil.addSuccessMessage("Deleted");
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Could NOT delete. " + e.getMessage());
        }
        return "";
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
