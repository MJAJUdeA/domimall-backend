Feature: Find a Commerce by id

  Background:
    * url baseUrl
    * def commercePath = '/api/v1/commerces'
    * def commercePathFindById = '/api/v1/commerces/'

    Scenario: Create and find a commerce by id
      * def commerceToCreate =
      """
        {
          "documentType": "NIT",
          "documentId": "901036745-3",
          "tradeName": "Papa Johns",
          "legalName": "Papa Johns.S.A.",
          "email": "papafbi@papajohns.com",
          "phone": "6541848"
        }
      """

      #create a commerce
      Given path commercePath
      And request commerceToCreate
      And header Accept = 'application/json'
      When method post
      Then status 201


      #find by id
      Given path responseHeaders['Location']
      When method get
      Then status 200
      And match response contains commerceToCreate


    Scenario: Find a Commerce by id that doesn't exist

      #find by id that doesn't exist
      Given path commercePath, 99999
      When method get
      Then status 404
      And match response contains {"message":"#regex .*Commerce not found.*"}

    Scenario: Find a Commerce lacking data type path variable id

      Given path commercePath, 'kk'
      When method get
      Then status 400
      And match response contains {'exception': '#regex .*MethodArgumentTypeMismatchException.*'}

