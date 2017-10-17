# language: pt

Funcionalidade: Validação de login

@login
Cenario: Logando no site com usuário válido e senha inválida  
    Quando eu vou para a pagina de Login
    E eu preencho o campo "login" com "robson"
    E eu preencho o campo "password" com "aaaaa"
    E eu pressiono "Login"
    Entao eu verei "Fail Login!" em "#result"

@login
Cenario: Logando no site com usuário inválido e senha válida  
    Quando eu vou para a pagina de Login
    E eu preencho o campo "login" com "aaaaa"
    E eu preencho o campo "password" com "agapito"
    E eu pressiono "Login"
    Entao eu verei "Fail Login!" em "#result"

@login
Cenario: Logando no site com usuário inválido e senha inválida  
    Quando eu vou para a pagina de Login
    E eu preencho o campo "login" com "robson"
    E eu preencho o campo "password" com "agapito"
    E eu pressiono "Login"
    Entao eu verei "Success Login!" em "#result"

@login @wip
Cenario: Logando no site com usuário e/ou senha inválida  
    Quando eu vou para a pagina de Login
    Entao eu preencho e valido os campos com os seguintes atributos:
    | login     | password    | result         |
    | robson    | aaaaaaaaaa  | Fail Login!    |
    | aaaaaa    | agapito     | Fail Login!    |
    | qalwfa    | inicial123  | Fail Login!    |
    | robson    | agapito     | Success Login! |