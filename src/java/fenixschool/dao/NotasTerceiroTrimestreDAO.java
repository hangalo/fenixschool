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
import fenixschool.modelo.NotasTerceiroTrimestre;
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
public class NotasTerceiroTrimestreDAO implements GenericoDAO<NotasTerceiroTrimestre>{
    
     Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public NotasTerceiroTrimestreDAO() {
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
     private static final String INSERIR = "INSERT INTO notas_terceiro_trimestre("
          
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
     
      private static final String ACTUALIZAR = "UPDATE notas_terceiro_trimestre SET "
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

       private static final String ACTUALIZAR_NOTAS_POR_ALUNO = "UPDATE notas_terceiro_trimestre SET "
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
       
          private static final String ELIMINAR = "DELETE FROM notas_terceiro_trimestre WHERE id_nota=?";

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
            + " INNER JOIN notas_terceiro_trimestre n ON "
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
            + " INNER JOIN notas_terceiro_trimestre n ON "
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
    public void save(NotasTerceiroTrimestre terceiroTrimestre) {
        
          
        
        
          if (terceiroTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setInt(1, terceiroTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, terceiroTrimestre.getAluno().getIdAluno());
            ps.setString(3, terceiroTrimestre.getCurso().getCodigoCurso());
            ps.setDate(4, new java.sql.Date(terceiroTrimestre.getDataLancamento().getTime()));
            ps.setDouble(5, terceiroTrimestre.getNotaPrimeiraProva());
            ps.setDouble(6, terceiroTrimestre.getNotaSegundaProva());
            ps.setInt(7, terceiroTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, terceiroTrimestre.getCicloLetivo().getIdCicloLectivo());
             ps.setString(9, terceiroTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(10, terceiroTrimestre.getTurma().getIdTurma());
           ps.setInt(11, terceiroTrimestre.getAnoCurricular().getIdAnoCurricular());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    
  
    }

    @Override
    public void update(NotasTerceiroTrimestre terceiroTrimestre) {
        
        
          if (terceiroTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setInt(1, terceiroTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
            ps.setInt(2, terceiroTrimestre.getAluno().getIdAluno());
            ps.setString(3, terceiroTrimestre.getCurso().getCodigoCurso());
            ps.setDate(4, new java.sql.Date(terceiroTrimestre.getDataLancamento().getTime()));
            ps.setDouble(5, terceiroTrimestre.getNotaPrimeiraProva());
            ps.setDouble(6, terceiroTrimestre.getNotaSegundaProva());
            ps.setInt(7, terceiroTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(8, terceiroTrimestre.getCicloLetivo().getIdCicloLectivo());
            ps.setString(9, terceiroTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(10, terceiroTrimestre.getTurma().getIdTurma());
            ps.setInt(11, terceiroTrimestre.getAnoCurricular().getIdAnoCurricular());
            ps.setInt(12, terceiroTrimestre.getIdNota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
  
  
    }

    @Override
    public void delete(NotasTerceiroTrimestre terceiroTrimestre) {
   
         if (terceiroTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, terceiroTrimestre.getIdNota());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    
    }

    @Override
    public NotasTerceiroTrimestre findById(Integer id) {
   
            NotasTerceiroTrimestre terceiroTrimestre = new NotasTerceiroTrimestre();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");

            }
            popularComDados(terceiroTrimestre, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return terceiroTrimestre;
    
    }

    @Override
    public List<NotasTerceiroTrimestre> findAll() {
   
            List<NotasTerceiroTrimestre> notasTerceiroTrimestres = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                NotasTerceiroTrimestre terceiroTrimestre = new NotasTerceiroTrimestre();
                popularComDados(terceiroTrimestre, rs);
                notasTerceiroTrimestres.add(terceiroTrimestre);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return notasTerceiroTrimestres;
    }

    public void updatePorAluno(NotasTerceiroTrimestre terceiroTrimestre) {

        if (terceiroTrimestre == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR_NOTAS_POR_ALUNO);
            ps.setInt(1, terceiroTrimestre.getPeriodoLetivo().getIdPeriodoLectivo());
          
            ps.setString(2, terceiroTrimestre.getCurso().getCodigoCurso());
            ps.setDate(3, new java.sql.Date(terceiroTrimestre.getDataLancamento().getTime()));
            ps.setDouble(4, terceiroTrimestre.getNotaPrimeiraProva());
            ps.setDouble(5, terceiroTrimestre.getNotaSegundaProva());
            ps.setInt(6, terceiroTrimestre.getAnoLetivo().getIdAnoLectivo());
            ps.setInt(7, terceiroTrimestre.getCicloLetivo().getIdCicloLectivo());
            ps.setString(8, terceiroTrimestre.getDisciplina().getIdDisciplina());
            ps.setInt(9, terceiroTrimestre.getTurma().getIdTurma());
            ps.setInt(10, terceiroTrimestre.getAnoCurricular().getIdAnoCurricular());
             ps.setInt(11, terceiroTrimestre.getAluno().getIdAluno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }
    @Override
    public void popularComDados(NotasTerceiroTrimestre t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public static void main(String[] args) {
        NotasTerceiroTrimestre terceiroTrimestre = new NotasTerceiroTrimestre();
        NotasTerceiroTrimestreDAO terceiroTrimestreDAO=new NotasTerceiroTrimestreDAO();
        
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
            terceiroTrimestre.setPeriodoLetivo(periodoLectivo);
            Aluno aluno=new Aluno();
            aluno.setIdAluno(17);
            terceiroTrimestre.setAluno(aluno);
            Curso curso=new Curso();
            curso.setCodigoCurso("MAT");
            terceiroTrimestre.setCurso(curso);
            terceiroTrimestre.setDataLancamento(DateUtil.strToDate("2000/05/02"));
            terceiroTrimestre.setNotaPrimeiraProva(2);
             terceiroTrimestre.setNotaSegundaProva(9);
             AnoLectivo anoLectivo=new AnoLectivo();
             anoLectivo.setIdAnoLectivo(2);
             terceiroTrimestre.setAnoLetivo(anoLectivo);
             CicloLectivo cicloLectivo=new CicloLectivo();
             cicloLectivo.setIdCicloLectivo(2);
             terceiroTrimestre.setCicloLetivo(cicloLectivo);
             Disciplina disciplina=new Disciplina();
             disciplina.setIdDisciplina("8");
             terceiroTrimestre.setDisciplina(disciplina);
             Turma turma=new Turma();
             turma.setIdTurma(3);
             terceiroTrimestre.setTurma(turma);
             AnoCurricular anoCurricular=new AnoCurricular();
             anoCurricular.setIdAnoCurricular(5);
             terceiroTrimestre.setAnoCurricular(anoCurricular);
                     terceiroTrimestre.setIdNota(3);
             terceiroTrimestreDAO.update(terceiroTrimestre);
    }

}
