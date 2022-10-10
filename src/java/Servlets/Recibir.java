/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Cifrado_DES.Cifrado;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author gussr
 */
@MultipartConfig
public class Recibir extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Recibir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Recibir at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        PrintWriter out = response.getWriter();
        Part a = request.getPart("archivo");
        Cifrado des = new Cifrado();
        String clave = request.getParameter("clave");
        if(a.getSize()==0 || clave.length()!=8){
            request.setAttribute("error","Introduzca archivo y clave.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
         InputStream in= a.getInputStream();
         File archivo = new File(in.toString());
         String nameFi = archivo.getName();
         FileOutputStream outS = new FileOutputStream(archivo);
         int dato = in.read();
         String opcion = request.getParameter("btn_cifrar");
         out.println(opcion);
         while(dato !=-1){
         out.write(dato);
         dato = in.read();
         }
         if(opcion.equals("true")){
            String re="";
            File encriptado = new File("Downloads\\cifrado.txt"); 
            try{
            re =des.Cifrar(encriptado, clave);
            }catch(Exception e){
                System.out.println(e);
            }
            out.println(re);
            out.close();
            in.close();
         }
         String re = "";
         File descifrado = new File("Downloads\\descifrado.txt");
         try{
         re = des.Descifrar(descifrado,clave);
         }catch(Exception e){
         out.println(e);
         }
         out.println(re);
            out.close();
            in.close();
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
