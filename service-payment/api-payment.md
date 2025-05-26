# API Service-Payment

Este microservicio gestiona los pagos.

---

## Base URL

`http://localhost:8083/payments`

---

## Endpoints

### GET `/ping`

- Chequea si el servicio está activo.
- Respuesta:  
  - 200 OK  
  - `"service-payment is running"`

---

### GET `/`

- Obtiene todos los pagos registrados.
- Respuesta:  
  - 200 OK  
  - Lista JSON con los pagos.

---

### POST `/`

- Crea un nuevo pago.
- Request Body JSON:

```json
{
  "sourceAccount": "cuenta_origen",
  "destinationAccount": "cuenta_destino",
  "amount": 100.0
}
