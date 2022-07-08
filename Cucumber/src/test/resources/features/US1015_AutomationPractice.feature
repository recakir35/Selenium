Feature: US1015 Kullanici @işareti olmadan email adresi yazar

  Scenario:TC20 kullanici gecersiz email yazamamali
    Given kullanici "automationUrl" anasayfasinda
    And user sign in linkine tiklar
    And email kutusuna @isareti olmayan email adresi yazar ve enter'a tiklar
    Then error mesajinin “Invalid email address” oldugunu dogrulayin
    And sayfayi kapatir
