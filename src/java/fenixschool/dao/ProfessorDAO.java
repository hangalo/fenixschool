/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Professor;
import fenixschool.modelo.Sexo;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProfessorDAO implements GenericoDAO<Professor> {
    private static final String INSERIR = "INSERT INTO Professor (nome_professor, sobrenome_professor, id_sexo)VALUES(?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE Professor SET nome_professor = ?, sobrenome_professor = ?, id_sexo = ? WHERE id_professor = ?";
    private static final String ELIMINAR = "DELETE FROM Professor WHERE id_professor = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM Professor WHERE id_professor = ?";
    private static final String LISTAR_TUDO = "SELECT id_Professor p, nome_professor p, sobrenome_professor p, id_sexo p FROM Professor p INNER JOIN Sexo s on p.id_sexo = s.id_sexo";


    @Override
    public void save(Professor professor) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (professor == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            
            ps.setString(1, professor.getNomeProfessor());
            ps.setString(2, professor.getSobrenomeProfessor());
            ps.setString(3, professor.getIdSexo().getAbreviatura());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    

    @Override
    public void update(Professor professor){
        PreparedStatement ps = null;
        Connection conn = null;
        if (professor == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);            
            ps.setString(1, professor.getNomeProfessor());
            ps.setString(2, professor.getSobrenomeProfessor());
            ps.setString(3, professor.getIdSexo().getAbreviatura());
            ps.setInt(4, professor.getIdProfessor());            
            ps.executeUpdate();            
        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Professor professor) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (professor == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, professor.getIdProfessor());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }
    

    @Override
    public Professor findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Professor professor = new Professor();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(professor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return professor;
    }

    @Override
    public List<Professor> findAll(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Professor> professores = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                popularComDados(professor, rs);
                professores.add(professor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return professores;
    }

    @Override
    public void popularComDados(Professor professor, ResultSet rs) {
        try {
         
            professor.setIdProfessor(rs.getInt("Id_Professor"));
            professor.setNomeProfessor(rs.getString("Nome_Professor"));
            professor.setSobrenomeProfessor(rs.getString("Sobrenome_Professor"));
            professor.setIdSexo(Sexo.getAbreviatura(rs.getString("Id_Sexo")));
                        
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
     
        
    }
    
}
