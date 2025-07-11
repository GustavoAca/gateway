# Projeto API Gateway

Este projeto implementa um API Gateway usando Spring Cloud Gateway. Ele atua como um ponto de entrada único para um
ecossistema de microserviços, centralizando a autenticação, o roteamento e outras preocupações transversais.

## Principais Funcionalidades

- **Roteamento Dinâmico**: Utiliza o Spring Cloud Discovery Client (com Eureka) para encontrar e rotear dinamicamente o
  tráfego para os serviços registrados.
- **Segurança Centralizada**: Protege os endpoints utilizando Spring Security e OAuth2 Resource Server, validando tokens
  JWT em cada requisição.
- **Balanceamento de Carga**: Integra-se com o Spring Cloud Load Balancer para distribuir as requisições entre as
  instâncias dos microserviços.
- **Monitoramento e Rastreabilidade**: Expõe métricas através do Spring Boot Actuator e está configurado para
  rastreamento distribuído com Micrometer e Zipkin.
- **Logging Estruturado**: Utiliza Logback com Logstash Encoder para gerar logs em formato JSON, facilitando a coleta e
  análise centralizada.
- **Filtros Customizados**: Implementa filtros para adicionar headers customizados às requisições, como chaves de API
  para comunicação interna.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Cloud Gateway**
- **Spring Security (OAuth2 Resource Server)**
- **Netflix Eureka (Discovery Client)**
- **Maven** (Gerenciador de dependências)
- **Lombok**
- **Micrometer Tracing** (para Zipkin)
- **Logstash Logback Encoder**

## Configuração

O arquivo de configuração principal é o `src/main/resources/application.yml`. Ele está dividido em perfis:

- **dev**: Perfil de desenvolvimento. Conecta-se a serviços locais (Eureka, Zipkin, Logstash) em `localhost`.
- **prod**: Perfil de produção. As configurações (URLs de serviços, chaves de API) são fornecidas através de variáveis
  de ambiente para maior segurança e flexibilidade.

**Principais Propriedades:**

- `server.port`: A porta padrão da aplicação é `8192`.
- `server.servlet.context-path`: O contexto base é `/gateway`.
- `eureka.client.service-url.defaultZone`: URL do servidor Eureka para registro e descoberta de serviços.
- `management.tracing.exporter.zipkin.url`: URL do Zipkin para exportar dados de rastreamento.
- `jwt.public.key`: Chave pública usada para validar a assinatura dos tokens JWT.

## Como Executar

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.x
- Um servidor Eureka em execução.
- (Opcional) Um servidor Zipkin e uma instância de Logstash para aproveitar o monitoramento e logging.

### Executando Localmente

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd gateway
   ```

2. **Execute a aplicação com o perfil `dev`:**

   O projeto utiliza o Maven Wrapper, então não é necessário ter o Maven instalado globalmente.

   ```bash
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
   ```

3. A aplicação estará disponível em `http://localhost:8192/gateway`.

## Rotas da API

As rotas são configuradas de duas maneiras:

1. **Descoberta Automática**: O Gateway descobre automaticamente os serviços registrados no Eureka e cria rotas baseadas
   nos nomes dos serviços (ex: um serviço com `spring.application.name=users-service` será acessível via
   `/gateway/users-service/**`).
2. **Configuração Manual**: Rotas específicas e seus filtros são definidos na classe `GatewayRoutesConfig.java`.

## Segurança

O Gateway atua como um "Resource Server". Todas as requisições para rotas protegidas devem conter um token JWT válido no
cabeçalho de autorização:

`Authorization: Bearer <seu-token-jwt>`

O Gateway valida o token usando a chave pública configurada no `application.yml` antes de encaminhar a requisição para o
microserviço correspondente.
