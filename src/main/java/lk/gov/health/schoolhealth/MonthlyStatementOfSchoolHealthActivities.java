/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.schoolhealth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class MonthlyStatementOfSchoolHealthActivities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Area rdhsArea;
    @ManyToOne
    private Area mohArea;
    @ManyToOne
    private Area phiArea;
    private int statementYear;
    private int statementMonth;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Enumerated(EnumType.STRING)
    Month statementMonthEnum;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date statementDate;

//    1. Basic Data
    private int totalNoOfSchoolsLessThan200;
    private int totalNoOfSchoolsMoreThan200;
    private int totalNoOfSchools;

    private int totalNoOfStudentsMaleInLessThan200Schools;
    private int totalNoOfStudentsFemaleInLessThan200Schools;
    private int totalNoOfStudentsMaleInMoreThan200Schools;
    private int totalNoOfStudentsFemaleInMoreThan200Schools;

    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade1Male;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade1Female;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade4Male;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade4Female;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade7Male;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade7Female;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade10Male;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGrade10Female;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale;
    private int totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale;
    private int totalNoOfStudentsToBeExaminedDuringTheYearMale;
    private int totalNoOfStudentsToBeExaminedDuringTheYearFemale;
    // 2. School ENvironment

    // 3. Health Promotion and Educational Programmes
    // 4. Schoool Medical Inspection
    // 5. School Medical Inspection Summery
    @OneToMany(mappedBy = "monthlyStatementOfSchoolHealthActivities", cascade = CascadeType.ALL)
    private List<MonthlyStatementSummeryDataForSingleInspection> monthlyStatementSummeryDataForSingleInspections;

    @OneToOne(cascade = CascadeType.ALL)
    MonthlyStatementSummeryDataForSingleInspection totalProbelms;

    @OneToOne(cascade = CascadeType.ALL)
    MonthlyStatementSummeryDataForSingleInspection totalForTheMonth;

    @OneToOne(cascade = CascadeType.ALL)
    MonthlyStatementSummeryDataForSingleInspection totalForTheYear;

    @OneToOne(cascade = CascadeType.ALL)
    MonthlyStatementSummeryDataForSingleInspection numberCorrectedForTheMonth;

    @OneToOne(cascade = CascadeType.ALL)
    MonthlyStatementSummeryDataForSingleInspection numberCorrectedForTheYear;

    // 6. Problems and Defects detected at School Medical Inspection
    // 7. Immunization
    // 8. Micronutrients, anti Helminthic treatment and follow up activities
    // 9. Information on Health Promoting Schools
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MonthlyStatementSummeryDataForSingleInspection> getMonthlyStatementSummeryDataForSingleInspections() {
        if (monthlyStatementSummeryDataForSingleInspections == null) {
            monthlyStatementSummeryDataForSingleInspections = new ArrayList<MonthlyStatementSummeryDataForSingleInspection>();
        }
        return monthlyStatementSummeryDataForSingleInspections;
    }

    public void setMonthlyStatementSummeryDataForSingleInspections(List<MonthlyStatementSummeryDataForSingleInspection> monthlyStatementSummeryDataForSingleInspections) {
        this.monthlyStatementSummeryDataForSingleInspections = monthlyStatementSummeryDataForSingleInspections;
    }

    public MonthlyStatementSummeryDataForSingleInspection getTotalProbelms() {
        return totalProbelms;
    }

    public void setTotalProbelms(MonthlyStatementSummeryDataForSingleInspection totalProbelms) {
        this.totalProbelms = totalProbelms;
    }

    public MonthlyStatementSummeryDataForSingleInspection getTotalForTheMonth() {
        return totalForTheMonth;
    }

    public void setTotalForTheMonth(MonthlyStatementSummeryDataForSingleInspection totalForTheMonth) {
        this.totalForTheMonth = totalForTheMonth;
    }

    public MonthlyStatementSummeryDataForSingleInspection getTotalForTheYear() {
        return totalForTheYear;
    }

    public void setTotalForTheYear(MonthlyStatementSummeryDataForSingleInspection totalForTheYear) {
        this.totalForTheYear = totalForTheYear;
    }

    public MonthlyStatementSummeryDataForSingleInspection getNumberCorrectedForTheMonth() {
        return numberCorrectedForTheMonth;
    }

    public void setNumberCorrectedForTheMonth(MonthlyStatementSummeryDataForSingleInspection numberCorrectedForTheMonth) {
        this.numberCorrectedForTheMonth = numberCorrectedForTheMonth;
    }

    public MonthlyStatementSummeryDataForSingleInspection getNumberCorrectedForTheYear() {
        return numberCorrectedForTheYear;
    }

    public void setNumberCorrectedForTheYear(MonthlyStatementSummeryDataForSingleInspection numberCorrectedForTheYear) {
        this.numberCorrectedForTheYear = numberCorrectedForTheYear;
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
        if (!(object instanceof MonthlyStatementOfSchoolHealthActivities)) {
            return false;
        }
        MonthlyStatementOfSchoolHealthActivities other = (MonthlyStatementOfSchoolHealthActivities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.schoolhealth.MonthlyStatementOfSchoolHealthActivities[ id=" + id + " ]";
    }

    public Area getRdhsArea() {
        return rdhsArea;
    }

    public void setRdhsArea(Area rdhsArea) {
        this.rdhsArea = rdhsArea;
    }

    public Area getMohArea() {
        return mohArea;
    }

    public void setMohArea(Area mohArea) {
        this.mohArea = mohArea;
    }

    public Area getPhiArea() {
        return phiArea;
    }

    public void setPhiArea(Area phiArea) {
        this.phiArea = phiArea;
    }

    public int getStatementYear() {
        return statementYear;
    }

    public void setStatementYear(int statementYear) {
        this.statementYear = statementYear;
    }

    public int getStatementMonth() {
        return statementMonth;
    }

    public void setStatementMonth(int statementMonth) {
        this.statementMonth = statementMonth;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public int getTotalNoOfSchoolsLessThan200() {
        return totalNoOfSchoolsLessThan200;
    }

    public void setTotalNoOfSchoolsLessThan200(int totalNoOfSchoolsLessThan200) {
        this.totalNoOfSchoolsLessThan200 = totalNoOfSchoolsLessThan200;
    }

    public int getTotalNoOfSchoolsMoreThan200() {
        return totalNoOfSchoolsMoreThan200;
    }

    public void setTotalNoOfSchoolsMoreThan200(int totalNoOfSchoolsMoreThan200) {
        this.totalNoOfSchoolsMoreThan200 = totalNoOfSchoolsMoreThan200;
    }

    public int getTotalNoOfSchools() {
        return totalNoOfSchools;
    }

    public void setTotalNoOfSchools(int totalNoOfSchools) {
        this.totalNoOfSchools = totalNoOfSchools;
    }

    public int getTotalNoOfStudentsMaleInLessThan200Schools() {
        return totalNoOfStudentsMaleInLessThan200Schools;
    }

    public void setTotalNoOfStudentsMaleInLessThan200Schools(int totalNoOfStudentsMaleInLessThan200Schools) {
        this.totalNoOfStudentsMaleInLessThan200Schools = totalNoOfStudentsMaleInLessThan200Schools;
    }

    public int getTotalNoOfStudentsFemaleInLessThan200Schools() {
        return totalNoOfStudentsFemaleInLessThan200Schools;
    }

    public void setTotalNoOfStudentsFemaleInLessThan200Schools(int totalNoOfStudentsFemaleInLessThan200Schools) {
        this.totalNoOfStudentsFemaleInLessThan200Schools = totalNoOfStudentsFemaleInLessThan200Schools;
    }

    public int getTotalNoOfStudentsMaleInMoreThan200Schools() {
        return totalNoOfStudentsMaleInMoreThan200Schools;
    }

    public void setTotalNoOfStudentsMaleInMoreThan200Schools(int totalNoOfStudentsMaleInMoreThan200Schools) {
        this.totalNoOfStudentsMaleInMoreThan200Schools = totalNoOfStudentsMaleInMoreThan200Schools;
    }

    public int getTotalNoOfStudentsFemaleInMoreThan200Schools() {
        return totalNoOfStudentsFemaleInMoreThan200Schools;
    }

    public void setTotalNoOfStudentsFemaleInMoreThan200Schools(int totalNoOfStudentsFemaleInMoreThan200Schools) {
        this.totalNoOfStudentsFemaleInMoreThan200Schools = totalNoOfStudentsFemaleInMoreThan200Schools;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade1Male() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade1Male;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade1Male(int totalNoOfStudentsToBeExaminedDuringTheYearGrade1Male) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade1Male = totalNoOfStudentsToBeExaminedDuringTheYearGrade1Male;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade1Female() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade1Female;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade1Female(int totalNoOfStudentsToBeExaminedDuringTheYearGrade1Female) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade1Female = totalNoOfStudentsToBeExaminedDuringTheYearGrade1Female;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade4Male() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade4Male;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade4Male(int totalNoOfStudentsToBeExaminedDuringTheYearGrade4Male) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade4Male = totalNoOfStudentsToBeExaminedDuringTheYearGrade4Male;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade4Female() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade4Female;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade4Female(int totalNoOfStudentsToBeExaminedDuringTheYearGrade4Female) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade4Female = totalNoOfStudentsToBeExaminedDuringTheYearGrade4Female;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade7Male() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade7Male;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade7Male(int totalNoOfStudentsToBeExaminedDuringTheYearGrade7Male) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade7Male = totalNoOfStudentsToBeExaminedDuringTheYearGrade7Male;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade7Female() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade7Female;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade7Female(int totalNoOfStudentsToBeExaminedDuringTheYearGrade7Female) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade7Female = totalNoOfStudentsToBeExaminedDuringTheYearGrade7Female;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade10Male() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade10Male;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade10Male(int totalNoOfStudentsToBeExaminedDuringTheYearGrade10Male) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade10Male = totalNoOfStudentsToBeExaminedDuringTheYearGrade10Male;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGrade10Female() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGrade10Female;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGrade10Female(int totalNoOfStudentsToBeExaminedDuringTheYearGrade10Female) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGrade10Female = totalNoOfStudentsToBeExaminedDuringTheYearGrade10Female;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale(int totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale = totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherMale;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale() {
        return totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale(int totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale = totalNoOfStudentsToBeExaminedDuringTheYearGradeOtherFemale;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearMale() {
        return totalNoOfStudentsToBeExaminedDuringTheYearMale;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearMale(int totalNoOfStudentsToBeExaminedDuringTheYearMale) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearMale = totalNoOfStudentsToBeExaminedDuringTheYearMale;
    }

    public int getTotalNoOfStudentsToBeExaminedDuringTheYearFemale() {
        return totalNoOfStudentsToBeExaminedDuringTheYearFemale;
    }

    public void setTotalNoOfStudentsToBeExaminedDuringTheYearFemale(int totalNoOfStudentsToBeExaminedDuringTheYearFemale) {
        this.totalNoOfStudentsToBeExaminedDuringTheYearFemale = totalNoOfStudentsToBeExaminedDuringTheYearFemale;
    }

    public Month getStatementMonthEnum() {
        return statementMonthEnum;
    }

    public void setStatementMonthEnum(Month statementMonthEnum) {
        this.statementMonthEnum = statementMonthEnum;
    }
    
    
    

}
