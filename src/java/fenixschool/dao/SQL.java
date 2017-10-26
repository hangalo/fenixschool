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
public class SQL {
    /*
    Para o relatorio da matricula
    SELECT  m.id_matricula, a.id_aluno,a.nome_aluno,a.sobrenome_aluno, a.nome_pai, a.nome_mae, a.data_nascimento, a.sexo, a.foto_aluno, c.nome_curso, c.abreviatura, ac.ano_curricular, t.nome_turma, pl.periodo_letivo,a.bairro_aluno, cl.ciclo_letivo,
            m.data_matricula,  m.numero_documento, m.observacao, mu.nome_municipio,
            m.data_emissao_documento, td.tipo_documento_identidade, le.local_emissao_documento, a.distrito_aluno, al.ano_letivo,
            f.nome_funcionario, f.sobrenome_funcionario,m.estado_matricula,
              m.lingua_opcao, m.situacao_aluno
            FROM matricula m
            INNER JOIN aluno a ON  m.id_aluno = a.id_aluno
            INNER JOIN turma t ON m.id_turma =t.id_turma
            INNER JOIN curso c ON m.codigo_curso =c.codigo_curso
            INNER JOIN ano_letivo al ON m.id_ano_letivo =al.id_ano_letivo
            INNER JOIN ciclo_letivo cl ON
             m.id_ciclo_letivo = cl.id_ciclo_letivo INNER JOIN ano_curricular ac ON
            m.id_ano_curricular = ac.id_ano_curricular INNER JOIN municipio mu ON
            a.id_municipio = mu.id_municipio INNER JOIN periodo_letivo pl ON
            t.id_periodo_letivo = pl.id_periodo_letivo INNER JOIN funcionario f ON m.id_funcionario=f.id_funcionario
            INNER JOIN tipo_documento_identidade td ON m.id_tipo_documento_identidade=td.id_tipo_documento_identidade
            INNER JOIN local_emissao_documento le ON m.id_local_emissao_documento=le.id_local_emissao_documento ;
    
    
    
    */
    
}
