FROM openjdk:11-jre-slim

WORKDIR /app

COPY . .

EXPOSE 8042

CMD ["./gradlew", "run"]

