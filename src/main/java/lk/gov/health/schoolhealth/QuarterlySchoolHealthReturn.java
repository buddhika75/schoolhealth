/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.schoolhealth;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class QuarterlySchoolHealthReturn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Area rdhs_division;
    @ManyToOne
    private Area moh_area;
    private int report_year;
    private int report_quarter;
    private Quarter report_quarter_enum;

    private int total_no_of_schools_less_than_200;
    private int total_no_of_schools_more_than_200;
    private int total_no_of_schools;

    private int no_of_schools_without_latrines_in_less_than_200;
    private int no_of_schools_without_latrines_in_less_more_200;
    private int no_of_schools_without_latrines;

    private int no_of_schools_inadequate_latrines_in_less_than_200;
    private int no_of_schools_inadequate_latrines_in_less_more_200;
    private int no_of_schools_inadequate_latrines;

    private int no_of_schools_without_water_in_less_than_200;
    private int no_of_schools_without_water_in_less_more_200;
    private int no_of_schools_without_water;

    private Month month_1;
    private Month month_2;
    private Month month_3;

    private int reproductive_Health_Programmes_No_Conducted_1;
    private int reproductive_Health_Programmes_No_Conducted_2;
    private int reproductive_Health_Programmes_No_Conducted_3;
    private int reproductive_Health_Programmes_No_Conducted;

    private int reproductive_Health_Programmes_Students_1;
    private int reproductive_Health_Programmes_Students_2;
    private int reproductive_Health_Programmes_Students_3;
    private int reproductive_Health_Programmes_Students;

    private int reproductive_Health_Programmes_Teachers_1;
    private int reproductive_Health_Programmes_Teachers_2;
    private int reproductive_Health_Programmes_Teachers_3;
    private int reproductive_Health_Programmes_Teachers;

    private int life_skills_Health_Programmes_No_Conducted_1;
    private int life_skills_Health_Programmes_No_Conducted_2;
    private int life_skills_Health_Programmes_No_Conducted_3;
    private int life_skills_Health_Programmes_No_Conducted;

    private int life_skills_Health_Programmes_Students_1;
    private int life_skills_Health_Programmes_Students_2;
    private int life_skills_Health_Programmes_Students_3;
    private int life_skills_Health_Programmes_Students;

    private int life_skills_Health_Programmes_Teachers_1;
    private int life_skills_Health_Programmes_Teachers_2;
    private int life_skills_Health_Programmes_Teachers_3;
    private int life_skills_Health_Programmes_Teachers;

    private int com_and_noncom_Health_Programmes_No_Conducted_1;
    private int com_and_noncom_Health_Programmes_No_Conducted_2;
    private int com_and_noncom_Health_Programmes_No_Conducted_3;
    private int com_and_noncom_Health_Programmes_No_Conducted;

    private int com_and_noncom_Health_Programmes_Students_1;
    private int com_and_noncom_Health_Programmes_Students_2;
    private int com_and_noncom_Health_Programmes_Students_3;
    private int com_and_noncom_Health_Programmes_Students;

    private int com_and_noncom_Health_Programmes_Teachers_1;
    private int com_and_noncom_Health_Programmes_Teachers_2;
    private int com_and_noncom_Health_Programmes_Teachers_3;
    private int com_and_noncom_Health_Programmes_Teachers;

    private int nutrition_programmes_Health_Programmes_No_Conducted_1;
    private int nutrition_programmes_Health_Programmes_No_Conducted_2;
    private int nutrition_programmes_Health_Programmes_No_Conducted_3;
    private int nutrition_programmes_Health_Programmes_No_Conducted;

    private int nutrition_programmes_Health_Programmes_Students_1;
    private int nutrition_programmes_Health_Programmes_Students_2;
    private int nutrition_programmes_Health_Programmes_Students_3;
    private int nutrition_programmes_Health_Programmes_Students;

    private int nutrition_programmes_Health_Programmes_Teachers_1;
    private int nutrition_programmes_Health_Programmes_Teachers_2;
    private int nutrition_programmes_Health_Programmes_Teachers_3;
    private int nutrition_programmes_Health_Programmes_Teachers;

    private int students_Councelled_1;
    private int students_Councelled_2;
    private int students_Councelled_3;
    private int students_Councelled;

    private int community_Health_1;
    private int community_Health_2;
    private int community_Health_3;
    private int community_Health;

    private int other_1;
    private int other_2;
    private int other_3;
    private int other;

    private int phi_smi_l200;
    private int phi_smi_m200;
    private int phi_smi;

    private int moh_smi_l200;
    private int moh_smi_m200;
    private int moh_smi;

    private int amoh_smi_l200;
    private int amoh_smi_m200;
    private int amoh_smi;

    private int mo_smi_l200;
    private int mo_smi_m200;
    private int mo_smi;

    private int rmo_smi_l200;
    private int rmo_smi_m200;
    private int rmo_smi;

    private int smi_quarter_l200;
    private int smi_quarter_m200;
    private int smi_quarter;

    private int smi_cumulative_l200;
    private int smi_cumulative_m200;
    private int smi_cumulative;

    private int smi_l200_m_1;
    private int smi_l200_m_4;
    private int smi_l200_m_7;
    private int smi_l200_m_10;
    private int smi_l200_m_other;
    private int smi_l200_m_total;

    private int smi_l200_f_1;
    private int smi_l200_f_4;
    private int smi_l200_f_7;
    private int smi_l200_f_10;
    private int smi_l200_f_other;
    private int smi_l200_f_total;

    private int stunting_1_m_fm;
    private int stunting_1_m_sm;
    private int stunting_1_m_tm;
    private int stunting_1_m;

    private int stunting_1_f_fm;
    private int stunting_1_f_sm;
    private int stunting_1_f_tm;
    private int stunting_1_f;

    private int stunting_4_m_fm;
    private int stunting_4_m_sm;
    private int stunting_4_m_tm;
    private int stunting_4_m;

    private int stunting_4_f_fm;
    private int stunting_4_f_sm;
    private int stunting_4_f_tm;
    private int stunting_4_f;

    private int wasting_1_m_fm;
    private int wasting_1_m_sm;
    private int wasting_1_m_tm;
    private int wasting_1_m;

    private int wasting_1_f_fm;
    private int wasting_1_f_sm;
    private int wasting_1_f_tm;
    private int wasting_1_f;

    private int wasting_4_m_fm;
    private int wasting_4_m_sm;
    private int wasting_4_m_tm;
    private int wasting_4_m;

    private int wasting_4_f_fm;
    private int wasting_4_f_sm;
    private int wasting_4_f_tm;
    private int wasting_4_f;

    private int wasting_7_m_fm;
    private int wasting_7_m_sm;
    private int wasting_7_m_tm;
    private int wasting_7_m;

    private int wasting_7_f_fm;
    private int wasting_7_f_sm;
    private int wasting_7_f_tm;
    private int wasting_7_f;

    private int wasting_10_m_fm;
    private int wasting_10_m_sm;
    private int wasting_10_m_tm;
    private int wasting_10_m;

    private int wasting_10_f_fm;
    private int wasting_10_f_sm;
    private int wasting_10_f_tm;
    private int wasting_10_f;

    private int wasting_other_m_fm;
    private int wasting_other_m_sm;
    private int wasting_other_m_tm;
    private int wasting_other_m;

    private int wasting_other_f_fm;
    private int wasting_other_f_sm;
    private int wasting_other_f_tm;
    private int wasting_other_f;

    private int overweight_1_m_fm;
    private int overweight_1_m_sm;
    private int overweight_1_m_tm;
    private int overweight_1_m;

    private int overweight_1_f_fm;
    private int overweight_1_f_sm;
    private int overweight_1_f_tm;
    private int overweight_1_f;

    private int overweight_4_m_fm;
    private int overweight_4_m_sm;
    private int overweight_4_m_tm;
    private int overweight_4_m;

    private int overweight_4_f_fm;
    private int overweight_4_f_sm;
    private int overweight_4_f_tm;
    private int overweight_4_f;

    private int overweight_7_m_fm;
    private int overweight_7_m_sm;
    private int overweight_7_m_tm;
    private int overweight_7_m;

    private int overweight_7_f_fm;
    private int overweight_7_f_sm;
    private int overweight_7_f_tm;
    private int overweight_7_f;

    private int overweight_10_m_fm;
    private int overweight_10_m_sm;
    private int overweight_10_m_tm;
    private int overweight_10_m;

    private int overweight_10_f_fm;
    private int overweight_10_f_sm;
    private int overweight_10_f_tm;
    private int overweight_10_f;

    private int overweight_other_m_fm;
    private int overweight_other_m_sm;
    private int overweight_other_m_tm;
    private int overweight_other_m;

    private int overweight_other_f_fm;
    private int overweight_other_f_sm;
    private int overweight_other_f_tm;
    private int overweight_other_f;

    private int obesity_1_m_fm;
    private int obesity_1_m_sm;
    private int obesity_1_m_tm;
    private int obesity_1_m;

    private int obesity_1_f_fm;
    private int obesity_1_f_sm;
    private int obesity_1_f_tm;
    private int obesity_1_f;

    private int obesity_4_m_fm;
    private int obesity_4_m_sm;
    private int obesity_4_m_tm;
    private int obesity_4_m;

    private int obesity_4_f_fm;
    private int obesity_4_f_sm;
    private int obesity_4_f_tm;
    private int obesity_4_f;

    private int obesity_7_m_fm;
    private int obesity_7_m_sm;
    private int obesity_7_m_tm;
    private int obesity_7_m;

    private int obesity_7_f_fm;
    private int obesity_7_f_sm;
    private int obesity_7_f_tm;
    private int obesity_7_f;

    private int obesity_10_m_fm;
    private int obesity_10_m_sm;
    private int obesity_10_m_tm;
    private int obesity_10_m;

    private int obesity_10_f_fm;
    private int obesity_10_f_sm;
    private int obesity_10_f_tm;
    private int obesity_10_f;

    private int obesity_other_m_fm;
    private int obesity_other_m_sm;
    private int obesity_other_m_tm;
    private int obesity_other_m;

    private int obesity_other_f_fm;
    private int obesity_other_f_sm;
    private int obesity_other_f_tm;
    private int obesity_other_f;

    private int nutritional_referrals_other_m_fm;
    private int nutritional_referrals_other_m_sm;
    private int nutritional_referrals_other_m_tm;
    private int nutritional_referrals_other_m;

    private int nutritional_referrals_other_f_fm;
    private int nutritional_referrals_other_f_sm;
    private int nutritional_referrals_other_f_tm;
    private int nutritional_referrals_other_f;

    private int visual_defects_fm;
    private int visual_defects_sm;
    private int visual_defects_tm;
    private int visual_defects;
    private int visual_defects_corrected;

    private int hearing_defects_fm;
    private int hearing_defects_sm;
    private int hearing_defects_tm;
    private int hearing_defects;
    private int hearing_defects_corrected;

    private int speech_defects_fm;
    private int speech_defects_sm;
    private int speech_defects_tm;
    private int speech_defects;
    private int speech_defects_corrected;

    private int pediculosis_fm;
    private int pediculosis_sm;
    private int pediculosis_tm;
    private int pediculosis;
    private int pediculosis_corrected;

    private int night_blindness_fm;
    private int night_blindness_sm;
    private int night_blindness_tm;
    private int night_blindness;
    private int night_blindness_corrected;

    private int bitot_spots_fm;
    private int bitot_spots_sm;
    private int bitot_spots_tm;
    private int bitot_spots;
    private int bitot_spots_corrected;

    private int squint_fm;
    private int squint_sm;
    private int squint_tm;
    private int squint;
    private int squint_corrected;

    private int pallor_fm;
    private int pallor_sm;
    private int pallor_tm;
    private int pallor;
    private int pallor_corrected;

    private int xeropthalmia_fm;
    private int xeropthalmia_sm;
    private int xeropthalmia_tm;
    private int xeropthalmia;
    private int xeropthalmia_corrected;

    private int angular_stomatitis_or_glossitis_fm;
    private int angular_stomatitis_or_glossitis_sm;
    private int angular_stomatitis_or_glossitis_tm;
    private int angular_stomatitis_or_glossitis;
    private int angular_stomatitis_or_glossitis_corrected;

    private int dental_caries_fm;
    private int dental_caries_sm;
    private int dental_caries_tm;
    private int dental_caries;
    private int dental_caries_corrected;

    private int calculus_fm;
    private int calculus_sm;
    private int calculus_tm;
    private int calculus;
    private int calculus_corrected;

    private int fluorosis_fm;
    private int fluorosis_sm;
    private int fluorosis_tm;
    private int fluorosis;
    private int fluorosis_corrected;

    private int malocclusion_fm;
    private int malocclusion_sm;
    private int malocclusion_tm;
    private int malocclusion;
    private int malocclusion_corrected;

    private int goitre_fm;
    private int goitre_sm;
    private int goitre_tm;
    private int goitre;
    private int goitre_corrected;

    private int ent_defects_fm;
    private int ent_defects_sm;
    private int ent_defects_tm;
    private int ent_defects;
    private int ent_defects_corrected;

    private int lymphadenopathy_fm;
    private int lymphadenopathy_sm;
    private int lymphadenopathy_tm;
    private int lymphadenopathy;
    private int lymphadenopathy_corrected;

    private int scabies_fm;
    private int scabies_sm;
    private int scabies_tm;
    private int scabies;
    private int scabies_corrected;

    private int hypopigmented_skin_patches_fm;
    private int hypopigmented_skin_patches_sm;
    private int hypopigmented_skin_patches_tm;
    private int hypopigmented_skin_patches;
    private int hypopigmented_skin_patches_corrected;

    private int other_skin_disorders_fm;
    private int other_skin_disorders_sm;
    private int other_skin_disorders_tm;
    private int other_skin_disorders;
    private int other_skin_disorders_corrected;

    private int orthopaedic_disorders_fm;
    private int orthopaedic_disorders_sm;
    private int orthopaedic_disorders_tm;
    private int orthopaedic_disorders;
    private int orthopaedic_disorders_corrected;

    private int rheumatic_disorders_fm;
    private int rheumatic_disorders_sm;
    private int rheumatic_disorders_tm;
    private int rheumatic_disorders;
    private int rheumatic_disorders_corrected;

    private int heart_diseases_fm;
    private int heart_diseases_sm;
    private int heart_diseases_tm;
    private int heart_diseases;
    private int heart_diseases_corrected;

    private int lung_diseases_fm;
    private int lung_diseases_sm;
    private int lung_diseases_tm;
    private int lung_diseases;
    private int lung_diseases_corrected;

    private int bronchial_asthma_fm;
    private int bronchial_asthma_sm;
    private int bronchial_asthma_tm;
    private int bronchial_asthma;
    private int bronchial_asthma_corrected;

    private int behavioural_problems_fm;
    private int behavioural_problems_sm;
    private int behavioural_problems_tm;
    private int behavioural_problems;
    private int behavioural_problems_corrected;

    private int learning_difficulties_fm;
    private int learning_difficulties_sm;
    private int learning_difficulties_tm;
    private int learning_difficulties;
    private int learning_difficulties_corrected;

    private int other_defects_fm;
    private int other_defects_sm;
    private int other_defects_tm;
    private int other_defects;
    private int other_defects_corrected;

    private int total_defects_fm;
    private int total_defects_sm;
    private int total_defects_tm;
    private int total_defects;
    private int total_defects_corrected;

    private int referred_fm;
    private int referred_sm;
    private int referred_tm;
    private int referred;
    private int referred_corrected;

    @ManyToOne
    private WebUser preparedBy;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date preparedDate;

    @ManyToOne
    private WebUser certifiedBy;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date certifiedDate;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date returnDate;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
        if (!(object instanceof QuarterlySchoolHealthReturn)) {
            return false;
        }
        QuarterlySchoolHealthReturn other = (QuarterlySchoolHealthReturn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.schoolhealth.QuarterlySchoolHealthReturn[ id=" + id + " ]";
    }

    public Area getRdhs_division() {
        return rdhs_division;
    }

    public void setRdhs_division(Area rdhs_division) {
        this.rdhs_division = rdhs_division;
    }

    public Area getMoh_area() {
        return moh_area;
    }

    public void setMoh_area(Area moh_area) {
        this.moh_area = moh_area;
    }

    public int getReport_year() {
        return report_year;
    }

    public void setReport_year(int report_year) {
        this.report_year = report_year;
    }

    public int getReport_quarter() {
        return report_quarter;
    }

    public void setReport_quarter(int report_quarter) {
        this.report_quarter = report_quarter;
    }

    public int getTotal_no_of_schools_less_than_200() {
        return total_no_of_schools_less_than_200;
    }

    public void setTotal_no_of_schools_less_than_200(int total_no_of_schools_less_than_200) {
        this.total_no_of_schools_less_than_200 = total_no_of_schools_less_than_200;
    }

    public int getTotal_no_of_schools_more_than_200() {
        return total_no_of_schools_more_than_200;
    }

    public void setTotal_no_of_schools_more_than_200(int total_no_of_schools_more_than_200) {
        this.total_no_of_schools_more_than_200 = total_no_of_schools_more_than_200;
    }

    public int getTotal_no_of_schools() {
        return total_no_of_schools;
    }

    public void setTotal_no_of_schools(int total_no_of_schools) {
        this.total_no_of_schools = total_no_of_schools;
    }

    public int getNo_of_schools_without_latrines_in_less_than_200() {
        return no_of_schools_without_latrines_in_less_than_200;
    }

    public void setNo_of_schools_without_latrines_in_less_than_200(int no_of_schools_without_latrines_in_less_than_200) {
        this.no_of_schools_without_latrines_in_less_than_200 = no_of_schools_without_latrines_in_less_than_200;
    }

    public int getNo_of_schools_without_latrines_in_less_more_200() {
        return no_of_schools_without_latrines_in_less_more_200;
    }

    public void setNo_of_schools_without_latrines_in_less_more_200(int no_of_schools_without_latrines_in_less_more_200) {
        this.no_of_schools_without_latrines_in_less_more_200 = no_of_schools_without_latrines_in_less_more_200;
    }

    public int getNo_of_schools_without_latrines() {
        return no_of_schools_without_latrines;
    }

    public void setNo_of_schools_without_latrines(int no_of_schools_without_latrines) {
        this.no_of_schools_without_latrines = no_of_schools_without_latrines;
    }

    public int getNo_of_schools_inadequate_latrines_in_less_than_200() {
        return no_of_schools_inadequate_latrines_in_less_than_200;
    }

    public void setNo_of_schools_inadequate_latrines_in_less_than_200(int no_of_schools_inadequate_latrines_in_less_than_200) {
        this.no_of_schools_inadequate_latrines_in_less_than_200 = no_of_schools_inadequate_latrines_in_less_than_200;
    }

    public int getNo_of_schools_inadequate_latrines_in_less_more_200() {
        return no_of_schools_inadequate_latrines_in_less_more_200;
    }

    public void setNo_of_schools_inadequate_latrines_in_less_more_200(int no_of_schools_inadequate_latrines_in_less_more_200) {
        this.no_of_schools_inadequate_latrines_in_less_more_200 = no_of_schools_inadequate_latrines_in_less_more_200;
    }

    public int getNo_of_schools_inadequate_latrines() {
        return no_of_schools_inadequate_latrines;
    }

    public void setNo_of_schools_inadequate_latrines(int no_of_schools_inadequate_latrines) {
        this.no_of_schools_inadequate_latrines = no_of_schools_inadequate_latrines;
    }

    public int getNo_of_schools_without_water_in_less_than_200() {
        return no_of_schools_without_water_in_less_than_200;
    }

    public void setNo_of_schools_without_water_in_less_than_200(int no_of_schools_without_water_in_less_than_200) {
        this.no_of_schools_without_water_in_less_than_200 = no_of_schools_without_water_in_less_than_200;
    }

    public int getNo_of_schools_without_water_in_less_more_200() {
        return no_of_schools_without_water_in_less_more_200;
    }

    public void setNo_of_schools_without_water_in_less_more_200(int no_of_schools_without_water_in_less_more_200) {
        this.no_of_schools_without_water_in_less_more_200 = no_of_schools_without_water_in_less_more_200;
    }

    public int getNo_of_schools_without_water() {
        return no_of_schools_without_water;
    }

    public void setNo_of_schools_without_water(int no_of_schools_without_water) {
        this.no_of_schools_without_water = no_of_schools_without_water;
    }

    public Month getMonth_1() {
        return month_1;
    }

    public void setMonth_1(Month month_1) {
        this.month_1 = month_1;
    }

    public Month getMonth_2() {
        return month_2;
    }

    public void setMonth_2(Month month_2) {
        this.month_2 = month_2;
    }

    public Month getMonth_3() {
        return month_3;
    }

    public void setMonth_3(Month month_3) {
        this.month_3 = month_3;
    }

    public int getReproductive_Health_Programmes_No_Conducted_1() {
        return reproductive_Health_Programmes_No_Conducted_1;
    }

    public void setReproductive_Health_Programmes_No_Conducted_1(int reproductive_Health_Programmes_No_Conducted_1) {
        this.reproductive_Health_Programmes_No_Conducted_1 = reproductive_Health_Programmes_No_Conducted_1;
    }

    public int getReproductive_Health_Programmes_No_Conducted_2() {
        return reproductive_Health_Programmes_No_Conducted_2;
    }

    public void setReproductive_Health_Programmes_No_Conducted_2(int reproductive_Health_Programmes_No_Conducted_2) {
        this.reproductive_Health_Programmes_No_Conducted_2 = reproductive_Health_Programmes_No_Conducted_2;
    }

    public int getReproductive_Health_Programmes_No_Conducted_3() {
        return reproductive_Health_Programmes_No_Conducted_3;
    }

    public void setReproductive_Health_Programmes_No_Conducted_3(int reproductive_Health_Programmes_No_Conducted_3) {
        this.reproductive_Health_Programmes_No_Conducted_3 = reproductive_Health_Programmes_No_Conducted_3;
    }

    public int getReproductive_Health_Programmes_No_Conducted() {
        return reproductive_Health_Programmes_No_Conducted;
    }

    public void setReproductive_Health_Programmes_No_Conducted(int reproductive_Health_Programmes_No_Conducted) {
        this.reproductive_Health_Programmes_No_Conducted = reproductive_Health_Programmes_No_Conducted;
    }

    public int getReproductive_Health_Programmes_Students_1() {
        return reproductive_Health_Programmes_Students_1;
    }

    public void setReproductive_Health_Programmes_Students_1(int reproductive_Health_Programmes_Students_1) {
        this.reproductive_Health_Programmes_Students_1 = reproductive_Health_Programmes_Students_1;
    }

    public int getReproductive_Health_Programmes_Students_2() {
        return reproductive_Health_Programmes_Students_2;
    }

    public void setReproductive_Health_Programmes_Students_2(int reproductive_Health_Programmes_Students_2) {
        this.reproductive_Health_Programmes_Students_2 = reproductive_Health_Programmes_Students_2;
    }

    public int getReproductive_Health_Programmes_Students_3() {
        return reproductive_Health_Programmes_Students_3;
    }

    public void setReproductive_Health_Programmes_Students_3(int reproductive_Health_Programmes_Students_3) {
        this.reproductive_Health_Programmes_Students_3 = reproductive_Health_Programmes_Students_3;
    }

    public int getReproductive_Health_Programmes_Students() {
        return reproductive_Health_Programmes_Students;
    }

    public void setReproductive_Health_Programmes_Students(int reproductive_Health_Programmes_Students) {
        this.reproductive_Health_Programmes_Students = reproductive_Health_Programmes_Students;
    }

    public int getReproductive_Health_Programmes_Teachers_1() {
        return reproductive_Health_Programmes_Teachers_1;
    }

    public void setReproductive_Health_Programmes_Teachers_1(int reproductive_Health_Programmes_Teachers_1) {
        this.reproductive_Health_Programmes_Teachers_1 = reproductive_Health_Programmes_Teachers_1;
    }

    public int getReproductive_Health_Programmes_Teachers_2() {
        return reproductive_Health_Programmes_Teachers_2;
    }

    public void setReproductive_Health_Programmes_Teachers_2(int reproductive_Health_Programmes_Teachers_2) {
        this.reproductive_Health_Programmes_Teachers_2 = reproductive_Health_Programmes_Teachers_2;
    }

    public int getReproductive_Health_Programmes_Teachers_3() {
        return reproductive_Health_Programmes_Teachers_3;
    }

    public void setReproductive_Health_Programmes_Teachers_3(int reproductive_Health_Programmes_Teachers_3) {
        this.reproductive_Health_Programmes_Teachers_3 = reproductive_Health_Programmes_Teachers_3;
    }

    public int getReproductive_Health_Programmes_Teachers() {
        return reproductive_Health_Programmes_Teachers;
    }

    public void setReproductive_Health_Programmes_Teachers(int reproductive_Health_Programmes_Teachers) {
        this.reproductive_Health_Programmes_Teachers = reproductive_Health_Programmes_Teachers;
    }

    public int getLife_skills_Health_Programmes_No_Conducted_1() {
        return life_skills_Health_Programmes_No_Conducted_1;
    }

    public void setLife_skills_Health_Programmes_No_Conducted_1(int life_skills_Health_Programmes_No_Conducted_1) {
        this.life_skills_Health_Programmes_No_Conducted_1 = life_skills_Health_Programmes_No_Conducted_1;
    }

    public int getLife_skills_Health_Programmes_No_Conducted_2() {
        return life_skills_Health_Programmes_No_Conducted_2;
    }

    public void setLife_skills_Health_Programmes_No_Conducted_2(int life_skills_Health_Programmes_No_Conducted_2) {
        this.life_skills_Health_Programmes_No_Conducted_2 = life_skills_Health_Programmes_No_Conducted_2;
    }

    public int getLife_skills_Health_Programmes_No_Conducted_3() {
        return life_skills_Health_Programmes_No_Conducted_3;
    }

    public void setLife_skills_Health_Programmes_No_Conducted_3(int life_skills_Health_Programmes_No_Conducted_3) {
        this.life_skills_Health_Programmes_No_Conducted_3 = life_skills_Health_Programmes_No_Conducted_3;
    }

    public int getLife_skills_Health_Programmes_No_Conducted() {
        return life_skills_Health_Programmes_No_Conducted;
    }

    public void setLife_skills_Health_Programmes_No_Conducted(int life_skills_Health_Programmes_No_Conducted) {
        this.life_skills_Health_Programmes_No_Conducted = life_skills_Health_Programmes_No_Conducted;
    }

    public int getLife_skills_Health_Programmes_Students_1() {
        return life_skills_Health_Programmes_Students_1;
    }

    public void setLife_skills_Health_Programmes_Students_1(int life_skills_Health_Programmes_Students_1) {
        this.life_skills_Health_Programmes_Students_1 = life_skills_Health_Programmes_Students_1;
    }

    public int getLife_skills_Health_Programmes_Students_2() {
        return life_skills_Health_Programmes_Students_2;
    }

    public void setLife_skills_Health_Programmes_Students_2(int life_skills_Health_Programmes_Students_2) {
        this.life_skills_Health_Programmes_Students_2 = life_skills_Health_Programmes_Students_2;
    }

    public int getLife_skills_Health_Programmes_Students_3() {
        return life_skills_Health_Programmes_Students_3;
    }

    public void setLife_skills_Health_Programmes_Students_3(int life_skills_Health_Programmes_Students_3) {
        this.life_skills_Health_Programmes_Students_3 = life_skills_Health_Programmes_Students_3;
    }

    public int getLife_skills_Health_Programmes_Students() {
        return life_skills_Health_Programmes_Students;
    }

    public void setLife_skills_Health_Programmes_Students(int life_skills_Health_Programmes_Students) {
        this.life_skills_Health_Programmes_Students = life_skills_Health_Programmes_Students;
    }

    public int getLife_skills_Health_Programmes_Teachers_1() {
        return life_skills_Health_Programmes_Teachers_1;
    }

    public void setLife_skills_Health_Programmes_Teachers_1(int life_skills_Health_Programmes_Teachers_1) {
        this.life_skills_Health_Programmes_Teachers_1 = life_skills_Health_Programmes_Teachers_1;
    }

    public int getLife_skills_Health_Programmes_Teachers_2() {
        return life_skills_Health_Programmes_Teachers_2;
    }

    public void setLife_skills_Health_Programmes_Teachers_2(int life_skills_Health_Programmes_Teachers_2) {
        this.life_skills_Health_Programmes_Teachers_2 = life_skills_Health_Programmes_Teachers_2;
    }

    public int getLife_skills_Health_Programmes_Teachers_3() {
        return life_skills_Health_Programmes_Teachers_3;
    }

    public void setLife_skills_Health_Programmes_Teachers_3(int life_skills_Health_Programmes_Teachers_3) {
        this.life_skills_Health_Programmes_Teachers_3 = life_skills_Health_Programmes_Teachers_3;
    }

    public int getLife_skills_Health_Programmes_Teachers() {
        return life_skills_Health_Programmes_Teachers;
    }

    public void setLife_skills_Health_Programmes_Teachers(int life_skills_Health_Programmes_Teachers) {
        this.life_skills_Health_Programmes_Teachers = life_skills_Health_Programmes_Teachers;
    }

    public int getCom_and_noncom_Health_Programmes_No_Conducted_1() {
        return com_and_noncom_Health_Programmes_No_Conducted_1;
    }

    public void setCom_and_noncom_Health_Programmes_No_Conducted_1(int com_and_noncom_Health_Programmes_No_Conducted_1) {
        this.com_and_noncom_Health_Programmes_No_Conducted_1 = com_and_noncom_Health_Programmes_No_Conducted_1;
    }

    public int getCom_and_noncom_Health_Programmes_No_Conducted_2() {
        return com_and_noncom_Health_Programmes_No_Conducted_2;
    }

    public void setCom_and_noncom_Health_Programmes_No_Conducted_2(int com_and_noncom_Health_Programmes_No_Conducted_2) {
        this.com_and_noncom_Health_Programmes_No_Conducted_2 = com_and_noncom_Health_Programmes_No_Conducted_2;
    }

    public int getCom_and_noncom_Health_Programmes_No_Conducted_3() {
        return com_and_noncom_Health_Programmes_No_Conducted_3;
    }

    public void setCom_and_noncom_Health_Programmes_No_Conducted_3(int com_and_noncom_Health_Programmes_No_Conducted_3) {
        this.com_and_noncom_Health_Programmes_No_Conducted_3 = com_and_noncom_Health_Programmes_No_Conducted_3;
    }

    public int getCom_and_noncom_Health_Programmes_No_Conducted() {
        return com_and_noncom_Health_Programmes_No_Conducted;
    }

    public void setCom_and_noncom_Health_Programmes_No_Conducted(int com_and_noncom_Health_Programmes_No_Conducted) {
        this.com_and_noncom_Health_Programmes_No_Conducted = com_and_noncom_Health_Programmes_No_Conducted;
    }

    public int getCom_and_noncom_Health_Programmes_Students_1() {
        return com_and_noncom_Health_Programmes_Students_1;
    }

    public void setCom_and_noncom_Health_Programmes_Students_1(int com_and_noncom_Health_Programmes_Students_1) {
        this.com_and_noncom_Health_Programmes_Students_1 = com_and_noncom_Health_Programmes_Students_1;
    }

    public int getCom_and_noncom_Health_Programmes_Students_2() {
        return com_and_noncom_Health_Programmes_Students_2;
    }

    public void setCom_and_noncom_Health_Programmes_Students_2(int com_and_noncom_Health_Programmes_Students_2) {
        this.com_and_noncom_Health_Programmes_Students_2 = com_and_noncom_Health_Programmes_Students_2;
    }

    public int getCom_and_noncom_Health_Programmes_Students_3() {
        return com_and_noncom_Health_Programmes_Students_3;
    }

    public void setCom_and_noncom_Health_Programmes_Students_3(int com_and_noncom_Health_Programmes_Students_3) {
        this.com_and_noncom_Health_Programmes_Students_3 = com_and_noncom_Health_Programmes_Students_3;
    }

    public int getCom_and_noncom_Health_Programmes_Students() {
        return com_and_noncom_Health_Programmes_Students;
    }

    public void setCom_and_noncom_Health_Programmes_Students(int com_and_noncom_Health_Programmes_Students) {
        this.com_and_noncom_Health_Programmes_Students = com_and_noncom_Health_Programmes_Students;
    }

    public int getCom_and_noncom_Health_Programmes_Teachers_1() {
        return com_and_noncom_Health_Programmes_Teachers_1;
    }

    public void setCom_and_noncom_Health_Programmes_Teachers_1(int com_and_noncom_Health_Programmes_Teachers_1) {
        this.com_and_noncom_Health_Programmes_Teachers_1 = com_and_noncom_Health_Programmes_Teachers_1;
    }

    public int getCom_and_noncom_Health_Programmes_Teachers_2() {
        return com_and_noncom_Health_Programmes_Teachers_2;
    }

    public void setCom_and_noncom_Health_Programmes_Teachers_2(int com_and_noncom_Health_Programmes_Teachers_2) {
        this.com_and_noncom_Health_Programmes_Teachers_2 = com_and_noncom_Health_Programmes_Teachers_2;
    }

    public int getCom_and_noncom_Health_Programmes_Teachers_3() {
        return com_and_noncom_Health_Programmes_Teachers_3;
    }

    public void setCom_and_noncom_Health_Programmes_Teachers_3(int com_and_noncom_Health_Programmes_Teachers_3) {
        this.com_and_noncom_Health_Programmes_Teachers_3 = com_and_noncom_Health_Programmes_Teachers_3;
    }

    public int getCom_and_noncom_Health_Programmes_Teachers() {
        return com_and_noncom_Health_Programmes_Teachers;
    }

    public void setCom_and_noncom_Health_Programmes_Teachers(int com_and_noncom_Health_Programmes_Teachers) {
        this.com_and_noncom_Health_Programmes_Teachers = com_and_noncom_Health_Programmes_Teachers;
    }

    public int getNutrition_programmes_Health_Programmes_No_Conducted_1() {
        return nutrition_programmes_Health_Programmes_No_Conducted_1;
    }

    public void setNutrition_programmes_Health_Programmes_No_Conducted_1(int nutrition_programmes_Health_Programmes_No_Conducted_1) {
        this.nutrition_programmes_Health_Programmes_No_Conducted_1 = nutrition_programmes_Health_Programmes_No_Conducted_1;
    }

    public int getNutrition_programmes_Health_Programmes_No_Conducted_2() {
        return nutrition_programmes_Health_Programmes_No_Conducted_2;
    }

    public void setNutrition_programmes_Health_Programmes_No_Conducted_2(int nutrition_programmes_Health_Programmes_No_Conducted_2) {
        this.nutrition_programmes_Health_Programmes_No_Conducted_2 = nutrition_programmes_Health_Programmes_No_Conducted_2;
    }

    public int getNutrition_programmes_Health_Programmes_No_Conducted_3() {
        return nutrition_programmes_Health_Programmes_No_Conducted_3;
    }

    public void setNutrition_programmes_Health_Programmes_No_Conducted_3(int nutrition_programmes_Health_Programmes_No_Conducted_3) {
        this.nutrition_programmes_Health_Programmes_No_Conducted_3 = nutrition_programmes_Health_Programmes_No_Conducted_3;
    }

    public int getNutrition_programmes_Health_Programmes_No_Conducted() {
        return nutrition_programmes_Health_Programmes_No_Conducted;
    }

    public void setNutrition_programmes_Health_Programmes_No_Conducted(int nutrition_programmes_Health_Programmes_No_Conducted) {
        this.nutrition_programmes_Health_Programmes_No_Conducted = nutrition_programmes_Health_Programmes_No_Conducted;
    }

    public int getNutrition_programmes_Health_Programmes_Students_1() {
        return nutrition_programmes_Health_Programmes_Students_1;
    }

    public void setNutrition_programmes_Health_Programmes_Students_1(int nutrition_programmes_Health_Programmes_Students_1) {
        this.nutrition_programmes_Health_Programmes_Students_1 = nutrition_programmes_Health_Programmes_Students_1;
    }

    public int getNutrition_programmes_Health_Programmes_Students_2() {
        return nutrition_programmes_Health_Programmes_Students_2;
    }

    public void setNutrition_programmes_Health_Programmes_Students_2(int nutrition_programmes_Health_Programmes_Students_2) {
        this.nutrition_programmes_Health_Programmes_Students_2 = nutrition_programmes_Health_Programmes_Students_2;
    }

    public int getNutrition_programmes_Health_Programmes_Students_3() {
        return nutrition_programmes_Health_Programmes_Students_3;
    }

    public void setNutrition_programmes_Health_Programmes_Students_3(int nutrition_programmes_Health_Programmes_Students_3) {
        this.nutrition_programmes_Health_Programmes_Students_3 = nutrition_programmes_Health_Programmes_Students_3;
    }

    public int getNutrition_programmes_Health_Programmes_Students() {
        return nutrition_programmes_Health_Programmes_Students;
    }

    public void setNutrition_programmes_Health_Programmes_Students(int nutrition_programmes_Health_Programmes_Students) {
        this.nutrition_programmes_Health_Programmes_Students = nutrition_programmes_Health_Programmes_Students;
    }

    public int getNutrition_programmes_Health_Programmes_Teachers_1() {
        return nutrition_programmes_Health_Programmes_Teachers_1;
    }

    public void setNutrition_programmes_Health_Programmes_Teachers_1(int nutrition_programmes_Health_Programmes_Teachers_1) {
        this.nutrition_programmes_Health_Programmes_Teachers_1 = nutrition_programmes_Health_Programmes_Teachers_1;
    }

    public int getNutrition_programmes_Health_Programmes_Teachers_2() {
        return nutrition_programmes_Health_Programmes_Teachers_2;
    }

    public void setNutrition_programmes_Health_Programmes_Teachers_2(int nutrition_programmes_Health_Programmes_Teachers_2) {
        this.nutrition_programmes_Health_Programmes_Teachers_2 = nutrition_programmes_Health_Programmes_Teachers_2;
    }

    public int getNutrition_programmes_Health_Programmes_Teachers_3() {
        return nutrition_programmes_Health_Programmes_Teachers_3;
    }

    public void setNutrition_programmes_Health_Programmes_Teachers_3(int nutrition_programmes_Health_Programmes_Teachers_3) {
        this.nutrition_programmes_Health_Programmes_Teachers_3 = nutrition_programmes_Health_Programmes_Teachers_3;
    }

    public int getNutrition_programmes_Health_Programmes_Teachers() {
        return nutrition_programmes_Health_Programmes_Teachers;
    }

    public void setNutrition_programmes_Health_Programmes_Teachers(int nutrition_programmes_Health_Programmes_Teachers) {
        this.nutrition_programmes_Health_Programmes_Teachers = nutrition_programmes_Health_Programmes_Teachers;
    }

    public int getStudents_Councelled_1() {
        return students_Councelled_1;
    }

    public void setStudents_Councelled_1(int students_Councelled_1) {
        this.students_Councelled_1 = students_Councelled_1;
    }

    public int getStudents_Councelled_2() {
        return students_Councelled_2;
    }

    public void setStudents_Councelled_2(int students_Councelled_2) {
        this.students_Councelled_2 = students_Councelled_2;
    }

    public int getStudents_Councelled_3() {
        return students_Councelled_3;
    }

    public void setStudents_Councelled_3(int students_Councelled_3) {
        this.students_Councelled_3 = students_Councelled_3;
    }

    public int getStudents_Councelled() {
        return students_Councelled;
    }

    public void setStudents_Councelled(int students_Councelled) {
        this.students_Councelled = students_Councelled;
    }

    public int getCommunity_Health_1() {
        return community_Health_1;
    }

    public void setCommunity_Health_1(int community_Health_1) {
        this.community_Health_1 = community_Health_1;
    }

    public int getCommunity_Health_2() {
        return community_Health_2;
    }

    public void setCommunity_Health_2(int community_Health_2) {
        this.community_Health_2 = community_Health_2;
    }

    public int getCommunity_Health_3() {
        return community_Health_3;
    }

    public void setCommunity_Health_3(int community_Health_3) {
        this.community_Health_3 = community_Health_3;
    }

    public int getCommunity_Health() {
        return community_Health;
    }

    public void setCommunity_Health(int community_Health) {
        this.community_Health = community_Health;
    }

    public int getOther_1() {
        return other_1;
    }

    public void setOther_1(int other_1) {
        this.other_1 = other_1;
    }

    public int getOther_2() {
        return other_2;
    }

    public void setOther_2(int other_2) {
        this.other_2 = other_2;
    }

    public int getOther_3() {
        return other_3;
    }

    public void setOther_3(int other_3) {
        this.other_3 = other_3;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getPhi_smi_l200() {
        return phi_smi_l200;
    }

    public void setPhi_smi_l200(int phi_smi_l200) {
        this.phi_smi_l200 = phi_smi_l200;
    }

    public int getPhi_smi_m200() {
        return phi_smi_m200;
    }

    public void setPhi_smi_m200(int phi_smi_m200) {
        this.phi_smi_m200 = phi_smi_m200;
    }

    public int getPhi_smi() {
        return phi_smi;
    }

    public void setPhi_smi(int phi_smi) {
        this.phi_smi = phi_smi;
    }

    public int getMoh_smi_l200() {
        return moh_smi_l200;
    }

    public void setMoh_smi_l200(int moh_smi_l200) {
        this.moh_smi_l200 = moh_smi_l200;
    }

    public int getMoh_smi_m200() {
        return moh_smi_m200;
    }

    public void setMoh_smi_m200(int moh_smi_m200) {
        this.moh_smi_m200 = moh_smi_m200;
    }

    public int getMoh_smi() {
        return moh_smi;
    }

    public void setMoh_smi(int moh_smi) {
        this.moh_smi = moh_smi;
    }

    public int getAmoh_smi_l200() {
        return amoh_smi_l200;
    }

    public void setAmoh_smi_l200(int amoh_smi_l200) {
        this.amoh_smi_l200 = amoh_smi_l200;
    }

    public int getAmoh_smi_m200() {
        return amoh_smi_m200;
    }

    public void setAmoh_smi_m200(int amoh_smi_m200) {
        this.amoh_smi_m200 = amoh_smi_m200;
    }

    public int getAmoh_smi() {
        return amoh_smi;
    }

    public void setAmoh_smi(int amoh_smi) {
        this.amoh_smi = amoh_smi;
    }

    public int getMo_smi_l200() {
        return mo_smi_l200;
    }

    public void setMo_smi_l200(int mo_smi_l200) {
        this.mo_smi_l200 = mo_smi_l200;
    }

    public int getMo_smi_m200() {
        return mo_smi_m200;
    }

    public void setMo_smi_m200(int mo_smi_m200) {
        this.mo_smi_m200 = mo_smi_m200;
    }

    public int getMo_smi() {
        return mo_smi;
    }

    public void setMo_smi(int mo_smi) {
        this.mo_smi = mo_smi;
    }

    public int getRmo_smi_l200() {
        return rmo_smi_l200;
    }

    public void setRmo_smi_l200(int rmo_smi_l200) {
        this.rmo_smi_l200 = rmo_smi_l200;
    }

    public int getRmo_smi_m200() {
        return rmo_smi_m200;
    }

    public void setRmo_smi_m200(int rmo_smi_m200) {
        this.rmo_smi_m200 = rmo_smi_m200;
    }

    public int getRmo_smi() {
        return rmo_smi;
    }

    public void setRmo_smi(int rmo_smi) {
        this.rmo_smi = rmo_smi;
    }

    public int getSmi_quarter_l200() {
        return smi_quarter_l200;
    }

    public void setSmi_quarter_l200(int smi_quarter_l200) {
        this.smi_quarter_l200 = smi_quarter_l200;
    }

    public int getSmi_quarter_m200() {
        return smi_quarter_m200;
    }

    public void setSmi_quarter_m200(int smi_quarter_m200) {
        this.smi_quarter_m200 = smi_quarter_m200;
    }

    public int getSmi_quarter() {
        return smi_quarter;
    }

    public void setSmi_quarter(int smi_quarter) {
        this.smi_quarter = smi_quarter;
    }

    public int getSmi_cumulative_l200() {
        return smi_cumulative_l200;
    }

    public void setSmi_cumulative_l200(int smi_cumulative_l200) {
        this.smi_cumulative_l200 = smi_cumulative_l200;
    }

    public int getSmi_cumulative_m200() {
        return smi_cumulative_m200;
    }

    public void setSmi_cumulative_m200(int smi_cumulative_m200) {
        this.smi_cumulative_m200 = smi_cumulative_m200;
    }

    public int getSmi_cumulative() {
        return smi_cumulative;
    }

    public void setSmi_cumulative(int smi_cumulative) {
        this.smi_cumulative = smi_cumulative;
    }

    public int getSmi_l200_m_1() {
        return smi_l200_m_1;
    }

    public void setSmi_l200_m_1(int smi_l200_m_1) {
        this.smi_l200_m_1 = smi_l200_m_1;
    }

    public int getSmi_l200_m_4() {
        return smi_l200_m_4;
    }

    public void setSmi_l200_m_4(int smi_l200_m_4) {
        this.smi_l200_m_4 = smi_l200_m_4;
    }

    public int getSmi_l200_m_7() {
        return smi_l200_m_7;
    }

    public void setSmi_l200_m_7(int smi_l200_m_7) {
        this.smi_l200_m_7 = smi_l200_m_7;
    }

    public int getSmi_l200_m_10() {
        return smi_l200_m_10;
    }

    public void setSmi_l200_m_10(int smi_l200_m_10) {
        this.smi_l200_m_10 = smi_l200_m_10;
    }

    public int getSmi_l200_m_other() {
        return smi_l200_m_other;
    }

    public void setSmi_l200_m_other(int smi_l200_m_other) {
        this.smi_l200_m_other = smi_l200_m_other;
    }

    public int getSmi_l200_m_total() {
        return smi_l200_m_total;
    }

    public void setSmi_l200_m_total(int smi_l200_m_total) {
        this.smi_l200_m_total = smi_l200_m_total;
    }

    public int getSmi_l200_f_1() {
        return smi_l200_f_1;
    }

    public void setSmi_l200_f_1(int smi_l200_f_1) {
        this.smi_l200_f_1 = smi_l200_f_1;
    }

    public int getSmi_l200_f_4() {
        return smi_l200_f_4;
    }

    public void setSmi_l200_f_4(int smi_l200_f_4) {
        this.smi_l200_f_4 = smi_l200_f_4;
    }

    public int getSmi_l200_f_7() {
        return smi_l200_f_7;
    }

    public void setSmi_l200_f_7(int smi_l200_f_7) {
        this.smi_l200_f_7 = smi_l200_f_7;
    }

    public int getSmi_l200_f_10() {
        return smi_l200_f_10;
    }

    public void setSmi_l200_f_10(int smi_l200_f_10) {
        this.smi_l200_f_10 = smi_l200_f_10;
    }

    public int getSmi_l200_f_other() {
        return smi_l200_f_other;
    }

    public void setSmi_l200_f_other(int smi_l200_f_other) {
        this.smi_l200_f_other = smi_l200_f_other;
    }

    public int getSmi_l200_f_total() {
        return smi_l200_f_total;
    }

    public void setSmi_l200_f_total(int smi_l200_f_total) {
        this.smi_l200_f_total = smi_l200_f_total;
    }

    public int getStunting_1_m_fm() {
        return stunting_1_m_fm;
    }

    public void setStunting_1_m_fm(int stunting_1_m_fm) {
        this.stunting_1_m_fm = stunting_1_m_fm;
    }

    public int getStunting_1_m_sm() {
        return stunting_1_m_sm;
    }

    public void setStunting_1_m_sm(int stunting_1_m_sm) {
        this.stunting_1_m_sm = stunting_1_m_sm;
    }

    public int getStunting_1_m_tm() {
        return stunting_1_m_tm;
    }

    public void setStunting_1_m_tm(int stunting_1_m_tm) {
        this.stunting_1_m_tm = stunting_1_m_tm;
    }

    public int getStunting_1_m() {
        return stunting_1_m;
    }

    public void setStunting_1_m(int stunting_1_m) {
        this.stunting_1_m = stunting_1_m;
    }

    public int getStunting_1_f_fm() {
        return stunting_1_f_fm;
    }

    public void setStunting_1_f_fm(int stunting_1_f_fm) {
        this.stunting_1_f_fm = stunting_1_f_fm;
    }

    public int getStunting_1_f_sm() {
        return stunting_1_f_sm;
    }

    public void setStunting_1_f_sm(int stunting_1_f_sm) {
        this.stunting_1_f_sm = stunting_1_f_sm;
    }

    public int getStunting_1_f_tm() {
        return stunting_1_f_tm;
    }

    public void setStunting_1_f_tm(int stunting_1_f_tm) {
        this.stunting_1_f_tm = stunting_1_f_tm;
    }

    public int getStunting_1_f() {
        return stunting_1_f;
    }

    public void setStunting_1_f(int stunting_1_f) {
        this.stunting_1_f = stunting_1_f;
    }

    public int getStunting_4_m_fm() {
        return stunting_4_m_fm;
    }

    public void setStunting_4_m_fm(int stunting_4_m_fm) {
        this.stunting_4_m_fm = stunting_4_m_fm;
    }

    public int getStunting_4_m_sm() {
        return stunting_4_m_sm;
    }

    public void setStunting_4_m_sm(int stunting_4_m_sm) {
        this.stunting_4_m_sm = stunting_4_m_sm;
    }

    public int getStunting_4_m_tm() {
        return stunting_4_m_tm;
    }

    public void setStunting_4_m_tm(int stunting_4_m_tm) {
        this.stunting_4_m_tm = stunting_4_m_tm;
    }

    public int getStunting_4_m() {
        return stunting_4_m;
    }

    public void setStunting_4_m(int stunting_4_m) {
        this.stunting_4_m = stunting_4_m;
    }

    public int getStunting_4_f_fm() {
        return stunting_4_f_fm;
    }

    public void setStunting_4_f_fm(int stunting_4_f_fm) {
        this.stunting_4_f_fm = stunting_4_f_fm;
    }

    public int getStunting_4_f_sm() {
        return stunting_4_f_sm;
    }

    public void setStunting_4_f_sm(int stunting_4_f_sm) {
        this.stunting_4_f_sm = stunting_4_f_sm;
    }

    public int getStunting_4_f_tm() {
        return stunting_4_f_tm;
    }

    public void setStunting_4_f_tm(int stunting_4_f_tm) {
        this.stunting_4_f_tm = stunting_4_f_tm;
    }

    public int getStunting_4_f() {
        return stunting_4_f;
    }

    public void setStunting_4_f(int stunting_4_f) {
        this.stunting_4_f = stunting_4_f;
    }

    public int getWasting_1_m_fm() {
        return wasting_1_m_fm;
    }

    public void setWasting_1_m_fm(int wasting_1_m_fm) {
        this.wasting_1_m_fm = wasting_1_m_fm;
    }

    public int getWasting_1_m_sm() {
        return wasting_1_m_sm;
    }

    public void setWasting_1_m_sm(int wasting_1_m_sm) {
        this.wasting_1_m_sm = wasting_1_m_sm;
    }

    public int getWasting_1_m_tm() {
        return wasting_1_m_tm;
    }

    public void setWasting_1_m_tm(int wasting_1_m_tm) {
        this.wasting_1_m_tm = wasting_1_m_tm;
    }

    public int getWasting_1_m() {
        return wasting_1_m;
    }

    public void setWasting_1_m(int wasting_1_m) {
        this.wasting_1_m = wasting_1_m;
    }

    public int getWasting_1_f_fm() {
        return wasting_1_f_fm;
    }

    public void setWasting_1_f_fm(int wasting_1_f_fm) {
        this.wasting_1_f_fm = wasting_1_f_fm;
    }

    public int getWasting_1_f_sm() {
        return wasting_1_f_sm;
    }

    public void setWasting_1_f_sm(int wasting_1_f_sm) {
        this.wasting_1_f_sm = wasting_1_f_sm;
    }

    public int getWasting_1_f_tm() {
        return wasting_1_f_tm;
    }

    public void setWasting_1_f_tm(int wasting_1_f_tm) {
        this.wasting_1_f_tm = wasting_1_f_tm;
    }

    public int getWasting_1_f() {
        return wasting_1_f;
    }

    public void setWasting_1_f(int wasting_1_f) {
        this.wasting_1_f = wasting_1_f;
    }

    public int getWasting_4_m_fm() {
        return wasting_4_m_fm;
    }

    public void setWasting_4_m_fm(int wasting_4_m_fm) {
        this.wasting_4_m_fm = wasting_4_m_fm;
    }

    public int getWasting_4_m_sm() {
        return wasting_4_m_sm;
    }

    public void setWasting_4_m_sm(int wasting_4_m_sm) {
        this.wasting_4_m_sm = wasting_4_m_sm;
    }

    public int getWasting_4_m_tm() {
        return wasting_4_m_tm;
    }

    public void setWasting_4_m_tm(int wasting_4_m_tm) {
        this.wasting_4_m_tm = wasting_4_m_tm;
    }

    public int getWasting_4_m() {
        return wasting_4_m;
    }

    public void setWasting_4_m(int wasting_4_m) {
        this.wasting_4_m = wasting_4_m;
    }

    public int getWasting_4_f_fm() {
        return wasting_4_f_fm;
    }

    public void setWasting_4_f_fm(int wasting_4_f_fm) {
        this.wasting_4_f_fm = wasting_4_f_fm;
    }

    public int getWasting_4_f_sm() {
        return wasting_4_f_sm;
    }

    public void setWasting_4_f_sm(int wasting_4_f_sm) {
        this.wasting_4_f_sm = wasting_4_f_sm;
    }

    public int getWasting_4_f_tm() {
        return wasting_4_f_tm;
    }

    public void setWasting_4_f_tm(int wasting_4_f_tm) {
        this.wasting_4_f_tm = wasting_4_f_tm;
    }

    public int getWasting_4_f() {
        return wasting_4_f;
    }

    public void setWasting_4_f(int wasting_4_f) {
        this.wasting_4_f = wasting_4_f;
    }

    public int getWasting_7_m_fm() {
        return wasting_7_m_fm;
    }

    public void setWasting_7_m_fm(int wasting_7_m_fm) {
        this.wasting_7_m_fm = wasting_7_m_fm;
    }

    public int getWasting_7_m_sm() {
        return wasting_7_m_sm;
    }

    public void setWasting_7_m_sm(int wasting_7_m_sm) {
        this.wasting_7_m_sm = wasting_7_m_sm;
    }

    public int getWasting_7_m_tm() {
        return wasting_7_m_tm;
    }

    public void setWasting_7_m_tm(int wasting_7_m_tm) {
        this.wasting_7_m_tm = wasting_7_m_tm;
    }

    public int getWasting_7_m() {
        return wasting_7_m;
    }

    public void setWasting_7_m(int wasting_7_m) {
        this.wasting_7_m = wasting_7_m;
    }

    public int getWasting_7_f_fm() {
        return wasting_7_f_fm;
    }

    public void setWasting_7_f_fm(int wasting_7_f_fm) {
        this.wasting_7_f_fm = wasting_7_f_fm;
    }

    public int getWasting_7_f_sm() {
        return wasting_7_f_sm;
    }

    public void setWasting_7_f_sm(int wasting_7_f_sm) {
        this.wasting_7_f_sm = wasting_7_f_sm;
    }

    public int getWasting_7_f_tm() {
        return wasting_7_f_tm;
    }

    public void setWasting_7_f_tm(int wasting_7_f_tm) {
        this.wasting_7_f_tm = wasting_7_f_tm;
    }

    public int getWasting_7_f() {
        return wasting_7_f;
    }

    public void setWasting_7_f(int wasting_7_f) {
        this.wasting_7_f = wasting_7_f;
    }

    public int getWasting_10_m_fm() {
        return wasting_10_m_fm;
    }

    public void setWasting_10_m_fm(int wasting_10_m_fm) {
        this.wasting_10_m_fm = wasting_10_m_fm;
    }

    public int getWasting_10_m_sm() {
        return wasting_10_m_sm;
    }

    public void setWasting_10_m_sm(int wasting_10_m_sm) {
        this.wasting_10_m_sm = wasting_10_m_sm;
    }

    public int getWasting_10_m_tm() {
        return wasting_10_m_tm;
    }

    public void setWasting_10_m_tm(int wasting_10_m_tm) {
        this.wasting_10_m_tm = wasting_10_m_tm;
    }

    public int getWasting_10_m() {
        return wasting_10_m;
    }

    public void setWasting_10_m(int wasting_10_m) {
        this.wasting_10_m = wasting_10_m;
    }

    public int getWasting_10_f_fm() {
        return wasting_10_f_fm;
    }

    public void setWasting_10_f_fm(int wasting_10_f_fm) {
        this.wasting_10_f_fm = wasting_10_f_fm;
    }

    public int getWasting_10_f_sm() {
        return wasting_10_f_sm;
    }

    public void setWasting_10_f_sm(int wasting_10_f_sm) {
        this.wasting_10_f_sm = wasting_10_f_sm;
    }

    public int getWasting_10_f_tm() {
        return wasting_10_f_tm;
    }

    public void setWasting_10_f_tm(int wasting_10_f_tm) {
        this.wasting_10_f_tm = wasting_10_f_tm;
    }

    public int getWasting_10_f() {
        return wasting_10_f;
    }

    public void setWasting_10_f(int wasting_10_f) {
        this.wasting_10_f = wasting_10_f;
    }

    public int getWasting_other_m_fm() {
        return wasting_other_m_fm;
    }

    public void setWasting_other_m_fm(int wasting_other_m_fm) {
        this.wasting_other_m_fm = wasting_other_m_fm;
    }

    public int getWasting_other_m_sm() {
        return wasting_other_m_sm;
    }

    public void setWasting_other_m_sm(int wasting_other_m_sm) {
        this.wasting_other_m_sm = wasting_other_m_sm;
    }

    public int getWasting_other_m_tm() {
        return wasting_other_m_tm;
    }

    public void setWasting_other_m_tm(int wasting_other_m_tm) {
        this.wasting_other_m_tm = wasting_other_m_tm;
    }

    public int getWasting_other_m() {
        return wasting_other_m;
    }

    public void setWasting_other_m(int wasting_other_m) {
        this.wasting_other_m = wasting_other_m;
    }

    public int getWasting_other_f_fm() {
        return wasting_other_f_fm;
    }

    public void setWasting_other_f_fm(int wasting_other_f_fm) {
        this.wasting_other_f_fm = wasting_other_f_fm;
    }

    public int getWasting_other_f_sm() {
        return wasting_other_f_sm;
    }

    public void setWasting_other_f_sm(int wasting_other_f_sm) {
        this.wasting_other_f_sm = wasting_other_f_sm;
    }

    public int getWasting_other_f_tm() {
        return wasting_other_f_tm;
    }

    public void setWasting_other_f_tm(int wasting_other_f_tm) {
        this.wasting_other_f_tm = wasting_other_f_tm;
    }

    public int getWasting_other_f() {
        return wasting_other_f;
    }

    public void setWasting_other_f(int wasting_other_f) {
        this.wasting_other_f = wasting_other_f;
    }

    public int getOverweight_1_m_fm() {
        return overweight_1_m_fm;
    }

    public void setOverweight_1_m_fm(int overweight_1_m_fm) {
        this.overweight_1_m_fm = overweight_1_m_fm;
    }

    public int getOverweight_1_m_sm() {
        return overweight_1_m_sm;
    }

    public void setOverweight_1_m_sm(int overweight_1_m_sm) {
        this.overweight_1_m_sm = overweight_1_m_sm;
    }

    public int getOverweight_1_m_tm() {
        return overweight_1_m_tm;
    }

    public void setOverweight_1_m_tm(int overweight_1_m_tm) {
        this.overweight_1_m_tm = overweight_1_m_tm;
    }

    public int getOverweight_1_m() {
        return overweight_1_m;
    }

    public void setOverweight_1_m(int overweight_1_m) {
        this.overweight_1_m = overweight_1_m;
    }

    public int getOverweight_1_f_fm() {
        return overweight_1_f_fm;
    }

    public void setOverweight_1_f_fm(int overweight_1_f_fm) {
        this.overweight_1_f_fm = overweight_1_f_fm;
    }

    public int getOverweight_1_f_sm() {
        return overweight_1_f_sm;
    }

    public void setOverweight_1_f_sm(int overweight_1_f_sm) {
        this.overweight_1_f_sm = overweight_1_f_sm;
    }

    public int getOverweight_1_f_tm() {
        return overweight_1_f_tm;
    }

    public void setOverweight_1_f_tm(int overweight_1_f_tm) {
        this.overweight_1_f_tm = overweight_1_f_tm;
    }

    public int getOverweight_1_f() {
        return overweight_1_f;
    }

    public void setOverweight_1_f(int overweight_1_f) {
        this.overweight_1_f = overweight_1_f;
    }

    public int getOverweight_4_m_fm() {
        return overweight_4_m_fm;
    }

    public void setOverweight_4_m_fm(int overweight_4_m_fm) {
        this.overweight_4_m_fm = overweight_4_m_fm;
    }

    public int getOverweight_4_m_sm() {
        return overweight_4_m_sm;
    }

    public void setOverweight_4_m_sm(int overweight_4_m_sm) {
        this.overweight_4_m_sm = overweight_4_m_sm;
    }

    public int getOverweight_4_m_tm() {
        return overweight_4_m_tm;
    }

    public void setOverweight_4_m_tm(int overweight_4_m_tm) {
        this.overweight_4_m_tm = overweight_4_m_tm;
    }

    public int getOverweight_4_m() {
        return overweight_4_m;
    }

    public void setOverweight_4_m(int overweight_4_m) {
        this.overweight_4_m = overweight_4_m;
    }

    public int getOverweight_4_f_fm() {
        return overweight_4_f_fm;
    }

    public void setOverweight_4_f_fm(int overweight_4_f_fm) {
        this.overweight_4_f_fm = overweight_4_f_fm;
    }

    public int getOverweight_4_f_sm() {
        return overweight_4_f_sm;
    }

    public void setOverweight_4_f_sm(int overweight_4_f_sm) {
        this.overweight_4_f_sm = overweight_4_f_sm;
    }

    public int getOverweight_4_f_tm() {
        return overweight_4_f_tm;
    }

    public void setOverweight_4_f_tm(int overweight_4_f_tm) {
        this.overweight_4_f_tm = overweight_4_f_tm;
    }

    public int getOverweight_4_f() {
        return overweight_4_f;
    }

    public void setOverweight_4_f(int overweight_4_f) {
        this.overweight_4_f = overweight_4_f;
    }

    public int getOverweight_7_m_fm() {
        return overweight_7_m_fm;
    }

    public void setOverweight_7_m_fm(int overweight_7_m_fm) {
        this.overweight_7_m_fm = overweight_7_m_fm;
    }

    public int getOverweight_7_m_sm() {
        return overweight_7_m_sm;
    }

    public void setOverweight_7_m_sm(int overweight_7_m_sm) {
        this.overweight_7_m_sm = overweight_7_m_sm;
    }

    public int getOverweight_7_m_tm() {
        return overweight_7_m_tm;
    }

    public void setOverweight_7_m_tm(int overweight_7_m_tm) {
        this.overweight_7_m_tm = overweight_7_m_tm;
    }

    public int getOverweight_7_m() {
        return overweight_7_m;
    }

    public void setOverweight_7_m(int overweight_7_m) {
        this.overweight_7_m = overweight_7_m;
    }

    public int getOverweight_7_f_fm() {
        return overweight_7_f_fm;
    }

    public void setOverweight_7_f_fm(int overweight_7_f_fm) {
        this.overweight_7_f_fm = overweight_7_f_fm;
    }

    public int getOverweight_7_f_sm() {
        return overweight_7_f_sm;
    }

    public void setOverweight_7_f_sm(int overweight_7_f_sm) {
        this.overweight_7_f_sm = overweight_7_f_sm;
    }

    public int getOverweight_7_f_tm() {
        return overweight_7_f_tm;
    }

    public void setOverweight_7_f_tm(int overweight_7_f_tm) {
        this.overweight_7_f_tm = overweight_7_f_tm;
    }

    public int getOverweight_7_f() {
        return overweight_7_f;
    }

    public void setOverweight_7_f(int overweight_7_f) {
        this.overweight_7_f = overweight_7_f;
    }

    public int getOverweight_10_m_fm() {
        return overweight_10_m_fm;
    }

    public void setOverweight_10_m_fm(int overweight_10_m_fm) {
        this.overweight_10_m_fm = overweight_10_m_fm;
    }

    public int getOverweight_10_m_sm() {
        return overweight_10_m_sm;
    }

    public void setOverweight_10_m_sm(int overweight_10_m_sm) {
        this.overweight_10_m_sm = overweight_10_m_sm;
    }

    public int getOverweight_10_m_tm() {
        return overweight_10_m_tm;
    }

    public void setOverweight_10_m_tm(int overweight_10_m_tm) {
        this.overweight_10_m_tm = overweight_10_m_tm;
    }

    public int getOverweight_10_m() {
        return overweight_10_m;
    }

    public void setOverweight_10_m(int overweight_10_m) {
        this.overweight_10_m = overweight_10_m;
    }

    public int getOverweight_10_f_fm() {
        return overweight_10_f_fm;
    }

    public void setOverweight_10_f_fm(int overweight_10_f_fm) {
        this.overweight_10_f_fm = overweight_10_f_fm;
    }

    public int getOverweight_10_f_sm() {
        return overweight_10_f_sm;
    }

    public void setOverweight_10_f_sm(int overweight_10_f_sm) {
        this.overweight_10_f_sm = overweight_10_f_sm;
    }

    public int getOverweight_10_f_tm() {
        return overweight_10_f_tm;
    }

    public void setOverweight_10_f_tm(int overweight_10_f_tm) {
        this.overweight_10_f_tm = overweight_10_f_tm;
    }

    public int getOverweight_10_f() {
        return overweight_10_f;
    }

    public void setOverweight_10_f(int overweight_10_f) {
        this.overweight_10_f = overweight_10_f;
    }

    public int getOverweight_other_m_fm() {
        return overweight_other_m_fm;
    }

    public void setOverweight_other_m_fm(int overweight_other_m_fm) {
        this.overweight_other_m_fm = overweight_other_m_fm;
    }

    public int getOverweight_other_m_sm() {
        return overweight_other_m_sm;
    }

    public void setOverweight_other_m_sm(int overweight_other_m_sm) {
        this.overweight_other_m_sm = overweight_other_m_sm;
    }

    public int getOverweight_other_m_tm() {
        return overweight_other_m_tm;
    }

    public void setOverweight_other_m_tm(int overweight_other_m_tm) {
        this.overweight_other_m_tm = overweight_other_m_tm;
    }

    public int getOverweight_other_m() {
        return overweight_other_m;
    }

    public void setOverweight_other_m(int overweight_other_m) {
        this.overweight_other_m = overweight_other_m;
    }

    public int getOverweight_other_f_fm() {
        return overweight_other_f_fm;
    }

    public void setOverweight_other_f_fm(int overweight_other_f_fm) {
        this.overweight_other_f_fm = overweight_other_f_fm;
    }

    public int getOverweight_other_f_sm() {
        return overweight_other_f_sm;
    }

    public void setOverweight_other_f_sm(int overweight_other_f_sm) {
        this.overweight_other_f_sm = overweight_other_f_sm;
    }

    public int getOverweight_other_f_tm() {
        return overweight_other_f_tm;
    }

    public void setOverweight_other_f_tm(int overweight_other_f_tm) {
        this.overweight_other_f_tm = overweight_other_f_tm;
    }

    public int getOverweight_other_f() {
        return overweight_other_f;
    }

    public void setOverweight_other_f(int overweight_other_f) {
        this.overweight_other_f = overweight_other_f;
    }

    public int getObesity_1_m_fm() {
        return obesity_1_m_fm;
    }

    public void setObesity_1_m_fm(int obesity_1_m_fm) {
        this.obesity_1_m_fm = obesity_1_m_fm;
    }

    public int getObesity_1_m_sm() {
        return obesity_1_m_sm;
    }

    public void setObesity_1_m_sm(int obesity_1_m_sm) {
        this.obesity_1_m_sm = obesity_1_m_sm;
    }

    public int getObesity_1_m_tm() {
        return obesity_1_m_tm;
    }

    public void setObesity_1_m_tm(int obesity_1_m_tm) {
        this.obesity_1_m_tm = obesity_1_m_tm;
    }

    public int getObesity_1_m() {
        return obesity_1_m;
    }

    public void setObesity_1_m(int obesity_1_m) {
        this.obesity_1_m = obesity_1_m;
    }

    public int getObesity_1_f_fm() {
        return obesity_1_f_fm;
    }

    public void setObesity_1_f_fm(int obesity_1_f_fm) {
        this.obesity_1_f_fm = obesity_1_f_fm;
    }

    public int getObesity_1_f_sm() {
        return obesity_1_f_sm;
    }

    public void setObesity_1_f_sm(int obesity_1_f_sm) {
        this.obesity_1_f_sm = obesity_1_f_sm;
    }

    public int getObesity_1_f_tm() {
        return obesity_1_f_tm;
    }

    public void setObesity_1_f_tm(int obesity_1_f_tm) {
        this.obesity_1_f_tm = obesity_1_f_tm;
    }

    public int getObesity_1_f() {
        return obesity_1_f;
    }

    public void setObesity_1_f(int obesity_1_f) {
        this.obesity_1_f = obesity_1_f;
    }

    public int getObesity_4_m_fm() {
        return obesity_4_m_fm;
    }

    public void setObesity_4_m_fm(int obesity_4_m_fm) {
        this.obesity_4_m_fm = obesity_4_m_fm;
    }

    public int getObesity_4_m_sm() {
        return obesity_4_m_sm;
    }

    public void setObesity_4_m_sm(int obesity_4_m_sm) {
        this.obesity_4_m_sm = obesity_4_m_sm;
    }

    public int getObesity_4_m_tm() {
        return obesity_4_m_tm;
    }

    public void setObesity_4_m_tm(int obesity_4_m_tm) {
        this.obesity_4_m_tm = obesity_4_m_tm;
    }

    public int getObesity_4_m() {
        return obesity_4_m;
    }

    public void setObesity_4_m(int obesity_4_m) {
        this.obesity_4_m = obesity_4_m;
    }

    public int getObesity_4_f_fm() {
        return obesity_4_f_fm;
    }

    public void setObesity_4_f_fm(int obesity_4_f_fm) {
        this.obesity_4_f_fm = obesity_4_f_fm;
    }

    public int getObesity_4_f_sm() {
        return obesity_4_f_sm;
    }

    public void setObesity_4_f_sm(int obesity_4_f_sm) {
        this.obesity_4_f_sm = obesity_4_f_sm;
    }

    public int getObesity_4_f_tm() {
        return obesity_4_f_tm;
    }

    public void setObesity_4_f_tm(int obesity_4_f_tm) {
        this.obesity_4_f_tm = obesity_4_f_tm;
    }

    public int getObesity_4_f() {
        return obesity_4_f;
    }

    public void setObesity_4_f(int obesity_4_f) {
        this.obesity_4_f = obesity_4_f;
    }

    public int getObesity_7_m_fm() {
        return obesity_7_m_fm;
    }

    public void setObesity_7_m_fm(int obesity_7_m_fm) {
        this.obesity_7_m_fm = obesity_7_m_fm;
    }

    public int getObesity_7_m_sm() {
        return obesity_7_m_sm;
    }

    public void setObesity_7_m_sm(int obesity_7_m_sm) {
        this.obesity_7_m_sm = obesity_7_m_sm;
    }

    public int getObesity_7_m_tm() {
        return obesity_7_m_tm;
    }

    public void setObesity_7_m_tm(int obesity_7_m_tm) {
        this.obesity_7_m_tm = obesity_7_m_tm;
    }

    public int getObesity_7_m() {
        return obesity_7_m;
    }

    public void setObesity_7_m(int obesity_7_m) {
        this.obesity_7_m = obesity_7_m;
    }

    public int getObesity_7_f_fm() {
        return obesity_7_f_fm;
    }

    public void setObesity_7_f_fm(int obesity_7_f_fm) {
        this.obesity_7_f_fm = obesity_7_f_fm;
    }

    public int getObesity_7_f_sm() {
        return obesity_7_f_sm;
    }

    public void setObesity_7_f_sm(int obesity_7_f_sm) {
        this.obesity_7_f_sm = obesity_7_f_sm;
    }

    public int getObesity_7_f_tm() {
        return obesity_7_f_tm;
    }

    public void setObesity_7_f_tm(int obesity_7_f_tm) {
        this.obesity_7_f_tm = obesity_7_f_tm;
    }

    public int getObesity_7_f() {
        return obesity_7_f;
    }

    public void setObesity_7_f(int obesity_7_f) {
        this.obesity_7_f = obesity_7_f;
    }

    public int getObesity_10_m_fm() {
        return obesity_10_m_fm;
    }

    public void setObesity_10_m_fm(int obesity_10_m_fm) {
        this.obesity_10_m_fm = obesity_10_m_fm;
    }

    public int getObesity_10_m_sm() {
        return obesity_10_m_sm;
    }

    public void setObesity_10_m_sm(int obesity_10_m_sm) {
        this.obesity_10_m_sm = obesity_10_m_sm;
    }

    public int getObesity_10_m_tm() {
        return obesity_10_m_tm;
    }

    public void setObesity_10_m_tm(int obesity_10_m_tm) {
        this.obesity_10_m_tm = obesity_10_m_tm;
    }

    public int getObesity_10_m() {
        return obesity_10_m;
    }

    public void setObesity_10_m(int obesity_10_m) {
        this.obesity_10_m = obesity_10_m;
    }

    public int getObesity_10_f_fm() {
        return obesity_10_f_fm;
    }

    public void setObesity_10_f_fm(int obesity_10_f_fm) {
        this.obesity_10_f_fm = obesity_10_f_fm;
    }

    public int getObesity_10_f_sm() {
        return obesity_10_f_sm;
    }

    public void setObesity_10_f_sm(int obesity_10_f_sm) {
        this.obesity_10_f_sm = obesity_10_f_sm;
    }

    public int getObesity_10_f_tm() {
        return obesity_10_f_tm;
    }

    public void setObesity_10_f_tm(int obesity_10_f_tm) {
        this.obesity_10_f_tm = obesity_10_f_tm;
    }

    public int getObesity_10_f() {
        return obesity_10_f;
    }

    public void setObesity_10_f(int obesity_10_f) {
        this.obesity_10_f = obesity_10_f;
    }

    public int getObesity_other_m_fm() {
        return obesity_other_m_fm;
    }

    public void setObesity_other_m_fm(int obesity_other_m_fm) {
        this.obesity_other_m_fm = obesity_other_m_fm;
    }

    public int getObesity_other_m_sm() {
        return obesity_other_m_sm;
    }

    public void setObesity_other_m_sm(int obesity_other_m_sm) {
        this.obesity_other_m_sm = obesity_other_m_sm;
    }

    public int getObesity_other_m_tm() {
        return obesity_other_m_tm;
    }

    public void setObesity_other_m_tm(int obesity_other_m_tm) {
        this.obesity_other_m_tm = obesity_other_m_tm;
    }

    public int getObesity_other_m() {
        return obesity_other_m;
    }

    public void setObesity_other_m(int obesity_other_m) {
        this.obesity_other_m = obesity_other_m;
    }

    public int getObesity_other_f_fm() {
        return obesity_other_f_fm;
    }

    public void setObesity_other_f_fm(int obesity_other_f_fm) {
        this.obesity_other_f_fm = obesity_other_f_fm;
    }

    public int getObesity_other_f_sm() {
        return obesity_other_f_sm;
    }

    public void setObesity_other_f_sm(int obesity_other_f_sm) {
        this.obesity_other_f_sm = obesity_other_f_sm;
    }

    public int getObesity_other_f_tm() {
        return obesity_other_f_tm;
    }

    public void setObesity_other_f_tm(int obesity_other_f_tm) {
        this.obesity_other_f_tm = obesity_other_f_tm;
    }

    public int getObesity_other_f() {
        return obesity_other_f;
    }

    public void setObesity_other_f(int obesity_other_f) {
        this.obesity_other_f = obesity_other_f;
    }

    public int getNutritional_referrals_other_m_fm() {
        return nutritional_referrals_other_m_fm;
    }

    public void setNutritional_referrals_other_m_fm(int nutritional_referrals_other_m_fm) {
        this.nutritional_referrals_other_m_fm = nutritional_referrals_other_m_fm;
    }

    public int getNutritional_referrals_other_m_sm() {
        return nutritional_referrals_other_m_sm;
    }

    public void setNutritional_referrals_other_m_sm(int nutritional_referrals_other_m_sm) {
        this.nutritional_referrals_other_m_sm = nutritional_referrals_other_m_sm;
    }

    public int getNutritional_referrals_other_m_tm() {
        return nutritional_referrals_other_m_tm;
    }

    public void setNutritional_referrals_other_m_tm(int nutritional_referrals_other_m_tm) {
        this.nutritional_referrals_other_m_tm = nutritional_referrals_other_m_tm;
    }

    public int getNutritional_referrals_other_m() {
        return nutritional_referrals_other_m;
    }

    public void setNutritional_referrals_other_m(int nutritional_referrals_other_m) {
        this.nutritional_referrals_other_m = nutritional_referrals_other_m;
    }

    public int getNutritional_referrals_other_f_fm() {
        return nutritional_referrals_other_f_fm;
    }

    public void setNutritional_referrals_other_f_fm(int nutritional_referrals_other_f_fm) {
        this.nutritional_referrals_other_f_fm = nutritional_referrals_other_f_fm;
    }

    public int getNutritional_referrals_other_f_sm() {
        return nutritional_referrals_other_f_sm;
    }

    public void setNutritional_referrals_other_f_sm(int nutritional_referrals_other_f_sm) {
        this.nutritional_referrals_other_f_sm = nutritional_referrals_other_f_sm;
    }

    public int getNutritional_referrals_other_f_tm() {
        return nutritional_referrals_other_f_tm;
    }

    public void setNutritional_referrals_other_f_tm(int nutritional_referrals_other_f_tm) {
        this.nutritional_referrals_other_f_tm = nutritional_referrals_other_f_tm;
    }

    public int getNutritional_referrals_other_f() {
        return nutritional_referrals_other_f;
    }

    public void setNutritional_referrals_other_f(int nutritional_referrals_other_f) {
        this.nutritional_referrals_other_f = nutritional_referrals_other_f;
    }

    public int getVisual_defects_fm() {
        return visual_defects_fm;
    }

    public void setVisual_defects_fm(int visual_defects_fm) {
        this.visual_defects_fm = visual_defects_fm;
    }

    public int getVisual_defects_sm() {
        return visual_defects_sm;
    }

    public void setVisual_defects_sm(int visual_defects_sm) {
        this.visual_defects_sm = visual_defects_sm;
    }

    public int getVisual_defects_tm() {
        return visual_defects_tm;
    }

    public void setVisual_defects_tm(int visual_defects_tm) {
        this.visual_defects_tm = visual_defects_tm;
    }

    public int getVisual_defects() {
        return visual_defects;
    }

    public void setVisual_defects(int visual_defects) {
        this.visual_defects = visual_defects;
    }

    public int getVisual_defects_corrected() {
        return visual_defects_corrected;
    }

    public void setVisual_defects_corrected(int visual_defects_corrected) {
        this.visual_defects_corrected = visual_defects_corrected;
    }

    public int getHearing_defects_fm() {
        return hearing_defects_fm;
    }

    public void setHearing_defects_fm(int hearing_defects_fm) {
        this.hearing_defects_fm = hearing_defects_fm;
    }

    public int getHearing_defects_sm() {
        return hearing_defects_sm;
    }

    public void setHearing_defects_sm(int hearing_defects_sm) {
        this.hearing_defects_sm = hearing_defects_sm;
    }

    public int getHearing_defects_tm() {
        return hearing_defects_tm;
    }

    public void setHearing_defects_tm(int hearing_defects_tm) {
        this.hearing_defects_tm = hearing_defects_tm;
    }

    public int getHearing_defects() {
        return hearing_defects;
    }

    public void setHearing_defects(int hearing_defects) {
        this.hearing_defects = hearing_defects;
    }

    public int getHearing_defects_corrected() {
        return hearing_defects_corrected;
    }

    public void setHearing_defects_corrected(int hearing_defects_corrected) {
        this.hearing_defects_corrected = hearing_defects_corrected;
    }

    public int getSpeech_defects_fm() {
        return speech_defects_fm;
    }

    public void setSpeech_defects_fm(int speech_defects_fm) {
        this.speech_defects_fm = speech_defects_fm;
    }

    public int getSpeech_defects_sm() {
        return speech_defects_sm;
    }

    public void setSpeech_defects_sm(int speech_defects_sm) {
        this.speech_defects_sm = speech_defects_sm;
    }

    public int getSpeech_defects_tm() {
        return speech_defects_tm;
    }

    public void setSpeech_defects_tm(int speech_defects_tm) {
        this.speech_defects_tm = speech_defects_tm;
    }

    public int getSpeech_defects() {
        return speech_defects;
    }

    public void setSpeech_defects(int speech_defects) {
        this.speech_defects = speech_defects;
    }

    public int getSpeech_defects_corrected() {
        return speech_defects_corrected;
    }

    public void setSpeech_defects_corrected(int speech_defects_corrected) {
        this.speech_defects_corrected = speech_defects_corrected;
    }

    public int getPediculosis_fm() {
        return pediculosis_fm;
    }

    public void setPediculosis_fm(int pediculosis_fm) {
        this.pediculosis_fm = pediculosis_fm;
    }

    public int getPediculosis_sm() {
        return pediculosis_sm;
    }

    public void setPediculosis_sm(int pediculosis_sm) {
        this.pediculosis_sm = pediculosis_sm;
    }

    public int getPediculosis_tm() {
        return pediculosis_tm;
    }

    public void setPediculosis_tm(int pediculosis_tm) {
        this.pediculosis_tm = pediculosis_tm;
    }

    public int getPediculosis() {
        return pediculosis;
    }

    public void setPediculosis(int pediculosis) {
        this.pediculosis = pediculosis;
    }

    public int getPediculosis_corrected() {
        return pediculosis_corrected;
    }

    public void setPediculosis_corrected(int pediculosis_corrected) {
        this.pediculosis_corrected = pediculosis_corrected;
    }

    public int getNight_blindness_fm() {
        return night_blindness_fm;
    }

    public void setNight_blindness_fm(int night_blindness_fm) {
        this.night_blindness_fm = night_blindness_fm;
    }

    public int getNight_blindness_sm() {
        return night_blindness_sm;
    }

    public void setNight_blindness_sm(int night_blindness_sm) {
        this.night_blindness_sm = night_blindness_sm;
    }

    public int getNight_blindness_tm() {
        return night_blindness_tm;
    }

    public void setNight_blindness_tm(int night_blindness_tm) {
        this.night_blindness_tm = night_blindness_tm;
    }

    public int getNight_blindness() {
        return night_blindness;
    }

    public void setNight_blindness(int night_blindness) {
        this.night_blindness = night_blindness;
    }

    public int getNight_blindness_corrected() {
        return night_blindness_corrected;
    }

    public void setNight_blindness_corrected(int night_blindness_corrected) {
        this.night_blindness_corrected = night_blindness_corrected;
    }

    public int getBitot_spots_fm() {
        return bitot_spots_fm;
    }

    public void setBitot_spots_fm(int bitot_spots_fm) {
        this.bitot_spots_fm = bitot_spots_fm;
    }

    public int getBitot_spots_sm() {
        return bitot_spots_sm;
    }

    public void setBitot_spots_sm(int bitot_spots_sm) {
        this.bitot_spots_sm = bitot_spots_sm;
    }

    public int getBitot_spots_tm() {
        return bitot_spots_tm;
    }

    public void setBitot_spots_tm(int bitot_spots_tm) {
        this.bitot_spots_tm = bitot_spots_tm;
    }

    public int getBitot_spots() {
        return bitot_spots;
    }

    public void setBitot_spots(int bitot_spots) {
        this.bitot_spots = bitot_spots;
    }

    public int getBitot_spots_corrected() {
        return bitot_spots_corrected;
    }

    public void setBitot_spots_corrected(int bitot_spots_corrected) {
        this.bitot_spots_corrected = bitot_spots_corrected;
    }

    public int getSquint_fm() {
        return squint_fm;
    }

    public void setSquint_fm(int squint_fm) {
        this.squint_fm = squint_fm;
    }

    public int getSquint_sm() {
        return squint_sm;
    }

    public void setSquint_sm(int squint_sm) {
        this.squint_sm = squint_sm;
    }

    public int getSquint_tm() {
        return squint_tm;
    }

    public void setSquint_tm(int squint_tm) {
        this.squint_tm = squint_tm;
    }

    public int getSquint() {
        return squint;
    }

    public void setSquint(int squint) {
        this.squint = squint;
    }

    public int getSquint_corrected() {
        return squint_corrected;
    }

    public void setSquint_corrected(int squint_corrected) {
        this.squint_corrected = squint_corrected;
    }

    public int getPallor_fm() {
        return pallor_fm;
    }

    public void setPallor_fm(int pallor_fm) {
        this.pallor_fm = pallor_fm;
    }

    public int getPallor_sm() {
        return pallor_sm;
    }

    public void setPallor_sm(int pallor_sm) {
        this.pallor_sm = pallor_sm;
    }

    public int getPallor_tm() {
        return pallor_tm;
    }

    public void setPallor_tm(int pallor_tm) {
        this.pallor_tm = pallor_tm;
    }

    public int getPallor() {
        return pallor;
    }

    public void setPallor(int pallor) {
        this.pallor = pallor;
    }

    public int getPallor_corrected() {
        return pallor_corrected;
    }

    public void setPallor_corrected(int pallor_corrected) {
        this.pallor_corrected = pallor_corrected;
    }

    public int getXeropthalmia_fm() {
        return xeropthalmia_fm;
    }

    public void setXeropthalmia_fm(int xeropthalmia_fm) {
        this.xeropthalmia_fm = xeropthalmia_fm;
    }

    public int getXeropthalmia_sm() {
        return xeropthalmia_sm;
    }

    public void setXeropthalmia_sm(int xeropthalmia_sm) {
        this.xeropthalmia_sm = xeropthalmia_sm;
    }

    public int getXeropthalmia_tm() {
        return xeropthalmia_tm;
    }

    public void setXeropthalmia_tm(int xeropthalmia_tm) {
        this.xeropthalmia_tm = xeropthalmia_tm;
    }

    public int getXeropthalmia() {
        return xeropthalmia;
    }

    public void setXeropthalmia(int xeropthalmia) {
        this.xeropthalmia = xeropthalmia;
    }

    public int getXeropthalmia_corrected() {
        return xeropthalmia_corrected;
    }

    public void setXeropthalmia_corrected(int xeropthalmia_corrected) {
        this.xeropthalmia_corrected = xeropthalmia_corrected;
    }

    public int getAngular_stomatitis_or_glossitis_fm() {
        return angular_stomatitis_or_glossitis_fm;
    }

    public void setAngular_stomatitis_or_glossitis_fm(int angular_stomatitis_or_glossitis_fm) {
        this.angular_stomatitis_or_glossitis_fm = angular_stomatitis_or_glossitis_fm;
    }

    public int getAngular_stomatitis_or_glossitis_sm() {
        return angular_stomatitis_or_glossitis_sm;
    }

    public void setAngular_stomatitis_or_glossitis_sm(int angular_stomatitis_or_glossitis_sm) {
        this.angular_stomatitis_or_glossitis_sm = angular_stomatitis_or_glossitis_sm;
    }

    public int getAngular_stomatitis_or_glossitis_tm() {
        return angular_stomatitis_or_glossitis_tm;
    }

    public void setAngular_stomatitis_or_glossitis_tm(int angular_stomatitis_or_glossitis_tm) {
        this.angular_stomatitis_or_glossitis_tm = angular_stomatitis_or_glossitis_tm;
    }

    public int getAngular_stomatitis_or_glossitis() {
        return angular_stomatitis_or_glossitis;
    }

    public void setAngular_stomatitis_or_glossitis(int angular_stomatitis_or_glossitis) {
        this.angular_stomatitis_or_glossitis = angular_stomatitis_or_glossitis;
    }

    public int getAngular_stomatitis_or_glossitis_corrected() {
        return angular_stomatitis_or_glossitis_corrected;
    }

    public void setAngular_stomatitis_or_glossitis_corrected(int angular_stomatitis_or_glossitis_corrected) {
        this.angular_stomatitis_or_glossitis_corrected = angular_stomatitis_or_glossitis_corrected;
    }

    public int getDental_caries_fm() {
        return dental_caries_fm;
    }

    public void setDental_caries_fm(int dental_caries_fm) {
        this.dental_caries_fm = dental_caries_fm;
    }

    public int getDental_caries_sm() {
        return dental_caries_sm;
    }

    public void setDental_caries_sm(int dental_caries_sm) {
        this.dental_caries_sm = dental_caries_sm;
    }

    public int getDental_caries_tm() {
        return dental_caries_tm;
    }

    public void setDental_caries_tm(int dental_caries_tm) {
        this.dental_caries_tm = dental_caries_tm;
    }

    public int getDental_caries() {
        return dental_caries;
    }

    public void setDental_caries(int dental_caries) {
        this.dental_caries = dental_caries;
    }

    public int getDental_caries_corrected() {
        return dental_caries_corrected;
    }

    public void setDental_caries_corrected(int dental_caries_corrected) {
        this.dental_caries_corrected = dental_caries_corrected;
    }

    public int getCalculus_fm() {
        return calculus_fm;
    }

    public void setCalculus_fm(int calculus_fm) {
        this.calculus_fm = calculus_fm;
    }

    public int getCalculus_sm() {
        return calculus_sm;
    }

    public void setCalculus_sm(int calculus_sm) {
        this.calculus_sm = calculus_sm;
    }

    public int getCalculus_tm() {
        return calculus_tm;
    }

    public void setCalculus_tm(int calculus_tm) {
        this.calculus_tm = calculus_tm;
    }

    public int getCalculus() {
        return calculus;
    }

    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    public int getCalculus_corrected() {
        return calculus_corrected;
    }

    public void setCalculus_corrected(int calculus_corrected) {
        this.calculus_corrected = calculus_corrected;
    }

    public int getFluorosis_fm() {
        return fluorosis_fm;
    }

    public void setFluorosis_fm(int fluorosis_fm) {
        this.fluorosis_fm = fluorosis_fm;
    }

    public int getFluorosis_sm() {
        return fluorosis_sm;
    }

    public void setFluorosis_sm(int fluorosis_sm) {
        this.fluorosis_sm = fluorosis_sm;
    }

    public int getFluorosis_tm() {
        return fluorosis_tm;
    }

    public void setFluorosis_tm(int fluorosis_tm) {
        this.fluorosis_tm = fluorosis_tm;
    }

    public int getFluorosis() {
        return fluorosis;
    }

    public void setFluorosis(int fluorosis) {
        this.fluorosis = fluorosis;
    }

    public int getFluorosis_corrected() {
        return fluorosis_corrected;
    }

    public void setFluorosis_corrected(int fluorosis_corrected) {
        this.fluorosis_corrected = fluorosis_corrected;
    }

    public int getMalocclusion_fm() {
        return malocclusion_fm;
    }

    public void setMalocclusion_fm(int malocclusion_fm) {
        this.malocclusion_fm = malocclusion_fm;
    }

    public int getMalocclusion_sm() {
        return malocclusion_sm;
    }

    public void setMalocclusion_sm(int malocclusion_sm) {
        this.malocclusion_sm = malocclusion_sm;
    }

    public int getMalocclusion_tm() {
        return malocclusion_tm;
    }

    public void setMalocclusion_tm(int malocclusion_tm) {
        this.malocclusion_tm = malocclusion_tm;
    }

    public int getMalocclusion() {
        return malocclusion;
    }

    public void setMalocclusion(int malocclusion) {
        this.malocclusion = malocclusion;
    }

    public int getMalocclusion_corrected() {
        return malocclusion_corrected;
    }

    public void setMalocclusion_corrected(int malocclusion_corrected) {
        this.malocclusion_corrected = malocclusion_corrected;
    }

    public int getGoitre_fm() {
        return goitre_fm;
    }

    public void setGoitre_fm(int goitre_fm) {
        this.goitre_fm = goitre_fm;
    }

    public int getGoitre_sm() {
        return goitre_sm;
    }

    public void setGoitre_sm(int goitre_sm) {
        this.goitre_sm = goitre_sm;
    }

    public int getGoitre_tm() {
        return goitre_tm;
    }

    public void setGoitre_tm(int goitre_tm) {
        this.goitre_tm = goitre_tm;
    }

    public int getGoitre() {
        return goitre;
    }

    public void setGoitre(int goitre) {
        this.goitre = goitre;
    }

    public int getGoitre_corrected() {
        return goitre_corrected;
    }

    public void setGoitre_corrected(int goitre_corrected) {
        this.goitre_corrected = goitre_corrected;
    }

    public int getEnt_defects_fm() {
        return ent_defects_fm;
    }

    public void setEnt_defects_fm(int ent_defects_fm) {
        this.ent_defects_fm = ent_defects_fm;
    }

    public int getEnt_defects_sm() {
        return ent_defects_sm;
    }

    public void setEnt_defects_sm(int ent_defects_sm) {
        this.ent_defects_sm = ent_defects_sm;
    }

    public int getEnt_defects_tm() {
        return ent_defects_tm;
    }

    public void setEnt_defects_tm(int ent_defects_tm) {
        this.ent_defects_tm = ent_defects_tm;
    }

    public int getEnt_defects() {
        return ent_defects;
    }

    public void setEnt_defects(int ent_defects) {
        this.ent_defects = ent_defects;
    }

    public int getEnt_defects_corrected() {
        return ent_defects_corrected;
    }

    public void setEnt_defects_corrected(int ent_defects_corrected) {
        this.ent_defects_corrected = ent_defects_corrected;
    }

    public int getLymphadenopathy_fm() {
        return lymphadenopathy_fm;
    }

    public void setLymphadenopathy_fm(int lymphadenopathy_fm) {
        this.lymphadenopathy_fm = lymphadenopathy_fm;
    }

    public int getLymphadenopathy_sm() {
        return lymphadenopathy_sm;
    }

    public void setLymphadenopathy_sm(int lymphadenopathy_sm) {
        this.lymphadenopathy_sm = lymphadenopathy_sm;
    }

    public int getLymphadenopathy_tm() {
        return lymphadenopathy_tm;
    }

    public void setLymphadenopathy_tm(int lymphadenopathy_tm) {
        this.lymphadenopathy_tm = lymphadenopathy_tm;
    }

    public int getLymphadenopathy() {
        return lymphadenopathy;
    }

    public void setLymphadenopathy(int lymphadenopathy) {
        this.lymphadenopathy = lymphadenopathy;
    }

    public int getLymphadenopathy_corrected() {
        return lymphadenopathy_corrected;
    }

    public void setLymphadenopathy_corrected(int lymphadenopathy_corrected) {
        this.lymphadenopathy_corrected = lymphadenopathy_corrected;
    }

    public int getScabies_fm() {
        return scabies_fm;
    }

    public void setScabies_fm(int scabies_fm) {
        this.scabies_fm = scabies_fm;
    }

    public int getScabies_sm() {
        return scabies_sm;
    }

    public void setScabies_sm(int scabies_sm) {
        this.scabies_sm = scabies_sm;
    }

    public int getScabies_tm() {
        return scabies_tm;
    }

    public void setScabies_tm(int scabies_tm) {
        this.scabies_tm = scabies_tm;
    }

    public int getScabies() {
        return scabies;
    }

    public void setScabies(int scabies) {
        this.scabies = scabies;
    }

    public int getScabies_corrected() {
        return scabies_corrected;
    }

    public void setScabies_corrected(int scabies_corrected) {
        this.scabies_corrected = scabies_corrected;
    }

    public int getHypopigmented_skin_patches_fm() {
        return hypopigmented_skin_patches_fm;
    }

    public void setHypopigmented_skin_patches_fm(int hypopigmented_skin_patches_fm) {
        this.hypopigmented_skin_patches_fm = hypopigmented_skin_patches_fm;
    }

    public int getHypopigmented_skin_patches_sm() {
        return hypopigmented_skin_patches_sm;
    }

    public void setHypopigmented_skin_patches_sm(int hypopigmented_skin_patches_sm) {
        this.hypopigmented_skin_patches_sm = hypopigmented_skin_patches_sm;
    }

    public int getHypopigmented_skin_patches_tm() {
        return hypopigmented_skin_patches_tm;
    }

    public void setHypopigmented_skin_patches_tm(int hypopigmented_skin_patches_tm) {
        this.hypopigmented_skin_patches_tm = hypopigmented_skin_patches_tm;
    }

    public int getHypopigmented_skin_patches() {
        return hypopigmented_skin_patches;
    }

    public void setHypopigmented_skin_patches(int hypopigmented_skin_patches) {
        this.hypopigmented_skin_patches = hypopigmented_skin_patches;
    }

    public int getHypopigmented_skin_patches_corrected() {
        return hypopigmented_skin_patches_corrected;
    }

    public void setHypopigmented_skin_patches_corrected(int hypopigmented_skin_patches_corrected) {
        this.hypopigmented_skin_patches_corrected = hypopigmented_skin_patches_corrected;
    }

    public int getOther_skin_disorders_fm() {
        return other_skin_disorders_fm;
    }

    public void setOther_skin_disorders_fm(int other_skin_disorders_fm) {
        this.other_skin_disorders_fm = other_skin_disorders_fm;
    }

    public int getOther_skin_disorders_sm() {
        return other_skin_disorders_sm;
    }

    public void setOther_skin_disorders_sm(int other_skin_disorders_sm) {
        this.other_skin_disorders_sm = other_skin_disorders_sm;
    }

    public int getOther_skin_disorders_tm() {
        return other_skin_disorders_tm;
    }

    public void setOther_skin_disorders_tm(int other_skin_disorders_tm) {
        this.other_skin_disorders_tm = other_skin_disorders_tm;
    }

    public int getOther_skin_disorders() {
        return other_skin_disorders;
    }

    public void setOther_skin_disorders(int other_skin_disorders) {
        this.other_skin_disorders = other_skin_disorders;
    }

    public int getOther_skin_disorders_corrected() {
        return other_skin_disorders_corrected;
    }

    public void setOther_skin_disorders_corrected(int other_skin_disorders_corrected) {
        this.other_skin_disorders_corrected = other_skin_disorders_corrected;
    }

    public int getOrthopaedic_disorders_fm() {
        return orthopaedic_disorders_fm;
    }

    public void setOrthopaedic_disorders_fm(int orthopaedic_disorders_fm) {
        this.orthopaedic_disorders_fm = orthopaedic_disorders_fm;
    }

    public int getOrthopaedic_disorders_sm() {
        return orthopaedic_disorders_sm;
    }

    public void setOrthopaedic_disorders_sm(int orthopaedic_disorders_sm) {
        this.orthopaedic_disorders_sm = orthopaedic_disorders_sm;
    }

    public int getOrthopaedic_disorders_tm() {
        return orthopaedic_disorders_tm;
    }

    public void setOrthopaedic_disorders_tm(int orthopaedic_disorders_tm) {
        this.orthopaedic_disorders_tm = orthopaedic_disorders_tm;
    }

    public int getOrthopaedic_disorders() {
        return orthopaedic_disorders;
    }

    public void setOrthopaedic_disorders(int orthopaedic_disorders) {
        this.orthopaedic_disorders = orthopaedic_disorders;
    }

    public int getOrthopaedic_disorders_corrected() {
        return orthopaedic_disorders_corrected;
    }

    public void setOrthopaedic_disorders_corrected(int orthopaedic_disorders_corrected) {
        this.orthopaedic_disorders_corrected = orthopaedic_disorders_corrected;
    }

    public int getRheumatic_disorders_fm() {
        return rheumatic_disorders_fm;
    }

    public void setRheumatic_disorders_fm(int rheumatic_disorders_fm) {
        this.rheumatic_disorders_fm = rheumatic_disorders_fm;
    }

    public int getRheumatic_disorders_sm() {
        return rheumatic_disorders_sm;
    }

    public void setRheumatic_disorders_sm(int rheumatic_disorders_sm) {
        this.rheumatic_disorders_sm = rheumatic_disorders_sm;
    }

    public int getRheumatic_disorders_tm() {
        return rheumatic_disorders_tm;
    }

    public void setRheumatic_disorders_tm(int rheumatic_disorders_tm) {
        this.rheumatic_disorders_tm = rheumatic_disorders_tm;
    }

    public int getRheumatic_disorders() {
        return rheumatic_disorders;
    }

    public void setRheumatic_disorders(int rheumatic_disorders) {
        this.rheumatic_disorders = rheumatic_disorders;
    }

    public int getRheumatic_disorders_corrected() {
        return rheumatic_disorders_corrected;
    }

    public void setRheumatic_disorders_corrected(int rheumatic_disorders_corrected) {
        this.rheumatic_disorders_corrected = rheumatic_disorders_corrected;
    }

    public int getHeart_diseases_fm() {
        return heart_diseases_fm;
    }

    public void setHeart_diseases_fm(int heart_diseases_fm) {
        this.heart_diseases_fm = heart_diseases_fm;
    }

    public int getHeart_diseases_sm() {
        return heart_diseases_sm;
    }

    public void setHeart_diseases_sm(int heart_diseases_sm) {
        this.heart_diseases_sm = heart_diseases_sm;
    }

    public int getHeart_diseases_tm() {
        return heart_diseases_tm;
    }

    public void setHeart_diseases_tm(int heart_diseases_tm) {
        this.heart_diseases_tm = heart_diseases_tm;
    }

    public int getHeart_diseases() {
        return heart_diseases;
    }

    public void setHeart_diseases(int heart_diseases) {
        this.heart_diseases = heart_diseases;
    }

    public int getHeart_diseases_corrected() {
        return heart_diseases_corrected;
    }

    public void setHeart_diseases_corrected(int heart_diseases_corrected) {
        this.heart_diseases_corrected = heart_diseases_corrected;
    }

    public int getLung_diseases_fm() {
        return lung_diseases_fm;
    }

    public void setLung_diseases_fm(int lung_diseases_fm) {
        this.lung_diseases_fm = lung_diseases_fm;
    }

    public int getLung_diseases_sm() {
        return lung_diseases_sm;
    }

    public void setLung_diseases_sm(int lung_diseases_sm) {
        this.lung_diseases_sm = lung_diseases_sm;
    }

    public int getLung_diseases_tm() {
        return lung_diseases_tm;
    }

    public void setLung_diseases_tm(int lung_diseases_tm) {
        this.lung_diseases_tm = lung_diseases_tm;
    }

    public int getLung_diseases() {
        return lung_diseases;
    }

    public void setLung_diseases(int lung_diseases) {
        this.lung_diseases = lung_diseases;
    }

    public int getLung_diseases_corrected() {
        return lung_diseases_corrected;
    }

    public void setLung_diseases_corrected(int lung_diseases_corrected) {
        this.lung_diseases_corrected = lung_diseases_corrected;
    }

    public int getBronchial_asthma_fm() {
        return bronchial_asthma_fm;
    }

    public void setBronchial_asthma_fm(int bronchial_asthma_fm) {
        this.bronchial_asthma_fm = bronchial_asthma_fm;
    }

    public int getBronchial_asthma_sm() {
        return bronchial_asthma_sm;
    }

    public void setBronchial_asthma_sm(int bronchial_asthma_sm) {
        this.bronchial_asthma_sm = bronchial_asthma_sm;
    }

    public int getBronchial_asthma_tm() {
        return bronchial_asthma_tm;
    }

    public void setBronchial_asthma_tm(int bronchial_asthma_tm) {
        this.bronchial_asthma_tm = bronchial_asthma_tm;
    }

    public int getBronchial_asthma() {
        return bronchial_asthma;
    }

    public void setBronchial_asthma(int bronchial_asthma) {
        this.bronchial_asthma = bronchial_asthma;
    }

    public int getBronchial_asthma_corrected() {
        return bronchial_asthma_corrected;
    }

    public void setBronchial_asthma_corrected(int bronchial_asthma_corrected) {
        this.bronchial_asthma_corrected = bronchial_asthma_corrected;
    }

    public int getBehavioural_problems_fm() {
        return behavioural_problems_fm;
    }

    public void setBehavioural_problems_fm(int behavioural_problems_fm) {
        this.behavioural_problems_fm = behavioural_problems_fm;
    }

    public int getBehavioural_problems_sm() {
        return behavioural_problems_sm;
    }

    public void setBehavioural_problems_sm(int behavioural_problems_sm) {
        this.behavioural_problems_sm = behavioural_problems_sm;
    }

    public int getBehavioural_problems_tm() {
        return behavioural_problems_tm;
    }

    public void setBehavioural_problems_tm(int behavioural_problems_tm) {
        this.behavioural_problems_tm = behavioural_problems_tm;
    }

    public int getBehavioural_problems() {
        return behavioural_problems;
    }

    public void setBehavioural_problems(int behavioural_problems) {
        this.behavioural_problems = behavioural_problems;
    }

    public int getBehavioural_problems_corrected() {
        return behavioural_problems_corrected;
    }

    public void setBehavioural_problems_corrected(int behavioural_problems_corrected) {
        this.behavioural_problems_corrected = behavioural_problems_corrected;
    }

    public int getLearning_difficulties_fm() {
        return learning_difficulties_fm;
    }

    public void setLearning_difficulties_fm(int learning_difficulties_fm) {
        this.learning_difficulties_fm = learning_difficulties_fm;
    }

    public int getLearning_difficulties_sm() {
        return learning_difficulties_sm;
    }

    public void setLearning_difficulties_sm(int learning_difficulties_sm) {
        this.learning_difficulties_sm = learning_difficulties_sm;
    }

    public int getLearning_difficulties_tm() {
        return learning_difficulties_tm;
    }

    public void setLearning_difficulties_tm(int learning_difficulties_tm) {
        this.learning_difficulties_tm = learning_difficulties_tm;
    }

    public int getLearning_difficulties() {
        return learning_difficulties;
    }

    public void setLearning_difficulties(int learning_difficulties) {
        this.learning_difficulties = learning_difficulties;
    }

    public int getLearning_difficulties_corrected() {
        return learning_difficulties_corrected;
    }

    public void setLearning_difficulties_corrected(int learning_difficulties_corrected) {
        this.learning_difficulties_corrected = learning_difficulties_corrected;
    }

    public int getOther_defects_fm() {
        return other_defects_fm;
    }

    public void setOther_defects_fm(int other_defects_fm) {
        this.other_defects_fm = other_defects_fm;
    }

    public int getOther_defects_sm() {
        return other_defects_sm;
    }

    public void setOther_defects_sm(int other_defects_sm) {
        this.other_defects_sm = other_defects_sm;
    }

    public int getOther_defects_tm() {
        return other_defects_tm;
    }

    public void setOther_defects_tm(int other_defects_tm) {
        this.other_defects_tm = other_defects_tm;
    }

    public int getOther_defects() {
        return other_defects;
    }

    public void setOther_defects(int other_defects) {
        this.other_defects = other_defects;
    }

    public int getOther_defects_corrected() {
        return other_defects_corrected;
    }

    public void setOther_defects_corrected(int other_defects_corrected) {
        this.other_defects_corrected = other_defects_corrected;
    }

    public int getTotal_defects_fm() {
        return total_defects_fm;
    }

    public void setTotal_defects_fm(int total_defects_fm) {
        this.total_defects_fm = total_defects_fm;
    }

    public int getTotal_defects_sm() {
        return total_defects_sm;
    }

    public void setTotal_defects_sm(int total_defects_sm) {
        this.total_defects_sm = total_defects_sm;
    }

    public int getTotal_defects_tm() {
        return total_defects_tm;
    }

    public void setTotal_defects_tm(int total_defects_tm) {
        this.total_defects_tm = total_defects_tm;
    }

    public int getTotal_defects() {
        return total_defects;
    }

    public void setTotal_defects(int total_defects) {
        this.total_defects = total_defects;
    }

    public int getTotal_defects_corrected() {
        return total_defects_corrected;
    }

    public void setTotal_defects_corrected(int total_defects_corrected) {
        this.total_defects_corrected = total_defects_corrected;
    }

    public int getReferred_fm() {
        return referred_fm;
    }

    public void setReferred_fm(int referred_fm) {
        this.referred_fm = referred_fm;
    }

    public int getReferred_sm() {
        return referred_sm;
    }

    public void setReferred_sm(int referred_sm) {
        this.referred_sm = referred_sm;
    }

    public int getReferred_tm() {
        return referred_tm;
    }

    public void setReferred_tm(int referred_tm) {
        this.referred_tm = referred_tm;
    }

    public int getReferred() {
        return referred;
    }

    public void setReferred(int referred) {
        this.referred = referred;
    }

    public int getReferred_corrected() {
        return referred_corrected;
    }

    public void setReferred_corrected(int referred_corrected) {
        this.referred_corrected = referred_corrected;
    }

    public WebUser getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(WebUser preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public WebUser getCertifiedBy() {
        return certifiedBy;
    }

    public void setCertifiedBy(WebUser certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

    public Date getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(Date certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public Quarter getReport_quarter_enum() {
        return report_quarter_enum;
    }

    public void setReport_quarter_enum(Quarter report_quarter_enum) {
        this.report_quarter_enum = report_quarter_enum;
    }

    
    
}
