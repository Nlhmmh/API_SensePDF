package com.nlh.formpdf.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlh.formpdf.response.FormBean;
import com.nlh.formpdf.respository.FormRepoIF;

/**
 * @author nlh
 *
 */
@Service
public class FormService {

	@Autowired
	private FormRepoIF formRepoIF;

	/**
	 * Submit Form フォームを提出する
	 */
	public String submitForm(FormBean formBean) {
		boolean result = formRepoIF.submitForm(formBean);
		if (result) {
			return "Form Submission Success!";
		} else {
			return "Form Submission Failed!";
		}
	}

	/**
	 * Get All Forms 全部のフォームを抽出する
	 */
	public List<FormBean> getFroms() {
		return formRepoIF.getForms();
	}

	/**
	 * Delete PDF with ID IDでPDFを削除する。
	 */
	public String deletePDF(int id) {
		String response = "";
		FormBean formBean = formRepoIF.getFormByID(id); // Get Targeted From by ID
		response = formRepoIF.deleteForm(formBean);
		return response;
	}

//	/**
//	 * Create PDF without MySQL
//	 * PDFを直接作成する。
//	 */
//	public String creatDirectPDF(FormBean formBean) {
//		List<String> responseList = outputPDF(formBean); 
//		return responseList.get(0);
//	}

	/**
	 * Preview PDF PDFをウェブでプレビューする、
	 */
	public String previewPDF(FormBean formBean) {
		submitForm(formBean);
		String response = outputPDF(formBean);
		return response;
	}

	/**
	 * Create PDF with Form Data フォームデータでPDFを作成し、パスに出力する。
	 */
	private String outputPDF(FormBean formBean) {
		String response = "";
		try {
			String resultPDFName = "form" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()) + ".pdf";
			String resultPDF = ConstantDefine.resultPDFpath + resultPDFName;

			PDDocument pDDocument = PDDocument.load(new File(ConstantDefine.sourcePDF));
			PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
			PDFont pdfont = PDType0Font.load(pDDocument, new File(ConstantDefine.path + "/TestPDF/MSMINCHO.ttf"));

			// Page 1
			fillField(pDAcroForm, pdfont, "10", "1_dateToSubmit", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "2_taxOffice", formBean.getTaxOffice());
			fillField(pDAcroForm, pdfont, "5", "5_corporateNameFurigana", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "6_corporateName", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "7_8_headOfficeAddress", ConstantDefine.post + formBean.getHeadOfficeAddress1() + formBean.getHeadOfficeAddress2());
			fillField(pDAcroForm, pdfont, "10", "9_companyPhoneNo", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "10_11_jurisdictionsAddress", ConstantDefine.post + formBean.getJurisdictionsAddress1() + formBean.getJurisdictionsAddress2());
			fillField(pDAcroForm, pdfont, "10", "12_13_contactAddress1", ConstantDefine.post + formBean.getContactAddress1() + formBean.getContactAddress2());
			fillField(pDAcroForm, pdfont, "10", "14_representativeFurigana", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "15_representativeName", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "16_17_representativeAddress", ConstantDefine.post + formBean.getRepresentativeAddress1() + formBean.getRepresentativeAddress2());
			fillField(pDAcroForm, pdfont, "10", "18_capital", formBean.getCapital());
			fillField(pDAcroForm, pdfont, "10", "20_companyFoundedDate", formBean.getCompanyFoundedDate());
			fillField(pDAcroForm, pdfont, "10", "21_fiscalKara", formBean.getFiscalKara());
			fillField(pDAcroForm, pdfont, "10", "22_fiscalMade", formBean.getFiscalMade());
			fillField(pDAcroForm, pdfont, "10", "23_endOfFiscalYear", formBean.getEndOfFiscalYear());
			fillField(pDAcroForm, pdfont, "10", "24_purposeOfBusiness", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "24_purposeOfBusiness1", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "26_businessStartExpectedDate", formBean.getBusinessStartExpectedDate());
			fillField(pDAcroForm, pdfont, "10", "32_taxName", formBean.getTaxName());
			fillField(pDAcroForm, pdfont, "10", "33_34_taxAddressPhone", formBean.getTaxAddress() + formBean.getTaxPhone());

			// Page 2
			fillField(pDAcroForm, pdfont, "10", "2_1", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "2_3", formBean.getPrefecturalTaxOffice());
			fillField(pDAcroForm, pdfont, "5", "2_5", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "2_6", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "2_7_8", ConstantDefine.post + formBean.getHeadOfficeAddress1() + formBean.getHeadOfficeAddress2());
			fillField(pDAcroForm, pdfont, "10", "2_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "2_10_11", ConstantDefine.post + formBean.getJurisdictionsAddress1() + formBean.getJurisdictionsAddress2());
			fillField(pDAcroForm, pdfont, "10", "2_12_13", ConstantDefine.post + formBean.getContactAddress1() + formBean.getContactAddress2());
			fillField(pDAcroForm, pdfont, "10", "2_14", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "2_15", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "2_16_17", ConstantDefine.post + formBean.getRepresentativeAddress1() + formBean.getRepresentativeAddress2());
			fillField(pDAcroForm, pdfont, "10", "2_18", formBean.getCapital());
			fillField(pDAcroForm, pdfont, "10", "2_20", formBean.getCompanyFoundedDate());
			fillField(pDAcroForm, pdfont, "10", "2_21", formBean.getFiscalKara());
			fillField(pDAcroForm, pdfont, "10", "2_22", formBean.getFiscalMade());
			fillField(pDAcroForm, pdfont, "10", "2_23", formBean.getEndOfFiscalYear());
			fillField(pDAcroForm, pdfont, "10", "2_24_1", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "2_24_2", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "2_26", formBean.getBusinessStartExpectedDate());
			fillField(pDAcroForm, pdfont, "10", "2_32", formBean.getTaxName());
			fillField(pDAcroForm, pdfont, "10", "2_33_34", formBean.getTaxAddress() + formBean.getTaxPhone());

			// Page 3
			fillField(pDAcroForm, pdfont, "10", "3_1", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "3_4", formBean.getMunicipalities());
			fillField(pDAcroForm, pdfont, "5", "3_5", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "3_6", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "3_7_8", ConstantDefine.post + formBean.getHeadOfficeAddress1() + formBean.getHeadOfficeAddress2());
			fillField(pDAcroForm, pdfont, "10", "3_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "3_10_11", ConstantDefine.post + formBean.getJurisdictionsAddress1() + formBean.getJurisdictionsAddress2());
			fillField(pDAcroForm, pdfont, "10", "3_12_13", ConstantDefine.post + formBean.getContactAddress1() + formBean.getContactAddress2());
			fillField(pDAcroForm, pdfont, "10", "3_14", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "3_15", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "3_16_17", ConstantDefine.post + formBean.getRepresentativeAddress1() + formBean.getRepresentativeAddress2());
			fillField(pDAcroForm, pdfont, "10", "3_18", formBean.getCapital());
			fillField(pDAcroForm, pdfont, "10", "3_20", formBean.getCompanyFoundedDate());
			fillField(pDAcroForm, pdfont, "10", "3_21", formBean.getFiscalKara());
			fillField(pDAcroForm, pdfont, "10", "3_22", formBean.getFiscalMade());
			fillField(pDAcroForm, pdfont, "10", "3_23", formBean.getEndOfFiscalYear());
			fillField(pDAcroForm, pdfont, "10", "3_24_1", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "3_24_2", formBean.getPurposeOfBusiness());
			fillField(pDAcroForm, pdfont, "10", "3_26", formBean.getBusinessStartExpectedDate());
			fillField(pDAcroForm, pdfont, "10", "3_32", formBean.getTaxName());
			fillField(pDAcroForm, pdfont, "10", "3_33_34", formBean.getTaxAddress() + formBean.getTaxPhone());

			// Page 4
			fillField(pDAcroForm, pdfont, "10", "4_1", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "4_2", formBean.getTaxOffice());
			fillField(pDAcroForm, pdfont, "5", "4_5", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "4_6", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "4_7", ConstantDefine.post + formBean.getHeadOfficeAddress1());
			fillField(pDAcroForm, pdfont, "10", "4_8", formBean.getHeadOfficeAddress2());
			fillField(pDAcroForm, pdfont, "10", "4_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "4_14", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "4_15", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "4_32", formBean.getTaxName());
			
			// Page 5
			fillField(pDAcroForm, pdfont, "10", "5_1", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "5_2", formBean.getTaxOffice());
			fillField(pDAcroForm, pdfont, "5", "5_5", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "5_6", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "5_7", ConstantDefine.post + formBean.getHeadOfficeAddress1());
			fillField(pDAcroForm, pdfont, "10", "5_8_1", formBean.getHeadOfficeAddress2());fillField(pDAcroForm, pdfont, "10", "3_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "5_8_2", formBean.getHeadOfficeAddress2());fillField(pDAcroForm, pdfont, "10", "3_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "10", "5_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "5", "5_14", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "5_15", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "5_20", formBean.getCompanyFoundedDate());
			fillField(pDAcroForm, pdfont, "10", "5_26", formBean.getBusinessStartExpectedDate());
			fillField(pDAcroForm, pdfont, "10", "5_27", formBean.getOfficer());
			fillField(pDAcroForm, pdfont, "10", "5_27_select", formBean.getOfficerSalary());
			fillField(pDAcroForm, pdfont, "10", "5_28", formBean.getOfficeWorker());
			fillField(pDAcroForm, pdfont, "10", "5_28_select", formBean.getOfficeWorkerSalary());
			fillField(pDAcroForm, pdfont, "10", "5_29", formBean.getSalesFactoryWorkers());
			fillField(pDAcroForm, pdfont, "10", "5_29_select", formBean.getSalesFactoryWorkersSalary());
			fillField(pDAcroForm, pdfont, "10", "5_30", formBean.getOthers());
			fillField(pDAcroForm, pdfont, "10", "5_30_select", formBean.getOthersSalary());
			fillField(pDAcroForm, pdfont, "10", "5_32_1", formBean.getTaxName());
			fillField(pDAcroForm, pdfont, "10", "5_32_2", formBean.getTaxName());
//			fillField(pDAcroForm, pdfont, "10", "5_33 ", formBean.getTaxAddress()); 
			fillField(pDAcroForm, pdfont, "10", "5_34", formBean.getTaxPhone());
			
			// Page 6
			fillField(pDAcroForm, pdfont, "10", "6_1", formBean.getDateToSubmit());
			fillField(pDAcroForm, pdfont, "10", "5_2", formBean.getTaxOffice());
			fillField(pDAcroForm, pdfont, "5", "6_5", formBean.getCorporateNameFurigana());
			fillField(pDAcroForm, pdfont, "10", "6_6", formBean.getCorporateName());
			fillField(pDAcroForm, pdfont, "10", "6_7_8", ConstantDefine.post + formBean.getHeadOfficeAddress1() + formBean.getHeadOfficeAddress2());
			fillField(pDAcroForm, pdfont, "10", "6_9", formBean.getCompanyPhoneNo());
			fillField(pDAcroForm, pdfont, "5", "6_14", formBean.getRepresentativeFurigana());
			fillField(pDAcroForm, pdfont, "10", "6_15", formBean.getRepresentativeName());
			fillField(pDAcroForm, pdfont, "10", "6_16_17", ConstantDefine.post + formBean.getRepresentativeAddress1() + formBean.getRepresentativeAddress2());
			fillField(pDAcroForm, pdfont, "10", "6_18", formBean.getCapital());
			fillField(pDAcroForm, pdfont, "10", "6_20", formBean.getCompanyFoundedDate());
			fillField(pDAcroForm, pdfont, "10", "6_23", formBean.getEndOfFiscalYear());
			fillField(pDAcroForm, pdfont, "10", "6_25", formBean.getBusinessEvent());
			fillField(pDAcroForm, pdfont, "10", "6_32", formBean.getTaxName());
			
			pDAcroForm.flatten();
			pDDocument.save(resultPDF);
			pDDocument.close();

			response = resultPDFName;

			System.out.println(response);
		} catch (Exception e) {
			response = e.getMessage();
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Fill date to TextField of PDF PDFのテキストフィールドでフォームデータを入力する。
	 */
	private void fillField(PDAcroForm pDAcroForm, PDFont pdFont, String fontSize, String fieldName, String value)
			throws IOException {
		PDField field = pDAcroForm.getField(fieldName);
		PDTextField textField = (PDTextField) field;
		String font_name = pDAcroForm.getDefaultResources().add(pdFont).getName();

		textField.setDefaultAppearance(String.format("/%s " + fontSize + " Tf 0 g", font_name));
		textField.setValue(value);
	}

}
