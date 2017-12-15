package fenixschool.dao;

import fenixschool.modelo.Curso;
import fenixschool.modelo.Disciplina;
import fenixschool.modelo.DisciplinasDoCurso;
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
public class DisciplinasDoCursoDAO implements GenericoDAO<DisciplinasDoCurso> {

    private static final String INSERT = "INSERT INTO curso_disciplina (codigo_curso,id_disciplina) VALUES (?,?);";
    private static final String UPDATE = "UPDATE curso_disciplina SET codigo_curso = ?, id_disciplina = ? WHERE id_curso_disciplina = ?";
    private static final String DELETE = "DELETE FROM curso_disciplina WHERE id_curso_disciplina = ?";
    private static final String SELECT_BY_ID = "SELECT cd.id_curso_disciplina,d.id_disciplina, d.nome_disciplina,c.codigo_curso, c.nome_curso,d.descricao_displina,c.descricao_curso,c.codigo_ministerio_educacao FROM curso_disciplina cd INNER JOIN curso c ON (cd.codigo_curso = c.codigo_curso) INNER JOIN disciplina d ON (cd.id_disciplina = d.id_disciplina) WHERE cd.id_curso_disciplina =? ORDER by c.nome_curso";
    private static final String SELECT_BY_CURSO = "SELECT cd.id_curso_disciplina,d.id_disciplina, d.nome_disciplina,c.codigo_curso, c.nome_curso,d.descricao_displina,c.descricao_curso,c.codigo_ministerio_educacao FROM curso_disciplina cd INNER JOIN curso c ON (cd.codigo_curso = c.codigo_curso) INNER JOIN disciplina d ON (cd.id_disciplina = d.id_disciplina) WHERE c.nome_curso LIKE ? ORDER by c.nome_curso";
    private static final String SELECT_ALL = "SELECT cd.id_curso_disciplina,d.id_disciplina, d.nome_disciplina,c.codigo_curso, c.nome_curso,d.descricao_displina,c.descricao_curso,c.codigo_ministerio_educacao FROM curso_disciplina cd INNER JOIN curso c ON (cd.codigo_curso = c.codigo_curso) INNER JOIN disciplina d ON (cd.id_disciplina = d.id_disciplina) ORDER by c.nome_curso";

    public DisciplinasDoCursoDAO() {
    }

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public DisciplinasDoCursoDAO(Connection conn, PreparedStatement ps, ResultSet rs) {
        this.conn = conn;
        this.ps = ps;
        this.rs = rs;
    }

    @Override
    public void save(DisciplinasDoCurso discipCurso) {
        if (discipCurso == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, discipCurso.getCurso().getCodigoCurso());
            ps.setString(2, discipCurso.getDisciplina().getIdDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(DisciplinasDoCurso discipCurso) {
        if (discipCurso == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, discipCurso.getCurso().getCodigoCurso());
            ps.setString(2, discipCurso.getDisciplina().getIdDisciplina());
            ps.setInt(3, discipCurso.getIdCursoDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao actualizar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(DisciplinasDoCurso discipCurso) {
        if (discipCurso == null) {
            System.out.println("O campo passado nao pode ser nulo");
        }

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, discipCurso.getIdCursoDisciplina());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public DisciplinasDoCurso findById(Integer id) {
        DisciplinasDoCurso disciplinasDoCurso = new DisciplinasDoCurso();
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum registo com esse id: " + id);

            }
            popularComDados(disciplinasDoCurso, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplinasDoCurso;
    }

    public List<DisciplinasDoCurso> findByCurso(String curso) {
        List<DisciplinasDoCurso> disciplinasDoCursos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_CURSO);
            ps.setString(1, curso);
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplinasDoCurso disciplinasDoCurso = new DisciplinasDoCurso();
                popularComDados(disciplinasDoCurso, rs);
                disciplinasDoCursos.add(disciplinasDoCurso);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplinasDoCursos;
    }

    @Override
    public List<DisciplinasDoCurso> findAll() {
        List<DisciplinasDoCurso> disciplinasDoCursos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplinasDoCurso disciplinasDoCurso = new DisciplinasDoCurso();
                popularComDados(disciplinasDoCurso, rs);
                disciplinasDoCursos.add(disciplinasDoCurso);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return disciplinasDoCursos;
    }

    @Override
    public void popularComDados(DisciplinasDoCurso discipCurso, ResultSet rs) {
        try {
            Disciplina disciplina = new Disciplina();
            Curso curso = new Curso();

            discipCurso.setIdCursoDisciplina(rs.getInt("id_curso_disciplina"));

            disciplina.setIdDisciplina(rs.getString("id_disciplina"));
            disciplina.setNomeDisciplina(rs.getString("nome_disciplina"));
            disciplina.setDescricaoDisplina(rs.getString("descricao_displina"));
            discipCurso.setDisciplina(disciplina);

            //id_disciplina
            //codigo_curso
            curso.setCodigoCurso(rs.getString("codigo_curso"));
            curso.setNomeCurso(rs.getString("nome_curso"));
            curso.setDescricaoCurso(rs.getString("descricao_curso"));
            curso.setCodigoMinisterioDaEducação(rs.getString("codigo_ministerio_educacao"));
            discipCurso.setCurso(curso);

        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados: " + ex.getMessage());
        }
    }

}
