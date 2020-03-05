#language: pt

  Funcionalidade: Tela de Login

    Cenário: Usuário valido e senha válida

      Dado que o usuário está na página de login
      E o usuário preenche no campo "login" o valor "robson"
      E o usuário preenche no campo "password" o valor "agapito"
      Quando o usuário clicar no botão login
      Então usuário deveria ver a mensagem de "Success Login!"


    Cenário: Usuário valido e senha inválida

      Dado que o usuário está na página de login
      E o usuário preenche no campo "login" o valor "robson"
      E o usuário preenche no campo "password" o valor "1234"
      Quando o usuário clicar no botão login
      Então usuário deveria ver a mensagem invalida igual a "Fail Login!"