# :syringe: Vacinação :syringe:

### :page_with_curl: Explicando :page_with_curl:
Fiz essa pequena aplicação para exercitar os conceitos dados em aula.
Nessa semana foi proposto que fizessemos um crud com JDBC.
Então preferi criar um projeto diferente. Essa aplicação 
faz o registro da aplicação de vacina em pessoas que já possuem 
um cadastro.

Para não ficar algo monotono decidi fazer um pequeno menu interejativo.
Escolhendo as opções exibidas no console, podemos fazer as
operações de CRUD prosposta na ativiade.

Também achei interessante colocar algumas regras de negócio, como:
* Um email só pode está vinculado a um cadastro
* Um CPF só pode está vinculado a um cadastro

Em outras palavras, o Email e CPF devem ser únicos.

### Banco de dados:

![tabelas_db](https://user-images.githubusercontent.com/45303056/123497442-f0e94f00-d603-11eb-86d0-14e277c288f7.PNG)

Fiz uma relação entre a *tb_vacina* e *tb_usuario*, onde a *tb_vacina* tem um usuario.

### SQL:

Comando de criação do banco:

```bash 
CREATE DATABASE vacinacao_db
```

Comando de criação da tabela *usuario*:
``` 
CREATE TABLE tb_usuario (
	id serial NOT NULL,
	nome_usuario varchar NOT NULL,
	email varchar NOT NULL,
	cpf varchar NOT NULL,
	telefone varchar NOT NULL,
	data_nascimento date NOT NULL,
	CONSTRAINT unique_id_usuario UNIQUE (id)
);
```

Comando de criação da tabela *vacina*:
``` 
CREATE TABLE tb_vacina (
	id_vacina serial NOT NULL,
	nome_vacina varchar NOT NULL,
	data_aplicacao date NOT NULL,
	id_usuario serial NOT NULL,
	CONSTRAINT tb_vacina_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);
``` 
Comando de inserção de registros na tabela *usuario*:
```
INSERT INTO tb_usuario (nome_usuario,email,cpf,telefone,data_nascimento)
	VALUES ('Juliana Rayssa dos Santos','julianarayssadossantos-82@bol.co.br','11953865402','96985468365','1978-10-26');
INSERT INTO tb_usuario (nome_usuario,email,cpf,telefone,data_nascimento)
	VALUES ('Pietra Heloisa Campos','pietraheloisacampos_@mixfmmanaus.com.br','98535371923','64997446982','1942-06-07');
INSERT INTO tb_usuario (nome_usuario,email,cpf,telefone,data_nascimento)
	VALUES ('Lorena Manuela Andrea Galvão','lorenamanuelaandreagalvao_@studiodeideias.com','13857555718','6328695240','1965-05-19');
INSERT INTO tb_usuario (nome_usuario,email,cpf,telefone,data_nascimento)
	VALUES ('Gabriel Tomás Sebastião da Paz','gabrieltomassebastiaodapaz@truckeixo.com.br','90321941276','6328112846','1964-07-07');
INSERT INTO tb_usuario (nome_usuario,email,cpf,telefone,data_nascimento)
	VALUES ('Heloise Aurora Moreira','heloiseauroramoreira-97@lctour.com.br','00391571990','8425632114','1961-07-27');
```

Comando de inserção de registros na tabela *vacina*:
```
INSERT INTO tb_vacina (nome_vacina,data_aplicacao,id_usuario)
	VALUES ('CoronaVac','2021-04-19',1);
INSERT INTO public.tb_vacina (nome_vacina,data_aplicacao,id_usuario)
	VALUES ('Pólio','1995-05-16',5);
INSERT INTO public.tb_vacina (nome_vacina,data_aplicacao,id_usuario)
	VALUES ('Catapora','2000-03-25',3);
INSERT INTO public.tb_vacina (nome_vacina,data_aplicacao,id_usuario)
	VALUES ('Gripe','2002-04-28',4);
INSERT INTO public.tb_vacina (nome_vacina,data_aplicacao,id_usuario)
	VALUES ('Varíola','2017-06-14',2);
```

### :page_with_curl: Executando a aplicação :page_with_curl:
Com o banco de dados criado, e com a aplicação iniciada, temos o primeiro menu:

![menu1](https://user-images.githubusercontent.com/45303056/123499795-9524c300-d60f-11eb-8fc0-1d24ed59a640.png)

Escolhendo a opção 1 somos direcionados para o sub menu de gerenciamento de pessoas:

![menu2](https://user-images.githubusercontent.com/45303056/123500087-c900e800-d611-11eb-9276-2b8aa0cd127b.png)

Nesse menu é possivel fazer as seguintes operações:
* Cadastrar uma nova pessoa
* Alterar dados de uma pessoa informando o CPF
* Excluir um cadastro de uma pessoa pelo CPF
* Listar todos os cadastros de pessoas
* Pesquisar cadastro pelo CPF

Escolhendo a opção 2 do menu principal somos direcionados para o sub menu de gerencimaneto de vacinas:

![menu3](https://user-images.githubusercontent.com/45303056/123500268-45e09180-d613-11eb-89c5-59a2567559e3.png)

Nesse menu é possível fazer as seguintes operações:
* Registrar a aplicação de uma vacina
* Gerar relatorio das aplicações de vacina, também é possivel salvar o relatorio

Por enquanto para poder salvar o relatorio será necessário alterar o path do arquivo em *service/VacinaService*
```
final String path = "CAMINHO DE ONDE O PROJETO FOI BAIXADO ATÉ A PASTA RELATORIOS \relatorios";
```
