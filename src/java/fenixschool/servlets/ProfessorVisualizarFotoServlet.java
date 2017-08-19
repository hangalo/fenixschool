/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.servlets;

import fenixschool.util.FicheiroUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProfessorVisualizarFotoServlet", urlPatterns = {"/professorVisualizarFotoServlet"})
public class ProfessorVisualizarFotoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //Obtem o parametro ficheiro do cliente
            String ficheiro = request.getParameter("file");

            if (ficheiro == null) {
                ficheiro = FicheiroUtil.getPathPastaAplicacaoServlet(request) + "padrao.png";
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Valor Imagem>>>>>>>>>>>" + ficheiro);

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

        /*
        try {

            String separador = System.getProperty("file.separator");
            String caminhoFicheiro = "C:" + separador + "fotos" + separador;

            // File file = new File(getRealPath() + "//fotos//" + arq.getFileName());
            // Equivalente a    String caminhoFicheiro = "C:\\fotos\\";
            //Obtem o parametro ficheiro do cliente
            String ficheiroDesejado = request.getParameter("file");

            //File absolutePath = new File(caminhoFicheiro + ficheiroDesejado);
            //File absolutePath = new File(getRealPath() + "//fotos//" + ficheiroDesejado);
            File absolutePath = new File(FicheiroUtil.getPathPastaAplicacaoServlet(request) + ficheiroDesejado);

            FileInputStream fileInputStream = new FileInputStream(absolutePath);

            BufferedInputStream in = new BufferedInputStream(fileInputStream);

            if (in.available() > 0) {
                //Obtem o conteudo da imagem
                byte[] bytes = new byte[in.available()];

                in.read(bytes);
                in.close();

                // Write image contents to response
                // Escreve o conteudo na saida
                response.getOutputStream().write(bytes);
                response.getOutputStream().close();
            }
        } catch (IOException ex) {
            System.err.println("File nÃ£o encontrado:\t" + ex.getMessage());
            ex.printStackTrace(System.out);
        }
         */
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

    public String getRealPath() {
        return getServletContext().getRealPath("/");
    }
}
