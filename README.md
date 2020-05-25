# Projeto Challenge


## Dependências do Projeto

* Maven 3.6.3 

* Java 11

## Como Executar

Com o Maven e o Java instalados e devidamente configurados, abra o terminal e vá até o diretório raiz do projeto, em seguida, execute o comando para fazer o build do projeto: 

``` 
mvn clean install
```

Após a finalização do build, execute o comando para subir o servidor:
```  
java -jar target/challenge-0.0.1-SNAPSHOT.jar
``` 

A aplicação estará em execução em: [localhost:8080/](localhost:8080/) 

## Informações Técnicas

* Servidor de aplicação : Tomcat (embarcado)
* Banco de dados: H2 (em memória)

