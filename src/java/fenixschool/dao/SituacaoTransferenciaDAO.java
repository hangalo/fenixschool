/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.dao;

/**
 *
 * @author informatica
 */
public class SituacaoTransferenciaDAO {
    private static final String INSERT = "INSERT INTO situacao_transferencia(id_situacao_transferencia,situacao_transferencia)VALUES(?, ?);";
    private static final String UPDATE = "UPDATE situacao_transferencia SET id_situacao_transferencia = ?, situacao_transferencia = ? WHERE id_situacao_transferencia = ?";
    private static final String DELETE = "DELETE FROM situacao_transferencia WHERE id_situacao_transferencia = ? ";
    private static final String SELECT_BY_ID = "SELECT id_situacao_transferencia,situacao_transferencia FROM situacao_transferencia WHERE id_situacao_transferencia = ?";
    private static final String SELECT_ALL ="SELECT id_situacao_transferencia,situacao_transferencia FROM situacao_transferencia";
}
