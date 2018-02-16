1602/2018
Objectivos: 
	1 ---> Construção de um template para o dashboard feito pela Aisha. 
	2 ---> Contrução da págna index que implementa  o tamplate construído.
	3 ---> Implementação da ligação dos formularios da aplicação com o dasboard construído.

Coisas feitas:  Objectivos 1 e 2.

Outros: 
	- O dashboard foi criado  na pasta templates  com o nome dashboard_aisha_tamplete.
	- A pagina index foi criada com o nome index2
	- Centralizei o conteúdo da div painel_esquerdo. Inclui a imagem da beca e os commandButtons, isso no tamplete construído e na página de 		dashboard feito pela dona Aisha. 
	- Use um <ui: include> (para incluir o menu_dashboard) no tamplate construído.
	

Coisas não feitas: Objectivo 3.

O.B.S.: Deixei uma página com o nome exemplo_dashboard, para poder ver como fica quando uma página é cliente do tamplate construído.
  
--------------------------------------------------------------------- Fim --------------------------------------------------------------------------


11/02/2018
Implementação das novas paginas de acesso a área de candidatos.
Coisas feitas:
-----> Foi criada uma pasta com nome 'candidatos', que contem todas as páginas 		criadas.
-----> Foi alterado o menu do dashboard_template (adicionei links para as novas páginas).
-----> As páginas construídas são clientes do dashboard_template.

-------------------------------------------------------------- Fim -------------------------------------------------------------- 











24/12/2017
Testes das funcionalidades de 
------------> Mensalidade
------------> Artigo
------------> Candidato




--------------------------------------------------------------------------------------------------------------
07/12/2017   00h:51m
--> Alteração em DisciplinasDoCursoMBean
	Não implementava a interface Serializable, o que causava o erro ao fazer deploy.
	OBS.: Verifiquem os vossos MBeans, se tiver algum que ainda não implementa 	           essa interface, é possivel que futuramente teremos o mesmo erro.

--> Alteração em MensalidadeDAO
	Os métodos não estavão bem implementados e testados.


--> Melhorei a estética, deixando os dialogos com o mesmo tamanho. O link encontra-se no menu tarefas actais no submeno Elisio.

--> Nota Importante: 
Testei as funcionalidades de impressão de relatórios, isto em professores. Notei algo que supostamente está a causar um NullPointerException. Deixei um comentario relacionado ao assunto, em GestãoImpressao, da linha 80 até a linha 91. 
Para ver que funciona, basta retirar o comentario e deixar simplesmente o seguinte código: 
	
	jasperPrint = new JasperPrint(); 


				Fim
------------------------------------------------------------------------------------------------------------

01/12/2017
CRUD nas seguintes áreas:
	---> CategoriaArtigo
	---> Artigo
	
Consultas parametrizadas de Artigo, por:
	---> nome, codigo, codigoBarras, preço.

O.B.S.: Funcionalidades, no menu Tarefas actuais

--------------------------------------------------------------------------------------------------
	

04/11/2017
Coisas feitas:
	---> Entidades: Artigo, CategoriaArtigo;
	---> Converters: CategoriaArtigoConverter;
	---> MBeans: Artigo, CategoriaArtigo;


Coisas por fazer: 
	---> Páginas
		---> artigo_gestão(CRUD), pesquisas por (codigo, codigo_barras, nome, preco, categoria);
		---> categoria_artigo_gestão(CRUD), pesquisas por(categoria).



	---> Relatórios com Jasper...


O.B.S1.: Foi executado o novo script da bd;
O.B.S2.: Foi feito pull antes do push;
O.B.S3.: Procedimentos feitos antes do push (add, comit, remot/push)
------------------------------------------------------------ Fim -----------------------------------------

















06/10/2017

Implementação das funcionalidades usando os novos campos adicionados a bd.
----------> login_candidato e password_candidato;

Alterações feitas em:
	------> Candidato(modelo);
	------> CandidatoDAO
	------> pagina candidato_novo, candidato_listar;

OBS.:  1- Havia feito clone porque estava com erros enquanto tentava fazer pull.
            2- O dialog novo_candidato e a pagina candidato_novo, esteticamente não me                convenceram. Preciso de sugestões. O mesmo acontece com as paginas das outras             entidades. Sinto que algo não está bm.



-------------------------------------------------------- Fim ---------------------------------------------------------------

















27/29/2017

Arruação dos componentes da página candidatos, de horizontais para Stacked forms.
Usei combinação das tags 
	<h:panelgrid>
	<h:panelGroup>

Alteração da forma de visualização dos dados de candidato.
	De tabVew para accordiooPanel


Obs1.: Trabalhei numa nova pagina com nome "candidato_novo2". 
             Não queria perder a anterior.
Obs2.: Não gostei muito de como ficou posicionado a cbmx da profissão.
Obs3.. Esperando a actualização da bd para implementar os campos de acesso.

------------------------------------ FIM --------------------------------------














18/09/2017
Implementação da interface GenericoLogicDAO e dos seus respectivos MBeans nas seguintes entidades:
	Candidato, Mensalidade, TipoDisciplina, TipoDocumentoIdentidade.

Implementação do <b:painel>

Padronização na estética das páginas(baseados nas paginas do professor)

Implementação da tarefa III
	---> fingByNomeSobrenome;
	---> findBySexo;
	---> findByNumero;
	---> findByDataNascimento, (está com erros de conversão de datas).

Implementação das cbms dependentes entre municipio e provincia. 


Dificuldades:
	---> findByDataNascimento
	---> Guardar e Editar da Mensalidade (está com erro na profissão que não é minha 	       responsabilidade).


««««««««««««««««««««««««««««««FIM»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»



















04/09/2017

Continuação da tafera 1.
	Problema: Não listava foto dos Candidatos, não editava.
	Solução: Já lista e edita.

Tarefa 2.
	CRUD tipoDisciplina, funcional;
	CRUD tipoDocumentoIdentidade, funcional;
	CRUD Mensalidade, 80%  funcional. 
		20 % em construção...

DAOs feitos:
	TipoDisciplinaDAO;
	TipoDocumentoIdentidadeDAO;
	MensalidadeDAO;

Converters feitos: 
	TipoDisciplinaConverter;
	TipoDocumentoIdentidadeConverter;
	CursoConverter;
	
MBeans:
	TipoDisciplinaMbean;
	TipoDocumentoIdentidadeMBean;
	MensalidadeMBean;

O.B.S.1: A Classe DateUtill2 que está no pacote util, fui eu quem a colocou aí, precisei dela quando testava o DAO da mensalidade. Não eliminei porque ainda precisarei dela. 

Os dados a mais que estão na tabela Mensalidade inseri enquanto testava as funcionalidades. 

Erros não corrigidos:
	Formulário da mensalidade, no campo turma;
	No diálogo editar não trás o anoLetivo, consequentemente o output 		alerta a seguinte mensagem: Erro ao carregar dados: Column 		'id_ano_letivo' not found. É estranho porque no texte do DAO 	carrega normalmente.

O.B.S.2.: Testei Os DAOs com JUnit.
	Alterei o método toString da Turma. Orientação do Frei.

Último pull feito em  2/set/2017 10:51:31
	 	

