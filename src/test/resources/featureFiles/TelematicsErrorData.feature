@TelematicsErrorData @all

Feature: Test @TelematicsErrorData API service

@TelematicsErrorDataWithAll
 Scenario: Fetch the TelematicsErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsErrorData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "508FGCU32-10718,508FGCU32-10718"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Verify retrieved response is having TelematicsErrorData response
 
@TelematicsErrorDataWithoutVin @outofregressionpack
 Scenario: Fetch the TelematicsErrorData without vin
 Given Fetch the TelematicsErrorData service details using from date "2023-10-14" and to date "2023-12-08"
 Then Verify the TelematicsErrorData statuscode "400" in response body
 And Validate error message in TelematicsErrorData for the field "vin"
 
 @TelematicsErrorDataWithoutFromDate @outofregressionpacks
 Scenario: Fetch the TelematicsErrorData without fromdate
 Given Fetch the TelematicsErrorData service details using to date "2023-12-08" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsErrorData statuscode "400" in response body
 And Validate error message in TelematicsErrorData for the field "fromDate"
 
 @TelematicsErrorDataWithoutToDate @outofregressionspack
 Scenario: Fetch the TelematicsErrorData without todate
 Given Fetch the TelematicsErrorData service details using from date "2023-10-14" and vin numbers "8FGCU32-68060"
 Then Verify the TelematicsErrorData statuscode "400" in response body
 And Validate error message in TelematicsErrorData for the field "toDate"
 
 @TelematicsErrorDataWithOnlyVin
 Scenario: Fetch the TelematicsErrorData service details by passing array of vin
 Given Fetch the TelematicsErrorData service details using vin "508FGCU32-10718"
 Then Verify the TelematicsErrorData statuscode "400" in response body
 And Validate error message in TelematicsErrorData for the field "toDate"
 
 @TelematicsErrorDataInvalidVin
 Scenario: Fetch the TelematicsErrorData by providing invalid vin
 Given Fetch the TelematicsErrorData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "12345"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And check message for TelematicsErrorData service is 'valid'
 
 
 @TelematicsErrorDataToDateFormat
 Scenario: Fetch the TelematicsErrorData service details by passing validfromdate invalidtodate and valid array of vin
 Given Fetch the TelematicsErrorData service details using from date "2023-10-14", to date "202-12-08" and vin numbers "8FGCU25-67740"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Validate error message in TelematicsErrorData service "Date cannot represent an invalid date-string"
 
 @TelematicsErrorDataFromDateFormat
 Scenario: Fetch the TelematicsErrorData service details by passing Invalidfromdate validtodate and valid array of vin
 Given Fetch the TelematicsErrorData service details using from date "202-10-14", to date "2023-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Validate error message in TelematicsErrorData service "Date cannot represent an invalid date-string"
 
 
 @TelematicsErrorDataWithAllFromDates
 Scenario: Fetch the TelematicsErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsErrorData service details using from date "2022-09-13", to date "2022-11-07" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Validate error message in TelematicsErrorData service "The earliest From Date cannot be more than 90 days from the current date"
 
 
 @TelematicsErrorDataWithAllFromDate
 Scenario: Fetch the TelematicsErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsErrorData service details using from date "2023-09-13", to date "2024-01-03" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Validate error message in TelematicsErrorData service "The difference between From Date and To Date should be less than or equal to 90 days"
 
 @TelematicsErrorDataWithFromDate
 Scenario: Fetch the TelematicsErrorData service details by passing fromdate todate and array of vin
 Given Fetch the TelematicsErrorData service details using from date "2024-10-09", to date "2023-01-03" and vin numbers "508FGCU32-10718,508FGCU32-10718,8FGCU25-67740"
 Then Verify the TelematicsErrorData statuscode "200" in response body
 And Validate error message in TelematicsErrorData service "From Date should not be greater than current date"