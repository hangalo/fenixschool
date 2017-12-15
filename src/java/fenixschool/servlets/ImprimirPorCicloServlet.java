/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.servlets;

import fenixschool.util.Conexao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author PENA
 */
@WebServlet(name = "ImprimirPorCicloServlet", urlPatterns = {"/imprimirPorCicloServlet"})
public class ImprimirPorCicloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String caminho = "/WEB-INF/relatorios/disciplina_por_ciclo.jasper";
        Connection conexao;

        ServletOutputStream outputStream = response.getOutputStream();

        //Caminho para o relatorio sem parametro
        File caminhoRelatorioSemParametros = new File(getServletConfig().getServletContext().getRealPath(caminho));

        File caminhoRelatorioComParametros = new File(getServletConfig().getServletContext().getRealPath(caminho));

        byte[] bytes;

        String comando = request.getParameter("comando");

        if (comando.equalsIgnoreCase("imprimir_ficha_sem_parametro")) {
            try {

                conexao = Conexao.getConnection();
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorioSemParametros.getPath(), new HashMap(), conexao);
                conexao.close();

                response.setContentType("/application/pdf");
                response.setContentLength(bytes.length);
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();

            } catch (IOException | JRException | SQLException ex) {

                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());

            }
        } else if (comando.equalsIgnoreCase("disciplina_por_ciclo")) {

            String ciclo = request.getParameter("ciclo");
            HashMap hashMap = new HashMap();
            hashMap.put("ciclo", ciclo);

            try {

                conexao = Conexao.getConnection();
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorioComParametros.getPath(), hashMap, conexao);
                conexao.close();

                response.setContentType("/application/pdf");
                response.setContentLength(bytes.length);
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();

            } catch (IOException | JRException | SQLException ex) {

                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());

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
