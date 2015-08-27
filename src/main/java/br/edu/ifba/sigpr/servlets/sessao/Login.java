package br.edu.ifba.sigpr.servlets.sessao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Recupera o usuario digitado
            String login = request.getParameter("usuario");
            
            //Recupera a senha digitada
            String senha = request.getParameter("senha");
            
            //Cria uma variavel que verifica se está logado ou não
            boolean logou = false;
            
            
            if(login !=null && senha !=null){
                HttpSession sessao = request.getSession();
                
                if(login.equals("admin")&&senha.equals("12345")){    
                    sessao.setAttribute("usuario", "1");
                    logou = true;
                    response.sendRedirect("index.jsp");                    
                } else if(login.equals("professor") && senha.equals("1234")){
                    sessao.setAttribute("usuario", "2");
                    logou = true;
                    response.sendRedirect("index.jsp");
                }
            }
            if(!logou){
                response.sendRedirect("index.jsp?erro=1");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}