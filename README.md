# 🧮 API Calculadora REST - Spring Boot

Uma API REST simples e eficiente desenvolvida em **Java** com **Spring Boot** para realizar operações matemáticas básicas. 

Este projeto foi construído com foco em boas práticas de engenharia de software, separação de responsabilidades (Controller/Service) e serve como base para estudos práticos de **Testes Automatizados**.

## 🚀 Tecnologias Utilizadas

* **Java 17** (ou superior)
* **Spring Boot** (Web)
* **Maven** (Gerenciamento de dependências)
* **JUnit 5 / Mockito** (Para testes automatizados)
* **JaCoCo** (Relatórios de cobertura de código)

---

## 🛠️ Documentação da API (Endpoints)

A API possui uma rota base: `/calculadora`. Todos os parâmetros (`numerox` e `numeroy`) são passados diretamente na URL (Path Variables).

### 1. Somar
Realiza a adição entre dois números inteiros.
* **Método:** `GET`
* **Rota:** `/calculadora/somar/{numerox}/{numeroy}`
* **Exemplo de Requisição:** `http://localhost:8080/calculadora/somar/10/5`
* **Retorno (200 OK):** `15`

### 2. Subtrair
Realiza a subtração do primeiro número pelo segundo.
* **Método:** `GET`
* **Rota:** `/calculadora/subtrair/{numerox}/{numeroy}`
* **Exemplo de Requisição:** `http://localhost:8080/calculadora/subtrair/10/5`
* **Retorno (200 OK):** `5`

### 3. Multiplicar
Realiza a multiplicação entre dois números inteiros.
* **Método:** `GET`
* **Rota:** `/calculadora/multiplicar/{numerox}/{numeroy}`
* **Exemplo de Requisição:** `http://localhost:8080/calculadora/multiplicar/10/5`
* **Retorno (200 OK):** `50`

### 4. Dividir
Realiza a divisão do primeiro número pelo segundo. Retorna um número decimal (`Double`).
* **Método:** `GET`
* **Rota:** `/calculadora/dividir/{numerox}/{numeroy}`
* **Exemplo de Requisição:** `http://localhost:8080/calculadora/dividir/10/5`
* **Retorno (200 OK):** `2.0`
> **Nota:** É recomendado o tratamento de exceções (como divisão por zero) na camada de serviço (`CalculadoraService`).

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. **Navegue até a pasta do projeto:**
   ```bash
   cd seu-repositorio
   ```
3. **Execute a aplicação via Maven:**
   ```bash
   mvn spring-boot:run
   ```
4. **Acesse no navegador ou Postman/Insomnia:**
   A aplicação estará rodando na porta padrão `8080`.
   `http://localhost:8080/calculadora/somar/5/5`

---

## 🧪 Rodando os Testes e Cobertura

Como este projeto tem foco em testes automatizados, você pode rodar a suíte de testes e gerar o relatório de cobertura do **JaCoCo** com o seguinte comando:

```bash
mvn clean test jacoco:report
```

Os relatórios de cobertura em HTML estarão disponíveis no diretório: 
`target/site/jacoco/index.html`
## Backend da aula JWT com PostgreSQL

O login procura os usuários na tabela `usuarios`. O Flyway cria a tabela e inclui um usuário para a aula na primeira inicialização.

### Iniciar o banco

Abra o Docker Desktop e, na pasta do projeto, execute

```bash
docker compose up -d
```

Para conferir se o banco iniciou

```bash
docker compose ps
```

### Iniciar a API

```bash
bash mvnw spring-boot:run
```

A API inicia na porta `8080` por padrão. Para usar a porta `8081` no frontend

```bash
bash mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

Credenciais da aula

- Login `admin`
- Senha `AulaJwt123!`

O PostgreSQL usa o banco `aula_jwt`, usuário `aula` e senha `aula123` para desenvolvimento local. Os valores podem ser sobrescritos com `DB_URL`, `DB_USER` e `DB_PASSWORD`.

O volume `postgres-data` mantém os dados entre reinícios do container. Para apagar o banco e recriá-lo do zero, execute `docker compose down -v`.

A migration inicial está em `src/main/resources/db/migration`. Hibernate valida o esquema criado pelo Flyway e não altera tabelas automaticamente.
