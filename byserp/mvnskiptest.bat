%~d0
cd %~p0

:: If you want to keep the Command Prompt Window,you can use 'cmd /k' option.
:: If you want to close the Commond Prompt Window,you can comment out the bellow.
cmd /k mvn clean package -Dmaven.test.skip=true

