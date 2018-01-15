****15/01/2018
Tarefas concluída....

Dashboad concluido numa primeira fase... agradeceria que dessem uma sugestão quando a estética e
outros elementos do mesmo. O mesmo dashboard tem o nome de dashboard_pena.

testes realizados da Entidade gestão de Matrículas. e notou-se  algumas irregularidades no que toca as dimensões dos formúlarios
e quanto a inserção e impressão da ficha de matrículas:
A) Ao inserir dados na entidate matrícula traz o erro 500 e aponta por linha 94 do gestor de impressão e na linha 554
do managedbean matrícula.
B) As dimensões do formulários são maiores podendo dificultar o inserção de dados em casos
de monitores com polegadas inferior a 16'.
----------------------------------------------------------------------------------------



*****15/12/2017********

****INFORMAÇÔES********
De 11 a 13 de Mês em curso trabalhei nas entidades que me cabem respeito com o intuito de melhorar
os aspectos visuais e padronizar os componentes da aplicação. Realizei melhorias algumas modificações na Entidade Encarregado
deixando tudo ao mesmo tamanho ao nível de dialogos.
Portanto trabalhei nas Entidades: Curso disciplina, Disciplina por ciclo e proceder com os devidos relatórios.
Os relatórios foram bem elaborados e exportados para a pasta RELATORIOS localizada na raiz da aplicação.

******TESTES*****
Com base as entidades que me cabem respeito realizei os testes possíveis e todas funcionam perfeitamente. Tavez,
faltando alguns aspectos estéticos...AGRADECERIA que todos fizessem os testes das minhas entidades e dar um feedback.


****DIFICULDADES

Após a construção dos relatórios tive muitas dificuldades de implementação na aplicação. Sempre passava um campo nulo dos parametros
fornecidos trazendo assim um erro NULL EXCEPTIONPOINT e não consegui descobrir o que se passe ate agora.

****EM FALTA*****
Nas Entidades trabalhadas falta a Entidade transferencia de Alunos, uma vez que não está completa no banco de dados e estaou aguardar que 
se actualize o script da BD para terminar a mesma.

*****REALIZAÇÂO DO PUSH****
Espero não ter causado transtorno
depois de tudo feito realizei o push seguindo os seguintes passos:

1 - Realizar o pull
2 - Add...
3 - Commit...
4 - Push

Abraços para toda equipa...
Salomão Pena
----------------------------------------------------------------FIM-------------------------------------------------------------------------------------------






29/10/2017
--Tarefas:--
Trabalhou-se nas entidades disciplina, transferencia, situação da transferencia...
tarefas concluidades com sucesso.
Emissão de relatorios disciplina por curso e por ciclo ainda em andamento.

Fiz o converter da situação da transferência...

dificuldades:
Não consegui fazer comq que o SelectMenyCheckBox logo na visualização
não trouxesse todas as caixinhas selecionadas...
Estudai acerca do assunto mais o que encontrei foi o que implementei
mais infelizmente tras todas as caixinhas selecionadas.
-----------------------------fim-------------------------------


Observacoes - Hangalo --- 28/09/2017
Elimiar os tabs no formulario do encarregado...
Nas disciplina o periodo lectivo aparece com todas a check seleccionadas... creio que o ideal è deixar apenas uma seleccionada



27/09/2017: 

Em funcção dos acabementos e estética no disposicionamento dos controlos, 
o formulário Encarregado educação e disciplinas estão ja em bom disposicionamento.

Fiz uma alteração no Modelo da Classe ano lectivo que faltava o método
hash Code e toString, fiz também alteração no FindByID no DAO da Classe periodo lectivo
que esteve a cargo da dona Aisha Lu que retornava Null. 

Alterei a forma do disposicionamento do Combx periodo lectivo para SelectMenyCheckBox.

OBS: Qualquer sugestão concernente ao melhoramento dos Layout é bem vinda.

Actualmente estpu com problema da classe Nota não Inser nem me traz nenhuma 
informação no OUTPUT.

------------------------------FIM------------------------------------



18/09/2017

III Tarefa conculida com êxito. A pesquisa de encarregado por nome,
por nome e sobrenome, por sexo está funcional. A localização de um 
encarregado por sexo já esta funcional com o SelectOneRadio
....

Dificuldades:
Fiquei quase duas semanas a tentar resolver os erros da tabela disciplina 
que ja estava funcional mais parou e a tabela Nota. 
como problema eu não sei realmente mais não estão adicionando nem apresentam
mensagem de erros no OUTPUT da IDE. Para quem tem a tabela ano lectivo como 
relacionado não consegue adicionar na tabela com que esta relacionada a mesma
traz um erro do tipo "invalid value" e não adiciona.

Como dificuldades são mais essas.
-------------------------------------fim------------------------


*******************25/08/2017********************
Fim das actividades da tarefa II
Em resumo as tarefas foram bem sucedidas com excessão a tabela DISCIPLINA 
e NOTA por falta de Converters
-periodo lectivo
-ciclo lectivo
-disciplina
-turma

 e ao erro que sucedeu no Cláusula SELECT da tabela nota:
Erro ao carregar dados: Unknown column 'c.codigo_cursoINNER' in 'on clause'

tudo foi feito em ordem mais o erro persistia. Peço ao Frei dar uma olhada
e informar o erro que fui cometendo.


Nota...
Fiz o converter Disciplina, nessa senda niguém mais deve fazer outro para 
não gerar erro.

No princípio de cada actividade o Frei deve orientar proceder a construção
dos converter que é para não cada um fazer e depois na hora do pull gerar
alguns erro.

Tarefas realizados com sucesso:
-ano lectivo
-ano curricular
-boletim de notas

tarefas reliazados com dificuldades e não concluidas a 100%
-disciplina
-nota.
******************************************FIM******************************












