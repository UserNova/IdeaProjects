#!/bin/bash
echo "Vérification de la santé du service Spring Boot..."
curl -s http://localhost:8085/actuator/health
echo ""
