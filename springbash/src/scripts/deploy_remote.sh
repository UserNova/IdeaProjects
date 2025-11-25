#!/bin/bash

echo "Déploiement local du fichier JAR..."

SOURCE_JAR="target/springbash-0.0.1-SNAPSHOT.jar"
DEST_PATH="/c/Users/rania/Desktop/deploy"

# Vérifier si le JAR existe
if [ ! -f "$SOURCE_JAR" ]; then
  echo "Le fichier JAR n'existe pas. Lance d'abord : mvn clean package"
  exit 1
fi

# Copier le fichier
cp "$SOURCE_JAR" "$DEST_PATH"

echo "Déploiement terminé ! Le JAR est dans : $DEST_PATH"
