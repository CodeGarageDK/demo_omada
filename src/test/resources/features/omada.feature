Feature: omada feature

  @test1
  Scenario: Open Omada Identity Cloud
    Given I Open Omada front page
    When I through the top menu selects Products => Omada Identity Cloud
    Then the Omada Identity Cloud Page loads as expected

  @test2
  Scenario: Open Omada Identity Cloud ver2
    Given I Open Omada front page
    When I through the bottom menu selects Omada Identity Cloud
    Then the Omada Identity Cloud Page loads as expected

  @test3
  Scenario: Open Omada Careers page and search for job openings
    Given I Open Omada front page
    When I through the top menu selects Company => Careers
    And I on Carreers page selects button - search our job openings
    Then the CandidateHR site loads as expected

  @test4
  Scenario: Open Omada Careers page and check if 2 peoples information is correct
    Given I Open Omada front page
    When I through the top menu selects Company => Careers
    And I on Carreers page select Gry Collignon
    Then I expect the Persons text to be equal with "src/test/resources/validation_texts/GryCollignon.txt"
    When I close the person
    And I on Carreers page select Daria Czajkowska
    Then I expect the Persons text to be equal with "src/test/resources/validation_texts/DariaCzajkowska.txt"
