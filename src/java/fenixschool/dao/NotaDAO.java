/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.ClassificacaoNota;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Nota;
import fenixschool.modelo.PeriodoLectivo;
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
 * @author PENA
 */
public class NotaDAO implements GenericoDAO<Nota> {

    private static final String INSERIR = "INSERT INTO nota(id_periodo_letivo,id_aluno,codigo_curso,id_disciplina,descricao,data_lancamento,nota,peso,id_ano_letivo,id_ciclo_letivo,id_classificacao_nota,id_departamento,id_turma,id_ano_curricular,observacao)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE nota SET id_periodo_letivo = ?,id_aluno = ?,codigo_curso = ?,id_disciplina = ?,descricao = ?,data_lancamento = ?,nota = ?,peso = ?,id_ano_letivo = ?,id_ciclo_letivo = ?,id_classificacao_nota = ?,id_departamento = ?,id_turma = ?,id_ano_curricular = ?,observacao = ? WHERE id_nota = ?";
    private static final String ELIMINAR = "DELETE FROM nota WHERE id_nota=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT n.id_nota, p.periodo_letivo, a.sobrenome_aluno, a.nome_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.nota, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular WHERE n.id_nota =?";
    private static final String LISTAR_TUDO = "SELECT n.id_nota, p.periodo_letivo, a.sobrenome_aluno, a.nome_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.nota, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public NotaDAO() {
    }

    @Override
    public void save(Nota nota) {
        if (nota == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, nota.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, nota.getAluno().getIdAluno());
            ps.setString(3, nota.getCurso().getCodigoCurso());
            ps.setString(4, nota.getDisciplina().getIdDisciplina());
            ps.setString(5, nota.getDescricao());
            ps.setDate(6, new java.sql.Date(nota.getDataLancamento().getTime()));
            ps.setDouble(7, nota.getNota());
            ps.setDouble(8, nota.getPeso());
            ps.setInt(9, nota.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(10, nota.getCicloLetivo().getIdCicloLectivo());
            ps.setInt(11, nota.getClassificacaoNota().getIdClassificacaoNota());
            ps.setInt(12, nota.getDepartamento().getIdDepartamento());
            ps.setInt(13, nota.getTurma().getIdTurma());
            ps.setInt(14, nota.getAnoCurricular().getIdAnoCurricular());
            ps.setString(15, nota.getObservacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Nota nota) {
        if (nota == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, nota.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, nota.getAluno().getIdAluno());
            ps.setString(3, nota.getCurso().getCodigoCurso());
            ps.setString(4, nota.getDisciplina().getIdDisciplina());
            ps.setString(5, nota.getDescricao());
            ps.setDate(6, new java.sql.Date(nota.getDataLancamento().getTime()));
            ps.setDouble(7, nota.getNota());
            ps.setDouble(8, nota.getPeso());
            ps.setInt(9, nota.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(10, nota.getCicloLetivo().getIdCicloLectivo());
            ps.setInt(11, nota.getClassificacaoNota().getIdClassificacaoNota());
            ps.setInt(12, nota.getDepartamento().getIdDepartamento());
            ps.setInt(13, nota.getTurma().getIdTurma());
            ps.setInt(14, nota.getAnoCurricular().getIdAnoCurricular());
            ps.setString(15, nota.getObservacao());
            ps.setInt(16, nota.getIdnota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Nota nota) {
        if (nota == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, nota.getIdnota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Nota findById(Integer id) {
        Nota nota = new Nota();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");

            }
            popularComDados(nota, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return nota;
    }

    @Override
    public List<Nota> findAll() {

        List<Nota> notas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                Nota nota = new Nota();
                popularComDados(nota, rs);
                notas.add(nota);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return notas;
    }

    @Override
    public void popularComDados(Nota nota, ResultSet rs) {
        try {

            PeriodoLectivo periodoLectivo = new PeriodoLectivo();
            Aluno aluno = new Aluno();
            Curso curso = new Curso();
            Disciplina disciplina = new Disciplina();
            AnoLectivo anoLectivo = new AnoLectivo();
            CicloLectivo cicloLectivo = new CicloLectivo();
            ClassificacaoNota classificacaoNota = new ClassificacaoNota();
            Departamento departamento = new Departamento();
            Turma turma = new Turma();
            AnoCurricular anoCurricular = new AnoCurricular();

            nota.setIdnota(rs.getInt("id_nota"));
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            nota.setPeriodoLetivo(periodoLectivo);
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            nota.setAluno(aluno);
            curso.setNomeCurso(rs.getString("nome_curso"));
            nota.setCurso(curso);
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            nota.setDisciplina(disciplina);
            nota.setDescricao(rs.getString("descricao"));
            nota.setDataLancamento(rs.getDate("data_lancamento"));
            nota.setNota(rs.getDouble("nota"));
            nota.setPeso(rs.getDouble("peso"));
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            nota.setAluno(aluno);
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            nota.setCicloLetivo(cicloLectivo);
            classificacaoNota.setClassificacaoNota(rs.getString("classificacao_nota"));
            nota.setClassificacaoNota(classificacaoNota);
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            nota.setDepartamento(departamento);
            turma.setNomeTurma(rs.getString("nome_turma"));
            nota.setTurma(turma);
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular"));
            nota.setAnoCurricular(anoCurricular);
            nota.setObservacao(rs.getString("observacao"));

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados" + ex.getMessage());
        }
    }

}
