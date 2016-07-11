package class_client_lab;

import java.util.ArrayList;

public class ReviewLab {
	
	private ArrayList<String> roster;
	private String city;
	private double teamBattingAverage;
	private final String [] city_names = {"Chicago", "New York", "L.A.", "Oakland"};
	
	// constructor that also sets the city.  initialize all
	// member variables
	public ReviewLab () {
		roster = new ArrayList<String>();
		
		this.city = "not set";
		
		teamBattingAverage = 0.00;
	}
	
	// constructor that also sets the city.  initialize all
	// member variables
	// @param: city - name of city to add
	public ReviewLab (String city) {
		this.city = city;
		roster = new ArrayList<String>();
		teamBattingAverage = 0.00;
	}
	
	// this method adds to the roster
	// @param: name - a list of names you want to add to the
	//                roster.  Example of calling this method:
	//			      r1.addToRoster ("james pat brian");
	public void addToRoster (String name) {
		
		
		String [] token = name.split(" ");
		
		for (int i = 0; i < token.length; i++) {
			
			roster.add(token[i]);
		}
	}
	
	// this method updates the teams batting average.  it should be in the 
	// range of 0.000 - 1.000
	public void updateBattingAverage (double average) {
		teamBattingAverage = average;
	}
	
	// this method returns true/false if the teams
	// batting average is good.
	public boolean isAverageGood () {
		if (teamBattingAverage > 0.300) {
			return true;
		} else {
			return false;
		}
	}
	
	// this method sets the city.  it verifies that 
	// the city is valid
	public void setCity (String city) {
		for (int i = 0; i < city_names.length; i++) {
			if (city_names[i].equals(city)) {
				this.city = city;
				return;
			}
		}
		
		System.out.println ("city not valid");
	}
	
	// print
	public String toString () {
		String name = ""; 
		
		for (int i = 0; i < roster.size(); i++) {
			name = name + " " + roster.get(i);
			System.out.println ("name = " + name);
		}
		
		name = "\tCity: " + city + "\n" + teamBattingAverage + "\n" + name;
		
		return name;
	}
	
	public boolean equals (ReviewLab lab) {
		if (lab.city.equals (this.city)) {
			return true;
		} else {
			return false;
		}
	}
}
