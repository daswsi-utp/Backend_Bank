# Arquitectura del Proyecto

![BankNet-ARQ](https://github.com/user-attachments/assets/3d569a5e-305d-4d88-86aa-58642b5771ed)

# 🏦 BankNet - Backend (Arquitectura de Microservicios)

Este proyecto corresponde al backend de la plataforma bancaria **BankNet**, desarrollado con **Java + Spring Boot**, estructurado bajo una arquitectura **basada en microservicios**. Cada microservicio tiene su propia base de datos (MySQL) y responsabilidad claramente definida.

---

## 🔧 Microservicios del Sistema

### ✅ `service-user` - Gestión de Usuarios
- Administra la información personal de los usuarios (clientes y empleados).
- 📌 Funcionalidades:
  - Registro, edición y consulta de usuarios.
  - Validación de DNI y email únicos.
  - Consulta de perfil y listado para administración.
- 🗃️ Tabla principal: `usuarios`

---

### 🔑 `service-auth` - Autenticación y Credenciales
- Controla el acceso al sistema mediante validación de credenciales.
- 📌 Funcionalidades:
  - Login con `email` y `contraseña`.
  - Retorno de `userId`, `rol` y datos del usuario.
  - Opcional: manejo de tokens, 2FA.
- 🗃️ Tabla principal: `credenciales`

---

### 🏦 `service-account` - Cuentas Bancarias
- Gestiona las cuentas bancarias de los usuarios.
- 📌 Funcionalidades:
  - Registro de cuentas nuevas.
  - Consulta de saldos y cuentas activas.
  - Cambio de estado de cuenta (activa, bloqueada, cerrada).
- 🗃️ Tablas: `cuentas`, `tipos_cuenta`, `estados_cuenta`

---

### 🔁 `service-transfer` - Transferencias
- Procesa y registra transferencias entre cuentas bancarias.
- 📌 Funcionalidades:
  - Validación de fondos y estados de cuentas.
  - Historial de transferencias por cuenta.
  - Integración con `service-account` para abonar/debitar automáticamente.
- 🗃️ Tablas: `transferencias`, `estados_transferencia`

---

### 💳 `service-card` - Tarjetas de Débito
- Administra las tarjetas de débito vinculadas a los usuarios.
- 📌 Funcionalidades:
  - Generación automática de tarjeta y CVV.
  - Activación y bloqueo de tarjetas.
  - Registro de movimientos de tarjeta.
- 🗃️ Tablas: `tarjetas`, `movimientos_tarjeta`, `tipos_tarjeta`, `estados_tarjeta`

---

### 💸 `service-payment` - Pagos de Servicios
- Permite realizar pagos de servicios públicos (agua, luz, internet).
- 📌 Funcionalidades:
  - Validación de número de referencia y saldo.
  - Registro e historial de pagos por cuenta.
- 🗃️ Tabla principal: `pagos_servicios`

---

### 💰 `service-loan` - Préstamos
- Gestiona préstamos personales y sus pagos.
- 📌 Funcionalidades:
  - Solicitud, evaluación y simulación de préstamos.
  - Registro de pagos de cuotas mensuales.
  - Seguimiento del estado del préstamo.
- 🗃️ Tablas: `prestamos`, `pagos_prestamo`, `estados_prestamo`

---

### 🔒 `service-log` - Registro de Actividades
- Registra la actividad de los usuarios para fines de auditoría y seguridad.
- 📌 Funcionalidades:
  - Registro de IP, navegador y acciones realizadas.
  - Filtro por tipo de actividad y exportación de logs.
- 🗃️ Tabla principal: `logs_usuario`

---

### 🧠 `service-fraud` - Detección de Fraude
- Detecta transacciones sospechosas con lógica de riesgo.
- 📌 Funcionalidades:
  - Análisis de transacciones con score de riesgo.
  - Generación y gestión de alertas de fraude.
  - Confirmación o rechazo manual desde el panel administrativo.
- 🗃️ Tablas: `alertas_fraude`, `tipos_transaccion_alerta`

---

## 📦 Tecnologías Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web (REST)
- MySQL Server
- Maven
- Swagger (documentación de APIs)

---

## 🚀 Estructura del Proyecto
Cada microservicio es independiente y contiene:

/src
└── main
└── java
└── com.banknet.[service]
├── controller
├── dto
├── model
├── repository
├── service
└── serviceimpl