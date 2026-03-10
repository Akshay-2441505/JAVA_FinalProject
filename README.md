# MSME Digital Lending Sandbox — Java & JavaFX 

This is the Java/JavaFX rewrite of the MSME Digital Lending Sandbox. We are migrating the architecture from a combined Python/Flutter/React stack into a unified Java ecosystem. 

## Tech Stack
- **Backend API:** Spring Boot (Java 21)
- **Database:** PostgreSQL (Spring Data JPA)
- **Borrower & Admin Clients:** JavaFX 
- **UI Frameworks:** AtlantaFX (for a modern, sexy, premium user interface)

## UI Guidelines
The primary focus of the JavaFX client apps is delivering an exceptionally **sexy and professional User Interface**. As detailed in the `TODO.md`:
- We use [AtlantaFX](https://mkpaz.github.io/atlantafx/) or comparable modern styling layers to prevent the typical "enterprise Java" look.
- Expect vibrant colors, drop shadows, responsive scaling, subtle animations, and glassmorphism themes where appropriate.

## Repository Setup
Review `java_conversion_plan.md.resolved` for the base architecture map and check `TODO.md` for the current progress and granular steps.

## How to Run

### 1. Prerequisites
- **Java 21** or later installed.
- **Maven** installed and added to your systemic PATH.
- No database installation required! This sandbox uses an **embedded H2 database** that spins up automatically in-memory.

### 2. Start the Backend API (Spring Boot)
Open a terminal in the root project directory and run:

```bash
cd lending-backend
..\.maven\apache-maven-3.9.6\bin\mvn.cmd spring-boot:run
```
*The API will start on `http://localhost:8080`. The embedded H2 database schema will be auto-generated in memory, which you can access via `http://localhost:8080/h2-console` with username `sa` and password `password`.*

### 3. Start the Admin App (JavaFX)
Open a new terminal window at the root project directory:

```bash
cd lending-client-admin
..\.maven\apache-maven-3.9.6\bin\mvn.cmd clean javafx:run
```

### 4. Start the Borrower App (JavaFX)
Open a new terminal window at the root project directory:

```bash
cd lending-client-borrower
..\.maven\apache-maven-3.9.6\bin\mvn.cmd clean javafx:run
```

