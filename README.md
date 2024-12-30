# Sistema de CRUD da Biblioteca 📚

## Visão Geral
Este repositório demonstra a evolução de um Sistema de Gerenciamento de Biblioteca desenvolvido em Java. O sistema é implementado em três versões distintas, cada uma destacando diferentes técnicas e tecnologias de programação para criar uma aplicação CRUD. O objetivo é demonstrar uma progressão passo a passo, do básico ao avançado, no tratamento de dados em uma aplicação Java.

## Versões

### Versão 1: Arrays para Armazenamento de Dados 🧮
Nesta versão, o aplicativo utiliza arrays para armazenar e gerenciar os dados. 

#### Principais Funcionalidades
- Os dados são armazenados em arrays simples do Java.
- Operações CRUD implementadas manualmente.
- Foco no entendimento de conceitos básicos do Java, como loops e arrays.

#### Pontos Fortes
- Fornece uma base sólida para compreender como as estruturas de dados funcionam.
- Incentiva o uso eficiente da memória e o design de algoritmos.

#### Lições Aprendidas
- A implementação manual de operações como busca, adição e remoção é suscetível a erros e consome tempo.

---

### Versão 2: Framework de Coleções 🗂️
Esta versão faz a transição para o uso do Framework de Coleções do Java para gerenciamento de dados.

#### Principais Funcionalidades
- Os dados são armazenados em estruturas dinâmicas como  `HashMap`, etc.
- Operações CRUD melhoradas com métodos embutidos da API de Coleções.
- Desempenho e legibilidade do código aprimorados.

#### Pontos Fortes
- As coleções oferecem redimensionamento dinâmico, tornando o sistema mais flexível.
- Simplifica a implementação de manipulações complexas de dados.

#### Lições Aprendidas
- Compreensão de como as coleções funcionam internamente (ex.: redimensionamento, hashing).
- Importância de escolher o tipo de coleção adequado para casos de uso específicos.

---

### Versão 3: JDBC com MySQL 🛢️
A versão final integra o aplicativo com um banco de dados MySQL utilizando o Java Database Connectivity (JDBC).

#### Principais Funcionalidades
- Armazenamento persistente de dados usando MySQL.
- Operações CRUD executadas por meio de consultas SQL.
- Implementação do padrão Command para funções como cadastro, emprestimo e devolução de livros.
- Introdução a conceitos de banco de dados, como design de esquemas, normalização e indexação.

#### Pontos Fortes
- Os dados persistem além do ciclo de vida do aplicativo.
- Permite lidar eficientemente com grandes volumes de dados.
- Separa a lógica de negócios do gerenciamento de dados.

#### Lições Aprendidas
- Importância do design e da otimização de bancos de dados.
- Escrita de consultas SQL seguras e eficientes.
- Tratamento de erros e depuração em aplicações conectadas a bancos de dados.

---

## Requisitos ✅
- **Java Development Kit (JDK)**: Versão 8 ou superior.
- **Banco de Dados MySQL**: Certifique-se de ter uma instância MySQL em execução.
- **IDE**: IntelliJ IDEA, Eclipse ou qualquer IDE compatível com Java.
- **Maven**: Para gerenciamento de dependências (opcional).

## Executando o Projeto 🚀
1. Clone o repositório:
   ```bash
   git clone https://github.com/MTR-S/java-crud-biblioteca
   ```
2. Navegue até o diretório da versão desejada:
   ```bash
   cd src/main/java/bibliotecaV1 # Para a Versão 1
   cd src/main/java/bibliotecaV2  # Para a Versão 2
   cd src/main/java/bibliotecaV3  # Para a Versão 3
   ```
3. Compile e execute o aplicativo:
   ```bash
   javac Main.java
   java Main
   ```
4. Para a Versão 3, certifique-se de que o banco de dados esteja configurado:
   - Configure as credenciais do banco de dados no arquivo de propriedades do aplicativo.

