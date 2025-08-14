@echo off
echo ========================================
echo    API REST para Node-RED - Java
echo ========================================
echo.
echo Compilando o projeto...
call mvnw.cmd clean compile
if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo.
echo Executando a aplicacao...
echo.
echo A API estara disponivel em: http://localhost:8080
echo Console H2: http://localhost:8080/h2-console
echo.
echo Pressione Ctrl+C para parar a aplicacao
echo.
call mvnw.cmd spring-boot:run

pause
