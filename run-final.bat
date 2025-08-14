@echo off
echo ========================================
echo    API REST para Node-RED - Java
echo ========================================
echo.

REM Configurar JAVA_HOME para o JDK 22 encontrado
set JAVA_HOME=C:\Program Files\Java\jdk-22
echo JAVA_HOME configurado: %JAVA_HOME%
echo.

REM Verificar se o Java está funcionando
echo Verificando Java...
"%JAVA_HOME%\bin\java" -version
if %errorlevel% neq 0 (
    echo ERRO: Java nao funcionando!
    pause
    exit /b 1
)

echo.
echo Java funcionando! Versao:
"%JAVA_HOME%\bin\java" -version
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
