/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PENA
 */
@WebServlet(name = "TesteJasperServlet", urlPatterns = {"/testeJasperServlet"})
public class TesteJasperServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String nomeArquivo = request.getServletContext().getRealPath("/WEB-INF/relatorios/curso_disciplina.jasper");
            Map<String, Object> parametro = new HashMap<>();
            Connection connection = Conexao.getConnection();
            parametro.put("nome_curso", "Formação Geral");

            GerenciadorImpressao gestorImpressao = new GerenciadorImpressao(nomeArquivo, parametro, connection);
            gestorImpressao.geraPDF(response.getOutputStream());
            // gestorImpressao.geraDocx(response.getOutputStream());
            //gestorImpressao.geraExcel(response.getOutputStream());

            connection.close();
        } catch (SQLException ex) {
            System.err.println("Erro com servlet a impressao! " + ex.getLocalizedMessage());

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
