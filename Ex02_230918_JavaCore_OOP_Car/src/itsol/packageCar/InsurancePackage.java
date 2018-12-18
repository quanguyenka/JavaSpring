package itsol.packageCar;

import java.util.Scanner;

public class InsurancePackage {
	private String packageName;
	private String typePackage;
	
	public InsurancePackage() {
		packageName = null;
		typePackage = null;
	}
	
	public InsurancePackage(String packageName, String typePackage) {
		this.packageName = packageName;
		this.typePackage = typePackage;
	}
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getTypePackage() {
		return typePackage;
	}
	public void setTypePackage(String typePackage) {
		this.typePackage = typePackage;
	}
	
	public void InputInformationPackage() {
		System.out.print("Enter package name: ");
		setPackageName(new Scanner(System.in).nextLine());
		System.out.print("Enter type of package: ");
		setTypePackage(new Scanner(System.in).nextLine());
	}
	
}







