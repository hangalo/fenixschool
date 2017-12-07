/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoLectivo;

import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Mensalidade;
import fenixschool.modelo.Mes;
import fenixschool.modelo.Turma;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elísio Kavaimunwa
 */
public class MensalidadeDAO implements GenericoDAOLogico<Mensalidade> {

    private static final String INSERIR = "INSERT INTO mensalidade(descricao_mensalidade, observacao, desconto, valor_pago, valor_multa, "
            + "data_pagamento, id_ano_letivo, id_departamento, id_turma, id_ciclo_letivo, id_mes, id_aluno, codigo_curso) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE mensalidade SET descricao_mensalidade =?, observacao=?, desconto=?, valor_pago=?, "
            + "valor_multa=?, data_pagamento=?,  id_ano_letivo=?, id_departamento=?, id_turma=?, id_ciclo_letivo=?, id_mes=?, id_aluno=?, "
            + "codigo_curso=? WHERE id_mensalidade =?";
    private static final String ELIMINAR = "DELETE FROM mensalidade WHERE id_mensalidade=?";

    private static final String LISTAR_POR_CODIGO = "SELECT * FROM mensalidade m "
            + "INNER JOIN ano_letivo an ON m.id_ano_letivo = an.id_ano_letivo "
            + "INNER JOIN departamento dep ON m.id_departamento = dep.id_departamento "
            + "INNER JOIN turma tur ON m.id_turma = tur.id_turma "
            + "INNER JOIN ciclo_letivo cl ON m.id_ciclo_letivo = cl.id_ciclo_letivo "
            + "INNER JOIN mes me ON m.id_mes = me.id_mes "
            + "INNER JOIN aluno al ON m.id_aluno = al.id_aluno "
            + "INNER JOIN curso cur ON m.codigo_curso = cur.codigo_curso WHERE id_mensalidade =?";

    private static final String LISTAR_TUDO = "SELECT * FROM mensalidade m "
            + "INNER JOIN ano_letivo an ON m.id_ano_letivo = an.id_ano_letivo "
            + "INNER JOIN departamento dep ON m.id_departamento = dep.id_departamento "
            + "INNER JOIN turma tur ON m.id_turma = tur.id_turma "
            + "INNER JOIN ciclo_letivo cl ON m.id_ciclo_letivo = cl.id_ciclo_letivo "
            + "INNER JOIN mes me ON m.id_mes = me.id_mes "
            + "INNER JOIN aluno al ON m.id_aluno = al.id_aluno "
            + "INNER JOIN curso cur ON m.codigo_curso = cur.codigo_curso ";

   
    @Override
    public boolean save(Mensalidade mensalidade) {
        Connection conn = null;
        PreparedStatement ps = null;
       
        
        boolean flagControlo = false;
        if (mensalidade == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, mensalidade.getDescricaoMensalidade());
            ps.setString(2, mensalidade.getObservacaoMensalidade());
            ps.setDouble(3, mensalidade.getDescontoMensalidade());
            ps.setDouble(4, mensalidade.getValorPago());
            ps.setDouble(5, mensalidade.getValorMulta());
            ps.setDate(6, new java.sql.Date(mensalidade.getDataPagamento().getTime()));
            
           
            ps.setInt(7, mensalidade.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, mensalidade.getDepartamento().getIdDepartamento());
            ps.setInt(9, mensalidade.getTurma().getIdTurma());
            ps.setInt(10, mensalidade.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(11, mensalidade.getMes().getIdMes());
            ps.setInt(12, mensalidade.getAluno().getIdAluno());
            ps.setString(13, mensalidade.getCurso().getCodigoCurso());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Mensalidade mensalidade) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        boolean flagControlo = false;
        if (mensalidade == null) {
            System.err.println("O campo anterior nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

            ps.setString(1, mensalidade.getDescricaoMensalidade());
            ps.setString(2, mensalidade.getObservacaoMensalidade());
            ps.setDouble(3, mensalidade.getDescontoMensalidade());
            ps.setDouble(4, mensalidade.getValorPago());
            ps.setDouble(5, mensalidade.getValorMulta());
            ps.setDate(6, new java.sql.Date(mensalidade.getDataPagamento().getTime()));
            
           
            ps.setInt(7, mensalidade.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, mensalidade.getDepartamento().getIdDepartamento());
            ps.setInt(9, mensalidade.getTurma().getIdTurma());
            ps.setInt(10, mensalidade.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(11, mensalidade.getMes().getIdMes());
            ps.setInt(12, mensalidade.getAluno().getIdAluno());
            ps.setString(13, mensalidade.getCurso().getCodigoCurso());
            ps.setInt(14, mensalidade.getIdMensalidade());


            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Mensalidade mensalidade) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        boolean flagControlo = false;
        if (mensalidade == null) {
            System.err.println("O valor passado não pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, mensalidade.getIdMensalidade());

            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;
        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
            {
            }
        }
    }

    @Override
    public Mensalidade findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Mensalidade mensalidade = new Mensalidade();

        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi possivel encontrado nenhum registro com o id:  " + id);
            }
            popularComDados(mensalidade, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn, ps, rs);
        }
        return mensalidade;
    }

    @Override
    public List<Mensalidade> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Mensalidade> mensalidades = new ArrayList<>();
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mensalidade mensalidade = new Mensalidade();
                popularComDados(mensalidade, rs);
                mensalidades.add(mensalidade);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler os dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection((java.sql.Connection) conn);
        }

        return mensalidades;
    }

    @Override
    public void popularComDados(Mensalidade mensalidade, ResultSet rs) {
        try {
            mensalidade.setIdMensalidade(rs.getInt("id_mensalidade"));
            mensalidade.setDescricaoMensalidade(rs.getString("descricao_mensalidade"));
            mensalidade.setDescontoMensalidade(rs.getDouble("desconto"));
            mensalidade.setValorPago(rs.getDouble("valor_pago"));
            mensalidade.setValorMulta(rs.getDouble("valor_multa"));
            mensalidade.setObservacaoMensalidade(rs.getString("observacao"));
            mensalidade.setDataPagamento(rs.getDate("data_pagamento"));

            AnoLectivo anoLetivo = new AnoLectivo();
            anoLetivo.setIdAnoLectivo(rs.getInt("id_ano_letivo"));
            anoLetivo.setAnoLectivo(rs.getString("ano_letivo"));
            mensalidade.setAnoLetivo(anoLetivo);

            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(rs.getInt("id_departamento"));
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            mensalidade.setDepartamento(departamento);

            Turma turma = new Turma();
            turma.setIdTurma(rs.getInt("id_turma"));
            turma.setNomeTurma(rs.getString("nome_turma"));
            mensalidade.setTurma(turma);

            CicloLectivo cicloLectivo = new CicloLectivo();
            cicloLectivo.setIdCicloLectivo(rs.getInt("id_ciclo_letivo"));
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            mensalidade.setCicloLectivo(cicloLectivo);

            Mes mes = new Mes();
            mes.setIdMes(rs.getInt("id_mes"));
            mes.setNomeMes(rs.getString("nome_mes"));
            mensalidade.setMes(mes);

            Aluno aluno = new Aluno();
            aluno.setIdAluno(rs.getInt("id_aluno"));
            
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));
            mensalidade.setAluno(aluno);

            Curso curso = new Curso();
            curso.setCodigoCurso(rs.getString("codigo_curso"));
            curso.setNomeCurso(rs.getString("nome_curso"));
            mensalidade.setCurso(curso);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados");
        }
    }
}
