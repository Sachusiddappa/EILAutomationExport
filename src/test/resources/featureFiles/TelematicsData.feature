@telematicsdata @all
Feature: validate Telematic data for the API

  @telematicsVin @134164
  Scenario: Get the TelematicsData details using vin
    Given Fetch the TelematicsData details using vin "508FGCU32-10718"
    Then Verify the TelematicsData statuscode "200" in response body
    And Verify retrieved response is having telematicsData response
    And Verify vins "508FGCU32-10718" are present in response

  @telematicsnull @134166 @134167
    Scenario: Get the TelematicsData details using vin
    Given Fetch the TelematicsData details using vin "null"
    Then Verify the TelematicsData statuscode "200" in response body
    And Verify retrieved response is having telematicsData response
    And Validate the telematics error message "Vehicle Not Found" in the TelematicsData service
    
  @telematicsempty @134169
    Scenario: Get the TelematicsData details using vin
    Given Fetch the TelematicsData details using vin ""
    Then Verify the TelematicsData statuscode "200" in response body
    And Verify retrieved response is having telematicsData response
    And Validate the telematics error message "Deleted" in the TelematicsData service
    
    
  @telematicsMultiVin @ExtraCovered
    Scenario: Get the TelematicsData details using multiple vin
    Given Fetch the TelematicsData details using multiple vin "508FGCU32-10718,508FGCU32-10718,8FGCU32-68060,8FGCU25-67740,508FGCU32-10718"
    Then Verify the TelematicsData statuscode "200" in response body
    And Verify retrieved response is having telematicsData response
    And Verify vins "508FGCU32-10718,508FGCU32-10718,8FGCU32-68060,8FGCU25-67740,508FGCU32-10718" are present in response
