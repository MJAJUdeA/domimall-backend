Feature: Create an user

  Background:
    * url baseUrl
    * def userPath = '/api/v1/users'

  Scenario: Create an user
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina.g@gmail.com",
          "password": "mypassword2020",
          "phone": "42342345"
        }
      """
    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 201
    And match responseHeaders contains {Location:[#string]}


  Scenario: Can't create an user lacking non-duplicate email
    * def commerceToCreate =
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina.g@gmail.com",
          "password": "mypassword2020",
          "phone": "42342345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 409
    And match response contains {"exception": "#regex .+DataIntegrityViolationException"}


  Scenario: Can't create an user lacking right email format
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina2.ggmail.com",
          "password": "mypassword2020",
          "phone": "42342345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {"message": "#regex .+Email must be a valid email.+"}


  Scenario: Can't create an user lacking documentId
    * def userToCreate =
      """
        {
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina3.g@gmail.com",
          "password": "mypassword2020",
          "phone": "42342345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400


  Scenario: Can't create an user lacking names
    * def userToCreate =
      """
        {
          "documentId": "3242353456",
          "lastNames": "Gomez",
          "email": "gomez@gmail.com",
          "password": "mypassword2021",
          "phone": "423434225"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400


  Scenario: Can't create an user lacking lastNames
    * def userToCreate =
      """
        {
          "names": "Mark",
          "email": "mark@gmail.com",
          "password": "mypassword220",
          "phone": "4234343466"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400


  Scenario: Can't create an user lacking email
    * def userToCreate =
      """
        {
          "names": "Sara",
          "lastNames": "Jaramillo",
          "password": "Apassword2020",
          "phone": "02323345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400


  Scenario: Can't create an user lacking password
    * def userToCreate =
      """
        {
          "names": "Julian",
          "lastNames": "Sosa",
          "email": "juliang@gmail.com",
          "password": "mypassw2020",
          "phone": "42324456"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400


  Scenario: Can create an user lacking phone

    * def userToCreate =

    """
        {
          "documentId": "104012654",
          "names": "Manolo",
          "lastNames": "Perez",
          "email": "manolo@gmail.com",
          "password": "12345678"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 201
    And match responseHeaders contains {Location:[#string]}


  Scenario: Can't create an user lacking right documentId size
    * def userToCreate =
      """
        {
          "documentId": "10",
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina.perez@gmail.com",
          "password": "mypassword2020",
          "phone": "42342345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {"message":"#regex .+Document id must be between 3 and 80 characters.+"}


  Scenario: Can't create an user lacking right password size
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Paulina",
          "lastNames": "Gonzalez Munera",
          "email": "paulina.g@gmail.com",
          "password": "1234567",
          "phone": "42342345"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {'message':'#regex .+Password must be between 8 and 70 characters.+'}


  Scenario: Can't create an user lacking right names size
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "P",
          "lastNames": "Lopez",
          "email": "p.lopez@gmail.com",
          "password": "123456343",
          "phone": "42333445"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {'message':'#regex .+Names must be between 2 and 80 characters.+'}


  Scenario: Can't create an user lacking right lastNames size
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Pedro",
          "lastNames": "l",
          "email": "pedro.lopez@gmail.com",
          "password": "123456343",
          "phone": "42333445"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {'message':'#regex .+Last names must be between 2 and 80 characters.+'}


  Scenario: Can't create an user lacking right phone size
    * def userToCreate =
      """
        {
          "documentId": "104051654",
          "names": "Felipe",
          "lastNames": "Sevillano",
          "email": "felipe@gmail.com",
          "password": "123456343",
          "phone": "42337"
        }
      """

    Given path userPath
    And request userToCreate
    And header Accept = 'application/json'
    When method post
    Then status 400
    And match response contains {'message':'#regex .+Phone must be between 6 and 80 characters.+'}
