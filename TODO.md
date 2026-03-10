# MSME Digital Lending Sandbox — Java & JavaFX Conversion TODO List

## Phase 1: Project Setup & Architecture
- [ ] Initialize a Maven Multi-Module Project:
  - `lending-backend` (Spring Boot API)
  - `lending-client-admin` (JavaFX Admin App)
  - `lending-client-borrower` (JavaFX Borrower App)
- [ ] Initialize Git repository (Done)
- [ ] Create `README.md` and document the project structure.

## Phase 2: Backend API (Spring Boot)
- [ ] Setup `application.properties` with PostgreSQL database connection URL, credentials, and `spring.jpa.hibernate.ddl-auto=update`.
- [ ] Implement JPA Entities (`@Entity` classes) mapped to tables:
  - [ ] `BorrowerProfile`
  - [ ] `LoanApplication`
  - [ ] (Others mapped from Python `models.py`)
- [ ] Create Spring Data JPA Repositories (e.g., `LoanApplicationRepository`).
- [ ] Implement Business Logic Services:
  - [ ] `RiskEngineService` (Calculate risk scores and evaluate applications based on debt-to-turnover ratio, etc.)
  - [ ] `AmortizationService` (Calculate EMI schedules)
- [ ] Build REST Controllers (`@RestController` mapping `/api/v1/loans/...`):
  - [ ] Auth Controller (Login/Register)
  - [ ] Borrower Controller
  - [ ] Admin Controller
- [ ] Configure Spring Security with JWT filters for securing endpoints.

## Phase 3: Client Application - Admin (JavaFX)
- [ ] Initialize `lending-client-admin` with `org.openjfx.javafx-archetype-fxml`.
- [ ] Set up HTTP Client logic to communicate with Spring Boot API endpoints.
- [ ] Design FXML Views using SceneBuilder:
  - [ ] `Dashboard.fxml`: Uses JavaFX `PieChart` and `LineChart` for Expenses vs. Revenue.
  - [ ] `LoanList.fxml`: Uses `TableView<LoanApplication>` to list and filter incoming loans.
  - [ ] `LoanDetail.fxml`: Detail view with action buttons for approving/rejecting statuses.
- [ ] Implement UI Controllers to map FXML elements to API data.

## Phase 4: Client Application - Borrower (JavaFX)
- [ ] Initialize `lending-client-borrower` JavaFX Maven project.
- [ ] Design FXML Views using SceneBuilder:
  - [ ] `Login.fxml`: Authentication screen.
  - [ ] `Profile.fxml`: Borrower profile details.
  - [ ] `ApplyLoan.fxml`: Form with `GridPane`, `TextField`s, and `ComboBox` for loan purpose.
- [ ] Implement UI Controllers and integrate API client services.
- [ ] Include styling via custom `.css` files (`scene.getStylesheets().add("styles.css")`) to match the web app colors.
- [ ] (Optional) Provide `Canvas` for capturing digital signatures via mouse events.

## Phase 5: Integration, Testing & Final Polish
- [ ] Test the End-to-End flow locally (Client -> API -> DB).
- [ ] Verify Risk Engine flags and correct application status transitions.
- [ ] Push updates to the GitHub repository.
