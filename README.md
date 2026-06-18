# WW2 Aircraft Display - API REST

## 📋 Descrição do Projeto

**WW2 Aircraft Display** é uma API REST desenvolvida em **Spring Boot** que fornece um serviço de catálogo de aeronaves da Segunda Guerra Mundial. O projeto permite gerenciar uma base de dados completa com informações detalhadas sobre mais de 40 aeronaves de diferentes nações, incluindo caças, bombardeiros, aviões de ataque e torpedeiros.

A API oferece funcionalidades CRUD (Create, Read, Update, Delete) completas para gerenciar aeronaves, com filtros por nação e acesso a informações como velocidade máxima, alcance de voo, armamento, tamanho da tripulação e período de serviço.

## 🚀 Pré-requisitos

Antes de iniciar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven 3.6+**
- **Docker** e **Docker Compose** (para banco de dados PostgreSQL)
- **Git** (opcional, para clonar o repositório)

## 🔧 Instalação e Configuração

### 1. Clone o Repositório
```bash
git clone https://github.com/seu-usuario/sdev-srv-ww2-aircraft-display.git
cd sdev-srv-ww2-aircraft-display
```

### 2. Configure o Banco de Dados

O projeto utiliza **PostgreSQL** em um contêiner Docker. Inicie o banco de dados executando:

```bash
docker-compose up -d
```

Este comando criará um contêiner PostgreSQL com as seguintes credenciais:
- **Host**: localhost
- **Porta**: 5432
- **Database**: aircraft-db
- **Username**: postgres
- **Password**: postgres

### 3. Instale as Dependências Maven

```bash
mvn clean install
```

### 4. Compile o Projeto

```bash
mvn compile
```

## ▶️ Como Executar

### Opção 1: Executar via Maven
```bash
mvn spring-boot:run
```

### Opção 2: Executar a partir do JAR compilado
```bash
java -jar target/any-project-for-any-propouses-0.0.1-SNAPSHOT.jar
```

A aplicação iniciará em: **http://localhost:8080**

### Opção 3: Executar no IDE (IntelliJ IDEA, Eclipse, VS Code)
1. Abra o projeto no seu IDE preferido
2. Clique com botão direito em `AnyProjectForAnyPropousesApplication.java`
3. Selecione "Run" ou "Execute"

## 📡 Endpoints da API

### Base URL
```
http://localhost:8080/api/v1/catalog
```

### 1. **Listar Todas as Aeronaves**
```http
GET /api/v1/catalog/list
```
**Resposta**: `200 OK`
```json
[
  {
    "id": 191,
    "name": "P-51D Mustang",
    "nation": "USA",
    "aircraftType": "FIGHTER",
    "manufacturer": "North American Aviation",
    "firstFlight": "26/10/1940",
    "maxSpeed": 703.0,
    "flyingRange": 2655,
    "armament": "6x 12.7mm M2 Browning machine guns, bombs, rockets",
    "crewSize": 1,
    "serviceStart": 1942,
    "serviceEnd": 1984
  }
]
```

### 2. **Listar Aeronaves por Nação**
```http
GET /api/v1/catalog/list/{nation}
```
**Parâmetros**:
- `nation` (path): Nação (USA, UK, GERMANY, USSR, JAPAN, ITALY, FRANCE)

**Exemplo**:
```http
GET /api/v1/catalog/list/USA
```

**Resposta**: `200 OK` - Lista de aeronaves da nação especificada

### 3. **Obter Aeronave por ID**
```http
GET /api/v1/catalog/{id}
```
**Parâmetros**:
- `id` (path): ID da aeronave

**Exemplo**:
```http
GET /api/v1/catalog/191
```

**Resposta**: `200 OK`
```json
{
  "id": 191,
  "name": "P-51D Mustang",
  "nation": "USA",
  "aircraftType": "FIGHTER",
  ...
}
```

### 4. **Criar Nova Aeronave**
```http
POST /api/v1/catalog/save
```
**Body** (JSON):
```json
{
  "name": "Supermarine Spitfire",
  "nation": "UK",
  "aircraftType": "FIGHTER",
  "manufacturer": "Supermarine",
  "firstFlight": "05/03/1936",
  "maxSpeed": 656.0,
  "flyingRange": 698,
  "armament": "2x 20mm Hispano cannons, 4x .303 machine guns",
  "crewSize": 1,
  "serviceStart": 1938,
  "serviceEnd": 1961
}
```

**Resposta**: `201 Created`

### 5. **Atualizar Aeronave**
```http
PUT /api/v1/catalog/change/{id}
```
**Parâmetros**:
- `id` (path): ID da aeronave

**Body** (JSON): Mesma estrutura do POST

**Resposta**: `200 OK` - Aeronave atualizada

### 6. **Deletar Aeronave**
```http
DELETE /api/v1/catalog/delete/{id}
```
**Parâmetros**:
- `id` (path): ID da aeronave

**Resposta**: `204 No Content` (sucesso) ou `404 Not Found` (se não existir)

## 📊 Estrutura do Projeto

```
sdev-srv-ww2-aircraft-display/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── AnyProjectForAnyPropousesApplication.java    # Classe principal (Spring Boot)
│   │   │   ├── controller/
│   │   │   │   └── AircraftController.java                   # Endpoints REST
│   │   │   ├── domain/
│   │   │   │   ├── Aircraft.java                             # Entidade JPA
│   │   │   │   └── enums/
│   │   │   │       ├── AircraftType.java                     # Tipos de aeronave
│   │   │   │       └── Nation.java                           # Nações
│   │   │   ├── dto/
│   │   │   │   └── AircraftDto.java                          # Data Transfer Object
│   │   │   ├── exception/
│   │   │   │   ├── AircraftNotFoundException.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │   ├── mapper/
│   │   │   │   └── AircraftMapper.java                       # Mapeamento de objetos
│   │   │   ├── repositories/
│   │   │   │   └── AircraftRepository.java                   # Acesso a dados (JPA)
│   │   │   ├── request/
│   │   │   │   └── AircraftRequest.java                      # Request DTO
│   │   │   └── service/
│   │   │       └── AircraftService.java                      # Lógica de negócio
│   │   └── resources/
│   │       ├── application.yml                               # Configurações da aplicação
│   │       └── base.json                                     # Dados iniciais de aeronaves
│   └── test/
│       └── java/com/example/demo/
│           └── AnyProjectForAnyPropousesApplicationTests.java
├── pom.xml                                                   # Dependências Maven
├── docker-compose.yml                                        # Configuração do PostgreSQL
├── mvnw e mvnw.cmd                                          # Maven Wrapper
└── target/                                                   # Arquivos compilados
```

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Spring Boot** | 3.4.3 | Framework para desenvolvimento de APIs REST |
| **Spring Data JPA** | 3.4.3 | ORM para persistência de dados |
| **PostgreSQL** | 16 | Banco de dados relacional |
| **Lombok** | 1.18.36 | Redução de boilerplate em Java |
| **Maven** | 3.8.1 | Gerenciador de dependências |
| **Java** | 17 | Linguagem de programação |
| **Docker** | - | Containerização da aplicação |

## 📋 Enums do Projeto

### AircraftType (Tipos de Aeronave)
- `FIGHTER` - Caça
- `BOMBER` - Bombardeiro
- `DIVE_BOMBER` - Bombardeiro de mergulho
- `TORPEDO_BOMBER` - Bombardeiro torpedeiro
- `ATTACK` - Avião de ataque
- `MULTIROLE` - Multirole
- `JET_FIGHTER` - Caça a jato

### Nation (Nações)
- `USA` - Estados Unidos
- `UK` - Reino Unido
- `GERMANY` - Alemanha
- `USSR` - União Soviética
- `JAPAN` - Japão
- `ITALY` - Itália
- `FRANCE` - França

## 📁 Dados de Exemplo

O projeto inclui um arquivo `base.json` com mais de 40 aeronaves de diferentes nações, tipos e períodos. Os dados podem ser carregados inicialmente no banco de dados através de um script de inicialização (em desenvolvimento).

**Exemplo de dados inclusos**:
- **USA**: P-51D Mustang, P-47D Thunderbolt, F4U Corsair, B-17 Flying Fortress, B-29 Superfortress
- **UK**: Supermarine Spitfire, Hawker Hurricane, De Havilland Mosquito, Avro Lancaster
- **Alemanha**: Messerschmitt Bf 109, Focke-Wulf Fw 190, Messerschmitt Me 262, Junkers Ju 87 Stuka
- **USSR**: Yak-3, Yak-9, Lavochkin La-5FN, Ilyushin Il-2 Sturmovik
- **Japão**: Mitsubishi A6M Zero, Nakajima Ki-84, Kawasaki Ki-61
- **Itália**: Macchi C.205, Fiat G.55
- **França**: Dewoitine D.520, Bloch MB.152

## 🔐 Configurações de Segurança

Atualmente, o projeto **não possui mecanismos de autenticação/autorização**. Para produção, recomenda-se implementar:

- Spring Security
- JWT (JSON Web Tokens)
- OAuth2
- CORS (Cross-Origin Resource Sharing)

## 🐛 Melhorias Futuras

- [ ] Implementar autenticação e autorização com Spring Security
- [ ] Adicionar JWT para segurança dos endpoints
- [ ] Implementar paginação na listagem de aeronaves
- [ ] Adicionar filtros avançados (por tipo, velocidade, alcance, etc.)
- [ ] Criar documentação Swagger/OpenAPI
- [ ] Implementar cache com Redis
- [ ] Adicionar validações mais robustas com Bean Validation
- [ ] Criar testes unitários e de integração completos
- [ ] Implementar logging estruturado com SLF4J
- [ ] Adicionar tratamento de exceções global com @ControllerAdvice
- [ ] Configurar CORS para integração com frontend

## 📝 Notas Importantes

1. **DDL Auto**: O Hibernate está configurado com `ddl-auto: update`, o que significa que as tabelas serão criadas automaticamente na primeira execução.

2. **JSON em Base.json**: O arquivo `base.json` contém dados históricos de aeronaves reais da Segunda Guerra Mundial.

3. **Estrutura de Nomes**: O projeto usa uma estrutura genérica de nomes (`AnyProjectForAnyPropouses`) mas é especializado em aeronaves WW2.

4. **Conexão com Banco**: As credenciais padrão do PostgreSQL são:
   - Username: `postgres`
   - Password: `postgres`
   - Database: `aircraft-db`

## 🤝 Contribuindo

Para contribuir com melhorias:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto é fornecido como está para fins educacionais e de demonstração.

## 📞 Suporte

Para dúvidas ou problemas:
- Verifique se o PostgreSQL está rodando: `docker ps`
- Confirme se a porta 8080 está disponível
- Verifique os logs da aplicação para mais detalhes dos erros

## 📚 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL Docker Image](https://hub.docker.com/_/postgres)
- [Lombok Documentation](https://projectlombok.org/)

---

**Última atualização**: Junho de 2026

**Versão do Projeto**: 0.0.1-SNAPSHOT

