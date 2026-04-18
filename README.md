# 🏧 Bank Management System — ATM Simulator

A desktop-based ATM Simulator application built with **Java** and **MySQL**, providing core banking operations through a secure card number and PIN-based authentication system.

---

## 📌 Project Description

The **Bank Management System** is a desktop application that simulates the core functionality of a real-world ATM machine. It is built using **Core Java** for business logic, **Java Swing** for the graphical user interface, **JDBC** for database connectivity, and **MySQL** for persistent data storage.

The application allows users to securely log in using their **card number** and **PIN number** — similar to how a real ATM works. Once authenticated, users can perform essential banking operations such as depositing money, withdrawing money, and viewing their mini statement which shows recent transaction history.

This project demonstrates strong understanding of:
- **Object-Oriented Programming (OOP)** — classes, inheritance, encapsulation
- **Database Design** — normalized MySQL schema for accounts and transactions
- **JDBC Connectivity** — real-time read/write operations between Java and MySQL
- **GUI Development** — interactive desktop screens using Java Swing
- **Validation Logic** — PIN authentication, balance checks before withdrawal

The system is designed to be simple, secure, and user-friendly — closely mimicking the experience of using a real ATM terminal.

---

## ✨ Features

- 🔐 **Secure Login** — Authentication via Card Number and PIN
- 💰 **Deposit Money** — Add funds to your account instantly
- 💸 **Withdraw Money** — Withdraw cash with balance validation
- 🧾 **Mini Statement** — View recent transaction history
- 🔄 **Real-time Balance** — Balance updates after every transaction
- 🛡️ **PIN Validation** — Wrong PIN blocks unauthorized access

---

## 🖥️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core application logic and OOP |
| Java Swing | Desktop GUI — forms, buttons, dialogs |
| JDBC | Database connectivity |
| MySQL | Data storage — accounts and transactions |

---

## 🗄️ Database Schema

```sql
-- Account Table
CREATE TABLE account (
    card_number   VARCHAR(20) PRIMARY KEY,
    pin           VARCHAR(10) NOT NULL,
    holder_name   VARCHAR(100) NOT NULL,
    balance       DECIMAL(10,2) DEFAULT 0.00,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Transaction Table
CREATE TABLE transactions (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    card_number      VARCHAR(20),
    type             ENUM('DEPOSIT','WITHDRAWAL'),
    amount           DECIMAL(10,2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (card_number) REFERENCES account(card_number)
);
```

---

## 📂 Project Structure

```
Bank-Management-System/
│
├── src/
│   ├── Login.java            → Card number + PIN authentication
│   ├── Dashboard.java        → Main ATM menu screen
│   ├── Deposit.java          → Deposit money screen
│   ├── Withdraw.java         → Withdraw money screen
│   ├── MiniStatement.java    → Transaction history screen
│   └── DBConnection.java     → MySQL JDBC connection
│
├── database/
│   └── bank_db.sql           → Database setup script
│
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or above
- MySQL Server
- IntelliJ IDEA or Eclipse

### Steps

```bash
# Step 1 — Clone the repository
git clone https://github.com/Shyam97099/Bank-Management-System.git

# Step 2 — Open in IntelliJ IDEA or Eclipse

# Step 3 — Setup MySQL Database
# Open MySQL and run:
source database/bank_db.sql

# Step 4 — Update DB credentials in DBConnection.java
String url  = "jdbc:mysql://localhost:3306/bank_db";
String user = "root";
String pass = "your_password";

# Step 5 — Run the project
# Right click Login.java → Run
```

---

## 📸 Application Flow

```
Launch App
    ↓
Login Screen
(Enter Card Number + PIN)
    ↓
Authentication Check (MySQL)
    ↓ ✅ Success
ATM Dashboard
    ↓
┌──────────────────────────┐
│  1. Deposit Money        │
│  2. Withdraw Money       │
│  3. Mini Statement       │
│  4. Exit                 │
└──────────────────────────┘
    ↓
Transaction Saved to MySQL
    ↓
Updated Balance Displayed
```

---

## 🔒 Security Features

- PIN-based authentication before any transaction
- Wrong PIN — access denied immediately
- Balance validation before withdrawal — prevents overdraft
- All transactions saved to MySQL with timestamp

---

## 💡 What I Learned

Building this project helped me strengthen my understanding of:

- Connecting Java applications to MySQL using **JDBC**
- Designing clean and normalized **relational database schemas**
- Building interactive desktop UIs using **Java Swing**
- Implementing **real-time data operations** — insert, update, select
- Writing **validation logic** — PIN check, balance check, input check
- Applying **OOP principles** — each screen is a separate class with clear responsibility

---

## 🚀 Future Enhancements

- [ ] Change PIN functionality
- [ ] Fund transfer between accounts
- [ ] Print receipt feature
- [ ] Admin panel for account management
- [ ] Email notification on transactions
- [ ] Account creation from the application itself

---

## 👨‍💻 Author

**Shyam Kumar Sharma**
- 💼 LinkedIn: [linkedin.com/in/shyamkumar97](https://linkedin.com/in/shyamkumar97)
- 💻 GitHub Profile: [github.com/Shyam97099](https://github.com/Shyam97099)
- 📧 Email: shyamkumarsharma069@gmail.com

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ If you found this project helpful, please give it a star on GitHub!

