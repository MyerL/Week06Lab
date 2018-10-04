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
public class LoginServlet extends HttpServlet {

    Cookie ck;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
       if(ck!=null)//if theres something in it then place it
       {
           request.setAttribute("u",ck.getValue());
           
       }
        
        
       
        if(request.getParameter("home")!=null)
            {
                HttpSession session = request.getSession();
                session.invalidate();
                request.setAttribute("error","You have successfully logged out"); 
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
         
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         
    
                   
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      
          String u = request.getParameter("u");
        String p = request.getParameter("p");
         
        if(u.equals(""))
        {
                request.setAttribute("error", "Username field is left empty");
                request.setAttribute("u", u);
                request.setAttribute("p", p);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
        
        }
        if(p.equals(""))
        {
                request.setAttribute("error", "Password field is left empty");
                request.setAttribute("u", u);
                request.setAttribute("p", p);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
        }
        else{
        User uncheckeduser = new User(u,p);
        User checkeduser =UserService.login(uncheckeduser);
        if(checkeduser==null)
        {
               request.setAttribute("u",u);
               request.setAttribute("p",p);
                request.setAttribute("error", "I do not recognize you");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else//LOG IN SUCCESS
        {
            HttpSession session = request.getSession();
            session.setAttribute("c", u);
            
            
           if(request.getParameter("checkers")!=null)
           {//CHECKED
              ck = new Cookie("u",u);
              response.addCookie(ck);
              
           }
           else
           {//NOTCHECKED
               ck.setValue("");
               ck.setMaxAge(0);
               
           }
        
           response.sendRedirect("home");
          
        }
        }
        
          
    }
}
