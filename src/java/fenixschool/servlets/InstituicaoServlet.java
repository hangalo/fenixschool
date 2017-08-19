/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.servlets;

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
@WebServlet(name = "InstituicaoServlet", urlPatterns = {"/instituicaoServlet"})
public class InstituicaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String separador = System.getProperty("file.separator");
            String caminhoAbsoluto = "C:" + separador + "fotos" + separador;

            //obter o paramero do ficheiro;
            String ficheiro = request.getParameter("ficheiro");
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(caminhoAbsoluto + ficheiro));

            //obter o conteudo da imagem
            byte[] foto = new byte[in.available()];
            in.read();
            in.close();

            //Escreve o conteudo 
            response.getOutputStream().write(foto);

        } catch (IOException e) {
            System.err.println("Ficheiro nao encontrado. " + e.getLocalizedMessage());
            e.printStackTrace(System.out);
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
