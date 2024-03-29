# Utilisez une image de base avec Java pré-installé
FROM openjdk:17
#Pour le port utilise
EXPOSE 8080
# Définissez le répertoire de travail dans l'image Docker
WORKDIR /app
# Copiez les fichiers sources de votre application dans l'image Docker
COPY . /app
# Exécutez les étapes de compilation de votre application
#RUN ./mvnw clean package
# Commande par défaut pour exécuter votre application Java
CMD ["java", "-jar", "examdevops-marcelino.jar"]