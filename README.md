Versão do Java utilizado: 17

tecnologias: Maven, Fireabse, Springboot

###### **É necessário gerar um token e ter um banco de dados no Firebase.**

#### 
------

### Atividade:

1. Estude o framework Spring Boot e proponha uma WEB API para a
   funcionalidade mais complexa do projeto da disciplina Projeto Integrador II.

2. Indique pontos em que o Spring Boot por si força a adoção ou implementa
   conceitos S.O.L.I.D.

   > O spring gera uma estrtura que permite a inserção de códigos de fácil abertura para novas funcionalidades, por exemplo, ao usarmos em nosso código a anotation @Service que acessa uma outra classe (Booking) e essa última sendo uma abstração para as informações a serem extraídas do Banco de dados (BD). 
   >
   > Dessa forma, se em algum momento o BD precisar ser trocado ou precisarem ser feitas modificações sobre o conteúdo que é solicitado ao BD, poucas mudanças precisam ser feitas. Pois, o Spring Boot deixa claro a forma como ele busca as classes e o que espera encontrar nelas.
   >
   > Entrando,então, em um outro conceito que é o de responsabilidade única. Na pasta model, temos duas classes cada uma com sua responsabilidade, devidamente sinalizadas com @Entity, por exemplo, podendo ser acessadas por outras classes.
   >
   >  No próprio Spring tem o anotation RestController, que é específico para API, e antes era utilizado o Controller compartilhado por requisições web e api, que são diferentes, ou seja, coisas diferentes antes usavam a mesma ferramenta e agora cada um tem sua responsabilidade bem definida.

3. Indique pontos em que o Spring Boot implementa e/ou substitui algumas ideias
   de Clean architecture.

   > Apesar de um dos conceitos de Clean architecture apontar para a importância de uma independencia  de tecnologias e framework, mesmo com a depedência do Springboot ele oferece várias ferramentas para que não exista maiores dependências fora dele. Por exemplo, quando ele abstrai todas as configurações necessárias das tecnologias a serem utilizadas no projeto antes mesmo de começarmo a codificar através do https://start.spring.io/ . E o pom.xml também trata dessas questões e configurações voltados as dependencias.
   >
   > O springboot ajuda ,assim, no desacoplamento ao apresentar as estruturas e pré configurações para o projeto. Quem quando bem aplicado, resulta na camada interna sem conhecimento das camadas externas. Por exemplo, nessa imagem com algumas das classes criadas:
   >![image](https://user-images.githubusercontent.com/61996692/146690623-b1875742-9201-4472-850e-d1c90aea6794.png)

   > 

4. Proponha uma alteração da WEB API pra implementar algum conceito não
   identificado dos itens 2 e 3.
   > Implementacao de um repositorio generico para (getById, getByAttribute);

   > Dependency Inversion Principle: Implementar interfaces como uma forma de contrato para a utilização do banco;


5. Avalie de forma crítica como um framework como o Spring boot substitui a
   necessidade de abstrair mudanças de acordo com o vídeo abaixo:
   https://www.youtube.com/watch?v=SQfpiDlYd0g

    > A implementação de várias abstrações onde o esforço para proteger de mudanças em tecnologias pode não compensar, ainda mais para Api's que podem ser altamente coesas.

    > O que o spring já possui: <br/> 
        @Entity utilizada para informar que uma classe também é uma entidade. <br/> 
        @RestController é uma anotação de conveniência que faz nada além de adicionar as anotações @Controller e @ResponseBody. <br/> 
        @Service para indicar que uma classe contém regras de negócio, uma camada de serviço. <br/> 
        @Repository anota classes na camada de persistência, que atuará como um repositório de banco de dados. <br/> 
        @Autowired delega ao Spring Boot a inicialização do objeto. <br/> 
        @RequestMapping permite definir uma rota. Caso não seja informado o método HTTP da rota, ela será definida para todos os métodos. <br/> 


