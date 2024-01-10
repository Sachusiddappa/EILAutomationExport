@equipmentswarranty
Feature: Test EquipmentWarranty Deatils

  @customerIdorCustomerGRIDandVin @135513
  Scenario: validate the postive and negative scenarioes of Get Equipment warranty details
    Given Fetch the equipment warranty details using vin '<vin>' and customerId '<customerId>'
    Then Verify the equipment warranty statuscode '<statusCode>' in response body
    And check retrieved data is '<typeOfData>'
      | vin           | customerId | statusCode | typeOfData |
      | 8FBE18U-23241 | 0000100253 |        200 | valid      |
      | 8FBE18U-23241 |       1234 |        200 | invalid    |
      | null          | 0000100253 |        200 | invalid    |
      | 8FBE18U-23241 | null       |        200 | invalid    |
      |               | 0000100253 |        200 | valid      |
      | 8FBE18U-23241 |            |        200 | invalid    |

  @customerIDs @135514 @135515
  Scenario Outline: get the equipment warranty details by passing only customerId or customerGrid
    Given Fetch the equipment warranty details using customerId '0000100253'
    Then Verify the equipment warranty statuscode '<statusCode>' in response body

  @EquipmentVinNumber @135516
  Scenario: Get the equipment warranty details with only vin number
    Given Fetch the equipemet details using vin '8FBE18U-23241'
    Then Verify the equipment warranty statuscode '200' in response body
    And validate the error message of customerId
