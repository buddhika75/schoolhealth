/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.schoolhealth;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class MonthlyStatementSummeryDataForSingleInspection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    SummeryOfSchoolMedicalInspection summeryOfSchoolMedicalInspection;
    @ManyToOne
    MonthlyStatementOfSchoolHealthActivities monthlyStatementOfSchoolHealthActivities;
    
    boolean screenedByPhi;
    int  screenedByPhiCount;
    
    int mohCount;
    int amohCount;
    int otherMoCount;
    int rmoAmoCount;
    int sphiCount;
    int phiCount;
    int phnsCount;
    int heoCount;
    int sdtCount;
    int phmCount;
    
    int totalNoOfStudentsInSchoolMale;
    int totalNoOfStudentsInSchoolFemale;
    
    private int totalNoOfChildren1Male;
    private int totalNoOfChildren1Female;
    private int totalNoOfChildren4Male;
    private int totalNoOfChildren4Female;
    private int totalNoOfChildren7Male;
    private int totalNoOfChildren7Female;
    private int totalNoOfChildren10Male;
    private int totalNoOfChildren10Female;
    private int totalNoOfChildrenOtherMale;
    private int totalNoOfChildrenOtherFemale;
    private int totalNoOfChildrenMale;
    private int totalNoOfChildrenFemale;
    private int totalNoOfChildrenMalePercentage;
    private int totalNoOfChildren1FemalePercentage;

    private int numberExaminedOfChildren1Male;
    private int numberExaminedOfChildren1Female;
    private int numberExaminedOfChildren4Male;
    private int numberExaminedOfChildren4Female;
    private int numberExaminedOfChildren7Male;
    private int numberExaminedOfChildren7Female;
    private int numberExaminedOfChildren10Male;
    private int numberExaminedOfChildren10Female;
    private int numberExaminedOfChildrenOtherMale;
    private int numberExaminedOfChildrenOtherFemale;
    private int numberExaminedOfChildrenMale;
    private int numberExaminedOfChildrenFemale;
    private int numberExaminedOfChildrenMalePercentage;
    private int numberExaminedOfChildren1FemalePercentage;

    private int stuntingOfChildren1Male;
    private int stuntingOfChildren1Female;
    private int stuntingOfChildren4Male;
    private int stuntingOfChildren4Female;
    private int stuntingOfChildren7Male;
    private int stuntingOfChildren7Female;
    private int stuntingOfChildren10Male;
    private int stuntingOfChildren10Female;
    private int stuntingOfChildrenOtherMale;
    private int stuntingOfChildrenOtherFemale;
    private int stuntingOfChildrenMale;
    private int stuntingOfChildrenFemale;
    private int stuntingOfChildrenMalePercentage;
    private int stuntingOfChildren1FemalePercentage;

    private int wastingOfChildren1Male;
    private int wastingOfChildren1Female;
    private int wastingOfChildren4Male;
    private int wastingOfChildren4Female;
    private int wastingOfChildren7Male;
    private int wastingOfChildren7Female;
    private int wastingOfChildren10Male;
    private int wastingOfChildren10Female;
    private int wastingOfChildrenOtherMale;
    private int wastingOfChildrenOtherFemale;
    private int wastingOfChildrenMale;
    private int wastingOfChildrenFemale;
    private int wastingOfChildrenMalePercentage;
    private int wastingOfChildren1FemalePercentage;

    private int overweightOfChildren1Male;
    private int overweightOfChildren1Female;
    private int overweightOfChildren4Male;
    private int overweightOfChildren4Female;
    private int overweightOfChildren7Male;
    private int overweightOfChildren7Female;
    private int overweightOfChildren10Male;
    private int overweightOfChildren10Female;
    private int overweightOfChildrenOtherMale;
    private int overweightOfChildrenOtherFemale;
    private int overweightOfChildrenMale;
    private int overweightOfChildrenFemale;
    private int overweightOfChildrenMalePercentage;
    private int overweightOfChildren1FemalePercentage;

    private int obesityChildren1Male;
    private int obesityChildren1Female;
    private int obesityChildren4Male;
    private int obesityChildren4Female;
    private int obesityChildren7Male;
    private int obesityChildren7Female;
    private int obesityChildren10Male;
    private int obesityChildren10Female;
    private int obesityChildrenOtherMale;
    private int obesityChildrenOtherFemale;
    private int obesityChildrenMale;
    private int obesityChildrenFemale;
    private int obesityChildrenMalePercentage;
    private int obesityChildren1FemalePercentage;

    private int visualDefects;
    private int hearingDefects;
    private int speechDeefcts;
    private int pediculosis;
    private int nightBlindness;
    private int bitotSpots;
    private int squint;
    private int pallor;
    private int xeropthalmia;
    private int angularStomatitisGlossitis;
    private int dentalCaries;
    private int calculus;
    private int fluorosis;
    private int malocclusion;
    private int goitre;
    private int entDefects;
    private int lympahdenopathy;
    private int scabies;
    private int hypopigmentedAnaestheticPatches;
    private int otherSkinDisorders;
    private int orthopaedicDefects;
    private int rheumaticDisorders;
    private int heartDeceases;
    private int lungDiseases;
    private int asthma;
    private int behaviouralProblems;
    private int learningDifficulties;
    private int otherDefects;
    String otherDefectsSpecify;
    int totalNoOfDefectsExcludingNutritionProblems;
    int noOfStudentsWithDefectsExcludingNutritionProblems;
    int noReferredExcludingNutritionProblems;

    public int getScreenedByPhiCount() {
        return screenedByPhiCount;
    }

    public void setScreenedByPhiCount(int screenedByPhiCount) {
        this.screenedByPhiCount = screenedByPhiCount;
    }

    
    public boolean isScreenedByPhi() {
        return screenedByPhi;
    }

    public void setScreenedByPhi(boolean screenedByPhi) {
        this.screenedByPhi = screenedByPhi;
    }

    public int getMohCount() {
        return mohCount;
    }

    public void setMohCount(int mohCount) {
        this.mohCount = mohCount;
    }

    public int getAmohCount() {
        return amohCount;
    }

    public void setAmohCount(int amohCount) {
        this.amohCount = amohCount;
    }

    public int getOtherMoCount() {
        return otherMoCount;
    }

    public void setOtherMoCount(int otherMoCount) {
        this.otherMoCount = otherMoCount;
    }

    public int getRmoAmoCount() {
        return rmoAmoCount;
    }

    public void setRmoAmoCount(int rmoAmoCount) {
        this.rmoAmoCount = rmoAmoCount;
    }

    public int getSphiCount() {
        return sphiCount;
    }

    public void setSphiCount(int sphiCount) {
        this.sphiCount = sphiCount;
    }

    public int getPhiCount() {
        return phiCount;
    }

    public void setPhiCount(int phiCount) {
        this.phiCount = phiCount;
    }

    public int getPhnsCount() {
        return phnsCount;
    }

    public void setPhnsCount(int phnsCount) {
        this.phnsCount = phnsCount;
    }

    public int getHeoCount() {
        return heoCount;
    }

    public void setHeoCount(int heoCount) {
        this.heoCount = heoCount;
    }

    public int getSdtCount() {
        return sdtCount;
    }

    public void setSdtCount(int sdtCount) {
        this.sdtCount = sdtCount;
    }

    public int getPhmCount() {
        return phmCount;
    }

    public void setPhmCount(int phmCount) {
        this.phmCount = phmCount;
    }

    public int getTotalNoOfStudentsInSchoolMale() {
        return totalNoOfStudentsInSchoolMale;
    }

    public void setTotalNoOfStudentsInSchoolMale(int totalNoOfStudentsInSchoolMale) {
        this.totalNoOfStudentsInSchoolMale = totalNoOfStudentsInSchoolMale;
    }

    public int getTotalNoOfStudentsInSchoolFemale() {
        return totalNoOfStudentsInSchoolFemale;
    }

    public void setTotalNoOfStudentsInSchoolFemale(int totalNoOfStudentsInSchoolFemale) {
        this.totalNoOfStudentsInSchoolFemale = totalNoOfStudentsInSchoolFemale;
    }

    
    
    public SummeryOfSchoolMedicalInspection getSummeryOfSchoolMedicalInspection() {
        return summeryOfSchoolMedicalInspection;
    }

    public void setSummeryOfSchoolMedicalInspection(SummeryOfSchoolMedicalInspection summeryOfSchoolMedicalInspection) {
        this.summeryOfSchoolMedicalInspection = summeryOfSchoolMedicalInspection;
    }

    public MonthlyStatementOfSchoolHealthActivities getMonthlyStatementOfSchoolHealthActivities() {
        return monthlyStatementOfSchoolHealthActivities;
    }

    public void setMonthlyStatementOfSchoolHealthActivities(MonthlyStatementOfSchoolHealthActivities monthlyStatementOfSchoolHealthActivities) {
        this.monthlyStatementOfSchoolHealthActivities = monthlyStatementOfSchoolHealthActivities;
    }

    public int getTotalNoOfChildren1Male() {
        return totalNoOfChildren1Male;
    }

    public void setTotalNoOfChildren1Male(int totalNoOfChildren1Male) {
        this.totalNoOfChildren1Male = totalNoOfChildren1Male;
    }

    public int getTotalNoOfChildren1Female() {
        return totalNoOfChildren1Female;
    }

    public void setTotalNoOfChildren1Female(int totalNoOfChildren1Female) {
        this.totalNoOfChildren1Female = totalNoOfChildren1Female;
    }

    public int getTotalNoOfChildren4Male() {
        return totalNoOfChildren4Male;
    }

    public void setTotalNoOfChildren4Male(int totalNoOfChildren4Male) {
        this.totalNoOfChildren4Male = totalNoOfChildren4Male;
    }

    public int getTotalNoOfChildren4Female() {
        return totalNoOfChildren4Female;
    }

    public void setTotalNoOfChildren4Female(int totalNoOfChildren4Female) {
        this.totalNoOfChildren4Female = totalNoOfChildren4Female;
    }

    public int getTotalNoOfChildren7Male() {
        return totalNoOfChildren7Male;
    }

    public void setTotalNoOfChildren7Male(int totalNoOfChildren7Male) {
        this.totalNoOfChildren7Male = totalNoOfChildren7Male;
    }

    public int getTotalNoOfChildren7Female() {
        return totalNoOfChildren7Female;
    }

    public void setTotalNoOfChildren7Female(int totalNoOfChildren7Female) {
        this.totalNoOfChildren7Female = totalNoOfChildren7Female;
    }

    public int getTotalNoOfChildren10Male() {
        return totalNoOfChildren10Male;
    }

    public void setTotalNoOfChildren10Male(int totalNoOfChildren10Male) {
        this.totalNoOfChildren10Male = totalNoOfChildren10Male;
    }

    public int getTotalNoOfChildren10Female() {
        return totalNoOfChildren10Female;
    }

    public void setTotalNoOfChildren10Female(int totalNoOfChildren10Female) {
        this.totalNoOfChildren10Female = totalNoOfChildren10Female;
    }

    public int getTotalNoOfChildrenOtherMale() {
        return totalNoOfChildrenOtherMale;
    }

    public void setTotalNoOfChildrenOtherMale(int totalNoOfChildrenOtherMale) {
        this.totalNoOfChildrenOtherMale = totalNoOfChildrenOtherMale;
    }

    public int getTotalNoOfChildrenOtherFemale() {
        return totalNoOfChildrenOtherFemale;
    }

    public void setTotalNoOfChildrenOtherFemale(int totalNoOfChildrenOtherFemale) {
        this.totalNoOfChildrenOtherFemale = totalNoOfChildrenOtherFemale;
    }

    public int getTotalNoOfChildrenMale() {
        return totalNoOfChildrenMale;
    }

    public void setTotalNoOfChildrenMale(int totalNoOfChildrenMale) {
        this.totalNoOfChildrenMale = totalNoOfChildrenMale;
    }

    public int getTotalNoOfChildrenFemale() {
        return totalNoOfChildrenFemale;
    }

    public void setTotalNoOfChildrenFemale(int totalNoOfChildrenFemale) {
        this.totalNoOfChildrenFemale = totalNoOfChildrenFemale;
    }

    public int getTotalNoOfChildrenMalePercentage() {
        return totalNoOfChildrenMalePercentage;
    }

    public void setTotalNoOfChildrenMalePercentage(int totalNoOfChildrenMalePercentage) {
        this.totalNoOfChildrenMalePercentage = totalNoOfChildrenMalePercentage;
    }

    public int getTotalNoOfChildren1FemalePercentage() {
        return totalNoOfChildren1FemalePercentage;
    }

    public void setTotalNoOfChildren1FemalePercentage(int totalNoOfChildren1FemalePercentage) {
        this.totalNoOfChildren1FemalePercentage = totalNoOfChildren1FemalePercentage;
    }

    public int getNumberExaminedOfChildren1Male() {
        return numberExaminedOfChildren1Male;
    }

    public void setNumberExaminedOfChildren1Male(int numberExaminedOfChildren1Male) {
        this.numberExaminedOfChildren1Male = numberExaminedOfChildren1Male;
    }

    public int getNumberExaminedOfChildren1Female() {
        return numberExaminedOfChildren1Female;
    }

    public void setNumberExaminedOfChildren1Female(int numberExaminedOfChildren1Female) {
        this.numberExaminedOfChildren1Female = numberExaminedOfChildren1Female;
    }

    public int getNumberExaminedOfChildren4Male() {
        return numberExaminedOfChildren4Male;
    }

    public void setNumberExaminedOfChildren4Male(int numberExaminedOfChildren4Male) {
        this.numberExaminedOfChildren4Male = numberExaminedOfChildren4Male;
    }

    public int getNumberExaminedOfChildren4Female() {
        return numberExaminedOfChildren4Female;
    }

    public void setNumberExaminedOfChildren4Female(int numberExaminedOfChildren4Female) {
        this.numberExaminedOfChildren4Female = numberExaminedOfChildren4Female;
    }

    public int getNumberExaminedOfChildren7Male() {
        return numberExaminedOfChildren7Male;
    }

    public void setNumberExaminedOfChildren7Male(int numberExaminedOfChildren7Male) {
        this.numberExaminedOfChildren7Male = numberExaminedOfChildren7Male;
    }

    public int getNumberExaminedOfChildren7Female() {
        return numberExaminedOfChildren7Female;
    }

    public void setNumberExaminedOfChildren7Female(int numberExaminedOfChildren7Female) {
        this.numberExaminedOfChildren7Female = numberExaminedOfChildren7Female;
    }

    public int getNumberExaminedOfChildren10Male() {
        return numberExaminedOfChildren10Male;
    }

    public void setNumberExaminedOfChildren10Male(int numberExaminedOfChildren10Male) {
        this.numberExaminedOfChildren10Male = numberExaminedOfChildren10Male;
    }

    public int getNumberExaminedOfChildren10Female() {
        return numberExaminedOfChildren10Female;
    }

    public void setNumberExaminedOfChildren10Female(int numberExaminedOfChildren10Female) {
        this.numberExaminedOfChildren10Female = numberExaminedOfChildren10Female;
    }

    public int getNumberExaminedOfChildrenOtherMale() {
        return numberExaminedOfChildrenOtherMale;
    }

    public void setNumberExaminedOfChildrenOtherMale(int numberExaminedOfChildrenOtherMale) {
        this.numberExaminedOfChildrenOtherMale = numberExaminedOfChildrenOtherMale;
    }

    public int getNumberExaminedOfChildrenOtherFemale() {
        return numberExaminedOfChildrenOtherFemale;
    }

    public void setNumberExaminedOfChildrenOtherFemale(int numberExaminedOfChildrenOtherFemale) {
        this.numberExaminedOfChildrenOtherFemale = numberExaminedOfChildrenOtherFemale;
    }

    public int getNumberExaminedOfChildrenMale() {
        return numberExaminedOfChildrenMale;
    }

    public void setNumberExaminedOfChildrenMale(int numberExaminedOfChildrenMale) {
        this.numberExaminedOfChildrenMale = numberExaminedOfChildrenMale;
    }

    public int getNumberExaminedOfChildrenFemale() {
        return numberExaminedOfChildrenFemale;
    }

    public void setNumberExaminedOfChildrenFemale(int numberExaminedOfChildrenFemale) {
        this.numberExaminedOfChildrenFemale = numberExaminedOfChildrenFemale;
    }

    public int getNumberExaminedOfChildrenMalePercentage() {
        return numberExaminedOfChildrenMalePercentage;
    }

    public void setNumberExaminedOfChildrenMalePercentage(int numberExaminedOfChildrenMalePercentage) {
        this.numberExaminedOfChildrenMalePercentage = numberExaminedOfChildrenMalePercentage;
    }

    public int getNumberExaminedOfChildren1FemalePercentage() {
        return numberExaminedOfChildren1FemalePercentage;
    }

    public void setNumberExaminedOfChildren1FemalePercentage(int numberExaminedOfChildren1FemalePercentage) {
        this.numberExaminedOfChildren1FemalePercentage = numberExaminedOfChildren1FemalePercentage;
    }

    public int getStuntingOfChildren1Male() {
        return stuntingOfChildren1Male;
    }

    public void setStuntingOfChildren1Male(int stuntingOfChildren1Male) {
        this.stuntingOfChildren1Male = stuntingOfChildren1Male;
    }

    public int getStuntingOfChildren1Female() {
        return stuntingOfChildren1Female;
    }

    public void setStuntingOfChildren1Female(int stuntingOfChildren1Female) {
        this.stuntingOfChildren1Female = stuntingOfChildren1Female;
    }

    public int getStuntingOfChildren4Male() {
        return stuntingOfChildren4Male;
    }

    public void setStuntingOfChildren4Male(int stuntingOfChildren4Male) {
        this.stuntingOfChildren4Male = stuntingOfChildren4Male;
    }

    public int getStuntingOfChildren4Female() {
        return stuntingOfChildren4Female;
    }

    public void setStuntingOfChildren4Female(int stuntingOfChildren4Female) {
        this.stuntingOfChildren4Female = stuntingOfChildren4Female;
    }

    public int getStuntingOfChildren7Male() {
        return stuntingOfChildren7Male;
    }

    public void setStuntingOfChildren7Male(int stuntingOfChildren7Male) {
        this.stuntingOfChildren7Male = stuntingOfChildren7Male;
    }

    public int getStuntingOfChildren7Female() {
        return stuntingOfChildren7Female;
    }

    public void setStuntingOfChildren7Female(int stuntingOfChildren7Female) {
        this.stuntingOfChildren7Female = stuntingOfChildren7Female;
    }

    public int getStuntingOfChildren10Male() {
        return stuntingOfChildren10Male;
    }

    public void setStuntingOfChildren10Male(int stuntingOfChildren10Male) {
        this.stuntingOfChildren10Male = stuntingOfChildren10Male;
    }

    public int getStuntingOfChildren10Female() {
        return stuntingOfChildren10Female;
    }

    public void setStuntingOfChildren10Female(int stuntingOfChildren10Female) {
        this.stuntingOfChildren10Female = stuntingOfChildren10Female;
    }

    public int getStuntingOfChildrenOtherMale() {
        return stuntingOfChildrenOtherMale;
    }

    public void setStuntingOfChildrenOtherMale(int stuntingOfChildrenOtherMale) {
        this.stuntingOfChildrenOtherMale = stuntingOfChildrenOtherMale;
    }

    public int getStuntingOfChildrenOtherFemale() {
        return stuntingOfChildrenOtherFemale;
    }

    public void setStuntingOfChildrenOtherFemale(int stuntingOfChildrenOtherFemale) {
        this.stuntingOfChildrenOtherFemale = stuntingOfChildrenOtherFemale;
    }

    public int getStuntingOfChildrenMale() {
        return stuntingOfChildrenMale;
    }

    public void setStuntingOfChildrenMale(int stuntingOfChildrenMale) {
        this.stuntingOfChildrenMale = stuntingOfChildrenMale;
    }

    public int getStuntingOfChildrenFemale() {
        return stuntingOfChildrenFemale;
    }

    public void setStuntingOfChildrenFemale(int stuntingOfChildrenFemale) {
        this.stuntingOfChildrenFemale = stuntingOfChildrenFemale;
    }

    public int getStuntingOfChildrenMalePercentage() {
        return stuntingOfChildrenMalePercentage;
    }

    public void setStuntingOfChildrenMalePercentage(int stuntingOfChildrenMalePercentage) {
        this.stuntingOfChildrenMalePercentage = stuntingOfChildrenMalePercentage;
    }

    public int getStuntingOfChildren1FemalePercentage() {
        return stuntingOfChildren1FemalePercentage;
    }

    public void setStuntingOfChildren1FemalePercentage(int stuntingOfChildren1FemalePercentage) {
        this.stuntingOfChildren1FemalePercentage = stuntingOfChildren1FemalePercentage;
    }

    public int getWastingOfChildren1Male() {
        return wastingOfChildren1Male;
    }

    public void setWastingOfChildren1Male(int wastingOfChildren1Male) {
        this.wastingOfChildren1Male = wastingOfChildren1Male;
    }

    public int getWastingOfChildren1Female() {
        return wastingOfChildren1Female;
    }

    public void setWastingOfChildren1Female(int wastingOfChildren1Female) {
        this.wastingOfChildren1Female = wastingOfChildren1Female;
    }

    public int getWastingOfChildren4Male() {
        return wastingOfChildren4Male;
    }

    public void setWastingOfChildren4Male(int wastingOfChildren4Male) {
        this.wastingOfChildren4Male = wastingOfChildren4Male;
    }

    public int getWastingOfChildren4Female() {
        return wastingOfChildren4Female;
    }

    public void setWastingOfChildren4Female(int wastingOfChildren4Female) {
        this.wastingOfChildren4Female = wastingOfChildren4Female;
    }

    public int getWastingOfChildren7Male() {
        return wastingOfChildren7Male;
    }

    public void setWastingOfChildren7Male(int wastingOfChildren7Male) {
        this.wastingOfChildren7Male = wastingOfChildren7Male;
    }

    public int getWastingOfChildren7Female() {
        return wastingOfChildren7Female;
    }

    public void setWastingOfChildren7Female(int wastingOfChildren7Female) {
        this.wastingOfChildren7Female = wastingOfChildren7Female;
    }

    public int getWastingOfChildren10Male() {
        return wastingOfChildren10Male;
    }

    public void setWastingOfChildren10Male(int wastingOfChildren10Male) {
        this.wastingOfChildren10Male = wastingOfChildren10Male;
    }

    public int getWastingOfChildren10Female() {
        return wastingOfChildren10Female;
    }

    public void setWastingOfChildren10Female(int wastingOfChildren10Female) {
        this.wastingOfChildren10Female = wastingOfChildren10Female;
    }

    public int getWastingOfChildrenOtherMale() {
        return wastingOfChildrenOtherMale;
    }

    public void setWastingOfChildrenOtherMale(int wastingOfChildrenOtherMale) {
        this.wastingOfChildrenOtherMale = wastingOfChildrenOtherMale;
    }

    public int getWastingOfChildrenOtherFemale() {
        return wastingOfChildrenOtherFemale;
    }

    public void setWastingOfChildrenOtherFemale(int wastingOfChildrenOtherFemale) {
        this.wastingOfChildrenOtherFemale = wastingOfChildrenOtherFemale;
    }

    public int getWastingOfChildrenMale() {
        return wastingOfChildrenMale;
    }

    public void setWastingOfChildrenMale(int wastingOfChildrenMale) {
        this.wastingOfChildrenMale = wastingOfChildrenMale;
    }

    public int getWastingOfChildrenFemale() {
        return wastingOfChildrenFemale;
    }

    public void setWastingOfChildrenFemale(int wastingOfChildrenFemale) {
        this.wastingOfChildrenFemale = wastingOfChildrenFemale;
    }

    public int getWastingOfChildrenMalePercentage() {
        return wastingOfChildrenMalePercentage;
    }

    public void setWastingOfChildrenMalePercentage(int wastingOfChildrenMalePercentage) {
        this.wastingOfChildrenMalePercentage = wastingOfChildrenMalePercentage;
    }

    public int getWastingOfChildren1FemalePercentage() {
        return wastingOfChildren1FemalePercentage;
    }

    public void setWastingOfChildren1FemalePercentage(int wastingOfChildren1FemalePercentage) {
        this.wastingOfChildren1FemalePercentage = wastingOfChildren1FemalePercentage;
    }

    public int getOverweightOfChildren1Male() {
        return overweightOfChildren1Male;
    }

    public void setOverweightOfChildren1Male(int overweightOfChildren1Male) {
        this.overweightOfChildren1Male = overweightOfChildren1Male;
    }

    public int getOverweightOfChildren1Female() {
        return overweightOfChildren1Female;
    }

    public void setOverweightOfChildren1Female(int overweightOfChildren1Female) {
        this.overweightOfChildren1Female = overweightOfChildren1Female;
    }

    public int getOverweightOfChildren4Male() {
        return overweightOfChildren4Male;
    }

    public void setOverweightOfChildren4Male(int overweightOfChildren4Male) {
        this.overweightOfChildren4Male = overweightOfChildren4Male;
    }

    public int getOverweightOfChildren4Female() {
        return overweightOfChildren4Female;
    }

    public void setOverweightOfChildren4Female(int overweightOfChildren4Female) {
        this.overweightOfChildren4Female = overweightOfChildren4Female;
    }

    public int getOverweightOfChildren7Male() {
        return overweightOfChildren7Male;
    }

    public void setOverweightOfChildren7Male(int overweightOfChildren7Male) {
        this.overweightOfChildren7Male = overweightOfChildren7Male;
    }

    public int getOverweightOfChildren7Female() {
        return overweightOfChildren7Female;
    }

    public void setOverweightOfChildren7Female(int overweightOfChildren7Female) {
        this.overweightOfChildren7Female = overweightOfChildren7Female;
    }

    public int getOverweightOfChildren10Male() {
        return overweightOfChildren10Male;
    }

    public void setOverweightOfChildren10Male(int overweightOfChildren10Male) {
        this.overweightOfChildren10Male = overweightOfChildren10Male;
    }

    public int getOverweightOfChildren10Female() {
        return overweightOfChildren10Female;
    }

    public void setOverweightOfChildren10Female(int overweightOfChildren10Female) {
        this.overweightOfChildren10Female = overweightOfChildren10Female;
    }

    public int getOverweightOfChildrenOtherMale() {
        return overweightOfChildrenOtherMale;
    }

    public void setOverweightOfChildrenOtherMale(int overweightOfChildrenOtherMale) {
        this.overweightOfChildrenOtherMale = overweightOfChildrenOtherMale;
    }

    public int getOverweightOfChildrenOtherFemale() {
        return overweightOfChildrenOtherFemale;
    }

    public void setOverweightOfChildrenOtherFemale(int overweightOfChildrenOtherFemale) {
        this.overweightOfChildrenOtherFemale = overweightOfChildrenOtherFemale;
    }

    public int getOverweightOfChildrenMale() {
        return overweightOfChildrenMale;
    }

    public void setOverweightOfChildrenMale(int overweightOfChildrenMale) {
        this.overweightOfChildrenMale = overweightOfChildrenMale;
    }

    public int getOverweightOfChildrenFemale() {
        return overweightOfChildrenFemale;
    }

    public void setOverweightOfChildrenFemale(int overweightOfChildrenFemale) {
        this.overweightOfChildrenFemale = overweightOfChildrenFemale;
    }

    public int getOverweightOfChildrenMalePercentage() {
        return overweightOfChildrenMalePercentage;
    }

    public void setOverweightOfChildrenMalePercentage(int overweightOfChildrenMalePercentage) {
        this.overweightOfChildrenMalePercentage = overweightOfChildrenMalePercentage;
    }

    public int getOverweightOfChildren1FemalePercentage() {
        return overweightOfChildren1FemalePercentage;
    }

    public void setOverweightOfChildren1FemalePercentage(int overweightOfChildren1FemalePercentage) {
        this.overweightOfChildren1FemalePercentage = overweightOfChildren1FemalePercentage;
    }

    public int getObesityChildren1Male() {
        return obesityChildren1Male;
    }

    public void setObesityChildren1Male(int obesityChildren1Male) {
        this.obesityChildren1Male = obesityChildren1Male;
    }

    public int getObesityChildren1Female() {
        return obesityChildren1Female;
    }

    public void setObesityChildren1Female(int obesityChildren1Female) {
        this.obesityChildren1Female = obesityChildren1Female;
    }

    public int getObesityChildren4Male() {
        return obesityChildren4Male;
    }

    public void setObesityChildren4Male(int obesityChildren4Male) {
        this.obesityChildren4Male = obesityChildren4Male;
    }

    public int getObesityChildren4Female() {
        return obesityChildren4Female;
    }

    public void setObesityChildren4Female(int obesityChildren4Female) {
        this.obesityChildren4Female = obesityChildren4Female;
    }

    public int getObesityChildren7Male() {
        return obesityChildren7Male;
    }

    public void setObesityChildren7Male(int obesityChildren7Male) {
        this.obesityChildren7Male = obesityChildren7Male;
    }

    public int getObesityChildren7Female() {
        return obesityChildren7Female;
    }

    public void setObesityChildren7Female(int obesityChildren7Female) {
        this.obesityChildren7Female = obesityChildren7Female;
    }

    public int getObesityChildren10Male() {
        return obesityChildren10Male;
    }

    public void setObesityChildren10Male(int obesityChildren10Male) {
        this.obesityChildren10Male = obesityChildren10Male;
    }

    public int getObesityChildren10Female() {
        return obesityChildren10Female;
    }

    public void setObesityChildren10Female(int obesityChildren10Female) {
        this.obesityChildren10Female = obesityChildren10Female;
    }

    public int getObesityChildrenOtherMale() {
        return obesityChildrenOtherMale;
    }

    public void setObesityChildrenOtherMale(int obesityChildrenOtherMale) {
        this.obesityChildrenOtherMale = obesityChildrenOtherMale;
    }

    public int getObesityChildrenOtherFemale() {
        return obesityChildrenOtherFemale;
    }

    public void setObesityChildrenOtherFemale(int obesityChildrenOtherFemale) {
        this.obesityChildrenOtherFemale = obesityChildrenOtherFemale;
    }

    public int getObesityChildrenMale() {
        return obesityChildrenMale;
    }

    public void setObesityChildrenMale(int obesityChildrenMale) {
        this.obesityChildrenMale = obesityChildrenMale;
    }

    public int getObesityChildrenFemale() {
        return obesityChildrenFemale;
    }

    public void setObesityChildrenFemale(int obesityChildrenFemale) {
        this.obesityChildrenFemale = obesityChildrenFemale;
    }

    public int getObesityChildrenMalePercentage() {
        return obesityChildrenMalePercentage;
    }

    public void setObesityChildrenMalePercentage(int obesityChildrenMalePercentage) {
        this.obesityChildrenMalePercentage = obesityChildrenMalePercentage;
    }

    public int getObesityChildren1FemalePercentage() {
        return obesityChildren1FemalePercentage;
    }

    public void setObesityChildren1FemalePercentage(int obesityChildren1FemalePercentage) {
        this.obesityChildren1FemalePercentage = obesityChildren1FemalePercentage;
    }

    public int getVisualDefects() {
        return visualDefects;
    }

    public void setVisualDefects(int visualDefects) {
        this.visualDefects = visualDefects;
    }

    public int getHearingDefects() {
        return hearingDefects;
    }

    public void setHearingDefects(int hearingDefects) {
        this.hearingDefects = hearingDefects;
    }

    public int getSpeechDeefcts() {
        return speechDeefcts;
    }

    public void setSpeechDeefcts(int speechDeefcts) {
        this.speechDeefcts = speechDeefcts;
    }

    public int getPediculosis() {
        return pediculosis;
    }

    public void setPediculosis(int pediculosis) {
        this.pediculosis = pediculosis;
    }

    public int getNightBlindness() {
        return nightBlindness;
    }

    public void setNightBlindness(int nightBlindness) {
        this.nightBlindness = nightBlindness;
    }

    public int getBitotSpots() {
        return bitotSpots;
    }

    public void setBitotSpots(int bitotSpots) {
        this.bitotSpots = bitotSpots;
    }

    public int getSquint() {
        return squint;
    }

    public void setSquint(int squint) {
        this.squint = squint;
    }

    public int getPallor() {
        return pallor;
    }

    public void setPallor(int pallor) {
        this.pallor = pallor;
    }

    public int getXeropthalmia() {
        return xeropthalmia;
    }

    public void setXeropthalmia(int xeropthalmia) {
        this.xeropthalmia = xeropthalmia;
    }

    public int getAngularStomatitisGlossitis() {
        return angularStomatitisGlossitis;
    }

    public void setAngularStomatitisGlossitis(int angularStomatitisGlossitis) {
        this.angularStomatitisGlossitis = angularStomatitisGlossitis;
    }

    public int getDentalCaries() {
        return dentalCaries;
    }

    public void setDentalCaries(int dentalCaries) {
        this.dentalCaries = dentalCaries;
    }

    public int getCalculus() {
        return calculus;
    }

    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    public int getFluorosis() {
        return fluorosis;
    }

    public void setFluorosis(int fluorosis) {
        this.fluorosis = fluorosis;
    }

    public int getMalocclusion() {
        return malocclusion;
    }

    public void setMalocclusion(int malocclusion) {
        this.malocclusion = malocclusion;
    }

    public int getGoitre() {
        return goitre;
    }

    public void setGoitre(int goitre) {
        this.goitre = goitre;
    }

    public int getEntDefects() {
        return entDefects;
    }

    public void setEntDefects(int entDefects) {
        this.entDefects = entDefects;
    }

    public int getLympahdenopathy() {
        return lympahdenopathy;
    }

    public void setLympahdenopathy(int lympahdenopathy) {
        this.lympahdenopathy = lympahdenopathy;
    }

    public int getScabies() {
        return scabies;
    }

    public void setScabies(int scabies) {
        this.scabies = scabies;
    }

    public int getHypopigmentedAnaestheticPatches() {
        return hypopigmentedAnaestheticPatches;
    }

    public void setHypopigmentedAnaestheticPatches(int hypopigmentedAnaestheticPatches) {
        this.hypopigmentedAnaestheticPatches = hypopigmentedAnaestheticPatches;
    }

    public int getOtherSkinDisorders() {
        return otherSkinDisorders;
    }

    public void setOtherSkinDisorders(int otherSkinDisorders) {
        this.otherSkinDisorders = otherSkinDisorders;
    }

    public int getOrthopaedicDefects() {
        return orthopaedicDefects;
    }

    public void setOrthopaedicDefects(int orthopaedicDefects) {
        this.orthopaedicDefects = orthopaedicDefects;
    }

    public int getRheumaticDisorders() {
        return rheumaticDisorders;
    }

    public void setRheumaticDisorders(int rheumaticDisorders) {
        this.rheumaticDisorders = rheumaticDisorders;
    }

    public int getHeartDeceases() {
        return heartDeceases;
    }

    public void setHeartDeceases(int heartDeceases) {
        this.heartDeceases = heartDeceases;
    }

    public int getLungDiseases() {
        return lungDiseases;
    }

    public void setLungDiseases(int lungDiseases) {
        this.lungDiseases = lungDiseases;
    }

    public int getAsthma() {
        return asthma;
    }

    public void setAsthma(int asthma) {
        this.asthma = asthma;
    }

    public int getBehaviouralProblems() {
        return behaviouralProblems;
    }

    public void setBehaviouralProblems(int behaviouralProblems) {
        this.behaviouralProblems = behaviouralProblems;
    }

    public int getLearningDifficulties() {
        return learningDifficulties;
    }

    public void setLearningDifficulties(int learningDifficulties) {
        this.learningDifficulties = learningDifficulties;
    }

    public int getOtherDefects() {
        return otherDefects;
    }

    public void setOtherDefects(int otherDefects) {
        this.otherDefects = otherDefects;
    }

    public String getOtherDefectsSpecify() {
        return otherDefectsSpecify;
    }

    public void setOtherDefectsSpecify(String otherDefectsSpecify) {
        this.otherDefectsSpecify = otherDefectsSpecify;
    }

    public int getTotalNoOfDefectsExcludingNutritionProblems() {
        return totalNoOfDefectsExcludingNutritionProblems;
    }

    public void setTotalNoOfDefectsExcludingNutritionProblems(int totalNoOfDefectsExcludingNutritionProblems) {
        this.totalNoOfDefectsExcludingNutritionProblems = totalNoOfDefectsExcludingNutritionProblems;
    }

    public int getNoOfStudentsWithDefectsExcludingNutritionProblems() {
        return noOfStudentsWithDefectsExcludingNutritionProblems;
    }

    public void setNoOfStudentsWithDefectsExcludingNutritionProblems(int noOfStudentsWithDefectsExcludingNutritionProblems) {
        this.noOfStudentsWithDefectsExcludingNutritionProblems = noOfStudentsWithDefectsExcludingNutritionProblems;
    }

    public int getNoReferredExcludingNutritionProblems() {
        return noReferredExcludingNutritionProblems;
    }

    public void setNoReferredExcludingNutritionProblems(int noReferredExcludingNutritionProblems) {
        this.noReferredExcludingNutritionProblems = noReferredExcludingNutritionProblems;
    }
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonthlyStatementSummeryDataForSingleInspection)) {
            return false;
        }
        MonthlyStatementSummeryDataForSingleInspection other = (MonthlyStatementSummeryDataForSingleInspection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.schoolhealth.MonthlyStatementSummeryDataForSingleInspection[ id=" + id + " ]";
    }

}
