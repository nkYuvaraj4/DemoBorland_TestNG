package com.qa.testdata;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;


public class dataproviders {

	@DataProvider (name ="dataMethod1")
	public Object[][] dpMethod(Method m){		
		switch(m.getName()) {
		case "add":
			return new Object[][] {{1,2},{3,4}};
		case "strConcat":
			return new Object[][] {{"test1","test2"},{"test3","test4"}};	
		}
		return null;		
	}
	
	@DataProvider(name ="excelData", parallel=true)
	public Object[][] excelFileData() throws IOException{
		Object[][] execelArry =ExcelUtil.getExcelFileData("E:\\Yuvaraj Learning\\Eclipse\\Learn\\Data\\data1.xlsx","Sheet1");
		return execelArry;	
	}
}
