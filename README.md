# 🏧 Bank Management System — ATM Simulator

A desktop-based ATM Simulator application built with **Java** and **MySQL**, providing core banking operations through a secure card number and PIN-based authentication system.

---

## 📌 Project Description

The **Bank Management System** is a desktop application that simulates the core functionality of a real-world ATM machine. It is built using **Core Java** for business logic, **Java Swing** for the graphical user interface, **JDBC** for database connectivity, and **MySQL** for persistent data storage.

The application allows users to securely sign up and log in using their **card number** and **PIN number** — similar to how a real ATM works. Once authenticated, users can perform essential banking operations such as depositing money, withdrawing cash via fast cash options, checking balance, changing PIN, and viewing their mini statement which shows recent transaction history.

This project demonstrates strong understanding of:
- **Object-Oriented Programming (OOP)** — classes, encapsulation, and modular screen design
- **Database Design** — normalized MySQL schema for accounts and transactions
- **JDBC Connectivity** — real-time read/write operations between Java and MySQL
- **GUI Development** — interactive multi-screen desktop application using Java Swing
- **Validation Logic** — PIN authentication, balance checks before withdrawal, input validation

The system is designed to be simple, secure, and user-friendly — closely mimicking the experience of using a real ATM terminal.

---

## ✨ Features

- 📝 **User Signup** — Multi-step account registration (3 screens)
- 🔐 **Secure Login** — Authentication via Card Number and PIN
- 💰 **Deposit Money** — Add funds to your account instantly
- 💸 **Withdraw Money** — Withdraw cash with balance validation
- ⚡ **Fast Cash** — Quick withdrawal with preset amounts
- 🧾 **Mini Statement** — View recent transaction history
- 🔄 **Balance Enquiry** — Check current account balance
- 🔑 **PIN Change** — Update PIN securely
- 📊 **Transaction History** — Complete record of all transactions
- 🛡️ **PIN Validation** — Wrong PIN blocks unauthorized access

---

## 🖥️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core application logic and OOP |
| Java Swing | Desktop GUI — multi-screen forms and dialogs |
| JDBC | Database connectivity via Conn.java |
| MySQL | Data storage — accounts and transactions |

---

## 📂 Project Structure

```
Bank-Management-System/
│
├── src/
│   └── BankManagementSystem/
│       ├── Conn.java             → MySQL JDBC connection setup
│       ├── LoginPg.java          → Login screen — card number + PIN
│       ├── Signup.java           → Signup Step 1 — personal details
│       ├── SignupTwo.java        → Signup Step 2 — account details
│       ├── SignupThree.java      → Signup Step 3 — card + PIN setup
│       ├── Deposit.java          → Deposit money screen
│       ├── Withdrawl.java        → Withdraw money screen
│       ├── FastCash.java         → Fast cash quick withdrawal
│       ├── BalanceEnquiry.java   → Check account balance
│       ├── MiniStatement.java    → View recent transactions
│       ├── PinChange.java        → Change PIN screen
│       └── Transaction.java      → Transaction history screen
│
├── bin/                          → Compiled .class files
├── lib/                          → External libraries (MySQL connector)
└── README.md
```

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
    type             ENUM('DEPOSIT','WITHDRAWAL','FAST CASH'),
    amount           DECIMAL(10,2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (card_number) REFERENCES account(card_number)
);
```

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or above
- MySQL Server
- IntelliJ IDEA or Eclipse
- MySQL Connector JAR (already in lib/ folder)

### Steps

```bash
# Step 1 — Clone the repository
git clone https://github.com/Shyam97099/Bank-Management-System.git

# Step 2 — Open project in IntelliJ IDEA or Eclipse

# Step 3 — Setup MySQL Database
# Open MySQL Workbench and create database:
CREATE DATABASE bankmanagement;

# Step 4 — Update DB credentials in Conn.java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/bankmanagement",
    "root",
    "your_password"
);

# Step 5 — Add MySQL Connector JAR to classpath
# (Already present in lib/ folder)

# Step 6 — Run the project
# Right click LoginPg.java → Run
```

---

## 📸 Application Flow

```
Launch App
    ↓
┌─────────────────┐
│   Login Screen  │ ← LoginPg.java
│  Card No + PIN  │
└────────┬────────┘
         │ New User?
         ↓
┌─────────────────┐
│   Signup Step 1 │ ← Signup.java
│   Signup Step 2 │ ← SignupTwo.java
│   Signup Step 3 │ ← SignupThree.java
└────────┬────────┘
         │ Authenticated
         ↓
┌──────────────────────────────┐
│        ATM Dashboard         │
├──────────────────────────────┤
│  💰 Deposit                  │ ← Deposit.java
│  💸 Withdraw                 │ ← Withdrawl.java
│  ⚡ Fast Cash                │ ← FastCash.java
│  🔄 Balance Enquiry          │ ← BalanceEnquiry.java
│  🧾 Mini Statement           │ ← MiniStatement.java
│  📊 Transaction History      │ ← Transaction.java
│  🔑 PIN Change               │ ← PinChange.java
│  🚪 Exit                     │
└──────────────────────────────┘
```

---

## 🔒 Security Features

- 3-step signup process for proper account creation
- PIN-based authentication before any transaction
- Wrong PIN — access denied immediately
- Balance validation before withdrawal — prevents overdraft
- PIN change requires old PIN verification
- All transactions saved to MySQL with timestamp

---

## 💡 What I Learned

Building this project helped me strengthen my understanding of:

- Connecting Java applications to MySQL using **JDBC**
- Designing **multi-screen desktop applications** using Java Swing
- Building a **multi-step signup flow** — 3 screens with data passing between them
- Implementing **real-time data operations** — insert, update, select with JDBC
- Writing **validation logic** — PIN check, balance check, input validation
- Applying **OOP principles** — each screen is a separate class with single responsibility
- Managing **database connections** efficiently using a centralized Conn.java class

---

## 🚀 Future Enhancements

- [ ] Fund transfer between accounts
- [ ] Print receipt feature
- [ ] Admin panel for account management
- [ ] Email notification on transactions
- [ ] Account statement download as PDF
- [ ] Multi-language support

---

## 👨‍💻 Author

**Shyam Kumar Sharma**
- 💼 LinkedIn: [linkedin.com/in/shyamkumar97](https://linkedin.com/in/shyamkumar97)
- 💻 GitHub Profile: [github.com/Shyam97099](https://github.com/Shyam97099)
- 🏦 Project Repo: [Bank-Management-System](https://github.com/Shyam97099/Bank-Management-System)
- 📧 Email: shyamkumarsharma069@gmail.com

---



---

⭐ If you found this project helpful, please give it a star on [GitHub](https://github.com/Shyam97099/Bank-Management-System)!
