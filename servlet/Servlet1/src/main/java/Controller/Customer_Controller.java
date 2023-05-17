	package Controller;

import java.io.IOException;

import Dao.Dao;
import Dto.CustomerDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Customer_Controller")
public class Customer_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Customer_Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.sendRedirect("CustomerAddress.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id=request.getParameter("id");
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String contact_person_name=request.getParameter("contact_person_name");
		String contact_person_phone=request.getParameter("contact_person_phone");
		String status=request.getParameter("status");
		String created_date=request.getParameter("created_date");
		String created_by=request.getParameter("created_by");
		String modified_date=request.getParameter("modified_date");
		String modified_by=request.getParameter("modified_by");
		System.out.println("customers......");
		CustomerDto userobj=new CustomerDto(name, code, email, phone, contact_person_name, contact_person_phone, status, created_date,created_by ,modified_date, modified_by);
	try {
		Dao.saveuser(userobj);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//doGet(request, response);

	}


}
