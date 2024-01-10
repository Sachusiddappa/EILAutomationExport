@TelematicsAggregatedErrorData @all

@140678 @140680 @140681 @140684 @140686 @140689 @140690 @140691 @140692

Feature: Test TelematicsAggregatedErrorData API service

@TelematicsAggregatedErrorDataWithAll
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "508FGCU32-10718,508FGCU32-10718"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Verify retrieved response is having telematicsAggregatedErrorData response
 
@TelematicsAggregatedErrorDataWithoutVin @outofregressionpack
 Scenario: Fetch the TelematicsAggregatedErrorData without vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-10-14" and to date "2023-12-08"
 Then Verify the TelematicsAggregatedErrorData statuscode "400" in response body
 And Validate error message in telematicsAggregatedErrorData for the field "vin"
 
 @TelematicsAggregatedErrorDataWithoutFromDate @outofregressionpacks
 Scenario: Fetch the TelematicsAggregatedErrorData without fromdate
 Given Fetch the TelematicsAggregatedErrorData service details using to date "2023-12-08" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsAggregatedErrorData statuscode "400" in response body
 And Validate error message in telematicsAggregatedErrorData for the field "fromDate"
 
 @TelematicsAggregatedErrorDataWithoutToDate @outofregressionspack
 Scenario: Fetch the TelematicsAggregatedErrorData without todate
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-10-14" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsAggregatedErrorData statuscode "400" in response body
 And Validate error message in telematicsAggregatedErrorData for the field "toDate"
 
 @TelematicsAggregatedErrorDataWithOnlyVin
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using vin "508FGCU32-10718"
 Then Verify the TelematicsAggregatedErrorData statuscode "400" in response body
 And Validate error message in telematicsAggregatedErrorData for the field "toDate"
 
 @TelematicsAggregatedErrorDataInvalidVin
 Scenario: Fetch the TelematicsAggregatedErrorData by providing invalid vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "12345"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "Vehicle Not Found"
 
 
 @TelematicsAggregatedErrorDataToDateFormat
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing validfromdate invalidtodate and valid array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-10-14", to date "202-12-08" and vin numbers "8FGCU25-67740"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "Date cannot represent an invalid date-string"
 
 @TelematicsAggregatedErrorDataFromDateFormat
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing Invalidfromdate validtodate and valid array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "202-10-14", to date "2023-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "Date cannot represent an invalid date-string"
 
 
 @TelematicsAggregatedErrorDataWithAllFromDate
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2022-09-13", to date "2022-11-07" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "The earliest From Date cannot be more than 90 days from the current date"
 
 
 @TelematicsAggregatedErrorDataWithAllFromDate
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2023-09-01", to date "2023-12-30" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "The difference between From date and To date should be less than or equal to 90 days"
 
 @TelematicsAggregatedErrorDataWithFromDate
 Scenario: Fetch the TelematicsAggregatedErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsAggregatedErrorData service details using from date "2024-10-09", to date "2023-01-03" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsAggregatedErrorData statuscode "200" in response body
 And Validate error message in TelematicsAggregatedErrorData service "From Date should not be greater than current date"