# ----- Etapa 1: Compilación (Build) -----
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /home/gradle/src
 
# 1. Copia SOLO los archivos de configuración de Gradle
COPY build.gradle settings.gradle ./
 
# 2. Copia TAMBIÉN la carpeta src
COPY src ./src
 
# 3. Construye el .jar ejecutable
RUN gradle bootJar --no-daemon
 
# ----- Etapa 2: Ejecución (Run) -----
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
 
# 4. Copia el .jar final
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
 
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]