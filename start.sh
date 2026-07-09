#!/usr/bin/env bash
set -e

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
LOGS_DIR="$ROOT_DIR/logs"
mkdir -p "$LOGS_DIR"

JAVA_OPTS="-Xmx256m -Xms128m"
BUILD_OPTS="-DskipTests -q"

# Modules avec chemins spéciaux (pour -pl)
INFRA_MODULES=(
  "config_server"
  "discovery_service"
  "api_gateway"
)

BUSINESS_MODULES=(
  "actualite"
  "admin"
  "coursenligne"
  "devoir"
  "domaine"
  "email"
  "empoiDuTemps"
  "Encadrement/encadrement"
  "Encadreur/encadreur"
  "enligne"
  "Enseignant/enseignant"
  "Etudiant/etudiant"
  "filiere"
  "historique"
  "matiere"
  "memoire"
  "messagerie"
  "moyenne"
  "niveau"
  "note"
  "notification"
  "organigramme"
  "presence"
  "president"
  "profile"
  "progression"
  "quiz"
  "semestre"
  "slides"
  "univesitaire"
  "utilisateur"
  "visio"
)

cleanup() {
  echo ""
  echo "Arrêt de tous les services..."
  pkill -f "spring-boot" 2>/dev/null || true
  pkill -f "etec-parent" 2>/dev/null || true
  wait 2>/dev/null
  echo "Tous les services sont arrêtés."
  exit 0
}

trap cleanup SIGINT SIGTERM

log() {
  local service="$1"
  local msg="$2"
  echo "[$service] $msg"
}

wait_for_service() {
  local service="$1"
  local port="$2"
  local max_retries=60
  local retries=0

  log "$service" "Attente du démarrage sur le port $port..."
  while [ $retries -lt $max_retries ]; do
    if curl -sf "http://localhost:$port/actuator/health" > /dev/null 2>&1; then
      log "$service" "Prêt !"
      return 0
    fi
    sleep 2
    retries=$((retries + 1))
  done
  log "$service" "ERREUR : non démarré après $((max_retries * 2)) secondes"
  return 1
}

start_service() {
  local module="$1"
  local logfile="$LOGS_DIR/$(echo "$module" | tr '/' '_').log"

  log "$module" "Démarrage..."
  mvn spring-boot:run -pl "$module" $BUILD_OPTS \
    -Dspring-boot.run.jvmArguments="$JAVA_OPTS" \
    > "$logfile" 2>&1 &
}

echo "=========================================="
echo "  ETEC Backend — Démarrage de tous les services"
echo "=========================================="
echo ""

echo "[1/3] Vérification des dépendances..."
for d in */; do
  if [ -f "$d/mvnw" ]; then
    chmod +x "$d/mvnw" && cd "$d" && ./mvnw dependency:go-offline
    cd ..
  fi
done
echo "Dépendances prêtes."
echo ""

echo "[2/3] Démarrage de l'infrastructure (config_server, discovery_service, api_gateway)..."
echo ""

# Config Server (port 8888)
start_service "config_server"
wait_for_service "config_server" 8888

# Discovery Service (port 8761 par défaut pour Eureka)
start_service "discovery_service"
wait_for_service "discovery_service" 8761

# API Gateway
start_service "api_gateway"

echo ""
echo "[3/3] Démarrage des microservices métier..."
echo ""

for module in "${BUSINESS_MODULES[@]}"; do
  start_service "$module"
  sleep 1
done

echo ""
echo "=========================================="
echo "  Tous les services sont en cours de démarrage."
echo "  Logs : $LOGS_DIR/"
echo "  Arrêt : Ctrl+C"
echo "=========================================="

# Attendre indéfiniment
wait
