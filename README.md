# probes-client

Um "client-side" da aplicação de registro de leitura de sensores, responsável pelo recebimento dos dados de um controlador e envio para uma API Rest.

Esta aplicação cliente se conecta com alguma porta serial disponível no computador e monitora os pacotes recebidos. Caso seja um JSON válido, como por exemplo [{"id":1,"read_value":25},{"id":2,"read_value":62},{"id":3,"read_value":29},{"id":4,"read_value":52}], são instanciados objetos da classe Probe, sendo mapeados o id e o read_value.

O id é utilizado no url da própria requisição enviada para a API Rest e o read_value entra como parte do JSON do corpo da requisição via método post.

Por exemplo, o JSON citado acima geraria 4 requisições POST:

http://localhost:8080/probedesc/1/probevalue
Corpo: {"read_value":25}
http://localhost:8080/probedesc/2/probevalue
Corpo: {"read_value":62}
http://localhost:8080/probedesc/3/probevalue
Corpo: {"read_value":29}
http://localhost:8080/probedesc/4/probevalue
Corpo: {"read_value":52}

* Bibilotecas utilizadas: 
 - jSerialComm (2.2.0)
 - Google Gson (2.8.5)
 - Jersey (1.8)
