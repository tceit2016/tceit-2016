package edu.tce.it.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleAjax
 */
public class ExampleAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private UserData compData = new UserData();
	private HashMap<String,User> users = compData.getComposers();

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExampleAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
	    String targetId = request.getParameter("id");
	    StringBuffer sb = new StringBuffer();

	    if (targetId != null) {
	        targetId = targetId.trim().toLowerCase();
	    } else {
	        context.getRequestDispatcher("/error.jsp").forward(request, response);
	    }

	    boolean namesAdded = false;
	    if (action.equals("complete")) {

	        // check if user sent empty string
	        if (!targetId.equals("")) {

	            Iterator it = users.keySet().iterator();

	            while (it.hasNext()) {
	                String id = (String) it.next();
	                User user = (User) users.get(id);

	                if ( // targetId matches first name
	                     user.getFirstName().toLowerCase().startsWith(targetId) ||
	                     // targetId matches last name
	                     user.getLastName().toLowerCase().startsWith(targetId) ||
	                     // targetId matches full name
	                     user.getFirstName().toLowerCase().concat(" ")
	                        .concat(user.getLastName().toLowerCase()).startsWith(targetId)) {

	                    sb.append("<user>");
	                    sb.append("<id>" + user.getId() + "</id>");
	                    sb.append("<firstName>" + user.getFirstName() + "</firstName>");
	                    sb.append("<lastName>" + user.getLastName() + "</lastName>");
	                    sb.append("</user>");
	                    namesAdded = true;
	                }
	            }
	        }

	        if (namesAdded) {
	            response.setContentType("text/xml");
	            response.setHeader("Cache-Control", "no-cache");
	            response.getWriter().write("<users>" + sb.toString() + "</users>");
	        } else {
	            //nothing to show
	            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	        }
	    }
	    if (action.equals("lookup")) {

	        // put the target composer in the request scope to display 
	        if ((targetId != null) && users.containsKey(targetId.trim())) {
	            request.setAttribute("user", users.get(targetId));
	            context.getRequestDispatcher("/user.jsp").forward(request, response);
	        }
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
