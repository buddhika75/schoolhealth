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
        System.out.println("year = " + year);
        QuarterlySchoolHealthReturn s;
        String j;
        Map m = new HashMap();
        j = " select q from QuarterlySchoolHealthReturn q "
                + " where q.moh_area=:moh "
                + " and q.report_year=:y "
                + " and q.report_quarter_enum=:q";
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
            s.setMoh_area(moh);
            s.setPreparedDate(new Date());
            s.setPreparedBy(webUserController.getLoggedUser());
            s.setMonth_1(webUserController.getFirstMonthOfQuarter(quarter));
            s.setMonth_2(webUserController.getSecondMonthOfQuarter(quarter));
            s.setMonth_3(webUserController.getThirdMonthOfQuarter(quarter));
            getFacade().create(s);
        } else {
            JsfUtil.addErrorMessage("Already Generated. Please delete and generate again");
            return "";
        }
        System.out.println("year = " + year);
        List<MonthlyStatementOfSchoolHealthActivities> m1s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatementsOfMohArea(year, moh, webUserController.getFirstMonthOfQuarter(quarter));
        System.out.println("m1s = " + m1s);
        List<MonthlyStatementOfSchoolHealthActivities> m2s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatementsOfMohArea(year, moh, webUserController.getSecondMonthOfQuarter(quarter));
        List<MonthlyStatementOfSchoolHealthActivities> m3s
                = monthlyStatementOfSchoolHealthActivitiesController.getMonthlyStatementsOfMohArea(year, moh, webUserController.getThirdMonthOfQuarter(quarter));

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
            s.setVisual_defects_fm(s.getVisual_defects() + m1.getTotalForTheMonth().getVisualDefects());
            s.setHearing_defects_fm(s.getHearing_defects() + m1.getTotalForTheMonth().getHearingDefects());
            s.setSpeech_defects_fm(s.getSpeech_defects() + m1.getTotalForTheMonth().getSpeechDeefcts());
            s.setPediculosis_fm(s.getPediculosis() + m1.getTotalForTheMonth().getPediculosis());

            s.setNight_blindness_fm(s.getNight_blindness() + m1.getTotalForTheMonth().getNightBlindness());

            s.setBitot_spots_fm(s.getBitot_spots() + m1.getTotalForTheMonth().getBitotSpots());

            s.setSquint_fm(s.getSquint() + m1.getTotalForTheMonth().getSquint());

            s.setPallor_fm(s.getPallor() + m1.getTotalForTheMonth().getPallor());

            s.setXeropthalmia_fm(s.getXeropthalmia() + m1.getTotalForTheMonth().getXeropthalmia());

            s.setAngular_stomatitis_or_glossitis_fm(s.getAngular_stomatitis_or_glossitis() + m1.getTotalForTheMonth().getAngularStomatitisGlossitis());

            s.setDental_caries_fm(s.getDental_caries() + m1.getTotalForTheMonth().getDentalCaries());

            s.setCalculus_fm(s.getCalculus() + m1.getTotalForTheMonth().getCalculus());

            s.setFluorosis_fm(s.getFluorosis() + m1.getTotalForTheMonth().getFluorosis());

            s.setMalocclusion_fm(s.getMalocclusion() + m1.getTotalForTheMonth().getMalocclusion());

            s.setGoitre_fm(s.getGoitre() + m1.getTotalForTheMonth().getGoitre());

            s.setEnt_defects_fm(s.getEnt_defects() + m1.getTotalForTheMonth().getEntDefects());

            s.setLymphadenopathy_fm(s.getLymphadenopathy() + m1.getTotalForTheMonth().getLympahdenopathy());

            s.setScabies_fm(s.getScabies() + m1.getTotalForTheMonth().getScabies());

            s.setHypopigmented_skin_patches_fm(s.getHypopigmented_skin_patches() + m1.getTotalForTheMonth().getHypopigmentedAnaestheticPatches());

            s.setOther_skin_disorders_fm(s.getOther_skin_disorders() + m1.getTotalForTheMonth().getOtherSkinDisorders());

            s.setOrthopaedic_disorders_fm(s.getOrthopaedic_disorders() + m1.getTotalForTheMonth().getOrthopaedicDefects());

            s.setRheumatic_disorders_fm(s.getRheumatic_disorders() + m1.getTotalForTheMonth().getRheumaticDisorders());

            s.setHeart_diseases_fm(s.getHeart_diseases() + m1.getTotalForTheMonth().getHeartDeceases());

            s.setLung_diseases_fm(s.getLung_diseases() + m1.getTotalForTheMonth().getLungDiseases());

            s.setBronchial_asthma_fm(s.getBronchial_asthma() + m1.getTotalForTheMonth().getAsthma());

            s.setBehavioural_problems_fm(s.getBehavioural_problems() + m1.getTotalForTheMonth().getBehaviouralProblems());

            s.setLearning_difficulties_fm(s.getLearning_difficulties() + m1.getTotalForTheMonth().getLearningDifficulties());

            s.setOther_defects_fm(s.getOther_defects() + m1.getTotalForTheMonth().getOtherDefects());

        }

        for (MonthlyStatementOfSchoolHealthActivities m2 : m2s) {
//            ********************************************
            s.setStunting_1_m_sm(s.getStunting_1_m_sm() + m2.getTotalForTheMonth().getStuntingOfChildren1Male());
            s.setStunting_1_f_sm(s.getStunting_1_f_sm() + m2.getTotalForTheMonth().getStuntingOfChildren1Female());
            s.setStunting_4_m_sm(s.getStunting_4_m_sm() + m2.getTotalForTheMonth().getStuntingOfChildren4Male());
            s.setStunting_4_f_sm(s.getStunting_4_f_sm() + m2.getTotalForTheMonth().getStuntingOfChildren4Female());
//            ********************************************            
            s.setWasting_1_m_sm(s.getWasting_1_m_sm() + m2.getTotalForTheMonth().getWastingOfChildren1Male());
            s.setWasting_1_f_sm(s.getWasting_1_f_sm() + m2.getTotalForTheMonth().getWastingOfChildren1Female());
            s.setWasting_4_m_sm(s.getWasting_4_m_sm() + m2.getTotalForTheMonth().getWastingOfChildren4Male());
            s.setWasting_4_f_sm(s.getWasting_4_f_sm() + m2.getTotalForTheMonth().getWastingOfChildren4Female());
            s.setWasting_7_m_sm(s.getWasting_7_m_sm() + m2.getTotalForTheMonth().getWastingOfChildren7Male());
            s.setWasting_7_f_sm(s.getWasting_7_f_sm() + m2.getTotalForTheMonth().getWastingOfChildren7Female());
            s.setWasting_10_m_sm(s.getWasting_10_m_sm() + m2.getTotalForTheMonth().getWastingOfChildren10Male());
            s.setWasting_10_f_sm(s.getWasting_10_f_sm() + m2.getTotalForTheMonth().getWastingOfChildren10Female());
            s.setWasting_other_m_sm(s.getWasting_other_m_sm() + m2.getTotalForTheMonth().getWastingOfChildrenOtherMale());
            s.setWasting_other_f_sm(s.getWasting_other_f_sm() + m2.getTotalForTheMonth().getWastingOfChildrenOtherFemale());
//            ********************************************            
            s.setOverweight_1_m_sm(s.getOverweight_1_m_sm() + m2.getTotalForTheMonth().getOverweightOfChildren1Male());
            s.setOverweight_1_f_sm(s.getOverweight_1_f_sm() + m2.getTotalForTheMonth().getOverweightOfChildren1Female());
            s.setOverweight_4_m_sm(s.getOverweight_4_m_sm() + m2.getTotalForTheMonth().getOverweightOfChildren4Male());
            s.setOverweight_4_f_sm(s.getOverweight_4_f_sm() + m2.getTotalForTheMonth().getOverweightOfChildren4Female());
            s.setOverweight_7_m_sm(s.getOverweight_7_m_sm() + m2.getTotalForTheMonth().getOverweightOfChildren7Male());
            s.setOverweight_7_f_sm(s.getOverweight_7_f_sm() + m2.getTotalForTheMonth().getOverweightOfChildren7Female());
            s.setOverweight_10_m_sm(s.getOverweight_10_m_sm() + m2.getTotalForTheMonth().getOverweightOfChildren10Male());
            s.setOverweight_10_f_sm(s.getOverweight_10_f_sm() + m2.getTotalForTheMonth().getOverweightOfChildren10Female());
            s.setOverweight_other_m_sm(s.getOverweight_other_m_sm() + m2.getTotalForTheMonth().getOverweightOfChildrenOtherMale());
            s.setOverweight_other_f_sm(s.getOverweight_other_f_sm() + m2.getTotalForTheMonth().getOverweightOfChildrenOtherFemale());
//            ********************************************            
            s.setObesity_1_m_sm(s.getObesity_1_m_sm() + m2.getTotalForTheMonth().getObesityChildren1Male());
            s.setObesity_1_f_sm(s.getObesity_1_f_sm() + m2.getTotalForTheMonth().getObesityChildren1Female());
            s.setObesity_4_m_sm(s.getObesity_4_m_sm() + m2.getTotalForTheMonth().getObesityChildren4Male());
            s.setObesity_4_f_sm(s.getObesity_4_f_sm() + m2.getTotalForTheMonth().getObesityChildren4Female());
            s.setObesity_7_m_sm(s.getObesity_7_m_sm() + m2.getTotalForTheMonth().getObesityChildren7Male());
            s.setObesity_7_f_sm(s.getObesity_7_f_sm() + m2.getTotalForTheMonth().getObesityChildren7Female());
            s.setObesity_10_m_sm(s.getObesity_10_m_sm() + m2.getTotalForTheMonth().getObesityChildren10Male());
            s.setObesity_10_f_sm(s.getObesity_10_f_sm() + m2.getTotalForTheMonth().getObesityChildren10Female());
            s.setObesity_other_m_sm(s.getObesity_other_m_sm() + m2.getTotalForTheMonth().getObesityChildrenOtherMale());
            s.setObesity_other_f_sm(s.getObesity_other_f_sm() + m2.getTotalForTheMonth().getObesityChildrenOtherFemale());
//            ********************************************            
            s.setVisual_defects_sm(s.getVisual_defects() + m2.getTotalForTheMonth().getVisualDefects());
            s.setHearing_defects_sm(s.getHearing_defects() + m2.getTotalForTheMonth().getHearingDefects());
            s.setSpeech_defects_sm(s.getSpeech_defects() + m2.getTotalForTheMonth().getSpeechDeefcts());
            s.setPediculosis_sm(s.getPediculosis() + m2.getTotalForTheMonth().getPediculosis());
            s.setNight_blindness_sm(s.getNight_blindness() + m2.getTotalForTheMonth().getNightBlindness());
            s.setBitot_spots_sm(s.getBitot_spots() + m2.getTotalForTheMonth().getBitotSpots());
            s.setSquint_sm(s.getSquint() + m2.getTotalForTheMonth().getSquint());
            s.setPallor_sm(s.getPallor() + m2.getTotalForTheMonth().getPallor());
            s.setXeropthalmia_sm(s.getXeropthalmia() + m2.getTotalForTheMonth().getXeropthalmia());
            s.setAngular_stomatitis_or_glossitis_sm(s.getAngular_stomatitis_or_glossitis() + m2.getTotalForTheMonth().getAngularStomatitisGlossitis());
            s.setDental_caries_sm(s.getDental_caries() + m2.getTotalForTheMonth().getDentalCaries());
            s.setCalculus_sm(s.getCalculus() + m2.getTotalForTheMonth().getCalculus());
            s.setFluorosis_sm(s.getFluorosis() + m2.getTotalForTheMonth().getFluorosis());
            s.setMalocclusion_sm(s.getMalocclusion() + m2.getTotalForTheMonth().getMalocclusion());
            s.setGoitre_sm(s.getGoitre() + m2.getTotalForTheMonth().getGoitre());
            s.setEnt_defects_sm(s.getEnt_defects() + m2.getTotalForTheMonth().getEntDefects());
            s.setLymphadenopathy_sm(s.getLymphadenopathy() + m2.getTotalForTheMonth().getLympahdenopathy());
            s.setScabies_sm(s.getScabies() + m2.getTotalForTheMonth().getScabies());
            s.setHypopigmented_skin_patches_sm(s.getHypopigmented_skin_patches() + m2.getTotalForTheMonth().getHypopigmentedAnaestheticPatches());
            s.setOther_skin_disorders_sm(s.getOther_skin_disorders() + m2.getTotalForTheMonth().getOtherSkinDisorders());
            s.setOrthopaedic_disorders_sm(s.getOrthopaedic_disorders() + m2.getTotalForTheMonth().getOrthopaedicDefects());
            s.setRheumatic_disorders_sm(s.getRheumatic_disorders() + m2.getTotalForTheMonth().getRheumaticDisorders());
            s.setHeart_diseases_sm(s.getHeart_diseases() + m2.getTotalForTheMonth().getHeartDeceases());
            s.setLung_diseases_sm(s.getLung_diseases() + m2.getTotalForTheMonth().getLungDiseases());
            s.setBronchial_asthma_sm(s.getBronchial_asthma() + m2.getTotalForTheMonth().getAsthma());
            s.setBehavioural_problems_sm(s.getBehavioural_problems() + m2.getTotalForTheMonth().getBehaviouralProblems());
            s.setLearning_difficulties_sm(s.getLearning_difficulties() + m2.getTotalForTheMonth().getLearningDifficulties());
            s.setOther_defects_sm(s.getOther_defects() + m2.getTotalForTheMonth().getOtherDefects());
        }

        for (MonthlyStatementOfSchoolHealthActivities m3 : m3s) {
//            ********************************************
            s.setStunting_1_m_tm(s.getStunting_1_m_tm() + m3.getTotalForTheMonth().getStuntingOfChildren1Male());
            s.setStunting_1_f_tm(s.getStunting_1_f_tm() + m3.getTotalForTheMonth().getStuntingOfChildren1Female());
            s.setStunting_4_m_tm(s.getStunting_4_m_tm() + m3.getTotalForTheMonth().getStuntingOfChildren4Male());
            s.setStunting_4_f_tm(s.getStunting_4_f_tm() + m3.getTotalForTheMonth().getStuntingOfChildren4Female());
//            ********************************************            
            s.setWasting_1_m_tm(s.getWasting_1_m_tm() + m3.getTotalForTheMonth().getWastingOfChildren1Male());
            s.setWasting_1_f_tm(s.getWasting_1_f_tm() + m3.getTotalForTheMonth().getWastingOfChildren1Female());
            s.setWasting_4_m_tm(s.getWasting_4_m_tm() + m3.getTotalForTheMonth().getWastingOfChildren4Male());
            s.setWasting_4_f_tm(s.getWasting_4_f_tm() + m3.getTotalForTheMonth().getWastingOfChildren4Female());
            s.setWasting_7_m_tm(s.getWasting_7_m_tm() + m3.getTotalForTheMonth().getWastingOfChildren7Male());
            s.setWasting_7_f_tm(s.getWasting_7_f_tm() + m3.getTotalForTheMonth().getWastingOfChildren7Female());
            s.setWasting_10_m_tm(s.getWasting_10_m_tm() + m3.getTotalForTheMonth().getWastingOfChildren10Male());
            s.setWasting_10_f_tm(s.getWasting_10_f_tm() + m3.getTotalForTheMonth().getWastingOfChildren10Female());
            s.setWasting_other_m_tm(s.getWasting_other_m_tm() + m3.getTotalForTheMonth().getWastingOfChildrenOtherMale());
            s.setWasting_other_f_tm(s.getWasting_other_f_tm() + m3.getTotalForTheMonth().getWastingOfChildrenOtherFemale());
//            ********************************************            
            s.setOverweight_1_m_tm(s.getOverweight_1_m_tm() + m3.getTotalForTheMonth().getOverweightOfChildren1Male());
            s.setOverweight_1_f_tm(s.getOverweight_1_f_tm() + m3.getTotalForTheMonth().getOverweightOfChildren1Female());
            s.setOverweight_4_m_tm(s.getOverweight_4_m_tm() + m3.getTotalForTheMonth().getOverweightOfChildren4Male());
            s.setOverweight_4_f_tm(s.getOverweight_4_f_tm() + m3.getTotalForTheMonth().getOverweightOfChildren4Female());
            s.setOverweight_7_m_tm(s.getOverweight_7_m_tm() + m3.getTotalForTheMonth().getOverweightOfChildren7Male());
            s.setOverweight_7_f_tm(s.getOverweight_7_f_tm() + m3.getTotalForTheMonth().getOverweightOfChildren7Female());
            s.setOverweight_10_m_tm(s.getOverweight_10_m_tm() + m3.getTotalForTheMonth().getOverweightOfChildren10Male());
            s.setOverweight_10_f_tm(s.getOverweight_10_f_tm() + m3.getTotalForTheMonth().getOverweightOfChildren10Female());
            s.setOverweight_other_m_tm(s.getOverweight_other_m_tm() + m3.getTotalForTheMonth().getOverweightOfChildrenOtherMale());
            s.setOverweight_other_f_tm(s.getOverweight_other_f_tm() + m3.getTotalForTheMonth().getOverweightOfChildrenOtherFemale());
//            ********************************************            
            s.setObesity_1_m_tm(s.getObesity_1_m_tm() + m3.getTotalForTheMonth().getObesityChildren1Male());
            s.setObesity_1_f_tm(s.getObesity_1_f_tm() + m3.getTotalForTheMonth().getObesityChildren1Female());
            s.setObesity_4_m_tm(s.getObesity_4_m_tm() + m3.getTotalForTheMonth().getObesityChildren4Male());
            s.setObesity_4_f_tm(s.getObesity_4_f_tm() + m3.getTotalForTheMonth().getObesityChildren4Female());
            s.setObesity_7_m_tm(s.getObesity_7_m_tm() + m3.getTotalForTheMonth().getObesityChildren7Male());
            s.setObesity_7_f_tm(s.getObesity_7_f_tm() + m3.getTotalForTheMonth().getObesityChildren7Female());
            s.setObesity_10_m_tm(s.getObesity_10_m_tm() + m3.getTotalForTheMonth().getObesityChildren10Male());
            s.setObesity_10_f_tm(s.getObesity_10_f_tm() + m3.getTotalForTheMonth().getObesityChildren10Female());
            s.setObesity_other_m_tm(s.getObesity_other_m_tm() + m3.getTotalForTheMonth().getObesityChildrenOtherMale());
            s.setObesity_other_f_tm(s.getObesity_other_f_tm() + m3.getTotalForTheMonth().getObesityChildrenOtherFemale());
//            ********************************************            
            s.setVisual_defects_tm(s.getVisual_defects() + m3.getTotalForTheMonth().getVisualDefects());
            s.setHearing_defects_tm(s.getHearing_defects() + m3.getTotalForTheMonth().getHearingDefects());
            s.setSpeech_defects_tm(s.getSpeech_defects() + m3.getTotalForTheMonth().getSpeechDeefcts());
            s.setPediculosis_tm(s.getPediculosis() + m3.getTotalForTheMonth().getPediculosis());
            s.setNight_blindness_tm(s.getNight_blindness() + m3.getTotalForTheMonth().getNightBlindness());
            s.setBitot_spots_tm(s.getBitot_spots() + m3.getTotalForTheMonth().getBitotSpots());
            s.setSquint_tm(s.getSquint() + m3.getTotalForTheMonth().getSquint());
            s.setPallor_tm(s.getPallor() + m3.getTotalForTheMonth().getPallor());
            s.setXeropthalmia_tm(s.getXeropthalmia() + m3.getTotalForTheMonth().getXeropthalmia());
            s.setAngular_stomatitis_or_glossitis_tm(s.getAngular_stomatitis_or_glossitis() + m3.getTotalForTheMonth().getAngularStomatitisGlossitis());
            s.setDental_caries_tm(s.getDental_caries() + m3.getTotalForTheMonth().getDentalCaries());
            s.setCalculus_tm(s.getCalculus() + m3.getTotalForTheMonth().getCalculus());
            s.setFluorosis_tm(s.getFluorosis() + m3.getTotalForTheMonth().getFluorosis());
            s.setMalocclusion_tm(s.getMalocclusion() + m3.getTotalForTheMonth().getMalocclusion());
            s.setGoitre_tm(s.getGoitre() + m3.getTotalForTheMonth().getGoitre());
            s.setEnt_defects_tm(s.getEnt_defects() + m3.getTotalForTheMonth().getEntDefects());
            s.setLymphadenopathy_tm(s.getLymphadenopathy() + m3.getTotalForTheMonth().getLympahdenopathy());
            s.setScabies_tm(s.getScabies() + m3.getTotalForTheMonth().getScabies());
            s.setHypopigmented_skin_patches_tm(s.getHypopigmented_skin_patches() + m3.getTotalForTheMonth().getHypopigmentedAnaestheticPatches());
            s.setOther_skin_disorders_tm(s.getOther_skin_disorders() + m3.getTotalForTheMonth().getOtherSkinDisorders());
            s.setOrthopaedic_disorders_tm(s.getOrthopaedic_disorders() + m3.getTotalForTheMonth().getOrthopaedicDefects());
            s.setRheumatic_disorders_tm(s.getRheumatic_disorders() + m3.getTotalForTheMonth().getRheumaticDisorders());
            s.setHeart_diseases_tm(s.getHeart_diseases() + m3.getTotalForTheMonth().getHeartDeceases());
            s.setLung_diseases_tm(s.getLung_diseases() + m3.getTotalForTheMonth().getLungDiseases());
            s.setBronchial_asthma_tm(s.getBronchial_asthma() + m3.getTotalForTheMonth().getAsthma());
            s.setBehavioural_problems_tm(s.getBehavioural_problems() + m3.getTotalForTheMonth().getBehaviouralProblems());
            s.setLearning_difficulties_tm(s.getLearning_difficulties() + m3.getTotalForTheMonth().getLearningDifficulties());
            s.setOther_defects_tm(s.getOther_defects() + m3.getTotalForTheMonth().getOtherDefects());
        }

        selected = s;
        return "/quarterlySchoolHealthReturn/quarterly_health_return";
    }

    public String toListMohReturns() {
        items = null;
        return "/quarterlySchoolHealthReturn/moh_returns";
    }

    public String toListRdhsReturns() {
        items = null;
        return "/quarterlySchoolHealthReturn/rdhs_returns";
    }

    public String listMohReturns() {
        String j;
        Map m = new HashMap();
        j = " select q from QuarterlySchoolHealthReturn q "
                + " where q.moh_area=:moh "
                + " and q.report_year=:y "
                + " and q.report_quarter_enum=:q";
        m.put("moh", moh);
        m.put("y", year);
        m.put("q", quarter);
        items = getFacade().findBySQL(j, m);
        return "/quarterlySchoolHealthReturn/moh_returns";
    }

    public String listRdhsReturns() {
        String j;
        Map m = new HashMap();
        j = " select q from QuarterlySchoolHealthReturn q "
                + " where q.moh_area.parentArea=:r "
                + " and q.report_year=:y "
                + " and q.report_quarter_enum=:q";
        m.put("r", rdhs);
        m.put("y", year);
        m.put("q", quarter);
        items = getFacade().findBySQL(j, m);
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
