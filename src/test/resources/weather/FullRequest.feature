Feature: Testing weather in London
  Scenario: Weather parameter full test
    When we getting weather from server
    Then lon is -0.13
    And lat is 51.51

    Then weather id is 300
    And weather main is Drizzle
    And weather description is light intensity drizzle
    And weather icon is 09d

    Then base is stations

    Then temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min is 279.15
    And temp_max is 281.15

    Then visibility is 10000

    Then wind speed is 4.1
    And wind deg is 80

    Then Clouds are 90

    Then dt is 1485789600

    Then Sys type is 1
    And Sys id is 5091
    And message is 0.0103
    And country is GB
    And sunrise is 1485762037
    And sunset is 1485794875

    Then id is 2643743
    Then name is London
    Then cod is 200
