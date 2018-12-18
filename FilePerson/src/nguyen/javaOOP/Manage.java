package nguyen.javaOOP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Manage {
	ArrayList<NhanVien> list = new ArrayList<>();
	NhanVien nv = new NhanVien();
	
	public void DocFile() {
		String filePath = "nhanvien.dat";
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while ((line = br.readLine()) != null) {
				nv = new NhanVien();
				String[] arr;
				arr = line.split("\\$");
				nv.setHoTen(arr[0]);
				nv.setNgaySinh(arr[1]);
				nv.setDiaChi(arr[2]);
				nv.setGioiTinh(arr[3]);
				nv.setPhong(arr[4]);
				nv.setHsl(Float.parseFloat(arr[5]));
				nv.setLuongCB(Float.parseFloat(arr[6]));
				nv.setThamNien(Integer.parseInt(arr[7]));
				
				list.add(nv);
			}
			
			br.close();
			fr.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void GhiFile() {
		
		for(int i = 0; i < list.size(); i++) {		
			System.out.println(list.get(i).getHoTen() + " " + list.get(i).getNgaySinh() + " " + list.get(i).getDiaChi() + " " + list.get(i).getGioiTinh() 
			+ " " + list.get(i).getPhong() + " " + list.get(i).getHsl() + " " + list.get(i).getLuongCB() + " " + list.get(i).getThamNien());
		}
	}
}