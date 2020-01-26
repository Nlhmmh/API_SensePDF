package com.nlh.formpdf.response;

import java.io.Serializable;

/**
 * @author nlh
 *
 */
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String dateToSubmit = "";
	private String taxOffice = "";
	private String prefecturalTaxOffice = "";
	private String selectForPrefecturalTaxOffice = "";
	private String municipalities = "";
	private String selectForMunicipalities = "";
	private String corporateNameFurigana = "";
	private String corporateName = "";
	private String headOfficeAddress1 = "";
	private String headOfficeAddress2 = "";
	private String companyPhoneNo = "";
	private String jurisdictionsAddress1 = "";
	private String jurisdictionsAddress2 = "";
	private String contactAddress1 = "";
    private String contactAddress2 = "";
    private String representativeFurigana = "";
    private String representativeName = "";
    private String representativeAddress1 = "";
    private String representativeAddress2 = "";
    private String capital = "";
    private String investment = "";
    private String companyFoundedDate = "";
    private String fiscalKara = "";
    private String fiscalMade = "";
    private String endOfFiscalYear = "";
    private String purposeOfBusiness = "";
    private String businessEvent = "";
    private String businessStartExpectedDate = "";
    private String officer = "";
    private String officerSalary = "";
    private String officeWorker = "";
    private String officeWorkerSalary = "";
    private String salesFactoryWorkers = "";
    private String salesFactoryWorkersSalary = "";
    private String others = "";
    private String othersSalary = "";
    private String taxFurigana = "";
    private String taxName = "";
    private String taxAddress = "";
    private String taxPhone = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateToSubmit() {
		return dateToSubmit;
	}
	public void setDateToSubmit(String dateToSubmit) {
		this.dateToSubmit = dateToSubmit;
	}
	public String getTaxOffice() {
		return taxOffice;
	}
	public void setTaxOffice(String taxOffice) {
		this.taxOffice = taxOffice;
	}
	
	public String getPrefecturalTaxOffice() {
		return prefecturalTaxOffice;
	}
	public void setPrefecturalTaxOffice(String prefecturalTaxOffice) {
		this.prefecturalTaxOffice = prefecturalTaxOffice;
	}
	public String getSelectForPrefecturalTaxOffice() {
		return selectForPrefecturalTaxOffice;
	}
	public void setSelectForPrefecturalTaxOffice(String selectForPrefecturalTaxOffice) {
		this.selectForPrefecturalTaxOffice = selectForPrefecturalTaxOffice;
	}
	public String getMunicipalities() {
		return municipalities;
	}
	public void setMunicipalities(String municipalities) {
		this.municipalities = municipalities;
	}
	public String getSelectForMunicipalities() {
		return selectForMunicipalities;
	}
	public void setSelectForMunicipalities(String selectForMunicipalities) {
		this.selectForMunicipalities = selectForMunicipalities;
	}
	public String getCorporateNameFurigana() {
		return corporateNameFurigana;
	}
	public void setCorporateNameFurigana(String corporateNameFurigana) {
		this.corporateNameFurigana = corporateNameFurigana;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getHeadOfficeAddress1() {
		return headOfficeAddress1;
	}
	public void setHeadOfficeAddress1(String headOfficeAddress1) {
		this.headOfficeAddress1 = headOfficeAddress1;
	}
	public String getHeadOfficeAddress2() {
		return headOfficeAddress2;
	}
	public void setHeadOfficeAddress2(String headOfficeAddress2) {
		this.headOfficeAddress2 = headOfficeAddress2;
	}
	public String getCompanyPhoneNo() {
		return companyPhoneNo;
	}
	public void setCompanyPhoneNo(String companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}
	public String getJurisdictionsAddress1() {
		return jurisdictionsAddress1;
	}
	public void setJurisdictionsAddress1(String jurisdictionsAddress1) {
		this.jurisdictionsAddress1 = jurisdictionsAddress1;
	}
	public String getJurisdictionsAddress2() {
		return jurisdictionsAddress2;
	}
	public void setJurisdictionsAddress2(String jurisdictionsAddress2) {
		this.jurisdictionsAddress2 = jurisdictionsAddress2;
	}
	public String getContactAddress1() {
		return contactAddress1;
	}
	public void setContactAddress1(String contactAddress1) {
		this.contactAddress1 = contactAddress1;
	}
	public String getContactAddress2() {
		return contactAddress2;
	}
	public void setContactAddress2(String contactAddress2) {
		this.contactAddress2 = contactAddress2;
	}
	public String getRepresentativeFurigana() {
		return representativeFurigana;
	}
	public void setRepresentativeFurigana(String representativeFurigana) {
		this.representativeFurigana = representativeFurigana;
	}
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	public String getRepresentativeAddress1() {
		return representativeAddress1;
	}
	public void setRepresentativeAddress1(String representativeAddress1) {
		this.representativeAddress1 = representativeAddress1;
	}
	public String getRepresentativeAddress2() {
		return representativeAddress2;
	}
	public void setRepresentativeAddress2(String representativeAddress2) {
		this.representativeAddress2 = representativeAddress2;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getCompanyFoundedDate() {
		return companyFoundedDate;
	}
	public void setCompanyFoundedDate(String companyFoundedDate) {
		this.companyFoundedDate = companyFoundedDate;
	}
	public String getFiscalKara() {
		return fiscalKara;
	}
	public void setFiscalKara(String fiscalKara) {
		this.fiscalKara = fiscalKara;
	}
	public String getFiscalMade() {
		return fiscalMade;
	}
	public void setFiscalMade(String fiscalMade) {
		this.fiscalMade = fiscalMade;
	}
	public String getEndOfFiscalYear() {
		return endOfFiscalYear;
	}
	public void setEndOfFiscalYear(String endOfFiscalYear) {
		this.endOfFiscalYear = endOfFiscalYear;
	}
	public String getPurposeOfBusiness() {
		return purposeOfBusiness;
	}
	public void setPurposeOfBusiness(String purposeOfBusiness) {
		this.purposeOfBusiness = purposeOfBusiness;
	}
	public String getBusinessEvent() {
		return businessEvent;
	}
	public void setBusinessEvent(String businessEvent) {
		this.businessEvent = businessEvent;
	}
	public String getBusinessStartExpectedDate() {
		return businessStartExpectedDate;
	}
	public void setBusinessStartExpectedDate(String businessStartExpectedDate) {
		this.businessStartExpectedDate = businessStartExpectedDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public String getOfficerSalary() {
		return officerSalary;
	}
	public void setOfficerSalary(String officerSalary) {
		this.officerSalary = officerSalary;
	}
	public String getOfficeWorker() {
		return officeWorker;
	}
	public void setOfficeWorker(String officeWorker) {
		this.officeWorker = officeWorker;
	}
	public String getOfficeWorkerSalary() {
		return officeWorkerSalary;
	}
	public void setOfficeWorkerSalary(String officeWorkerSalary) {
		this.officeWorkerSalary = officeWorkerSalary;
	}
	public String getSalesFactoryWorkers() {
		return salesFactoryWorkers;
	}
	public void setSalesFactoryWorkers(String salesFactoryWorkers) {
		this.salesFactoryWorkers = salesFactoryWorkers;
	}
	public String getSalesFactoryWorkersSalary() {
		return salesFactoryWorkersSalary;
	}
	public void setSalesFactoryWorkersSalary(String salesFactoryWorkersSalary) {
		this.salesFactoryWorkersSalary = salesFactoryWorkersSalary;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getOthersSalary() {
		return othersSalary;
	}
	public void setOthersSalary(String othersSalary) {
		this.othersSalary = othersSalary;
	}
	public String getTaxFurigana() {
		return taxFurigana;
	}
	public void setTaxFurigana(String taxFurigana) {
		this.taxFurigana = taxFurigana;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getTaxAddress() {
		return taxAddress;
	}
	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}
	public String getTaxPhone() {
		return taxPhone;
	}
	public void setTaxPhone(String taxPhone) {
		this.taxPhone = taxPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}