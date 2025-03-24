```mermaid
---
title: Payment
---
classDiagram
  class Payment{
    -int paymentId
    -int rentalId
    -int amount
    +paymentMethod(credit, cash)
    +processPayment()
}

