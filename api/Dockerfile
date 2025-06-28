# Imagem base com Java
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR para dentro do container
COPY api.jar .

# Comando que será executado quando o container iniciar
CMD ["java", "-jar", "api.jar"]
