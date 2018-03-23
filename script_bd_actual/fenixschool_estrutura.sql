-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema fenixschoolem
--

CREATE DATABASE IF NOT EXISTS fenixschoolem;
USE fenixschoolem;

--
-- Definition of table `acesso_sistema`
--

DROP TABLE IF EXISTS `acesso_sistema`;
CREATE TABLE `acesso_sistema` (
  `id_acesso_sistema` int(11) NOT NULL AUTO_INCREMENT,
  `data_acesso_sistema` date DEFAULT NULL,
  `hora_acesso_sistema` datetime DEFAULT NULL,
  `id_professor` int(11) DEFAULT NULL,
  `id_candidato` int(11) DEFAULT NULL,
  `aluno_id_aluno` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_encarregado` int(11) NOT NULL,
  PRIMARY KEY (`id_acesso_sistema`),
  KEY `fk_acesso_sistema_professor1_idx` (`id_professor`),
  KEY `fk_acesso_sistema_candidato1_idx` (`id_candidato`),
  KEY `fk_acesso_sistema_aluno1_idx` (`aluno_id_aluno`),
  KEY `fk_acesso_sistema_funcionario1_idx` (`id_funcionario`),
  KEY `fk_acesso_sistema_encarregado_educacao1_idx` (`id_encarregado`),
  CONSTRAINT `fk_acesso_sistema_aluno1` FOREIGN KEY (`aluno_id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_candidato1` FOREIGN KEY (`id_candidato`) REFERENCES `candidato` (`id_candidato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_encarregado_educacao1` FOREIGN KEY (`id_encarregado`) REFERENCES `encarregado_educacao` (`id_encarregado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_professor1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `acesso_sistema`
--

/*!40000 ALTER TABLE `acesso_sistema` DISABLE KEYS */;
/*!40000 ALTER TABLE `acesso_sistema` ENABLE KEYS */;


--
-- Definition of table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `id_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome_aluno` varchar(45) DEFAULT NULL,
  `sobrenome_aluno` varchar(45) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `nome_pai` varchar(100) DEFAULT NULL,
  `nome_mae` varchar(100) DEFAULT NULL,
  `numero_BI` varchar(45) DEFAULT NULL,
  `data_emisao_BI` date DEFAULT NULL,
  `local_emisaao_BI` varchar(100) DEFAULT NULL,
  `numero_passaporte` varchar(45) DEFAULT NULL,
  `data_emissao_passaporte` date DEFAULT NULL,
  `local_emissao_passaporte` varchar(45) DEFAULT NULL,
  `casa_aluno` varchar(45) DEFAULT NULL,
  `bairro_aluno` varchar(45) DEFAULT NULL,
  `distrito_aluno` varchar(45) DEFAULT NULL,
  `comuna_aluno` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `foto_aluno` blob,
  `url_foto_aluno` varchar(45) DEFAULT 'padrao.png',
  `telefone_fixo` varchar(45) DEFAULT NULL,
  `telefone_movel` varchar(45) DEFAULT NULL,
  `email_aluno` varchar(45) DEFAULT NULL,
  `id_profissao` int(11) NOT NULL,
  `sexo` char(10) DEFAULT NULL,
  `login_aluno` varchar(45) DEFAULT NULL,
  `password_aluno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  KEY `fk_aluno_municipio1_idx` (`id_municipio`),
  KEY `fk_aluno_profissao1_idx` (`id_profissao`),
  CONSTRAINT `fk_aluno_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_aluno_profissao1` FOREIGN KEY (`id_profissao`) REFERENCES `profissao` (`id_profissao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aluno`
--

/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;


--
-- Definition of table `aluno_encarregado_educacao`
--

DROP TABLE IF EXISTS `aluno_encarregado_educacao`;
CREATE TABLE `aluno_encarregado_educacao` (
  `id_aluno_encarregado_educacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_encarregado` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_parentesco` int(11) NOT NULL,
  `inicio_responsabilidade` date DEFAULT NULL,
  `fim_responsabilidade` date DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_aluno_encarregado_educacao`),
  KEY `fk_aluno_encarregado_educacao_encarregado_educacao1_idx` (`id_encarregado`),
  KEY `fk_aluno_encarregado_educacao_aluno1_idx` (`id_aluno`),
  KEY `fk_aluno_encarregado_educacao_parentesco1_idx` (`id_parentesco`),
  CONSTRAINT `fk_aluno_encarregado_educacao_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_encarregado_educacao_encarregado_educacao1` FOREIGN KEY (`id_encarregado`) REFERENCES `encarregado_educacao` (`id_encarregado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_encarregado_educacao_parentesco1` FOREIGN KEY (`id_parentesco`) REFERENCES `parentesco` (`id_parentesco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aluno_encarregado_educacao`
--

/*!40000 ALTER TABLE `aluno_encarregado_educacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_encarregado_educacao` ENABLE KEYS */;


--
-- Definition of table `aluno_endereco`
--

DROP TABLE IF EXISTS `aluno_endereco`;
CREATE TABLE `aluno_endereco` (
  `id_endereco_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_endereco_aluno`),
  KEY `fk_aluno_endereco_aluno1_idx` (`id_aluno`),
  KEY `fk_aluno_endereco_endereco1_idx` (`id_endereco`),
  CONSTRAINT `fk_aluno_endereco_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_endereco_endereco1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aluno_endereco`
--

/*!40000 ALTER TABLE `aluno_endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_endereco` ENABLE KEYS */;


--
-- Definition of table `andar_edificio`
--

DROP TABLE IF EXISTS `andar_edificio`;
CREATE TABLE `andar_edificio` (
  `id_andar_edificio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_andar_edificio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_andar_edificio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `andar_edificio`
--

/*!40000 ALTER TABLE `andar_edificio` DISABLE KEYS */;
/*!40000 ALTER TABLE `andar_edificio` ENABLE KEYS */;


--
-- Definition of table `ano_curricular`
--

DROP TABLE IF EXISTS `ano_curricular`;
CREATE TABLE `ano_curricular` (
  `id_ano_curricular` int(11) NOT NULL AUTO_INCREMENT,
  `ano_curricular` varchar(45) DEFAULT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  PRIMARY KEY (`id_ano_curricular`),
  KEY `fk_ano_curricular_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  CONSTRAINT `fk_ano_curricular_ciclo_letivo1` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ano_curricular`
--

/*!40000 ALTER TABLE `ano_curricular` DISABLE KEYS */;
/*!40000 ALTER TABLE `ano_curricular` ENABLE KEYS */;


--
-- Definition of table `ano_letivo`
--

DROP TABLE IF EXISTS `ano_letivo`;
CREATE TABLE `ano_letivo` (
  `id_ano_letivo` int(11) NOT NULL AUTO_INCREMENT,
  `ano_letivo` varchar(45) DEFAULT NULL,
  `inicio_ano_letivo` date DEFAULT NULL,
  `fim_ano_letivo` date DEFAULT NULL,
  PRIMARY KEY (`id_ano_letivo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ano_letivo`
--

/*!40000 ALTER TABLE `ano_letivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ano_letivo` ENABLE KEYS */;


--
-- Definition of table `artigo`
--

DROP TABLE IF EXISTS `artigo`;
CREATE TABLE `artigo` (
  `id_artigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_artigo` varchar(45) DEFAULT NULL,
  `codigo_barras_artigo` varchar(45) DEFAULT NULL,
  `nome_artigo` varchar(45) DEFAULT NULL,
  `preco_artigo` double DEFAULT NULL,
  `id_categoria_artigo` int(11) NOT NULL,
  PRIMARY KEY (`id_artigo`),
  KEY `fk_artigo_categoria_artigo1_idx` (`id_categoria_artigo`),
  CONSTRAINT `fk_artigo_categoria_artigo1` FOREIGN KEY (`id_categoria_artigo`) REFERENCES `categoria_artigo` (`id_categoria_artigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artigo`
--

/*!40000 ALTER TABLE `artigo` DISABLE KEYS */;
/*!40000 ALTER TABLE `artigo` ENABLE KEYS */;


--
-- Definition of table `boletim_notas`
--

DROP TABLE IF EXISTS `boletim_notas`;
CREATE TABLE `boletim_notas` (
  `id_boletin_notas` int(11) NOT NULL AUTO_INCREMENT,
  `data_boletin_notas` datetime DEFAULT NULL,
  `id_aluno` int(11) NOT NULL,
  PRIMARY KEY (`id_boletin_notas`),
  KEY `fk_boletin_notas_aluno1_idx` (`id_aluno`),
  CONSTRAINT `fk_boletin_notas_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `boletim_notas`
--

/*!40000 ALTER TABLE `boletim_notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletim_notas` ENABLE KEYS */;


--
-- Definition of table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
CREATE TABLE `candidato` (
  `id_candidato` int(11) NOT NULL AUTO_INCREMENT,
  `numero_candidato` varchar(45) DEFAULT NULL,
  `nome_candidato` varchar(45) DEFAULT NULL,
  `sobrenome_candidato` varchar(45) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `casa_candidato` varchar(45) DEFAULT NULL,
  `bairro_candidato` varchar(45) DEFAULT NULL,
  `distrito_candidato` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `url_foto_candidato` varchar(45) DEFAULT NULL,
  `foto_candidato` longblob,
  `telefone_fixo` varchar(45) DEFAULT NULL,
  `telefone_movel` varchar(45) DEFAULT NULL,
  `email_candidato` varchar(45) DEFAULT NULL,
  `id_profissao` int(11) NOT NULL,
  `sexo` char(45) DEFAULT NULL,
  `login_candidato` varchar(45) DEFAULT NULL,
  `password_candidato` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_candidato`),
  KEY `fk_aluno_municipio1_idx` (`id_municipio`),
  KEY `fk_aluno_profissao1_idx` (`id_profissao`),
  CONSTRAINT `fk_aluno_municipio11` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_profissao10` FOREIGN KEY (`id_profissao`) REFERENCES `profissao` (`id_profissao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidato`
--

/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;


--
-- Definition of table `candidatura`
--

DROP TABLE IF EXISTS `candidatura`;
CREATE TABLE `candidatura` (
  `id_candidatura` int(11) NOT NULL AUTO_INCREMENT,
  `id_candidato` int(11) NOT NULL,
  `data_candidatura` date DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `codigo_curso` char(45) NOT NULL,
  `id_ano_letivo` int(11) NOT NULL,
  `estado_candidatura` tinyint(1) DEFAULT NULL,
  `id_turma` int(11) NOT NULL,
  `id_tipo_documento_identidade` int(11) NOT NULL,
  `data_emissao_documento` date DEFAULT NULL,
  `id_local_emissao_documento` int(11) NOT NULL,
  `numero_documento` varchar(100) DEFAULT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  `id_ano_curricular` int(11) NOT NULL,
  `lingua_opcao` varchar(45) DEFAULT NULL,
  `situacao_candidato` varchar(45) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_candidatura`),
  KEY `fk_matricula_funcionario1_idx` (`id_funcionario`),
  KEY `fk_matricula_curso1_idx` (`codigo_curso`),
  KEY `fk_matricula_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_matricula_turma1_idx` (`id_turma`),
  KEY `fk_matricula_tipo_documento_identidade1_idx` (`id_tipo_documento_identidade`),
  KEY `fk_matricula_local_emissao_documento1_idx` (`id_local_emissao_documento`),
  KEY `fk_matricula_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  KEY `fk_matricula_ano_curricular1_idx` (`id_ano_curricular`),
  KEY `fk_candidatura_candidato1_idx` (`id_candidato`),
  CONSTRAINT `fk_candidatura_candidato1` FOREIGN KEY (`id_candidato`) REFERENCES `candidato` (`id_candidato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ano_curricular10` FOREIGN KEY (`id_ano_curricular`) REFERENCES `ano_curricular` (`id_ano_curricular`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ano_letivo10` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ciclo_letivo10` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_curso10` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_funcionario10` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_local_emissao_documento10` FOREIGN KEY (`id_local_emissao_documento`) REFERENCES `local_emissao_documento` (`id_local_emissao_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_tipo_documento_identidade10` FOREIGN KEY (`id_tipo_documento_identidade`) REFERENCES `tipo_documento_identidade` (`id_tipo_documento_identidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_turma10` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidatura`
--

/*!40000 ALTER TABLE `candidatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidatura` ENABLE KEYS */;


--
-- Definition of table `categoria_artigo`
--

DROP TABLE IF EXISTS `categoria_artigo`;
CREATE TABLE `categoria_artigo` (
  `id_categoria_artigo` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_artigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria_artigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_artigo`
--

/*!40000 ALTER TABLE `categoria_artigo` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_artigo` ENABLE KEYS */;


--
-- Definition of table `categoria_cargo`
--

DROP TABLE IF EXISTS `categoria_cargo`;
CREATE TABLE `categoria_cargo` (
  `id_categoria_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_categoria_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_cargo`
--

/*!40000 ALTER TABLE `categoria_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_cargo` ENABLE KEYS */;


--
-- Definition of table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
CREATE TABLE `certificado` (
  `id_certificado` int(11) NOT NULL AUTO_INCREMENT,
  `data_certificado` date DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_ano_curricular` int(11) NOT NULL,
  `texto_certificado` text,
  PRIMARY KEY (`id_certificado`),
  KEY `fk_certificado_funcionario1_idx` (`id_funcionario`),
  KEY `fk_certificado_aluno1_idx` (`id_aluno`),
  KEY `fk_certificado_ano_curricular1_idx` (`id_ano_curricular`),
  CONSTRAINT `fk_certificado_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificado_ano_curricular1` FOREIGN KEY (`id_ano_curricular`) REFERENCES `ano_curricular` (`id_ano_curricular`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificado_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `certificado`
--

/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;


--
-- Definition of table `ciclo_letivo`
--

DROP TABLE IF EXISTS `ciclo_letivo`;
CREATE TABLE `ciclo_letivo` (
  `id_ciclo_letivo` int(11) NOT NULL AUTO_INCREMENT,
  `ciclo_letivo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ciclo_letivo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ciclo_letivo`
--

/*!40000 ALTER TABLE `ciclo_letivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciclo_letivo` ENABLE KEYS */;


--
-- Definition of table `classificacao_nota`
--

DROP TABLE IF EXISTS `classificacao_nota`;
CREATE TABLE `classificacao_nota` (
  `id_classificacao_nota` int(11) NOT NULL AUTO_INCREMENT,
  `classificacao_nota` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_classificacao_nota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classificacao_nota`
--

/*!40000 ALTER TABLE `classificacao_nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `classificacao_nota` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(45) DEFAULT NULL,
  `sobrenome_cliente` varchar(45) DEFAULT NULL,
  `telemovel_cliente` varchar(45) DEFAULT NULL,
  `telefone_cliente` varchar(45) DEFAULT NULL,
  `email_cliente` varchar(45) DEFAULT NULL,
  `casa_cliente` varchar(45) DEFAULT NULL,
  `bairro_cliente` varchar(45) DEFAULT NULL,
  `rua_cliente` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `id_tipo_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_municipio1_idx` (`id_municipio`),
  KEY `fk_cliente_tipo_cliente1_idx` (`id_tipo_cliente`),
  CONSTRAINT `fk_cliente_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_tipo_cliente1` FOREIGN KEY (`id_tipo_cliente`) REFERENCES `tipo_cliente` (`id_tipo_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `codigo_curso` char(45) NOT NULL,
  `nome_curso` varchar(45) DEFAULT NULL,
  `abreviatura` varchar(45) DEFAULT NULL,
  `codigo_ministerio_educacao` varchar(45) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `id_departamento` int(11) NOT NULL,
  `descricao_curso` varchar(100) DEFAULT NULL,
  `conteudo_programatico` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`codigo_curso`),
  KEY `fk_curso_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_curso_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `curso`
--

/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


--
-- Definition of table `curso_disciplina`
--

DROP TABLE IF EXISTS `curso_disciplina`;
CREATE TABLE `curso_disciplina` (
  `id_curso_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_curso` char(45) NOT NULL,
  `id_disciplina` char(20) NOT NULL,
  PRIMARY KEY (`id_curso_disciplina`),
  KEY `fk_curso_disciplina_curso1_idx` (`codigo_curso`),
  KEY `fk_curso_disciplina_disciplina1_idx` (`id_disciplina`),
  CONSTRAINT `fk_curso_disciplina_curso1` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_disciplina_disciplina1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `curso_disciplina`
--

/*!40000 ALTER TABLE `curso_disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_disciplina` ENABLE KEYS */;


--
-- Definition of table `declaracao`
--

DROP TABLE IF EXISTS `declaracao`;
CREATE TABLE `declaracao` (
  `id_declaracao` int(11) NOT NULL AUTO_INCREMENT,
  `texto_declaracao` text,
  `data_declaracao` datetime DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_objetivo_declaracao` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  PRIMARY KEY (`id_declaracao`),
  KEY `fk_delcaracao_funcionario1_idx` (`id_funcionario`),
  KEY `fk_delcaracao_objetivo_declaracao1_idx` (`id_objetivo_declaracao`),
  KEY `fk_delcaracao_aluno1_idx` (`id_aluno`),
  CONSTRAINT `fk_delcaracao_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_delcaracao_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_delcaracao_objetivo_declaracao1` FOREIGN KEY (`id_objetivo_declaracao`) REFERENCES `objetivo_declaracao` (`id_objetivo_declaracao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `declaracao`
--

/*!40000 ALTER TABLE `declaracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `declaracao` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE `disciplina` (
  `id_disciplina` char(20) NOT NULL,
  `nome_disciplina` varchar(45) DEFAULT NULL,
  `abreviatura` varchar(45) DEFAULT NULL,
  `descricao_displina` varchar(45) DEFAULT NULL,
  `sumario_disciplina` varchar(200) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  `id_tipo_disciplina` int(11) NOT NULL,
  PRIMARY KEY (`id_disciplina`),
  KEY `fk_disciplina_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  KEY `fk_disciplina_tipo_disciplina1_idx` (`id_tipo_disciplina`),
  CONSTRAINT `fk_disciplina_ciclo_letivo1` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_tipo_disciplina1` FOREIGN KEY (`id_tipo_disciplina`) REFERENCES `tipo_disciplina` (`id_tipo_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `disciplina`
--

/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;


--
-- Definition of table `docencia`
--

DROP TABLE IF EXISTS `docencia`;
CREATE TABLE `docencia` (
  `id_docencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_professor` int(11) NOT NULL,
  `id_disciplina` char(20) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `id_ano_letivo` int(11) DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_docencia`),
  KEY `fk_docencia_professor1_idx` (`id_professor`),
  KEY `fk_docencia_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_docencia_disciplina1_idx` (`id_disciplina`),
  CONSTRAINT `fk_docencia_ano_letivo1` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_docencia_disciplina1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_docencia_professor1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docencia`
--

/*!40000 ALTER TABLE `docencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `docencia` ENABLE KEYS */;


--
-- Definition of table `encarregado_educacao`
--

DROP TABLE IF EXISTS `encarregado_educacao`;
CREATE TABLE `encarregado_educacao` (
  `id_encarregado` int(11) NOT NULL AUTO_INCREMENT,
  `nome_encarregado` varchar(45) DEFAULT NULL,
  `sobrenome_encarregado` varchar(45) DEFAULT NULL,
  `id_profissao_encarregado` int(11) NOT NULL,
  `sexo_encarregado` char(20) NOT NULL,
  `casa_encarregado` varchar(45) DEFAULT NULL,
  `rua_encarregado` varchar(45) DEFAULT NULL,
  `bairro_encarregado` varchar(45) DEFAULT NULL,
  `distrito_urbano_encarregado` varchar(45) DEFAULT NULL,
  `telemovel_principal_encarregado` varchar(45) DEFAULT NULL,
  `telemovel_alternativo_encarregado` varchar(45) DEFAULT NULL,
  `email_principal_encarregado` varchar(45) DEFAULT NULL,
  `email_alternativo_encarregado` varchar(45) DEFAULT NULL,
  `foto_encarregado` longblob,
  `url_foto_encarregado` varchar(45) DEFAULT 'padrao.png',
  `id_municipio` int(11) NOT NULL,
  `login_encarregado_educacao` varchar(45) DEFAULT NULL,
  `password_encarregado_educacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_encarregado`),
  KEY `fk_encarregado_educacao_profissao1_idx` (`id_profissao_encarregado`),
  KEY `fk_encarregado_educacao_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_encarregado_educacao_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_encarregado_educacao_profissao1` FOREIGN KEY (`id_profissao_encarregado`) REFERENCES `profissao` (`id_profissao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `encarregado_educacao`
--

/*!40000 ALTER TABLE `encarregado_educacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `encarregado_educacao` ENABLE KEYS */;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `casa` int(11) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `comuna` varchar(45) DEFAULT NULL,
  `distrito` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `endereco`
--

/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


--
-- Definition of table `falta`
--

DROP TABLE IF EXISTS `falta`;
CREATE TABLE `falta` (
  `id_falta` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `hora` datetime DEFAULT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `id_disciplina` char(20) NOT NULL,
  PRIMARY KEY (`id_falta`),
  KEY `fk_faltas_aluno1_idx` (`id_aluno`),
  KEY `fk_faltas_turma1_idx` (`id_turma`),
  KEY `fk_faltas_professor1_idx` (`id_professor`),
  KEY `fk_falta_disciplina1_idx` (`id_disciplina`),
  CONSTRAINT `fk_falta_disciplina1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_professor1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `falta`
--

/*!40000 ALTER TABLE `falta` DISABLE KEYS */;
/*!40000 ALTER TABLE `falta` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(45) DEFAULT NULL,
  `sobrenome_funcionario` varchar(45) DEFAULT NULL,
  `sexo` char(20) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `casa_funcionario` varchar(45) DEFAULT NULL,
  `bairro_funcionario` varchar(45) DEFAULT NULL,
  `distrito_funcionario` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `foto_funcionario` blob,
  `url_foto_funcionario` varchar(45) DEFAULT 'padrao.png',
  `telefone_fixo` varchar(45) DEFAULT NULL,
  `telefone_movel` varchar(45) DEFAULT NULL,
  `email_funcionario` varchar(45) DEFAULT NULL,
  `login_funcionario` varchar(45) DEFAULT NULL,
  `password_funcionario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_aluno_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_aluno_municipio10` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `funcionario_categoria_cargo`
--

DROP TABLE IF EXISTS `funcionario_categoria_cargo`;
CREATE TABLE `funcionario_categoria_cargo` (
  `id_funcionario_categoria_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) DEFAULT NULL,
  `id_categoria_cargo` int(11) DEFAULT NULL,
  `data_nomeacao` date DEFAULT NULL,
  `data_fim_nomeacao` date DEFAULT NULL,
  `Observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario_categoria_cargo`),
  KEY `fk_professor_categoria_cargo_categoria_cargo1_idx` (`id_categoria_cargo`),
  KEY `fk_funcionario_categoria_cargo_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_funcionario_categoria_cargo_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_categoria_cargo_categoria_cargo10` FOREIGN KEY (`id_categoria_cargo`) REFERENCES `categoria_cargo` (`id_categoria_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario_categoria_cargo`
--

/*!40000 ALTER TABLE `funcionario_categoria_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario_categoria_cargo` ENABLE KEYS */;


--
-- Definition of table `funcionario_departamento`
--

DROP TABLE IF EXISTS `funcionario_departamento`;
CREATE TABLE `funcionario_departamento` (
  `id_funcionario_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `observacoes` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario_departamento`),
  KEY `fk_professor_departamento_departamento1_idx` (`id_departamento`),
  KEY `fk_funcionario_departamento_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_funcionario_departamento_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_departamento_departamento10` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario_departamento`
--

/*!40000 ALTER TABLE `funcionario_departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario_departamento` ENABLE KEYS */;


--
-- Definition of table `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
CREATE TABLE `instituicao` (
  `id_instituicao` int(11) NOT NULL AUTO_INCREMENT,
  `nome_instituicao` varchar(100) DEFAULT NULL,
  `casa_instituicao` varchar(45) DEFAULT NULL,
  `rua_instituicao` varchar(45) DEFAULT NULL,
  `bairro_instituicao` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `telefone_fixo_instituicao` varchar(45) DEFAULT NULL,
  `telefone_unitel_instituicao` varchar(45) DEFAULT NULL,
  `telefone_movicel_instituicao` varchar(45) DEFAULT NULL,
  `email_instituicao` varchar(45) DEFAULT NULL,
  `home_instituicao` varchar(45) DEFAULT NULL,
  `logotipo_instituicao` longblob,
  `urllogotipo_instituicao` varchar(45) DEFAULT 'padrao.png',
  PRIMARY KEY (`id_instituicao`),
  KEY `fk_insituicao_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_insituicao_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instituicao`
--

/*!40000 ALTER TABLE `instituicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `instituicao` ENABLE KEYS */;


--
-- Definition of table `local_emissao_documento`
--

DROP TABLE IF EXISTS `local_emissao_documento`;
CREATE TABLE `local_emissao_documento` (
  `id_local_emissao_documento` int(11) NOT NULL AUTO_INCREMENT,
  `local_emissao_documento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_local_emissao_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `local_emissao_documento`
--

/*!40000 ALTER TABLE `local_emissao_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `local_emissao_documento` ENABLE KEYS */;


--
-- Definition of table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL AUTO_INCREMENT,
  `data_matricula` date DEFAULT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `codigo_curso` char(45) NOT NULL,
  `id_ano_letivo` int(11) NOT NULL,
  `estado_matricula` tinyint(1) DEFAULT NULL,
  `id_turma` int(11) NOT NULL,
  `id_tipo_documento_identidade` int(11) NOT NULL,
  `data_emissao_documento` date DEFAULT NULL,
  `id_local_emissao_documento` int(11) NOT NULL,
  `numero_documento` varchar(100) DEFAULT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  `id_ano_curricular` int(11) NOT NULL,
  `lingua_opcao` varchar(45) DEFAULT NULL,
  `situacao_aluno` varchar(45) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `lingua_estudada` varchar(45) NOT NULL,
  PRIMARY KEY (`id_matricula`),
  KEY `fk_matricula_aluno1_idx` (`id_aluno`),
  KEY `fk_matricula_funcionario1_idx` (`id_funcionario`),
  KEY `fk_matricula_curso1_idx` (`codigo_curso`),
  KEY `fk_matricula_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_matricula_turma1_idx` (`id_turma`),
  KEY `fk_matricula_tipo_documento_identidade1_idx` (`id_tipo_documento_identidade`),
  KEY `fk_matricula_local_emissao_documento1_idx` (`id_local_emissao_documento`),
  KEY `fk_matricula_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  KEY `fk_matricula_ano_curricular1_idx` (`id_ano_curricular`),
  CONSTRAINT `fk_matricula_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ano_curricular1` FOREIGN KEY (`id_ano_curricular`) REFERENCES `ano_curricular` (`id_ano_curricular`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ano_letivo1` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ciclo_letivo1` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_curso1` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_local_emissao_documento1` FOREIGN KEY (`id_local_emissao_documento`) REFERENCES `local_emissao_documento` (`id_local_emissao_documento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_tipo_documento_identidade1` FOREIGN KEY (`id_tipo_documento_identidade`) REFERENCES `tipo_documento_identidade` (`id_tipo_documento_identidade`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matricula`
--

/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;


--
-- Definition of table `mensalidade`
--

DROP TABLE IF EXISTS `mensalidade`;
CREATE TABLE `mensalidade` (
  `id_mensalidade` int(11) NOT NULL AUTO_INCREMENT,
  `id_ano_letivo` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  `descricao_mensalidade` varchar(200) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `id_mes` int(11) NOT NULL,
  `valor_pago` double DEFAULT NULL,
  `valor_multa` double DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  `id_aluno` int(11) NOT NULL,
  `codigo_curso` char(45) NOT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_mensalidade`),
  KEY `fk_mensalidade_aluno1_idx` (`id_aluno`),
  KEY `fk_mensalidade_curso1_idx` (`codigo_curso`),
  KEY `fk_mensalidade_mes1_idx` (`id_mes`),
  KEY `fk_mensalidade_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_mensalidade_departamento1_idx` (`id_departamento`),
  KEY `fk_mensalidade_turma1_idx` (`id_turma`),
  KEY `fk_mensalidade_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  CONSTRAINT `fk_mensalidade_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_ano_letivo1` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_ciclo_letivo1` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_curso1` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_mes1` FOREIGN KEY (`id_mes`) REFERENCES `mes` (`id_mes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mensalidade`
--

/*!40000 ALTER TABLE `mensalidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensalidade` ENABLE KEYS */;


--
-- Definition of table `mes`
--

DROP TABLE IF EXISTS `mes`;
CREATE TABLE `mes` (
  `id_mes` int(11) NOT NULL AUTO_INCREMENT,
  `nome_mes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_mes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mes`
--

/*!40000 ALTER TABLE `mes` DISABLE KEYS */;
/*!40000 ALTER TABLE `mes` ENABLE KEYS */;


--
-- Definition of table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL,
  `nome_municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia1_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `nota`
--

DROP TABLE IF EXISTS `nota`;
CREATE TABLE `nota` (
  `id_nota` int(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `codigo_curso` char(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `data_lancamento` date DEFAULT NULL,
  `nota_primeira_prova` double DEFAULT NULL,
  `nota_segunda_prova` double DEFAULT NULL,
  `nota_terceira_prova` double DEFAULT NULL,
  `nota_exame_recurso` double DEFAULT NULL,
  `nota_exame_final` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `id_ano_letivo` int(11) NOT NULL,
  `id_ciclo_letivo` int(11) NOT NULL,
  `id_disciplina` char(20) NOT NULL,
  `id_classificacao_nota` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `id_ano_curricular` int(11) NOT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `id_semestre_lectivo` int(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `fk_nota_aluno1_idx` (`id_aluno`),
  KEY `fk_nota_curso1_idx` (`codigo_curso`),
  KEY `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo`),
  KEY `fk_nota_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo`),
  KEY `fk_nota_classificacao_nota1_idx` (`id_classificacao_nota`),
  KEY `fk_nota_departamento1_idx` (`id_departamento`),
  KEY `fk_nota_turma1_idx` (`id_turma`),
  KEY `fk_nota_ano_curricular1_idx` (`id_ano_curricular`),
  KEY `fk_nota_disciplina1_idx` (`id_disciplina`),
  KEY `fk_nota_semestre_lectivo1_idx` (`id_semestre_lectivo`),
  CONSTRAINT `fk_nota_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular1` FOREIGN KEY (`id_ano_curricular`) REFERENCES `ano_curricular` (`id_ano_curricular`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo1` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo1` FOREIGN KEY (`id_ciclo_letivo`) REFERENCES `ciclo_letivo` (`id_ciclo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_classificacao_nota1` FOREIGN KEY (`id_classificacao_nota`) REFERENCES `classificacao_nota` (`id_classificacao_nota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso1` FOREIGN KEY (`codigo_curso`) REFERENCES `curso` (`codigo_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id_disciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo1` FOREIGN KEY (`id_periodo_letivo`) REFERENCES `periodo_letivo` (`id_periodo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_semestre_lectivo1` FOREIGN KEY (`id_semestre_lectivo`) REFERENCES `semestre_lectivo` (`id_semestre_lectivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nota`
--

/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;


--
-- Definition of table `notas_para_boletim`
--

DROP TABLE IF EXISTS `notas_para_boletim`;
CREATE TABLE `notas_para_boletim` (
  `id_notas_para_boletim` int(11) NOT NULL AUTO_INCREMENT,
  `id_boletin_notas` int(11) NOT NULL,
  `id_nota` int(11) NOT NULL,
  PRIMARY KEY (`id_notas_para_boletim`),
  KEY `fk_notas_para_boletim_boletin_notas1_idx` (`id_boletin_notas`),
  KEY `fk_notas_para_boletim_nota1_idx` (`id_nota`),
  CONSTRAINT `fk_notas_para_boletim_boletin_notas1` FOREIGN KEY (`id_boletin_notas`) REFERENCES `boletim_notas` (`id_boletin_notas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_para_boletim_nota1` FOREIGN KEY (`id_nota`) REFERENCES `nota` (`id_nota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notas_para_boletim`
--

/*!40000 ALTER TABLE `notas_para_boletim` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas_para_boletim` ENABLE KEYS */;


--
-- Definition of table `notas_para_certifica`
--

DROP TABLE IF EXISTS `notas_para_certifica`;
CREATE TABLE `notas_para_certifica` (
  `id_notas_certifica_boletin` int(11) NOT NULL AUTO_INCREMENT,
  `id_certificado` int(11) NOT NULL,
  `notas_certifica` double DEFAULT NULL,
  `id_nota` int(11) NOT NULL,
  PRIMARY KEY (`id_notas_certifica_boletin`),
  KEY `fk_notas_certifica_boletin_certificado1_idx` (`id_certificado`),
  KEY `fk_notas_para_certifica_nota1_idx` (`id_nota`),
  CONSTRAINT `fk_notas_certifica_boletin_certificado1` FOREIGN KEY (`id_certificado`) REFERENCES `certificado` (`id_certificado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_para_certifica_nota1` FOREIGN KEY (`id_nota`) REFERENCES `nota` (`id_nota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notas_para_certifica`
--

/*!40000 ALTER TABLE `notas_para_certifica` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas_para_certifica` ENABLE KEYS */;


--
-- Definition of table `objetivo_declaracao`
--

DROP TABLE IF EXISTS `objetivo_declaracao`;
CREATE TABLE `objetivo_declaracao` (
  `id_objetivo_declaracao` int(11) NOT NULL AUTO_INCREMENT,
  `objetivo_declaracao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_objetivo_declaracao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `objetivo_declaracao`
--

/*!40000 ALTER TABLE `objetivo_declaracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `objetivo_declaracao` ENABLE KEYS */;


--
-- Definition of table `pais`
--

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nome_pais` varchar(50) DEFAULT NULL,
  `name_pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pais`
--

/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;


--
-- Definition of table `parentesco`
--

DROP TABLE IF EXISTS `parentesco`;
CREATE TABLE `parentesco` (
  `id_parentesco` int(11) NOT NULL AUTO_INCREMENT,
  `parentesco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_parentesco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parentesco`
--

/*!40000 ALTER TABLE `parentesco` DISABLE KEYS */;
/*!40000 ALTER TABLE `parentesco` ENABLE KEYS */;


--
-- Definition of table `periodo_letivo`
--

DROP TABLE IF EXISTS `periodo_letivo`;
CREATE TABLE `periodo_letivo` (
  `id_periodo_letivo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo_letivo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_periodo_letivo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `periodo_letivo`
--

/*!40000 ALTER TABLE `periodo_letivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo_letivo` ENABLE KEYS */;


--
-- Definition of table `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_professor` varchar(45) DEFAULT NULL,
  `sobrenome_professor` varchar(45) DEFAULT NULL,
  `data_nascimento_professor` date DEFAULT NULL,
  `sexo_professor` char(45) DEFAULT NULL,
  `nif_professor` varchar(45) DEFAULT NULL,
  `foto_professor` blob,
  `url_foto_professor` varchar(45) DEFAULT 'padrao.png',
  `casa_professor` varchar(45) DEFAULT NULL,
  `rua_professor` varchar(45) DEFAULT NULL,
  `bairro_professor` varchar(45) DEFAULT NULL,
  `distrito_urbano_professor` varchar(45) DEFAULT NULL,
  `telemovel_principal_professor` varchar(45) DEFAULT NULL,
  `telemovel_alternativo_professor` varchar(45) DEFAULT NULL,
  `telefone_principal_professor` varchar(45) DEFAULT NULL,
  `telefone_alternativo_professor` varchar(45) DEFAULT NULL,
  `email_principal_professor` varchar(45) DEFAULT NULL,
  `email_aternativo_professor` varchar(45) DEFAULT NULL,
  `numero_bi_professor` varchar(45) DEFAULT NULL,
  `iban_professor` varchar(45) DEFAULT NULL,
  `numero_passaporte_professor` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  `login_professor` varchar(45) DEFAULT NULL,
  `password_professor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_professor`),
  KEY `fk_professor_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_professor_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor`
--

/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;


--
-- Definition of table `professor_categoria_cargo`
--

DROP TABLE IF EXISTS `professor_categoria_cargo`;
CREATE TABLE `professor_categoria_cargo` (
  `id_professor_categoria_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria_cargo` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `data_nomeacao` date DEFAULT NULL,
  `data_fim_nomeacao` date DEFAULT NULL,
  `Observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_professor_categoria_cargo`),
  KEY `fk_professor_categoria_cargo_categoria_cargo1_idx` (`id_categoria_cargo`),
  KEY `fk_professor_categoria_cargo_professor1_idx` (`id_professor`),
  CONSTRAINT `fk_professor_categoria_cargo_categoria_cargo1` FOREIGN KEY (`id_categoria_cargo`) REFERENCES `categoria_cargo` (`id_categoria_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_categoria_cargo_professor1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor_categoria_cargo`
--

/*!40000 ALTER TABLE `professor_categoria_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_categoria_cargo` ENABLE KEYS */;


--
-- Definition of table `professor_departamento`
--

DROP TABLE IF EXISTS `professor_departamento`;
CREATE TABLE `professor_departamento` (
  `id_professor_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `id_professor` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `observacoes` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id_professor_departamento`),
  KEY `fk_professor_departamento_professor1_idx` (`id_professor`),
  KEY `fk_professor_departamento_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_professor_departamento_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_departamento_professor1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor_departamento`
--

/*!40000 ALTER TABLE `professor_departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_departamento` ENABLE KEYS */;


--
-- Definition of table `profissao`
--

DROP TABLE IF EXISTS `profissao`;
CREATE TABLE `profissao` (
  `id_profissao` int(11) NOT NULL AUTO_INCREMENT,
  `nome_profissao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_profissao`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profissao`
--

/*!40000 ALTER TABLE `profissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `profissao` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_provincia_pais1_idx` (`id_pais`),
  CONSTRAINT `fk_provincia_pais1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;


--
-- Definition of table `sala`
--

DROP TABLE IF EXISTS `sala`;
CREATE TABLE `sala` (
  `id_sala` int(11) NOT NULL AUTO_INCREMENT,
  `nome_sala` varchar(45) DEFAULT NULL,
  `localizacao` varchar(45) DEFAULT NULL,
  `id_andar_edificio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sala`),
  KEY `fk_sala_andar_edificio1_idx` (`id_andar_edificio`),
  CONSTRAINT `fk_sala_andar_edificio1` FOREIGN KEY (`id_andar_edificio`) REFERENCES `andar_edificio` (`id_andar_edificio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sala`
--

/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;


--
-- Definition of table `semestre_lectivo`
--

DROP TABLE IF EXISTS `semestre_lectivo`;
CREATE TABLE `semestre_lectivo` (
  `id_semestre_lectivo` int(11) NOT NULL AUTO_INCREMENT,
  `semestre_lectivo` varchar(45) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_semestre_lectivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `semestre_lectivo`
--

/*!40000 ALTER TABLE `semestre_lectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `semestre_lectivo` ENABLE KEYS */;


--
-- Definition of table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
CREATE TABLE `sexo` (
  `id_sexo` int(11) NOT NULL AUTO_INCREMENT,
  `designacao_sexo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_sexo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sexo`
--

/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;


--
-- Definition of table `situacao_transferencia`
--

DROP TABLE IF EXISTS `situacao_transferencia`;
CREATE TABLE `situacao_transferencia` (
  `id_situacao_transferencia` int(11) NOT NULL AUTO_INCREMENT,
  `situacao_transferencia` varchar(45) DEFAULT NULL COMMENT 'Estado ou situacao da transferencia\n\nDeferida ou indeferida',
  PRIMARY KEY (`id_situacao_transferencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `situacao_transferencia`
--

/*!40000 ALTER TABLE `situacao_transferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `situacao_transferencia` ENABLE KEYS */;


--
-- Definition of table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
CREATE TABLE `tipo_cliente` (
  `id_tipo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_cliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_cliente`
--

/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;


--
-- Definition of table `tipo_disciplina`
--

DROP TABLE IF EXISTS `tipo_disciplina`;
CREATE TABLE `tipo_disciplina` (
  `id_tipo_disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_disciplina` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_disciplina`
--

/*!40000 ALTER TABLE `tipo_disciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_disciplina` ENABLE KEYS */;


--
-- Definition of table `tipo_documento_identidade`
--

DROP TABLE IF EXISTS `tipo_documento_identidade`;
CREATE TABLE `tipo_documento_identidade` (
  `id_tipo_documento_identidade` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento_identidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_documento_identidade`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_documento_identidade`
--

/*!40000 ALTER TABLE `tipo_documento_identidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_documento_identidade` ENABLE KEYS */;


--
-- Definition of table `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
CREATE TABLE `transferencia` (
  `id_transferencia` int(11) NOT NULL AUTO_INCREMENT,
  `data_transferencia` date DEFAULT NULL,
  `texto_transferencia` text,
  `id_aluno` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_situacao_transferencia` int(11) NOT NULL,
  `observacoes` text,
  PRIMARY KEY (`id_transferencia`),
  KEY `fk_transferencia_aluno1_idx` (`id_aluno`),
  KEY `fk_transferencia_funcionario1_idx` (`id_funcionario`),
  KEY `fk_transferencia_situacao_transferencia1_idx` (`id_situacao_transferencia`),
  CONSTRAINT `fk_transferencia_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transferencia_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transferencia_situacao_transferencia1` FOREIGN KEY (`id_situacao_transferencia`) REFERENCES `situacao_transferencia` (`id_situacao_transferencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transferencia`
--

/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferencia` ENABLE KEYS */;


--
-- Definition of table `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE `turma` (
  `id_turma` int(11) NOT NULL AUTO_INCREMENT,
  `nome_turma` varchar(45) DEFAULT NULL,
  `id_ano_letivo` int(11) NOT NULL,
  `id_periodo_letivo` int(11) NOT NULL,
  `numero_maximo_inscristos` int(11) DEFAULT NULL,
  `id_sala` int(11) NOT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `fk_turma_ano_letivo1_idx` (`id_ano_letivo`),
  KEY `fk_turma_periodo_letivo1_idx` (`id_periodo_letivo`),
  KEY `fk_turma_sala1_idx` (`id_sala`),
  CONSTRAINT `fk_turma_ano_letivo1` FOREIGN KEY (`id_ano_letivo`) REFERENCES `ano_letivo` (`id_ano_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_periodo_letivo1` FOREIGN KEY (`id_periodo_letivo`) REFERENCES `periodo_letivo` (`id_periodo_letivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_sala1` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `turma`
--

/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(45) DEFAULT NULL,
  `password_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` varchar(45) DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `fk_venda_funcionario1_idx` (`id_funcionario`),
  KEY `fk_venda_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venda`
--

/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;


--
-- Definition of table `venda_detalhes`
--

DROP TABLE IF EXISTS `venda_detalhes`;
CREATE TABLE `venda_detalhes` (
  `id_venda` int(11) NOT NULL,
  `id_artigo` int(11) NOT NULL,
  `quantidade_detalhes_venda` int(11) DEFAULT NULL,
  `desconto_detalhes_venda` double DEFAULT NULL,
  `preco__detalhes_venda` double DEFAULT NULL,
  PRIMARY KEY (`id_venda`,`id_artigo`),
  KEY `fk_detalhes_venda_venda1_idx` (`id_venda`),
  KEY `fk_detalhes_venda_artigo1_idx` (`id_artigo`),
  CONSTRAINT `fk_detalhes_venda_artigo1` FOREIGN KEY (`id_artigo`) REFERENCES `artigo` (`id_artigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_venda_venda1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venda_detalhes`
--

/*!40000 ALTER TABLE `venda_detalhes` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_detalhes` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
