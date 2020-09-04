Feature: Create a commerce

  Background:
    * url baseUrl
    * def commercePath = '/api/v1/commerces'

    Scenario: Create a commerce
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "901036745-2",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa@papajohns.com",
          "phone": "6541848"
        }
      """
      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 201
      And match responseHeaders contains {Location:[#string]}


    Scenario: Can't create a commerce lacking non-duplicate email
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "901036745-2",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa@papajohns.com",
          "phone": "6541848"
        }
      """

      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 409
      And match response contains {"exception": "#regex .+DataIntegrityViolationException"}

    Scenario: Can't create a commerce lacking right email format
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "901036745-2",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa.johns.com",
          "phone": "6541848"
        }
      """

      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 400
      And match response contains {"message": "#regex .+Email must be a valid email.+"}

    Scenario: Can't create a commerce lacking documentId
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa2@papajohns.com",
          "phone": "6541848"
        }
      """

      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 400

    Scenario: Can't create a commerce lacking right documentId size
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "90",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa2@papajohns.com",
          "phone": "6541848"
        }
      """

      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 400
      And match response contains {"message":"#regex .+Document id must be between 3 and 80 characters.+"}

    Scenario: Can't create a commerce not found on SIC
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "999999999",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papa2@papajohns.com",
          "phone": "6541848"
        }
      """
