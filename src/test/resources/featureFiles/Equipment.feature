@equipments @all
Feature: Test Equipment APIs

  @vinCustomerId @135515 @135516 @135981 @135982 @135984 @155784 @155787 @155786 @155785
  Scenario Outline: validate postive and negative scenarioes of Get Equipment Details
    Given Fetch the equipment details using vin '<vin>' and customerId '<customerId>'
    Then Verify the statuscode '<statusCode>' in response body
    And check retrieved data is '<typeOfData>'

    Examples: 
      | vin           | customerId | statusCode | typeOfData |
      | 9BDRU15-39704 | 0061290277 |        200 | invalid    |
      | 8FG40U-20216  |       1234 |        200 | invalid    |
      | null          | 0061290277 |        200 | invalid    |
      | 9BDRU15-39704 | null       |        200 | invalid    |
      |               | 0061290277 |        200 | valid      |
      | 9BDRU15-39704 |            |        200 | invalid    |

  @customerId @135985
  Scenario: Get the equipment details with only customerId
    Given Fetch the equipemet details using customerId '0061290277'
    Then Verify the statuscode '200' in response body
    And check retrieved data is 'valid'

  #Then validate error message of customerId
  @vinNumber @155784 @155785 @155786 @155787 @155785 @155786
  Scenario: Get the equipment details with only vin number
    Given Fetch the equipemet details using vin '9BDRU15-39704'
    Then Verify the statuscode '200' in response body
    And validate error message of customerId

  @EquipmentWaranty @135514
  Scenario: Get the equipment waranty details with customer id and vin
    Given Fetch the equipment waranty details using vin "8FBE18U-23241" and customerId "0000100253"
    Then Verify the statuscode '200' in response body
    And Verify retrieved response is having Equipment Data response

  @EquipmentWarantyByVin @ExtraCovered
  Scenario: Get the equipment waranty details with vin
    Given Fetch the equipment waranty details using vin "8FBE18U-23241"
    Then Verify the statuscode '200' in response body
    And Verify retrieved response is having Equipment Data response
    And validate error message of customerId

  @EquipmentWarantyByCustomerId @135513
  Scenario: Get the equipment waranty details with customer id
    Given Fetch the equipment waranty details using customerId "0000100253"
    Then Verify the statuscode '200' in response body
    And Verify retrieved response is having Equipment Data response
