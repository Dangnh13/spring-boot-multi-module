%~d0
cd %~p0
cd  /d mybatis-generator
:: If you want to keep the Command Prompt Window,you can use 'cmd /k' option.
:: If you want to close the Commond Prompt Window,you can comment out the bellow.
cmd /k mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true


