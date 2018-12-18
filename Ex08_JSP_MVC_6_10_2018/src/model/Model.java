package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import object.Baohiem;
import object.Oto;

@WebServlet("/view.html")
public class Model extends HttpServlet {

	public Model() {

	}

	Oto o = new Oto();
	Baohiem bh = new Baohiem();
	Controller conl = new Controller();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String st = req.getParameter("act").trim();
		String t = req.getRequestURL().toString();
		System.out.println(t);

		System.out.println(st);

		if (st.equalsIgnoreCase("insert")) {
			o = new Oto();
			o.setMaXe(req.getParameter("maxe"));
			o.setHangXe(req.getParameter("hangxe"));
			o.setGiaXe(Float.parseFloat(req.getParameter("giaxe")));
			o.setNamSx(Integer.parseInt(req.getParameter("namsanxuat")));
			int nam = Integer.parseInt(req.getParameter("namsanxuat"));
			o.setBaoHiem(req.getParameter("goibaohiem"));
			if(nam <= 1995) {
				o.setLoaixe("OldCar");
			} else if(nam> 1995 && nam < 2005) {
				o.setLoaixe("MediumCar");
			} else {
				o.setLoaixe("ModernCar");
			}
			o.setSoLuong(Integer.parseInt(req.getParameter("soluong")));

			conl = new Controller();

			conl.ThemDuLieuOto(o.getMaXe(), o.getHangXe(),o.getLoaixe(), o.getGiaXe(), o.getNamSx(), o.getSoLuong(), o.getBaoHiem());
			String sql = "select * from Oto";
			req.setAttribute("listOto", conl.LayDuLieuOto(sql));

			req.getRequestDispatcher("view.jsp").forward(req, resp);
		} else if (st.equalsIgnoreCase("delete")) {
			String maxe = req.getParameter("maxe");
			System.out.println(maxe);
			conl = new Controller();
			conl.XoaDuLieuOto(maxe);
			String sql = "select * from Oto";
			req.setAttribute("listOto", conl.LayDuLieuOto(sql));

			req.getRequestDispatcher("view.jsp").forward(req, resp);
		} else if (st.equalsIgnoreCase("update")) {

			req.setAttribute("maxe", req.getParameter("maxe"));
			req.setAttribute("hangxe", req.getParameter("hangxe"));
			req.setAttribute("giaxe", req.getParameter("giaxe"));
			req.setAttribute("namsx", req.getParameter("namsx"));
			req.setAttribute("baohiem", req.getParameter("baohiem"));
			req.setAttribute("soluong", req.getParameter("luong"));

			req.getRequestDispatcher("update.jsp").forward(req, resp);

		} else if (st.equalsIgnoreCase("updateform")) {

			String maxe = req.getParameter("maxe");
			System.out.println(maxe);
			o = new Oto();
			o.setMaXe(req.getParameter("maxe"));
			o.setHangXe(req.getParameter("hangxe"));
			o.setGiaXe(Float.parseFloat(req.getParameter("giaxe")));
			o.setNamSx(Integer.parseInt(req.getParameter("namsx")));
			System.out.println(req.getParameter("baohiem"));
			if (req.getParameter("baohiem") == "") {
				o.setBaoHiem("null");
			} else {
				o.setBaoHiem(req.getParameter("baohiem"));
			}
			o.setSoLuong(Integer.parseInt(req.getParameter("soluong")));

			conl = new Controller();
			
			conl.Update(o.getMaXe().trim(), o.getHangXe().trim(), o.getGiaXe(), o.getNamSx(), o.getBaoHiem().trim(),
					o.getSoLuong());
			String sql = "select * from Oto";
			req.setAttribute("listOto", conl.LayDuLieuOto(sql));

			req.getRequestDispatcher("view.jsp").forward(req, resp);
		} else if(st.equalsIgnoreCase("qlbh")) {
			req.getRequestDispatcher("view2.jsp").forward(req, resp);
		} else if(st.equalsIgnoreCase("thembaohiem")) {
			bh = new Baohiem();
			bh.setPackagecartype(req.getParameter("tengoi"));
			int nam = Integer.parseInt(req.getParameter("namsx"));
			bh.setNamsx(Integer.parseInt(req.getParameter("namsx")));
			if (nam <= 1995) {
				bh.setCartype("OldCar");
			} else if(nam> 1995 && nam < 2005) {
				bh.setCartype("MediumCar");
			} else {
				bh.setCartype("ModernCar");
			}
			
			conl = new Controller();
			conl.Thembaohiem(bh.getPackagecartype(), bh.getCartype(), bh.getNamsx());
			
			req.getRequestDispatcher("view2.jsp").forward(req, resp);
		} else if(st.equalsIgnoreCase("mua")) {
			conl = new Controller();
		} else if(st.equalsIgnoreCase("goback")) {
			String sql = "select * from Oto";
			req.setAttribute("listOto", conl.LayDuLieuOto(sql));
			req.getRequestDispatcher("view.jsp").forward(req, resp);
		} else if(st.equalsIgnoreCase("hienthigioihan")) {
			String sl = req.getParameter("soluonghienthi");
			String sql;
			if(sl == "") {
				sql = "select * from oto";
			} else {
				sql = "select top "+sl+" * from oto";
			}
			req.setAttribute("listOto", conl.LayDuLieuOto(sql));
			req.getRequestDispatcher("view.jsp").forward(req, resp);
		}
	}
}
