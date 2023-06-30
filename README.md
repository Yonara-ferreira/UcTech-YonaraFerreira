# UcTech-YonaraFerreira

Esse repositório contém os arquivos do sobre o desafio de cadastro de empresas utilizando Java e Spring.<br>O cadastro tem como funcionalidade mostrar os cadastros de Empresa utilizando a ApiBrasil.<br>

<br>Ele foi desenvolvido com as seguintes tecnologias:

 - Back-end: **API REST** com o framework **Spring Boot** 3.1.1 no **Java** 17
 - Front-end: bootstrap 5 e Jquery 3.6
 - Banco de dados **MySql** 8.0.26
 - **Flyway** (migrações do banco de dados)
 - Apache **Maven** (gerenciador de projetos e dependências)

 ### Funcionalidades do software
-  Categorias de empresas
     -  Salvar uma nova empresa passando como argumento o CNPJ da API Brasil.
      - Buscar todas as empresas cadastradas.
      - Buscar uma empresa pelo Cnpj ou Nome fantasia.
     
 
  ### Campos selecionado para salvar no banco
      - ID
      - Nome Fantasia
      - Razão social
      - CNPJ
      - Telefone
      - Endereço
      - Porte da Empresa
      
 **URL's**
 
|  URL |  Método | Descrição |
|----------|--------------|--------------|
|`http://localhost:8081/empresa/salvar/{cnpj}`                                 | POST | Salva a empresa no banco de dados |
|`http://localhost:8081/empresa/listarEmpresa`                                 | GET | Lista todas as empresas salvas no banco de dados |
|`http://localhost:8081/empresa/buscarUserId/{id}`                             | GET | Buscar empresa baseado no Id salvo no banco de dados |
|`http://localhost:8081/empresa/buscar/{filter}`                               | GET | Buscas dados da empresa tanto por nome Fantasia quanto CNPJ |

