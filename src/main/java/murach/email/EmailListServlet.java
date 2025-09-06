package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.User;

public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL
        if (action.equals("join")) {
            url = "/index.html";    
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String heardFrom = request.getParameter("heardFrom");
            String updates = request.getParameter("updates");
            String contactVia = request.getParameter("contactVia");

            // store data in User object
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setHeardFrom(heardFrom);
            user.setUpdates(updates);
            user.setContactVia(contactVia);

            // set User object in request
            request.setAttribute("user", user);
            
            // Thay đổi URL forward đến survey.jsp thay vì thanks.jsp
            url = "/survey.jsp";   // the survey results page
        }
        
        // forward request
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        doPost(request, response);
    }    
}