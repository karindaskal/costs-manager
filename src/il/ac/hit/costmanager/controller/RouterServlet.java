package il.ac.hit.costmanager.controller;



import javax.servlet.*;

import javax.servlet.http.*;

import il.ac.hit.costmanager.model.IModel;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;
/**
 * Karin Daskal 208511659
 * lilach louz 315903179
 */

/**
 * Servlet get  all the request and send to the appropriate function
 */

public class RouterServlet extends HttpServlet {
	

    private String pkg;

    /*
    Each request's URL will include the controller name and the
    action name (in that specific controller) at which the request
    targets.

    e.g.
    http://localhost:8080/mvcdemo/router/admin/addproduct
    http://localhost:8080/mvcdemo/router/admin/deleteproduct
    http://localhost:8080/mvcdemo/router/admin/updateproduct
    http://localhost:8080/mvcdemo/router/user/products
    http://localhost:8080/mvcdemo/router/user/products/345344

     */

    @Override
    public void init() {
        pkg = getServletConfig().getInitParameter("package");
      
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  System.out.print(pkg);
        String text = request.getRequestURI();
        PrintWriter writer = response.getWriter();
        String[]  arr = text.split("/");
        String controller = "user";
        String action = "index";
        if(arr.length>3) {
            controller = arr[3];
            if(controller.equals("*")) {
                controller = "user";
            }
        }

        if(arr.length>4) {
            action = arr[4].toLowerCase();
        }

        //writer.println("controller=" + controller + " action=" + action);
        //writer.println(text);

        try {
            // calling the right action on the right controller
            String className = pkg + "." + controller.substring(0, 1).toUpperCase() + controller.substring(1).toLowerCase() + "Controller";
            Class clazz = Class.forName(className);
			
			 Constructor constructor = clazz.getConstructor(IModel.class);
	            //constructor.newInstance(com.example.mvcdemo.model.SimpleVirtualProductsDAO.getInstance());
	            Object object = constructor.newInstance(il.ac.hit.costmanager.model.SqlModel.getInstance());
	            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class );
	            //method.invoke(request,response);
	       	 System.out.println("dsfdfsd");

	            method.invoke(object,request,response);

	            //forwarding the execution to the view (identical in its name to the action)
	            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(action+".jsp");
	            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(action+".jsp");
				/*
				 * RequestDispatcher dispatcher =
				 * getServletContext().getRequestDispatcher("/views/user/"+action+".jsp");
				 * dispatcher.forward(request,response);
				 */
			 

        } catch(ClassNotFoundException e) { 
        	response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, action);
            //showErrorMessage(request,response,e.toString());
        } catch(NoSuchMethodException e) {
        	    	 	
       
      	response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, action);
        } catch (InvocationTargetException e) {
        	System.out.println(e.getCause().toString());
        	
        
        	response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getCause().toString());
        } catch (InstantiationException e) {        	     	
          
      	response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, action);
        } catch (IllegalAccessException e) {
        	   	
         
      	response.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR, action);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void showErrorMessage(HttpServletRequest request, HttpServletResponse response,String text) throws ServletException, IOException {
        request.setAttribute("errormessage",text);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
        dispatcher.forward(request,response);
    }
}
