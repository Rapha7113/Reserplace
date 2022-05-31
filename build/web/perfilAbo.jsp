<%-- 
    Document   : perfilAbo
    Created on : 25/05/2022, 12:54:14 PM
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@page session="true"%>
<!DOCTYPE html>
    <% 
    Abogado x=DaoAbogado.Datos(Integer.parseInt(request.getParameter("id")));
    %>


<%
    String usuario="";
    String correo="";
    HttpSession sesionOk=request.getSession();
    if(sesionOk.getAttribute("usuario")==null){
    %>
    <jsp:forward page="pag_login.jsp">
        <jsp:param name="msg2" value="Debe Loguarse para Ingresar"/>
    </jsp:forward>
    <%
        }else{
         usuario=(String)sesionOk.getAttribute("usuario");
         correo=(String)sesionOk.getAttribute("E_mail");
    }
    %>
<html lang="en">
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Reserplace</title>
 
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/dt-1.12.1/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs5/dt-1.12.1/datatables.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=League+Spartan:wght@300;600&display=swap" rel="stylesheet">
        <link href="css/Principal.css" rel="stylesheet" />
        <script src="js/scripts.js"></script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-dark" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light"><img src="imagenes/logo2.png"></div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="">Lista Producto</a>
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="ServletContAbo?opcion=nombres">Abogados</a>
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="">Lista de Laboratorios</a>
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="#!">Stock de Productos</a>
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="#!">Ventas</a>
                    <a class="list-group-item list-group-item-action list-group-item-primary p-3" href="#!">Reportes</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
            <nav class="navbar navbar-expand-lg navbar-light bg-dark border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">Desplegar Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link text-light" href="#!">Home</a></li>
                                <li class="nav-item"><a class="nav-link text-light" href="#!">Link</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle text-light" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Hola,<%=usuario%></a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="ServletCliente?ope=cerrar">Cerrar Sesion</a>                                   
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <main class="mt-2 pt-1">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-12 mt-1 text-center text-primary fw-bold h4">
                <i>Perfil Abogado</i>  </div>
            </div>
             
                <div class="row">
                            <div class="col-sm-3">
                                <div class="card">                                   
                                    <div class="card-body">
         <form method= action=""> 
        <table border="0" width="700" align="center">
                <tr>
                    <th rowspan="9"><img src="imagenes/abogados/<%=x.getFoto()%>" width=210 height="180"></th>
                    <th> Nombre y Apellido :</th>
                    <th> <input type="text" name="" value="<%=x.getNomA()%>" readonly="" class="border-0"></th>
                </tr><tr><th> Especialidad :</th>
                     <th><input type="text" name="" value="<%=x.getEsp()%>" readonly="" class="border-0"></th>
                </tr><tr><th>Años experiencia :</th>
                    <th><input type="text" name="" value="<%=x.getExp()%> años" readonly="" class="border-0"></th>
                </tr><tr><th> Grado Academico :</th>
                     <th><input type="text" name="" value="<%=x.getGrado()%>" readonly="" class="border-0"></th>
                </tr><tr><th>Telefono :</th>
                     <th><input type="text" name="" value="<%=x.getTelf()%>" readonly="" class="border-0"></th>
                </tr><tr><th>Correo :</th>
                     <th><input type="text" name="" value="<%=x.getCorreo()%>" readonly="" class="border-0"></th>
                </tr>
                <tr><th>Curriculum Vitae :</th>
                    <td><a href="" class="text-decoration-none">Descargar CV</a></td>
                </tr>
                <tr><th>Linkedin :</th>
                    <td><a href="" class="text-decoration-none">linkedin.com/in/<%=x.getNomA()%></a></td>
                </tr>
                
              
        </table> 
                <input type="hidden" name="accion" value="ReaReserva">
        </form>  
                                        
                                    </div>
                                    <div class="card-footer text-center bg-light" >
                                         <div>
                                           <a href="" class="btn btn-primary btn-sm active " role="button">Realizar Reservacion</a>

                                         </div>
                                    </div>
                                </div>
                            </div>  
              
              
              
              
                          
            </div>
                </main>
                                    
        </div>
</div>
    </body>
</html>
    
    
