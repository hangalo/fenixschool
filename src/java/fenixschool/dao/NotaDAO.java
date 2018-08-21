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
import fenixschool.modelo.SemestreLectivo;
import fenixschool.modelo.Sexo;
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
public class NotaDAO implements GenericoDAOLogico<Nota> {

    private static final String INSERIR = "INSERT INTO nota("
            + "id_periodo_letivo,"
            + "id_aluno,"
            + "codigo_curso,"
            + "id_disciplina,"
            + "descricao,"
            + "data_lancamento,"
            + "nota_primeira_prova, "
            + "nota_segunda_prova, "
            + "nota_terceira_prova, "
            + "nota_exame_recurso, "
            + "nota_exame_final,"
            + "peso,"
            + "id_ano_letivo,"
            + "id_ciclo_letivo,"
            + "id_classificacao_nota,"
            + "id_departamento,"
            + "id_turma,"
            + "id_ano_curricular,"
            + "observacao,id_semestre_lectivo)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = "UPDATE nota SET id_periodo_letivo = ?,id_aluno = ?,codigo_curso = ?,id_disciplina = ?,descricao = ?,data_lancamento = ?,nota_primeira_prova = ?, nota_segunda_prova=?,nota_terceira_prova=?,nota_exame_recurso=?, nota_exame_final=?  ,peso = ?,id_ano_letivo = ?,id_ciclo_letivo = ?,id_classificacao_nota = ?,id_departamento = ?,id_turma = ?,id_ano_curricular = ?,observacao = ?,id_semestre_lectivo=? WHERE id_nota = ?";
    private static final String ELIMINAR = "DELETE FROM nota WHERE id_nota=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT  ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo) WHERE n.id_nota=?";

    private static final String LISTAR_TUDO = "SELECT  ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo)  GROUP BY a.id_aluno, n.id_semestre_lectivo";

    private static final String SELECT_EXIST = "SELECT  ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo)  "
            + " WHERE (a.id_aluno=? AND sl.id_semestre_lectivo=? AND an.id_ano_letivo=? AND d.id_disciplina=? AND ac.id_ano_curricular =?)";

    private static final String MASCULINOS = "SELECT COUNT(a.sexo) as MASCULINO, ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo) WHERE a.sexo = 'M'  OR 'MASCULINO'";
    private static final String FEMININOS = "SELECT COUNT(a.sexo) as MASCULINO, ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo) WHERE a.sexo = 'F'  OR 'FEMININO'";

    private static final String LANCAR_NOTAS_TURMA = "SELECT ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo) "
            + " WHERE c.codigo_curso=? AND d.id_disciplina=? AND  ac.id_ano_curricular=? AND  t.id_turma=? AND an.id_ano_letivo=? AND p.id_periodo_letivo=? AND ci.id_ciclo_letivo=?";

    private static final String FIND_ALUNO_BY_NOTAS_LANCADAS = "SELECT  ac.id_ano_curricular,p.id_periodo_letivo,c.codigo_curso,t.id_turma,ci.id_ciclo_letivo, sl.id_semestre_lectivo,d.id_disciplina,an.id_ano_letivo,a.id_aluno,n.id_nota,sl.semestre_lectivo, p.periodo_letivo,n.nota_primeira_prova,n.nota_segunda_prova,n.nota_terceira_prova,n.nota_exame_recurso,n.nota_exame_final, a.sobrenome_aluno, a.nome_aluno,a.sexo,a.url_foto_aluno, c.nome_curso, d.nome_disciplina, n.descricao, n.data_lancamento, n.peso, an.ano_letivo, ci.ciclo_letivo, cl.classificacao_nota, dp.nome_departamento, t.nome_turma, n.observacao, ac.ano_curricular FROM nota n INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo INNER JOIN aluno a ON n.id_aluno=a.id_aluno INNER JOIN curso c ON n.codigo_curso=c.codigo_curso INNER JOIN disciplina d ON n.id_disciplina=d.id_disciplina INNER JOIN ano_letivo an ON n.id_ano_letivo = an.id_ano_letivo INNER JOIN ciclo_letivo ci ON n.id_ciclo_letivo = ci.id_ciclo_letivo INNER JOIN classificacao_nota cl ON n.id_classificacao_nota=cl.id_classificacao_nota INNER JOIN departamento dp ON n.id_departamento = dp.id_departamento INNER JOIN turma t ON n.id_turma = t.id_turma INNER JOIN ano_curricular ac ON n.id_ano_curricular = ac.id_ano_curricular INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=n.id_semestre_lectivo) WHERE n.id_turma =? AND  n.id_ano_letivo = ? AND n.id_periodo_letivo =? AND n.id_ano_curricular=?";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public NotaDAO() {
    }

    @Override
    public boolean save(Nota nota) {
        boolean controlo = false;
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
            ps.setDouble(7, nota.getNotaPrimeiraProva());
            ps.setDouble(8, nota.getNotaSegundaProva());
            ps.setDouble(9, nota.getNotaTerceiraProva());
            ps.setDouble(10, nota.getNotaExameRecurso());
            ps.setDouble(11, nota.getNotaExameFinal());
            ps.setDouble(12, nota.getPeso());
            ps.setInt(13, nota.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(14, nota.getCicloLetivo().getIdCicloLectivo());
            ps.setInt(15, nota.getClassificacaoNota().getIdClassificacaoNota());
            ps.setInt(16, nota.getDepartamento().getIdDepartamento());
            ps.setInt(17, nota.getTurma().getIdTurma());
            ps.setInt(18, nota.getAnoCurricular().getIdAnoCurricular());
            ps.setString(19, nota.getObservacao());
            ps.setInt(20, nota.getSemestreLectivo().getIdSemestreLectivo());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados Salvado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registo" + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Nota nota) {
        boolean controlo = false;
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
            ps.setDouble(7, nota.getNotaPrimeiraProva());
            ps.setDouble(8, nota.getNotaSegundaProva());
            ps.setDouble(9, nota.getNotaTerceiraProva());
            ps.setDouble(10, nota.getNotaExameRecurso());
            ps.setDouble(11, nota.getNotaExameFinal());
            ps.setDouble(12, nota.getPeso());
            ps.setInt(13, nota.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(14, nota.getCicloLetivo().getIdCicloLectivo());
            ps.setInt(15, nota.getClassificacaoNota().getIdClassificacaoNota());
            ps.setInt(16, nota.getDepartamento().getIdDepartamento());
            ps.setInt(17, nota.getTurma().getIdTurma());
            ps.setInt(18, nota.getAnoCurricular().getIdAnoCurricular());
            ps.setString(19, nota.getObservacao());
            ps.setInt(20, nota.getSemestreLectivo().getIdSemestreLectivo());
            ps.setInt(21, nota.getIdnota());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registo" + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Nota nota) {
        boolean controlo = false;
        if (nota == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, nota.getIdnota());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registo" + ex.getMessage());
            return false;
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

    public boolean existe(Nota nota) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_EXIST);
            ps.setInt(1, nota.getAluno().getIdAluno());
            ps.setInt(2, nota.getSemestreLectivo().getIdSemestreLectivo());
            ps.setInt(3, nota.getAnoLetivo().getIdAnoLectivo());
            ps.setString(4, nota.getDisciplina().getIdDisciplina());
            ps.setInt(5, nota.getAnoCurricular().getIdAnoCurricular());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Novo registro adicionado " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return false;
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

    public List<Nota> findAllOfTurmas(String curso, String disciplina, Integer classe, Integer turma, Integer anoLectivo, Integer periodo, Integer ciclo) {

        List<Nota> notas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LANCAR_NOTAS_TURMA);
            ps.setString(1, curso);
            ps.setString(2, disciplina);
            ps.setInt(3, classe);
            ps.setInt(4, turma);
            ps.setInt(5, anoLectivo);
            ps.setInt(6, periodo);
            ps.setInt(7, ciclo);
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

    public List<Nota> findTumaPeridodo(Integer periodo, Integer turma, Integer anoLetivo, Integer classe) {

        List<Nota> notas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(FIND_ALUNO_BY_NOTAS_LANCADAS);           
            ps.setInt(1, turma);
            ps.setInt(2, anoLetivo);
             ps.setInt(3, periodo);
            ps.setInt(4, classe);
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
            periodoLectivo.setIdPeriodoLectivo(rs.getInt("id_periodo_letivo"));
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            nota.setPeriodoLetivo(periodoLectivo);
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));
            nota.setAluno(aluno);

            curso.setCodigoCurso(rs.getString("codigo_curso"));
            curso.setNomeCurso(rs.getString("nome_curso"));
            nota.setCurso(curso);

            disciplina.setIdDisciplina(rs.getString("id_disciplina"));
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            nota.setDisciplina(disciplina);

            nota.setDescricao(rs.getString("descricao"));
            nota.setDataLancamento(rs.getDate("data_lancamento"));
            nota.setNotaPrimeiraProva(rs.getDouble("nota_primeira_prova"));
            nota.setNotaSegundaProva(rs.getDouble("nota_segunda_prova"));
            nota.setNotaTerceiraProva(rs.getDouble("nota_terceira_prova"));
            nota.setNotaExameRecurso(rs.getDouble("nota_exame_recurso"));
            nota.setNotaExameFinal(rs.getDouble("nota_exame_final"));
            nota.setPeso(rs.getDouble("peso"));
            anoLectivo.setIdAnoLectivo(rs.getInt("id_ano_letivo"));
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            nota.setAnoLetivo(anoLectivo);

            cicloLectivo.setIdCicloLectivo(rs.getInt("id_ciclo_letivo"));
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            nota.setCicloLetivo(cicloLectivo);

            classificacaoNota.setClassificacaoNota(rs.getString("classificacao_nota"));
            nota.setClassificacaoNota(classificacaoNota);

            departamento.setNomeDepartamento(rs.getString("nome_departamento"));
            nota.setDepartamento(departamento);

            turma.setIdTurma(rs.getInt("id_turma"));
            turma.setNomeTurma(rs.getString("nome_turma"));
            nota.setTurma(turma);

            anoCurricular.setIdAnoCurricular(rs.getInt("id_ano_curricular"));
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular"));
            nota.setAnoCurricular(anoCurricular);

            nota.setObservacao(rs.getString("observacao"));
            SemestreLectivo semestre = new SemestreLectivo();
            semestre.setSemestreLectivo(rs.getString("semestre_lectivo"));
            nota.setSemestreLectivo(semestre);
        } catch (SQLException ex) {
            System.out.println("Erro ao ler notas" + ex.getMessage());
        }

    }

}
