package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import models.User;
import models.UserService;


/**
 *
 * @author awarsyle
 */
public class HomeServlet extends HttpServlet {

String g;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       
       
          HttpSession session = request.getSession();
         g=(String) session.getAttribute("c");
          if(g==null)//NO USER LOGGED IN
          {
//              request.setAttribute("error","u werent logged in"); 
                response.sendRedirect("login");
              
                
                
          }
          else{
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
       
          }
                   
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      
        
          
    }
}
