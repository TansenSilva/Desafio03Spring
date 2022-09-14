# Desafio03Spring

Continuação - parte 2.
Não mude os nomes dos atributos e classes - é essencial para a correção.
Se seu contas ContasAPagar ou Enums tiverem outros nomes diferentes coloque os da documentação.
Crie as classes relacionamentos e os CRUDS.

Todos os foreign deverão ter o final _id ex: Classe Avião terá o passageiro_id. Primary key terão o nome de código.

Crie uma classe Usuario:
	nomeUsuario: String
	dataNascimento: Date
	email - String -validation
	CPF - String - validation

Crie uma classe Endereco:
	logradouro: String
	Bairro: String
	cep: String
	pontoReferencia: String

Crie uma classe Cidade:
	nomeCidade: String

Crie uma classe Estado:
uf: String
	nomeEstado: String

Nosso Usuario tem seu contasReceber;

ContasReceber:
	Status String, recebimento String, valorRecebido BigDecimal, tipoRecebido ENUM, dataDeVencimento Date, dataDeRecebimento Date, usuario_id.
	
Enun TipoRecebimento: “ALUGUEIS, EMPREGO_CLT, FREELANCER"
Enun RecebimentoAlugueis: “EM_ATRASO, EM_DIA”, ADIANTADO”.

Entrega Mínima:
Patterns Factory.
Quando for recebimento de aluguéis.
Os aluguéis em contratos tem os seguintes critérios - em atraso multa de 3,5%, em dia sem desconto e adiantado 5% de desconto.

Entrega MÉDIA

O sistema realiza todas as validações de campos obrigatórios para cadastrar uma conta. São eles; nomeUsuario, VALORDERECEBIMENTO, TIPORECEBIMENTO e Data de Vencimento.
Pesquisa por todos os “usuários” não mostra cpf.
O sistema responderá de forma coerente todos os erros de validação como por exemplo 422 para erros causados por validação ou 404 quando usuário tentar atualizar uma conta que não existe. 

Para isso será necessário o controller advice.   

O sistema também permitirá visualizar uma conta específica com todos os detalhes. 
Entrega Maxima.

O sistema deve permitir que sejam feitos alguns filtros na lista de contas. 

1 - filtro de contas por status -contasReceber
2 - filtro de contas por TIPORECEBIMENTO - contasReceber
3 -Data de vencimento a partir de: - contasReceber

Por fim, o sistema deve permitir DELETAR uma conta caso seja necessário. A requisição deve seguir o seguinte padrão. 

Endpoint: /contasReceber/{id}
Verbo HTTP: DELETE

Resposta Status 204
