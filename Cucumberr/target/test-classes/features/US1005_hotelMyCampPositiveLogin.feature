Feature: US1005 dogru kullanici adi ve sifre ile giris yapilabilmeli

  @sirali @pr1
  Scenario: TC08 kullanici gecerli bilgilerle giris yapar
    Given kullanici "HMCUrl" anasayfasinda
    Then Log in yazisina tiklar
    And gecerli username girer
    And gecerli password girer
    And Login butonuna basar
    Then sayfaya giris yaptigini kontrol eder
    And sayfayi kapatir