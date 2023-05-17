package Controller;

import java.io.IOException;

import Dao.Dao;
import Dto.CustomerOrderDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customerorder")
public class CustomerOderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerOderController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.sendRedirect("CustomerOrderiItem.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String id=request.getParameter("id");
		String customer_id=request.getParameter("customer_id");
		String order_no=request.getParameter("order_no");
		String order_date=request.getParameter("order_date");
		String no_of_items=request.getParameter("no_of_items");
		String order_sub_total=request.getParameter("order_sub_total");
		String order_discount=request.getParameter("order_discount");
		String order_total_amount=request.getParameter("order_total_amount");
		String payment_type=request.getParameter("payment_type");
		String delivery_date=request.getParameter("delivery_date");
		String status=request.getParameter("status");
		String created_date=request.getParameter("created_date");
		String created_by=request.getParameter("created_by");
		String modified_date=request.getParameter("modified_date");
		String modified_by=request.getParameter("modified_by");
		CustomerOrderDto orderobj=new CustomerOrderDto(customer_id, order_no, order_date, no_of_items, order_sub_total, order_discount, order_total_amount, payment_type,delivery_date,status,created_date,created_by,modified_date,modified_by);
		try {
			Dao.customerorder(orderobj);
		}catch(Exception e) {
			System.out.println(e);
		}
		doGet(request, response);
	}
}
