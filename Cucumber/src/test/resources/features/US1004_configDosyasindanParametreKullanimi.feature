Feature: US1004 Kullanici parametre ile configuration file'i kullanabilmeli
@pr2
  Scenario: TC07 configuration properties dosyasindan parametre kullanimi
    Given kullanici "brcUrl" anasayfasinda
    Then kullanici 15 sn bekler
    And url'in "blue" icerdiğini test eder
    Then sayfayi kapatir