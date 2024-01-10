@TelematicsUtilizationData @all

Feature: Test TelematicsUtilizationData API service

@TelematicsUtilizationDataWithAll @140360
 Scenario: Fetch the TelematicsUtilizationData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsUtilizationData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "508FGCU32-10718,508FGCU32-10718"
 Then Verify the TelematicsUtilizationData statuscode "200" in response body
 And Verify retrieved response is having TelematicsUtilizationData response
 
@TelematicsUtilizationDataWithoutVin @outofregressionpack
 Scenario: Fetch the TelematicsUtilizationData without vin
 Given Fetch the TelematicsUtilizationData service details using from date "2023-10-14" and to date "2023-12-08"
 Then Verify the TelematicsUtilizationData statuscode "400" in response body
 And Validate error message in TelematicsUtilizationData for the field "vin"
 
 @TelematicsUtilizationDataWithoutFromDate @outofregressionpacks
 Scenario: Fetch the TelematicsUtilizationData without fromdate
 Given Fetch the TelematicsUtilizationData service details using to date "2023-12-08" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsUtilizationData statuscode "400" in response body
 And Validate error message in TelematicsUtilizationData for the field "fromDate"
 
 @TelematicsUtilizationDataWithoutToDate @outofregressionspack
 Scenario: Fetch the TelematicsUtilizationData without todate
 Given Fetch the TelematicsUtilizationData service details using from date "2023-10-14" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsUtilizationData statuscode "400" in response body
 And Validate error message in TelematicsUtilizationData for the field "toDate"
 
 
 @TelematicsUtilizationDataInvalidVin @140361 @140362 @140363
 Scenario: Fetch the TelematicsUtilizationData by providing invalid vin
 Given Fetch the TelematicsUtilizationData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "12345"
 Then Verify the TelematicsUtilizationData statuscode "200" in response body
 And Validate error message in TelematicsUtilizationData service "Vehicle Not Found"
 
 
 @TelematicsUtilizationDataInvalidToDateFormat @140361 @140362
 Scenario: Fetch the TelematicsUtilizationData service details by passing validfromdate invalidtodate and valid array of vin
 Given Fetch the TelematicsUtilizationData service details using from date "2023-10-14", to date "20-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the TelematicsUtilizationData statuscode "200" in response body
 And Validate error message in TelematicsUtilizationData service "Date cannot represent an invalid date-string"
 
 @TelematicsUtilizationDataInvalidFromDateFormat @140361 @140362
 Scenario: Fetch the TelematicsUtilizationData service details by passing Invalidfromdate validtodate and valid array of vin
 Given Fetch the TelematicsUtilizationData service details using from date "20-10-14", to date "2023-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the TelematicsUtilizationData statuscode "200" in response body
 And Validate error message in TelematicsUtilizationData service "Date cannot represent an invalid date-string"
 