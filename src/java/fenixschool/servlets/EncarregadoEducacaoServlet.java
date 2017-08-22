/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.servlets;

import fenixschool.util.FicheiroUtil;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PENA
 */
@WebServlet(name = "EncarregadoEducacaoServlet", urlPatterns = {"/encarregadoEducacaoServlet"})
public class EncarregadoEducacaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //Obtem o parametro ficheiro do cliente
            String ficheiro = request.getParameter("file");

            if (ficheiro == null) {
                ficheiro = FicheiroUtil.getPathPastaAplicacaoServlet(request) + "padrao.png";
            }

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(FicheiroUtil.getPathPastaAplicacaoServlet(request) + ficheiro));

//Obtem o conteudo da imagem
            if (in.available() > 0) {
                byte[] bytes = new byte[in.available()];
                in.read(bytes);
                in.close();

                // Write image contents to response
                // Escreve o conteudo na saida
                response.getOutputStream().write(bytes);
            }
        } catch (IOException ex) {
            System.err.println("Ficheiro nao encontraro:\t" + ex.getMessage());
            ex.printStackTrace(System.out);
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
