package com.nlh.formpdf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nlh.formpdf.response.FormBean;
import com.nlh.formpdf.service.FormService;

/**
 * @author nlh
 *
 */
@RestController
public class FormController {

	@Autowired
	private FormService formSer;
	
	/**
	 * Submit Form
	 * フォームを提出する
	 */
	@CrossOrigin
	@RequestMapping(value = "/api/submitForm", method = RequestMethod.POST)
	public ResponseEntity<String> submitForm(@RequestBody FormBean formBean) {
		String response = formSer.submitForm(formBean);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	/**
	 * Get All　Forms
	 *　全部のフォームを抽出する
	 */
	@CrossOrigin
	@RequestMapping(value = "/api/getForms", method = RequestMethod.GET)
	public ResponseEntity<List<FormBean>> getForms() {
		List<FormBean> response = formSer.getFroms();
		return new ResponseEntity<List<FormBean>>(response, HttpStatus.OK);
	}
	
	/**
	 * Delete PDF　with ID
	 *　IDでPDFを削除する。
	 */
	@CrossOrigin
	@RequestMapping(value = "/api/deleteForm", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteForm(@RequestParam String id) {
		String response = "";
		try {
			response = formSer.deletePDF(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			response = "Error : Targeted ID is not a number";
		}
		System.out.println(response);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
//	/**
//	 * Create PDF without MySQL
//	 * PDFを直接作成する。
//	 */
//	@CrossOrigin
//	@RequestMapping(value = "/api/createDirectPDF", method = RequestMethod.POST)
//	public ResponseEntity<String> createDirectPDF(@RequestBody FormBean formBean) {
//		String response = formSer.creatDirectPDF(formBean);
//		return new ResponseEntity<String>(response, HttpStatus.OK);
//	}
	
	/**
	 * Preview PDF
	 *　PDFをウェブでプレビューする、
	 */
	@CrossOrigin
	@RequestMapping(value = "/api/previewPDF", method = RequestMethod.POST)
	public ResponseEntity<String> previewPDF(@RequestBody FormBean formBean) {
		String response = formSer.previewPDF(formBean);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}	
	
}
