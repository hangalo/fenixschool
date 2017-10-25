/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.TipoDisciplina;
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
public class DisciplinaDAO implements GenericoDAO<Disciplina> {

    private static final String INSERIR = "INSERT INTO disciplina (id_disciplina, nome_disciplina, abreviatura, descricao_displina, sumario_disciplina, data_criacao, id_ciclo_letivo, id_tipo_disciplina) VALUES (?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE disciplina  SET id_disciplina = ?, nome_disciplina = ?, abreviatura = ?, descricao_displina = ?, sumario_disciplina = ?, data_criacao = ?, id_ciclo_letivo = ?, id_tipo_disciplina = ? WHERE id_disciplina = ?";
    private static final String ELIMINAR = "DELETE FROM disciplina WHERE id_disciplina=?";
    private static final String LISTAR_POR_CODIGO = "SELECT d.id_disciplina, d.nome_disciplina, d.abreviatura, d.descricao_displina, d.sumario_disciplina, "
            + " d.data_criacao, ci.ciclo_letivo, ti.tipo_disciplina  "
            + " FROM disciplina d INNER JOIN ciclo_letivo ci ON "
            + " d.id_ciclo_letivo=ci.id_ciclo_letivo INNER JOIN tipo_disciplina ti ON d.id_tipo_disciplina = ti.id_tipo_disciplina WHERE d.id_disciplina=? ";
    private static final String LISTAR_TUDO = "SELECT d.id_disciplina, d.nome_disciplina, d.abreviatura, d.descricao_displina, d.sumario_disciplina, "
            + " d.data_criacao, ci.ciclo_letivo, ti.tipo_disciplina  "
            + " FROM disciplina d INNER JOIN ciclo_letivo ci ON "
            + " d.id_ciclo_letivo=ci.id_ciclo_letivo INNER JOIN tipo_disciplina ti ON d.id_tipo_disciplina = ti.id_tipo_disciplina ";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public DisciplinaDAO() {
    }

    public DisciplinaDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public void save(Disciplina disciplina) {
        if (disciplina == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, disciplina.getIdDisciplina());
            ps.setString(2, disciplina.getNomeDisciplina());
            ps.setString(3, disciplina.getAbreviatura());
            ps.setString(4, disciplina.getDescricaoDisplina());
            ps.setString(5, disciplina.getSumarioDisciplina());
            ps.setDate(6, new java.sql.Date(disciplina.getDataCriacao().getTime()));
            ps.setInt(7, disciplina.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(8, disciplina.getTipoDisciplina().getIdTipoDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Disciplina disciplina) {
        if (disciplina == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, disciplina.getIdDisciplina());
            ps.setString(2, disciplina.getNomeDisciplina());
            ps.setString(3, disciplina.getAbreviatura());
            ps.setString(4, disciplina.getDescricaoDisplina());
            ps.setString(5, disciplina.getSumarioDisciplina());
            ps.setDate(6, new java.sql.Date(disciplina.getDataCriacao().getTime()));
            ps.setInt(7, disciplina.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(8, disciplina.getTipoDisciplina().getIdTipoDisciplina());
            ps.setString(9, disciplina.getIdDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Disciplina disciplina) {
        if (disciplina == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setString(1, disciplina.getIdDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Disciplina findById(Integer id) {

        Disciplina disciplina = new Disciplina();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(disciplina, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplina;
    }
    
     public Disciplina findByCodigo(String id) {

        Disciplina disciplina = new Disciplina();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(disciplina, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplina;
    }

    @Override
    public List<Disciplina> findAll() {
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                popularComDados(disciplina, rs);
                disciplinas.add(disciplina);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplinas;
    }

    @Override
    public void popularComDados(Disciplina disciplina, ResultSet rs) {
        try {

            disciplina.setIdDisciplina(rs.getString("id_disciplina"));
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            disciplina.setAbreviatura(rs.getString("abreviatura"));
            disciplina.setDescricaoDisplina(rs.getString("descricao_displina"));
            disciplina.setSumarioDisciplina(rs.getString("sumario_disciplina"));
            disciplina.setDataCriacao(rs.getDate("data_criacao"));

            CicloLectivo cicloLectivo = new CicloLectivo();
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            disciplina.setCicloLectivo(cicloLectivo);

            TipoDisciplina tipoDisciplina = new TipoDisciplina();
            tipoDisciplina.setTipoDisciplina(rs.getString("tipo_disciplina"));
            disciplina.setTipoDisciplina(tipoDisciplina);

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        }
    }

}
