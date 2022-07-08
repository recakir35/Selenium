Feature: US1012 Dinamik_url test

  Scenario Outline: TC17_yazilan_her_url’e_gitmeli
    Given kullanici "<sayfa_Url>" anasayfasinda
    And url'in "<sayfa_Url>" oldugunu test eder
    And sayfayi kapatir

    Examples:
    |sayfa_Url|
    |amazonUrl|
    |facebookUrl|
