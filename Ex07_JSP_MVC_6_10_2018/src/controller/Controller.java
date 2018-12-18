package controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Baohiem;
import object.Khachhang;
import object.Oto;

@WebServlet("/index.html")
public class Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		if (XuLyDangNhap(name, pass, type)) {
			
			HienThiView(req, resp, type);
			
		} else {
			req.setAttribute("err", "Đăng nhập thất bại");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	public void HienThiView(HttpServletRequest req, HttpServletResponse resp, String type) throws ServletException, IOException {
		
		if(type.equalsIgnoreCase("manage")) {
			String sql = "Select top 30 * from oto";
			req.setAttribute("listOto", LayDuLieuOto(sql));
			req.getRequestDispatcher("view.jsp").forward(req, resp);
		} else {
			req.setAttribute("listKhachhang", LaydulieuKhachhang());
			req.getRequestDispatcher("view3.jsp").forward(req, resp);
		}
		
		
	}

	Connection conn = null;

	public Connection getConnection() {
		try {

			String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QLBH";
			String user = "sa";
			String pass = "aaa";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(url, user, pass);

			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.out.println("Ket noi that bai");

			e.printStackTrace();
		}
		return conn;
	}

	Connection cn;
	Statement stm;
	ResultSet rs;

	Oto oto = new Oto();
	Khachhang kh = new Khachhang();
	Baohiem bh = new Baohiem();
	ArrayList<Khachhang> list3 = new ArrayList<Khachhang>();
	ArrayList<Baohiem> list2 = new ArrayList<Baohiem>();
	ArrayList<Oto> list = new ArrayList<Oto>();

	public void ThemDuLieuOto(String carCode, String hangXe, String loaixe, float gia, int namSX, int soluong, String packagetype) {
		try {

			String sql = "Insert into oto(carCode, hangXe, cartype, gia, namSX, soluong, packagetype)" + "values ('" + carCode
					+ "','" + hangXe + "','" + loaixe + "','" + gia + "','" + namSX + "','" + soluong + "','" + packagetype + "')";
			System.out.println(sql);

			cn = getConnection();

			stm = cn.createStatement();
			rs = stm.executeQuery(sql);

		} catch (Exception e) {
		}
	}

	public void XoaDuLieuOto(String carCode) {
		try {
			String sql = "delete from oto where carCode = '" + carCode + "'";
			

			cn = getConnection();

			stm = cn.createStatement();
			rs = stm.executeQuery(sql);

		} catch (Exception e) {
		}
	}

	public ArrayList<Oto> LayDuLieuOto(String sql) {
		list.clear();
		try {
			
			cn = getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			list = new ArrayList<Oto>();
			

			while (rs.next()) {
				oto = new Oto();
				oto.setMaXe(rs.getString(1));
				oto.setHangXe(rs.getString(2));
				oto.setLoaixe(rs.getString(7));
				oto.setGiaXe(rs.getFloat(3));
				oto.setNamSx(rs.getInt(4));
				oto.setSoLuong(rs.getInt(5));
				if (rs.getString(6) == null) {
					oto.setBaoHiem("null");
				} else {
					oto.setBaoHiem(rs.getString(6));
				}

				list.add(oto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Baohiem> LayDuLieuBaohiem() {
		try {
			String sql = "Select * from packagecartype";
			cn = getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			list2 = new ArrayList<Baohiem>();

			while (rs.next()) {
				bh = new Baohiem();

				bh.setPackagecartype(rs.getString(1));
				bh.setCartype(rs.getString(2));

				list2.add(bh);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return list2;
	}
	
	public ArrayList<Khachhang> LaydulieuKhachhang() {
		
		try {
			String sql = "select * from CUS_CAR where CUS_CAR.cusCode = '"+cusCode+"'";
			
			System.out.println(sql);
			
			cn = getConnection();
			ResultSet rs;
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				kh = new Khachhang();
				kh.setCarCode(rs.getString(2));
				kh.setPackagetype(rs.getString(3));
				kh.setCartype(rs.getString(4));
				list3.add(kh);
			}
			
		} catch (Exception e) {
		}
		return list3;
	}

	public void Update(String maxe, String hangxe, float giaxe, int namsx, String baohiem, int soluong) {
		String sql;
		try {

			if (baohiem == "null") {
				sql = "Update oto set hangXe='" + hangxe + "',gia='" + giaxe + "',namSX='" + namsx
						+ "',packagetype=null,soluong='" + soluong + "' where carCode='" + maxe + "'";
			} else {
				sql = "Update oto set hangXe='" + hangxe + "',gia='" + giaxe + "',namSX='" + namsx + "',packagetype='"
						+ baohiem + "',soluong='" + soluong + "' where carCode='" + maxe + "'";
			}

			cn = getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {

		}
	}

	public void Thembaohiem(String tengoi, String loaixe, int namsx) {
		try {
			String sql = "insert into packagecartype(packagetype,cartype, namSX)" + "values ('" + tengoi + "','" + loaixe
					+ "','"+namsx+"');";
			System.out.println(sql);
			
			cn = getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {

		}
	}
	
	String cusCode;

	public boolean XuLyDangNhap(String name, String pass, String type) {
		boolean flag = true;
		String sql;

		try {
			
			if(type.contentEquals("manage")) {
				sql = "select * from MANAGER";
			} else {
				sql = "select * from CUSTOMER";
			}
			
			cn = getConnection();
			
			ResultSet rs;
			
			stm = cn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				cusCode = rs.getString(1).trim();
				if (name.equalsIgnoreCase(rs.getString(2).trim()) && pass.equalsIgnoreCase(rs.getString(3).trim())) {
					System.out.println("Dang nhap thanh cong");					
					flag = true;
					return flag;
				} else {
					flag = false;
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}
}
