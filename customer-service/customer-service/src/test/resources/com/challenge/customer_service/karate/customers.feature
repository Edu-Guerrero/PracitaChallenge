Feature: Customers API (integration)

Background:
  * url baseUrl
  * def basePath = ['api', 'v1']

# ------------------------------------------------------------
Scenario: Create -> Get -> Update -> Delete (happy path)
  * def ts = java.lang.System.currentTimeMillis()
  * def identification = 'IT-' + ts

  Given path 'api', 'v1', 'customers'
  And request
    """
    {
      "name": "Karate Customer",
      "gender": "OTHER",
      "identification": "#(identification)",
      "address": "Test Address",
      "phone": "0999999999",
      "password": "1234",
      "status": true
    }
    """
  When method post
  Then status 201
  And match response.id != null
  And match header Location contains '/api/v1/customers/'
  * def id = response.id

  Given path 'api', 'v1', 'customers', id
  When method get
  Then status 200
  And match response.id == id
  And match response.identification == identification
  And match response.name == 'Karate Customer'
  And match response.status == true

  * def updatedIdentification = 'UPD-' + ts

  Given path 'api', 'v1', 'customers', id
  And request
    """
    {
      "name": "Karate Customer Updated",
      "gender": "FEMALE",
      "identification": "#(updatedIdentification)",
      "address": "New Address",
      "phone": "0888888888",
      "password": "5678",
      "status": false
    }
    """
  When method put
  Then status 200
  And match response.id == id
  And match response.status == false
  And match response.identification == updatedIdentification

  Given path 'api', 'v1', 'customers', id
  When method delete
  Then status 204

  Given path 'api', 'v1', 'customers', id
  When method get
  Then status 404
  And match response.status == 404
  And match response.error == 'Not Found'

# ------------------------------------------------------------
Scenario: 400 - Bean validation should return ApiError.details (identification too long)
  # identification longer than 30 chars to trigger @Size(max=30)
  * def longId = 'X' + '1234567890123456789012345678901234567890'

  Given path 'api', 'v1', 'customers'
  And request
    """
    {
      "name": "Invalid Customer",
      "gender": "OTHER",
      "identification": "#(longId)",
      "address": "Addr",
      "phone": "0999999999",
      "password": "1234",
      "status": true
    }
    """
  When method post
  Then status 400
  And match response.status == 400
  And match response.error == 'Bad Request'
  And match response.message == 'Validation failed'
  And match response.details[*].field contains 'identification'

# ------------------------------------------------------------
Scenario: 409 - Duplicated identification should return conflict ApiError
  * def ts = java.lang.System.currentTimeMillis()
  * def identification = 'DUP-' + ts

  # First create OK
  Given path 'api', 'v1', 'customers'
  And request
    """
    {
      "name": "Dup Customer",
      "gender": "OTHER",
      "identification": "#(identification)",
      "address": "Addr",
      "phone": "0999999999",
      "password": "1234",
      "status": true
    }
    """
  When method post
  Then status 201
  And match response.id != null

  # Second create -> 409
  Given path 'api', 'v1', 'customers'
  And request
    """
    {
      "name": "Dup Customer 2",
      "gender": "OTHER",
      "identification": "#(identification)",
      "address": "Addr",
      "phone": "0999999999",
      "password": "1234",
      "status": true
    }
    """
  When method post
  Then status 409
  And match response.status == 409
  And match response.error == 'Conflict'

# ------------------------------------------------------------
Scenario: 404 - Get non existing customer should return ApiError
  * def id = '00000000-0000-0000-0000-000000000000'

  Given path 'api', 'v1', 'customers', id
  When method get
  Then status 404
  And match response.status == 404
  And match response.error == 'Not Found'
