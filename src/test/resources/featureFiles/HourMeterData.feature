  @hourmeterdata @all
  Feature: validate Telematic Vehicle Data API
  
  @hourVin @137255
  Scenario: Get the hourmeterdata data details using vin
    Given Fetch the hourmeterdata data details using vin "7FBCU25-69060"
    Then Verify the hourmeterdata statuscode "200" in response body
    And Verify retrieved response is having Hour Meter Data response
    And Verify vin numbers "7FBCU25-69060" are present in the response
 
    
  @hourVinnull @137257 @137258
  Scenario: Get the hourmeterdata data details using vin
    Given Fetch the hourmeterdata data details using vin "null"
    Then Verify the hourmeterdata statuscode "200" in response body
    And Verify retrieved response is having Hour Meter Data response
 		And Validate the error message "Vehicle Not Found" in the hourMeterData service
 		   
   @hourVinempty @137259
    Scenario: Get the hourmeterdata data details using vin
    Given Fetch the hourmeterdata data details using vin ""
    And Verify retrieved response is having Hour Meter Data response
    Then Verify the hourmeterdata statuscode "200" in response body
    
    
    @hourmultiVin @137255 @137256
    Scenario: Get the hourmeterdata data details with multiple vin
    Given Fetch the hourmeterdata data details with multiple vin "77FBCU25-69060,508FGCU32-11405"
   	And Verify retrieved response is having Hour Meter Data response
    Then Verify the hourmeterdata statuscode "200" in response body
    And Verify vin numbers "77FBCU25-69060,508FGCU32-11405" are present in the response