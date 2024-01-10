@ImpactData @all
Feature: Test ImpactData API services
 
 @GetImpactData @140167
 Scenario: Fetch the Impact Data service details
 Given Fetch the ImpactData service details using from date "2023-10-14", to date "2023-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the impact data statuscode "200" in response body
 And Verify retrieved response is having Impact Data response
 
 @GetImpactDataWithoutVin @Notpartofregressionpack
 Scenario: Fetch the Impact Data without Vin
 Given Fetch the ImpactData service details using from date "2023-10-14" and to date "2023-12-08"
 Then Verify the impact data statuscode "400" in response body
 And Validate error message in Impact Data for the field "vin"
 
  @GetImpactDataWithoutFromDate @Notpartofregressionpacks
 Scenario: Fetch the Impact Data without From Date
 Given Fetch the ImpactData service details using to date "2023-10-14" and vin "8FGCU32-68060"
 Then Verify the impact data statuscode "400" in response body
 And Validate error message in Impact Data for the field "fromDate"
 
   @GetImpactDataWithoutToDate @Notpartsofregressionpacks
 Scenario: Fetch the Impact Data without to Date
 Given Fetch the ImpactData service details using from date "2023-10-14" and vin "8FGCU32-68060"
 Then Verify the impact data statuscode "400" in response body
 And Validate error message in Impact Data for the field "toDate"
 
 @invalidFromDateFormat @140168 @140169 @140171
 Scenario: Fetch the Impact Data service details
 Given Fetch the ImpactData service details using from date "2023-10", to date "2023-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the impact data statuscode "200" in response body
 And Validate error message in Impact Data service "Date cannot represent an invalid date-string"
 
 
 @invalidToDateFormat @140168 @140169 @140171
 Scenario: Fetch the Impact Data service details
 Given Fetch the ImpactData service details using from date "2023-10-08", to date "20-12-08" and vin numbers "8FGCU32-68060,8FGCU25-QA-7FBEHU18"
 Then Verify the impact data statuscode "200" in response body
 And Validate error message in Impact Data service "Date cannot represent an invalid date-string"
 
 @invalidVin @140168
 Scenario: Fetch the Impact Data service details
 Given Fetch the ImpactData service details using from date "2023-10-08", to date "2023-12-08" and vin numbers "1234"
 Then Verify the impact data statuscode "200" in response body
 And Validate error message in Impact Data service "Vehicle Not Found"
 