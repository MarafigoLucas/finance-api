# Finance Manager API 💰

Uma API REST robusta para gestão de finanças pessoais, desenvolvida com **Java** e **Spring Boot**. O projeto foca em boas práticas de arquitetura, segurança avançada e alta performance.

## 🚀 Tecnologias
* **Java 21**
* **Spring Boot 3**
* **Spring Security** (Autenticação Stateless com JWT)
* **JWT (Auth0)** para geração e validação de tokens
* **Hibernate/JPA** para persistência de dados
* **H2 Database** (Perfil de teste/desenvolvimento)
* **Lombok** para redução de código boilerplate
* **Swagger/OpenAPI** para documentação interativa

---

## 🔒 Segurança e Autenticação
A API utiliza um modelo de segurança **Stateless**. As passwords dos utilizadores são protegidas utilizando o algoritmo de hash **BCrypt** antes de serem persistidas no banco de dados.

### Fluxo de Autenticação:
1. O utilizador regista-se via `POST /auth/register`.
2. O utilizador realiza o login via `POST /auth/login` e recebe um **Token JWT**.
3. O Token deve ser enviado em todas as requisições protegidas através do Header `Authorization: Bearer <TOKEN>`.

---

## 🛠️ Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/finance-api.git](https://github.com/seu-usuario/finance-api.git)