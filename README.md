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