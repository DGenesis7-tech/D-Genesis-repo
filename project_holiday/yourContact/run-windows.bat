@echo off
REM Build and run YourContact with the JVM flag that enables native access
REM Usage: run-windows.bat

mvn clean package -DskipTests
IF %ERRORLEVEL% NEQ 0 EXIT /B %ERRORLEVEL%

java --enable-native-access=ALL-UNNAMED -jar "target\yourContact-0.0.1-SNAPSHOT.jar"
