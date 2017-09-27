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
	 	

