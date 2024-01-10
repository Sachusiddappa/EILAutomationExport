@GetTelematicsEquipmentCount @all
Feature: Validate GetTelematicEquipmentCount APIs

  @GetTelematicsEquipmentCountAllFilters @134188
  Scenario Outline: To validate GetTelematicsEquipmentCount by using CustomeridorcustomerGrid with limit activeIndicator telematicsStatus
    Given Fetch the GetTelematicsEquipmentCount details using telematicStatus '<telematicsStatus>', customerId '<customerGRId>', activeIndicator '<activeIndicator>' and limit '<limit>'
    Then Verify the GetTelematicsEquipmentCount statuscode '<statusCode>' in response body
    And check GetTelematicsEquipmentCount retrieved data is '<typeOfData>'

    Examples: 
      | limit | customerGRId | statusCode | typeOfData | activeIndicator | telematicsStatus |
      |    10 |     49360906 |        200 | valid      | Y               | N                |
      |    10 |     49360906 |        200 | invalid    | N               | Y                |
      |    10 |     49360906 |        200 | valid      | Y               | Y                |
      |    10 |     49360906 |        200 | invalid    | N               | N                |

  @GetTelematicsEquipmentCountMultiple @134189 @134190
  Scenario: Validate GetTelematicsEquipmentCount service with multiple values
    Given Fetch the GetTelematicsEquipmentCount data details with multiple telematicStatus "Y,N",CustomerGrId "49360906,50034487",activeIndicator "Y,N" and limit "10"
    Then Verify the GetTelematicsEquipmentCount statuscode '200' in response body
    And Verify retrieved response is having GetTelematicsEquipmentCount response

  @GetTelematicsErrorMessage @134191
  Scenario: Validate GetTelematicsEquipmentCount service without customerGrid
    Given Fetch the GetTelematicsEquipmentCount details using telematicStatus "Y", activeIndicator "N" and limit "10"
    Then Verify the GetTelematicsEquipmentCount statuscode '200' in response body
    And Validate GetTelematicsEquipmentCount error message "Bad input request: Either one of fields customerid or customergrid is required"

  @GetTelematicsErrorMessageforLowerCaseToTelematicsStatusorActiveIndicator
  Scenario: Validate GetTelematicsEquipmentCount service by passing lowercase or invalid to telematicStatus
    Given Fetch the GetTelematicsEquipmentCount data details using telematicStatus "y", activeIndicator "N", limit "10" and CustomerGrId "49360906"
    Then Verify the GetTelematicsEquipmentCount statuscode '400' in response body
    And Validate GetTelematicsEquipmentCount data error message "Did you mean the enum value"

    
  #@arrayofCustomeridorcustomerGridonly
  #Scenario: To validate equipment count by using arrayofCustomeridorcustomerGridonly
    #Given Fetch the equipment count using customerGRId "49360906,50034487"
    #Then Verify the statuscode '200' in response body
#
  #@arrayofCustomeridorcustomerGrid:with_limit
  #Scenario: To validate equipment count by using arrayofCustomeridorcustomerGrid with limit
    #Given Fetch the equipment count using customerGRId "49360906,50034487" limit "50"
    #Then Verify the statuscode '200' in response body
#
  #@arrayofCustomeridorcustomerGrid:with_activeIndicator_telematicsStatus
  #Scenario: To validate equipment count by using arrayofCustomeridorcustomerGrid with telematicsStatus and activeIndicator
    #Given Fetch the equipment count using customerGRId "49360906,50034487" telematicsStatus "Y,N" activeIndicator "Y,N"
    #Then Verify the statuscode '200' in response body
#
  #@arrayofCustomeridorcustomerGrid:with_activeIndicatorstatusYandN
  #Scenario: To validate equipment count by using arrayofCustomeridorcustomerGrid with activeIndicatorstatusYandN
    #Given Fetch the equipment count using customerGRId "49360906,50034487" and activeIndicator "Y,N"
    #Then Verify the statuscode '200' in response body
#
  #@arrayofCustomeridorcustomerGrid:with_telematicsStatusYandN
  #Scenario: To validate equipment count by using arrayofCustomeridorcustomerGrid with telematicsStatusYandN
    #Given Fetch the equipment count using customerGRId "49360906,50034487" and telematicsStatus "Y,N"
    #Then Verify the statuscode '200' in response body
