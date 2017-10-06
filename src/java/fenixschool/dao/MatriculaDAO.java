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
import fenixschool.modelo.Curso;
import fenixschool.modelo.Funcionario;
import fenixschool.modelo.LocalEmissaoDocumento;
import fenixschool.modelo.Matricula;
import fenixschool.modelo.Municipio;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Sexo;
import fenixschool.modelo.TipoDocumentoIdentidade;
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
 * @author HACKER
 */
public class MatriculaDAO implements GenericoDAO<Matricula> {

    private static final String INSERIR = "INSERT INTO matricula(data_matricula,id_aluno,id_funcionario,codigo_curso,id_ano_letivo,estado_matricula,id_turma,id_tipo_documento_identidade,data_emissao_documento,id_local_emissao_documento,numero_documento,id_ciclo_letivo,id_ano_curricular,observacao)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ATUALIZAR = "UPDATE matricula SET data_matricula = ?,id_aluno = ?,id_funcionario = ?,codigo_curso = ?,id_ano_letivo = ?,estado_matricula = ?,id_turma = ?,id_tipo_documento_identidade = ?,data_emissao_documento = ?,id_local_emissao_documento = ?,numero_documento = ?,id_ciclo_letivo = ?,id_ano_curricular = ?,observacao = ?WHERE id_matricula=?";
    private static final String ELIMINAR = "DELETE FROM matricula WHERE id_matricula=?";
    
    private static final String BUSCAT_POR_ID = "SELECT c.codigo_ministerio_educacao,	a.data_nascimento, a.sexo, m.estado_matricula,"
            + "a.url_foto_aluno, a.foto_aluno, c.data_criacao, c.nome_curso, c.abreviatura, ac.ano_curricular, t.nome_turma, pl.periodo_letivo,"
            + "al.inicio_ano_letivo, al.fim_ano_letivo,	t.numero_maximo_inscristos, a.bairro_aluno, cl.ciclo_letivo,"
            + "m.data_matricula, a.nome_aluno,	a.telefone_fixo, c.descricao_curso, a.casa_aluno, m.numero_documento, m.observacao, mu.nome_municipio,"
            + "a.email_aluno, a.numero_aluno, a.sobrenome_aluno, a.id_aluno, m.data_emissao_documento, m.id_matricula, a.distrito_aluno, a.telefone_movel, c.conteudo_programatico,	al.ano_letivo, "
            + "f.nome_funcionario, f.sobrenome_funcionario,"
            + " td.tipo_documento_identidade, le.local_emissao_documento "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON  m.id_aluno = a.id_aluno "
            + "INNER JOIN turma t ON m.id_turma =t.id_turma "
            + "INNER JOIN curso c ON m.codigo_curso =c.codigo_curso "
            + "INNER JOIN ano_letivo al ON m.id_ano_letivo =al.id_ano_letivo "
          + "INNER JOIN ciclo_letivo cl ON "
            + " m.id_ciclo_letivo = cl.id_ciclo_letivo INNER JOIN ano_curricular ac ON "
            + "m.id_ano_curricular = ac.id_ano_curricular INNER JOIN municipio mu ON "
            + "a.id_municipio = mu.id_municipio INNER JOIN periodo_letivo pl ON "
            + "t.id_periodo_letivo = pl.id_periodo_letivo INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario "
            + "INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade "
            + "INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento "
            + "WHERE m.id_matricula-?";

    private static final String BUSCAR_TUDO = "SELECT c.codigo_ministerio_educacao,	a.data_nascimento, a.sexo, m.estado_matricula,"
            + "a.url_foto_aluno, a.foto_aluno, c.data_criacao, c.nome_curso, c.abreviatura, ac.ano_curricular, t.nome_turma, pl.periodo_letivo,"
            + "al.inicio_ano_letivo, al.fim_ano_letivo,	t.numero_maximo_inscristos, a.bairro_aluno, cl.ciclo_letivo,"
            + "m.data_matricula, a.nome_aluno,	a.telefone_fixo, c.descricao_curso, a.casa_aluno, m.numero_documento, m.observacao, mu.nome_municipio,"
            + "a.email_aluno, a.numero_aluno, a.sobrenome_aluno, a.id_aluno, m.data_emissao_documento, m.id_matricula, a.distrito_aluno, a.telefone_movel, c.conteudo_programatico,	al.ano_letivo, "
            + "f.nome_funcionario, f.sobrenome_funcionario,"
            + " td.tipo_documento_identidade, le.local_emissao_documento "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON  m.id_aluno = a.id_aluno "
            + "INNER JOIN turma t ON m.id_turma =t.id_turma "
            + "INNER JOIN curso c ON m.codigo_curso =c.codigo_curso "
            + "INNER JOIN ano_letivo al ON m.id_ano_letivo =al.id_ano_letivo "
          + "INNER JOIN ciclo_letivo cl ON "
            + " m.id_ciclo_letivo = cl.id_ciclo_letivo INNER JOIN ano_curricular ac ON "
            + "m.id_ano_curricular = ac.id_ano_curricular INNER JOIN municipio mu ON "
            + "a.id_municipio = mu.id_municipio INNER JOIN periodo_letivo pl ON "
            + "t.id_periodo_letivo = pl.id_periodo_letivo INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario "
            + "INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade "
            + "INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento ";

    private static final String SELECT_BY_TURMA ="SELECT c.codigo_ministerio_educacao,	a.data_nascimento, a.sexo, m.estado_matricula,"
            + "a.url_foto_aluno, a.foto_aluno, c.data_criacao, c.nome_curso, c.abreviatura, ac.ano_curricular, t.nome_turma, pl.periodo_letivo,"
            + "al.inicio_ano_letivo, al.fim_ano_letivo,	t.numero_maximo_inscristos, a.bairro_aluno, cl.ciclo_letivo,"
            + "m.data_matricula, a.nome_aluno,	a.telefone_fixo, c.descricao_curso, a.casa_aluno, m.numero_documento, m.observacao, mu.nome_municipio,"
            + "a.email_aluno, a.numero_aluno, a.sobrenome_aluno, a.id_aluno, m.data_emissao_documento, m.id_matricula, a.distrito_aluno, a.telefone_movel, c.conteudo_programatico,	al.ano_letivo, "
            + "f.nome_funcionario, f.sobrenome_funcionario,"
            + " td.tipo_documento_identidade, le.local_emissao_documento "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON  m.id_aluno = a.id_aluno "
            + "INNER JOIN turma t ON m.id_turma =t.id_turma "
            + "INNER JOIN curso c ON m.codigo_curso =c.codigo_curso "
            + "INNER JOIN ano_letivo al ON m.id_ano_letivo =al.id_ano_letivo "
          + "INNER JOIN ciclo_letivo cl ON "
            + " m.id_ciclo_letivo = cl.id_ciclo_letivo INNER JOIN ano_curricular ac ON "
            + "m.id_ano_curricular = ac.id_ano_curricular INNER JOIN municipio mu ON "
            + "a.id_municipio = mu.id_municipio INNER JOIN periodo_letivo pl ON "
            + "t.id_periodo_letivo = pl.id_periodo_letivo INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario "
            + "INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade "
            + "INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento "
            + "WHERE t.nome_turma=?";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Matricula matricula) {
        if (matricula == null) {
            System.out.println("O parametro passado nao pode nulo");

        }
        try {
            
         
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            
            ps.setDate(1, new java.sql.Date(matricula.getDataMatricula().getTime()));
            
            System.out.println("Dado Recebido Aluno: \t"+matricula.getAluno().getIdAluno());
            ps.setInt(2, matricula.getAluno().getIdAluno());
            ps.setInt(3, matricula.getFuncionario().getIdFuncionario());
            ps.setString(4, matricula.getCurso().getCodigoCurso());
            ps.setInt(5, matricula.getAnoLetivo().getIdAnoLectivo());
            ps.setBoolean(6, matricula.isEstadoMatricula());
            ps.setInt(7, matricula.getTurma().getIdTurma());
            
            System.out.println("Dado Recebido Turma: \t"+matricula.getTurma().getIdTurma());
            ps.setInt(8, matricula.getTipoDocumentoIdentidade().getIdTipoDocumentoIdentidade());
            ps.setDate(9, new java.sql.Date(matricula.getDataEmissaoDocumento().getTime()));
            ps.setInt(10, matricula.getLocalEmissaoDocumento().getIdLocalEmissaoDocumento());
            ps.setString(11, matricula.getNumeroDocumento());
            ps.setInt(12, matricula.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(13, matricula.getAnoCurricular().getIdAnoCurricular());
            ps.setString(14, matricula.getObservacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Matricula matricula) {
        if (matricula == null) {
            System.out.println("O parametro passado nao pode nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setDate(1, new java.sql.Date(matricula.getDataMatricula().getTime()));
            ps.setInt(2, matricula.getAluno().getIdAluno());
            ps.setInt(3, matricula.getFuncionario().getIdFuncionario());
            ps.setString(4, matricula.getCurso().getCodigoCurso());
            ps.setInt(5, matricula.getAnoLetivo().getIdAnoLectivo());
            ps.setBoolean(6, matricula.isEstadoMatricula());
            ps.setInt(7, matricula.getTurma().getIdTurma());
            ps.setInt(8, matricula.getTipoDocumentoIdentidade().getIdTipoDocumentoIdentidade());
            ps.setDate(9, new java.sql.Date(matricula.getDataEmissaoDocumento().getTime()));
            ps.setInt(10, matricula.getLocalEmissaoDocumento().getIdLocalEmissaoDocumento());
            ps.setString(11, matricula.getNumeroDocumento());
            ps.setInt(12, matricula.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(13, matricula.getAnoCurricular().getIdAnoCurricular());
            ps.setString(14, matricula.getObservacao());
            ps.setInt(15, matricula.getIdMatricula());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Matricula matricula) {
        if (matricula == null) {
            System.out.println("O parametro passado nao pode nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, matricula.getIdMatricula());
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Matricula findById(Integer id) {
        Matricula matricula = new Matricula();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAT_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com ID: " + id);

            }
            popularComDados(matricula, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return matricula;

    }

    @Override
    public List<Matricula> findAll() {
        ArrayList<Matricula> itens = new ArrayList<Matricula>();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula();

                popularComDados(matricula, rs);
                itens.add(matricula);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return itens;
    }

    /*Consultas parametrizadas, metodo buscar alunos por turma*/
    public List<Matricula> findByTurma(String turma) {
        ArrayList<Matricula> itens = new ArrayList<Matricula>();

        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_TURMA);
            ps.setString(1, turma);
            rs = ps.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula();

                popularComDados(matricula, rs);
                itens.add(matricula);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return itens;
    }

    @Override
    public void popularComDados(Matricula matricula, ResultSet rs) {
        try {/*
            matricula.setIdMatricula(rs.getInt("id_matricula "));
            matricula.setDataMatricula(rs.getDate("data_matricula "));
            
            Aluno aluno = new Aluno();
            aluno.setNomeAluno(rs.getString("nome_aluno "));
                    aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno  "));
            matricula.setAluno(aluno);
            
           
            
            Curso curso = new Curso();
            curso.setNomeCurso(rs.getString("nome_curso"));
             curso.setAbreviaturaCurso(rs.getString("abreviatura "));
            matricula.setCurso(curso);
            
            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo "));
            matricula.setAnoLetivo(anoLectivo);
            
            matricula.setEstadoMatricula(rs.getInt("estado_matricula "));
            
            Turma turma = new Turma();
            turma.setNomeTurma(rs.getString("nome_turma "));
            matricula.setTurma(turma);
            
            
            
            matricula.setDataEmissaoDocumento(rs.getDate("data_emissao_documento "));
            
           
            
            matricula.setNumeroDocumento(rs.getString("numero_documento "));
            
            CicloLectivo cicloLectivo = new CicloLectivo();
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo "));
            matricula.setCicloLectivo(cicloLectivo);
            
            AnoCurricular anoCurricular = new AnoCurricular();
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular "));
            matricula.setAnoLetivo(anoLectivo);
            
            matricula.setObservacao(rs.getString("observacao "));
            
             */
            matricula.setIdMatricula(rs.getInt("id_matricula"));
            matricula.setDataMatricula(rs.getDate("data_matricula"));
            matricula.setEstadoMatricula(rs.getBoolean("estado_matricula"));
            matricula.setDataEmissaoDocumento(rs.getDate("data_emissao_documento"));
            matricula.setNumeroDocumento(rs.getString("numero_documento"));
            matricula.setObservacao(rs.getString("observacao"));
            Aluno aluno = new Aluno();

            aluno.setIdAluno(rs.getInt("id_aluno"));
//            aluno.setNumeroAluno(rs.getString("numero_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimentoAluno(rs.getDate("data_nascimento"));

            aluno.setCasaAluno(rs.getString("casa_aluno"));
            aluno.setBairroAluno(rs.getString("bairro_aluno"));
            aluno.setDistritoAluno(rs.getString("distrito_aluno"));

            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            aluno.setMunicipioAluno(municipio);
            aluno.setUrlfotoAluno(rs.getString("url_foto_aluno"));

            aluno.setFotoAluno(rs.getBytes("foto_aluno"));
            aluno.setTelefoneFixoAluno(rs.getString("telefone_fixo"));
            aluno.setTelefoneMovelAluno(rs.getString("telefone_movel"));
            aluno.setEmailAluno(rs.getString("email_aluno"));

            aluno.setSexo(Sexo.getAbreviatura(rs.getString("sexo")));

            matricula.setAluno(aluno);

            AnoCurricular anoCurricular = new AnoCurricular();
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular"));
            matricula.setAnoCurricular(anoCurricular);

            CicloLectivo cicloLectivo = new CicloLectivo();
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            matricula.setCicloLectivo(cicloLectivo);

            AnoLectivo anoLectivo = new AnoLectivo();
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            anoLectivo.setInicioAnoLetivo(rs.getDate("inicio_ano_letivo"));
            anoLectivo.setFimAnoLetivo(rs.getDate("fim_ano_letivo"));
            matricula.setAnoLetivo(anoLectivo);

            Turma turma = new Turma();
            turma.setNomeTurma(rs.getString("nome_turma"));
            turma.setNumeroMaximoInscritos(rs.getInt("numero_maximo_inscristos"));
            matricula.setTurma(turma);

            PeriodoLectivo periodoLectivo = new PeriodoLectivo();
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            turma.setPeriodoLectivo(periodoLectivo);

            Curso curso = new Curso();
            curso.setNomeCurso(rs.getString("nome_curso"));
            curso.setAbreviaturaCurso(rs.getString("abreviatura"));
            curso.setCodigoMinisterioDaEducação(rs.getString("codigo_ministerio_educacao"));
            curso.setDataCriacao(rs.getDate("data_criacao"));
            curso.setDescricaoCurso(rs.getString("descricao_curso"));
            curso.setConteudoProgramaticoCurso(rs.getString("conteudo_programatico"));
            matricula.setCurso(curso);

            LocalEmissaoDocumento localEmissaoDocumento = new LocalEmissaoDocumento();
            localEmissaoDocumento.setLocalEmissaoDocumento(rs.getString("local_emissao_documento"));
            matricula.setLocalEmissaoDocumento(localEmissaoDocumento);

            TipoDocumentoIdentidade tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
            tipoDocumentoIdentidade.setTipoDOcumentoIdentidade(rs.getString("tipo_documento_identidade"));
            matricula.setTipoDocumentoIdentidade(tipoDocumentoIdentidade);

            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            funcionario.setSobrenomeFuncionario(rs.getString("sobrenome_funcionario"));

            matricula.setFuncionario(funcionario);
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados" + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        List<Matricula> matriculas = matriculaDAO.findByTurma("BO");

        for (Matricula matricula : matriculas) {
            System.out.println(matricula.getAluno().getNomeAluno()+" "+matricula.getAluno().getSobrenomeAluno());
               

        }
    }
}
