# karen
Karen is an accounting software based on Java



## Planning
The idea of this software is that any user can easily do their accounting. There should be functionalities
covering every desire that people have, thinking of an accounting software. It should be easy to use, accessible for
everyone and free.

The idea of how the classes for the implementation could look is what we tried to draw on the following picture.

![UML of karen at the beginning](https://github.com/ant0n7/karen/blob/main/umlstart.png)

### Why inheritance was not used
Planned was an implementation resembling the last sketch. In this idea the class Entity is either the receiver or the sender of a transaction. In the planning process we decided to remove that whole inheritance tree and not link every transaction to a customer. Transactions can be linked to an order. Every order is linked to a customer. The would be a massive redundancy if every transaction was linked to a customer separately while it's already linked through the order.  

## Functionalities
this software offers following functionalities

### Customer
- Adding customers that consist of a name, a POC (Person of contact) and a location that is split in to multiple fields
- this customer can be added to a transaction when creating one

### Order
- Adding orders that consist of a title, a description, a status, a type, a customer and the expenses
- a transaction relies on the order. It can not be created without any existing orders

### Transaction
- Adding transactions that consist of an amount, a currency, a purpose, an order and a date
- a transaction cannot exist without an order and an order cannot exist without a customer

### Additional functionalities
- Detailed view of all transactions
- Detailed view of all customers
- Detailed view of all orders
- Accounting statistics

### UML
![UML of karen](https://github.com/ant0n7/karen/blob/main/Bild_2022-01-30_233128.png)

### Sequence Diagram
![Sequence Diagram for addTransactionmethod](https://github.com/ant0n7/karen/blob/main/addTransactionSequence.png)
