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
	 	

