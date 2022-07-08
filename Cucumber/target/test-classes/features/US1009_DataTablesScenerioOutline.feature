Feature: US1009 DataTables sitesine 5 farkli giris yapalim

  Scenario Outline: TC14 kullanici 5 farkli kayit girisi yapabilmeli

    When kullanici "datatablesUrl" anasayfasinda
    Then new butonuna basar
    And firstname bolumuna "<firstname>" yazar
    And kullanici 1 sn bekler
    And lastname bolumuna "<lastname>" yazar
    And kullanici 1 sn bekler
    And position bolumuna "<position>" yazar
    And kullanici 1 sn bekler
    And office bolumuna "<office>" yazar
    And kullanici 1 sn bekler
    And extension bolumuna "<extension>" yazar
    And kullanici 1 sn bekler
    And startDate bolumuna "<startDate>" yazar
    And kullanici 1 sn bekler
    And salary bolumuna "<salary>" yazar
    And Create tusuna basar
    When kullanici "<firstname>" ile arama yapar
    Then isim bolumunde "<firstname>" oldugunu test eder
    But sayfayi kapatir

    Examples:
      | firstname | lastname | position   | office    | extension | startDate | salary |
      | Alim     | Yazar    | qa         | Ankara    | UI        | 2022-03-12 | 1000 |
      | Veli     | Sarar    | tester     | istanbul  | api       | 2021-03-12 | 2000 |
      | Sami     | Karar    | BA         | office    | -         | 2022-04-12 | 3000 |
      | Recep    | Zarar    | PO         | office    | UI        | 2022-03-22 | 4000 |
      | Ayse     | Fayda    | qa Analist | kastamonu | api       | 2022-05-10 | 5000 |

