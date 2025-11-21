FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

# Permite rodar o mvnw
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# ----------------------------
# IMAGEM FINAL
# ----------------------------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o .jar
COPY --from=build /app/target/*.jar app.jar

# 🔥 ESSAS DUAS LINHAS SÃO OBRIGATÓRIAS NO RENDER
EXPOSE 8080
ENV PORT=8080

# Inicia o app
CMD ["java", "-jar", "app.jar"]
