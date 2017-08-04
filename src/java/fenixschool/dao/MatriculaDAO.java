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
import fenixschool.modelo.TipoDocumentoIdentidade;
import fenixschool.modelo.Turma;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HACKER
 */
public class MatriculaDAO implements GenericoDAO<Matricula> {

    private static final String INSERIR = "INSERT INTO matricula(id_matricula,data_matricula,id_aluno,id_funcionario,codigo_curso,id_ano_letivo,estado_matricula,id_turma,id_tipo_documento_identidade,data_emissao_documento,id_local_emissao_documento,numero_documento,id_ciclo_letivo,id_ano_curricular,observacao)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ATUALIZAR = "UPDATE matricula SET id_matricula = ?,data_matricula = ?,id_aluno = ?,id_funcionario = ?,codigo_curso = ?,id_ano_letivo = ?,estado_matricula = ?,id_turma = ?,id_tipo_documento_identidade = ?,data_emissao_documento = ?,id_local_emissao_documento = ?,numero_documento = ?,id_ciclo_letivo = ?,id_ano_curricular = ?,observacao = ?WHERE id_matricula=?";
    private static final String ELIMINAR = "DELETE FROM matricula WHERE id_matricula=?";
    private static final String BUSCAT_POR_ID = "SELECT id_matricula m, data_matricula m, nome_aluno a, sobrenome_aluno a, nome_funcionario f, sobrenome_funcionario f, nome_curso c, abreviatura c, ano_letivo an, estado_matricula m, nome_turma t, tipo_documento_identidade td, data_emissao_documento m, local_emissao_documento le, numero_documento m, ciclo_letivo cl, ano_curricular ac, observacao m "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON m.id_aluno=a.id_aluno "
            + "INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario "
            + "INNER JOIN curso c ON c.codigo_curso=m.codigo_curso "
            + "INNER JOIN ano_letivo an ON m.id_ano_letivo=an.id_ano_letivo "
            + "INNER JOIN turma t ON m.id_turma=t.id_turma "
            + "INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade "
            + "INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento "
            + "INNER JOIN ciclo_letivo cl ON m.id_ciclo_letivo=cl.id_ciclo_letivo "
            + "INNER JOIN ano_curricular ac ON m.id_ano_curricular=ac.id_ano_curricular WHERE m.id_matricula-?";
   
    private static final String BUSCAR_TUDO = "SELECT id_matricula m, data_matricula m, nome_aluno a, sobrenome_aluno a, nome_funcionario f, sobrenome_funcionario f, nome_curso c, abreviatura c, ano_letivo an, estado_matricula m, nome_turma t, tipo_documento_identidade td, data_emissao_documento m, local_emissao_documento le, numero_documento m, ciclo_letivo cl, ano_curricular ac, observacao m "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON m.id_aluno=a.id_aluno "
            + "INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario "
            + "INNER JOIN curso c ON c.codigo_curso=m.codigo_curso "
            + "INNER JOIN ano_letivo an ON m.id_ano_letivo=an.id_ano_letivo "
            + "INNER JOIN turma t ON m.id_turma=t.id_turma "
            + "INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade "
            + "INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento "
            + "INNER JOIN ciclo_letivo cl ON m.id_ciclo_letivo=cl.id_ciclo_letivo "
            + "INNER JOIN ano_curricular ac ON m.id_ano_curricular=ac.id_ano_curricular;";
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Matricula matricula){
        if (matricula==null) {
            System.out.println("O parametro passado nao pode nulo");
            
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setDate(1, new java.sql.Date(matricula.getDataMatricula().getTime()));
            ps.setInt(2, matricula.getAluno().getIdAluno());
            ps.setInt(3, matricula.getFuncionario().getIdFuncionario());
            ps.setInt(4, matricula.getCurso().getCodigoCurso());
            ps.setInt(5, matricula.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(6, matricula.getEstadoMatricula());
            ps.setInt(7, matricula.getTurma().getIdTurma());
            ps.setInt(8, matricula.getTipoDocumentoIdentidade().getIdTipoDocumentoIdentidade());
            ps.setDate(9, new java.sql.Date(matricula.getDataEmissaoDocumento().getTime()));
            ps.setInt(10, matricula.getLocalEmissaoDocumento().getIdLocalEmissaoDocumento());
            ps.setString(11, matricula.getNumeroDocumento());
            ps.setInt(12, matricula.getCicloLectivo().getIdCicloLectivo());
            ps.setInt(13, matricula.getAnoCurricular().getIdAnoCurricular());
            ps.setString(14, matricula.getObservacao());
            ps.setString(15, matricula.getObservacao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar dados"+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void update(Matricula matricula) {
         if (matricula==null) {
            System.out.println("O parametro passado nao pode nulo");
            
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ATUALIZAR);
            ps.setDate(1, new java.sql.Date(matricula.getDataMatricula().getTime()));
            ps.setInt(2, matricula.getAluno().getIdAluno());
            ps.setInt(3, matricula.getFuncionario().getIdFuncionario());
            ps.setInt(4, matricula.getCurso().getCodigoCurso());
            ps.setInt(5, matricula.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(6, matricula.getEstadoMatricula());
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
            System.out.println("Erro ao atualizar dados"+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Matricula matricula) {
         if (matricula==null) {
            System.out.println("O parametro passado nao pode nulo");
            
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, matricula.getIdMatricula());
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar dados"+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Matricula findById(Integer id){
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
            
            
        }  catch (SQLException ex) {
            System.out.println("Erro ao carregar dados"+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn, ps, rs);
        }
        return matricula;

    }

    @Override
    public List<Matricula> findAll(){
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
           
        }  catch (SQLException ex) {
            System.out.println("Erro ao carregar dados"+ex.getMessage());
        }finally{
            Conexao.closeConnection(conn);
        }
         return itens;
    }

    @Override
    public void popularComDados(Matricula matricula, ResultSet rs){
        try {
            matricula.setIdMatricula(rs.getInt("id_matricula "));
            matricula.setDataMatricula(rs.getDate("data_matricula "));
            
            Aluno aluno = new Aluno();
            aluno.setNomeAluno(rs.getString("nome_aluno "));
                    aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno  "));
            matricula.setAluno(aluno);
            
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario "));
            funcionario.setSobrenomeFuncionario(rs.getString("sobrenome_funcionario  "));
            
            matricula.setFuncionario(funcionario);
            
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
            
            TipoDocumentoIdentidade tipoDocumentoIdentidade = new TipoDocumentoIdentidade();
            tipoDocumentoIdentidade.setTipoDOcumentoIdentidade(rs.getString("tipo_documento_identidade "));
            matricula.setTipoDocumentoIdentidade(tipoDocumentoIdentidade);
            
            matricula.setDataEmissaoDocumento(rs.getDate("data_emissao_documento "));
            
            LocalEmissaoDocumento localEmissaoDocumento = new LocalEmissaoDocumento();
            localEmissaoDocumento.setLocalEmissaoDocumento(rs.getString("local_emissao_documento "));
            matricula.setLocalEmissaoDocumento(localEmissaoDocumento);
            
            matricula.setNumeroDocumento(rs.getString("numero_documento "));
            
            CicloLectivo cicloLectivo = new CicloLectivo();
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo "));
            matricula.setCicloLectivo(cicloLectivo);
            
            AnoCurricular anoCurricular = new AnoCurricular();
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular "));
            matricula.setAnoLetivo(anoLectivo);
            
            matricula.setObservacao(rs.getString("observacao "));
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados"+ex.getMessage());
        }

    }
}
