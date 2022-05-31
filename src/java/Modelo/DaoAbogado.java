/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Utils.ConexionDB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class DaoAbogado {
 
   public static ArrayList<Abogado>obtenerA(){

    ArrayList<Abogado>Lista = new ArrayList<>();
        try {
            CallableStatement cl=ConexionDB.getConexion().prepareCall("{call listarAbogados()}");
            ResultSet rs=cl.executeQuery();
            while (rs.next()){
            Abogado a= new Abogado(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
            Lista.add(a);                  
        }
        } catch (Exception e) {
        }
         return Lista;
 } 
   
   public static Abogado Datos(int codigo){
   Abogado abo=null;
       try {
           CallableStatement cl=ConexionDB.getConexion().prepareCall("{CALL sp_Abogado(?)}");
           cl.setInt(1,codigo);
           ResultSet rs = cl.executeQuery();
           while(rs.next()){
           abo =new Abogado(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));}
       } catch (Exception e) {}  
   return abo;
   }
}
