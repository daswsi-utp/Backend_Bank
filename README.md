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