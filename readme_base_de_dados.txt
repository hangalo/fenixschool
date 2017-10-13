+++++++++++++++++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>++++++++++++++++++++++++++++++++++++++

13/10/2017

Alterações na base de dados

1) Novos campos na tabela  nota

Em funçao do numero de provas (varias) que o aluno pode realizar (estou em crer que existe um numero fixo)
foram acrescentados os campos nota_primeira_prova, nota_segunda_prova, nota_terceira_prova, nota_exame_final, nota_exame_recurso

2) O nome da tabela declaração estava mal escrito. Foi corrigido

3) foram criadas novas tabelas - 
Categoria_cargo
professor_categoria-cargo
funcionario_categoria-cargo

4) Alterada a estrutura da tabela Disciplina

Em função da necessidade de distinguir varias disciplinas com o mesmo nome nos diversos ciclos parece melhor usar siglas identificativas do tipo char
Por exemplo Lingua Porguesa para a 7º classe poderida ser codificada como 07ALP, Lingua Portuguesa para a 8º classe como 08ALP... assim por diante
Por isso o id em vez de ser auto_increment passa a ser char
A licação curso disciplina foi alterada para um ligacao muito para muitos, afinal uma disciplina pode estar associada à varios Cursos incluindo o Curso Geral
Foi eliminada a relação com o ano lectivo



++++++++++++++++++++++++++++++++++++++++>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>++++++++++++++++++++++++++++++++++++

19/09/2017

Adicionada a tabela acesso_sistema - para controlo auditoria dos acessos ao sistema em caso de necessidade

nas tabelas
aluno
candidato
professor
funcionario
encarregado_educação

foram adicionados dois novos campos. login e password
No sistema haverá diversas áreas de acesso e quem acede so pode ver o que lhe diz respeito



11/09/2017

Nova versao so script da base de dados


10/09/2017

adicionada #tabela funcionario_departamento

Adicionados novos campos a tabela docencia - nesta tabela fica registado o historico do professor em termos
de actividade de especialidade




Novas tabelas
04/09/2017

artigo
categoria_artigo
venda
detalhes_venda

