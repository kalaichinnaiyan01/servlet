package Controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Connection.dp;
import Dao.Dao;
import Dto.CustomerDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Update5Customer
 */
@WebServlet("Update5Customer")
public class Update5Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update5Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
        PreparedStatement pstmt = null;

	  int numRowsUpdated = 0;
	try {
    	conn = dp.getConnection();

        String sql = "UPDATE tb_Customer_kalai SET status = 'Deleted'"
                   + " WHERE status = 'Active'";
        pstmt = conn.prepareStatement(sql);
        numRowsUpdated = pstmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();

	}


    List<CustomerDto> user=null;
	try {
	 user=Dao.getAllDetails();
} catch (Exception e) {

	e.printStackTrace();
}
	request.setAttribute("key", user);

	request.getRequestDispatcher("update5Customer.jsp").forward(request, response);

}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
