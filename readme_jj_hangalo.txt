

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
