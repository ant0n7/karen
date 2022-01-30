# karen
Karen is an accounting software based on Java and MySQL


this software offers following functionalities

## Customer
- Adding customers that consist of a name, a POC (Person of contact) and a location that is split in to multiple fields
- this customer can be added to a transaction when creating one

## Order
- Adding orders that consist of a title, a description, a status, a type, a customer and the expenses
- a transaction relies on the order. It can not be created without any existing orders

## Transaction
- Adding transactions that consist of an amount, a currency, a purpose, an order and a date
- a transaction cannot exist without an order and an order cannot exist without a customer

## Additional functionalities
- Detailed view of all transactions
- Detailed view of all customers
- Detailed view of all orders
- Accounting statistics

## UML
![UML of karen](https://github.com/ant0n7/karen/blob/main/Bild_2022-01-30_233128.png)

## Sequence Diagram
![Sequence Diagram for addTransactionmethod](https://github.com/ant0n7/karen/blob/main/addTransactionSequence.png)
