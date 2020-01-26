package com.nlh.formpdf.respository;

import java.util.List;

import com.nlh.formpdf.response.FormBean;

/**
 * @author nlh
 *
 */
public interface FormRepoIF {

	boolean submitForm(FormBean formBean);

	List<FormBean> getForms();

	FormBean getFormByID(int id);

	String deleteForm(FormBean formBean);

}
