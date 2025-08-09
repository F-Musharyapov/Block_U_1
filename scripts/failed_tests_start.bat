@echo off  
echo Hello, старт скриптов!

start cmd /k java -jar C:\Selenium\selenium-server-4.34.0.jar hub --port 4446
timeout /t 25
start cmd /k java -jar C:\Selenium\selenium-server-4.34.0.jar node --port 5555 --hub http://localhost:4446
echo Hub на порту 4446 и node на порту 5555 запущены отдельными окнами

mvn test -Dsurefire.suiteXmlFiles=test-output/testng-failed.xml
echo Произведен запуск упавших тестов из отчета TestNG

pause