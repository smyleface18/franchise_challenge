# Imagen base: JDK para correr la app
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el jar compilado
COPY target/*.jar app.jar

# Exponer puerto interno
EXPOSE 8080

# Comando para iniciar la app
ENTRYPOINT ["java","-jar","app.jar"]

