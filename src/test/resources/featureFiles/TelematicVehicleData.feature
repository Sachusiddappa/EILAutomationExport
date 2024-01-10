@telematicVehicleData @all
Feature: validate Telematic Vehicle Data APIs

  @teleVin @155780
  Scenario: Get the telematic vehicle data details using vin
    Given Fetch the telematic vehicle data details using vin "7FBCU25-69060"
    Then Verify the telematic vehicle data statuscode "200" in response body
    
  
  
  @teleVinNull @155781 @155782
  Scenario: Get the telematic vehicle data details using vin
    Given Fetch the telematic vehicle data details using vin "null"
    Then Verify the telematic vehicle data statuscode "200" in response body
    
  @teleVinEmpty @155783
   Scenario: Get the telematic vehicle data details using vin
   Given Fetch the telematic vehicle data details using vin ""
   Then Verify the telematic vehicle data statuscode "200" in response body
    
    
  @multiVin @Coveredwhichisnotpartofregressionpack
  Scenario: Get the telematic vehicle data details with multiple vin
  Given Fetch the telematic vehicle data details with multiple vin "7FBCU25-69060,8FGCU25-67740,508FGCU32-10718"
  Then Verify the telematic vehicle data statuscode "200" in response body