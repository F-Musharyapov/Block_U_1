@echo off  
echo Hello, старт скриптов!

start cmd /k java -jar C:\Selenium\selenium-server-4.34.0.jar hub --port 4446

timeout /t 25

start cmd /k java -Dwebdriver.edge.driver="C:\edgedriver\msedgedriver.exe" -jar C:\Selenium\selenium-server-4.34.0.jar node --port 5555 --hub http://localhost:4446

timeout /t 25
start cmd /k java -Dwebdriver.ie.driver="C:\IEDriverServer\IEDriverServer.exe" -jar C:\Selenium\selenium-server-4.34.0.jar node --port 5556 --hub http://localhost:4446

echo Hub на порту 4446 и node на порту 5555 запущены отдельными окнами
pause