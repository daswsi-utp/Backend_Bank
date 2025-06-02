# build-and-run.ps1

Write-Host "`n🛠  Iniciando generación de .jar de todos los microservicios..." -ForegroundColor Cyan

# Listado de carpetas de microservicios
$services = @(
    "serviceuser",
    "service-auth",
    "service-account",
    "service-transfer",
    "service-card",
    "service-payment",
    "service-loan",
    "service-log",
    "service-fraud",
    "service-employee",
    "api-gateway"
)

# Cambiar a la carpeta raíz del proyecto
cd (Split-Path -Parent $MyInvocation.MyCommand.Definition)

# Recorre cada microservicio y genera el jar
foreach ($service in $services) {
    Write-Host "`n📦 Empaquetando $service ..." -ForegroundColor Yellow
    cd "$service"
    mvn clean package -DskipTests
    cd ..
}

Write-Host "`n🐳 Construyendo imágenes Docker con docker compose..." -ForegroundColor Cyan
docker compose build

Write-Host "`n🚀 Levantando contenedores con docker compose..." -ForegroundColor Cyan
docker compose up
