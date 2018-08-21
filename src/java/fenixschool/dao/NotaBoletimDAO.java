/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.BoletimNota;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.ClassificacaoNota;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Nota;
import fenixschool.modelo.NotaBoletim;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.SemestreLectivo;
import fenixschool.modelo.Turma;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PENA
 */
public class NotaBoletimDAO implements GenericoDAOLogico<NotaBoletim> {

    private static final String INSERT = "INSERT INTO notas_para_boletim (id_boletin_notas,id_nota) VALUES (?,?)";
    private static final String UPDATE = "UPDATE notas_para_boletim SET id_boletin_notas = ?, id_nota = ? WHERE id_notas_para_boletim = ?";
    private static final String DELETE = "DELETE FROM notas_para_boletim WHERE id_notas_para_boletim = ?";

    private static final String SELECT_BY_ID = "SELECT nb.id_notas_para_boletim,bn.data_boletin_notas,bn.id_boletin_notas,pl.periodo_letivo,al.nome_aluno,\n"
            + " al.sobrenome_aluno,al.data_nascimento,al.numero_BI,al.url_foto_aluno,an.ano_letivo,cl.ciclo_letivo,\n"
            + " nt.descricao,nt.data_lancamento, nt.nota_primeira_prova, nt.nota_segunda_prova,\n"
            + " nt.nota_terceira_prova,nt. nota_exame_recurso,nt.nota_exame_final,nt.peso, nt.observacao,d.nome_disciplina,\n"
            + " cn.classificacao_nota,dp.nome_departamento,t.nome_turma, cr.nome_curso,ac.ano_curricular, sl.semestre_lectivo\n"
            + " FROM notas_para_boletim nb INNER JOIN boletim_notas bn ON (nb.id_boletin_notas=bn.id_boletin_notas)\n"
            + " INNER JOIN nota nt ON (nb.id_nota=nt.id_nota) INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo)\n"
            + " INNER JOIN aluno al ON (nt.id_aluno = al.id_aluno) INNER JOIN ano_letivo an ON (an.id_ano_letivo=nt.id_ano_letivo)\n"
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo=nt.id_ciclo_letivo) INNER JOIN disciplina d ON\n"
            + " (d. id_disciplina=nt. id_disciplina) INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota)\n"
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) INNER JOIN turma t ON (t.id_turma=nt.id_turma)\n"
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular)\n"
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) \n"
            + " INNER JOIN nota nta WHERE (nta.id_aluno=bn.id_aluno) ";

    private static final String SELECT_ALL = "SELECT nb.id_notas_para_boletim,bn.id_boletin_notas,bn.data_boletin_notas,pl.periodo_letivo,al.nome_aluno,\n "
            + " al.sobrenome_aluno,al.data_nascimento,al.numero_BI,al.url_foto_aluno,an.ano_letivo,cl.ciclo_letivo,\n "
            + " nt.descricao,nt.data_lancamento, nt.nota_primeira_prova, nt.nota_segunda_prova,\n"
            + " nt.nota_terceira_prova,nt. nota_exame_recurso,nt.nota_exame_final,nt.peso, nt.observacao,d.nome_disciplina,\n"
            + " cn.classificacao_nota,dp.nome_departamento,t.nome_turma, cr.nome_curso,ac.ano_curricular, sl.semestre_lectivo\n"
            + " FROM notas_para_boletim nb INNER JOIN boletim_notas bn ON (nb.id_boletin_notas=bn.id_boletin_notas)\n"
            + " INNER JOIN nota nt ON (nb.id_nota=nt.id_nota) INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo)\n "
            + " INNER JOIN aluno al ON (nt.id_aluno = al.id_aluno) INNER JOIN ano_letivo an ON (an.id_ano_letivo=nt.id_ano_letivo)\n"
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo=nt.id_ciclo_letivo) INNER JOIN disciplina d ON\n "
            + " (d. id_disciplina=nt. id_disciplina) INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota)\n "
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) INNER JOIN turma t ON (t.id_turma=nt.id_turma)\n"
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular)\n"
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) \n"
            + " INNER JOIN nota nta WHERE (nta.id_aluno=bn.id_aluno) ";

   
    
      private static final String SELECT_EXIST = "SELECT nb.id_notas_para_boletim,bn.id_boletin_notas,bn.data_boletin_notas,pl.periodo_letivo,al.nome_aluno,\n "
            + " al.sobrenome_aluno,al.data_nascimento,al.numero_BI,al.url_foto_aluno,an.ano_letivo,cl.ciclo_letivo,\n "
            + " nt.descricao,nt.data_lancamento, nt.nota_primeira_prova, nt.nota_segunda_prova,\n"
            + " nt.nota_terceira_prova,nt. nota_exame_recurso,nt.nota_exame_final,nt.peso, nt.observacao,d.nome_disciplina,\n"
            + " cn.classificacao_nota,dp.nome_departamento,t.nome_turma, cr.nome_curso,ac.ano_curricular, sl.semestre_lectivo\n"
            + " FROM notas_para_boletim nb INNER JOIN boletim_notas bn ON (nb.id_boletin_notas=bn.id_boletin_notas)\n"
            + " INNER JOIN nota nt ON (nb.id_nota=nt.id_nota) INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo)\n "
            + " INNER JOIN aluno al ON (nt.id_aluno = al.id_aluno) INNER JOIN ano_letivo an ON (an.id_ano_letivo=nt.id_ano_letivo)\n"
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo=nt.id_ciclo_letivo) INNER JOIN disciplina d ON\n "
            + " (d. id_disciplina=nt. id_disciplina) INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota)\n "
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) INNER JOIN turma t ON (t.id_turma=nt.id_turma)\n"
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular)\n"
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) \n"
            + " INNER JOIN nota nta WHERE (nta.id_aluno=bn.id_aluno) WHERE bn.id_boletin_notas =?";
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean save(NotaBoletim notaBoletim) {
        boolean controlo = false;
        if (notaBoletim == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, notaBoletim.getBoletinNota().getIdBoletim());
            ps.setInt(2, notaBoletim.getNota().getIdnota());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados Salvado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(NotaBoletim notaBoletim) {
        boolean controlo = false;
        if (notaBoletim == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, notaBoletim.getBoletinNota().getIdBoletim());
            ps.setInt(2, notaBoletim.getNota().getIdnota());
            ps.setInt(3, notaBoletim.getIdNotaBoletim());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizado com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao actualizar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(NotaBoletim notaBoletim) {
        boolean controlo = false;
        if (notaBoletim == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, notaBoletim.getIdNotaBoletim());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso! " + ps.getUpdateCount());
                controlo = true;
            }
            return controlo;
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registro: " + ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public NotaBoletim findById(Integer id) {
        NotaBoletim notaBoletim = new NotaBoletim();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);
            }
            popularComDados(notaBoletim, rs);

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return notaBoletim;
    }

    @Override
    public List<NotaBoletim> findAll() {
        List<NotaBoletim> notaBoletims = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                NotaBoletim boletim = new NotaBoletim();
                popularComDados(boletim, rs);
                notaBoletims.add(boletim);
            }

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return notaBoletims;
    }

    public boolean existe(NotaBoletim nb) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_EXIST);
            ps.setInt(1, nb.getBoletinNota().getIdBoletim());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Registo existente->>>>>>>>>>>> "+nb.getBoletinNota().getAluno().getNomeAluno());
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao localizar registo " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return false;
    }

    @Override
    public void popularComDados(NotaBoletim notaBoletim, ResultSet rs) {
        try {
            Aluno aluno = new Aluno();

            notaBoletim.setIdNotaBoletim(rs.getInt("id_notas_para_boletim"));

            PeriodoLectivo periodo = new PeriodoLectivo();
            periodo.setPeriodoLectivo(rs.getString("periodo_letivo"));

            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));
            aluno.setBiAluno(rs.getString("numero_BI"));
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));

            BoletimNota boletim = new BoletimNota();
            boletim.setIdBoletim(rs.getInt("id_boletin_notas"));
            boletim.setDataBoletim(rs.getDate("data_boletin_notas").toLocalDate());
            //boletim.setDataBoletim(LocalDate.parse(rs.getString("data_boletin_notas")));
            boletim.setAluno(aluno);
            notaBoletim.setBoletinNota(boletim);

            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));

            CicloLectivo ciclo = new CicloLectivo();
            ciclo.setCicloLectivo(rs.getString("ciclo_letivo"));

            Disciplina disciplina = new Disciplina();
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));

            ClassificacaoNota classificacao = new ClassificacaoNota();
            classificacao.setClassificacaoNota(rs.getString("classificacao_nota"));

            Departamento departamento = new Departamento();
            departamento.setNomeDepartamento(rs.getString("nome_departamento"));

            Turma turma = new Turma();
            turma.setNomeTurma(rs.getString("nome_turma"));

            Curso curso = new Curso();
            curso.setNomeCurso(rs.getString("nome_curso"));

            AnoCurricular anoCurricular = new AnoCurricular();
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular"));

            SemestreLectivo semestreLectivo = new SemestreLectivo();
            semestreLectivo.setSemestreLectivo(rs.getString("semestre_lectivo"));

            Nota nota = new Nota();
            nota.setDescricao(rs.getString("descricao"));
            nota.setDataLancamento(rs.getDate("data_lancamento"));
            nota.setNotaPrimeiraProva(rs.getDouble("nota_primeira_prova"));
            nota.setNotaSegundaProva(rs.getDouble("nota_segunda_prova"));
            nota.setNotaTerceiraProva(rs.getDouble("nota_terceira_prova"));
            nota.setNotaExameRecurso(rs.getDouble("nota_exame_recurso"));
            nota.setNotaExameFinal(rs.getDouble("nota_exame_final"));
            nota.setObservacao(rs.getString("observacao"));
            nota.setPeso(rs.getDouble("peso"));
            nota.setPeriodoLetivo(periodo);
            nota.setAluno(aluno);
            nota.setAnoLetivo(anoLectivo);
            nota.setCicloLetivo(ciclo);
            nota.setDisciplina(disciplina);
            nota.setDepartamento(departamento);
            nota.setTurma(turma);
            nota.setCurso(curso);
            nota.setAnoCurricular(anoCurricular);
            notaBoletim.setNota(nota);

        } catch (SQLException ex) {
            System.out.println("Erro ao popular dados no boletim de notas: " + ex.getMessage());
        }
    }

}
