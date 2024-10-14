# API de Adoção de Animais

Este projeto é uma API desenvolvida em Java com Spring Boot para a gestão de adoção de animais. A aplicação oferece endpoints para gerenciar informações sobre animais disponíveis para adoção, adotantes e outras operações relacionadas.

## Tutorial

Você pode ver um passo a passo de como foi construído [aqui](https://joserodriguesjr.com/posts/api-using-spring-data-rest/)

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Spring Data REST**
- **PostgreSQL**
- **Docker**

## Como Executar o Projeto

Necessário ter Docker instalado.

### Passos para Executar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/joserodriguesjr/animal-adoption.git
   cd animal-adoption
   ```

2. **Suba os containers**

   ```bash
    docker compose up --build
    ```
   
3. **Acesse o Swagger**

   Você terá acesso aos endpoints na rota _http://localhost:8080/swagger-ui/index.html_
