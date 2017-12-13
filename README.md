### Algoritmo Dijkstra 

#### Objetivo
Expor o serviço do Algoritmo de Dijkstra para calcular a menor rota entre pontos de um grafo.

#### Tecnologias

* [Maven](https://maven.apache.org/)
* [Spring Boot](https://projects.spring.io/spring-boot/)
* [HSQLDB](http://hsqldb.org/)
* [Java 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

#### Passos para execução do serviço
Pré-requisitos: Possuir uma máquina com o Java 1.8 configurado e o Maven(3.3 ou superior) para build da aplicação.
Executar 
Após start do Spring Boot, acessar a URL http://localhost:8880/swagger-ui.html

Massa de dados para teste:

```json
[
	{"custo": 4,"nodeDestino": "A","nodeOrigem": "D"},
	{"custo": 1,"nodeDestino": "D","nodeOrigem": "E"},
	{"custo": 8,"nodeDestino": "E","nodeOrigem": "C"},
	{"custo": 2,"nodeDestino": "C","nodeOrigem": "B"},
	{"custo": 6,"nodeDestino": "B","nodeOrigem": "A"},
	{"custo": 9,"nodeDestino": "A","nodeOrigem": "C"},
	{"custo": 7,"nodeDestino": "D","nodeOrigem": "F"},
	{"custo": 5,"nodeDestino": "F","nodeOrigem": "C"},
	{"custo": 9,"nodeDestino": "F","nodeOrigem": "E"},
	{"custo": 3,"nodeDestino": "B","nodeOrigem": "D"},
	{"custo": 3,"nodeDestino": "F","nodeOrigem": "A"}
]
```
