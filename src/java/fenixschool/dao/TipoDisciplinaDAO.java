/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

import fenixschool.modelo.TipoDisciplina;
import fenixschool.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class TipoDisciplinaDAO implements GenericoDAOLogico<TipoDisciplina> {

    private static final String INSERIR = "INSERT INTO tipo_disciplina(tipo_disciplina) VALUES (?)";
    private static final String ACTUALIZAR = "UPDATE tipo_disciplina SET tipo_disciplina = ? WHERE id_tipo_disciplina = ?";
    private static final String ELIMINAR = "DELETE FROM tipo_disciplina WHERE id_tipo_disciplina = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM tipo_disciplina WHERE id_tipo_disciplina = ? ORDER BY tipo_disciplina ASC";
    private static final String LISTAR_TUDO = "SELECT * FROM tipo_disciplina ORDER BY tipo_disciplina ASC";

    @Override
    public boolean save(TipoDisciplina tipoDisciplina) {
        
        /*
            PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (professor == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);

            ps.setString(1, professor.getNomeProfessor());
            ps.setString(2, professor.getSobrenomeProfessor());
            ps.setDate(3, new java.sql.Date(professor.getDataNascimentoProfessor().getTime()));
            ps.setString(4, professor.getSexo().getAbreviatura());
            ps.setString(5, professor.getNifProfessor());
            ps.setBytes(6, professor.getFotoProfessor());
            ps.setString(7, professor.getUrlFotoProfessor());
            ps.setString(8, professor.getCasaProfessor());
            ps.setString(9, professor.getRuaProfessor());
            ps.setString(10, professor.getBairroProfessor());
            ps.setString(11, professor.getDistritoUrbanoProfessor());
            ps.setString(12, professor.getTelemovelPrincipalProfessor());
            ps.setString(13, professor.getTelemovelAlternativoProfessor());
            ps.setString(14, professor.getTelefonePrincipalProfessor());
            ps.setString(15, professor.getTelefoneAlternativoProfessor());
            ps.setString(16, professor.getEmailPrincipalProfessor());
            ps.setString(17, professor.getEmailAlternativoProfessor());
            ps.setString(18, professor.getNumeroBIProfessor());
            ps.setString(19, professor.getIBAMProfessor());
            ps.setString(20, professor.getNumeroPassaporteProfessor());
            ps.setInt(21, professor.getMunicipio().getIdMunicipio());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;
        */
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (tipoDisciplina == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, tipoDisciplina.getTipoDisciplina());

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
    public boolean update(TipoDisciplina tipoDisciplina) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;

        if (tipoDisciplina == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, tipoDisciplina.getTipoDisciplina());
            ps.setInt(2, tipoDisciplina.getIdTipoDisciplina());
            

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados actualizados com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    @Override
    public boolean delete(TipoDisciplina tipoDisciplina) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (tipoDisciplina == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, tipoDisciplina.getIdTipoDisciplina());
            

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
    public TipoDisciplina findById(Integer id) {
        TipoDisciplina tipoDisciplina = new TipoDisciplina();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(tipoDisciplina, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return tipoDisciplina;
    }

    @Override
    public List<TipoDisciplina> findAll() {
        List<TipoDisciplina> tipoDisciplinas = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = (Connection) Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDisciplina tipoDisciplina = new TipoDisciplina();
                popularComDados(tipoDisciplina, rs);
                tipoDisciplinas.add(tipoDisciplina);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return tipoDisciplinas;
    }

    @Override
    public void popularComDados(TipoDisciplina tipoDisciplina, ResultSet rs) {
        try {
            tipoDisciplina.setIdTipoDisciplina(rs.getInt("id_tipo_disciplina"));
            tipoDisciplina.setTipoDisciplina(rs.getString("tipo_disciplina"));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
