<br>
<h1 align="center">
🚀SWAPI-DEV CHALLENGE ✨
</h1>
<br>

## 💬 Sobre o repositório

A SWAPI é uma api (open-source) que disponibiliza várias informações do universo de StarWars. 
Este repositório consome esta api e persiste os dados em memória, possibilitando a sua listagem e alteração os dados.

Esta aplicação possui 3 serviços, dentre eles:
* Lista de todos os filmes com as suas devidas versões;
* Recupera um filme específico e detalhado;
* Edita a mensagem de abertura de um filme específico;

## ⚠ Pré-requisitos para execução do projeto

* Java 11 ou versões superiores
* Maven
* IDE ( INTELLIJ / ECLIPSE)

## 🛠 Tecnologias Utilizadas? 

* Java 11
* Spring Framework :
  1. Spring Data JPA
  2. Spring Web MVC
* Lombok
* H2 database

## 📌 Como utilizar?

Por ser tratar de um projeto Spring, só é necessário clonar este repositorio e possuir a versão Java 11 ou superior na sua IDE.

## 📲 Serviços disponíveis para testes

### Listar todos os filmes
```
Method: GET
URL: http://localhost:8080/api/v1/films
Body: no body required
```

### Detalhar um filme específico
```
Method: GET
URL: http://localhost:8080/api/v1/films/{id}, onde {id} é o id do filme.
Body: no body required
```

### Alterar OpeningCrawl de um filme
```
Method: PUT
URL: http://localhost:8080/api/films/{id}, onde {id} é o id do filme.
Body (json):
{
    "openingCrawl": "INSIRA AQUI NOVO OPENINCRAWL"
}
```

Para conferir se os serviços estão funcionando, utilize uma ferramenta para testes de API Clients, como o Postman, [saiba mais sobre!](https://medium.com/@thi_carva/testando-servi%C3%A7os-web-api-com-postman-874ac81b20a3)

## 🧠 Links importantes

* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Palheta de atalhos de comandos do IntelliJ](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr para setup do projeto](https://start.spring.io/)
* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)

---