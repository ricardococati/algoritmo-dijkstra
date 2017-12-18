### Algoritmo Dijkstra 

#### Objetivo
Expor o serviço do Algoritmo de Dijkstra para calcular a menor rota entre pontos de um grafo.

#### Ferramentas e Tecnologias

* [Maven](https://maven.apache.org/)
* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Swagger](https://swagger.io/)
* [IntelliJ](https://www.jetbrains.com/idea/)
* [Java 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

#### Passos para execução do serviço

* Pré-requisitos: Possuir uma máquina com o Java 1.8 configurado e o Maven(3.3 ou superior) para build da aplicação.

Executar os seguintes comandos:

```
mvn clean install -U
```
Após a instalação no ambiente local, executar o Spring Boot.

```
mvn spring-boot:run
```
Após start do Spring Boot, acessar a URL http://localhost:8880/swagger-ui.html

Massa de dados para teste:

```json

	A, D

```
