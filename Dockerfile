# Usa una imagen de Maven para construir la aplicación
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copia los archivos del proyecto y construye el JAR
COPY . .
RUN mvn clean package -DskipTests

# Usa una imagen ligera de Java para ejecutar la app
FROM openjdk:21-jdk AS runtime
WORKDIR /app

# Copia el JAR generado desde el contenedor builder
COPY --from=builder /app/target/crud-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
