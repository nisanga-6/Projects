package com.nisanga.PDFExtract;
import java.io.*;
//import java.io.IOException;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdmodel.*;
//import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtractPDF {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File pdfFile=	new File("C:\\Users\\User\\Desktop\\file1.pdf");
		FileInputStream fis = new FileInputStream(pdfFile);
	    PDDocument document=	PDDocument.load(fis);
	    System.out.println(document.getPages().getCount());
	    PDFTextStripper pdfTextStripper = new PDFTextStripper();
	  String docText=  pdfTextStripper.getText(document);
	  System.out.println(docText);
	    document.close();
	    fis.close();
			
		

	}
	public static String extractShipFromAddress(String text) {
		String shipFromAddress = null;
		String keyword = "Ship from Adress";
		int startIndex=text.indexOf(keyword);
		if(startIndex!=-1) {
			int endIndex = text.indexOf("\n", startIndex);
			if(endIndex !=-1) {
			shipFromAddress=	text.substring(startIndex+keyword.length(),endIndex).trim();
			}
		}
		return shipFromAddress;
		
	}
	public static String extractSoldToAddress(String text) {
		String soldToAdress=null;
		String keyword = "Sold to Address";
		int startIndex=text.indexOf(keyword);
		if(startIndex!=-1) {
			int endIndex = text.indexOf("\n", startIndex);
			if(endIndex !=-1) {
				soldToAdress=	text.substring(startIndex+keyword.length(),endIndex).trim();
			}
		}
		return soldToAdress;
		
	}
	public static String extractConsigneeAddress(String text) {
		String consigneeAdress=null;
		String keyword = "Consignee Address";
		int startIndex=text.indexOf(keyword);
		if(startIndex!=-1) {
			int endIndex = text.indexOf("\n", startIndex);
			if(endIndex !=-1) {
				consigneeAdress=	text.substring(startIndex+keyword.length(),endIndex).trim();
			}
		}
		return consigneeAdress;
		
	}
	
	public static String shipToAddress(String text) {
		String shipToAdress=null;
		String keyword = "Ship to Address";
		int startIndex=text.indexOf(keyword);
		if(startIndex!=-1) {
			int endIndex = text.indexOf("\n", startIndex);
			if(endIndex !=-1) {
				shipToAdress=	text.substring(startIndex+keyword.length(),endIndex).trim();
			}
		}
		return shipToAdress;
		
	}

}
