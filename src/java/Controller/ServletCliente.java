/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Cliente;
import Modelo.DAOcliente;
import Utils.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andre
 */
public class ServletCliente extends HttpServlet {
      DAOcliente dc = new DAOcliente();
      Cliente cl=new Cliente();
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String op=request.getParameter("ope");
        if(op.equals("login")){
        String usu=request.getParameter("txtCorreo");
        String pas=request.getParameter("txtPass");
        
            try {
                PreparedStatement psta=ConexionDB.getConexion()
                        .prepareStatement("Select * from cliente where E_mail=? and contraseña=?");
                psta.setString(1, usu);
                psta.setString(2, pas);
                ResultSet rs=psta.executeQuery();
                if (rs.next()){
                    HttpSession sesionOk=request.getSession();
                    sesionOk.setAttribute("usuario",rs.getString(2).toString());
                    sesionOk.setAttribute("E_mail",rs.getString(4).toString());
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                }else{
                request.setAttribute("msj","Usuario Incorrecto");
                request.getRequestDispatcher("pag_login.jsp").forward(request, response);
                }
            } catch (Exception e) { System.out.println("Error"+e);}
            }else if(op.equals("cerrar")){
            HttpSession sesionOk=request.getSession();
            sesionOk.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            } }
 
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
        processRequest(request, response);
        
                String accion = request.getParameter("accion");
                if (accion.equals("GuardarCli")) {               
                    String noap = request.getParameter("txtnoap");
                    String sexo=request.getParameter("RB1");
                    String correo = request.getParameter("txtcorreo");
                    String pass = request.getParameter("txtpass");
                    cl.setNomap(noap);
                    cl.setSexo(sexo);
                    cl.setCorreo(correo);
                    cl.setPassword(pass);
                    dc.agregarCli(cl);
                    request.getRequestDispatcher("pag_login.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } 
}
