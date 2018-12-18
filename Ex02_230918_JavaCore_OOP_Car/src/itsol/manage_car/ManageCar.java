package itsol.manage_car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import itsol.car.Car;
import itsol.car.MediumCar;
import itsol.car.ModernCar;
import itsol.car.OldCar;

public class ManageCar {
	private int amount;
	ArrayList<Car> list1 = new ArrayList<>();
	ArrayList<Car> list2 = new ArrayList<>();
	
	public ManageCar() {
		amount = 0;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void InputInfoCar() {
		
		list1 =  new ArrayList<Car>();
		
		System.out.print("Enter car amount: ");
		setAmount(new Scanner(System.in).nextInt());
		
		boolean flag;
		for(int i = 0; i < getAmount(); i++) {
			do {
				System.out.println("Enter the type of car: ");
				System.out.println("1: Modern car");
				System.out.println("2: Medium car");
				System.out.println("3: Old car");
				int choose = new Scanner(System.in).nextInt();
				
				flag = true;
				
				switch(choose) {
					case 1: {
						ModernCar modernCar = new ModernCar();
						modernCar.InputInformation();
						//save
						list1.add(modernCar);
						flag = false;						
					} break;
					case 2: {
						MediumCar mediumCar = new MediumCar();
						mediumCar.InputInformation();
						list1.add(mediumCar);
						//save
						flag = false;
					} break;
					case 3: {
						OldCar oldCar = new OldCar();
						oldCar.InputInformation();
						list1.add(oldCar);
						//save
						flag = false;
					} break;
					default : {
						System.out.print("Choose 1, 2 or 3!");
					}
				}
				
			}while (flag);
		}

		SaveInfoCar(list1);
	}
	
	public void PrintInfoCar() {
		list2 = new ArrayList<Car>();
		try {
			String filePath = "Car.dat";
			File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("File not exists");
			}
						
			
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			list2 = (ArrayList<Car>)ois.readObject();
			for(int i = 0; i < list2.size(); i++) {
				Car car = new Car();
				
				car = (Car)list2.get(i);
				System.out.println(car.getNumberPlate()+ " " + car.getBrand() + " " +car.getYearOfManufacture()
				+ " " +car.getHaveInsurance());
				
			}
			
			
			ois.close();
			fis.close();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void SaveInfoCar(ArrayList car)  {
		
		try {
			String filePath = "Car.dat";
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileOutputStream  fos = new FileOutputStream(filePath, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(car);
			
			oos.close();
			fos.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
