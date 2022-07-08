# amazon sayfasına gidip sırasiyla nutella, java, elma, armut aratıp
  # sonucların arama yaptığımız kelimeyi içerdiğini test edelim

  Feature: US1007 kullanici amazonda istediği kelimeleri aratır

    Scenario Outline: TC12 amazonda listedeki elementleri aratma
      Given kullanici "amazonUrl" anasayfasinda
      Then kullanici "<istenenKelime>" icin arama yapar
      And sonuclarin "<istenenKelimeKontrol>" icerdigini test eder
      And sayfayi kapatir

      Examples:
      |istenenKelime|istenenKelimeKontrol|
      |nutella      |nutella             |
      |java         |java                |
      |elma         |elma                |
      |armut        |armut               |