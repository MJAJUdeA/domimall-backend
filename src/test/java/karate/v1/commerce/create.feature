Feature: Create and read commerce

  Background:
    * url = baseUrl
    * def commercePath = '/api/v1/commerce'

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

