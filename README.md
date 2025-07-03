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