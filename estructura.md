# Estructura de: Challenge

```
Challenge/
├── .vscode
│   └── settings.json
├── accounts_movements_service
│   └── accounts_movements_service
│       ├── .gradle
│       │   ├── 8.14.4
│       │   │   ├── checksums
│       │   │   │   ├── checksums.lock
│       │   │   │   ├── md5-checksums.bin
│       │   │   │   └── sha1-checksums.bin
│       │   │   ├── executionHistory
│       │   │   │   ├── executionHistory.bin
│       │   │   │   └── executionHistory.lock
│       │   │   ├── expanded
│       │   │   │   └── expanded.lock
│       │   │   ├── fileChanges
│       │   │   │   └── last-build.bin
│       │   │   ├── fileHashes
│       │   │   │   ├── fileHashes.bin
│       │   │   │   ├── fileHashes.lock
│       │   │   │   └── resourceHashesCache.bin
│       │   │   ├── vcsMetadata
│       │   │   └── gc.properties
│       │   ├── buildOutputCleanup
│       │   │   ├── buildOutputCleanup.lock
│       │   │   ├── cache.properties
│       │   │   └── outputFiles.bin
│       │   ├── vcs-1
│       │   │   └── gc.properties
│       │   └── file-system.probe
│       ├── build
│       │   ├── classes
│       │   │   └── java
│       │   │       ├── main
│       │   │       │   └── com
│       │   │       │       └── challenge
│       │   │       │           ├── accounts_movement_service
│       │   │       │           │   └── infrastructure
│       │   │       │           │       ├── input
│       │   │       │           │       │   └── adapter
│       │   │       │           │       │       └── rest
│       │   │       │           │       │           └── customer_service
│       │   │       │           │       │               ├── bean
│       │   │       │           │       │               │   ├── AccountBase.class
│       │   │       │           │       │               │   ├── AccountResponse.class
│       │   │       │           │       │               │   ├── AccountStatementAccount.class
│       │   │       │           │       │               │   ├── AccountStatementReport.class
│       │   │       │           │       │               │   ├── AccountType.class
│       │   │       │           │       │               │   ├── ApiError.class
│       │   │       │           │       │               │   ├── ApiErrorDetailsInner.class
│       │   │       │           │       │               │   ├── CreateAccountRequest.class
│       │   │       │           │       │               │   ├── CreateMovementRequest.class
│       │   │       │           │       │               │   ├── MovementBase.class
│       │   │       │           │       │               │   ├── MovementResponse.class
│       │   │       │           │       │               │   ├── MovementType.class
│       │   │       │           │       │               │   ├── PagedAccountsResponse.class
│       │   │       │           │       │               │   ├── PagedMovementsResponse.class
│       │   │       │           │       │               │   ├── UpdateAccountRequest.class
│       │   │       │           │       │               │   └── UpdateMovementRequest.class
│       │   │       │           │       │               ├── AccountsApi.class
│       │   │       │           │       │               ├── ApiUtil.class
│       │   │       │           │       │               ├── MovementsApi.class
│       │   │       │           │       │               └── ReportsApi.class
│       │   │       │           │       └── output
│       │   │       │           │           └── adapter
│       │   │       │           │               └── rest
│       │   │       │           │                   ├── auth
│       │   │       │           │                   │   ├── ApiKeyAuth.class
│       │   │       │           │                   │   ├── Authentication.class
│       │   │       │           │                   │   ├── HttpBasicAuth.class
│       │   │       │           │                   │   └── HttpBearerAuth.class
│       │   │       │           │                   ├── customer_service
│       │   │       │           │                   │   ├── bean
│       │   │       │           │                   │   │   ├── ApiError.class
│       │   │       │           │                   │   │   ├── ApiErrorDetailsInner.class
│       │   │       │           │                   │   │   ├── CreateCustomerRequest.class
│       │   │       │           │                   │   │   ├── Customer.class
│       │   │       │           │                   │   │   ├── CustomerFields.class
│       │   │       │           │                   │   │   ├── CustomerResponse.class
│       │   │       │           │                   │   │   ├── Gender.class
│       │   │       │           │                   │   │   ├── PagedCustomersResponse.class
│       │   │       │           │                   │   │   ├── PersonBase.class
│       │   │       │           │                   │   │   └── UpdateCustomerRequest.class
│       │   │       │           │                   │   ├── CustomersApi$1.class
│       │   │       │           │                   │   ├── CustomersApi$10.class
│       │   │       │           │                   │   ├── CustomersApi$11.class
│       │   │       │           │                   │   ├── CustomersApi$12.class
│       │   │       │           │                   │   ├── CustomersApi$13.class
│       │   │       │           │                   │   ├── CustomersApi$14.class
│       │   │       │           │                   │   ├── CustomersApi$15.class
│       │   │       │           │                   │   ├── CustomersApi$16.class
│       │   │       │           │                   │   ├── CustomersApi$17.class
│       │   │       │           │                   │   ├── CustomersApi$18.class
│       │   │       │           │                   │   ├── CustomersApi$19.class
│       │   │       │           │                   │   ├── CustomersApi$2.class
│       │   │       │           │                   │   ├── CustomersApi$20.class
│       │   │       │           │                   │   ├── CustomersApi$21.class
│       │   │       │           │                   │   ├── CustomersApi$22.class
│       │   │       │           │                   │   ├── CustomersApi$23.class
│       │   │       │           │                   │   ├── CustomersApi$24.class
│       │   │       │           │                   │   ├── CustomersApi$25.class
│       │   │       │           │                   │   ├── CustomersApi$3.class
│       │   │       │           │                   │   ├── CustomersApi$4.class
│       │   │       │           │                   │   ├── CustomersApi$5.class
│       │   │       │           │                   │   ├── CustomersApi$6.class
│       │   │       │           │                   │   ├── CustomersApi$7.class
│       │   │       │           │                   │   ├── CustomersApi$8.class
│       │   │       │           │                   │   ├── CustomersApi$9.class
│       │   │       │           │                   │   └── CustomersApi.class
│       │   │       │           │                   ├── ApiClient$CollectionFormat.class
│       │   │       │           │                   ├── ApiClient.class
│       │   │       │           │                   ├── JavaTimeFormatter.class
│       │   │       │           │                   ├── RFC3339DateFormat.class
│       │   │       │           │                   ├── ServerConfiguration.class
│       │   │       │           │                   ├── ServerVariable.class
│       │   │       │           │                   └── StringUtil.class
│       │   │       │           └── accounts_movements_service
│       │   │       │               └── AccountsMovementsServiceApplication.class
│       │   │       └── test
│       │   │           └── com
│       │   │               └── challenge
│       │   │                   └── accounts_movements_service
│       │   │                       └── AccountsMovementsServiceApplicationTests.class
│       │   ├── generated
│       │   │   ├── .github
│       │   │   │   └── workflows
│       │   │   │       └── maven.yml
│       │   │   ├── .openapi-generator
│       │   │   │   ├── FILES
│       │   │   │   └── VERSION
│       │   │   ├── api
│       │   │   │   └── openapi.yaml
│       │   │   ├── docs
│       │   │   │   ├── ApiError.md
│       │   │   │   ├── ApiErrorDetailsInner.md
│       │   │   │   ├── CreateCustomerRequest.md
│       │   │   │   ├── Customer.md
│       │   │   │   ├── CustomerFields.md
│       │   │   │   ├── CustomerResponse.md
│       │   │   │   ├── CustomersApi.md
│       │   │   │   ├── Gender.md
│       │   │   │   ├── PagedCustomersResponse.md
│       │   │   │   ├── PersonBase.md
│       │   │   │   └── UpdateCustomerRequest.md
│       │   │   ├── gradle
│       │   │   │   └── wrapper
│       │   │   │       ├── gradle-wrapper.jar
│       │   │   │       └── gradle-wrapper.properties
│       │   │   ├── sources
│       │   │   │   ├── annotationProcessor
│       │   │   │   │   └── java
│       │   │   │   │       ├── main
│       │   │   │   │       └── test
│       │   │   │   └── headers
│       │   │   │       └── java
│       │   │   │           ├── main
│       │   │   │           └── test
│       │   │   ├── src
│       │   │   │   ├── main
│       │   │   │   │   ├── java
│       │   │   │   │   │   └── com
│       │   │   │   │   │       └── challenge
│       │   │   │   │   │           └── accounts_movement_service
│       │   │   │   │   │               └── infrastructure
│       │   │   │   │   │                   ├── input
│       │   │   │   │   │                   │   └── adapter
│       │   │   │   │   │                   │       └── rest
│       │   │   │   │   │                   │           └── customer_service
│       │   │   │   │   │                   │               ├── bean
│       │   │   │   │   │                   │               │   ├── AccountBase.java
│       │   │   │   │   │                   │               │   ├── AccountResponse.java
│       │   │   │   │   │                   │               │   ├── AccountStatementAccount.java
│       │   │   │   │   │                   │               │   ├── AccountStatementReport.java
│       │   │   │   │   │                   │               │   ├── AccountType.java
│       │   │   │   │   │                   │               │   ├── ApiError.java
│       │   │   │   │   │                   │               │   ├── ApiErrorDetailsInner.java
│       │   │   │   │   │                   │               │   ├── CreateAccountRequest.java
│       │   │   │   │   │                   │               │   ├── CreateMovementRequest.java
│       │   │   │   │   │                   │               │   ├── MovementBase.java
│       │   │   │   │   │                   │               │   ├── MovementResponse.java
│       │   │   │   │   │                   │               │   ├── MovementType.java
│       │   │   │   │   │                   │               │   ├── PagedAccountsResponse.java
│       │   │   │   │   │                   │               │   ├── PagedMovementsResponse.java
│       │   │   │   │   │                   │               │   ├── UpdateAccountRequest.java
│       │   │   │   │   │                   │               │   └── UpdateMovementRequest.java
│       │   │   │   │   │                   │               ├── AccountsApi.java
│       │   │   │   │   │                   │               ├── ApiUtil.java
│       │   │   │   │   │                   │               ├── MovementsApi.java
│       │   │   │   │   │                   │               └── ReportsApi.java
│       │   │   │   │   │                   └── output
│       │   │   │   │   │                       └── adapter
│       │   │   │   │   │                           └── rest
│       │   │   │   │   │                               ├── auth
│       │   │   │   │   │                               │   ├── ApiKeyAuth.java
│       │   │   │   │   │                               │   ├── Authentication.java
│       │   │   │   │   │                               │   ├── HttpBasicAuth.java
│       │   │   │   │   │                               │   └── HttpBearerAuth.java
│       │   │   │   │   │                               ├── customer_service
│       │   │   │   │   │                               │   ├── bean
│       │   │   │   │   │                               │   │   ├── ApiError.java
│       │   │   │   │   │                               │   │   ├── ApiErrorDetailsInner.java
│       │   │   │   │   │                               │   │   ├── CreateCustomerRequest.java
│       │   │   │   │   │                               │   │   ├── Customer.java
│       │   │   │   │   │                               │   │   ├── CustomerFields.java
│       │   │   │   │   │                               │   │   ├── CustomerResponse.java
│       │   │   │   │   │                               │   │   ├── Gender.java
│       │   │   │   │   │                               │   │   ├── PagedCustomersResponse.java
│       │   │   │   │   │                               │   │   ├── PersonBase.java
│       │   │   │   │   │                               │   │   └── UpdateCustomerRequest.java
│       │   │   │   │   │                               │   └── CustomersApi.java
│       │   │   │   │   │                               ├── ApiClient.java
│       │   │   │   │   │                               ├── JavaTimeFormatter.java
│       │   │   │   │   │                               ├── RFC3339DateFormat.java
│       │   │   │   │   │                               ├── ServerConfiguration.java
│       │   │   │   │   │                               ├── ServerVariable.java
│       │   │   │   │   │                               └── StringUtil.java
│       │   │   │   │   └── AndroidManifest.xml
│       │   │   │   └── test
│       │   │   │       └── java
│       │   │   │           └── com
│       │   │   │               └── challenge
│       │   │   │                   └── accounts_movement_service
│       │   │   │                       └── infrastructure
│       │   │   │                           └── output
│       │   │   │                               └── adapter
│       │   │   │                                   └── rest
│       │   │   │                                       └── customer_service
│       │   │   │                                           ├── bean
│       │   │   │                                           │   ├── ApiErrorDetailsInnerTest.java
│       │   │   │                                           │   ├── ApiErrorTest.java
│       │   │   │                                           │   ├── CreateCustomerRequestTest.java
│       │   │   │                                           │   ├── CustomerFieldsTest.java
│       │   │   │                                           │   ├── CustomerResponseTest.java
│       │   │   │                                           │   ├── CustomerTest.java
│       │   │   │                                           │   ├── GenderTest.java
│       │   │   │                                           │   ├── PagedCustomersResponseTest.java
│       │   │   │                                           │   ├── PersonBaseTest.java
│       │   │   │                                           │   └── UpdateCustomerRequestTest.java
│       │   │   │                                           └── CustomersApiTest.java
│       │   │   ├── .gitignore
│       │   │   ├── .openapi-generator-ignore
│       │   │   ├── .travis.yml
│       │   │   ├── build.gradle
│       │   │   ├── build.sbt
│       │   │   ├── git_push.sh
│       │   │   ├── gradle.properties
│       │   │   ├── gradlew
│       │   │   ├── gradlew.bat
│       │   │   ├── pom.xml
│       │   │   ├── README.md
│       │   │   └── settings.gradle
│       │   ├── jacoco
│       │   │   └── test.exec
│       │   ├── libs
│       │   │   ├── accounts_movements_service-0.0.1-SNAPSHOT-plain.jar
│       │   │   └── accounts_movements_service-0.0.1-SNAPSHOT.jar
│       │   ├── reports
│       │   │   ├── jacoco
│       │   │   │   └── test
│       │   │   │       ├── html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.input.adapter.rest.customer_service
│       │   │   │       │   │   ├── ApiUtil.html
│       │   │   │       │   │   ├── ApiUtil.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.input.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── AccountBase.html
│       │   │   │       │   │   ├── AccountBase.java.html
│       │   │   │       │   │   ├── AccountResponse.html
│       │   │   │       │   │   ├── AccountResponse.java.html
│       │   │   │       │   │   ├── AccountStatementAccount.html
│       │   │   │       │   │   ├── AccountStatementAccount.java.html
│       │   │   │       │   │   ├── AccountStatementReport.html
│       │   │   │       │   │   ├── AccountStatementReport.java.html
│       │   │   │       │   │   ├── AccountType.html
│       │   │   │       │   │   ├── AccountType.java.html
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateAccountRequest.html
│       │   │   │       │   │   ├── CreateAccountRequest.java.html
│       │   │   │       │   │   ├── CreateMovementRequest.html
│       │   │   │       │   │   ├── CreateMovementRequest.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementBase.html
│       │   │   │       │   │   ├── MovementBase.java.html
│       │   │   │       │   │   ├── MovementResponse.html
│       │   │   │       │   │   ├── MovementResponse.java.html
│       │   │   │       │   │   ├── MovementType.html
│       │   │   │       │   │   ├── MovementType.java.html
│       │   │   │       │   │   ├── PagedAccountsResponse.html
│       │   │   │       │   │   ├── PagedAccountsResponse.java.html
│       │   │   │       │   │   ├── PagedMovementsResponse.html
│       │   │   │       │   │   ├── PagedMovementsResponse.java.html
│       │   │   │       │   │   ├── UpdateAccountRequest.html
│       │   │   │       │   │   ├── UpdateAccountRequest.java.html
│       │   │   │       │   │   ├── UpdateMovementRequest.html
│       │   │   │       │   │   └── UpdateMovementRequest.java.html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.output.adapter.rest
│       │   │   │       │   │   ├── ApiClient$CollectionFormat.html
│       │   │   │       │   │   ├── ApiClient.html
│       │   │   │       │   │   ├── ApiClient.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── JavaTimeFormatter.html
│       │   │   │       │   │   ├── JavaTimeFormatter.java.html
│       │   │   │       │   │   ├── RFC3339DateFormat.html
│       │   │   │       │   │   ├── RFC3339DateFormat.java.html
│       │   │   │       │   │   ├── ServerConfiguration.html
│       │   │   │       │   │   ├── ServerConfiguration.java.html
│       │   │   │       │   │   ├── ServerVariable.html
│       │   │   │       │   │   ├── ServerVariable.java.html
│       │   │   │       │   │   ├── StringUtil.html
│       │   │   │       │   │   └── StringUtil.java.html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.output.adapter.rest.auth
│       │   │   │       │   │   ├── ApiKeyAuth.html
│       │   │   │       │   │   ├── ApiKeyAuth.java.html
│       │   │   │       │   │   ├── HttpBasicAuth.html
│       │   │   │       │   │   ├── HttpBasicAuth.java.html
│       │   │   │       │   │   ├── HttpBearerAuth.html
│       │   │   │       │   │   ├── HttpBearerAuth.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.output.adapter.rest.customer_service
│       │   │   │       │   │   ├── CustomersApi$1.html
│       │   │   │       │   │   ├── CustomersApi$10.html
│       │   │   │       │   │   ├── CustomersApi$11.html
│       │   │   │       │   │   ├── CustomersApi$12.html
│       │   │   │       │   │   ├── CustomersApi$13.html
│       │   │   │       │   │   ├── CustomersApi$14.html
│       │   │   │       │   │   ├── CustomersApi$15.html
│       │   │   │       │   │   ├── CustomersApi$16.html
│       │   │   │       │   │   ├── CustomersApi$17.html
│       │   │   │       │   │   ├── CustomersApi$18.html
│       │   │   │       │   │   ├── CustomersApi$19.html
│       │   │   │       │   │   ├── CustomersApi$2.html
│       │   │   │       │   │   ├── CustomersApi$20.html
│       │   │   │       │   │   ├── CustomersApi$21.html
│       │   │   │       │   │   ├── CustomersApi$22.html
│       │   │   │       │   │   ├── CustomersApi$23.html
│       │   │   │       │   │   ├── CustomersApi$24.html
│       │   │   │       │   │   ├── CustomersApi$25.html
│       │   │   │       │   │   ├── CustomersApi$3.html
│       │   │   │       │   │   ├── CustomersApi$4.html
│       │   │   │       │   │   ├── CustomersApi$5.html
│       │   │   │       │   │   ├── CustomersApi$6.html
│       │   │   │       │   │   ├── CustomersApi$7.html
│       │   │   │       │   │   ├── CustomersApi$8.html
│       │   │   │       │   │   ├── CustomersApi$9.html
│       │   │   │       │   │   ├── CustomersApi.html
│       │   │   │       │   │   ├── CustomersApi.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movement_service.infrastructure.output.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateCustomerRequest.html
│       │   │   │       │   │   ├── CreateCustomerRequest.java.html
│       │   │   │       │   │   ├── Customer.html
│       │   │   │       │   │   ├── Customer.java.html
│       │   │   │       │   │   ├── CustomerFields.html
│       │   │   │       │   │   ├── CustomerFields.java.html
│       │   │   │       │   │   ├── CustomerResponse.html
│       │   │   │       │   │   ├── CustomerResponse.java.html
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedCustomersResponse.html
│       │   │   │       │   │   ├── PagedCustomersResponse.java.html
│       │   │   │       │   │   ├── PersonBase.html
│       │   │   │       │   │   ├── PersonBase.java.html
│       │   │   │       │   │   ├── UpdateCustomerRequest.html
│       │   │   │       │   │   └── UpdateCustomerRequest.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service
│       │   │   │       │   │   ├── AccountsMovementsServiceApplication.html
│       │   │   │       │   │   ├── AccountsMovementsServiceApplication.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── jacoco-resources
│       │   │   │       │   │   ├── branchfc.gif
│       │   │   │       │   │   ├── branchnc.gif
│       │   │   │       │   │   ├── branchpc.gif
│       │   │   │       │   │   ├── bundle.gif
│       │   │   │       │   │   ├── class.gif
│       │   │   │       │   │   ├── down.gif
│       │   │   │       │   │   ├── greenbar.gif
│       │   │   │       │   │   ├── group.gif
│       │   │   │       │   │   ├── method.gif
│       │   │   │       │   │   ├── package.gif
│       │   │   │       │   │   ├── prettify.css
│       │   │   │       │   │   ├── prettify.js
│       │   │   │       │   │   ├── redbar.gif
│       │   │   │       │   │   ├── report.css
│       │   │   │       │   │   ├── report.gif
│       │   │   │       │   │   ├── session.gif
│       │   │   │       │   │   ├── sort.gif
│       │   │   │       │   │   ├── sort.js
│       │   │   │       │   │   ├── source.gif
│       │   │   │       │   │   └── up.gif
│       │   │   │       │   ├── index.html
│       │   │   │       │   └── jacoco-sessions.html
│       │   │   │       ├── jacocoTestReport.csv
│       │   │   │       └── jacocoTestReport.xml
│       │   │   ├── problems
│       │   │   │   └── problems-report.html
│       │   │   └── tests
│       │   │       └── test
│       │   │           ├── classes
│       │   │           │   └── com.challenge.accounts_movements_service.AccountsMovementsServiceApplicationTests.html
│       │   │           ├── css
│       │   │           │   ├── base-style.css
│       │   │           │   └── style.css
│       │   │           ├── js
│       │   │           │   └── report.js
│       │   │           ├── packages
│       │   │           │   └── com.challenge.accounts_movements_service.html
│       │   │           └── index.html
│       │   ├── resources
│       │   │   ├── main
│       │   │   │   ├── META-INF
│       │   │   │   │   └── build-info.properties
│       │   │   │   ├── openapi-templates
│       │   │   │   │   ├── client
│       │   │   │   │   │   ├── api.mustache
│       │   │   │   │   │   └── ApiClient.mustache
│       │   │   │   │   └── bodyParams.mustache
│       │   │   │   ├── application.yaml
│       │   │   │   ├── customer_service.yaml
│       │   │   │   └── openapi.yaml
│       │   │   └── test
│       │   │       ├── application-test.yaml
│       │   │       └── schema.sql
│       │   ├── test-results
│       │   │   └── test
│       │   │       ├── binary
│       │   │       │   ├── output.bin
│       │   │       │   ├── output.bin.idx
│       │   │       │   └── results.bin
│       │   │       └── TEST-com.challenge.accounts_movements_service.AccountsMovementsServiceApplicationTests.xml
│       │   ├── tmp
│       │   │   ├── .cache
│       │   │   │   └── expanded
│       │   │   │       └── zip_9892ccb804f78c0637616b68610d363f
│       │   │   │           ├── META-INF
│       │   │   │           │   ├── maven
│       │   │   │           │   │   └── org.jacoco
│       │   │   │           │   │       └── org.jacoco.agent
│       │   │   │           │   │           ├── pom.properties
│       │   │   │           │   │           └── pom.xml
│       │   │   │           │   └── MANIFEST.MF
│       │   │   │           ├── org
│       │   │   │           │   └── jacoco
│       │   │   │           │       └── agent
│       │   │   │           │           ├── AgentJar.class
│       │   │   │           │           └── package-info.class
│       │   │   │           ├── about.html
│       │   │   │           └── jacocoagent.jar
│       │   │   ├── bootJar
│       │   │   │   └── MANIFEST.MF
│       │   │   ├── compileJava
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── compileTestJava
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── jacocoTestCoverageVerification
│       │   │   │   └── success.txt
│       │   │   ├── jar
│       │   │   │   └── MANIFEST.MF
│       │   │   └── test
│       │   └── resolvedMainClassName
│       ├── gradle
│       │   └── wrapper
│       │       ├── gradle-wrapper.jar
│       │       └── gradle-wrapper.properties
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── challenge
│       │   │   │           └── accounts_movements_service
│       │   │   │               ├── application
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── AccountInputPort.java
│       │   │   │               │   │       ├── MovementInputPort.java
│       │   │   │               │   │       └── ReportInputPort.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── AccountRepositoryPort.java
│       │   │   │               │   │       ├── CustomerRepositoryPort.java
│       │   │   │               │   │       └── MovementRepositoryPort.java
│       │   │   │               │   ├── service
│       │   │   │               │   │   └── impl
│       │   │   │               │   │       ├── AccountServiceImpl.java
│       │   │   │               │   │       ├── MovementServiceImpl.java
│       │   │   │               │   │       └── ReportServiceImpl.java
│       │   │   │               │   └── util
│       │   │   │               │       └── PagedResult.java
│       │   │   │               ├── domain
│       │   │   │               │   ├── exception
│       │   │   │               │   │   ├── AccountInactiveException.java
│       │   │   │               │   │   ├── AccountNotFoundException.java
│       │   │   │               │   │   ├── CustomerNotFoundException.java
│       │   │   │               │   │   ├── DomainException.java
│       │   │   │               │   │   ├── DomainValidationException.java
│       │   │   │               │   │   ├── DownstreamServiceException.java
│       │   │   │               │   │   ├── DuplicatedAccountNumberException.java
│       │   │   │               │   │   ├── InsufficientFundsException.java
│       │   │   │               │   │   └── MovementNotFoundException.java
│       │   │   │               │   ├── model
│       │   │   │               │   │   ├── Account.java
│       │   │   │               │   │   ├── AccountStatementReport.java
│       │   │   │               │   │   ├── AccountStatementReportAccount.java
│       │   │   │               │   │   ├── AccountStatementReportMovement.java
│       │   │   │               │   │   ├── AccountType.java
│       │   │   │               │   │   ├── Movement.java
│       │   │   │               │   │   └── MovementType.java
│       │   │   │               │   └── policy
│       │   │   │               │       └── MovementPolicy.java
│       │   │   │               ├── infrastructure
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── controller
│       │   │   │               │   │       │   ├── AccountsController.java
│       │   │   │               │   │       │   ├── MovementsController.java
│       │   │   │               │   │       │   └── ReportController.java
│       │   │   │               │   │       └── mapper
│       │   │   │               │   │           ├── AccountRestMapper.java
│       │   │   │               │   │           ├── MovementRestMapper.java
│       │   │   │               │   │           └── ReportRestMapper.java
│       │   │   │               │   └── output
│       │   │   │               │       └── adapter
│       │   │   │               │           ├── entity
│       │   │   │               │           │   ├── AccountEntity.java
│       │   │   │               │           │   └── MovementEntity.java
│       │   │   │               │           ├── mapper
│       │   │   │               │           │   ├── AccountJpaMapper.java
│       │   │   │               │           │   └── MovementJpaMapper.java
│       │   │   │               │           ├── repository
│       │   │   │               │           │   ├── AccountJpaRepository.java
│       │   │   │               │           │   └── MovementJpaRepository.java
│       │   │   │               │           ├── AccountRepositoryAdapter.java
│       │   │   │               │           └── MovementRepositoryAdapter.java
│       │   │   │               └── AccountsMovementsServiceApplication.java
│       │   │   └── resources
│       │   │       ├── openapi-templates
│       │   │       │   ├── client
│       │   │       │   │   ├── api.mustache
│       │   │       │   │   └── ApiClient.mustache
│       │   │       │   └── bodyParams.mustache
│       │   │       ├── application.yaml
│       │   │       ├── customer_service.yaml
│       │   │       └── openapi.yaml
│       │   └── test
│       │       ├── java
│       │       │   └── com
│       │       │       └── challenge
│       │       │           └── accounts_movements_service
│       │       │               └── AccountsMovementsServiceApplicationTests.java
│       │       └── resources
│       │           ├── application-test.yaml
│       │           └── schema.sql
│       ├── .gitattributes
│       ├── .gitignore
│       ├── build.gradle
│       ├── gradlew
│       ├── gradlew.bat
│       ├── HELP.md
│       └── settings.gradle
├── customer-service
│   └── customer-service
│       ├── .gradle
│       │   ├── 8.14.4
│       │   │   ├── checksums
│       │   │   │   ├── checksums.lock
│       │   │   │   ├── md5-checksums.bin
│       │   │   │   └── sha1-checksums.bin
│       │   │   ├── executionHistory
│       │   │   │   ├── executionHistory.bin
│       │   │   │   └── executionHistory.lock
│       │   │   ├── expanded
│       │   │   │   └── expanded.lock
│       │   │   ├── fileChanges
│       │   │   │   └── last-build.bin
│       │   │   ├── fileHashes
│       │   │   │   ├── fileHashes.bin
│       │   │   │   ├── fileHashes.lock
│       │   │   │   └── resourceHashesCache.bin
│       │   │   ├── vcsMetadata
│       │   │   └── gc.properties
│       │   ├── buildOutputCleanup
│       │   │   ├── buildOutputCleanup.lock
│       │   │   ├── cache.properties
│       │   │   └── outputFiles.bin
│       │   ├── vcs-1
│       │   │   └── gc.properties
│       │   └── file-system.probe
│       ├── .idea
│       │   ├── modules
│       │   │   ├── customer-service.main.iml
│       │   │   └── customer-service.test.iml
│       │   ├── .gitignore
│       │   ├── compiler.xml
│       │   ├── copilot.data.migration.agent.xml
│       │   ├── gradle.xml
│       │   ├── misc.xml
│       │   ├── modules.xml
│       │   └── workspace.xml
│       ├── build
│       │   ├── classes
│       │   │   └── java
│       │   │       ├── main
│       │   │       │   └── com
│       │   │       │       └── challenge
│       │   │       │           └── customer_service
│       │   │       │               ├── application
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── port
│       │   │       │               │   │       └── CustomerInputPort.class
│       │   │       │               │   ├── output
│       │   │       │               │   │   └── port
│       │   │       │               │   │       ├── CustomerRepositoryPort.class
│       │   │       │               │   │       └── PasswordHasherPort.class
│       │   │       │               │   ├── service
│       │   │       │               │   │   └── impl
│       │   │       │               │   │       └── CustomerServiceImpl.class
│       │   │       │               │   └── util
│       │   │       │               │       └── PagedResult.class
│       │   │       │               ├── domain
│       │   │       │               │   ├── exception
│       │   │       │               │   │   ├── CustomerNotFoundException.class
│       │   │       │               │   │   ├── DomainValidationException.class
│       │   │       │               │   │   └── DuplicatedIdentificationException.class
│       │   │       │               │   └── model
│       │   │       │               │       ├── Customer$CustomerBuilder.class
│       │   │       │               │       ├── Customer.class
│       │   │       │               │       ├── Gender.class
│       │   │       │               │       ├── Person$PersonBuilder.class
│       │   │       │               │       └── Person.class
│       │   │       │               ├── infrastructure
│       │   │       │               │   ├── exception
│       │   │       │               │   │   └── GlobalExceptionHandler.class
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── adapter
│       │   │       │               │   │       ├── controller
│       │   │       │               │   │       │   └── CustomersController.class
│       │   │       │               │   │       ├── mapper
│       │   │       │               │   │       │   ├── CustomerRestMapper$1.class
│       │   │       │               │   │       │   ├── CustomerRestMapper.class
│       │   │       │               │   │       │   └── CustomerRestMapperImpl.class
│       │   │       │               │   │       └── rest
│       │   │       │               │   │           └── customer_service
│       │   │       │               │   │               ├── bean
│       │   │       │               │   │               │   ├── ApiError.class
│       │   │       │               │   │               │   ├── ApiErrorDetailsInner.class
│       │   │       │               │   │               │   ├── CreateCustomerRequest.class
│       │   │       │               │   │               │   ├── Customer.class
│       │   │       │               │   │               │   ├── CustomerFields.class
│       │   │       │               │   │               │   ├── CustomerResponse.class
│       │   │       │               │   │               │   ├── Gender.class
│       │   │       │               │   │               │   ├── PagedCustomersResponse.class
│       │   │       │               │   │               │   ├── PersonBase.class
│       │   │       │               │   │               │   └── UpdateCustomerRequest.class
│       │   │       │               │   │               ├── ApiUtil.class
│       │   │       │               │   │               └── CustomersApi.class
│       │   │       │               │   └── output
│       │   │       │               │       └── adapter
│       │   │       │               │           ├── entity
│       │   │       │               │           │   ├── CustomerEntity.class
│       │   │       │               │           │   └── PersonEntity.class
│       │   │       │               │           ├── mapper
│       │   │       │               │           │   └── CustomerJpaMapper.class
│       │   │       │               │           ├── repository
│       │   │       │               │           │   ├── CustomerJpaRepository.class
│       │   │       │               │           │   └── PersonJpaRepository.class
│       │   │       │               │           ├── security
│       │   │       │               │           │   └── BCryptPasswordHasherAdapter.class
│       │   │       │               │           └── CustomeRepositoryAdapter.class
│       │   │       │               └── CustomerServiceApplication.class
│       │   │       └── test
│       │   │           └── com
│       │   │               └── challenge
│       │   │                   └── customer_service
│       │   │                       ├── application
│       │   │                       │   └── service
│       │   │                       │       └── impl
│       │   │                       │           └── CustomerServiceImplTest.class
│       │   │                       ├── domain
│       │   │                       │   ├── exception
│       │   │                       │   │   ├── CustomerNotFoundExceptionTest.class
│       │   │                       │   │   ├── DomainValidationExceptionTest.class
│       │   │                       │   │   └── DuplicatedIdentificationExceptionTest.class
│       │   │                       │   └── model
│       │   │                       │       ├── CustomerTest.class
│       │   │                       │       ├── GenderTest.class
│       │   │                       │       └── PersonTest.class
│       │   │                       ├── infrastructure
│       │   │                       │   ├── exception
│       │   │                       │   │   └── GlobalExceptionHandlerTest.class
│       │   │                       │   ├── input
│       │   │                       │   │   └── adapter
│       │   │                       │   │       └── controller
│       │   │                       │   │           └── CustomersControllerTest.class
│       │   │                       │   └── output
│       │   │                       │       └── adapter
│       │   │                       │           ├── entity
│       │   │                       │           │   ├── CustomerEntityTest.class
│       │   │                       │           │   └── PersonEntityTest.class
│       │   │                       │           ├── mapper
│       │   │                       │           │   └── CustomerJpaMapperTest.class
│       │   │                       │           ├── security
│       │   │                       │           │   └── BCryptPasswordHasherAdapterTest.class
│       │   │                       │           └── CustomeRepositoryAdapterTest.class
│       │   │                       ├── karate
│       │   │                       │   ├── KarateIT.class
│       │   │                       │   └── TestcontainersInitializer.class
│       │   │                       └── CustomerServiceApplicationTests.class
│       │   ├── generated
│       │   │   ├── .openapi-generator
│       │   │   │   ├── FILES
│       │   │   │   └── VERSION
│       │   │   ├── sources
│       │   │   │   ├── annotationProcessor
│       │   │   │   │   └── java
│       │   │   │   │       ├── main
│       │   │   │   │       │   └── com
│       │   │   │   │       │       └── challenge
│       │   │   │   │       │           └── customer_service
│       │   │   │   │       │               └── infrastructure
│       │   │   │   │       │                   └── input
│       │   │   │   │       │                       └── adapter
│       │   │   │   │       │                           └── mapper
│       │   │   │   │       │                               └── CustomerRestMapperImpl.java
│       │   │   │   │       └── test
│       │   │   │   └── headers
│       │   │   │       └── java
│       │   │   │           ├── main
│       │   │   │           └── test
│       │   │   ├── src
│       │   │   │   └── main
│       │   │   │       └── java
│       │   │   │           └── com
│       │   │   │               └── challenge
│       │   │   │                   └── customer_service
│       │   │   │                       └── infrastructure
│       │   │   │                           └── input
│       │   │   │                               └── adapter
│       │   │   │                                   └── rest
│       │   │   │                                       └── customer_service
│       │   │   │                                           ├── bean
│       │   │   │                                           │   ├── ApiError.java
│       │   │   │                                           │   ├── ApiErrorDetailsInner.java
│       │   │   │                                           │   ├── CreateCustomerRequest.java
│       │   │   │                                           │   ├── Customer.java
│       │   │   │                                           │   ├── CustomerFields.java
│       │   │   │                                           │   ├── CustomerResponse.java
│       │   │   │                                           │   ├── Gender.java
│       │   │   │                                           │   ├── PagedCustomersResponse.java
│       │   │   │                                           │   ├── PersonBase.java
│       │   │   │                                           │   └── UpdateCustomerRequest.java
│       │   │   │                                           ├── ApiUtil.java
│       │   │   │                                           └── CustomersApi.java
│       │   │   ├── .openapi-generator-ignore
│       │   │   ├── pom.xml
│       │   │   └── README.md
│       │   ├── jacoco
│       │   │   └── test.exec
│       │   ├── karate-reports
│       │   │   ├── res
│       │   │   │   ├── bootstrap.min.css
│       │   │   │   ├── bootstrap.min.js
│       │   │   │   ├── jquery-ui.min.js
│       │   │   │   ├── jquery.min.js
│       │   │   │   ├── jquery.tablesorter.min.js
│       │   │   │   ├── karate-report.css
│       │   │   │   ├── karate-report.js
│       │   │   │   ├── Resemble.js
│       │   │   │   ├── vis.min.css
│       │   │   │   └── vis.min.js
│       │   │   ├── com.challenge.customer_service.karate.customers.html
│       │   │   ├── com.challenge.customer_service.karate.customers.karate-json.txt
│       │   │   ├── favicon.ico
│       │   │   ├── karate-labs-logo-ring.svg
│       │   │   ├── karate-logo.png
│       │   │   ├── karate-logo.svg
│       │   │   ├── karate-summary-json.txt
│       │   │   ├── karate-summary.html
│       │   │   ├── karate-tags.html
│       │   │   └── karate-timeline.html
│       │   ├── libs
│       │   │   ├── customer-service-0.0.1-SNAPSHOT-plain.jar
│       │   │   └── customer-service-0.0.1-SNAPSHOT.jar
│       │   ├── reports
│       │   │   ├── jacoco
│       │   │   │   └── test
│       │   │   │       ├── html
│       │   │   │       │   ├── com.challenge.customer_service
│       │   │   │       │   │   ├── CustomerServiceApplication.html
│       │   │   │       │   │   ├── CustomerServiceApplication.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.application.service.impl
│       │   │   │       │   │   ├── CustomerServiceImpl.html
│       │   │   │       │   │   ├── CustomerServiceImpl.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.application.util
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedResult.html
│       │   │   │       │   │   └── PagedResult.java.html
│       │   │   │       │   ├── com.challenge.customer_service.domain.exception
│       │   │   │       │   │   ├── CustomerNotFoundException.html
│       │   │   │       │   │   ├── CustomerNotFoundException.java.html
│       │   │   │       │   │   ├── DomainValidationException.html
│       │   │   │       │   │   ├── DomainValidationException.java.html
│       │   │   │       │   │   ├── DuplicatedIdentificationException.html
│       │   │   │       │   │   ├── DuplicatedIdentificationException.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.domain.model
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.exception
│       │   │   │       │   │   ├── GlobalExceptionHandler.html
│       │   │   │       │   │   ├── GlobalExceptionHandler.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller
│       │   │   │       │   │   ├── CustomersController.html
│       │   │   │       │   │   ├── CustomersController.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.mapper
│       │   │   │       │   │   ├── CustomerRestMapper.html
│       │   │   │       │   │   ├── CustomerRestMapper.java.html
│       │   │   │       │   │   ├── CustomerRestMapperImpl.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service
│       │   │   │       │   │   ├── ApiUtil.html
│       │   │   │       │   │   ├── ApiUtil.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateCustomerRequest.html
│       │   │   │       │   │   ├── CreateCustomerRequest.java.html
│       │   │   │       │   │   ├── Customer.html
│       │   │   │       │   │   ├── Customer.java.html
│       │   │   │       │   │   ├── CustomerFields.html
│       │   │   │       │   │   ├── CustomerFields.java.html
│       │   │   │       │   │   ├── CustomerResponse.html
│       │   │   │       │   │   ├── CustomerResponse.java.html
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedCustomersResponse.html
│       │   │   │       │   │   ├── PagedCustomersResponse.java.html
│       │   │   │       │   │   ├── PersonBase.html
│       │   │   │       │   │   ├── PersonBase.java.html
│       │   │   │       │   │   ├── UpdateCustomerRequest.html
│       │   │   │       │   │   └── UpdateCustomerRequest.java.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter
│       │   │   │       │   │   ├── CustomeRepositoryAdapter.html
│       │   │   │       │   │   ├── CustomeRepositoryAdapter.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper
│       │   │   │       │   │   ├── CustomerJpaMapper.html
│       │   │   │       │   │   ├── CustomerJpaMapper.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter.security
│       │   │   │       │   │   ├── BCryptPasswordHasherAdapter.html
│       │   │   │       │   │   ├── BCryptPasswordHasherAdapter.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── jacoco-resources
│       │   │   │       │   │   ├── branchfc.gif
│       │   │   │       │   │   ├── branchnc.gif
│       │   │   │       │   │   ├── branchpc.gif
│       │   │   │       │   │   ├── bundle.gif
│       │   │   │       │   │   ├── class.gif
│       │   │   │       │   │   ├── down.gif
│       │   │   │       │   │   ├── greenbar.gif
│       │   │   │       │   │   ├── group.gif
│       │   │   │       │   │   ├── method.gif
│       │   │   │       │   │   ├── package.gif
│       │   │   │       │   │   ├── prettify.css
│       │   │   │       │   │   ├── prettify.js
│       │   │   │       │   │   ├── redbar.gif
│       │   │   │       │   │   ├── report.css
│       │   │   │       │   │   ├── report.gif
│       │   │   │       │   │   ├── session.gif
│       │   │   │       │   │   ├── sort.gif
│       │   │   │       │   │   ├── sort.js
│       │   │   │       │   │   ├── source.gif
│       │   │   │       │   │   └── up.gif
│       │   │   │       │   ├── index.html
│       │   │   │       │   └── jacoco-sessions.html
│       │   │   │       ├── jacocoTestReport.csv
│       │   │   │       └── jacocoTestReport.xml
│       │   │   ├── problems
│       │   │   │   └── problems-report.html
│       │   │   └── tests
│       │   │       └── test
│       │   │           ├── classes
│       │   │           │   ├── com.challenge.customer_service.application.service.impl.CustomerServiceImplTest.html
│       │   │           │   ├── com.challenge.customer_service.CustomerServiceApplicationTests.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.CustomerNotFoundExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.DomainValidationExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.DuplicatedIdentificationExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.CustomerTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.GenderTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.PersonTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.exception.GlobalExceptionHandlerTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller.CustomersControllerTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.CustomeRepositoryAdapterTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntityTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntityTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper.CustomerJpaMapperTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.security.BCryptPasswordHasherAdapterTest.html
│       │   │           │   └── com.challenge.customer_service.karate.KarateIT.html
│       │   │           ├── css
│       │   │           │   ├── base-style.css
│       │   │           │   └── style.css
│       │   │           ├── js
│       │   │           │   └── report.js
│       │   │           ├── packages
│       │   │           │   ├── com.challenge.customer_service.application.service.impl.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.html
│       │   │           │   ├── com.challenge.customer_service.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.exception.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.security.html
│       │   │           │   └── com.challenge.customer_service.karate.html
│       │   │           └── index.html
│       │   ├── resources
│       │   │   ├── main
│       │   │   │   ├── META-INF
│       │   │   │   │   └── build-info.properties
│       │   │   │   ├── openapi-templates
│       │   │   │   │   ├── client
│       │   │   │   │   │   ├── api.mustache
│       │   │   │   │   │   └── ApiClient.mustache
│       │   │   │   │   └── bodyParams.mustache
│       │   │   │   ├── application.yaml
│       │   │   │   └── openapi.yaml
│       │   │   └── test
│       │   │       ├── com
│       │   │       │   └── challenge
│       │   │       │       └── customer_service
│       │   │       │           └── karate
│       │   │       │               └── customers.feature
│       │   │       ├── application-test.yaml
│       │   │       ├── BaseDatos.sql
│       │   │       ├── karate-config.js
│       │   │       └── schema.sql
│       │   ├── test-results
│       │   │   └── test
│       │   │       ├── binary
│       │   │       │   ├── output.bin
│       │   │       │   ├── output.bin.idx
│       │   │       │   └── results.bin
│       │   │       ├── TEST-com.challenge.customer_service.application.service.impl.CustomerServiceImplTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.CustomerServiceApplicationTests.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.CustomerNotFoundExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.DomainValidationExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.DuplicatedIdentificationExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.CustomerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.GenderTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.PersonTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.exception.GlobalExceptionHandlerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.input.adapter.controller.CustomersControllerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.CustomeRepositoryAdapterTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntityTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntityTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.mapper.CustomerJpaMapperTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.security.BCryptPasswordHasherAdapterTest.xml
│       │   │       └── TEST-com.challenge.customer_service.karate.KarateIT.xml
│       │   ├── tmp
│       │   │   ├── .cache
│       │   │   │   └── expanded
│       │   │   │       └── zip_9892ccb804f78c0637616b68610d363f
│       │   │   │           ├── META-INF
│       │   │   │           │   ├── maven
│       │   │   │           │   │   └── org.jacoco
│       │   │   │           │   │       └── org.jacoco.agent
│       │   │   │           │   │           ├── pom.properties
│       │   │   │           │   │           └── pom.xml
│       │   │   │           │   └── MANIFEST.MF
│       │   │   │           ├── org
│       │   │   │           │   └── jacoco
│       │   │   │           │       └── agent
│       │   │   │           │           ├── AgentJar.class
│       │   │   │           │           └── package-info.class
│       │   │   │           ├── about.html
│       │   │   │           └── jacocoagent.jar
│       │   │   ├── bootJar
│       │   │   │   └── MANIFEST.MF
│       │   │   ├── compileJava
│       │   │   │   ├── compileTransaction
│       │   │   │   │   ├── backup-dir
│       │   │   │   │   └── stash-dir
│       │   │   │   │       └── CustomersController.class.uniqueId0
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── compileTestJava
│       │   │   │   ├── compileTransaction
│       │   │   │   │   ├── backup-dir
│       │   │   │   │   └── stash-dir
│       │   │   │   │       └── CustomersControllerTest.class.uniqueId0
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── jacocoTestCoverageVerification
│       │   │   │   └── success.txt
│       │   │   ├── jar
│       │   │   │   └── MANIFEST.MF
│       │   │   └── test
│       │   └── resolvedMainClassName
│       ├── gradle
│       │   └── wrapper
│       │       ├── gradle-wrapper.jar
│       │       └── gradle-wrapper.properties
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── challenge
│       │   │   │           └── customer_service
│       │   │   │               ├── application
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── port
│       │   │   │               │   │       └── CustomerInputPort.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── CustomerRepositoryPort.java
│       │   │   │               │   │       └── PasswordHasherPort.java
│       │   │   │               │   ├── service
│       │   │   │               │   │   └── impl
│       │   │   │               │   │       └── CustomerServiceImpl.java
│       │   │   │               │   └── util
│       │   │   │               │       ├── Constants.java
│       │   │   │               │       └── PagedResult.java
│       │   │   │               ├── domain
│       │   │   │               │   ├── exception
│       │   │   │               │   │   ├── CustomerNotFoundException.java
│       │   │   │               │   │   ├── DomainValidationException.java
│       │   │   │               │   │   └── DuplicatedIdentificationException.java
│       │   │   │               │   ├── model
│       │   │   │               │   │   ├── Customer.java
│       │   │   │               │   │   ├── Gender.java
│       │   │   │               │   │   └── Person.java
│       │   │   │               │   └── util
│       │   │   │               │       └── Constants.java
│       │   │   │               ├── infrastructure
│       │   │   │               │   ├── exception
│       │   │   │               │   │   └── GlobalExceptionHandler.java
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── controller
│       │   │   │               │   │       │   └── CustomersController.java
│       │   │   │               │   │       └── mapper
│       │   │   │               │   │           └── CustomerRestMapper.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── entity
│       │   │   │               │   │       │   ├── CustomerEntity.java
│       │   │   │               │   │       │   └── PersonEntity.java
│       │   │   │               │   │       ├── mapper
│       │   │   │               │   │       │   └── CustomerJpaMapper.java
│       │   │   │               │   │       ├── repository
│       │   │   │               │   │       │   ├── CustomerJpaRepository.java
│       │   │   │               │   │       │   └── PersonJpaRepository.java
│       │   │   │               │   │       ├── security
│       │   │   │               │   │       │   └── BCryptPasswordHasherAdapter.java
│       │   │   │               │   │       └── CustomeRepositoryAdapter.java
│       │   │   │               │   └── utils
│       │   │   │               │       └── Constants.java
│       │   │   │               └── CustomerServiceApplication.java
│       │   │   └── resources
│       │   │       ├── openapi-templates
│       │   │       │   ├── client
│       │   │       │   │   ├── api.mustache
│       │   │       │   │   └── ApiClient.mustache
│       │   │       │   └── bodyParams.mustache
│       │   │       ├── application.yaml
│       │   │       └── openapi.yaml
│       │   └── test
│       │       ├── java
│       │       │   └── com
│       │       │       └── challenge
│       │       │           └── customer_service
│       │       │               ├── application
│       │       │               │   └── service
│       │       │               │       └── impl
│       │       │               │           └── CustomerServiceImplTest.java
│       │       │               ├── domain
│       │       │               │   ├── exception
│       │       │               │   │   ├── CustomerNotFoundExceptionTest.java
│       │       │               │   │   ├── DomainValidationExceptionTest.java
│       │       │               │   │   └── DuplicateIdentificationExceptionTest.java
│       │       │               │   └── model
│       │       │               │       ├── CustomerTest.java
│       │       │               │       ├── GenderTest.java
│       │       │               │       └── PersonTest.java
│       │       │               ├── infrastructure
│       │       │               │   ├── exception
│       │       │               │   │   └── GlobalExceptionHandlerTest.java
│       │       │               │   ├── input
│       │       │               │   │   └── adapter
│       │       │               │   │       └── controller
│       │       │               │   │           └── CustomersControllerTest.java
│       │       │               │   └── output
│       │       │               │       └── adapter
│       │       │               │           ├── entity
│       │       │               │           │   ├── CustomerEntityTest.java
│       │       │               │           │   └── PersonEntityTest.java
│       │       │               │           ├── mapper
│       │       │               │           │   └── CustomerJpaMapperTest.java
│       │       │               │           ├── security
│       │       │               │           │   └── BCryptPasswordHasherAdapterTest.java
│       │       │               │           └── CustomerRepositoryAdapterTest.java
│       │       │               ├── karate
│       │       │               │   ├── KarateIT.java
│       │       │               │   └── TestcontainersInitializer.java
│       │       │               └── CustomerServiceApplicationTests.java
│       │       └── resources
│       │           ├── com
│       │           │   └── challenge
│       │           │       └── customer_service
│       │           │           └── karate
│       │           │               └── customers.feature
│       │           ├── application-test.yaml
│       │           ├── BaseDatos.sql
│       │           ├── karate-config.js
│       │           └── schema.sql
│       ├── .gitattributes
│       ├── .gitignore
│       ├── build.gradle
│       ├── gradlew
│       ├── gradlew.bat
│       ├── HELP.md
│       └── settings.gradle
├── BaseDatos.sql
├── collection.json
├── docker-compose.yml
├── Ejercicio Técnico Backend Java v2 13.pdf
├── oasis.oaw
└── path_tracker.py
```text
