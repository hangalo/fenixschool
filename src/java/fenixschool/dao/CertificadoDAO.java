/*
 * To change this license header, choose License Headers in Project Propertie
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.Certificado;
import fenixschool.modelo.Funcionario;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aisha Lubadika
 */
public class CertificadoDAO  implements GenericoDAO<Certificado>{
     private static final String INSERIR ="INSERT INTO certificado (id_certificado, data_certificado, id_funcionario, id_aluno, id_ano_curricular, texto_certificado) VALUES (id_certificado=?, data_certificado=?, id_funcionario=?,id_aluno=?,id_ano_curricular=?,texto_certificado=?)";
     private static final String ACTUALIZAR ="UPDATE certificado SET id_certificado =?, data_certificado` =?, id_funcionario` = ?, id_aluno = ?, id_ano_curricular = ?, texto_certificado = ? WHERE id_certificado=?";
     private static final String ELIMINAR ="DELETE FROM certificado WHERE id_ceriticado=?";
     private static final String BUSCAR_POR_CODIGO ="SELECT id_certificado c, data_certificado c, id_funcionario f, id_aluno a, id_ano_curricular an, texto_certificado c FROM certificado c INNER JOIN id_funcionario f ON c.id_funcionario=f.id_funcionario INNER JOIN id_aluno a ON c.id_aluno=a.id_aluno INNER JOIN id_ano_curricular an ON c.id_ano_curricular=an.id_ano_curricular WHERE c.id_certificado=?";
     private static final String LISTAR_TUDO ="SELECT id_certificado c, data_certificado c, id_funcionario f, id_aluno a, id_ano_curricular an, texto_certificado c FROM certificado c INNER JOIN id_funcionario f ON c.id_funcionario=f.id_funcionario INNER JOIN id_aluno a ON c.id_aluno=a.id_aluno INNER JOIN id_ano_curricular an ON c.id_ano_curricular=an.id_ano_curricular";
    
    
     @Override
    public void save(Certificado certificado) {
        PreparedStatement ps = null;
        Connection conn = null;
         if (certificado == null) {
             System.out.println("O valor passado não pode ser nulo");
             
        }
         try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, certificado.getIdCertificado());
         
            ps.setDate(2, new java.sql.Date(certificado.getDataCertificado().getTime()));
            ps.setInt(3, certificado.getIdAluno().getIdAluno());
            ps.setInt(4, certificado.getIdFuncionario().getIdFuncionario());
            ps.setInt(5, certificado.getIdAnoCurricilar().getIdAnoCurricular());
            ps.setString(6,certificado.getTextoCertificado());
         } catch (Exception e) {
              System.out.println("Erro ao inserir dados: " + e.getMessage());
         }
         finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Certificado certificado) {
         PreparedStatement ps = null;
        Connection conn = null;
         if (certificado == null) {
             System.out.println("O valor passado não pode ser nulo");
             
        }
         try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, certificado.getIdCertificado());
            ps.setDate(2, new java.sql.Date(certificado.getDataCertificado().getTime()));
            ps.setInt(3, certificado.getIdAluno().getIdAluno());
            ps.setInt(4, certificado.getIdFuncionario().getIdFuncionario());
            ps.setInt(5, certificado.getIdAnoCurricilar().getIdAnoCurricular());
            ps.setString(6,certificado.getTextoCertificado());
            
         } catch (Exception e) {
              System.out.println("Erro ao actualizar dados: " + e.getMessage());
         }
         finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Certificado certificado) {
         PreparedStatement ps = null;
        Connection conn = null;
         if (certificado == null) {
             System.out.println("O valor passado não pode ser nulo");
             
        }
         try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, certificado.getIdCertificado());
            
            
         } catch (Exception e) {
              System.out.println("Erro ao eliminar dados: " + e.getMessage());
         }
         finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Certificado findById(Integer id) {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Certificado certificado= new Certificado();
       
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(certificado, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        }finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return certificado;
    }

    @Override
    public List<Certificado> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Certificado> certificados = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Certificado certificado = new Certificado();
                popularComDados(certificado, rs);
                certificados.add(certificado);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return certificados;
    }

    @Override
    public void popularComDados(Certificado certificado, ResultSet rs) {
        try {
            certificado.setIdCertificado(rs.getInt("id_certificado"));
            certificado.setDataCertificado(rs.getDate("data_certificado"));
            
            Aluno aluno= new Aluno();
            aluno.setIdAluno(rs.getInt("id_aluno"));
            certificado.setIdAluno(aluno);
           
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            certificado.setIdFuncionario(funcionario);
            AnoCurricular anoCurricular = new AnoCurricular();
           
            anoCurricular.setIdAnoCurricular(rs.getInt("id_ano_curricular"));
            certificado.setIdAnoCurricilar(anoCurricular);
            
            certificado.setTextoCertificado(rs.getString("texto_certificado"));
        } catch (SQLException ex) {
             Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
