package itsol.car;

import java.io.Serializable;
import java.util.Scanner;

import itsol.car.Car;

public class MediumCar extends Car{
	private boolean havePowerSteering;
	
	public MediumCar() {
		havePowerSteering = false;
	}
	
	public MediumCar(boolean havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}
	
	public boolean getHavePowerSteering() {
		return havePowerSteering;
	}
	public void setHavePowerSteering(boolean havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}
	
	
	public void InputInformation() {
		super.InputInformation();
		System.out.print("Have power steering?(true/false)");
		setHavePowerSteering(new Scanner(System.in).nextBoolean());
	}
	
	public void PrintInformation() {
		super.PrintInformation();
		System.out.print("Power steering: "+ getHavePowerSteering());
	}
}

