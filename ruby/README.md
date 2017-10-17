Cucumber com Ruby
=================

Projeto exemplo para realização de testes com a técnica BDD utiliando Ruby + Cucumber + Capybara

BDD - Behavier Driven Development
---------------------------------

Conhecendo um pouco mais sobre a técnica: http://www.bugbang.com.br/entendendo-bdd-com-cucumber-parte-i/

Para executar o projeto basta
-----------------------------

- Se possuir o RVM não precisa instalar nada. Se não tiver, tem que ter o Ruby 2.1.3 instalado.
- Instalar o PhantomJS (versão 1.9.7) na máquina.
	* (no iOS) brew install phantomjs 
	* (no Ubuntu) sudo apt-get install phantomjs
	* para verificar a versão: phantomjs --version
- Baixar o projeto.
- Executar o bundle.
- Executar o cucumber colocando o diretório/feature que está trabalhando.
- Também executará o parametro -p <tag> para pegar uma tag com outros parametros que está no arquivo config/cucumber.yml
 
Exemplo de execução
-------------------
	
	bundle exec cucumber features/tdc/bdd_example.feature -p testers

	bundle exec cucumber features/bdd/login.feature -p testers