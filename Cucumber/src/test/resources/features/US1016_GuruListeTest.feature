Feature: US1016 Guru Web Tables
  Scenario:  TC_21 kullanici liste alabilmeli
    Given kullanici "guruUrl" anasayfasinda
    Then "Company", sutunundaki tum degerleri yazdirir
    And   "UCO Bank" sirketinin listede oldugunu test eder
    And sayfayi kapatir
