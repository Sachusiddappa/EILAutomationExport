@getRetailorders @all
Feature: Test GetRetail Order API services

  @getRetailOrdersByCustomerID_and_CustomerGrid @140165
  Scenario: Validate positive scenario for Get retailorder details using CustomerID and CustomerGrid
   	Given Fetch the GetRetailOrders data details with multiple customerId '0060284565' and customerGrid '50415408' 
    Then Verify the GetRetailOrders statuscode '200' in response body
    And Verify retrieved response is having GetRetailOrders Data response

  @getRetailOrdersByCustomerID @140165
  Scenario: Validate positive scenario for Get retailorder details using CustomerID
    Given Fetch the GetRetailOrders data details with multiple customer id '0060284565'
    Then Verify the GetRetailOrders statuscode '200' in response body
    And Verify retrieved response is having GetRetailOrders Data response

  @getRetailOrdersByCustomerGrid @140165
  Scenario: Validate positive scenario for Get retailorder details using CustomerGrid
    Given Fetch the GetRetailOrders data details with multiple customerGrid '50415408'
    Then Verify the GetRetailOrders statuscode '200' in response body
    And Verify retrieved response is having GetRetailOrders Data response

  @getRetailOrdersByarrayofCustomerID @140165
  Scenario: Validate positive scenario for Get retailorder details using array of CustomerID
    Given Fetch the GetRetailOrders data details with multiple customer id "0060284565,0061370793,0061054008"
    Then Verify the GetRetailOrders statuscode "200" in response body
    And Verify retrieved response is having GetRetailOrders Data response

  @getRetailOrdersByarrayofCustomerGrid @140165
  Scenario: Get retailorder details using array of CustomerGrid
    Given Fetch the GetRetailOrders data details with multiple customerGrid "50415408,54666009,53151679"
    Then Verify the GetRetailOrders statuscode '200' in response body
    And Verify retrieved response is having GetRetailOrders Data response

  @getReatilOrderByPassingNullandEmptystringtoCustomerIDandCustomerGrid @140162 @140163 @140164
  Scenario Outline: Validate negative scenario for retailorder details using array of CustomerID and CustomerGrid
   	Given Fetch the GetRetailOrders data details with multiple customerId '<customerId>' and customerGrid '<customerGrid>'
    Then Verify the GetRetailOrders statuscode "<statusCode>" in response body
    And Verify retrieved response is having GetRetailOrders Data response
    And check retrieved getRetailOrders data is '<typeOfData>'
  Examples: 
      | customerId | customerGrid | statusCode | typeOfData |
      | 0060284565 |              |        200 | invalid    |
      | 0060284565 | null         |        200 | invalid    |
      |            |     50415408 |        200 | invalid    |
      | null       |     50415408 |        200 | invalid    |
      
