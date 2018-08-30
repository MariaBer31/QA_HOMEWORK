Feature: Delfi check comments test

  Scenario: Check comments count on delfi page
    Given Delfi home page
    When we are searching for article with text Бесплатной медицины в Латвии стало меньше
    Then we are getting full article text and compare with article name on article page
    When redirecting to comment page
    Then expect comment count is equals to comment count on main page