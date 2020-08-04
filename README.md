Um Back baseado no filme Star Wars, e integrado API Swap.co<br/>
<br/>
nele é possivel Adicionar os Planetas no Banco de dados Manualmente, consulta-los pelo id que é gerado pelo banco de dados automaticamente como string, pequisar os planetas que você cadastrou por nome, e caso o planeta cadastrado tenha aparecido em algum filme, você vera tambem quais filmes foram, e tambem é possivel deletar os planetas.


#configuração do banco de dados <br/>
é necessario realizar as alterações das credencias do banco de dados no arquivo application.properties, foi utilizado o mongodb, e o banco de dados deve possuir uma collection com o nome planetas



#Inserindo novos Planetas - POST /planetas/<br/>
Para inserir novos planetas basta enviar uma requisição POST para a url "/planetas/" com os seguintes dados:

nome = nome do Planeta<br/>
clima = clima do planeta<br/>
Terreno = com o tipo de terreno do planeta<br/>


os dados devem estar no formato json e devem ser enviados no corpo da requisição.
caso os objetos tenham sido salvos o servidor ira retornar o status 201 junto com o endereço do novo planeta cadastrado.


#Listar todos os Planetas - GET /planetas/<br/>

#Consulta por id - GET /planetas/{id}<br/>
Para Consultar dederminado Planeta por id deve ser enviada uma requisição GET para a url "/planetas/{id}/"

Caso o id exita ira retornar um objeto json parecido com o objeto abaixo

{<br/>
    "id": "id do planeta no formato de uma string",<br/>
    "nome": "Nome do planeta",<br/>
    "clima": "tipo de clima do planeta",<br/>
    "terreno": "tipo de terreno do planeta",<br/>
    "filmes": ["Lista com filmes em que o planeta apareceu",<br/>
    "caso ele não tenha aparecido em nenhum esta lista vira vazia]<br/>
}<br/>


#Pesquisa pelo nome - GET /planetas/search?nome= + nome do planeta, ou parte do nome.<br/>
Para fazer Uma Pesquisa pelo nome do planeta, basta enviar uma requisição GET para a url "/planetas/search?nome=" + o nome ou parte do nome do planeta de interesse, caso exista algum planeta cadastrado com os dados da pesquisa você ira receber um Json como o Abaixo:<br/>

[
    {<br/>
        "id": "id do planeta no formato de uma string",<br/>
        "nome": "Nome do planeta",<br/>
        "clima": "tipo de clima do planeta",<br/>
        "terreno": "tipo de terreno do planeta",<br/>
        "filmes": ["Lista com filmes em que o planeta apareceu",<br/>
        "caso ele não tenha aparecido em nenhum esta lista vira vazia]<br/>
    }
]<br/>

#Deletar um Planeta - DELETE /planetas/{id}<br/>
Para deletar um planeta basta você enviar uma requisição com o metodo delete para a url "/planeta/{id}"
caso tudo tenha ocorrido normalmente você recebera um status 204.
