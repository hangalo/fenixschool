****15/01/2018
Tarefas conclu�da....

Dashboad concluido numa primeira fase... agradeceria que dessem uma sugest�o quando a est�tica e
outros elementos do mesmo. O mesmo dashboard tem o nome de dashboard_pena.

testes realizados da Entidade gest�o de Matr�culas. e notou-se  algumas irregularidades no que toca as dimens�es dos form�larios
e quanto a inser��o e impress�o da ficha de matr�culas:
A) Ao inserir dados na entidate matr�cula traz o erro 500 e aponta por linha 94 do gestor de impress�o e na linha 554
do managedbean matr�cula.
B) As dimens�es do formul�rios s�o maiores podendo dificultar o inser��o de dados em casos
de monitores com polegadas inferior a 16'.
----------------------------------------------------------------------------------------



*****15/12/2017********

****INFORMA��ES********
De 11 a 13 de M�s em curso trabalhei nas entidades que me cabem respeito com o intuito de melhorar
os aspectos visuais e padronizar os componentes da aplica��o. Realizei melhorias algumas modifica��es na Entidade Encarregado
deixando tudo ao mesmo tamanho ao n�vel de dialogos.
Portanto trabalhei nas Entidades: Curso disciplina, Disciplina por ciclo e proceder com os devidos relat�rios.
Os relat�rios foram bem elaborados e exportados para a pasta RELATORIOS localizada na raiz da aplica��o.

******TESTES*****
Com base as entidades que me cabem respeito realizei os testes poss�veis e todas funcionam perfeitamente. Tavez,
faltando alguns aspectos est�ticos...AGRADECERIA que todos fizessem os testes das minhas entidades e dar um feedback.


****DIFICULDADES

Ap�s a constru��o dos relat�rios tive muitas dificuldades de implementa��o na aplica��o. Sempre passava um campo nulo dos parametros
fornecidos trazendo assim um erro NULL EXCEPTIONPOINT e n�o consegui descobrir o que se passe ate agora.

****EM FALTA*****
Nas Entidades trabalhadas falta a Entidade transferencia de Alunos, uma vez que n�o est� completa no banco de dados e estaou aguardar que 
se actualize o script da BD para terminar a mesma.

*****REALIZA��O DO PUSH****
Espero n�o ter causado transtorno
depois de tudo feito realizei o push seguindo os seguintes passos:

1 - Realizar o pull
2 - Add...
3 - Commit...
4 - Push

Abra�os para toda equipa...
Salom�o Pena
----------------------------------------------------------------FIM-------------------------------------------------------------------------------------------






29/10/2017
--Tarefas:--
Trabalhou-se nas entidades disciplina, transferencia, situa��o da transferencia...
tarefas concluidades com sucesso.
Emiss�o de relatorios disciplina por curso e por ciclo ainda em andamento.

Fiz o converter da situa��o da transfer�ncia...

dificuldades:
N�o consegui fazer comq que o SelectMenyCheckBox logo na visualiza��o
n�o trouxesse todas as caixinhas selecionadas...
Estudai acerca do assunto mais o que encontrei foi o que implementei
mais infelizmente tras todas as caixinhas selecionadas.
-----------------------------fim-------------------------------


Observacoes - Hangalo --- 28/09/2017
Elimiar os tabs no formulario do encarregado...
Nas disciplina o periodo lectivo aparece com todas a check seleccionadas... creio que o ideal � deixar apenas uma seleccionada



27/09/2017: 

Em func��o dos acabementos e est�tica no disposicionamento dos controlos, 
o formul�rio Encarregado educa��o e disciplinas est�o ja em bom disposicionamento.

Fiz uma altera��o no Modelo da Classe ano lectivo que faltava o m�todo
hash Code e toString, fiz tamb�m altera��o no FindByID no DAO da Classe periodo lectivo
que esteve a cargo da dona Aisha Lu que retornava Null. 

Alterei a forma do disposicionamento do Combx periodo lectivo para SelectMenyCheckBox.

OBS: Qualquer sugest�o concernente ao melhoramento dos Layout � bem vinda.

Actualmente estpu com problema da classe Nota n�o Inser nem me traz nenhuma 
informa��o no OUTPUT.

------------------------------FIM------------------------------------



18/09/2017

III Tarefa conculida com �xito. A pesquisa de encarregado por nome,
por nome e sobrenome, por sexo est� funcional. A localiza��o de um 
encarregado por sexo j� esta funcional com o SelectOneRadio
....

Dificuldades:
Fiquei quase duas semanas a tentar resolver os erros da tabela disciplina 
que ja estava funcional mais parou e a tabela Nota. 
como problema eu n�o sei realmente mais n�o est�o adicionando nem apresentam
mensagem de erros no OUTPUT da IDE. Para quem tem a tabela ano lectivo como 
relacionado n�o consegue adicionar na tabela com que esta relacionada a mesma
traz um erro do tipo "invalid value" e n�o adiciona.

Como dificuldades s�o mais essas.
-------------------------------------fim------------------------


*******************25/08/2017********************
Fim das actividades da tarefa II
Em resumo as tarefas foram bem sucedidas com excess�o a tabela DISCIPLINA 
e NOTA por falta de Converters
-periodo lectivo
-ciclo lectivo
-disciplina
-turma

 e ao erro que sucedeu no Cl�usula SELECT da tabela nota:
Erro ao carregar dados: Unknown column 'c.codigo_cursoINNER' in 'on clause'

tudo foi feito em ordem mais o erro persistia. Pe�o ao Frei dar uma olhada
e informar o erro que fui cometendo.


Nota...
Fiz o converter Disciplina, nessa senda nigu�m mais deve fazer outro para 
n�o gerar erro.

No princ�pio de cada actividade o Frei deve orientar proceder a constru��o
dos converter que � para n�o cada um fazer e depois na hora do pull gerar
alguns erro.

Tarefas realizados com sucesso:
-ano lectivo
-ano curricular
-boletim de notas

tarefas reliazados com dificuldades e n�o concluidas a 100%
-disciplina
-nota.
******************************************FIM******************************












