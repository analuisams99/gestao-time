# Sistema de Gerenciamento de Times (ORM - Hibernate)

    Este projeto foi realizado com o objetivo de aprimorar o conhecimento em 
    Hibernate (ORM) na linguagem Java.

## :zap: Descrição

 Sistema que faz a gestão de times esportivos.
 
 Minha tarefa nesta demanda foi construir um sistema, utilizando o framework hibernate, em que foi possível realizar operações de CRUD (CREATE, READ, UPDATE, DELETE) para todas as entidades listadas, conforme a especificação abaixo.
 
#### 🟡 Para isso:

  1. Analisei o relacionamento entre as entidades, com base nela escolhi as anotações do hibernate necessárias:

```java
@OnetoOne
@OneToMany
@ManyToOne
@ManyToMany
```

  2. Criei todas as classes Data Access Object (DAO)
  3. Criei todas as classes Entity
  
### :pushpin: Boas práticas
  1. Como boa prática, fiz camadas diferentes para responsabilidade. Por exemplo, utilizei um pacote chamado dao para as classes que representem o Data Access Object.
  2. Utilizei o conceito de Herança para implementar as classes de Data Access Object.
 

### 🔸 Diagrama de entidade relacionamento
 
 Para auxiliar a elaboração do sistema, foi elaborado um diagrama de entidade relacionamento, exposto abaixo. 
 
 ![diagrama-relacionamento](https://github.com/analuisams99/gestao-time/blob/main/img/der.png)
 

:pushpin: Os seguintes dados foram armazenados no sistema:
|   Entidade    |   Atributos                                   |
| :-----------: | :------------------------------------------- |
|   Torcedor    | Id, Nome                           |
|     Time      | Id, Nome, Lista de Jogadores, Lista de Torcedores |
|    Jogador    | Id, Nome, Posição, Documento, Time no qual trabalha |
|   Documento   | Id, CPF, Número da Carteira de Trabalho, Número CBF |


-- o Jogador tem um Documento, mas o Documento não tem um Jogador.


## :pushpin: Instalação do projeto em sua máquina
  1. Clone o repositório
   
     `git@github.com:analuisams99/gestao-time.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd gestao-time`
     
  3. Instale as dependências necessárias:
     
     `mvn install`
     
  

## :pushpin: Para testar o projeto
  1. digite o comando no seu terminal
      
      `mvn test`
      
    Os códigos de cobertura de testes, do arquivo src/test/java/com/trybe/acc/java/gestaoTime/CoverageValidationTest.java,
    foram desenvolvidos pela Trybe.
    
---

-- Projeto desenvolvido por Ana Luisa Marques Simões, para fins didáticos. 2023

