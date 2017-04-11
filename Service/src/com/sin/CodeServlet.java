package com.sin;

import com.sin.code.CodeAnalyze;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CodeServlet")
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CodeAnalyze code = new CodeAnalyze(request.getParameter("codeType"),request.getParameter("code"));
        String result = code.runCode();
        request.setAttribute("result",result);
        System.out.println(result);
        request.getRequestDispatcher("webcontent/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
