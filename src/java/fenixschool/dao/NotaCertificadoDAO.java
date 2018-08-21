/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Aluno;
import fenixschool.modelo.AnoCurricular;
import fenixschool.modelo.AnoLectivo;
import fenixschool.modelo.Certificado;
import fenixschool.modelo.CicloLectivo;
import fenixschool.modelo.ClassificacaoNota;
import fenixschool.modelo.Curso;
import fenixschool.modelo.Departamento;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.Nota;
import fenixschool.modelo.NotaCertificado;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.SemestreLectivo;
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
public class NotaCertificadoDAO implements GenericoDAOLogico<NotaCertificado> {

    private static final String INSERT = "INSERT INTO notas_para_certifica (id_certificado,notas_certifica,id_nota) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE notas_para_certifica SET id_certificado = ?,notas_certifica = ?,id_nota = ? WHERE id_notas_certifica_boletin = ?";
    private static final String DELETE = "DELETE FROM notas_para_certifica WHERE id_notas_certifica_boletin = ?";

    private static final String SELECT_BY_ID = " SELECT cert.id_notas_certifica_boletin, cert.id_certificado,cert.notas_certifica , cert.id_nota,  cer.data_certificado, "
            + " cer.texto_certificado,f.nome_funcionario,f.sobrenome_funcionario,al.nome_aluno,al.sobrenome_aluno,al.data_nascimento, "
            + " al.numero_BI,al.url_foto_aluno,al.id_aluno,anc.ano_curricular,pl.periodo_letivo, "
            + " cr.nome_curso, nt.data_lancamento,nt.nota_primeira_prova,nt.nota_segunda_prova,nt.nota_terceira_prova, nt.nota_exame_recurso,  "
            + " nt.nota_exame_final,nt.peso,an.ano_letivo, cl.ciclo_letivo, dc.nome_disciplina, cn.classificacao_nota, dp.nome_departamento, "
            + " t.nome_turma, nt.observacao, sl.semestre_lectivo "
            + " FROM notas_para_certifica cert "
            + " INNER JOIN certificado cer ON (cert.id_certificado = cer.id_certificado) "
            + " INNER JOIN nota nt ON (nt.id_nota=cert.id_nota) "
            + " INNER JOIN funcionario f ON (cer.id_funcionario =f.id_funcionario) "
            + " INNER JOIN aluno al ON (al.id_aluno=cer.id_aluno) "
            + " INNER JOIN ano_curricular anc ON (anc.id_ano_curricular=cer.id_ano_curricular) "
            + " INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo) "
            + " INNER JOIN aluno alu ON (alu.id_aluno=nt.id_aluno) "
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) "
            + " INNER JOIN ano_letivo an ON (nt.id_ano_letivo=an.id_ano_letivo) "
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo = nt.id_ciclo_letivo) "
            + " INNER JOIN disciplina dc ON (dc.id_disciplina=nt.id_disciplina) "
            + " INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota) "
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) "
            + " INNER JOIN turma t ON (t.id_turma=nt.id_turma) "
            + " INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular) "
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) WHERE nt.id_aluno = cer.id_aluno AND cert.id_notas_certifica_boletin = ?";

    private static final String SELECT_ALL = " SELECT cert.id_notas_certifica_boletin, cert.id_certificado,cert.notas_certifica , cert.id_nota,  cer.data_certificado, "
            + " cer.texto_certificado,f.nome_funcionario,f.sobrenome_funcionario,al.nome_aluno,al.sobrenome_aluno,al.data_nascimento, "
            + " al.numero_BI,al.url_foto_aluno,al.id_aluno, anc.ano_curricular,pl.periodo_letivo, "
            + " cr.nome_curso, nt.data_lancamento,nt.nota_primeira_prova,nt.nota_segunda_prova,nt.nota_terceira_prova, nt.nota_exame_recurso,  "
            + " nt.nota_exame_final,nt.peso,an.ano_letivo, cl.ciclo_letivo, dc.nome_disciplina, cn.classificacao_nota, dp.nome_departamento, "
            + " t.nome_turma, nt.observacao, sl.semestre_lectivo "
            + " FROM notas_para_certifica cert "
            + " INNER JOIN certificado cer ON (cert.id_certificado = cer.id_certificado) "
            + " INNER JOIN nota nt ON (nt.id_nota=cert.id_nota) "
            + " INNER JOIN funcionario f ON (cer.id_funcionario =f.id_funcionario) "
            + " INNER JOIN aluno al ON (al.id_aluno=cer.id_aluno) "
            + " INNER JOIN ano_curricular anc ON (anc.id_ano_curricular=cer.id_ano_curricular) "
            + " INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo) "
            + " INNER JOIN aluno alu ON (alu.id_aluno=nt.id_aluno) "
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) "
            + " INNER JOIN ano_letivo an ON (nt.id_ano_letivo=an.id_ano_letivo) "
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo = nt.id_ciclo_letivo) "
            + " INNER JOIN disciplina dc ON (dc.id_disciplina=nt.id_disciplina) "
            + " INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota) "
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) "
            + " INNER JOIN turma t ON (t.id_turma=nt.id_turma) "
            + " INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular) "
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) WHERE nt.id_aluno = cer.id_aluno";

    private static final String SELECT_EXIST = " SELECT cert.id_notas_certifica_boletin, cert.id_certificado,cert.notas_certifica , cert.id_nota,  cer.data_certificado, "
            + " cer.texto_certificado,f.nome_funcionario,f.sobrenome_funcionario,al.nome_aluno,al.sobrenome_aluno,al.data_nascimento, "
            + " al.numero_BI,al.url_foto_aluno,al.id_aluno, anc.ano_curricular,pl.periodo_letivo, "
            + " cr.nome_curso, nt.data_lancamento,nt.nota_primeira_prova,nt.nota_segunda_prova,nt.nota_terceira_prova, nt.nota_exame_recurso,  "
            + " nt.nota_exame_final,nt.peso,an.ano_letivo, cl.ciclo_letivo, dc.nome_disciplina, cn.classificacao_nota, dp.nome_departamento, "
            + " t.nome_turma, nt.observacao, sl.semestre_lectivo "
            + " FROM notas_para_certifica cert "
            + " INNER JOIN certificado cer ON (cert.id_certificado = cer.id_certificado) "
            + " INNER JOIN nota nt ON (nt.id_nota=cert.id_nota) "
            + " INNER JOIN funcionario f ON (cer.id_funcionario =f.id_funcionario) "
            + " INNER JOIN aluno al ON (al.id_aluno=cer.id_aluno) "
            + " INNER JOIN ano_curricular anc ON (anc.id_ano_curricular=cer.id_ano_curricular) "
            + " INNER JOIN periodo_letivo pl ON (nt.id_periodo_letivo=pl.id_periodo_letivo) "
            + " INNER JOIN aluno alu ON (alu.id_aluno=nt.id_aluno) "
            + " INNER JOIN curso cr ON (cr.codigo_curso=nt.codigo_curso) "
            + " INNER JOIN ano_letivo an ON (nt.id_ano_letivo=an.id_ano_letivo) "
            + " INNER JOIN ciclo_letivo cl ON (cl.id_ciclo_letivo = nt.id_ciclo_letivo) "
            + " INNER JOIN disciplina dc ON (dc.id_disciplina=nt.id_disciplina) "
            + " INNER JOIN classificacao_nota cn ON (cn.id_classificacao_nota=nt.id_classificacao_nota) "
            + " INNER JOIN departamento dp ON (dp.id_departamento=nt.id_departamento) "
            + " INNER JOIN turma t ON (t.id_turma=nt.id_turma) "
            + " INNER JOIN ano_curricular ac ON (ac.id_ano_curricular=nt.id_ano_curricular) "
            + " INNER JOIN semestre_lectivo sl ON (sl.id_semestre_lectivo=nt.id_semestre_lectivo) WHERE nt.id_aluno = cer.id_aluno AND cert.id_nota =?";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean save(NotaCertificado notaCertificado) {
        boolean controlo = false;
        if (notaCertificado == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, notaCertificado.getCertificado().getIdCertificado());
            ps.setDouble(2, notaCertificado.getNotaCertificado());
            ps.setInt(3, notaCertificado.getNota().getIdnota());
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
    public boolean update(NotaCertificado notaCertificado) {
        boolean controlo = false;
        if (notaCertificado == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, notaCertificado.getCertificado().getIdCertificado());
            ps.setDouble(2, notaCertificado.getNotaCertificado());
            ps.setInt(3, notaCertificado.getNota().getIdnota());
            ps.setInt(4, notaCertificado.getIdNotaCertificado());
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
    public boolean delete(NotaCertificado notaCertificado) {
        boolean controlo = false;
        if (notaCertificado == null) {
            System.out.println("O paramentro passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, notaCertificado.getIdNotaCertificado());
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
    public NotaCertificado findById(Integer id) {
        NotaCertificado notaCertificado = new NotaCertificado();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(notaCertificado, rs);

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return notaCertificado;
    }

    @Override
    public List<NotaCertificado> findAll() {
        List<NotaCertificado> notaCertificados = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                NotaCertificado notaCertificado = new NotaCertificado();
                popularComDados(notaCertificado, rs);
                notaCertificados.add(notaCertificado);

            }

        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return notaCertificados;
    }

    
    
    public boolean findWhere(NotaCertificado certificado) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_EXIST);
            ps.setInt(1, certificado.getNota().getIdnota());           
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
    public void popularComDados(NotaCertificado notaCertificado, ResultSet rs) {
        try {
            notaCertificado.setIdNotaCertificado(rs.getInt("id_notas_certifica_boletin"));
            notaCertificado.setNotaCertificado(rs.getDouble("notas_certifica"));

            Certificado certificado = new Certificado();
            certificado.setIdCertificado(rs.getInt("id_certificado"));
            certificado.setDataCertificado(rs.getDate("data_certificado"));
            certificado.setTextoCertificado(rs.getString("texto_certificado"));

            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            funcionario.setSobrenomeFuncionario(rs.getString("sobrenome_funcionario"));
            certificado.setFuncionarioCertificado(funcionario);
            notaCertificado.setCertificado(certificado);

            Aluno aluno = new Aluno();

            PeriodoLectivo periodo = new PeriodoLectivo();
            periodo.setPeriodoLectivo(rs.getString("periodo_letivo"));

            aluno.setIdAluno(rs.getInt("id_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));
            aluno.setBiAluno(rs.getString("numero_BI"));
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));

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
            nota.setIdnota(rs.getInt("id_nota"));
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

        } catch (SQLException ex) {
            System.out.println("erro ao ler dados: " + ex.getMessage());
        }
    }

}
