

package springPractice.basic;

import java.io.IOException;

import org.springframework.http.StreamingHttpOutputMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//서블릿 사용 애너테이션, name은 서블릿 이름, urlPattern은 응답받을 url명
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{ //httpServlet사용을 위해 해당 클래스 상속

	//service메서드를 사용해서  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("HelloServlet.service");
		System.out.println("request="+ request);
		System.out.println("response="+ response);
		
		String username = request.getParameter("username");
		System.out.println("username="+ username);
		
		String gugudan = request.getParameter("gugudan");
		int gugudanInt = Integer.parseInt(gugudan);
		
		String resultOfGugudan = "";
		
		for (int i=1; i < 10; i ++) {
			int a = (gugudanInt * i);
			resultOfGugudan = resultOfGugudan +"\n"+ gugudanInt + " × " + i + " = " + a;
		}
		
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("hello " + username + "\n");
		response.getWriter().write("구구단 결과는" + resultOfGugudan);
		
	}
}
