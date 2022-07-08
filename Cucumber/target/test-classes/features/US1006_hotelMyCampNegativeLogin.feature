#hotel my camp sitesinde 3 adet negative test senaryosu oluşturalım
  #1- doğru username-yanlış password
  #2- yanlış username-dogru password
  #2- yanlış username-yanlış password

  Feature: US1006 yanlis bilgilerle siteye giris yapılmaz

    @smoke @regiration @haftalik
    Scenario: TC09 yanlis password ile giris yapilamaz
      Given kullanici "HMCUrl" anasayfasinda
      Then Log in yazisina tiklar
      And gecerli username girer
      And gecersiz password girer
      And Login butonuna basar
      Then sayfaya giris yapilamadigini test eder
      And sayfayi kapatir

    @smoke @aylik @pr1
    Scenario: TC10 yanlis kullanici adi ile giris yapilamaz
      Given kullanici "HMCUrl" anasayfasinda
      Then Log in yazisina tiklar
      And gecersiz username girer
      And gecerli password girer
      And Login butonuna basar
      Then sayfaya giris yapilamadigini test eder
      And sayfayi kapatir

    @smoke @regiration @pr2
    Scenario: TC11 yanlis kullanici adi ve yanlis sifre ile giris yapilamaz
      Given kullanici "HMCUrl" anasayfasinda
      Then Log in yazisina tiklar
      And gecersiz username girer
      And gecersiz password girer
      And Login butonuna basar
      Then sayfaya giris yapilamadigini test eder
      And sayfayi kapatir