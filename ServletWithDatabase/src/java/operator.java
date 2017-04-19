/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
@WebServlet(urlPatterns = {"/operator"})
public class operator extends HttpServlet {

    PreparedStatement ps;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet operator</title>");            
            out.println("</head>");
            out.println("<body>");
            String opr = request.getParameter("sbt").toString();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/stud","saurabh","saurabh");
            System.out.println("Connected");
            if(opr.equals("insert")){
                ps = conn.prepareStatement("insert into info values(?,?,?)");
                String roll = request.getParameter("roll");
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                
                ps.setInt(1, Integer.parseInt(roll));
                ps.setString(2, fname);
                ps.setString(3, lname);
                ps.execute();
                
                out.print("<h1>Inserted</h1>");
                
            }else if(opr.equals("select")){
                int roll = Integer.parseInt(request.getParameter("roll"));
                ps = conn.prepareStatement("select * from info where roll = ?");
                ps.setInt(1, roll);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    out.print("<h1>"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+"</h1>");
                }
            
            }else if(opr.equals("update")){
                int roll = Integer.parseInt(request.getParameter("roll"));
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                ps = conn.prepareStatement("update info set fname = ?, lname = ? where roll = ?");
                
                ps.setString(1,fname);
                ps.setString(2, lname);
                ps.setInt(3, roll);
                ps.executeUpdate();
                out.print("<h1>Updated</h1>");
                
                
            
            }else if(opr.equals("delete")){
                int roll = Integer.parseInt(request.getParameter("roll"));
                ps = conn.prepareStatement("delete from info where roll = ?");
                ps.setInt(1, roll);
                ps.execute();
                out.print("<h1>Deleted</h1>");
                
                
            }
            
            out.println("<h1></h1>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex){
            System.out.println("" + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(operator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(operator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(operator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(operator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
