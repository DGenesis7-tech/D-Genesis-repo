# Build and run YourContact with the JVM flag that enables native access
# Usage: Open PowerShell in the project root and run: .\run-windows.ps1

mvn clean package -DskipTests
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

java --enable-native-access=ALL-UNNAMED -jar "target\yourContact-0.0.1-SNAPSHOT.jar"
