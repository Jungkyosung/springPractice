package springPractice.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import springPractice.basic.HelloData;

@WebServlet(name="requestBodyStringServlet", urlPatterns="/request-body-string")
public class RequestBodyStringServlet extends HttpServlet{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		ServletInputStream inputStream = request.getInputStream();
		System.out.println(inputStream); //문자가 아닌 인코딩 된 형식인가? (Byte 코드)
		//인코딩 된 형식을 문자형식으로 바꿔서 저장?
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println("messageBody = " + messageBody);
		
		HelloData helloData = objectMapper.readValue(messageBody,HelloData.class);
		
		System.out.println("helloData.username = " + helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());
		
		response.getWriter().write("ok");
		
	}
}
