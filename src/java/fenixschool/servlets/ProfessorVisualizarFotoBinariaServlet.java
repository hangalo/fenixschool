/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.servlets;

import fenixschool.dao.ProfessorDAO;
import fenixschool.util.FicheiroUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author informatica
 */
@WebServlet(name = "ProfessorVisualizarFotoBinariaServlet", urlPatterns = {"/professorVisualizarFotoBinariaServlet"})
public class ProfessorVisualizarFotoBinariaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpg; image/png");
        
        ProfessorDAO professorDAO = new ProfessorDAO();
        
        int idImagem = Integer.parseInt(request.getParameter("file"));
        
        byte[] imagem = professorDAO.recuperarImagem(idImagem);

        if (imagem == null) {
            imagem = carregarImagemPadrao(request);
        }
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imagem);
        outputStream.flush();
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

    private byte[] carregarImagemPadrao(HttpServletRequest request) throws IOException {
        
        String caminho = getServletContext().getRealPath("/fotos/");
        
        byte byteArray[] = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(FicheiroUtil.getPathPastaAplicacaoServlet(request), "padrao.png"));
            int numeroBytes = fileInputStream.available();
            byteArray = new byte[numeroBytes];
            fileInputStream.read(byteArray);

        } catch (IOException ex) {
        } finally {
            fileInputStream.close();
        }
        return byteArray;
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
