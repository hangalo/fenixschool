
/>>>>>>>>20/09/2017 >>>>>>>>

Na pasta WEB-INF foi criada uma nova subpsta chamada "menus" e dentro dela o ficheiro "opac_menu_final.xhmtl"

Orientação.

Na parte final deste ficheiro ("opac_menu_final.xhmtl") foram definidos MENUS PARA CASA PROGRAMADOR.
Cada um deverá colocar os links das suas tarefas num dos submenus como facilmente pode-se intuir.

Os itens de menu do menu anterior serão progressivamente transportados para este a medida que forem sendo classificados

********************Fim ****************************

tarefas concluidas

CRUD e interface para:
-> local_emissao_documento
-> periodo_letivo
-> professor_departamento (colocação - na interface)

Melhorias feitas
-> padronização do tamanho das dialogs para a manipulacao dos dados do professor
-> e do periodo lectivo


11/09/2017


Uso do p:selectManyCheckbox

Para associar de uma so vez um funcinario á varios departamentos temos a tabela funcionario_departamento.
Os DAOS constroem-se de forma comum...

O metodo guardar do managedbem é que tem a diferença


******


public void guardar(ActionEvent evt) {
        boolean controlo = false;

 (1)       for (Departamento departamentoLido : departamentos) {
 (2)          Departamento departamento = departamentoDAO.findById(departamentoLido.getIdDepartamento());
 (3)           professorDepartamento.setDepartamento(departamento);
 (4)          controlo = professorDepartamentoDAO.save(professorDepartamento);
        }
        if (controlo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar:\t", "\tDado registado com sucesso"));
            professorDepartamento = new ProfessorDepartamento();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar\t", "\tErro ao guardar os dados"));

        }
    }

****
na pagina

******



       			(5)	 <p:selectManyCheckbox id="idDepartamento" value="#{professorDepartamentoMBean.departamentos}" converter="departamentoConverter" converterMessage="Departamento - Erro de conversao" layout="grid" columns="1">
				<f:selectItems value="#{departamentoMBean.departamentos}"
                                                       var="departamento"
                                                       itemValue="#{departamento}"
                                                       itemLabel="#{departamento.nomeDepartamento}"/>
                                    </p:selectManyCheckbox>
****


Explicação

No ManagedBeam foi criado um List<Departamento> departamentos que foi associado o ao value do <p:selectManyCheckbox(5) esta lista pode receber quantos elementos
forem seleccionados
no medoto guardar, atraves do loop for percorrer-se a lista carregada dos elementos seleccionads (1)
(2) localiza-se cada elemento lido pelo seu id
(3) com este elemento criar-se um valor a armazenar
(4) é chamado o medoto guardar para este elemento e o loop regressa até ler e guardar todos elementos 


10/09/2017

>>> Inicio

Notas importantes

1) Prestar atenção ao aspecto estético e uniforme dos formularios e tabelas que se constroem

2) Sugiro uma nova forma de implementar os metodos guardar, editar e delete. Devem retornar um boolean
(ver a implementação no ProfessorDAO, PeriodoLectivoDAO, LocalEmissaoDocumentoDAO e ProfessorMBeam, 
PeriodoLectivoMBeam e LocalEmissaoDocumentoMBean
Só assim se poderá ter um controlo sobre as mensagens do cliente de forma mais facil e logica

4) Esta presente no projecto um GenericoDAOLogico com a definicao do metodos que retornam boolean
3) No readme deixar a informação actual no topo


>>> FIM



29/08/2017

I)
Adicao do ficheiro primefaces-calendar-pt.js para a traducao do componente p:calendar para portugues

Forma de usar
1)Fazer a chamada no head da pagina

<h:head>
        <title>Novo Professor</title>
         <h:outputScript library="js" name="primefaces-calendar-pt.js"/>
    </h:head>

Adicionar a propriedade locale ="pt" no componente. Exemplo

<p:calendar id="dataNascimento" value="#{professorMBean.professor.dataNascimentoProfessor}" pattern="dd/MM/yyyy" locale="pt" />

II) criada a pasta "fotos"



30/08/2017




Pesquisa:

No DAO
criar as constantes

SELECT_BY_NAME, SELEC_BY_SOBRENOME, SELECT_BY_NOME_SOBRENOME

Criar os medotos 



No ManagedBeam

Criar as variaveis que vao ligar-se à interface e receber os valores a passar para os metodos
sets e gets das variaveis

criar o metodo que será chamado no value do dataBale


Criar um formulario de pesquisa...
