package fenixschool.dao;

import fenixschool.modelo.Departamento;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoDAO implements GenericoDAO<Departamento> {

    private static final String INSERIR = "INSERT INTO departamento (nome_departamento) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE departamento set nome_departamento=? WHERE id_departamento=?";
    private static final String ELIMINAR = "DELETE FROM departamento WHERE id_departamento=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM  departamento WHERE id_departamento=?";
    private static final String LISTAR_TUDO = "SELECT * FROM departamento";

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void save(Departamento departamento) {

        if (departamento == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao guardar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Departamento departamento) {
        if (departamento == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setInt(2, departamento.getIdDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public void delete(Departamento departamento) {
        if (departamento == null) {

            System.out.println("O campo anterior nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, departamento.getIdDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao eliminar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public Departamento findById(Integer id) {

        Departamento departamento = new Departamento();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Nao existe nenhum dado com esse ID.");

            }
            popularComDados(departamento, rs);

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return departamento;
    }

    @Override
    public List<Departamento> findAll() {

        ArrayList<Departamento> itens = new ArrayList<Departamento>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();

            while (rs.next()) {
                Departamento departamento = new Departamento();
                popularComDados(departamento, rs);
                itens.add(departamento);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar registo" + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        return itens;
    }

    @Override
    public void popularComDados(Departamento departamento, ResultSet rs) {
        try {
            departamento.setIdDepartamento(rs.getInt(1));
            departamento.setNomeDepartamento(rs.getString(2));
        } catch (SQLException ex) {
            System.out.println("Erro ao ler dados" + ex.getMessage());
        }

    }

}
