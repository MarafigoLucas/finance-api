Finance Manager API 💰
Uma API REST robusta para gerenciamento de finanças pessoais, desenvolvida com Java e Spring Boot. O projeto foca em boas práticas de arquitetura, segurança avançada e alta performance.

🚀 Tecnologias
Java 21

Spring Boot 3

Spring Security (Autenticação Stateless com JWT)

JWT (Auth0) para geração e validação de tokens

Hibernate/JPA para persistência de dados

H2 Database (Perfil de teste)

Lombok para redução de boilerplate

Swagger/OpenAPI para documentação interativa

🔒 Segurança e Autenticação
A API utiliza um modelo de segurança Stateless. As senhas dos usuários são protegidas utilizando o algoritmo de hash BCrypt antes de serem persistidas no banco de dados.

Fluxo de Autenticação:
O usuário se cadastra via /auth/register.

O usuário realiza o login via /auth/login e recebe um Token JWT.

O Token deve ser enviado em todas as requisições protegidas através do Header Authorization: Bearer <TOKEN>.

🛠️ Como Executar o Projeto
Clonar o repositório:

Bash
git clone https://github.com/seu-usuario/finance-manager-api.git
Executar a aplicação:
Pela sua IDE (IntelliJ/Eclipse) ou via terminal:

Bash
./mvnw spring-boot:run
Acessar a documentação (Swagger):
Abra o navegador em: http://localhost:8080/swagger-ui.html

📈 Endpoints Principais
Autenticação (/auth)
POST /auth/register - Cadastra um novo usuário.

POST /auth/login - Autentica e retorna o token JWT.

Usuários (/users)
GET /users/{id}/balance - Retorna o saldo total, receitas e despesas de um período.

GET /users - Lista todos os usuários (Requer autenticação).

Transações (/transactions)
POST /transactions - Registra uma nova entrada ou saída.

🏗️ Estrutura de Pacotes
O projeto segue uma arquitetura em camadas para facilitar a manutenção:

com.marafigo.finance.entities: Mapeamento das tabelas do banco.

com.marafigo.finance.dto: Objetos de transferência de dados (Records).

com.marafigo.finance.resources: Controllers (Exposição dos endpoints).

com.marafigo.finance.services: Lógica de negócio.

com.marafigo.finance.infra.security: Configurações de segurança e filtros.