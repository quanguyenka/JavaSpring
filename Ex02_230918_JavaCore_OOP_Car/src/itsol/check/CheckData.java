package itsol.check;

public class CheckData {
	public CheckData() {
		
	}
	
	public boolean CheckNumberPlate(String numberPlate) {
		
		if(numberPlate.length() != 5) {
			System.out.println("Length of number plate equal 5!");
			return false;
		}
				
		
		return true;
	}
	
	public boolean CheckYearOfManufacture(String yearOfManufacture) {
		int number = Integer.parseInt(yearOfManufacture);
		
		
		if(number < 1980 || number > 2012) {
			return false;
		}
		
		return true;
	}
	
	public boolean CheckBrand(String brand) {
		if(brand.equalsIgnoreCase("TOYOTA") || brand.equalsIgnoreCase("BMW") || brand.equalsIgnoreCase("HUYNDAI")) {
			return true;
		}
		return false;
	}
}
