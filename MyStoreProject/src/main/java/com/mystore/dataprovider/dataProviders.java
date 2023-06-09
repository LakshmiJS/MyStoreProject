package com.mystore.dataprovider;
import com.mystore.utility.excelLibrary;
import org.testng.annotations.DataProvider;

public class dataProviders {
	excelLibrary xl=new excelLibrary();
	@DataProvider(name="Credentials")
	public Object[][] getCrdentials()
	{
		int rows=xl.getRowCount("Credentials");
		int columns=xl.getColumnCount("Credentials");
		int actualRows=rows-1;
		Object[][] data=new Object[actualRows][columns];
		for(int i=0;i<actualRows;i++)
		{
			for( int j=0;j<columns;j++)
			{
				
				data[i][j]=xl.getCellData("Credentials", j, i+2);
		}
		}
			return data;	
	}
	@DataProvider(name="NewAccount")
	public Object[][] getNewEmail()
	{
		int rows=xl.getRowCount("NewAccount");
		int columns=xl.getColumnCount("NewAccount");
		int actualRows=rows-1;
		Object[][] data=new Object[actualRows][columns];
		for(int i=0;i<actualRows;i++)
		{
			for( int j=0;j<columns;j++)
			{
				
				data[i][j]=xl.getCellData("NewAccount", j, i+2);
		}
		}
			return data;	
	}


}
