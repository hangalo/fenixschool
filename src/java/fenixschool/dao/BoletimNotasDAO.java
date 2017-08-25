/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.BoletimNotas;
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
 * @author PENA
 */
public class BoletimNotasDAO implements GenericoDAO<BoletimNotas> {

    private static final String INSERIR = "INSERT INTO boletin_notas (data_boletin_notas,id_aluno) VALUES (?,?)";
    private static final String ACTUALIZAR = "UPDATE boletin_notas SET data_boletin_notas = ?, id_aluno =? WHERE id_boletin_notas = ?";
    private static final String ELIMINAR = "DELETE FROM boletin_notas WHERE id_boletin_notas=?";
    private static final String LISTAR_POR_CODIGO = "SELECT b.id_boletin_notas,b.data_boletin_notas, b.id_aluno, a.numero_aluno,a.nome_aluno,a.sobrenome_aluno,"
            + "a.data_nascimento,a.sexo FROM boletin_notas b INNER JOIN aluno a ON b.id_aluno=a.id_aluno WHERE b.id_boletin_notas=?";
    private static final String LISTAR_TUDO = "SELECT b.id_boletin_notas,b.data_boletin_notas, b.id_aluno, a.numero_aluno,a.nome_aluno,a.sobrenome_aluno,"
            + "a.data_nascimento,a.sexo FROM boletin_notas b INNER JOIN aluno a ON b.id_aluno=a.id_aluno";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public BoletimNotasDAO() {
    }

    @Override
    public void save(BoletimNotas boletimNotas) {
        if (boletimNotas == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setDate(1, new java.sql.Date(boletimNotas.getDataBoletimNotas().getTime()));
            ps.setInt(2, boletimNotas.getAluno().getIdAluno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(BoletimNotas boletimNotas) {
        if (boletimNotas == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setDate(1, new java.sql.Date(boletimNotas.getDataBoletimNotas().getTime()));
            ps.setInt(2, boletimNotas.getAluno().getIdAluno());
            ps.setInt(3, boletimNotas.getIdBoletimNotas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(BoletimNotas boletimNota) {
        if (boletimNota == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, boletimNota.getIdBoletimNotas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public BoletimNotas findById(Integer id) {
        
         BoletimNotas boletimNota = new BoletimNotas();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(boletimNota, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return boletimNota;
    }

    @Override
    public List<BoletimNotas> findAll() {
         List<BoletimNotas> boletinsNotas = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                BoletimNotas boletimNota = new BoletimNotas();
                popularComDados(boletimNota, rs);
                boletinsNotas.add(boletimNota);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return boletinsNotas;
    }

    @Override
    public void popularComDados(BoletimNotas boletimNotas, ResultSet rs) {

        try {
            boletimNotas.setIdBoletimNotas(rs.getInt("id_boletin_notas"));
            boletimNotas.setDataBoletimNotas(rs.getDate("data_boletin_notas"));
            
            Aluno aluno = new Aluno();
            
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setNumeroAluno(rs.getString("numero_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));
            aluno.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));
            
            boletimNotas.setAluno(aluno);
            
        } catch (SQLException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
    }

}
