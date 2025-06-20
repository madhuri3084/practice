package com.b2b.stuman.StudentInfo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.b2b.stuman.baseTest.BaseClass;
import com.b2b.stuman.generic.fileUtility.ExcelUtility;
import com.b2b.stuman.generic.fileUtility.FileUtility;
import com.b2b.stuman.generic.webDriverUtility.UtilityClassObject;

import junit.framework.Assert;
/**
 * 
 * @author madhuri
 * 
 */
public class StudentDetailsTest extends BaseClass {
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	
	/*
	 *  scenario : login==>navigation to add students==> Add a Student ==>verify
	 */
	@Test(groups = "smoke")
	public void addStudent() throws Exception {
		
		/*
		 *  step 1: Login to app
		 */
		
//		String sheet = fLib.getDataFromPropertyFile("sheet_name");
//		String name = eLib.getCellData(sheet, 12, 2);
//		String stuCont_Num = eLib.getCellData(sheet, 12, 3);
//		String gender = eLib.getCellData(sheet, 12, 4);
//		String typeOfData = eLib.getCellData(sheet, 12, 5);
//		String degree = eLib.getCellData(sheet, 12, 6);
//		String stream = eLib.getCellData(sheet, 12, 7);
//		String yop = eLib.getCellData(sheet, 12, 8);
//		String techRating = eLib.getCellData(sheet, 12, 9);
//		String tenthPer = eLib.getCellData(sheet, 12, 10);
//		String interper = eLib.getCellData(sheet, 12, 11);
//		String degreePer = eLib.getCellData(sheet, 12, 12);
//		System.out.println(name);
//		System.out.println(stuCont_Num);
//		System.out.println(gender);
//		System.out.println(typeOfData);
//		System.out.println(degree);
//		System.out.println(stream);
//		System.out.println(yop);
//		System.out.println(techRating);
//		System.out.println(tenthPer);
//		System.out.println(interper);
//		System.out.println(degreePer);
		//UtilityClassObject.getTest().log(Status.INFO, "Student details added");
        System.out.println("Student added successfully");
	}
	
	@Test(groups = "regression")
	public void updateStudentDetails()
	{
		//UtilityClassObject.getTest().log(Status.INFO, "Student details updated");
		System.out.println("Students details has been updated successfully");
	}
	
	@Test(groups = "regression")
	public void removeStudent() {
		//UtilityClassObject.getTest().log(Status.INFO, "Student details removed");
		System.out.println("Student details haas been removed");
	}
}
