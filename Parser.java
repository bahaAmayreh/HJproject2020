import java.io.*;
import java.util.ArrayList;
import jxl.Sheet;
import jxl.Workbook;
public class Parser {
private int countFemale;
private int countMale;
private int countSV;
private int countXY;
private int countOther;
private int countEgy;
private int countPakis;
private int countBang;
private  String url;
private ArrayList<Person> data= new ArrayList<Person>();
public  Parser() {
	this.url="src\\file\\Data.xls";
}
	public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
	public static void main(String[] args) throws Exception {
		Parser pr = new Parser();
		pr.readExcel(pr.getUrl());
		pr.analyzer();
		System.out.print("Famale="+pr.countFemale);
		System.out.print(", male="+pr.countMale);
		System.out.print(", SV flight="+pr.countSV);
		System.out.print(", XY flight="+pr.countXY);
		System.out.print(", Ohter flight="+pr.countOther);
	}
	public  void  readExcel(String url) throws Exception {
		File file= new File(url);
		 Workbook w;	 
		 try {
			 w = Workbook.getWorkbook(file);
			 Sheet page = w.getSheet(0);
			 for (int y = 1; y <page.getRows() ; y++){
				 Person person= new Person();
				 for (int x = 0; x <page.getColumns() ; x++){
					 switch(x) {
					 case 0:person.setID(page.getCell(x, y).getContents());break;
					 case 1:person.setName(page.getCell(x, y).getContents());break;
					 case 2:person.setSeason(page.getCell(x, y).getContents());break;
					 case 3:person.setAge(page.getCell(x, y).getContents());break;
					 case 4:person.setEntryDate(page.getCell(x, y).getContents());break;
					 case 5:person.setEitDate(page.getCell(x, y).getContents());break;
					 case 6:person.setEntryTime(page.getCell(x, y).getContents());break;
					 case 7:person.setExitTime(page.getCell(x, y).getContents());break;
					 case 8:person.setGender(page.getCell(x, y).getContents());break;
					 case 9:person.setNation(page.getCell(x, y).getContents());break;
					 case 12:person.setAirline(page.getCell(x, y).getContents());break;
					 } 
				 }
				 data.add(person);
				// System.out.print(person.getID()+", "+person.getName()+"," +person.getSeason()+"," +person.getAge()+"," +person.getEntryDate()+"," +person.getEitDate()+"," +person.getEntryTime()+"," +person.getExitTime()+"," +person.getAirline());	 
			 }
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		 
	}
	public void analyzer() {
		for(int i=0;i<data.size();++i) {
			if(data.get(i).getGender().trim().equals("F"))
				this.countFemale++;
			else
				this.countMale++;
			if(data.get(i).getAirline().trim().equals("SV"))
				this.countSV++;
				else if(data.get(i).getAirline().trim().equals("XY"))
					this.countXY++;
				else 
					this.countOther++;
			if(data.get(i).getNation().trim().equals("BAbNGLADESH"))
					this.countBang++;
			else if(data.get(i).getNation().trim().equals("EGYPT"))
					this.countEgy++;
			else if (data.get(i).getNation().trim().equals("PAKISTAN"))
					this.countPakis++;
		}
	}
}//end class parser

