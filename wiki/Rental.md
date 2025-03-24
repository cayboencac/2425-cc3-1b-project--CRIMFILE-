```mermaid
---
title: Rental
---
classDiagram
  class Rental{
    -int rentalId
    -int totalCost
    -int carId
    -int rentalDate
    -int returnDate
    +calculateTotalCost()
}

