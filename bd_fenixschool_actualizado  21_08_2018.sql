SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fenixschoolem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fenixschoolem` ;
USE `fenixschoolem` ;

-- -----------------------------------------------------
-- Table `fenixschoolem`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`pais` (
  `id_pais` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_pais` VARCHAR(50) NULL DEFAULT NULL,
  `name_pais` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pais`))
ENGINE = InnoDB
AUTO_INCREMENT = 253
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`provincia` (
  `id_provincia` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` VARCHAR(45) NULL DEFAULT NULL,
  `id_pais` INT(11) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  INDEX `fk_provincia_pais1_idx` (`id_pais` ASC),
  CONSTRAINT `fk_provincia_pais1`
    FOREIGN KEY (`id_pais`)
    REFERENCES `fenixschoolem`.`pais` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`municipio` (
  `id_municipio` INT(11) NOT NULL,
  `nome_municipio` VARCHAR(45) NULL DEFAULT NULL,
  `id_provincia` INT(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  INDEX `fk_municipio_provincia1_idx` (`id_provincia` ASC),
  CONSTRAINT `fk_municipio_provincia1`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `fenixschoolem`.`provincia` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`profissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`profissao` (
  `id_profissao` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_profissao` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_profissao`))
ENGINE = InnoDB
AUTO_INCREMENT = 64
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`aluno` (
  `id_aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `nome_pai` VARCHAR(100) NULL DEFAULT NULL,
  `nome_mae` VARCHAR(100) NULL DEFAULT NULL,
  `numero_BI` VARCHAR(45) NULL DEFAULT NULL,
  `data_emisao_BI` DATE NULL DEFAULT NULL,
  `local_emisaao_BI` VARCHAR(100) NULL DEFAULT NULL,
  `numero_passaporte` VARCHAR(45) NULL DEFAULT NULL,
  `data_emissao_passaporte` DATE NULL DEFAULT NULL,
  `local_emissao_passaporte` VARCHAR(45) NULL DEFAULT NULL,
  `casa_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `distrito_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `comuna_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `foto_aluno` BLOB NULL DEFAULT NULL,
  `url_foto_aluno` VARCHAR(45) NULL DEFAULT 'padrao.png',
  `telefone_fixo` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movel` VARCHAR(45) NULL DEFAULT NULL,
  `email_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `id_profissao` INT(11) NOT NULL,
  `sexo` CHAR(10) NULL DEFAULT NULL,
  `login_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `password_aluno` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  INDEX `fk_aluno_municipio1_idx` (`id_municipio` ASC),
  INDEX `fk_aluno_profissao1_idx` (`id_profissao` ASC),
  CONSTRAINT `fk_aluno_municipio1`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_aluno_profissao1`
    FOREIGN KEY (`id_profissao`)
    REFERENCES `fenixschoolem`.`profissao` (`id_profissao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1012
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`candidato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`candidato` (
  `id_candidato` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `nome_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `casa_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `distrito_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `url_foto_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `foto_candidato` LONGBLOB NULL DEFAULT NULL,
  `telefone_fixo` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movel` VARCHAR(45) NULL DEFAULT NULL,
  `email_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `id_profissao` INT(11) NOT NULL,
  `sexo` CHAR(45) NULL DEFAULT NULL,
  `login_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `password_candidato` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_candidato`),
  INDEX `fk_aluno_municipio1_idx` (`id_municipio` ASC),
  INDEX `fk_aluno_profissao1_idx` (`id_profissao` ASC),
  CONSTRAINT `fk_aluno_municipio11`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_profissao10`
    FOREIGN KEY (`id_profissao`)
    REFERENCES `fenixschoolem`.`profissao` (`id_profissao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`encarregado_educacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`encarregado_educacao` (
  `id_encarregado` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `id_profissao_encarregado` INT(11) NOT NULL,
  `sexo_encarregado` CHAR(20) NOT NULL,
  `casa_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `rua_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `distrito_urbano_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `telemovel_principal_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `telemovel_alternativo_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `email_principal_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `email_alternativo_encarregado` VARCHAR(45) NULL DEFAULT NULL,
  `foto_encarregado` LONGBLOB NULL DEFAULT NULL,
  `url_foto_encarregado` VARCHAR(45) NULL DEFAULT 'padrao.png',
  `id_municipio` INT(11) NOT NULL,
  `login_encarregado_educacao` VARCHAR(45) NULL DEFAULT NULL,
  `password_encarregado_educacao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_encarregado`),
  INDEX `fk_encarregado_educacao_profissao1_idx` (`id_profissao_encarregado` ASC),
  INDEX `fk_encarregado_educacao_municipio1_idx` (`id_municipio` ASC),
  CONSTRAINT `fk_encarregado_educacao_municipio1`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_encarregado_educacao_profissao1`
    FOREIGN KEY (`id_profissao_encarregado`)
    REFERENCES `fenixschoolem`.`profissao` (`id_profissao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`funcionario` (
  `id_funcionario` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` CHAR(20) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `casa_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `distrito_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `foto_funcionario` BLOB NULL DEFAULT NULL,
  `url_foto_funcionario` VARCHAR(45) NULL DEFAULT 'padrao.png',
  `telefone_fixo` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movel` VARCHAR(45) NULL DEFAULT NULL,
  `email_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `login_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `password_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  INDEX `fk_aluno_municipio1_idx` (`id_municipio` ASC),
  CONSTRAINT `fk_aluno_municipio10`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`professor` (
  `id_professor` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_professor` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_professor` VARCHAR(45) NULL DEFAULT NULL,
  `data_nascimento_professor` DATE NULL DEFAULT NULL,
  `sexo_professor` CHAR(45) NULL DEFAULT NULL,
  `nif_professor` VARCHAR(45) NULL DEFAULT NULL,
  `foto_professor` BLOB NULL DEFAULT NULL,
  `url_foto_professor` VARCHAR(45) NULL DEFAULT 'padrao.png',
  `casa_professor` VARCHAR(45) NULL DEFAULT NULL,
  `rua_professor` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_professor` VARCHAR(45) NULL DEFAULT NULL,
  `distrito_urbano_professor` VARCHAR(45) NULL DEFAULT NULL,
  `telemovel_principal_professor` VARCHAR(45) NULL DEFAULT NULL,
  `telemovel_alternativo_professor` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_principal_professor` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_alternativo_professor` VARCHAR(45) NULL DEFAULT NULL,
  `email_principal_professor` VARCHAR(45) NULL DEFAULT NULL,
  `email_aternativo_professor` VARCHAR(45) NULL DEFAULT NULL,
  `numero_bi_professor` VARCHAR(45) NULL DEFAULT NULL,
  `iban_professor` VARCHAR(45) NULL DEFAULT NULL,
  `numero_passaporte_professor` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `login_professor` VARCHAR(45) NULL DEFAULT NULL,
  `password_professor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_professor`),
  INDEX `fk_professor_municipio1_idx` (`id_municipio` ASC),
  CONSTRAINT `fk_professor_municipio1`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`acesso_sistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`acesso_sistema` (
  `id_acesso_sistema` INT(11) NOT NULL AUTO_INCREMENT,
  `data_acesso_sistema` DATE NULL DEFAULT NULL,
  `hora_acesso_sistema` DATETIME NULL DEFAULT NULL,
  `id_professor` INT(11) NULL DEFAULT NULL,
  `id_candidato` INT(11) NULL DEFAULT NULL,
  `aluno_id_aluno` INT(11) NOT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `id_encarregado` INT(11) NOT NULL,
  PRIMARY KEY (`id_acesso_sistema`),
  INDEX `fk_acesso_sistema_professor1_idx` (`id_professor` ASC),
  INDEX `fk_acesso_sistema_candidato1_idx` (`id_candidato` ASC),
  INDEX `fk_acesso_sistema_aluno1_idx` (`aluno_id_aluno` ASC),
  INDEX `fk_acesso_sistema_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_acesso_sistema_encarregado_educacao1_idx` (`id_encarregado` ASC),
  CONSTRAINT `fk_acesso_sistema_aluno1`
    FOREIGN KEY (`aluno_id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_candidato1`
    FOREIGN KEY (`id_candidato`)
    REFERENCES `fenixschoolem`.`candidato` (`id_candidato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_encarregado_educacao1`
    FOREIGN KEY (`id_encarregado`)
    REFERENCES `fenixschoolem`.`encarregado_educacao` (`id_encarregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_sistema_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `fenixschoolem`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`parentesco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`parentesco` (
  `id_parentesco` INT(11) NOT NULL AUTO_INCREMENT,
  `parentesco` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_parentesco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`aluno_encarregado_educacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`aluno_encarregado_educacao` (
  `id_aluno_encarregado_educacao` INT(11) NOT NULL AUTO_INCREMENT,
  `id_encarregado` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `id_parentesco` INT(11) NOT NULL,
  `inicio_responsabilidade` DATE NULL DEFAULT NULL,
  `fim_responsabilidade` DATE NULL DEFAULT NULL,
  `observacoes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_aluno_encarregado_educacao`),
  INDEX `fk_aluno_encarregado_educacao_encarregado_educacao1_idx` (`id_encarregado` ASC),
  INDEX `fk_aluno_encarregado_educacao_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_aluno_encarregado_educacao_parentesco1_idx` (`id_parentesco` ASC),
  CONSTRAINT `fk_aluno_encarregado_educacao_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_encarregado_educacao_encarregado_educacao1`
    FOREIGN KEY (`id_encarregado`)
    REFERENCES `fenixschoolem`.`encarregado_educacao` (`id_encarregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_encarregado_educacao_parentesco1`
    FOREIGN KEY (`id_parentesco`)
    REFERENCES `fenixschoolem`.`parentesco` (`id_parentesco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`endereco` (
  `id_endereco` INT(11) NOT NULL AUTO_INCREMENT,
  `casa` INT(11) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `comuna` VARCHAR(45) NULL DEFAULT NULL,
  `distrito` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_endereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`aluno_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`aluno_endereco` (
  `id_endereco_aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` INT(11) NOT NULL,
  `id_endereco` INT(11) NOT NULL,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  `activo` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_endereco_aluno`),
  INDEX `fk_aluno_endereco_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_aluno_endereco_endereco1_idx` (`id_endereco` ASC),
  CONSTRAINT `fk_aluno_endereco_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_endereco_endereco1`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `fenixschoolem`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`andar_edificio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`andar_edificio` (
  `id_andar_edificio` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_andar_edificio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_andar_edificio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`ciclo_letivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`ciclo_letivo` (
  `id_ciclo_letivo` INT(11) NOT NULL AUTO_INCREMENT,
  `ciclo_letivo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_ciclo_letivo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`ano_curricular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`ano_curricular` (
  `id_ano_curricular` INT(11) NOT NULL AUTO_INCREMENT,
  `ano_curricular` VARCHAR(45) NULL DEFAULT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  PRIMARY KEY (`id_ano_curricular`),
  INDEX `fk_ano_curricular_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  CONSTRAINT `fk_ano_curricular_ciclo_letivo1`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`ano_letivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`ano_letivo` (
  `id_ano_letivo` INT(11) NOT NULL AUTO_INCREMENT,
  `ano_letivo` VARCHAR(45) NULL DEFAULT NULL,
  `inicio_ano_letivo` DATE NULL DEFAULT NULL,
  `fim_ano_letivo` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_ano_letivo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`categoria_artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`categoria_artigo` (
  `id_categoria_artigo` INT(11) NOT NULL AUTO_INCREMENT,
  `categoria_artigo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria_artigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`artigo` (
  `id_artigo` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_artigo` VARCHAR(45) NULL DEFAULT NULL,
  `codigo_barras_artigo` VARCHAR(45) NULL DEFAULT NULL,
  `nome_artigo` VARCHAR(45) NULL DEFAULT NULL,
  `preco_artigo` DOUBLE NULL DEFAULT NULL,
  `id_categoria_artigo` INT(11) NOT NULL,
  PRIMARY KEY (`id_artigo`),
  INDEX `fk_artigo_categoria_artigo1_idx` (`id_categoria_artigo` ASC),
  CONSTRAINT `fk_artigo_categoria_artigo1`
    FOREIGN KEY (`id_categoria_artigo`)
    REFERENCES `fenixschoolem`.`categoria_artigo` (`id_categoria_artigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`boletim_notas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`boletim_notas` (
  `id_boletin_notas` INT(11) NOT NULL AUTO_INCREMENT,
  `data_boletin_notas` DATETIME NULL DEFAULT NULL,
  `id_aluno` INT(11) NOT NULL,
  PRIMARY KEY (`id_boletin_notas`),
  INDEX `fk_boletin_notas_aluno1_idx` (`id_aluno` ASC),
  CONSTRAINT `fk_boletin_notas_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`departamento` (
  `id_departamento` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_departamento`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`curso` (
  `codigo_curso` CHAR(45) NOT NULL,
  `nome_curso` VARCHAR(45) NULL DEFAULT NULL,
  `abreviatura` VARCHAR(45) NULL DEFAULT NULL,
  `codigo_ministerio_educacao` VARCHAR(45) NULL DEFAULT NULL,
  `data_criacao` DATE NULL DEFAULT NULL,
  `id_departamento` INT(11) NOT NULL,
  `descricao_curso` VARCHAR(100) NULL DEFAULT NULL,
  `conteudo_programatico` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo_curso`),
  INDEX `fk_curso_departamento1_idx` (`id_departamento` ASC),
  CONSTRAINT `fk_curso_departamento1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `fenixschoolem`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`local_emissao_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`local_emissao_documento` (
  `id_local_emissao_documento` INT(11) NOT NULL AUTO_INCREMENT,
  `local_emissao_documento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_local_emissao_documento`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`tipo_documento_identidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`tipo_documento_identidade` (
  `id_tipo_documento_identidade` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento_identidade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_documento_identidade`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`periodo_letivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`periodo_letivo` (
  `id_periodo_letivo` INT(11) NOT NULL AUTO_INCREMENT,
  `periodo_letivo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_periodo_letivo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`sala` (
  `id_sala` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_sala` VARCHAR(45) NULL DEFAULT NULL,
  `localizacao` VARCHAR(45) NULL DEFAULT NULL,
  `id_andar_edificio` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_sala`),
  INDEX `fk_sala_andar_edificio1_idx` (`id_andar_edificio` ASC),
  CONSTRAINT `fk_sala_andar_edificio1`
    FOREIGN KEY (`id_andar_edificio`)
    REFERENCES `fenixschoolem`.`andar_edificio` (`id_andar_edificio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`turma` (
  `id_turma` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_turma` VARCHAR(45) NULL DEFAULT NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_periodo_letivo` INT(11) NOT NULL,
  `numero_maximo_inscristos` INT(11) NULL DEFAULT NULL,
  `id_sala` INT(11) NOT NULL,
  PRIMARY KEY (`id_turma`),
  INDEX `fk_turma_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_turma_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_turma_sala1_idx` (`id_sala` ASC),
  CONSTRAINT `fk_turma_ano_letivo1`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_periodo_letivo1`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_sala1`
    FOREIGN KEY (`id_sala`)
    REFERENCES `fenixschoolem`.`sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`candidatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`candidatura` (
  `id_candidatura` INT(11) NOT NULL AUTO_INCREMENT,
  `id_candidato` INT(11) NOT NULL,
  `data_candidatura` DATE NULL DEFAULT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `estado_candidatura` TINYINT(1) NULL DEFAULT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_tipo_documento_identidade` INT(11) NOT NULL,
  `data_emissao_documento` DATE NULL DEFAULT NULL,
  `id_local_emissao_documento` INT(11) NOT NULL,
  `numero_documento` VARCHAR(100) NULL DEFAULT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  `lingua_opcao` VARCHAR(45) NULL DEFAULT NULL,
  `situacao_candidato` VARCHAR(45) NULL DEFAULT NULL,
  `observacao` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_candidatura`),
  INDEX `fk_matricula_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_matricula_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_matricula_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_matricula_turma1_idx` (`id_turma` ASC),
  INDEX `fk_matricula_tipo_documento_identidade1_idx` (`id_tipo_documento_identidade` ASC),
  INDEX `fk_matricula_local_emissao_documento1_idx` (`id_local_emissao_documento` ASC),
  INDEX `fk_matricula_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_matricula_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_candidatura_candidato1_idx` (`id_candidato` ASC),
  CONSTRAINT `fk_candidatura_candidato1`
    FOREIGN KEY (`id_candidato`)
    REFERENCES `fenixschoolem`.`candidato` (`id_candidato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ano_curricular10`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ano_letivo10`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_ciclo_letivo10`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_curso10`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_funcionario10`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_local_emissao_documento10`
    FOREIGN KEY (`id_local_emissao_documento`)
    REFERENCES `fenixschoolem`.`local_emissao_documento` (`id_local_emissao_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_tipo_documento_identidade10`
    FOREIGN KEY (`id_tipo_documento_identidade`)
    REFERENCES `fenixschoolem`.`tipo_documento_identidade` (`id_tipo_documento_identidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_turma10`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`categoria_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`categoria_cargo` (
  `id_categoria_cargo` INT(11) NOT NULL AUTO_INCREMENT,
  `categoria_cargo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria_cargo`))
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`certificado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`certificado` (
  `id_certificado` INT(11) NOT NULL AUTO_INCREMENT,
  `data_certificado` DATE NULL DEFAULT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  `texto_certificado` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_certificado`),
  INDEX `fk_certificado_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_certificado_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_certificado_ano_curricular1_idx` (`id_ano_curricular` ASC),
  CONSTRAINT `fk_certificado_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificado_ano_curricular1`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificado_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`classificacao_nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`classificacao_nota` (
  `id_classificacao_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `classificacao_nota` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_classificacao_nota`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`tipo_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`tipo_cliente` (
  `id_tipo_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_cliente` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `sobrenome_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `telemovel_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `email_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `casa_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `rua_cliente` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `id_tipo_cliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_municipio1_idx` (`id_municipio` ASC),
  INDEX `fk_cliente_tipo_cliente1_idx` (`id_tipo_cliente` ASC),
  CONSTRAINT `fk_cliente_municipio1`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_tipo_cliente1`
    FOREIGN KEY (`id_tipo_cliente`)
    REFERENCES `fenixschoolem`.`tipo_cliente` (`id_tipo_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`tipo_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`tipo_disciplina` (
  `id_tipo_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_disciplina` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_disciplina`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`disciplina` (
  `id_disciplina` CHAR(20) NOT NULL,
  `nome_disciplina` VARCHAR(45) NULL DEFAULT NULL,
  `abreviatura` VARCHAR(45) NULL DEFAULT NULL,
  `descricao_displina` VARCHAR(45) NULL DEFAULT NULL,
  `sumario_disciplina` VARCHAR(200) NULL DEFAULT NULL,
  `data_criacao` DATE NULL DEFAULT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_tipo_disciplina` INT(11) NOT NULL,
  PRIMARY KEY (`id_disciplina`),
  INDEX `fk_disciplina_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_disciplina_tipo_disciplina1_idx` (`id_tipo_disciplina` ASC),
  CONSTRAINT `fk_disciplina_ciclo_letivo1`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_tipo_disciplina1`
    FOREIGN KEY (`id_tipo_disciplina`)
    REFERENCES `fenixschoolem`.`tipo_disciplina` (`id_tipo_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`curso_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`curso_disciplina` (
  `id_curso_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_curso` CHAR(45) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  PRIMARY KEY (`id_curso_disciplina`),
  INDEX `fk_curso_disciplina_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_curso_disciplina_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_curso_disciplina_curso1`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_disciplina_disciplina1`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`objetivo_declaracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`objetivo_declaracao` (
  `id_objetivo_declaracao` INT(11) NOT NULL AUTO_INCREMENT,
  `objetivo_declaracao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_objetivo_declaracao`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`declaracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`declaracao` (
  `id_declaracao` INT(11) NOT NULL AUTO_INCREMENT,
  `texto_declaracao` TEXT NULL DEFAULT NULL,
  `data_declaracao` DATETIME NULL DEFAULT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `id_objetivo_declaracao` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  PRIMARY KEY (`id_declaracao`),
  INDEX `fk_delcaracao_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_delcaracao_objetivo_declaracao1_idx` (`id_objetivo_declaracao` ASC),
  INDEX `fk_delcaracao_aluno1_idx` (`id_aluno` ASC),
  CONSTRAINT `fk_delcaracao_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delcaracao_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delcaracao_objetivo_declaracao1`
    FOREIGN KEY (`id_objetivo_declaracao`)
    REFERENCES `fenixschoolem`.`objetivo_declaracao` (`id_objetivo_declaracao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`docencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`docencia` (
  `id_docencia` INT(11) NOT NULL AUTO_INCREMENT,
  `id_professor` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  `id_ano_letivo` INT(11) NULL DEFAULT NULL,
  `observacao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_docencia`),
  INDEX `fk_docencia_professor1_idx` (`id_professor` ASC),
  INDEX `fk_docencia_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_docencia_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_docencia_ano_letivo1`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docencia_disciplina1`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docencia_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `fenixschoolem`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`falta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`falta` (
  `id_falta` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `hora` DATETIME NULL DEFAULT NULL,
  `id_aluno` INT(11) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_professor` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  PRIMARY KEY (`id_falta`),
  INDEX `fk_faltas_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_faltas_turma1_idx` (`id_turma` ASC),
  INDEX `fk_faltas_professor1_idx` (`id_professor` ASC),
  INDEX `fk_falta_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_falta_disciplina1`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `fenixschoolem`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_faltas_turma1`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`funcionario_categoria_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`funcionario_categoria_cargo` (
  `id_funcionario_categoria_cargo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` INT(11) NULL DEFAULT NULL,
  `id_categoria_cargo` INT(11) NULL DEFAULT NULL,
  `data_nomeacao` DATE NULL DEFAULT NULL,
  `data_fim_nomeacao` DATE NULL DEFAULT NULL,
  `Observacoes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_funcionario_categoria_cargo`),
  INDEX `fk_professor_categoria_cargo_categoria_cargo1_idx` (`id_categoria_cargo` ASC),
  INDEX `fk_funcionario_categoria_cargo_funcionario1_idx` (`id_funcionario` ASC),
  CONSTRAINT `fk_funcionario_categoria_cargo_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_categoria_cargo_categoria_cargo10`
    FOREIGN KEY (`id_categoria_cargo`)
    REFERENCES `fenixschoolem`.`categoria_cargo` (`id_categoria_cargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`funcionario_departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`funcionario_departamento` (
  `id_funcionario_departamento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` INT(11) NOT NULL,
  `id_departamento` INT(11) NOT NULL,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  `observacoes` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id_funcionario_departamento`),
  INDEX `fk_professor_departamento_departamento1_idx` (`id_departamento` ASC),
  INDEX `fk_funcionario_departamento_funcionario1_idx` (`id_funcionario` ASC),
  CONSTRAINT `fk_funcionario_departamento_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_departamento_departamento10`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `fenixschoolem`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`instituicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`instituicao` (
  `id_instituicao` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_instituicao` VARCHAR(100) NULL DEFAULT NULL,
  `casa_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `rua_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `bairro_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `id_municipio` INT(11) NOT NULL,
  `telefone_fixo_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_unitel_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movicel_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `email_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `home_instituicao` VARCHAR(45) NULL DEFAULT NULL,
  `logotipo_instituicao` LONGBLOB NULL DEFAULT NULL,
  `urllogotipo_instituicao` VARCHAR(45) NULL DEFAULT 'padrao.png',
  PRIMARY KEY (`id_instituicao`),
  INDEX `fk_insituicao_municipio1_idx` (`id_municipio` ASC),
  CONSTRAINT `fk_insituicao_municipio1`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `fenixschoolem`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`matricula` (
  `id_matricula` INT(11) NOT NULL AUTO_INCREMENT,
  `data_matricula` DATE NULL DEFAULT NULL,
  `id_aluno` INT(11) NOT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `estado_matricula` TINYINT(1) NULL DEFAULT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_tipo_documento_identidade` INT(11) NOT NULL,
  `data_emissao_documento` DATE NULL DEFAULT NULL,
  `id_local_emissao_documento` INT(11) NOT NULL,
  `numero_documento` VARCHAR(100) NULL DEFAULT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  `lingua_opcao` VARCHAR(45) NULL DEFAULT NULL,
  `situacao_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `observacao` VARCHAR(200) NULL DEFAULT NULL,
  `lingua_estudada` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_matricula`),
  INDEX `fk_matricula_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_matricula_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_matricula_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_matricula_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_matricula_turma1_idx` (`id_turma` ASC),
  INDEX `fk_matricula_tipo_documento_identidade1_idx` (`id_tipo_documento_identidade` ASC),
  INDEX `fk_matricula_local_emissao_documento1_idx` (`id_local_emissao_documento` ASC),
  INDEX `fk_matricula_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_matricula_ano_curricular1_idx` (`id_ano_curricular` ASC),
  CONSTRAINT `fk_matricula_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ano_curricular1`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ano_letivo1`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_ciclo_letivo1`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_curso1`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_local_emissao_documento1`
    FOREIGN KEY (`id_local_emissao_documento`)
    REFERENCES `fenixschoolem`.`local_emissao_documento` (`id_local_emissao_documento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_tipo_documento_identidade1`
    FOREIGN KEY (`id_tipo_documento_identidade`)
    REFERENCES `fenixschoolem`.`tipo_documento_identidade` (`id_tipo_documento_identidade`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_turma1`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`mes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`mes` (
  `id_mes` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_mes` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_mes`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`mensalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`mensalidade` (
  `id_mensalidade` INT(11) NOT NULL AUTO_INCREMENT,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_departamento` INT(11) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `descricao_mensalidade` VARCHAR(200) NULL DEFAULT NULL,
  `data_pagamento` DATE NULL DEFAULT NULL,
  `id_mes` INT(11) NOT NULL,
  `valor_pago` DOUBLE NULL DEFAULT NULL,
  `valor_multa` DOUBLE NULL DEFAULT NULL,
  `desconto` DOUBLE NULL DEFAULT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `observacao` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_mensalidade`),
  INDEX `fk_mensalidade_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_mensalidade_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_mensalidade_mes1_idx` (`id_mes` ASC),
  INDEX `fk_mensalidade_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_mensalidade_departamento1_idx` (`id_departamento` ASC),
  INDEX `fk_mensalidade_turma1_idx` (`id_turma` ASC),
  INDEX `fk_mensalidade_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  CONSTRAINT `fk_mensalidade_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_ano_letivo1`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_ciclo_letivo1`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_curso1`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_departamento1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `fenixschoolem`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_mes1`
    FOREIGN KEY (`id_mes`)
    REFERENCES `fenixschoolem`.`mes` (`id_mes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mensalidade_turma1`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`semestre_lectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`semestre_lectivo` (
  `id_semestre_lectivo` INT(11) NOT NULL AUTO_INCREMENT,
  `semestre_lectivo` VARCHAR(45) NULL DEFAULT NULL,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  `observacoes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_semestre_lectivo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`nota` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  `data_lancamento` DATE NULL DEFAULT NULL,
  `nota_primeira_prova` DOUBLE NULL DEFAULT NULL,
  `nota_segunda_prova` DOUBLE NULL DEFAULT NULL,
  `nota_terceira_prova` DOUBLE NULL DEFAULT NULL,
  `nota_exame_recurso` DOUBLE NULL DEFAULT NULL,
  `nota_exame_final` DOUBLE NULL DEFAULT NULL,
  `peso` DOUBLE NULL DEFAULT NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `id_classificacao_nota` INT(11) NOT NULL,
  `id_departamento` INT(11) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  `observacao` VARCHAR(200) NULL DEFAULT NULL,
  `id_semestre_lectivo` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  INDEX `fk_nota_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_nota_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_nota_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_nota_classificacao_nota1_idx` (`id_classificacao_nota` ASC),
  INDEX `fk_nota_departamento1_idx` (`id_departamento` ASC),
  INDEX `fk_nota_turma1_idx` (`id_turma` ASC),
  INDEX `fk_nota_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_nota_disciplina1_idx` (`id_disciplina` ASC),
  INDEX `fk_nota_semestre_lectivo1_idx` (`id_semestre_lectivo` ASC),
  CONSTRAINT `fk_nota_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular1`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo1`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo1`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_classificacao_nota1`
    FOREIGN KEY (`id_classificacao_nota`)
    REFERENCES `fenixschoolem`.`classificacao_nota` (`id_classificacao_nota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso1`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_departamento1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `fenixschoolem`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina1`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo1`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_semestre_lectivo1`
    FOREIGN KEY (`id_semestre_lectivo`)
    REFERENCES `fenixschoolem`.`semestre_lectivo` (`id_semestre_lectivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma1`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_para_boletim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_para_boletim` (
  `id_notas_para_boletim` INT(11) NOT NULL AUTO_INCREMENT,
  `id_boletin_notas` INT(11) NOT NULL,
  `id_nota` INT(11) NOT NULL,
  PRIMARY KEY (`id_notas_para_boletim`),
  INDEX `fk_notas_para_boletim_boletin_notas1_idx` (`id_boletin_notas` ASC),
  INDEX `fk_notas_para_boletim_nota1_idx` (`id_nota` ASC),
  CONSTRAINT `fk_notas_para_boletim_boletin_notas1`
    FOREIGN KEY (`id_boletin_notas`)
    REFERENCES `fenixschoolem`.`boletim_notas` (`id_boletin_notas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_para_boletim_nota1`
    FOREIGN KEY (`id_nota`)
    REFERENCES `fenixschoolem`.`nota` (`id_nota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_para_certifica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_para_certifica` (
  `id_notas_certifica_boletin` INT(11) NOT NULL AUTO_INCREMENT,
  `id_certificado` INT(11) NOT NULL,
  `notas_certifica` DOUBLE NULL DEFAULT NULL,
  `id_nota` INT(11) NOT NULL,
  PRIMARY KEY (`id_notas_certifica_boletin`),
  INDEX `fk_notas_certifica_boletin_certificado1_idx` (`id_certificado` ASC),
  INDEX `fk_notas_para_certifica_nota1_idx` (`id_nota` ASC),
  CONSTRAINT `fk_notas_certifica_boletin_certificado1`
    FOREIGN KEY (`id_certificado`)
    REFERENCES `fenixschoolem`.`certificado` (`id_certificado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_para_certifica_nota1`
    FOREIGN KEY (`id_nota`)
    REFERENCES `fenixschoolem`.`nota` (`id_nota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`professor_categoria_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`professor_categoria_cargo` (
  `id_professor_categoria_cargo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_categoria_cargo` INT(11) NOT NULL,
  `id_professor` INT(11) NOT NULL,
  `data_nomeacao` DATE NULL DEFAULT NULL,
  `data_fim_nomeacao` DATE NULL DEFAULT NULL,
  `Observacoes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_professor_categoria_cargo`),
  INDEX `fk_professor_categoria_cargo_categoria_cargo1_idx` (`id_categoria_cargo` ASC),
  INDEX `fk_professor_categoria_cargo_professor1_idx` (`id_professor` ASC),
  CONSTRAINT `fk_professor_categoria_cargo_categoria_cargo1`
    FOREIGN KEY (`id_categoria_cargo`)
    REFERENCES `fenixschoolem`.`categoria_cargo` (`id_categoria_cargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_categoria_cargo_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `fenixschoolem`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`professor_departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`professor_departamento` (
  `id_professor_departamento` INT(11) NOT NULL AUTO_INCREMENT,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  `id_professor` INT(11) NOT NULL,
  `id_departamento` INT(11) NOT NULL,
  `observacoes` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id_professor_departamento`),
  INDEX `fk_professor_departamento_professor1_idx` (`id_professor` ASC),
  INDEX `fk_professor_departamento_departamento1_idx` (`id_departamento` ASC),
  CONSTRAINT `fk_professor_departamento_departamento1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `fenixschoolem`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_departamento_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `fenixschoolem`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`sexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`sexo` (
  `id_sexo` INT(11) NOT NULL AUTO_INCREMENT,
  `designacao_sexo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_sexo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`situacao_transferencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`situacao_transferencia` (
  `id_situacao_transferencia` INT(11) NOT NULL AUTO_INCREMENT,
  `situacao_transferencia` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Estado ou situacao da transferencia' /* comment truncated */ /*
Deferida ou indeferida*/,
  PRIMARY KEY (`id_situacao_transferencia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`transferencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`transferencia` (
  `id_transferencia` INT(11) NOT NULL AUTO_INCREMENT,
  `data_transferencia` DATE NULL DEFAULT NULL,
  `texto_transferencia` TEXT NULL DEFAULT NULL,
  `id_aluno` INT(11) NOT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `id_situacao_transferencia` INT(11) NOT NULL,
  `observacoes` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_transferencia`),
  INDEX `fk_transferencia_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_transferencia_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_transferencia_situacao_transferencia1_idx` (`id_situacao_transferencia` ASC),
  CONSTRAINT `fk_transferencia_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transferencia_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transferencia_situacao_transferencia1`
    FOREIGN KEY (`id_situacao_transferencia`)
    REFERENCES `fenixschoolem`.`situacao_transferencia` (`id_situacao_transferencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `password_usuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`venda` (
  `id_venda` INT(11) NOT NULL AUTO_INCREMENT,
  `data_venda` VARCHAR(45) NULL DEFAULT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  INDEX `fk_venda_funcionario1_idx` (`id_funcionario` ASC),
  INDEX `fk_venda_cliente1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `fenixschoolem`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `fenixschoolem`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`venda_detalhes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`venda_detalhes` (
  `id_venda` INT(11) NOT NULL,
  `id_artigo` INT(11) NOT NULL,
  `quantidade_detalhes_venda` INT(11) NULL DEFAULT NULL,
  `desconto_detalhes_venda` DOUBLE NULL DEFAULT NULL,
  `preco__detalhes_venda` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_venda`, `id_artigo`),
  INDEX `fk_detalhes_venda_venda1_idx` (`id_venda` ASC),
  INDEX `fk_detalhes_venda_artigo1_idx` (`id_artigo` ASC),
  CONSTRAINT `fk_detalhes_venda_artigo1`
    FOREIGN KEY (`id_artigo`)
    REFERENCES `fenixschoolem`.`artigo` (`id_artigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_venda_venda1`
    FOREIGN KEY (`id_venda`)
    REFERENCES `fenixschoolem`.`venda` (`id_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_primeiro_trimestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_primeiro_trimestre` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `data_lancamento` DATE NULL DEFAULT NULL,
  `nota_primeira_prova` DOUBLE NULL DEFAULT NULL,
  `nota_segunda_prova` DOUBLE NULL DEFAULT NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  INDEX `fk_nota_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_nota_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_nota_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_nota_turma1_idx` (`id_turma` ASC),
  INDEX `fk_nota_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_nota_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_nota_aluno10`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular10`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo10`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo10`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso10`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina10`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo10`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma10`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_segundo_trimestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_segundo_trimestre` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `data_lancamento` DATE NULL DEFAULT NULL,
  `nota_primeira_prova` DOUBLE NULL DEFAULT NULL,
  `nota_segunda_prova` DOUBLE NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  INDEX `fk_nota_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_nota_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_nota_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_nota_turma1_idx` (`id_turma` ASC),
  INDEX `fk_nota_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_nota_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_nota_aluno100`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular100`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo100`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo100`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso100`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina100`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo100`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma100`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_terceiro_trimestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_terceiro_trimestre` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `data_lancamento` DATE NULL DEFAULT NULL,
  `nota_primeira_prova` DOUBLE NULL DEFAULT NULL,
  `nota_segunda_prova` DOUBLE NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  INDEX `fk_nota_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_nota_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_nota_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_nota_turma1_idx` (`id_turma` ASC),
  INDEX `fk_nota_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_nota_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_nota_aluno1000`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular1000`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo1000`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo1000`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso1000`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina1000`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo1000`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma1000`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fenixschoolem`.`notas_exame_final`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixschoolem`.`notas_exame_final` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `id_periodo_letivo` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  `codigo_curso` CHAR(45) NOT NULL,
  `data_lancamento` DATE NULL DEFAULT NULL,
  `nota_exame_final` DOUBLE NULL,
  `nota_exame_recurso` DOUBLE NULL,
  `exame_especial` DOUBLE NULL,
  `id_ano_letivo` INT(11) NOT NULL,
  `id_ciclo_letivo` INT(11) NOT NULL,
  `id_disciplina` CHAR(20) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_ano_curricular` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota`),
  INDEX `fk_nota_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_nota_curso1_idx` (`codigo_curso` ASC),
  INDEX `fk_nota_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  INDEX `fk_nota_ano_letivo1_idx` (`id_ano_letivo` ASC),
  INDEX `fk_nota_ciclo_letivo1_idx` (`id_ciclo_letivo` ASC),
  INDEX `fk_nota_turma1_idx` (`id_turma` ASC),
  INDEX `fk_nota_ano_curricular1_idx` (`id_ano_curricular` ASC),
  INDEX `fk_nota_disciplina1_idx` (`id_disciplina` ASC),
  CONSTRAINT `fk_nota_aluno10000`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `fenixschoolem`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_curricular10000`
    FOREIGN KEY (`id_ano_curricular`)
    REFERENCES `fenixschoolem`.`ano_curricular` (`id_ano_curricular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ano_letivo10000`
    FOREIGN KEY (`id_ano_letivo`)
    REFERENCES `fenixschoolem`.`ano_letivo` (`id_ano_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_ciclo_letivo10000`
    FOREIGN KEY (`id_ciclo_letivo`)
    REFERENCES `fenixschoolem`.`ciclo_letivo` (`id_ciclo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_curso10000`
    FOREIGN KEY (`codigo_curso`)
    REFERENCES `fenixschoolem`.`curso` (`codigo_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_disciplina10000`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `fenixschoolem`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_periodo_letivo10000`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `fenixschoolem`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_turma10000`
    FOREIGN KEY (`id_turma`)
    REFERENCES `fenixschoolem`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
