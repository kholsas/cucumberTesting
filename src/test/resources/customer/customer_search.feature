Feature: Customer Search
  To allow the user to search for a customer

  Scenario: Find a customer by age
    Given a customer with a name 'Kholofelo', and id number '1', and surname 'Maloma', with identity number '9012054433298', and aged '25' this year
      And another customer with a name 'Tom', and id number '2', and surname 'Coffeeman', with identity number '765433456785', and aged '29' this year
      And another customer with a name 'Merlyn', and id number '3', and surname 'Tubman', with identity number '78686858584', and aged '80' this year
    When the user searches for customers with age between 18 and 50
    Then 2 customers should have been found
      And customer 1 should have a name 'Kholofelo'
      And customer 2 should have a name 'Tom'



  Scenario: Find all cutomers
    Given a customer with a name 'Kholofelo', and id number '13', and surname 'Maloma', with identity number '9012054433298', and aged '25' this year
    And another customer with a name 'Tom', and id number '92', and surname 'Coffeeman', with identity number '765433456785', and aged '29' this year
    And another customer with a name 'Merlyn', and id number '30', and surname 'Tubman', with identity number '78686858584', and aged '80' this year
    And another customer with a name 'Jamaline', and id number '330', and surname 'Turenos', with identity number '83', and aged '35' this year
    When the user retrieves all customers
    Then 4 customers should be found