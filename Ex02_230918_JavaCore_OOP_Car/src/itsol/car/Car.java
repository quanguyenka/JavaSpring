package itsol.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import itsol.check.CheckData;
import itsol.manage_car.ManageCar;

public class Car implements Serializable{
	private String numberPlate;
	private String yearOfManufacture;
	private String brand;
	private boolean haveInsurance;
	
	
	public Car() {
		numberPlate = null;
		yearOfManufacture = null;
		brand = null;
		haveInsurance = false;
	}
	
	public Car(String numberPlate, String yearOfManufacture, String brand, boolean haveInsurance) {
		this.numberPlate = numberPlate;
		this.yearOfManufacture = yearOfManufacture;
		this.brand = brand;
		this.haveInsurance = haveInsurance;
	}
	
	
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	
	public String getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(String yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	
	public String getBrand() {
		return brand;
	} 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public boolean getHaveInsurance() {
		return haveInsurance;
	}
	public void setHaveInsurance(boolean haveInsurance) {
		this.haveInsurance = haveInsurance;
	}
	
	
	
	
	
	 	
	public void InputInformation() {
		CheckData check = new CheckData();
		boolean flag = false;
		do {
			flag = true;
			System.out.print("Enter number plate of car: ");
			String s = new Scanner(System.in).nextLine();
			if(check.CheckNumberPlate(s) == true) {
				setNumberPlate(s);
				flag = false;
			}
		} while (flag);
		
		do {
			flag = true;
			
			System.out.print("Enter year of manu future: ");
			String s = new Scanner(System.in).nextLine();
			if(check.CheckYearOfManufacture(s) == true) {
				setYearOfManufacture(s);
				flag = false;
			}
			
		} while(flag);
		
		do {
			flag = true;
			System.out.print("Enter car brand: ");
			String s = new Scanner(System.in).nextLine();
			if(check.CheckBrand(s)) {
				setBrand(s);
				flag = false;
			}
		} while(flag);
		
		System.out.print("Have insuarance?(true/false)");
		setHaveInsurance(new Scanner(System.in).nextBoolean());
	}
	
	public void PrintInformation() {
		System.out.print("Number plate: "+ getNumberPlate());
		System.out.print("Year of manufature: "+ getYearOfManufacture());
		System.out.print("Brand: "+ getBrand());
		System.out.print("Have insuarance: "+ getHaveInsurance());
	}
}










