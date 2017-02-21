# xy-inc

1. AMBIENTE UTLIZADO NESTE PROJETO 

                    S.O. - Linux Mint 17 (https://www.linuxmint.com/download.php)
              PLATAFORMA - Java 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
                     IDE - Spring Tools Suite (https://spring.io/tools/sts/all)
               FRAMEWORK - Spring (Spring Boot, Spring Data JPA)
          BANCO DE DADOS - mySql
				 
				           sudo apt-get update && sudo apt-get upgrade

				           sudo apt-get install mysql-server-5.7 (Lembre-se de setar a senha do usuario root tambem como "root", pois é a mesma configurada na aplicação)

CLIENT DE BANCO DE DADOS - mySql workbench 			 

				           sudo apt-get install mysql-workbench


2.PRÉ-REQUISITOS PARA EXECUÇÃO DO PROJETO

	Com o ambiente devidamente configurado abra o mySql workbench e se autentique com as credenciais abaixo.
    		user: root
    	password: root

    Crie um novo banco de dados com o comando abaixo
    	create database xyinc; 
    	obs.: Não é necessário criar as tabelas da base de dados pois ela sera criata automaticamente através da propriedade spring.jpa.hibernate.ddl-auto=update do arquivo application.properties e do mapeamento feito através do Spring Data(JPA).

    Faça o Dowload do projeto através do link (https://github.com/rafagranero11/xy-inc) 
    	ou o clone através do link https://github.com/rafagranero11/xy-inc.git

    Após o Download descompacte o arquivo em um diretório de sua preferencia e faça o import do projeto na IDE Spring Tools Suite
    	File > Import > Existing Maven Project

    Após a importação faça o update das dependências configuradas no pom.xml
    	Clique com o botão direito sobre o projeto > Maven > Update Project > selectione o projeto > flegue a opção Force Update os Snapshots/Releases > OK

    Após a atualização das dependencias rode o projeto
    	Clique com o botão direito sobre o projeto > Run As > Spring Boot App

3. TESTES

	Utilize as Urls apaixo como exemplo para testar em qualquer client HTTP ou navegador.    	

	GET - http://localhost:8080/poi/test - Retorna uma string basica para verificar se os serviçoes estao disponíveis e se a requisição esta 	batendo na camada de controle.

	GET - http://localhost:8080/poi/listPoi - Lista todos os POIs

	POST - http://localhost:8080/poi/save?nomePoi=TesteRafael&coordenadaX=39&coordenadaY=45 - Salva um novo POI na base de dados.

	GET - http://localhost:8080/poi/findByCoordinates?coordenadaX=20&coordenadaY=10&metros=10 - Busca os Pois baseado em uma coordenada x,y e 	uma distância em metros.