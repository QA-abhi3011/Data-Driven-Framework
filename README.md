# Selenium Data-Driven Automation Framework

A scalable and maintainable Selenium automation framework built using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**. The framework supports **data-driven testing, parallel execution, environment-specific configurations, Extent Reports, and GitHub Actions CI/CD** with automatic publishing of the latest execution report to GitHub Pages.

---

## 🚀 Features

- Selenium WebDriver 4
- Java 17
- TestNG
- Maven
- Page Object Model (POM)
- Data-Driven Testing using Excel (Apache POI)
- Thread-safe WebDriver management using ThreadLocal
- Parallel Test Execution
- Cross Browser Support
- Environment-specific Configuration
- Retry Analyzer
- Explicit Wait utilities
- Extent Reports
- Automatic Screenshot Capture on Test Failure
- GitHub Actions CI/CD
- Automatic Publishing of Latest Extent Report to GitHub Pages

---

# 🏗 Project Structure

```text
Data-Driven-Framework
│
├── .github
│   └── workflows
│       └── data-driven-framework.yml
│
├── src
│   └── test
│       ├── java
│       │
│       ├── pageObjects
│       │   ├── BasePage.java
│       │   ├── LoginPage.java
│       │   ├── FileUploadPage.java
│       │   └── DynamicTablePage.java
│       │
│       ├── testCases
│       │   ├── BaseClass.java
│       │   ├── LoginTest.java
│       │   ├── FileUploadTest.java
│       │   └── DynamicTableTest.java
│       │
│       └── utilities
│           ├── BrowserUtils.java
│           ├── ConfigReader.java
│           ├── DriverFactory.java
│           ├── ExcelReader.java
│           ├── TestDataProvider.java
│           ├── RetryAnalyzer.java
│           ├── ScreenshotUtils.java
│           ├── ReportingManager.java
│           ├── ReportingFactory.java
│           └── ExtentListener.java
│
├── src
│   └── test
│       └── resources
│           ├── Config-QA.properties
│           ├── Config-Prod.properties
│           ├── Config-CI.properties
│           ├── TestData.xlsx
│           └── TestFiles
│
├── pom.xml
├── testNG.xml
├── README.md
└── .gitignore
```

---

# ⚙ Framework Architecture

## Driver Management

The framework uses **ThreadLocal<WebDriver>** to provide a separate WebDriver instance for every executing thread, enabling safe parallel execution without driver conflicts.

**Key Components**

- BrowserUtils
- DriverFactory
- BaseClass

---

## Page Object Model

Each page class contains:

- Element Locators
- Page Methods
- Business Actions

The BasePage class provides reusable methods such as:

- click()
- type()
- getText()
- isDisplayed()

along with centralized Explicit Wait utilities.

---

## Data-Driven Testing

Test data is maintained in an Excel workbook.

```
src/test/resources/TestData.xlsx
```

Apache POI is used to read Excel data while TestNG DataProviders supply test data during execution.

---

## Environment-Specific Configuration

The framework supports multiple execution environments.

Configuration files:

```
Config-QA.properties
Config-Prod.properties
Config-CI.properties
```

Environment can be selected during execution:

```bash
mvn clean test -Denv=QA
```

```bash
mvn clean test -Denv=Prod
```

```bash
mvn clean test -Denv=CI
```

---

## Browser Configuration

Supports execution on:

- Chrome
- Edge
- Firefox

Browser settings can be configured through the properties file.

Supported browser modes:

- Headless
- Incognito / Private

---

## Parallel Execution

The framework supports parallel execution using TestNG.

Thread safety is achieved using:

- ThreadLocal WebDriver
- DriverFactory
- Parallel TestNG Suite

---

## Retry Mechanism

RetryAnalyzer automatically retries failed test cases to handle intermittent failures caused by:

- Temporary browser instability
- Dynamic page loading
- Network latency

---

## Reporting

Extent Reports provide:

- Test execution summary
- Pass / Fail status
- Exception details
- Screenshot attachment for failed tests
- Execution information

---

## Screenshot Capture

Screenshots are automatically captured whenever a test fails.

Captured screenshots are attached to the Extent Report for easier debugging.

---

# 🔄 GitHub Actions CI/CD

The framework is integrated with GitHub Actions for continuous integration.

The pipeline performs the following steps:

- Checkout Repository
- Setup Java
- Cache Maven Dependencies
- Execute Test Suite
- Generate Extent Report
- Upload Reports as Workflow Artifacts
- Publish Latest Extent Report to GitHub Pages

Workflow triggers:

- Push
- Pull Request
- Scheduled Execution
- Manual Execution (`workflow_dispatch`)

---

# 📊 Live Automation Report

The latest execution report is automatically published after every GitHub Actions workflow execution.

### Latest Extent Report

➡️ **[View Latest Extent Report](https://qa-abhi3011.github.io/Data-Driven-Framework/)**

---

# 📦 Runtime Generated Artifacts

The following directories are generated automatically during execution and are **not committed** to the repository.

```
reports/
```

Generated after every execution.

Contains:

- Extent Report
- HTML report assets

---

```
screenshots/
```

Generated automatically whenever a test fails.

---

# ▶ Running the Framework

Clone the repository

```bash
git clone https://github.com/QA-abhi3011/Data-Driven-Framework.git
```

Navigate to the project

```bash
cd Data-Driven-Framework
```

Execute using default configuration

```bash
mvn clean test
```

Execute using QA environment

```bash
mvn clean test -Denv=QA
```

Execute using Production environment

```bash
mvn clean test -Denv=Prod
```

Execute using CI configuration

```bash
mvn clean test -Denv=CI
```

---

# 🧪 Current Automated Test Coverage

Implemented test scenarios:

- Login Functionality
- File Upload using `sendKeys()`
- Dynamic Table Validation

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Selenium WebDriver | UI Automation |
| TestNG | Test Execution |
| Maven | Build Management |
| Apache POI | Excel Data Handling |
| WebDriverManager | Browser Driver Management |
| Extent Reports | Reporting |
| GitHub Actions | Continuous Integration |
| GitHub Pages | Live Report Hosting |

---

# 📐 Design Patterns & Framework Practices

The framework incorporates:

- Page Object Model (POM)
- ThreadLocal WebDriver Management
- Utility Class Pattern
- Data Provider Pattern

---

# 🔮 Future Enhancements

- Implement soft assertions with consolidated failure reporting.
- Introduce custom annotations for test categorization (Smoke, Regression, Sanity).
- Add configurable execution logging using Log4j2 or SLF4J.
- Jenkins Pipeline
- Automatic report notification via Email or Slack.

---

# 👨‍💻 Author

**Abhishek Gautam**

Automation Test Engineer

GitHub: https://github.com/QA-abhi3011