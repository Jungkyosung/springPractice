package springPractice.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import springPractice.basic.HelloData;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		response.setHeader("content-type", "application/json");
		response.setCharacterEncoding("utf-8");
		
		HelloData data = new HelloData();
		data.setUsername("kim");
		data.setAge(22);
		
		String result = objectMapper.writeValueAsString(data);
		
		response.getWriter().write(result);
		
	}
	
}
