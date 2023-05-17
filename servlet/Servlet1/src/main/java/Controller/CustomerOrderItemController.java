package Controller;


import java.io.IOException;
import java.util.List;

import Dao.Dao;
import Dto.CustomerDto;
import Dto.CustomerOrderItemDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerOrderItemController
 */
@WebServlet("/CustomerOrderItem")
public class CustomerOrderItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		List<CustomerDto> user=null;
	    	try {
	    	 user=Dao.getAllDetails()	;
	    			 } catch (Exception e) {

	    	e.printStackTrace();
	    }
	    	request.setAttribute("key", user);

	    	request.getRequestDispatcher("ViewCustomerDetails.jsp").forward(request, response);
		}
    		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    			//String id=request.getParameter("id");
    			String order_id=request.getParameter("order_id");
    			String item_name=request.getParameter("item_name");
    			String item_sku=request.getParameter("item_sku");
    			String item_rate=request.getParameter("item_rate");
    			String ordered_qty=request.getParameter("ordered_qty");
    			String order_total=request.getParameter("order_total");
    			CustomerOrderItemDto orderitemobj=new CustomerOrderItemDto(order_id, item_name, item_sku, item_rate, ordered_qty, order_total);
    			try {
    			Dao.customersorderitem(orderitemobj);
    			}catch(Exception e) {
    				System.out.println(e);
    			}
    			//response.sendRedirect("index.jsp");

    		}
    	}
