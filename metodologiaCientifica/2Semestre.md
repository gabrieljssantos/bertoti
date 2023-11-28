# Projeto 2 - 2º semestre
## Empresa parceira: NectoSystem 

<img src="https://user-images.githubusercontent.com/80851038/133914328-794317fa-31e1-4279-afb0-d986acb5db45.png" height="150"/>


###*Figura 11. NectoSystem (Fonte: https://necto.com.br/)*

### Visão do Projeto ![Visão do Projeto](https://img.shields.io/badge/-Visão%20Do%20Projeto-blue)

 O projeto consiste em apresentar para o cliente Necto Systems uma solução para o monitoramento de um ou mais SGBDs remotos, bem como na coleta de métricas de funcionamento dos Banco de Dados presentes nos servidores da empresa. O objetivo foi desenvolver um software integrado que monitore e apresente métricas referentes ao uso e à saúde do SGBD em tempo real, além de oferecer um pós-gerenciamento de múltiplos BDs no servidor como diferencial.

- **Objetivo Geral**:
foi desenvolver um software integrado que monitora e apresenta métricas referentes ao uso e à saúde de SGBDs em tempo real, oferecendo um pós-gerenciamento de múltiplos BDs no servidor.

- **Objetivos Específicos**: Como objetivos específicos, temos:
    - Realizar registros periódicos de métricas (diariamente/hora);
    - Disponibilizar dados coletados em tempo real;
    - Manter um histórico de métricas;
    - Criar relatórios com as métricas e valores limites atingidos durante a operação;
    - Permitir o cadastro de dados de conexão dos SGBDs para acesso a estatísticas por tabela.


## Tecnologias utilizadas ![Tecnologias utilizadas](https://img.shields.io/badge/-Tecnologias%20Utilizadas-blue)


- **PostgreSQL** é um sistema de gerenciamento de banco de dados relacional de código aberto. É utilizado para armazenar os dados coletados e oferecer suporte ao monitoramento dos SGBDs.

- **Java** é uma linguagem de programação amplamente utilizada para desenvolvimento de aplicações. Foi escolhida como linguagem principal para implementação do software de monitoramento.

- **Eclipse** é uma IDE (Integrated Development Environment) utilizada para desenvolvimento de software em diversas linguagens.

- **JDBC** (Java Database Connectivity) é uma API do Java que fornece uma interface para conectar e interagir com bancos de dados relacionais. É utilizado para estabelecer a conexão com o banco de dados PostgreSQL.

- **SQLite** é um sistema de gerenciamento de banco de dados relacional embutido. Foi utilizado neste projeto para armazenar e gerenciar o histórico de métricas coletadas.

- **Microsoft SQL Server** é um SGBD relacional desenvolvido pela Microsoft, utilizado para armazenar e manipular dados de maneira eficiente e segura.



## Contribuições pessoais ![Contribuições pessoais](https://img.shields.io/badge/-Contribui%C3%A7%C3%B5es%20Pessoais-blue)

**Registros Periódicos de Métricas:** Lógica para a coleta e registro automático de métricas em intervalos regulares, permitindo uma análises.

**Histórico de Métricas no Banco de Dados SQLite:** Desenvolvimento da estrutura de armazenamento e consulta das métricas no banco de dados SQLite, permitindo a visualização do histórico de dados coletados ao longo do tempo.


**Cadastro de Dados de Conexão aos SGBDs:** Implementei um sistema de registro e gerenciamento dos dados de conexão aos SGBDs, facilitando o acesso e a análise estatística por tabela dos diferentes bancos de dados utilizados no projeto.

 
<details><summary>Exemplo de código</summary>

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        // Configuração da conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/meu_banco_de_dados";
        String username = "usuario";
        String password = "senha";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Estabelecendo a conexão com o banco de dados
            connection = DriverManager.getConnection(url, username, password);

            // Criando um statement para executar consultas SQL
            statement = connection.createStatement();

            // Executando uma consulta SQL
            String sql = "SELECT * FROM tabela";
            resultSet = statement.executeQuery(sql);

            // Processando o resultado da consulta
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechando os recursos (resultSet, statement e connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
```
</details>



## Aprendizados Efetivos ![Aprendizados efetivos](https://img.shields.io/badge/-Aprendizados%20Efeitvos-blue)

Desenvolvi habilidades técnicas, como:

- Desenvolvimento de aplicativos utilizando Java.
- Conexão e manipulação de bancos de dados relacionais com o uso do JDBC.
- Utilização do Eclipse como ambiente de desenvolvimento integrado.
- Armazenamento e consulta de dados utilizando o PostgreSQL.
- Gerenciamento do histórico de métricas com o SQLite.

Também aprimorei habilidades interpessoais, tais como:

- Trabalho em equipe eficaz, colaborando com sucesso entre os membros do projeto.
- Comunicação clara e eficaz para garantir o entendimento e a implementação correta dos requisitos do projeto.
- Gestão do tempo e priorização de tarefas para cumprir os prazos estabelecidos.
- Resolução de problemas e tomada de decisões, enfrentando desafios técnicos e definindo a melhor abordagem para a implementação das funcionalidades desejadas.
- Flexibilidade e adaptabilidade, lidando com a aprendizagem de novas tecnologias e a capacidade de se adaptar a mudanças nos requisitos do projeto.


