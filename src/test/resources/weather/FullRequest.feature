Feature: Testing weather in London

  Scenario: Weather parameter full test
    When we getting weather from server
    Then lon is -0.13
    And lat is 51.51

    And weather id is 300
    And weather main is Drizzle
    And weather description is light intensity drizzle
    And weather icon is 09d

    And base is stations

    And temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min is 279.15
    And temp_max is 281.15

    And visibility is 10000

    And wind speed is 4.1
    And wind deg is 80

    And Clouds are 90

    And dt is 1485789600

    And Sys type is 1
    And Sys id is 5091
    And message is 0.0103
    And country is GB
    And sunrise is 1485762037
    And sunset is 1485794875

    And id is 2643743
    And name is London
    And cod is 200
