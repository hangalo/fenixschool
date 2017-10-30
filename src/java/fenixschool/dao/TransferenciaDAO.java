/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.SituacaoTransferencia;
import fenixschool.modelo.Transferencia;
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
public class TransferenciaDAO implements GenericoDAO<Transferencia> {

    private static final String INSERT = "INSERT INTO transferencia (data_transferencia, texto_transferencia, id_aluno, id_funcionario, id_situacao_transferencia, observacoes) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE transferencia SET data_transferencia = ?, texto_transferencia = ?, id_aluno = ?, id_funcionario = ?, id_situacao_transferencia = ?, observacoes = ? WHERE id_transferencia = ?";
    private static final String DELETE = "DELETE FROM transferencia WHERE id_transferencia=?";
    private static final String FIND_BY_ID = "SELECT t.id_transferencia, t.data_transferencia, a.url_foto_aluno, a.sobrenome_aluno, a.id_aluno,a.nome_aluno, f.nome_funcionario, t.texto_transferencia, s.situacao_transferencia, t.observacoes FROM transferencia t INNER JOIN aluno a ON t.id_aluno = a.id_aluno INNER JOIN funcionario f ON t.id_funcionario=f.id_funcionario INNER JOIN situacao_transferencia s ON t.id_situacao_transferencia = s.id_situacao_transferencia WHERE t.id_transferencia =?";
    private static final String FIND_ALL = "SELECT t.id_transferencia, t.data_transferencia, a.url_foto_aluno, a.sobrenome_aluno, a.id_aluno, a.nome_aluno, f.nome_funcionario, t.texto_transferencia, s.situacao_transferencia, t.observacoes FROM transferencia t INNER JOIN aluno a ON t.id_aluno = a.id_aluno INNER JOIN funcionario f ON t.id_funcionario=f.id_funcionario INNER JOIN situacao_transferencia s ON t.id_situacao_transferencia = s.id_situacao_transferencia ORDER BY t.id_transferencia";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public TransferenciaDAO() {
    }

    public TransferenciaDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public void save(Transferencia transferencia) {
        if (transferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setDate(1, new java.sql.Date(transferencia.getDataTransferencia().getTime()));
            ps.setString(2, transferencia.getTextoTransferencia());
            ps.setInt(3, transferencia.getAluno().getIdAluno());
            ps.setInt(4, transferencia.getFuncionario().getIdFuncionario());
            ps.setInt(5, transferencia.getSituacaoTransferencia().getIdSituacaoTransferencia());
            ps.setString(6, transferencia.getObservacoes());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Transferencia transferencia) {
        if (transferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setDate(1, new java.sql.Date(transferencia.getDataTransferencia().getTime()));
            ps.setString(2, transferencia.getTextoTransferencia());
            ps.setInt(3, transferencia.getAluno().getIdAluno());
            ps.setInt(4, transferencia.getFuncionario().getIdFuncionario());
            ps.setInt(5, transferencia.getSituacaoTransferencia().getIdSituacaoTransferencia());
            ps.setString(6, transferencia.getObservacoes());
            ps.setInt(7, transferencia.getIdTransferencia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Transferencia transferencia) {
        if (transferencia == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, transferencia.getIdTransferencia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Transferencia findById(Integer id) {
        Transferencia transferencia = new Transferencia();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(transferencia, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return transferencia;
    }

    @Override
    public List<Transferencia> findAll() {
        List<Transferencia> transferencias = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Transferencia transferencia = new Transferencia();
                popularComDados(transferencia, rs);
                transferencias.add(transferencia);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return transferencias;
    }

    @Override
    public void popularComDados(Transferencia transferencia, ResultSet rs) {

        try {

            transferencia.setIdTransferencia(rs.getInt("id_transferencia"));
            transferencia.setDataTransferencia(rs.getDate("data_transferencia"));
            transferencia.setTextoTransferencia(rs.getString("texto_transferencia"));
            
            Aluno aluno = new Aluno();
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));
            transferencia.setAluno(aluno);
            
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            transferencia.setFuncionario(funcionario);
            
            SituacaoTransferencia situacaoTransferencia = new SituacaoTransferencia();
            situacaoTransferencia.setSituacaoTransferencia(rs.getString("situacao_transferencia"));
            transferencia.setSituacaoTransferencia(situacaoTransferencia);
            
            transferencia.setObservacoes(rs.getString("observacoes"));

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados " + ex.getMessage());
        }
    }

}
