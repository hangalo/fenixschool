/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class CursoDAO implements GenericoDAO<Curso>{
    private static final String INSERIR = "INSERT INTO curso (nome_curso, abreviatura, codigo_ministerio_educacao, data_criacao, id_departamento) VALUES (?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE curso set nome_curso=?, abreviatura = ?, codigo_ministerio_educacao = ?, data_criacao = ?, id_departamento =? WHERE id_curso=?";
    private static final String ELIMINAR = "DELETE FROM curso WHERE id_curso=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM  curso WHERE id_curso=?";
    private static final String LISTAR_TUDO = "SELECT * FROM departamento";

    @Override
    public void save(Curso curso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if(curso == null){System.err.println("O valor passado não pode ser nulo!");}
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, curso.getNomeCurso());
            ps.setString(2, curso.getAbreviaturaCurso());
            ps.setString(3, curso.getCodigoMinisterioDaEducação());
            ps.setDate(4, new java.sql.Date(curso.getDataCriacao().getTime()));
            ps.setInt(5, curso.getId_Departamento().getIdDepartamento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
        finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Curso curso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (curso == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);            
            ps.setString(1, curso.getNomeCurso());
            ps.setString(2, curso.getAbreviaturaCurso());
            ps.setString(3, curso.getCodigoMinisterioDaEducação());
            ps.setDate(4, new java.sql.Date(curso.getDataCriacao().getTime()));
            ps.setInt(5, curso.getId_Departamento().getIdDepartamento());
            ps.executeUpdate();            
        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }}

    @Override
    public void delete(Curso curso) {
         PreparedStatement ps = null;
        Connection conn = null;
        if (curso == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, curso.getCodigoCurso());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }}

    @Override
    public Curso findById(Integer id) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Curso curso = new Curso();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(curso, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
            return curso;
    }

    @Override
    public List<Curso> findAll(){
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                popularComDados(curso, rs);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return cursos;
    }

    @Override
    public void popularComDados(Curso curso, ResultSet rs) {
        try {
            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(rs.getInt("id_departamento"));
            curso.setCodigoCurso(rs.getInt("codigo_curso"));
            curso.setNomeCurso(rs.getString("nome_curso"));
            curso.setCodigoMinisterioDaEducação(rs.getString("codigo_ministerio_educacao"));
            curso.setDataCriacao(rs.getDate("data_criacao"));
            curso.setId_Departamento(departamento);
            
        } catch (Exception e) {
        }
    }
    
}
