package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProvider {

	@Test(dataProvider =" getData")
	public void AddToCard(String name,int price,int qty,String color,boolean isAvailable) {
		
		System.out.println("--"+name+"----"+price+"--"+qty+"----"+color+"---"+isAvailable);
		
	}
	@DataProvider
	public  Object[][] getData()
	{
		Object[][] data=new Object[3][5];
		data[0][0]="samasung";
		data[0][1]=1000000;
		data[0][2]=2;
		data[0][3]="Black";
		data[0][4]=true;
		
		data[1][0]="Lenovo";
		data[1][1]=1000000;
		data[1][2]=2;
		data[1][3]="grey";
		data[1][4]=false;
		
		data[2][0]="HP";
		data[2][1]=100000;
		data[2][2]=1;
		data[2][3]="blue";
		data[2][4]=true;
		
		return data;
		
	}
}
