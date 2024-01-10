@getequipmentbyvin @all
Feature: Test getequipmentbyvin API services

  @equipmentVin @135980
  Scenario: Get the getEquipmentByVin details by using vin
    Given Fetch the getEquipemetByVin details using vin '9BDRU15-39704'
    Then Verify the GetEquipmentByVin service statuscode '200' in response body
    And Verify retrieved response is having getEquipmentsByVin response
    And Verify getEquipmentByVin vin numbers '9BDRU15-39704' is present in the response

  @equipmentNull @135981 @135982 @135983 @135984
  Scenario: Get the getEquipmentByVin details by using vin
    Given Fetch the getEquipemetByVin details using vin "null"
    Then Verify the GetEquipmentByVin service statuscode '200' in response body
    And Verify retrieved response is having getEquipmentsByVin response
    And Validate Error response for the vin data "null"

  @equipmentEmpty @135981 @135982 @135984
  Scenario: Get the getEquipmentByVin details by using vin
    Given Fetch the getEquipemetByVin details using vin ""
    Then Verify the GetEquipmentByVin service statuscode '200' in response body
    And Verify retrieved response is having getEquipmentsByVin response
    And Validate Error response for the vin data ""

  @equipmentmultiple 
  Scenario: Get the getEquipmentByVin details by using multiple vin
    Given Fetch the getEquipmentByVin service details with multiple vin "9BDRU15-39704,6FDU18-60158,8FD80U-20140"
    Then Verify the GetEquipmentByVin service statuscode '200' in response body
    And Verify retrieved response is having getEquipmentsByVin response
    And Verify getEquipmentByVin vin numbers '9BDRU15-39704,6FDU18-60158,8FD80U-20140' is present in the response
