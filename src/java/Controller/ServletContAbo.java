/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Abogado;
import Utils.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
public class ServletContAbo extends HttpServlet {

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
        processRequest(request, response);        
         String opcion=request.getParameter("opcion");         
         if(opcion.equals("nombres")){
            try {
                PreparedStatement psta=ConexionDB.getConexion()
                        .prepareStatement("select DISTINCT especialidad from abogado");
                ResultSet rs=psta.executeQuery();                
                ArrayList<Abogado> p=new ArrayList();
                
                while(rs.next()){
            Abogado e=new Abogado(rs.getString(1));
            p.add(e); 
            }
                request.setAttribute("a",p);
                request.getRequestDispatcher("Abogado_lis.jsp").forward(request, response);
            } catch (Exception e) {
            }
        }else if(opcion.equals("consultaAbo")){
            
            String nom=request.getParameter("selectAbo");
            try {
                PreparedStatement psta=ConexionDB.getConexion()
                        .prepareStatement("select * from abogado where especialidad=?");
                psta.setString(1,nom); 
                ResultSet rs=psta.executeQuery();
                ArrayList<Abogado> p=new ArrayList();
                
                    while(rs.next()){
            Abogado e=new Abogado(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
            
            p.add(e); 
            }
                request.setAttribute("z",p);
                request.getRequestDispatcher("Resultado.jsp").forward(request, response);
                
            } catch (Exception e) {
            }
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
    }// </editor-fold>

}
