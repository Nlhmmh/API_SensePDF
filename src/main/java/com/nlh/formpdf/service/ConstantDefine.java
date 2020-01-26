package com.nlh.formpdf.service;

public class ConstantDefine {
	
	public static final String post = "〒"; // 〒

	// Ubuntu
//	public static final String path = "/home/nlh/Documents/TestPDF";
	
	// Windows
//	public static final String path = "C:/Users/Acer/Documents/TestPDF";
	public static final String path = "F:/1_All_Projects_&_Testings/Vue/formpdfVue";
	
	// Mac - To modify
//	public static final String path = "/users/sense11/Desktop/company project by MMH/New folder/formpdfVue";
	
	public static final String pathFolder = "/TestPDF";
	public static final String sourcePDF = path + pathFolder + "/DefaultForm.pdf";
	
//	public static String resultPDFName = "form" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()) + ".pdf";
	public static String resultPDFpath = path + "/public/";	
}
