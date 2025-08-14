@echo off
echo ========================================
echo    API REST para Node-RED - Java
echo ========================================
echo.
echo Executando com Maven Wrapper...
echo.

REM Verificar se o Java está instalado
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERRO: Java nao encontrado!
    echo Instale o Java 17 ou superior
    pause
    exit /b 1
)

echo Java encontrado! Versao:
java -version
echo.

echo Compilando o projeto...
call mvnw.cmd clean compile
if %errorlevel% neq 0 (
    echo.
    echo ERRO na compilacao! Verifique se o Java 17+ esta instalado
    pause
    exit /b 1
)

echo.
echo Compilacao bem-sucedida!
echo.
echo Executando a aplicacao...
echo.
echo A API estara disponivel em: http://localhost:8080
echo Console H2: http://localhost:8080/h2-console
echo Health Check: http://localhost:8080/api/produtos/health
echo.
echo Pressione Ctrl+C para parar a aplicacao
echo.

call mvnw.cmd spring-boot:run

pause
