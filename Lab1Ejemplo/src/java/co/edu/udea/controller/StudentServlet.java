/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.dao.StudentDaoLocal;
import co.edu.udea.model.Student;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Duban Camilo Bedoya - dcamilobj@gmail.com
 */
/*Se utiliza la siguiente anotación para dar soporte al tamaño máximo y mínimo
  de la foto puesta por el estudiante*/
 @MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
                  maxFileSize=1024*1024*50, // 50 MB
                  maxRequestSize=1024*1024*100, // 100 MB
                   location="/")
    
public class StudentServlet extends HttpServlet {

    /*Se hace un llamado al facade para poder referenciar sus métodos*/
    @EJB
    private StudentDaoLocal studentDao;
    
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

        byte[] photo = null; 
        Student student = null;
        //Tomar el botón en el que dieron clic 
        String action = request.getParameter("action");
        //Tomar id (campo obligatorio)
        String studentIdStr = request.getParameter("studentId");
        /*Se verifica que la identificación haya sido ingresada*/
        if(studentIdStr != null && !studentIdStr.equals(""))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String level = request.getParameter("level");
            System.out.println("El nombre es:" + firstName);
            System.out.println("El nombre es:" + lastName);
            if(request.getMethod().equals("POST"))
            {
                System.out.println("El nombre es adentro:" + firstName);
                Part photoPart = request.getPart("photo");
                System.out.println("Size: " + photoPart.getSize());
                //Verificar si la parte de la foto no es null
                if(photoPart.getSize() != 0)
                {
                    System.out.println("Si hay foto: " + action);
                    //Leer bytes de la parte de la foto
                    try(InputStream is = photoPart.getInputStream())
                    {
                        System.out.println("Bytes: " + is.available());
                        photo = new byte[is.available()];
                        is.read(photo);
                        is.close();
                    }
                    
                    student = new Student(studentIdStr, firstName, lastName,
                                          level,photo);
                }
                else
                {
                    System.out.println("No hay foto: " + action);
                    photo = null;
                    student = new Student(studentIdStr, firstName, lastName,
                                          level,photo);
                }
                /*Verificar el botón presionado*/
                if("Agregar".equalsIgnoreCase(action))
                {
                    System.out.println("Me vine por Add");
                   studentDao.addStudent(student);
                }
                else if("Editar".equalsIgnoreCase(action))
                {
                   studentDao.editStudent(student);
                }
                else if("Eliminar".equalsIgnoreCase(action))
                {
                   studentDao.deleteStudent(studentIdStr);
                }
                else if("Buscar".equalsIgnoreCase(action))
                {
                   studentDao.getStudent(studentIdStr);
                }
                
                //Enviar los parámetros necesarios para mostrarse en el JSP
                request.setAttribute("student", student);
                request.setAttribute("allStudents", studentDao.getAllStudents());
                //Redirigir a la página deseada
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
                
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
