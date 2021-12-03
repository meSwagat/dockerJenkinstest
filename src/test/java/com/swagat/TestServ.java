package com.swagat;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 *
 * @author swakumar
 *
 */
@WebServlet("/TestServ")
public class TestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		print(response, "Served at: ", request.getContextPath());
		print(response, "Testing at: ", InetAddress.getLocalHost().getHostName(), " with IP=", InetAddress.getLocalHost().getHostAddress(), " on Server=", System.getProperty("weblogic.Name"));
		print(response, "Testing time: ", new Date().toString(),"\n");
		
//		response.getWriter().append("-- HTTP headers --").append("\n");
//		StringBuffer headers = new StringBuffer(); 
//		Enumeration headerNames = request.getHeaderNames();
//		while(headerNames.hasMoreElements()) {
//		  String headerName = (String)headerNames.nextElement();
//		  headers.append(headerName);
//		  headers.append(": ");
//		  headers.append(request.getHeader(headerName));
//		  headers.append("\n");
//		  }
//		response.getWriter().append(headers.toString()).append("\n\n");
//
//		StringBuffer attributes = new StringBuffer(); 
//		response.getWriter().append("-- HTTP attributes --").append("\n");
//		Enumeration attributeNames = request.getAttributeNames();
//		while(attributeNames.hasMoreElements()) {
//		  String attributeName = (String)attributeNames.nextElement();
//		  attributes.append(attributeName);
//		  attributes.append(": ");
//		  attributes.append(request.getAttribute(attributeName));
//		  attributes.append("\n");
//		  }
//		response.getWriter().append(attributes.toString()).append("\n\n");
//
//		StringBuffer parameters = new StringBuffer(); 
//		response.getWriter().append("-- HTTP parameters --").append("\n");
//		Enumeration parameterNames = request.getParameterNames();
//		while(parameterNames.hasMoreElements()) {
//		  String parameterName = (String)parameterNames.nextElement();
//		  parameters.append(parameterName);
//		  parameters.append(": ");
//		  parameters.append(request.getAttribute(parameterName));
//		  parameters.append("\n");
//		  }
//		response.getWriter().append(parameters.toString()).append("\n\n");

		print(response, "\n-- HTTP headers --");
		Collections.list(request.getHeaderNames()).forEach(headerName -> print(response, headerName+":"+request.getHeader((String) headerName)));
		print(response, "\n-- HTTP attributes --");
		Collections.list(request.getAttributeNames()).forEach(attributeName -> print(response, attributeName+":"+request.getHeader((String) attributeName)));
		print(response, "\n-- HTTP parameters --");
		Collections.list(request.getParameterNames()).forEach(parameterName -> print(response, parameterName+":"+request.getHeader((String) parameterName)));
		
		print(response,"\n");
		print(response, "X-Forwarded-For, attr:", (String)request.getAttribute("X-Forwarded-For"), ", header:", request.getHeader("X-Forwarded-For"));
		print(response, "RemoteAddr: ", request.getRemoteAddr());
	}
	public void print(HttpServletResponse response, String... values){
		try {
			StringBuilder printString = new StringBuilder();
			for (String value : values) {
				printString.append(value);
			}
			response.getWriter().append(printString.toString()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
