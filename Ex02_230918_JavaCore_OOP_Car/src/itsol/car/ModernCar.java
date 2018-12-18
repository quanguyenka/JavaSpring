package itsol.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import itsol.car.Car;

public class ModernCar extends Car{
	private boolean havePositioningDevice;
	
	public ModernCar() {
		havePositioningDevice = false;
	}
	public ModernCar(boolean havePositioningDevice) {
		this.havePositioningDevice = havePositioningDevice;
	}
	
	public boolean getHavePositioningDevice() {
		return havePositioningDevice;
	}
	public void setHavePositioningDevice(boolean havePositioningDevice) {
		this.havePositioningDevice = havePositioningDevice;
	}
	
	public void InputInformation() {
		super.InputInformation();
		System.out.print("Have positioning device?(true/false)");
		setHavePositioningDevice(new Scanner(System.in).nextBoolean());
		//save...
	}
	public void PrintInformation() {
		super.PrintInformation();
		System.out.print("Have positioning device: "+ getHavePositioningDevice());
	}
	
}

