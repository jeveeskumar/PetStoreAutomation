package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//datasheet.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("userdata");
		int colcount=xl.getCellCount("userdata",1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("userdata", i, j);
			}
		}
		return apidata;
	}
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//datasheet.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("userdata");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("userdata", i, 1);
		}

		return apidata;

	}
}
