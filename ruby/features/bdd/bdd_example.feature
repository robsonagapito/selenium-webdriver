# language: pt

Funcionalidade: Validação de login da Comunidade Testadores

	No site exemplo
	Como um analista de cadastro
	Eu quero cadastrar novos clientes na pesquisa

Cenario: Validando idade menor que 18 anos
    Quando eu vou para a pagina do Cadastro Exemplo
    E eu informo minha idade igual a 17 anos
    Quando eu pressiono "salvar"
    Entao eu verei a mensagem "A idade tem que ser entre 18 e 65 anos"

Cenario: Validando idade maior que 65 anos
    Quando eu vou para a pagina do Cadastro Exemplo
    E eu informo minha idade igual a 66 anos
    Quando eu pressiono "salvar"
    Entao eu verei a mensagem "A idade tem que ser entre 18 e 65 anos"

Cenario: Validando idade igual a 18 anos
    Quando eu vou para a pagina do Cadastro Exemplo
    E eu informo minha idade igual a 18 anos
    Quando eu pressiono "salvar"
    Entao eu verei a mensagem "Registro gravado com sucesso."

Cenario: Validando idade igual a 18 anos
    Quando eu vou para a pagina do Cadastro Exemplo
    E eu informo minha idade igual a 65 anos
    Quando eu pressiono "salvar"
    Entao eu verei a mensagem "Registro gravado com sucesso."