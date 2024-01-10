@EquipmentTelematcisStatus @all
Feature: Test the TelematicsStatus for the Vin along with the customerID or with only the customerId

  @EquipmentTelematicsStatusWithVinAndCustomerID @135166 @135171
  Scenario: Test the TelematicsStatus for the Vin along with the customerID
    Given check the TelematicsStatus by using vin '508FGCU32-10718' and customerId '0000100492'
    Then Verify the TelematicsStatus statuscode '200' in response body
    
      #| vin             | customerId | statuscode |
      #| 508FGCU32-10718 | 0000100492 |        200 |
      #| 508FGCU32-11405 | 0000100492 |        200 |
      #| 8FGCU32-68060   | 0000100492 |        200 |

  @EquipmentTelematicsStatusWithCustomerID @135171
  Scenario: Test the TelematicsStatus only with the customerID or customerGrid
    Given check the TelematicsStatus by using customerId '0000100492'
    Then Verify the TelematicsStatus statuscode '200' in response body

  @EquipmentTelematicsStatusWithVin
  Scenario: Test the TelematicsStatus only with the vin
    Given check the TelematicsStatus by using vin '508FGCU32-10718'
    Then Verify the TelematicsStatus statuscode '200' in response body
    And validate the error message for the customerId
