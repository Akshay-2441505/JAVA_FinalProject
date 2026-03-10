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
