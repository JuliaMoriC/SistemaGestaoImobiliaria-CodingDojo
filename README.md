# Sistema de Gestão Imobiliária — Coding Dojo

Projeto baseado no roteiro da atividade. São duas aplicações Java/Spring Boot independentes:

- **Frontend (8080):** Spring Boot + Thymeleaf + Bootstrap.
- **Backend (8081):** Spring Boot + Spring Web + Spring Data JPA + H2.
- **Comunicação:** HTTP/JSON pela API REST. O frontend não acessa o banco diretamente.

## Requisitos
- JDK 17 ou superior
- Maven 3.6+ (ou usar o Maven Wrapper, se adicionado pelo ambiente)
- Internet para carregar o CSS do Bootstrap via CDN

## Como executar

Abra dois terminais na pasta do projeto.

### 1. Iniciar o backend
```bash
cd backend
mvn spring-boot:run
```
Backend: http://localhost:8081  
Console H2: http://localhost:8081/h2-console

Dados para o H2:
- JDBC URL: `jdbc:h2:mem:imobiliaria`
- User Name: `sa`
- Password: (deixar em branco)

### 2. Iniciar o frontend
Em outro terminal:
```bash
cd frontend
mvn spring-boot:run
```
Acesse: http://localhost:8080

**Importante:** inicie o backend antes do frontend. O banco H2 está configurado em memória; os dados são perdidos quando o backend é encerrado.

## API REST

| Método | Endpoint | Função |
|---|---|---|
| GET | `/api/imoveis` | Lista todos os imóveis |
| POST | `/api/imoveis` | Cadastra um imóvel |

Exemplo de JSON para POST:
```json
{
  "descricao": "Casa com 2 quartos",
  "endereco": "Rua das Flores, 123",
  "tipo": "Casa",
  "valor": 250000.00,
  "disponivel": true
}
```

Teste a API:
```bash
curl http://localhost:8081/api/imoveis
```

## Estrutura
```text
SistemaGestaoImobiliaria/
├── backend/
│   ├── pom.xml
│   └── src/main/
│       ├── java/br/com/imobiliaria/backend/
│       │   ├── controller/ImovelController.java
│       │   ├── model/Imovel.java
│       │   ├── repository/ImovelRepository.java
│       │   ├── service/ImovelService.java
│       │   └── ImobiliariaBackendApplication.java
│       └── resources/application.properties
├── frontend/
│   ├── pom.xml
│   └── src/main/
│       ├── java/br/com/imobiliaria/frontend/
│       │   ├── controller/PaginaController.java
│       │   ├── model/Imovel.java
│       │   ├── service/ImovelApiClient.java
│       │   └── ImobiliariaFrontendApplication.java
│       └── resources/
│           ├── application.properties
│           └── templates/index.html
└── README.md
```

## Roteiro rápido para apresentação
1. Mostrar que existem dois projetos Spring Boot independentes.
2. Iniciar o backend na porta 8081 e explicar as camadas Controller, Service e Repository.
3. Mostrar a entidade `Imovel` e o banco H2.
4. Iniciar o frontend na porta 8080 e abrir a tela no navegador.
5. Cadastrar um imóvel e mostrar a mensagem de sucesso.
6. Conferir o imóvel na tabela e consultar `GET /api/imoveis` para demonstrar a API REST.
7. Explicar que o frontend faz uma requisição HTTP ao backend; somente o backend conversa com o H2.

## Observação sobre o Coding Dojo
O roteiro define três papéis: Piloto (programa, executa e testa), Copiloto 1 (discute a lógica) e Copiloto 2 (consulta a IA e avalia as sugestões). Façam o rodízio entre os integrantes durante a implementação.
