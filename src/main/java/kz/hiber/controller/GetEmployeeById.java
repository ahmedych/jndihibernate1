package kz.hiber.controller;

import kz.hiber.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetEmployeeById extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int empId=1;
        if(req.getParameter("empId")!=null)
                     empId= Integer.parseInt(req.getParameter("empId"));
        System.out.println("Request parameter empId= " + empId);
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, empId);
        transaction.commit();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if (employee != null) {
            out.print("<html><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>Employee ID</th>");
            out.print("<th>Employee Name</th>");
            out.print("<th>Employee Role</th>");

            out.print("<tr>");
            out.print("<td>" + empId + "</td>");
            out.print("<td>" + employee.getName() + "</td>");
            out.print("<td>" + employee.getRole() + "</td>");
            out.print("</tr>");
            out.print("</table></body><br/>");

            out.print("</html>");
        } else {
            out.print("<html><body><h2>No Employee Found with ID=" + empId + "</h2></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

