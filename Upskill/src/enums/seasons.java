package enums;

import java.util.Arrays;
import java.util.List;

 enum season {
	SPRING(Arrays.asList("March", "April", "May")),
	SUMMER(Arrays.asList("June","july","august")),
	AUTUMN(Arrays.asList("September","October","November")),
	WINTER(Arrays.asList("December","January","Febravary"));
	 private final List<String> months;
	season(List<String> months) {
		this.months=months;
		// TODO Auto-generated constructor stub
	}
	public List<String> getMonths(){
		return months;
	}
	public static season getsesonByMonth(String month) {
		for(season season:season.values()) {
			if(season.getMonths().contains(month)) {
				return season;
			}
		}
		return null;
	}
	
}
 public class seasons{
	 public static void main(String[] args) {
		 String month="March";
		 season ses=season.getsesonByMonth(month);
		 if(ses!=null) {
			 System.out.println("month :"+month +"belongs to season:"+ses);
		 }else {
			 System.out.println("nont found");
		 }
		
	}
	
	 
	 
 }
