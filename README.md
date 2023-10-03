## Sobre o projeto 
Devido ao aumento constante de produtos e imóveis apreendidos pela Receita Federal do Brasil, o governo brasileiro identificou a necessidade de desenvolver um Sistema de Leilões Eletrônicos mais robusto e simples que o atual Sistema de Leilões Eletrônicos (SLE) utilizado através do portal eCAC. Este projeto tem como objetivo criar uma plataforma eficiente para leilões de dispositivos de informática e veículos apreendidos.

O sistema possui as seguintes funcionalidades básicas:

1. Gerenciamento de Dispositivos de Informática
Registro, consulta, atualização e remoção de dispositivos de informática a serem leiloados, incluindo notebooks, monitores, hubs, switches e roteadores.

2. Gerenciamento de Veículos
Registro, consulta, atualização e remoção de veículos a serem leiloados, incluindo carros, motocicletas de passeio, caminhões e utilitários.

4. Gerenciamento de Leilões
Registro, consulta, atualização e remoção de leilões, com informações como data de ocorrência futura, data de visitação dos itens do leilão, local de realização e outros detalhes pertinentes a leilões eletrônicos.
Os leilões também devem ter informações de entrada física, incluindo endereço, cidade e estado.

5. Associação de Produtos aos Leilões
Associação dos produtos registrados (dispositivos de informática e veículos) aos seus respectivos leilões.
O registro de produtos deve ser independente do leilão, mas eles devem obrigatoriamente estar vinculados a um leilão registrado no momento do cadastro.

6. Gerenciamento de Clientes Autorizados
Registro, consulta, atualização e remoção dos dados de cada cliente autorizado a interagir com o sistema.
Os clientes podem fornecer lances e consultar detalhes dos produtos anunciados nos leilões, bem como informações sobre os leilões a serem realizados.

8. Gerenciamento de Instituições Financeiras
Registro, consulta, atualização e remoção das instituições financeiras responsáveis pela quitação das transações fechadas durante os leilões.


## Executando a aplicação 
1. Instale o Maven;
   
2.  Clonar o repositório utilizando:
   `git clone https://github.com/lara-leal/lp-leilao.git`

3. Acesse o caminho da pasta executando:
    `cd lp-leilao`
   `cd lp-leilao`
   
4. Rodar mvn clean install para instalar as dependências;
   
5. Execute o seguinte comando:
   `mvn mn:run`
   
6. A aplicação estará disponivel na porta: 8080

## Acesse a documentação 
Acesse o link a seguir para visualizar a documentação da aplicação: 
