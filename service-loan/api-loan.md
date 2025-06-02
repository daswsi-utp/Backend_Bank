# API Service-Loan

Este microservicio gestiona los préstamos.

---

## Base URL

`http://localhost:8084/loans`

---

## Endpoints

### GET `/ping`

- Chequea si el servicio está activo.
- Respuesta:  
  - 200 OK  
  - `"service-loan is running"`

---

### GET `/`

- Obtiene todos los préstamos registrados.
- Respuesta:  
  - 200 OK  
  - Lista JSON con los préstamos.

---

### POST `/`

- Crea un nuevo préstamo.
- Request Body JSON:

```json
{
  "borrower": "nombre_del_cliente",
  "amount": 1000.0,
  "termMonths": 12
}
