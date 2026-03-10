# MSME Digital Lending Sandbox — Java & JavaFX Conversion TODO List

## Phase 1: Project Setup & Architecture
- [x] Initialize a Maven Multi-Module Project:
  - `lending-backend` (Spring Boot API)
  - `lending-client-admin` (JavaFX Admin App)
  - `lending-client-borrower` (JavaFX Borrower App)
- [ ] Initialize Git repository (Done)
- [ ] Create `README.md` and document the project structure.

## Phase 2: Backend API (Spring Boot)
- [x] Setup `application.properties` with PostgreSQL database connection URL, credentials, and `spring.jpa.hibernate.ddl-auto=update`.
- [x] Implement JPA Entities (`@Entity` classes) mapped to tables:
  - [x] `BorrowerProfile`
  - [x] `LoanApplication`
  - [x] (Others mapped from Python `models.py`)
- [x] Create Spring Data JPA Repositories (e.g., `LoanApplicationRepository`).
- [x] Implement Business Logic Services:
  - [x] `RiskEngineService` (Calculate risk scores and evaluate applications based on debt-to-turnover ratio, etc.)
  - [x] `AmortizationService` (Calculate EMI schedules)
- [x] Build REST Controllers (`@RestController` mapping `/api/v1/loans/...`):
  - [x] Auth Controller (Login/Register)
  - [x] Borrower Controller
  - [x] Admin Controller
- [x] Configure Spring Security with JWT filters for securing endpoints.

## Phase 3: Client Application - Admin (JavaFX)
- [x] Initialize `lending-client-admin` with `org.openjfx.javafx-archetype-fxml`.
- [x] Set up HTTP Client logic to communicate with Spring Boot API endpoints.
- [x] Design FXML Views using SceneBuilder:
  - [x] `Dashboard.fxml`: Uses JavaFX `PieChart` and `LineChart` for Expenses vs. Revenue.
  - [x] `LoanList.fxml`: Uses `TableView<LoanApplication>` to list and filter incoming loans.
  - [x] `LoanDetail.fxml`: Detail view with action buttons for approving/rejecting statuses.
- [x] Implement UI Controllers to map FXML elements to API data.
- [x] **UI Polish (Admin)**: Integrate a modern UI library like **AtlantaFX** or **JFoenix** for a sleek, professional Material/modern design. Implement responsive layouts (AnchorPane/BorderPane), smooth transitions, drop shadows, and high-quality charts.

## Phase 4: Client Application - Borrower (JavaFX)
- [ ] Initialize `lending-client-borrower` JavaFX Maven project.
- [ ] Design FXML Views using SceneBuilder:
  - [ ] `Login.fxml`: Authentication screen.
  - [ ] `Profile.fxml`: Borrower profile details.
  - [ ] `ApplyLoan.fxml`: Form with `GridPane`, `TextField`s, and `ComboBox` for loan purpose.
- [ ] Implement UI Controllers and integrate API client services.
- [ ] **UI Polish (Borrower)**: Include styling via custom `.css` files and **AtlantaFX** to match the modern web app experience. Focus on a sexy, premium look with vibrant colors, hover animations, curved buttons, and glassmorphism styling where applicable.
- [ ] (Optional) Provide `Canvas` for capturing digital signatures via mouse events.

## Phase 5: Integration, Testing & Final Polish
- [ ] Test the End-to-End flow locally (Client -> API -> DB).
- [ ] Verify Risk Engine flags and correct application status transitions.
- [ ] Push updates to the GitHub repository.
