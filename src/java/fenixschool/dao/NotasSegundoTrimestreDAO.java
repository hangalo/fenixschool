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
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.NotasPrimeiroTrimestre;
import fenixschool.modelo.NotasSegundoTrimestre;
import fenixschool.modelo.PeriodoLectivo;
import fenixschool.modelo.Turma;
import fenixschool.util.Conexao;
import fenixschool.util.DateUtil;
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
public class NotasSegundoTrimestreDAO implements GenericoDAO<NotasSegundoTrimestre>{
     Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public NotasSegundoTrimestreDAO() {
    }
    
    /*
 id_nota             
| id_periodo_letivo  
| id_aluno            
| codigo_curso       
| data_lancamento     
| nota_primeira_prova 
| nota_segunda_prova  
| id_ano_letivo       
| id_ciclo_letivo   
| id_disciplina      
| id_turma           
| id_ano_curricular
     */
     private static final String INSERIR = "INSERT INTO notas_segundo_trimestre("
          
            + "id_periodo_letivo,"
            + "id_aluno,"
            + "codigo_curso,"
            + "data_lancamento,"
            + "nota_primeira_prova,"
            + "nota_segunda_prova, "
            + "id_ano_letivo, "
            + "id_ciclo_letivo, "
            + "id_disciplina, "
            + "id_turma,"
            + "id_ano_curricular)"
             + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String ACTUALIZAR = "UPDATE notas_segundo_trimestre SET "
            + "id_periodo_letivo = ?,"
            + "id_aluno = ?,"
            + "codigo_curso = ?"
            + ",data_lancamento = ?,"
            + "nota_primeira_prova = ?,"
            + "nota_segunda_prova = ?"
            + ",id_ano_letivo = ?"
            + ", id_ciclo_letivo=?,"
            + "id_disciplina=?,"
            + "id_turma=?, "
            + "id_ano_curricular=?  "
            + "WHERE id_nota = ?";
  
   private static final String ACTUALIZAR_NOTAS_POR_ALUNO = "UPDATE notas_segundo_trimestre SET "
            + "id_periodo_letivo = ?,"
            + "codigo_curso = ?"
            + ",data_lancamento = ?,"
            + "nota_primeira_prova = ?,"
            + "nota_segunda_prova = ?"
            + ",id_ano_letivo = ?"
            + ", id_ciclo_letivo=?,"
            + "id_disciplina=?,"
            + "id_turma=?, "
            + "id_ano_curricular=?  "
            + "WHERE id_aluno = ?";

      private static final String ELIMINAR = "DELETE FROM notas_segundo_trimestre WHERE id_nota=?";

       private static final String LISTAR_TUDO = "SELECT n.nota_primeira_prova, "
            + "n.id_nota, "
            + "ci.ciclo_letivo,"
            + "p.periodo_letivo,"
            + "n.nota_segunda_prova, "
            + "c.nome_curso,"
            + "d.nome_disciplina, "
            + "ac.ano_curricular, "
            + "t.nome_turma, "
            + "al.ano_letivo, "
            + "a.nome_aluno, "
            + "a.sexo, "
            + "a.sobrenome_aluno, "
            + "m.id_matricula "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON "
            + " m.id_aluno = a.id_aluno "
            + " INNER JOIN notas_segundo_trimestre n ON "
            + " n.id_aluno = a.id_aluno "
            + "INNER JOIN ano_letivo al ON "
            + " m.id_ano_letivo = al.id_ano_letivo "
            + "INNER JOIN turma t ON "
            + "m.id_turma = t.id_turma "
            + "INNER JOIN disciplina d ON "
            + "n.id_disciplina = d.id_disciplina "
            + "INNER JOIN ano_curricular ac ON "
            + "m.id_ano_curricular = ac.id_ano_curricular "
            + "INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo "
            + "INNER JOIN ciclo_letivo ci ON m.id_ciclo_letivo = ci.id_ciclo_letivo "
            + "INNER JOIN curso c ON n.codigo_curso=c.codigo_curso "
            + "Order by a.nome_aluno";
       
       
         private static final String BUSCAR_POR_CODIGO = "SELECT n.nota_primeira_prova, "
            + "n.id_nota, "
            + "ci.ciclo_letivo,"
            + "p.periodo_letivo,"
            + "n.nota_segunda_prova, "
            + "c.nome_curso,"
            + "d.nome_disciplina, "
            + "ac.ano_curricular, "
            + "t.nome_turma, "
            + "al.ano_letivo, "
            + "a.nome_aluno, "
            + "a.sexo, "
            + "a.sobrenome_aluno, "
            + "m.id_matricula "
            + "FROM matricula m "
            + "INNER JOIN aluno a ON "
            + " m.id_aluno = a.id_aluno "
            + " INNER JOIN notas_segundo_trimestre n ON "
            + " n.id_aluno = a.id_aluno "
            + "INNER JOIN ano_letivo al ON "
            + " m.id_ano_letivo = al.id_ano_letivo "
            + "INNER JOIN turma t ON "
            + "m.id_turma = t.id_turma "
            + "INNER JOIN disciplina d ON "
            + "n.id_disciplina = d.id_disciplina "
            + "INNER JOIN ano_curricular ac ON "
            + "m.id_ano_curricular = ac.id_ano_curricular "
            + "INNER JOIN periodo_letivo p ON n.id_periodo_letivo=p.id_periodo_letivo "
            + "INNER JOIN ciclo_letivo ci ON m.id_ciclo_letivo = ci.id_ciclo_letivo "
            + "INNER JOIN curso c ON n.codigo_curso=c.codigo_curso "
            + "WHERE n.id_nota =?";


    @Override
    public void save(NotasSegundoTrimestre segundoTrimestre) {
        
        
        
          if (segundoTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, segundoTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, segundoTrimestre.getAluno().getIdAluno());
            ps.setString(3, segundoTrimestre.getCurso().getCodigoCurso());
            ps.setDate(4, new java.sql.Date(segundoTrimestre.getDataLancamento().getTime()));
            ps.setDouble(5, segundoTrimestre.getNotaPrimeiraProva());
            ps.setDouble(6, segundoTrimestre.getNotaSegundaProva());
            ps.setInt(7, segundoTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, segundoTrimestre.getCicloLetivo().getIdCicloLectivo());
             ps.setString(9, segundoTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(10, segundoTrimestre.getTurma().getIdTurma());
           ps.setInt(11, segundoTrimestre.getAnoCurricular().getIdAnoCurricular());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    
  
    
    }

    @Override
    public void update(NotasSegundoTrimestre segundoTrimestre) {
        
          if (segundoTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, segundoTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, segundoTrimestre.getAluno().getIdAluno());
            ps.setString(3, segundoTrimestre.getCurso().getCodigoCurso());
            ps.setDate(4, new java.sql.Date(segundoTrimestre.getDataLancamento().getTime()));
            ps.setDouble(5, segundoTrimestre.getNotaPrimeiraProva());
            ps.setDouble(6, segundoTrimestre.getNotaSegundaProva());
            ps.setInt(7, segundoTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, segundoTrimestre.getCicloLetivo().getIdCicloLectivo());
            ps.setString(9, segundoTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(10, segundoTrimestre.getTurma().getIdTurma());
            ps.setInt(11, segundoTrimestre.getAnoCurricular().getIdAnoCurricular());
            ps.setInt(12, segundoTrimestre.getIdNota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
  
    }

    @Override
    public void delete(NotasSegundoTrimestre segundoTrimestre) {
   
         if (segundoTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, segundoTrimestre.getIdNota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public NotasSegundoTrimestre findById(Integer id) {
   
            NotasSegundoTrimestre segundoTrimestre = new NotasSegundoTrimestre();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");

            }
            popularComDados(segundoTrimestre, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return segundoTrimestre;
    }

    @Override
    public List<NotasSegundoTrimestre> findAll() {
    List<NotasSegundoTrimestre> notasSegundoTrimestres = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                NotasSegundoTrimestre segundoTrimestre = new NotasSegundoTrimestre();
                popularComDados(segundoTrimestre, rs);
                notasSegundoTrimestres.add(segundoTrimestre);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return notasSegundoTrimestres;
    
    }
public void updatePorAluno(NotasSegundoTrimestre segundoTrimestre) {

        if (segundoTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR_NOTAS_POR_ALUNO);
            ps.setInt(1, segundoTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
          
            ps.setString(2, segundoTrimestre.getCurso().getCodigoCurso());
            ps.setDate(3, new java.sql.Date(segundoTrimestre.getDataLancamento().getTime()));
            ps.setDouble(4, segundoTrimestre.getNotaPrimeiraProva());
            ps.setDouble(5, segundoTrimestre.getNotaSegundaProva());
            ps.setInt(6, segundoTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(7, segundoTrimestre.getCicloLetivo().getIdCicloLectivo());
            ps.setString(8, segundoTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(9, segundoTrimestre.getTurma().getIdTurma());
            ps.setInt(10, segundoTrimestre.getAnoCurricular().getIdAnoCurricular());
             ps.setInt(11, segundoTrimestre.getAluno().getIdAluno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }
    @Override
    public void popularComDados(NotasSegundoTrimestre segundoTrimestre, ResultSet rs) {
   
        
        try {

            PeriodoLectivo periodoLectivo = new PeriodoLectivo();
            Aluno aluno = new Aluno();
            Curso curso = new Curso();
            Disciplina disciplina = new Disciplina();
            AnoLectivo anoLectivo = new AnoLectivo();
            CicloLectivo cicloLectivo = new CicloLectivo();

            Turma turma = new Turma();
            AnoCurricular anoCurricular = new AnoCurricular();

            segundoTrimestre.setIdNota(rs.getInt("id_nota"));
            periodoLectivo.setPeriodoLectivo(rs.getString("periodo_letivo"));
            segundoTrimestre.setPeriodoLetivo(periodoLectivo);
            aluno.setSobrenomeAluno(rs.getString("sobrenome_aluno"));
            aluno.setNomeAluno(rs.getString("nome_aluno"));

            segundoTrimestre.setAluno(aluno);
            curso.setNomeCurso(rs.getString("nome_curso"));
            segundoTrimestre.setCurso(curso);
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            segundoTrimestre.setDisciplina(disciplina);
            // nota.setDescricao(rs.getString("descricao"));
            // nota.setDataLancamento(rs.getDate("data_lancamento"));

            segundoTrimestre.setNotaPrimeiraProva(rs.getDouble("nota_primeira_prova"));
            segundoTrimestre.setNotaSegundaProva(rs.getDouble("nota_segunda_prova"));

            // nota.setPeso(rs.getDouble("peso"));
            anoLectivo.setAnoLectivo(rs.getString("ano_letivo"));
            segundoTrimestre.setAluno(aluno);
            cicloLectivo.setCicloLectivo(rs.getString("ciclo_letivo"));
            segundoTrimestre.setCicloLetivo(cicloLectivo);

            turma.setNomeTurma(rs.getString("nome_turma"));
            segundoTrimestre.setTurma(turma);
            anoCurricular.setAnoCurricular(rs.getString("ano_curricular"));
            segundoTrimestre.setAnoCurricular(anoCurricular);
            // nota.setObservacao(rs.getString("observacao"));

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados" + ex.getMessage());
        }

    }
     public static void main(String[] args) {
        NotasSegundoTrimestre segundoTrimestre = new NotasSegundoTrimestre();
        NotasSegundoTrimestreDAO segundoTrimestreDAO=new NotasSegundoTrimestreDAO();
        
            /*
 id_nota             
| id_periodo_letivo  
| id_aluno            
| codigo_curso       
| data_lancamento     
| nota_primeira_prova 
| nota_segunda_prova  
| id_ano_letivo       
| id_ciclo_letivo   
| id_disciplina      
| id_turma           
| id_ano_curricular
     */
            
            
            
            PeriodoLectivo periodoLectivo=new PeriodoLectivo();
            periodoLectivo.setIdPeriodoLectivo(7);
            segundoTrimestre.setPeriodoLetivo(periodoLectivo);
            Aluno aluno=new Aluno();
            aluno.setIdAluno(17);
            segundoTrimestre.setAluno(aluno);
            Curso curso=new Curso();
            curso.setCodigoCurso("MAT");
            segundoTrimestre.setCurso(curso);
            segundoTrimestre.setDataLancamento(DateUtil.strToDate("2000/05/02"));
            segundoTrimestre.setNotaPrimeiraProva(10);
             segundoTrimestre.setNotaSegundaProva(15);
             AnoLectivo anoLectivo=new AnoLectivo();
             anoLectivo.setIdAnoLectivo(2);
             segundoTrimestre.setAnoLetivo(anoLectivo);
             CicloLectivo cicloLectivo=new CicloLectivo();
             cicloLectivo.setIdCicloLectivo(2);
             segundoTrimestre.setCicloLetivo(cicloLectivo);
             Disciplina disciplina=new Disciplina();
             disciplina.setIdDisciplina("8");
             segundoTrimestre.setDisciplina(disciplina);
             Turma turma=new Turma();
             turma.setIdTurma(3);
             segundoTrimestre.setTurma(turma);
             AnoCurricular anoCurricular=new AnoCurricular();
             anoCurricular.setIdAnoCurricular(5);
             segundoTrimestre.setAnoCurricular(anoCurricular);
                 segundoTrimestre.setIdNota(3);
        segundoTrimestreDAO.update(segundoTrimestre);
    }
}
