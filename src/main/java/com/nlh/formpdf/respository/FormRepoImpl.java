package com.nlh.formpdf.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nlh.formpdf.response.FormBean;

/**
 * @author nlh
 *
 */
@Transactional
@Repository
public class FormRepoImpl implements FormRepoIF {

	@Autowired
	private JdbcTemplate jdbcTemp;
	
	@Override
	public boolean submitForm(FormBean formBean) {
		String sql = "INSERT INTO form("
				+ "date_to_submit, "
				+ "tax_office,"
				+ "prefecturalTaxOffice,"
				+ "selectForPrefecturalTaxOffice,"
				+ "municipalities,"
				+ "selectForMunicipalities,"
				+ "corporateNameFurigana,"
				+ "corporateName,"
				+ "headOfficeAddress1,"
				+ "headOfficeAddress2,"
				+ "companyPhoneNo,"
				+ "jurisdictionsAddress1,"
				+ "jurisdictionsAddress2,"
				+ "contactAddress1,"
				+ "contactAddress2,"
				+ "representativeFurigana,"
				+ "representativeName,"
				+ "representativeAddress1,"
				+ "representativeAddress2,"
				+ "capital,"
				+ "investment,"
				+ "companyFoundedDate,"
				+ "fiscalKara,"
				+ "fiscalMade,"
				+ "endOfFiscalYear,"
				+ "purposeOfBusiness,"
				+ "businessEvent,"
				+ "businessStartExpectedDate,"
				+ "officer,"
				+ "officerSalary,"
				+ "officeWorker,"
				+ "officeWorkerSalary,"
				+ "salesFactoryWorkers,"
				+ "salesFactoryWorkersSalary,"
				+ "others,"
				+ "othersSalary,"
				+ "taxFurigana,"
				+ "taxName,"
				+ "taxAddress,"
				+ "taxPhone"
				+ ") VALUE ("
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,"
				+ "?,?,?,?)";
		jdbcTemp.execute("SET NAMES 'UTF8'");
		jdbcTemp.execute("SET CHARACTER SET 'UTF8'");
		int result = jdbcTemp.update(sql, 
				formBean.getDateToSubmit(), 
				formBean.getTaxOffice(),
				formBean.getPrefecturalTaxOffice(),
				formBean.getSelectForPrefecturalTaxOffice(),
				formBean.getMunicipalities(),
				formBean.getSelectForMunicipalities(),
				formBean.getCorporateNameFurigana(),
				formBean.getCorporateName(),
				formBean.getHeadOfficeAddress1(),
				formBean.getHeadOfficeAddress2(),
				formBean.getCompanyPhoneNo(),
				formBean.getJurisdictionsAddress1(),
				formBean.getJurisdictionsAddress2(),
				formBean.getContactAddress1(),
				formBean.getContactAddress2(),
				formBean.getRepresentativeFurigana(),
				formBean.getRepresentativeName(),
				formBean.getRepresentativeAddress1(),
				formBean.getRepresentativeAddress2(),
				formBean.getCapital(),
				formBean.getInvestment(),
				formBean.getCompanyFoundedDate(),
				formBean.getFiscalKara(),
				formBean.getFiscalMade(),
				formBean.getEndOfFiscalYear(),
				formBean.getPurposeOfBusiness(),
				formBean.getBusinessEvent(),
				formBean.getBusinessStartExpectedDate(),
				formBean.getOfficer(),
				formBean.getOfficerSalary(),
				formBean.getOfficeWorker(),
				formBean.getOfficeWorkerSalary(),
				formBean.getSalesFactoryWorkers(),
				formBean.getSalesFactoryWorkersSalary(),
				formBean.getOthers(),
				formBean.getOthersSalary(),
				formBean.getTaxFurigana(),
				formBean.getTaxName(),
				formBean.getTaxAddress(),
				formBean.getTaxPhone()
				);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public List<FormBean> getForms() {
		String sql = "SELECT * FROM form";
		RowMapper<FormBean> rowMapper = new BeanPropertyRowMapper<FormBean>(FormBean.class);
		return this.jdbcTemp.query(sql, rowMapper);
	}

	@Override
	public FormBean getFormByID(int id) {
		String sql = "SELECT * FROM form WHERE id = ?";
		RowMapper<FormBean> rowMapper = new BeanPropertyRowMapper<FormBean>(FormBean.class);
		return this.jdbcTemp.queryForObject(sql, rowMapper, id);
	}

	@Override
	public String deleteForm(FormBean formBean) {
		String sql = "DELETE FROM form WHERE id = ?";
		int rowAffected = jdbcTemp.update(sql, formBean.getId());
		if (rowAffected > 0) {
			return "Form Deleted with ID " + formBean.getId() +"!";
		} else {
			return "Form Delete Failed!";
		}
	}

}
