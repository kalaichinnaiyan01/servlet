package Controller;

import java.io.IOException;

import Dao.Dao;
import Dto.CustomerAddressDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address")
public class CustomerAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerAddressController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("CustomerOrder.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Customer_id=request.getParameter("customer_id");
		String address_type=request.getParameter("address_type");
		String address_line1=request.getParameter("address_line1");
		String  address_line2=request.getParameter("address_line2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String postal_code=request.getParameter("postal_code");
		CustomerAddressDto address=new CustomerAddressDto(Customer_id,address_type, address_line1, address_line2, city, state, country, postal_code);
		try {
			Dao.customers_address(address);
		}catch(Exception e) {
			System.out.println(e);
		}
		doGet(request, response);
	}

}
