/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.Andar;
import fenixschool.modelo.Sala;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aisha Lubadika
 */
public class SalaDAO implements GenericoDAOLogico<Sala> {

    private static final String INSERIR = "INSERT into sala (nome_sala, localizacao, id_andar_edificio) VALUES (?,?,?)";
    private static final String ACTUALIZAR = "UPDATE sala SET nome_sala =?, localizacao= ?, id_andar_edificio WHERE id_sala = ?";
    private static final String ELIMINAR = "DELETE FROM sala WHERE id_sala = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT s.id_sala, s.nome_sala, s.localizacao, a.id_andar_edificio from sala s INNER JOIN  andar_edificio a ON a.id_andar_edificio= s.id_andar_edificio WHERE s.id_sala=?";
    private static final String LISTAR_TUDO = "SELECT s.id_sala, s.nome_sala, s.localizacao, a.id_andar_edificio FROM sala  s INNER JOIN andar_edificio a ON a.id_andar_edificio= s.id_andar_edificio";

    @Override
    public boolean save(Sala sala) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (sala == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, sala.getNomeSala());
            ps.setString(2, sala.getLocalizacaoSala());
            ps.setInt(3, sala.getAndar().getIdAndar());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public boolean update(Sala sala) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (sala == null) {
            System.out.println("O valor passado não pode ser nulo");
        }
        try {

            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, sala.getNomeSala());
            ps.setString(2, sala.getLocalizacaoSala());
            ps.setInt(3, sala.getAndar().getIdAndar());
            ps.setInt(4, sala.getIdSala());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }
            return flagControlo;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public boolean delete(Sala sala) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (sala == null) {
            System.out.println("O valor passado nao pode ser nulo");

        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, sala.getIdSala());

            int retorno = ps.executeUpdate();

            if (retorno > 0) {
                System.out.println("Dados eliminados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);

        }
    }

    @Override
    public Sala findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        Sala sala = new Sala();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(sala, rs);

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return sala;
    }

    @Override
    public List<Sala> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                popularComDados(sala, rs);
                salas.add(sala);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());

        } finally {
            Conexao.closeConnection(conn);
        }
        return salas;
    }

    @Override
    public void popularComDados(Sala sala, ResultSet rs) {
        try {
            sala.setIdSala(rs.getInt("id_sala"));
            sala.setNomeSala(rs.getString("nome_sala"));
            sala.setLocalizacaoSala(rs.getString("localizacao"));

            Andar andar = new Andar();
            andar.setNomeAndar(rs.getString("mome_andar_edificio"));
           
            sala.setAndar(andar);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados da Sala: " + ex.getLocalizedMessage());
        }

    }
}
