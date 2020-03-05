#language: pt

Funcionalidade: Adicionar um novo processo.

  Cenário: Adicionar um novo processo com sucesso.
    Dado que o usuário está na página Agapito Software Testing
    E o usuário clicar no menu "processos"
    E o usuário clicar no botão novo processo
    E o usuário digitar no campo "processo_vara" o valor "1"
    E o usuário digitar no campo "processo_numero_processo" o valor "1231456"
    E o usuário digitar no campo "processo_natureza" o valor "Guarda"
    E o usuário digitar no campo "processo_partes" o valor "Joao da silva x Maria leite"
    E o usuário digitar no campo "processo_data_entrada" o valor "04/03/2020"
    E o usuário digitar no campo "processo_status" o valor "Agendado"
    E o usuário seleciona no campo urgencia o valor "Sim"
    E o usuário clica no campo arbitramento com o valor Sim
    Quando o usuário clicar no botão "btn-save" na página de inclusão de processos
    Então o usuário deveria visualizar a mensagem "Processo foi criado com sucesso."

    Quando o usuário clicar em voltar
    Então o usuário deveria ver o texto "Joao da silva x Maria leite"
