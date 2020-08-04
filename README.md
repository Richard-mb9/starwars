Um Back baseado no filme Star Wars, e integrado API Swap.co

nele é possivel Adicionar os Planetas no Banco de dados Manualmente, consulta-los pelo id que é gerado pelo banco de dados automaticamente como string, pequisar os planetas que você cadastrou por nome, e caso o planeta cadastrado tenha aparecido em algum filme, você vera tambem quais filmes foram, e tambem é possivel deletar os planetas.

é necessario realizar as alterações das credencias do banco de dados no arquivo application.properties



#Inserindo novos Planetas - POST /planetas/
Para inserir novos planetas basta enviar uma requisição POST para a url "/planetas/" com os seguintes dados:

nome = nome do Planeta
clima = clima do planeta
Terreno = com o tipo de terreno do planeta

os dados devem estar no formato json e devem ser enviados no corpo da requisição.
caso os objetos tenham sido salvos o servidor ira retornar o status 201 junto com o endereço do novo planeta cadastrado.


#Consulta por id - GET /planetas/{id}
Para Consultar dederminado Planeta por id deve ser enviada uma requisição GET para a url "/planetas/{id}/"

Caso o id exita ira retornar um objeto json parecido com o objeto abaixo

{
    "id": "id do planeta no formato de uma string",
    "nome": "Nome do planeta",
    "clima": "tipo de clima do planeta",
    "terreno": "tipo de terreno do planeta",
    "filmes": ["Lista com filmes em que o planeta apareceu",
    "caso ele não tenha aparecido em nenhum esta lista vira vazia]
}


#Pesquisa pelo nome - GET /planetas/search?nome= + nome do planeta, ou parte do nome
Para fazer Uma Pesquisa pelo nome do planeta, basta enviar uma requisição GET para a url "/planetas/search?nome=" + o nome ou parte do nome do planeta de interesse, caso exista algum planeta cadastrado com os dados da pesquisa você ira receber um Json como o Abaixo:

[
    {
        "id": "id do planeta no formato de uma string",
        "nome": "Nome do planeta",
        "clima": "tipo de clima do planeta",
        "terreno": "tipo de terreno do planeta",
        "filmes": ["Lista com filmes em que o planeta apareceu",
        "caso ele não tenha aparecido em nenhum esta lista vira vazia]
    }
]

#Deletar um Planeta - DELETE /planetas/{id}
Para deletar um planeta basta você enviar uma requisição com o metodo delete para a url "/planeta/{id}"
caso tudo tenha ocorrido normalmente você recebera um status 204.
