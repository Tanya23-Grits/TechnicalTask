# swagger documentation link - http://localhost:8080/swagger-ui/index.html

## RUS: Описание API для работы с банковскими счетами: Данный API позволяет работать с банковскими счетами, создавать новые счета, получать информацию о счетах и производить операции по переводам и пополнению.

## Технологии: Java 17 Spring Boot 3.2.0 Maven 4.0.0 PostgresSQL 16.1

## Использование API:

### 1)Получение списка всех счетов GET /accounts Возвращает список всех банковских счетов.

### 2)Создание нового счета POST /account Создает новый банковский счет.

### 3)Получение информации о счете по ID GET /{id} Возвращает информацию о банковском счете по его ID.

### 4)Получение списка транзакций по ID счета GET /transaction/{id} Возвращает список транзакций для банковского счета по его ID.

### 5)Пополнение счета PUT /transaction/deposit Пополняет банковский счет на указанную сумму.

### 6)Снятие со счета PUT /transaction/withdraw Снимает со счета указанную сумму.

### 7)Перевод между счетами PUT /transaction/transfer Переводит указанную сумму со счета отправителя на счет получателя.


## ENG: API Description for Bank Account Management: This API allows to work with bank accounts, create new accounts, get information about accounts, and perform operations for transfers and deposits.

## Technologies: Java 17 Spring Boot 3.2.0 Maven 4.0.0 PostgresSQL 16.1

## API Usage:

### 1)Get a list of all accounts GET /accounts Returns a list of all bank accounts.

### 2)Create a new account POST /account Creates a new bank account Returns id of new acount.

### 3)Get information about an account by ID GET /{id} Search account by it's id Returns information in JSON format if it's exists or NotFound.

### 4)Get a list of transactions by account ID GET /transaction/{id} Search for a list of transactions for a bank account by its ID Returns information in JSON format if it's exists or NotFound.

### 5)Deposit funds into an account PUT /transaction/deposit Deposits the specified amount into a bank account Returns status of transaction.

### 6)Withdraw funds from an account PUT /transaction/withdraw Withdraws the specified amount from a bank account Returns status of transaction.

### 7)Transfer funds between accounts PUT /transaction/transfer Transfers the specified amount from the sender's account to the recipient's account Returns status of transaction.

