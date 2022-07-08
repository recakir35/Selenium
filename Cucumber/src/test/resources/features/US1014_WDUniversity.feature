@university
Feature: US1014 kullanici baska window gecer

  Scenario:TC19 kullanici baska window gecip islem yapabilmeli
    Given kullanici "WDUniversity" anasayfasinda
    And Login Portal'a kadar asagi iner
    Then Login Portal'a tiklar
    And Diger window'a gecer
    And "WDUWrongUsername" ve "WDUWrongPasword" kutularina deger yazar
    Then login butonuna basar
    And Popup'ta cikan yazinin validation failed oldugunu test eder
    Then Ok diyerek Popup'i kapatir
    Then Ilk sayfaya geri doner
    And  Ilk sayfaya donuldugunu test eder
    Then sayfayi kapatir