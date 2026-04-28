FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia tudo do projeto
COPY . .

# Gera o JAR usando Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Expõe a porta
EXPOSE 8080

# Executa o Spring Boot
CMD ["java", "-jar", "target/fila-0.0.1-SNAPSHOT.jar"]