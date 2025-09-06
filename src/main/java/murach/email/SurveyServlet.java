package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import murach.business.User;

public class SurveyServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        
        try {
            // Get parameters
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String heardFrom = request.getParameter("heardFrom");
            String updates = request.getParameter("updates");
            String contactVia = request.getParameter("contactVia");

            // Create User object
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setHeardFrom(heardFrom);
            user.setUpdates(updates);
            user.setContactVia(contactVia);

            // Set attribute
            request.setAttribute("user", user);
            
            // Forward to JSP
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/survey.jsp");
            dispatcher.forward(request, response);
            
        } catch (ServletException | IOException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        doPost(request, response);
    }
}