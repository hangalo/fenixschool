01/12/2017
CRUD nas seguintes �reas:
	---> CategoriaArtigo
	---> Artigo
	
Consultas parametrizadas de Artigo, por:
	---> nome, codigo, codigoBarras, pre�o.

O.B.S.: Funcionalidades, no menu Tarefas actuais

--------------------------------------------------------------------------------------------------
	












04/11/2017
Coisas feitas:
	---> Entidades: Artigo, CategoriaArtigo;
	---> Converters: CategoriaArtigoConverter;
	---> MBeans: Artigo, CategoriaArtigo;


Coisas por fazer: 
	---> P�ginas
		---> artigo_gest�o(CRUD), pesquisas por (codigo, codigo_barras, nome, preco, categoria);
		---> categoria_artigo_gest�o(CRUD), pesquisas por(categoria).



	---> Relat�rios com Jasper...


O.B.S1.: Foi executado o novo script da bd;
O.B.S2.: Foi feito pull antes do push;
O.B.S3.: Procedimentos feitos antes do push (add, comit, remot/push)
------------------------------------------------------------ Fim -----------------------------------------

















06/10/2017

Implementa��o das funcionalidades usando os novos campos adicionados a bd.
----------> login_candidato e password_candidato;

Altera��es feitas em:
	------> Candidato(modelo);
	------> CandidatoDAO
	------> pagina candidato_novo, candidato_listar;

OBS.:  1- Havia feito clone porque estava com erros enquanto tentava fazer pull.
            2- O dialog novo_candidato e a pagina candidato_novo, esteticamente n�o me                convenceram. Preciso de sugest�es. O mesmo acontece com as paginas das outras             entidades. Sinto que algo n�o est� bm.



-------------------------------------------------------- Fim ---------------------------------------------------------------

















27/29/2017

Arrua��o dos componentes da p�gina candidatos, de horizontais para Stacked forms.
Usei combina��o das tags 
	<h:panelgrid>
	<h:panelGroup>

Altera��o da forma de visualiza��o dos dados de candidato.
	De tabVew para accordiooPanel


Obs1.: Trabalhei numa nova pagina com nome "candidato_novo2". 
             N�o queria perder a anterior.
Obs2.: N�o gostei muito de como ficou posicionado a cbmx da profiss�o.
Obs3.. Esperando a actualiza��o da bd para implementar os campos de acesso.

------------------------------------ FIM --------------------------------------














18/09/2017
Implementa��o da interface GenericoLogicDAO e dos seus respectivos MBeans nas seguintes entidades:
	Candidato, Mensalidade, TipoDisciplina, TipoDocumentoIdentidade.

Implementa��o do <b:painel>

Padroniza��o na est�tica das p�ginas(baseados nas paginas do professor)

Implementa��o da tarefa III
	---> fingByNomeSobrenome;
	---> findBySexo;
	---> findByNumero;
	---> findByDataNascimento, (est� com erros de convers�o de datas).

Implementa��o das cbms dependentes entre municipio e provincia. 


Dificuldades:
	---> findByDataNascimento
	---> Guardar e Editar da Mensalidade (est� com erro na profiss�o que n�o � minha 	       responsabilidade).


������������������������������FIM�������������������������������



















04/09/2017

Continua��o da tafera 1.
	Problema: N�o listava foto dos Candidatos, n�o editava.
	Solu��o: J� lista e edita.

Tarefa 2.
	CRUD tipoDisciplina, funcional;
	CRUD tipoDocumentoIdentidade, funcional;
	CRUD Mensalidade, 80%  funcional. 
		20 % em constru��o...

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

O.B.S.1: A Classe DateUtill2 que est� no pacote util, fui eu quem a colocou a�, precisei dela quando testava o DAO da mensalidade. N�o eliminei porque ainda precisarei dela. 

Os dados a mais que est�o na tabela Mensalidade inseri enquanto testava as funcionalidades. 

Erros n�o corrigidos:
	Formul�rio da mensalidade, no campo turma;
	No di�logo editar n�o tr�s o anoLetivo, consequentemente o output 		alerta a seguinte mensagem: Erro ao carregar dados: Column 		'id_ano_letivo' not found. � estranho porque no texte do DAO 	carrega normalmente.

O.B.S.2.: Testei Os DAOs com JUnit.
	Alterei o m�todo toString da Turma. Orienta��o do Frei.

�ltimo pull feito em  2/set/2017 10:51:31
	 	

