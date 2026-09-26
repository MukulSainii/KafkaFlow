# KafkaFlow
this repo is for understanding the basic flow of the kafka 
## 🔄 Order Processing Flow

```text
Customer
   │
   │ Create Order
   ▼
┌─────────────────┐
│  ORDER SERVICE  │
└────────┬────────┘
         │
         │ OrderCreated
         ▼
╔═════════════════╗
║  order-events   ║
╚════════╤════════╝
         │
         │ Consume
         ▼
┌─────────────────┐
│ PRODUCT SERVICE │
└────────┬────────┘
         │
         │ ProductReserved
         ▼
╔══════════════════╗
║ product-events   ║
╚════════╤═════════╝
         │
         │ Consume
         ▼
┌─────────────────┐
│ PAYMENT SERVICE │
└────────┬────────┘
         │
         │ PaymentCompleted
         ▼
╔═══════════════════╗
║  payment-events   ║
╚═════════╤═════════╝
          │
          │ Consume
          ▼
┌────────────────────┐
│ NOTIFICATION       │
│ SERVICE             │
└────────────────────┘
```

## ▶️ Running the Project

### Step 1: Start the Microservices

Start each service on the following ports:

| Service              |   Port |
| -------------------- | -----: |
| Order Service        | `8081` |
| Product Service      | `8082` |
| Payment Service      | `8083` |
| Notification Service | `8084` |

Make sure all four services are running before sending a request.

### Step 2: Create an Order

Use **Postman** to send a `POST` request to:

```http
POST http://localhost:8081/orders
```

Set the request **Body** to:

* **Body** → **raw**
* Select **JSON**

```json
{
  "productId": "P100",
  "quantity": 2
}
```

### Step 3: Order Event Flow

Once the order is created, the event flows through the services:

```text
Order Service
     │
     │ OrderCreated
     ▼
order-events
     │
     ▼
Product Service
     │
     │ ProductReserved
     ▼
product-events
     │
     ▼
Payment Service
     │
     │ PaymentCompleted
     ▼
payment-events
     │
     ▼
Notification Service
```

This demonstrates an **event-driven microservices architecture using Apache Kafka**.
