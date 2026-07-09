#!/usr/bin/env bash
set -e

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
LOGS_DIR="$ROOT_DIR/logs"
mkdir -p "$LOGS_DIR"

JAVA_OPTS="-Xmx256m -Xms128m"
BUILD_OPTS="-DskipTests -q"

INFRA_MODULES=(
  "config_server"
  "discovery_service"
  "api_gateway"
)

cleanup() {
  echo ""
  echo "Arrêt de l'infrastructure..."
  pkill -f "spring-boot" 2>/dev/null || true
  pkill -f "etec-parent" 2>/dev/null || true
  wait 2>/dev/null
  echo "Infrastructure arrêtée."
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
echo "  ETEC Infrastructure"
echo "  config_server | discovery_service | api_gateway"
echo "=========================================="
echo ""

echo "[1/2] Build des modules d'infrastructure..."
mvn install $BUILD_OPTS \
  -pl "$(IFS=,; echo "${INFRA_MODULES[*]}")" \
  -am
echo "Build terminé."
echo ""

echo "[2/2] Démarrage..."
echo ""

start_service "config_server"
wait_for_service "config_server" 8888

start_service "discovery_service"
wait_for_service "discovery_service" 8761

start_service "api_gateway"

echo ""
echo "=========================================="
echo "  Infrastructure en cours d'exécution."
echo "  Logs : $LOGS_DIR/"
echo "  Arrêt : Ctrl+C"
echo "=========================================="

wait
