package itsol.Controller;

import java.sql.DriverManager;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;

import itsol.object.GiaoVien;

public class Control {
	
	GiaoVien gv = new GiaoVien();
	
	//Chạy chương trình
	public void Login() {
        boolean flag = true;
        System.out.println("Ban can dang nhap truoc!");
        System.out.printf("1: Dang nhap\t\t\t2:Thoat");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1: {
                DangNhap();
            }
            break;

            case 2: {
                System.out.println("BAN CHAC CHAN MUON THOAT CHUONG TRINH?");
                System.out.println("Yes/y");
                String s = new Scanner(System.in).nextLine();
                if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("yes")) {
                    System.exit(0);
                } else {
                    Login();
                }
            }
            break;
        }
    }
	
	// Đăng nhập
	public void DangNhap() {
		System.out.println("Nhap acount: ");
		gv.setAcount(new Scanner(System.in).nextLine());
		System.out.println("Nhap ho: ");
		gv.setFirstName(new Scanner(System.in).nextLine());
		System.out.println("Nhap ten: ");
		gv.setLastName(new Scanner(System.in).nextLine());
		System.out.println("Nhap email: ");
		gv.setEmail(new Scanner(System.in).nextLine());
		
		XuLyDangNhap();
	}
	
	
	//Kết nối đến SQL server
	Connection conn = null;
	public Connection getConnection() {
		try {
			
			String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QLSV_GV";
			String user = "sa";
			String pass = "aaa";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url,user, pass);
			
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.out.println("Ket noi that bai");
			
			e.printStackTrace();
		}
		return conn;
	}
	
	//Xử lý đăng nhập
	Connection cn;
	Statement stm;
	ResultSet rs;
	
	public void XuLyDangNhap() {
		
		
		try {
			 cn = getConnection();
			 
			 String sql = "select * from GIAOVIEN";
			 
			 stm = cn.createStatement();
			 rs = stm.executeQuery(sql);
			 
			 while(rs.next()) {
				 				
				 
				 
				 if(rs.getString(1).trim().equals(gv.getAcount())  && rs.getString(2).trim().equals(gv.getFirstName())  && rs.getString(3).trim().equals(gv.getLastName())  && rs.getString(4).trim().equals(gv.getEmail())) {
					 System.out.println("Dang nhap thanh cong!");
					 String filePath = "GiaoVien.dat";
					 File file = new File(filePath);
					 if(!file.exists()) {
						 file.createNewFile();
					 }
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					 LocalDateTime now = LocalDateTime.now();
					 
					 try {
						 FileWriter fr = new FileWriter(filePath, true);
						 BufferedWriter br = new BufferedWriter(fr);
 						 String line = "";
						 line =rs.getString(1).trim()+ " dang nhap vao: " + (String)dtf.format(now);
						 
						 br.newLine();
						 br.write(line);
						 
						 br.close();
						 fr.close();
					} catch (Exception e) {
						System.out.println("Loi ghi file");
						e.printStackTrace();
					}
					 
					 
					 showDanhSachSV(rs.getString(1));
					 
				 }
			 }
			 System.out.println("Dang nhap that bai, vui long dang nhap lai");
			 Login();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Xử lý tác vụ
	
	public void showDanhSachSV(String acount) {

		try {
			
			String sql = "Select * from SINHVIEN where SINHVIEN.ACOUNT = '" + acount.trim()+"';";
			
			
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			
			
			System.out.println("Tai khoan cua ban: "+acount.trim());

			System.out.println("Thong tin hoc sinh cua ban");
			while(rs.next()) {
				
				System.out.printf("\tID: "+rs.getString(1).trim()+"\tHo ten: "+rs.getString(2).trim()
						+"\tEmail: "+rs.getString(3).trim()+"\tLop: "+rs.getString(4).trim()+"\tSDT: "
						+rs.getString(5).trim()+"\tGhi chu: "+rs.getString(6).trim()+"\n");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		showMenu();
	}
	
	public void showMenu() {
        do {
            System.out.println(".--------------------LUA CHON TAC VU---------------------.");
            System.out.println("|       1: Loc danh sach hoc vien theo lop               |");
            System.out.println("|       2: Tim kiem sinh vien                            |");
            System.out.println("|       3: Them/ Sua/ Xoa sinh vien                      |");
            System.out.println("|       4: Sap xep danh sach sinh vien                   |");
            System.out.println("|       5: Thoát!                                        |");
            System.out.println("*--------------------------------------------------------*");
            
            System.out.println("Nhap tac vu ban muon thuc thi!");
            int choose = new Scanner(System.in).nextInt();

            switch (choose) {
                case 1: {
                    LocDanhSach();
                } break;
                case 2: {
                	TimKiemSinhVien();
                }break;
                case 3: {
                	ChucNang();
                } break;
                	 
                case 5: {
                	System.out.println("BAN CHAC CHAN MUON THOAT CHUONG TRINH?(Yes/y)");
                    String s = new Scanner(System.in).nextLine();
                    if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("yes")) {
                    	System.out.println("DA THOAT");
                        System.exit(0);
                    } else {
                        showMenu();
                    }
                } break;
                default: {
                    System.out.println("Nhap sai, vui long nhap lai!");
                }
            }
        } while (true);
        
        
        
    }
    
    public void LocDanhSach() {
        System.out.println("Nhap lop ban muon loc");
        String lop = new Scanner(System.in).nextLine();
        
        try {
			String sql = "select * from SINHVIEN join GIAOVIEN on SINHVIEN.ACOUNT = GIAOVIEN.ACOUNT"
					+ " where SINHVIEN.LOP = '"+lop.trim()+"' and GIAOVIEN.ACOUNT = '"+gv.getAcount()+"';"; // sai
			
			
			//luu vao 1 list,xuat list ra
			
			System.out.print("Danh sach sinh vien lop: "+lop);
			
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				System.out.printf("\tID: "+rs.getString(1).trim()+"\tHo ten: "+rs.getString(2).trim()
						+"\tEmail: "+rs.getString(3).trim()+"\tLop: "+rs.getString(4).trim()+"\tSDT: "
						+rs.getString(5).trim()+"\tGhi chu: "+rs.getString(6).trim()+"\n");
			}
			
			
		} catch (Exception e) {
			System.out.println("Xin loi! Phat sinh loi khong mong muon!");
			e.printStackTrace();
		}
    }
    
    public void ChucNang() {
    	do {
    		
    		System.out.println("Chuc nang ban muon thuc thi?");
    		System.out.println(".-----------------------------------.");
        	System.out.println("|      1: Them sinh vien            |");
        	System.out.println("|      2: Sua thong tin sinh vien   |");
        	System.out.println("|      3: Xoa sinh vien             |");
        	System.out.println("|      4: Huy tac vu!               |");
        	System.out.println("*-----------------------------------*");
        	
        	int choose =  new Scanner(System.in).nextInt();

        	
        	
        	switch (choose) {
        	
				case 1:{
			       ThemSinhVien();			        
				} break;
				case 2: {
					SuaThongTin();
				}
				case 4: {
					showMenu();
				}
				default: {
					System.out.println("Nhap sai, vui long chon lai chuc nang!");
				} break;				
			}
        	
		} while (true);
    }
    
    public void SuaThongTin() {
    	String ID, HOTEN, EMAIL,LOP, SDT, GHICHU;
    	boolean flag;
    	
    	
		System.out.println("Nhap thong tin sinh vien");
        do {
        	flag = true;
        	System.out.println("Nhap ID: ");
	        ID = new Scanner(System.in).nextLine();
	        
	        
	        
	        try {
	        	
	        	String sql = "SELECT * FROM SINHVIEN WHERE SINHVIEN.ACOUNT = '"+gv.getAcount().trim()+"'";
	        	
				stm = cn.createStatement();
				rs = stm.executeQuery(sql);
				
				boolean flg = rs.next();
				
				do  {
					
					if(ID.trim().equalsIgnoreCase(rs.getString(1).trim())) {
						System.out.println(ID);
						System.out.println(rs.getString(1));
						break;
					}
					flg = rs.next();
					if(!flg) {
						System.out.println("ID khong ton tai!");
						showMenu();
						
					}
					
				} while (flg);
			} catch (Exception e) {
				// TODO: handle exception
			}
	        
	        
	        char[] temp = ID.toCharArray();
	        
	        ID.toString();
	        if (ID.length() > 10) {
				System.out.println("Do dai ID <= 10, moi ban nhap lai");
			} else if (temp[0] != 'S' && temp[1] != 'V') {
				System.out.println("ID bat dau bang chuoi sv, moi nhap lai!");
			} else {
				flag = false;
			}
	        	
		} while (flag);
        
        
        do {
        	flag = true;
        	System.out.println("Nhap ho ten: ");
	        HOTEN = new Scanner(System.in).nextLine();
	        String so = "0123456789";
	        char[] s = HOTEN.toCharArray();
	        if(HOTEN.length() > 50) {
	        	System.out.println("Do dai ten khong vuot qua 50 ki tu, moi nhap lai!");     	
	        } else {
	        	for (int i = 0; i < s.length; i++) {
					if (so.equalsIgnoreCase(Character.toString(s[i]))) {
						System.out.println("Ho ten khong duoc chua so, moi nhap lai!");
						break;
					}
				}	
				flag = false;
	        }
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap email: ");
	        EMAIL = new Scanner(System.in).nextLine();
	        
	        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(EMAIL);
	        
	        if (matcher.find()) {
	            flag = false;
	        } else {
	            System.out.println("EMAIL khong hop le, moi nhap lai!");
	        }
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap lop: ");
	        LOP = new Scanner(System.in).nextLine();
	        
	        if (LOP.length() > 10) {
				System.out.println("Do dai chuoi vuot qua 10 ki tu, moi nhap lai!");
			} else {
				flag = false;
			}
	        
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap SDT: ");
	        SDT = new Scanner(System.in).nextLine();
	        if (SDT.length() > 11 || SDT.length() < 9) {
	        	System.out.println("So khong hop le, moi nhap lai!");
			} else {
				try {
					Long.parseLong(SDT);
					SDT.toString();
					
					flag = false;
				} catch (Exception e) {
					System.out.println("SDT chua ki tu khong hop le, moi nhap lai!");
				}
			}
	        
			
	        
		} while (flag);
        
        
        System.out.println("Ghi chu: ");
        GHICHU = new Scanner(System.in).nextLine();
        
        
        
        try {
			String sql = "UPDATE SINHVIEN"
					+ " SET ID = '"+ID.trim()+"', HOTEN = '"+HOTEN.trim()+"', EMAIL = '"+EMAIL.trim()+"', LOP = '"+LOP.trim()+"',"
							+ " GHICHU = '"+GHICHU.trim()+"', ACOUNT = '"+gv.getAcount().trim()+"' WHERE ID = '"+ID.trim()+"'";			
			
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
    }
    
    public void ThemSinhVien() {
    	String ID, HOTEN, EMAIL,LOP, SDT, GHICHU;
    	boolean flag;
    	
    	
		System.out.println("Nhap thong tin sinh vien");
        do {
        	flag = true;
        	System.out.println("Nhap ID: ");
	        ID = new Scanner(System.in).nextLine();
	        ID.toUpperCase();
	        
	        char[] temp = ID.toCharArray();
	        
	        ID.toString();
	        if (ID.length() > 10) {
				System.out.println("Do dai ID <= 10, moi ban nhap lai");
			} else if (temp[0] != 'S' && temp[1] != 'S') {
				System.out.println("ID bat dau bang chuoi sv, moi nhap lai!");
			} else {
				flag = false;
			}
	        	
		} while (flag);
        
        
        do {
        	flag = true;
        	System.out.println("Nhap ho ten: ");
	        HOTEN = new Scanner(System.in).nextLine();
	        String so = "0123456789";
	        char[] s = HOTEN.toCharArray();
	        if(HOTEN.length() > 50) {
	        	System.out.println("Do dai ten khong vuot qua 50 ki tu, moi nhap lai!");     	
	        } else {
	        	for (int i = 0; i < s.length; i++) {
					if (so.equalsIgnoreCase(Character.toString(s[i]))) {
						System.out.println("Ho ten khong duoc chua so, moi nhap lai!");
						break;
					}
				}	
				flag = false;
	        }
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap email: ");
	        EMAIL = new Scanner(System.in).nextLine();
	        
	        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(EMAIL);
	        
	        if (matcher.find()) {
	            flag = false;
	        } else {
	            System.out.println("EMAIL khong hop le, moi nhap lai!");
	        }
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap lop: ");
	        LOP = new Scanner(System.in).nextLine();
	        
	        if (LOP.length() > 10) {
				System.out.println("Do dai chuoi vuot qua 10 ki tu, moi nhap lai!");
			} else {
				flag = false;
			}
	        
		} while (flag);
        
        do {
			flag = true;
			System.out.println("Nhap SDT: ");
	        SDT = new Scanner(System.in).nextLine();
	        if (SDT.length() > 11 || SDT.length() < 9) {
	        	System.out.println("So khong hop le, moi nhap lai!");
			} else {
				try {
					Long.parseLong(SDT);
					SDT.toString();
					
					flag = false;
				} catch (Exception e) {
					System.out.println("SDT chua ki tu khong hop le, moi nhap lai!");
				}
			}
	        
			
	        
		} while (flag);
        
        
        System.out.println("Ghi chu: ");
        GHICHU = new Scanner(System.in).nextLine();
        
        try {
        	String sql = "INSERT INTO SINHVIEN(ID, HOTEN, EMAIL, LOP, SDT, GHICHU, ACOUNT)"
	        		+ "VALUES ('"+ID.trim()+"','"+HOTEN.trim()+"','"+EMAIL.trim()+"','"+LOP.trim()+
	        		"','"+SDT.trim()+"','"+GHICHU.trim()+"','"+gv.getAcount().trim()+"');";
	                	
        	
	        stm = cn.createStatement();
	        rs = stm.executeQuery(sql);
	        
	        System.out.println("Them sinh vien thanh cong!");
	        
		} catch (Exception e) {
		}
    }
    
    public void TimKiemSinhVien() {
    	do {
    		System.out.println("Ban muon tim kiem theo?");
        	System.out.println(".------------------------.");
        	System.out.println("|      1: Ten            |");
        	System.out.println("|      2: Email          |");
        	System.out.println("|      3: SDT            |");
        	System.out.println("|      4: Huy tac vu!    |");
        	System.out.println("*------------------------*");
        	
        	int choose = new Scanner(System.in).nextInt();
        	
        	switch(choose) {
        		case 1: {
        			System.out.println("Nhap ten sinh vien ban muon tim kiem!");
        			String tenSinhVien = new Scanner(System.in).nextLine();
        			try {
        				String sql = "select * from SINHVIEN join GIAOVIEN on SINHVIEN."
        						+ "ACOUNT = GIAOVIEN.ACOUNT where SINHVIEN.HOTEN like '%"+tenSinhVien.trim()+"' "
        								+ "and GIAOVIEN.ACOUNT like '"+gv.getAcount()+"';";
        				System.out.println(sql);
        				
        				stm = cn.createStatement();
        				rs = stm.executeQuery(sql);
        				
        				System.out.println("Thong tin sinh vien ban muon da tim kiem");
        				
        				while (rs.next()) {
        					
        					System.out.printf("\tID: "+rs.getString(1).trim()+"\tHo ten: "+rs.getString(2).trim()
        							+"\tEmail: "+rs.getString(3).trim()+"\tLop: "+rs.getString(4).trim()+"\tSDT: "
        							+rs.getString(5).trim()+"\tGhi chu: "+rs.getString(6).trim()+"\n");
        					
        				}
					} catch (Exception e) {
						System.out.println("Tim kiem that bai");
						e.printStackTrace();
					}
        			
        			
        		}break;
        		
        		case 2: {
        			System.out.println("Nhap email sinh vien ban muon tim kiem!");
        			String emailSinhVien = new Scanner(System.in).nextLine();
        			try {
        				String sql = "select * from SINHVIEN join GIAOVIEN on SINHVIEN.ACOUNT = "
        						+ "GIAOVIEN.ACOUNT where SINHVIEN.EMAIL like '"+emailSinhVien.trim()+"'"
        								+ " and GIAOVIEN.ACOUNT like '"+gv.getAcount()+"';";
        				stm = cn.createStatement();
        				rs = stm.executeQuery(sql);
        				
        				System.out.println("Thong tin sinh vien ban muon da tim kiem");
        				
        				while (rs.next()) {
        					
        					System.out.printf("\tID: "+rs.getString(1).trim()+"\tHo ten: "+rs.getString(2).trim()
        							+"\tEmail: "+rs.getString(3).trim()+"\tLop: "+rs.getString(4).trim()+"\tSDT: "
        							+rs.getString(5).trim()+"\tGhi chu: "+rs.getString(6).trim()+"\n");
        					
        				}
					} catch (Exception e) {
						System.out.println("Tim kiem that bai");
						e.printStackTrace();
					}
        			
        			
        		}break;
        		
        		case 3: {
        			System.out.println("Nhap SDT sinh vien ban muon tim kiem!");
        			String SDT = new Scanner(System.in).nextLine();
        			try {
        				String sql = "select * from SINHVIEN join GIAOVIEN on SINHVIEN.ACOUNT = "
        						+ "GIAOVIEN.ACOUNT where SINHVIEN.SDT like '"+SDT.trim()+"' and "
        								+ "GIAOVIEN.ACOUNT like '"+gv.getAcount()+"';";
        				        				
        				stm = cn.createStatement();
        				rs = stm.executeQuery(sql);
        				
        				System.out.println("Thong tin sinh vien ban muon da tim kiem");
        				
        				while (rs.next()) {
        					
        					System.out.printf("\tID: "+rs.getString(1).trim()+"\tHo ten: "+rs.getString(2).trim()
        							+"\tEmail: "+rs.getString(3).trim()+"\tLop: "+rs.getString(4).trim()+"\tSDT: "
        							+rs.getString(5).trim()+"\tGhi chu: "+rs.getString(6).trim()+"\n");
        					
        				}
					} catch (Exception e) {
						System.out.println("Tim kiem that bai");
						e.printStackTrace();
					}
        			
        			
        		}break;
        		case 4:  {
        			showMenu();
        		} break;
        		default: {
        			System.out.println("Nhap sai, vui long nhap lai lua chon!");
        		}
        	}
        	
		} while (true);
    }
}













