# Trabalho II – Back-end (UNIPAR)

Continuação do Trabalho I: API REST de veículos com Java, Spring Boot, Spring Data JPA e PostgreSQL. **Este repositório contém um único projeto Maven**, com código-fonte na pasta `src`.

## Pré-requisitos
Java compatível com a versão definida em `pom.xml`, Maven (ou Maven Wrapper), PostgreSQL e Postman.

## Banco e configuração
1. Crie o banco executando `sql/criar_banco.sql` no PostgreSQL, se ainda não existir.
2. Configure `src/main/resources/application.properties` com o nome do banco, usuário e senha locais. **Nunca envie sua senha real ao GitHub**.
3. No Windows, execute `mvnw.cmd spring-boot:run` na raiz do projeto.

## Endpoints
- POST `/veiculo/gravar` — cadastra veículo sem informar ID.
- GET `/veiculo/listar-todos` — lista todos.
- GET `/veiculo/listar/{id}` — busca por ID.
- PUT `/veiculo/editar/{id}` — atualiza.
- DELETE `/veiculo/deletar/{id}` — exclui.
- GET `/veiculo/pesquisa?modelo=...&marca=...&ano=...` — três filtros opcionais e combináveis.
- GET `/veiculo/marca?marca=...` e GET `/veiculo/ano?ano=...` — consultas individuais adicionais.

### Exemplo de POST
```json
{"nome":"Meu carro","marca":"Volkswagen","modelo":"Gol","ano":2020}
```

### Teste de persistência
1. Faça POST com o JSON acima no Postman.
2. Anote o ID gerado, reinicie a aplicação e consulte GET `/veiculo/listar/{id}`.
3. No pgAdmin, consulte `SELECT * FROM veiculo ORDER BY id;` (também disponível na pasta `sql`).

**Observação:** execução e comprovação dos testes locais ainda dependem de um PostgreSQL configurado. O Trabalho I permanece em repositório próprio; este repositório é somente o Trabalho II.
