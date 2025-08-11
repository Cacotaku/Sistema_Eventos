# Sistema de Eventos 



Proposta da faculdade de criar um sistema de Eventos:

O sistema deve conter a opção de cadastrar o usuário, cadastrar o evento e cadastrar a categoria do evento
O sistema deve também exibir quais as categorias disponíveis, exibir quais usuários estão cadastrados em um evento e listar os eventos em que um usuário participou.
O sistema deve permitir que um usuário possa cancelar sua inscrição para um evento.

Opcionalmente, o sistema pode estar conectado com o banco de dados (mysql)

O sistema deve possuir interface gráfica.


### ------------------------------------------   Status ------------------------------------------

### Tecnologias utilizadas: 
<img loading="lazy" src="https://cdn.iconscout.com/icon/free/png-512/free-java-logo-icon-download-in-svg-png-gif-file-formats--wordmark-programming-language-pack-logos-icons-1174953.png?f=webp&w=256" width="40" height="40"/> <img loading="lazy" src="https://images.icon-icons.com/2699/PNG/512/mysql_logo_icon_169941.png" width="40" height="40"/> <img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg" width="40" height="40"/>
<img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" width="40" height="40"/>


Atualmente o sistema realiza a conexão com o banco de dados para cadastro de usuários, eventos, categorias e associação de usuários a eventos. 





### ------------------------------------------ Desafios ------------------------------------------

- Retirar linhas de código não utilizadas.
- Documentar melhor as funções do código.
- Conexão entre Java, MySql e Linux Mint (Procurar treinar conexão Maven (atualmente o sistema conecta com o connector J (JDBC) e Windows).



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
insert into categorias (nome, descricao) values ('Concerto', 'Apresentação com banda');<BR>
insert into categorias (nome, descricao) values ('Recital', 'Encontro de poetistas');<BR>

insert into evento (nome, endereco, data, categoria, id_categoria, horario) values ("aaaa", "dfsgr", "2025-05-05", "06", 1, "4");<BR>
insert into evento (nome, endereco, data, categoria, id_categoria, horario) values ("bbbb", "dfsgr", "2025-05-02", "06", 1, "9");<BR>
insert into evento (nome, endereco, data, categoria, id_categoria, horario) values ("cccc", "kdudk", "2015-05-02", "05", 1, "15");<BR>

insert into evento_usuario (id_evento, id_usuario) values (1, 1);<BR>

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

[//]: # (GRANT ALL PRIVILEGES ON homework01.* TO 'test1'@'localhost';)

### 3. Atualizar permissões

[//]: # (FLUSH PRIVILEGES;)

