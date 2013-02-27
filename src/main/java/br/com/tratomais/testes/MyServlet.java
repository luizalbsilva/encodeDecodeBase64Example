package br.com.tratomais.testes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

public class MyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private final Base64 base64 = new Base64();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String parameter = req.getParameter("tipoTraducao");
		String encodedBase64String = null;
		String decodedBase64String = null; 
		if (parameter != null ) {
			if("E".equals(parameter)){
				decodedBase64String = req.getParameter("textoPuro");
				byte[] binaryData = decodedBase64String.getBytes();
				encodedBase64String = new String(base64.encode(binaryData));
			}
			else {
				encodedBase64String = req.getParameter("textoBase64");
				byte[] binaryData = encodedBase64String.getBytes();
				decodedBase64String = new String(base64.decode(binaryData));
			}
		}
		req.setAttribute("textoBase64", encodedBase64String);
		req.setAttribute("textoPuro", decodedBase64String);				
		System.out.println("Ta rodando mesmo !!!");
		req.getRequestDispatcher("mostra.jsp").forward(req, resp);
	}
}
