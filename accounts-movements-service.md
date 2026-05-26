# Estructura de: accounts_movements_service

```
accounts_movements_service/
└── accounts_movements_service
    ├── .gradle
    │   ├── 8.14.4
    │   │   ├── checksums
    │   │   │   ├── checksums.lock
    │   │   │   ├── md5-checksums.bin
    │   │   │   └── sha1-checksums.bin
    │   │   ├── executionHistory
    │   │   │   ├── executionHistory.bin
    │   │   │   └── executionHistory.lock
    │   │   ├── expanded
    │   │   │   └── expanded.lock
    │   │   ├── fileChanges
    │   │   │   └── last-build.bin
    │   │   ├── fileHashes
    │   │   │   ├── fileHashes.bin
    │   │   │   ├── fileHashes.lock
    │   │   │   └── resourceHashesCache.bin
    │   │   ├── vcsMetadata
    │   │   └── gc.properties
    │   ├── buildOutputCleanup
    │   │   ├── buildOutputCleanup.lock
    │   │   ├── cache.properties
    │   │   └── outputFiles.bin
    │   ├── vcs-1
    │   │   └── gc.properties
    │   └── file-system.probe
    ├── build
    │   ├── classes
    │   │   └── java
    │   │       ├── main
    │   │       │   └── com
    │   │       │       └── challenge
    │   │       │           └── accounts_movements_service
    │   │       │               ├── application
    │   │       │               │   ├── input
    │   │       │               │   │   └── port
    │   │       │               │   │       ├── AccountInputPort.class
    │   │       │               │   │       ├── MovementInputPort.class
    │   │       │               │   │       └── ReportInputPort.class
    │   │       │               │   ├── output
    │   │       │               │   │   └── port
    │   │       │               │   │       ├── AccountRepositoryPort.class
    │   │       │               │   │       ├── CustomerRepositoryPort.class
    │   │       │               │   │       └── MovementRepositoryPort.class
    │   │       │               │   ├── service
    │   │       │               │   │   └── impl
    │   │       │               │   │       ├── AccountServiceImpl.class
    │   │       │               │   │       ├── MovementServiceImpl.class
    │   │       │               │   │       └── ReportServiceImpl.class
    │   │       │               │   └── util
    │   │       │               │       └── PagedResult.class
    │   │       │               ├── domain
    │   │       │               │   ├── exception
    │   │       │               │   │   ├── AccountInactiveException.class
    │   │       │               │   │   ├── AccountNotFoundException.class
    │   │       │               │   │   ├── CustomerNotFoundException.class
    │   │       │               │   │   ├── DomainException.class
    │   │       │               │   │   ├── DomainValidationException.class
    │   │       │               │   │   ├── DownstreamServiceException.class
    │   │       │               │   │   ├── DuplicatedAccountNumberException.class
    │   │       │               │   │   ├── InsufficientFundsException.class
    │   │       │               │   │   └── MovementNotFoundException.class
    │   │       │               │   ├── model
    │   │       │               │   │   ├── Account$AccountBuilder.class
    │   │       │               │   │   ├── Account.class
    │   │       │               │   │   ├── AccountStatementReport$AccountStatementReportBuilder.class
    │   │       │               │   │   ├── AccountStatementReport.class
    │   │       │               │   │   ├── AccountStatementReportAccount$AccountStatementReportAccountBuilder.class
    │   │       │               │   │   ├── AccountStatementReportAccount.class
    │   │       │               │   │   ├── AccountStatementReportMovement$AccountStatementReportMovementBuilder.class
    │   │       │               │   │   ├── AccountStatementReportMovement.class
    │   │       │               │   │   ├── AccountType.class
    │   │       │               │   │   ├── Movement$MovementBuilder.class
    │   │       │               │   │   ├── Movement.class
    │   │       │               │   │   └── MovementType.class
    │   │       │               │   └── policy
    │   │       │               │       ├── MovementPolicy$1.class
    │   │       │               │       └── MovementPolicy.class
    │   │       │               ├── infrastructure
    │   │       │               │   ├── exception
    │   │       │               │   │   └── GlobalExceptionHandler.class
    │   │       │               │   ├── input
    │   │       │               │   │   └── adapter
    │   │       │               │   │       ├── controller
    │   │       │               │   │       │   ├── AccountsController.class
    │   │       │               │   │       │   ├── MovementsController.class
    │   │       │               │   │       │   └── ReportController.class
    │   │       │               │   │       ├── mapper
    │   │       │               │   │       │   ├── AccountRestMapper$1.class
    │   │       │               │   │       │   ├── AccountRestMapper.class
    │   │       │               │   │       │   ├── AccountRestMapperImpl.class
    │   │       │               │   │       │   ├── MovementRestMapper$1.class
    │   │       │               │   │       │   ├── MovementRestMapper.class
    │   │       │               │   │       │   ├── MovementRestMapperImpl.class
    │   │       │               │   │       │   ├── ReportRestMapper$1.class
    │   │       │               │   │       │   ├── ReportRestMapper.class
    │   │       │               │   │       │   └── ReportRestMapperImpl.class
    │   │       │               │   │       └── rest
    │   │       │               │   │           └── customer_service
    │   │       │               │   │               ├── bean
    │   │       │               │   │               │   ├── AccountBase.class
    │   │       │               │   │               │   ├── AccountResponse.class
    │   │       │               │   │               │   ├── AccountStatementAccount.class
    │   │       │               │   │               │   ├── AccountStatementReport.class
    │   │       │               │   │               │   ├── AccountType.class
    │   │       │               │   │               │   ├── ApiError.class
    │   │       │               │   │               │   ├── ApiErrorDetailsInner.class
    │   │       │               │   │               │   ├── CreateAccountRequest.class
    │   │       │               │   │               │   ├── CreateMovementRequest.class
    │   │       │               │   │               │   ├── MovementBase.class
    │   │       │               │   │               │   ├── MovementResponse.class
    │   │       │               │   │               │   ├── MovementType.class
    │   │       │               │   │               │   ├── PagedAccountsResponse.class
    │   │       │               │   │               │   ├── PagedMovementsResponse.class
    │   │       │               │   │               │   ├── UpdateAccountRequest.class
    │   │       │               │   │               │   └── UpdateMovementRequest.class
    │   │       │               │   │               ├── AccountsApi.class
    │   │       │               │   │               ├── ApiUtil.class
    │   │       │               │   │               ├── MovementsApi.class
    │   │       │               │   │               └── ReportsApi.class
    │   │       │               │   └── output
    │   │       │               │       └── adapter
    │   │       │               │           ├── entity
    │   │       │               │           │   ├── AccountEntity$AccountEntityBuilder.class
    │   │       │               │           │   ├── AccountEntity.class
    │   │       │               │           │   ├── MovementEntity$MovementEntityBuilder.class
    │   │       │               │           │   └── MovementEntity.class
    │   │       │               │           ├── mapper
    │   │       │               │           │   ├── AccountJpaMapper.class
    │   │       │               │           │   └── MovementJpaMapper.class
    │   │       │               │           ├── repository
    │   │       │               │           │   ├── AccountJpaRepository.class
    │   │       │               │           │   └── MovementJpaRepository.class
    │   │       │               │           ├── rest
    │   │       │               │           │   ├── auth
    │   │       │               │           │   │   ├── ApiKeyAuth.class
    │   │       │               │           │   │   ├── Authentication.class
    │   │       │               │           │   │   ├── HttpBasicAuth.class
    │   │       │               │           │   │   └── HttpBearerAuth.class
    │   │       │               │           │   ├── customer_service
    │   │       │               │           │   │   ├── bean
    │   │       │               │           │   │   │   ├── ApiError.class
    │   │       │               │           │   │   │   ├── ApiErrorDetailsInner.class
    │   │       │               │           │   │   │   ├── CreateCustomerRequest.class
    │   │       │               │           │   │   │   ├── Customer.class
    │   │       │               │           │   │   │   ├── CustomerFields.class
    │   │       │               │           │   │   │   ├── CustomerResponse.class
    │   │       │               │           │   │   │   ├── Gender.class
    │   │       │               │           │   │   │   ├── PagedCustomersResponse.class
    │   │       │               │           │   │   │   ├── PersonBase.class
    │   │       │               │           │   │   │   └── UpdateCustomerRequest.class
    │   │       │               │           │   │   ├── CustomersApi$1.class
    │   │       │               │           │   │   ├── CustomersApi$10.class
    │   │       │               │           │   │   ├── CustomersApi$11.class
    │   │       │               │           │   │   ├── CustomersApi$12.class
    │   │       │               │           │   │   ├── CustomersApi$13.class
    │   │       │               │           │   │   ├── CustomersApi$14.class
    │   │       │               │           │   │   ├── CustomersApi$15.class
    │   │       │               │           │   │   ├── CustomersApi$16.class
    │   │       │               │           │   │   ├── CustomersApi$17.class
    │   │       │               │           │   │   ├── CustomersApi$18.class
    │   │       │               │           │   │   ├── CustomersApi$19.class
    │   │       │               │           │   │   ├── CustomersApi$2.class
    │   │       │               │           │   │   ├── CustomersApi$20.class
    │   │       │               │           │   │   ├── CustomersApi$21.class
    │   │       │               │           │   │   ├── CustomersApi$22.class
    │   │       │               │           │   │   ├── CustomersApi$23.class
    │   │       │               │           │   │   ├── CustomersApi$24.class
    │   │       │               │           │   │   ├── CustomersApi$25.class
    │   │       │               │           │   │   ├── CustomersApi$3.class
    │   │       │               │           │   │   ├── CustomersApi$4.class
    │   │       │               │           │   │   ├── CustomersApi$5.class
    │   │       │               │           │   │   ├── CustomersApi$6.class
    │   │       │               │           │   │   ├── CustomersApi$7.class
    │   │       │               │           │   │   ├── CustomersApi$8.class
    │   │       │               │           │   │   ├── CustomersApi$9.class
    │   │       │               │           │   │   └── CustomersApi.class
    │   │       │               │           │   ├── ApiClient$CollectionFormat.class
    │   │       │               │           │   ├── ApiClient.class
    │   │       │               │           │   ├── JavaTimeFormatter.class
    │   │       │               │           │   ├── RFC3339DateFormat.class
    │   │       │               │           │   ├── ServerConfiguration.class
    │   │       │               │           │   ├── ServerVariable.class
    │   │       │               │           │   └── StringUtil.class
    │   │       │               │           ├── AccountRepositoryAdapter.class
    │   │       │               │           └── MovementRepositoryAdapter.class
    │   │       │               └── AccountsMovementsServiceApplication.class
    │   │       └── test
    │   │           └── com
    │   │               └── challenge
    │   │                   └── accounts_movements_service
    │   │                       └── AccountsMovementsServiceApplicationTests.class
    │   ├── generated
    │   │   ├── .github
    │   │   │   └── workflows
    │   │   │       └── maven.yml
    │   │   ├── .openapi-generator
    │   │   │   ├── FILES
    │   │   │   └── VERSION
    │   │   ├── api
    │   │   │   └── openapi.yaml
    │   │   ├── docs
    │   │   │   ├── ApiError.md
    │   │   │   ├── ApiErrorDetailsInner.md
    │   │   │   ├── CreateCustomerRequest.md
    │   │   │   ├── Customer.md
    │   │   │   ├── CustomerFields.md
    │   │   │   ├── CustomerResponse.md
    │   │   │   ├── CustomersApi.md
    │   │   │   ├── Gender.md
    │   │   │   ├── PagedCustomersResponse.md
    │   │   │   ├── PersonBase.md
    │   │   │   └── UpdateCustomerRequest.md
    │   │   ├── gradle
    │   │   │   └── wrapper
    │   │   │       ├── gradle-wrapper.jar
    │   │   │       └── gradle-wrapper.properties
    │   │   ├── sources
    │   │   │   ├── annotationProcessor
    │   │   │   │   └── java
    │   │   │   │       ├── main
    │   │   │   │       │   └── com
    │   │   │   │       │       └── challenge
    │   │   │   │       │           └── accounts_movements_service
    │   │   │   │       │               └── infrastructure
    │   │   │   │       │                   └── input
    │   │   │   │       │                       └── adapter
    │   │   │   │       │                           └── mapper
    │   │   │   │       │                               ├── AccountRestMapperImpl.java
    │   │   │   │       │                               ├── MovementRestMapperImpl.java
    │   │   │   │       │                               └── ReportRestMapperImpl.java
    │   │   │   │       └── test
    │   │   │   └── headers
    │   │   │       └── java
    │   │   │           ├── main
    │   │   │           └── test
    │   │   ├── src
    │   │   │   ├── main
    │   │   │   │   ├── java
    │   │   │   │   │   └── com
    │   │   │   │   │       └── challenge
    │   │   │   │   │           └── accounts_movements_service
    │   │   │   │   │               └── infrastructure
    │   │   │   │   │                   ├── input
    │   │   │   │   │                   │   └── adapter
    │   │   │   │   │                   │       └── rest
    │   │   │   │   │                   │           └── customer_service
    │   │   │   │   │                   │               ├── bean
    │   │   │   │   │                   │               │   ├── AccountBase.java
    │   │   │   │   │                   │               │   ├── AccountResponse.java
    │   │   │   │   │                   │               │   ├── AccountStatementAccount.java
    │   │   │   │   │                   │               │   ├── AccountStatementReport.java
    │   │   │   │   │                   │               │   ├── AccountType.java
    │   │   │   │   │                   │               │   ├── ApiError.java
    │   │   │   │   │                   │               │   ├── ApiErrorDetailsInner.java
    │   │   │   │   │                   │               │   ├── CreateAccountRequest.java
    │   │   │   │   │                   │               │   ├── CreateMovementRequest.java
    │   │   │   │   │                   │               │   ├── MovementBase.java
    │   │   │   │   │                   │               │   ├── MovementResponse.java
    │   │   │   │   │                   │               │   ├── MovementType.java
    │   │   │   │   │                   │               │   ├── PagedAccountsResponse.java
    │   │   │   │   │                   │               │   ├── PagedMovementsResponse.java
    │   │   │   │   │                   │               │   ├── UpdateAccountRequest.java
    │   │   │   │   │                   │               │   └── UpdateMovementRequest.java
    │   │   │   │   │                   │               ├── AccountsApi.java
    │   │   │   │   │                   │               ├── ApiUtil.java
    │   │   │   │   │                   │               ├── MovementsApi.java
    │   │   │   │   │                   │               └── ReportsApi.java
    │   │   │   │   │                   └── output
    │   │   │   │   │                       └── adapter
    │   │   │   │   │                           └── rest
    │   │   │   │   │                               ├── auth
    │   │   │   │   │                               │   ├── ApiKeyAuth.java
    │   │   │   │   │                               │   ├── Authentication.java
    │   │   │   │   │                               │   ├── HttpBasicAuth.java
    │   │   │   │   │                               │   └── HttpBearerAuth.java
    │   │   │   │   │                               ├── customer_service
    │   │   │   │   │                               │   ├── bean
    │   │   │   │   │                               │   │   ├── ApiError.java
    │   │   │   │   │                               │   │   ├── ApiErrorDetailsInner.java
    │   │   │   │   │                               │   │   ├── CreateCustomerRequest.java
    │   │   │   │   │                               │   │   ├── Customer.java
    │   │   │   │   │                               │   │   ├── CustomerFields.java
    │   │   │   │   │                               │   │   ├── CustomerResponse.java
    │   │   │   │   │                               │   │   ├── Gender.java
    │   │   │   │   │                               │   │   ├── PagedCustomersResponse.java
    │   │   │   │   │                               │   │   ├── PersonBase.java
    │   │   │   │   │                               │   │   └── UpdateCustomerRequest.java
    │   │   │   │   │                               │   └── CustomersApi.java
    │   │   │   │   │                               ├── ApiClient.java
    │   │   │   │   │                               ├── JavaTimeFormatter.java
    │   │   │   │   │                               ├── RFC3339DateFormat.java
    │   │   │   │   │                               ├── ServerConfiguration.java
    │   │   │   │   │                               ├── ServerVariable.java
    │   │   │   │   │                               └── StringUtil.java
    │   │   │   │   └── AndroidManifest.xml
    │   │   │   └── test
    │   │   │       └── java
    │   │   │           └── com
    │   │   │               └── challenge
    │   │   │                   └── accounts_movements_service
    │   │   │                       └── infrastructure
    │   │   │                           └── output
    │   │   │                               └── adapter
    │   │   │                                   └── rest
    │   │   │                                       └── customer_service
    │   │   │                                           ├── bean
    │   │   │                                           │   ├── ApiErrorDetailsInnerTest.java
    │   │   │                                           │   ├── ApiErrorTest.java
    │   │   │                                           │   ├── CreateCustomerRequestTest.java
    │   │   │                                           │   ├── CustomerFieldsTest.java
    │   │   │                                           │   ├── CustomerResponseTest.java
    │   │   │                                           │   ├── CustomerTest.java
    │   │   │                                           │   ├── GenderTest.java
    │   │   │                                           │   ├── PagedCustomersResponseTest.java
    │   │   │                                           │   ├── PersonBaseTest.java
    │   │   │                                           │   └── UpdateCustomerRequestTest.java
    │   │   │                                           └── CustomersApiTest.java
    │   │   ├── .gitignore
    │   │   ├── .openapi-generator-ignore
    │   │   ├── .travis.yml
    │   │   ├── build.gradle
    │   │   ├── build.sbt
    │   │   ├── git_push.sh
    │   │   ├── gradle.properties
    │   │   ├── gradlew
    │   │   ├── gradlew.bat
    │   │   ├── pom.xml
    │   │   ├── README.md
    │   │   └── settings.gradle
    │   ├── jacoco
    │   │   └── test.exec
    │   ├── libs
    │   │   ├── accounts_movements_service-0.0.1-SNAPSHOT-plain.jar
    │   │   └── accounts_movements_service-0.0.1-SNAPSHOT.jar
    │   ├── reports
    │   │   ├── problems
    │   │   │   └── problems-report.html
    │   │   └── tests
    │   │       └── test
    │   │           ├── classes
    │   │           │   └── com.challenge.accounts_movements_service.AccountsMovementsServiceApplicationTests.html
    │   │           ├── css
    │   │           │   ├── base-style.css
    │   │           │   └── style.css
    │   │           ├── js
    │   │           │   └── report.js
    │   │           ├── packages
    │   │           │   └── com.challenge.accounts_movements_service.html
    │   │           └── index.html
    │   ├── resources
    │   │   ├── main
    │   │   │   ├── META-INF
    │   │   │   │   └── build-info.properties
    │   │   │   ├── openapi-templates
    │   │   │   │   ├── client
    │   │   │   │   │   ├── api.mustache
    │   │   │   │   │   └── ApiClient.mustache
    │   │   │   │   └── bodyParams.mustache
    │   │   │   ├── application.yaml
    │   │   │   ├── customer_service.yaml
    │   │   │   └── openapi.yaml
    │   │   └── test
    │   │       ├── application-test.yaml
    │   │       └── schema.sql
    │   ├── test-results
    │   │   └── test
    │   │       ├── binary
    │   │       │   ├── output.bin
    │   │       │   ├── output.bin.idx
    │   │       │   └── results.bin
    │   │       └── TEST-com.challenge.accounts_movements_service.AccountsMovementsServiceApplicationTests.xml
    │   ├── tmp
    │   │   ├── .cache
    │   │   │   └── expanded
    │   │   │       └── zip_9892ccb804f78c0637616b68610d363f
    │   │   │           ├── META-INF
    │   │   │           │   ├── maven
    │   │   │           │   │   └── org.jacoco
    │   │   │           │   │       └── org.jacoco.agent
    │   │   │           │   │           ├── pom.properties
    │   │   │           │   │           └── pom.xml
    │   │   │           │   └── MANIFEST.MF
    │   │   │           ├── org
    │   │   │           │   └── jacoco
    │   │   │           │       └── agent
    │   │   │           │           ├── AgentJar.class
    │   │   │           │           └── package-info.class
    │   │   │           ├── about.html
    │   │   │           └── jacocoagent.jar
    │   │   ├── bootJar
    │   │   │   └── MANIFEST.MF
    │   │   ├── compileJava
    │   │   │   └── previous-compilation-data.bin
    │   │   ├── compileTestJava
    │   │   │   └── previous-compilation-data.bin
    │   │   ├── jar
    │   │   │   └── MANIFEST.MF
    │   │   └── test
    │   └── resolvedMainClassName
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com
    │   │   │       └── challenge
    │   │   │           └── accounts_movements_service
    │   │   │               ├── application
    │   │   │               │   ├── input
    │   │   │               │   │   └── port
    │   │   │               │   │       ├── AccountInputPort.java
    │   │   │               │   │       ├── MovementInputPort.java
    │   │   │               │   │       └── ReportInputPort.java
    │   │   │               │   ├── output
    │   │   │               │   │   └── port
    │   │   │               │   │       ├── AccountRepositoryPort.java
    │   │   │               │   │       ├── CustomerRepositoryPort.java
    │   │   │               │   │       └── MovementRepositoryPort.java
    │   │   │               │   ├── service
    │   │   │               │   │   └── impl
    │   │   │               │   │       ├── AccountServiceImpl.java
    │   │   │               │   │       ├── MovementServiceImpl.java
    │   │   │               │   │       └── ReportServiceImpl.java
    │   │   │               │   └── util
    │   │   │               │       └── PagedResult.java
    │   │   │               ├── domain
    │   │   │               │   ├── exception
    │   │   │               │   │   ├── AccountInactiveException.java
    │   │   │               │   │   ├── AccountNotFoundException.java
    │   │   │               │   │   ├── CustomerNotFoundException.java
    │   │   │               │   │   ├── DomainException.java
    │   │   │               │   │   ├── DomainValidationException.java
    │   │   │               │   │   ├── DownstreamServiceException.java
    │   │   │               │   │   ├── DuplicatedAccountNumberException.java
    │   │   │               │   │   ├── InsufficientFundsException.java
    │   │   │               │   │   └── MovementNotFoundException.java
    │   │   │               │   ├── model
    │   │   │               │   │   ├── Account.java
    │   │   │               │   │   ├── AccountStatementReport.java
    │   │   │               │   │   ├── AccountStatementReportAccount.java
    │   │   │               │   │   ├── AccountStatementReportMovement.java
    │   │   │               │   │   ├── AccountType.java
    │   │   │               │   │   ├── Movement.java
    │   │   │               │   │   └── MovementType.java
    │   │   │               │   └── policy
    │   │   │               │       └── MovementPolicy.java
    │   │   │               ├── infrastructure
    │   │   │               │   ├── exception
    │   │   │               │   │   └── GlobalExceptionHandler.java
    │   │   │               │   ├── input
    │   │   │               │   │   └── adapter
    │   │   │               │   │       ├── controller
    │   │   │               │   │       │   ├── AccountsController.java
    │   │   │               │   │       │   ├── MovementsController.java
    │   │   │               │   │       │   └── ReportController.java
    │   │   │               │   │       └── mapper
    │   │   │               │   │           ├── AccountRestMapper.java
    │   │   │               │   │           ├── MovementRestMapper.java
    │   │   │               │   │           └── ReportRestMapper.java
    │   │   │               │   └── output
    │   │   │               │       └── adapter
    │   │   │               │           ├── entity
    │   │   │               │           │   ├── AccountEntity.java
    │   │   │               │           │   └── MovementEntity.java
    │   │   │               │           ├── mapper
    │   │   │               │           │   ├── AccountJpaMapper.java
    │   │   │               │           │   └── MovementJpaMapper.java
    │   │   │               │           ├── repository
    │   │   │               │           │   ├── AccountJpaRepository.java
    │   │   │               │           │   └── MovementJpaRepository.java
    │   │   │               │           ├── AccountRepositoryAdapter.java
    │   │   │               │           └── MovementRepositoryAdapter.java
    │   │   │               └── AccountsMovementsServiceApplication.java
    │   │   └── resources
    │   │       ├── openapi-templates
    │   │       │   ├── client
    │   │       │   │   ├── api.mustache
    │   │       │   │   └── ApiClient.mustache
    │   │       │   └── bodyParams.mustache
    │   │       ├── application.yaml
    │   │       ├── customer_service.yaml
    │   │       └── openapi.yaml
    │   └── test
    │       ├── java
    │       │   └── com
    │       │       └── challenge
    │       │           └── accounts_movements_service
    │       │               └── AccountsMovementsServiceApplicationTests.java
    │       └── resources
    │           ├── application-test.yaml
    │           └── schema.sql
    ├── .gitattributes
    ├── .gitignore
    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    ├── HELP.md
    └── settings.gradle
```text
