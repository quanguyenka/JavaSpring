package itsol.car;

import java.util.Scanner;

import itsol.car.Car;

public class OldCar extends Car{
	private String actionDuration;
	
	public OldCar() {
		actionDuration = null;
	}
	
	public OldCar(String actionDuration) {
		this.actionDuration = actionDuration;
	}
	
	public String getActionDuration() {
		return actionDuration;
	}
	public void setActionDuration(String actionDuration) {
		this.actionDuration = actionDuration;
	}
	
	public void InputInformation() {
		super.InputInformation();
		System.out.print("Enter car action duration: ");
		setActionDuration(new Scanner(System.in).nextLine());
	}
	
	public void PrintInformation() {
		super.PrintInformation();
		System.out.print("Action duration: "+getActionDuration());
	}
}