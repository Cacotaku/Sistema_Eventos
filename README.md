# Sistema de Eventos 

O sistema de Eventos deve permitir que o usuário consiga:

- Cadastrar um evento
- Cadastrar um usuário
- Cadastrar umna categoria de evento
- Cadastrar uma inscrição num evento
- Realizar busca de eventos que o usuário participou
- Realizar a busca de usuários de um evento
- Realizar a busca de eventos de uma cetegoria

Este projeto é uma aplicação de **CRUD** (Criar, Ler, Atualizar, Deletar) para gerenciamento de tarefas com um banco de dados relacional MySQL. O sistema deve realizar o cadastro dos dados no banco de dados (MySQL)

--- 

## Status

### Tecnologias utilizadas: 
<img loading="lazy" src="https://cdn.iconscout.com/icon/free/png-512/free-java-logo-icon-download-in-svg-png-gif-file-formats--wordmark-programming-language-pack-logos-icons-1174953.png?f=webp&w=256" width="40" height="40"/> <img loading="lazy" src="https://images.icon-icons.com/2699/PNG/512/mysql_logo_icon_169941.png" width="40" height="40"/> <img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg" width="40" height="40"/>
<img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="40" height="40"/>


Atualmente o sistema realiza a conexão com o banco de dados para cadastro de usuários, eventos, categorias e associação de usuários a eventos. 

---

## Tecnologias

- **MySQL** (Versão 8.4.6)
- **Java** (Versão 23.0.2)

---

## Como Rodar

Aqui, você explica os passos necessários para rodar o projeto no ambiente local do usuário.

Exemplo:
1. Clone o repositório:
    ```bash
    git clone https://github.com/cacotaku/Sistema_Eventos.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd Sistema_Eventos
    ```

---

## Como Contribuir

Dicas e regras para quem quer contribuir no projeto, por exemplo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (`git checkout -b feature-nova`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para o repositório remoto (`git push origin feature-nova`).
5. Crie um Pull Request.

---

## Autoria

Informe seu nome e informações de contato, caso alguém queira entrar em contato para dúvidas ou contribuições.

Desenvolvido por **[Paulo Izidoro](https://www.linkedin.com/in/paulo-de-tarso-oliveira-20286135/)**.

---


# Script do banco de dados:

### 1. Criação de banco de dados 'Homework01'
drop database Homework01;
<BR>
create database if not exists Homework01;

### 2. Selecionar banco de dados
use Homework01;


### 3. Criação da tabela CATEGORIAS;
drop table if exists CATEGORIAS;
<BR>
CREATE TABLE CATEGORIAS 
( 
 id_categoria INT PRIMARY KEY AUTO_INCREMENT,  
 nome varchar(50) NOT NULL,  
 descricao varchar(50)
 ); 

### 4. Criação da tabela USUARIO;
drop table if exists USUARIO;
<BR>
CREATE TABLE USUARIO 
( 
 id_usuario INT PRIMARY KEY AUTO_INCREMENT,  
 nome varchar(50) NOT NULL, 
 idade INT,  
 endereco varchar(50) 
); 

### 5. Criação da tabela EVENTO_USUARIO;
drop table if exists EVENTO_USUARIO;
<BR>
CREATE TABLE EVENTO_USUARIO 
( 
 id_evento INT,  
 id_usuario INT  
); 

### 6. Criação da tabela EVENTO;
drop table if exists EVENTO;
<BR>
CREATE TABLE EVENTO 
( 
 id_evento INT PRIMARY KEY AUTO_INCREMENT,  
 nome VARCHAR(25) NOT NULL,  
 endereco varchar(25),  
 data DATE,  
 categoria varchar(25),  
 id_CATEGORIA INT,  
 horario CHAR(10)
); 

### 7. Definição de chaves estrangeiras
ALTER TABLE EVENTO_USUARIO ADD FOREIGN KEY(id_evento) REFERENCES EVENTO (id_evento);<BR>
ALTER TABLE EVENTO_USUARIO ADD FOREIGN KEY(id_usuario) REFERENCES USUARIO (id_usuario);<BR>
ALTER TABLE EVENTO ADD FOREIGN KEY(id_CATEGORIA) REFERENCES CATEGORIAS (id_CATEGORIA);<BR>

### 8. Alimentação com dados de teste
insert into CATEGORIAS (nome, descricao) values ('Concerto', 'Apresentação com banda');<BR>
insert into CATEGORIAS (nome, descricao) values ('Recital', 'Encontro de poetistas');<BR>

insert into EVENTO (nome, endereco, data, categoria, id_categoria, horario) values ("aaaa", "dfsgr", "2025-05-05", "06", 1, "4");<BR>
insert into EVENTO (nome, endereco, data, categoria, id_categoria, horario) values ("bbbb", "dfsgr", "2025-05-02", "06", 1, "9");<BR>
insert into EVENTO (nome, endereco, data, categoria, id_categoria, horario) values ("cccc", "kdudk", "2015-05-02", "05", 1, "15");<BR>

insert into EVENTO_USUARIO (id_evento, id_usuario) values (1, 1);<BR>

<!-- Chamadas de tabelas

select * from categorias;
Select * from evento_Usuario;
Select * from usuario;
select * from evento;

-->

# Script de criação de usuário

### 1. Criação do usuário 'test1'

[//]: # (CREATE USER 'test1'@'localhost' IDENTIFIED BY 'b123';)

### 2. Definição de permissões para o usuário 'test1'

[//]: # (GRANT ALL PRIVILEGES ON HOMEWORK01.* TO 'test1'@'localhost';)

### 3. Atualizar permissões

[//]: # (FLUSH PRIVILEGES;)

