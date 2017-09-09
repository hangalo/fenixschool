
10/09/2017

>>> Inicio

Notas importantes

1) Prestar atenção ao aspecto estético e uniforme dos formularios e tabelas que se constroem

2) Sugiro uma nova forma de implementar os metodos guardar, editar e delete. Devem retornar um boolean
(ver a implementação no ProfessorDAO, PeriodoLectivoDAO, LocalEmissaoDocumentoDAO e ProfessorMBeam, 
PeriodoLectivoMBeam e LocalEmissaoDocumentoMBean
Só assim se poderá ter um controlo sobre as mensagens do cliente de forma mais facil e logica



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
