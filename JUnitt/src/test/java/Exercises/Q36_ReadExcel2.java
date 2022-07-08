package Exercises;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Q36_ReadExcel2 {
    @Test
    public void test01() throws IOException {
        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Cell istenenHucre = workbook.getSheet("Sayfa1").getRow(0).getCell(1);
        System.out.println(" *** 1- 2.Hücre Datası: " + istenenHucre);

        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData = "Kabil";
        String actualData = String.valueOf(workbook.getSheet("Sayfa1").getRow(1).getCell(3));
        Assert.assertEquals(expectedData, actualData);

        //Satir sayisini bulalim
        System.out.println(" *** 2- Satır Sayısı: " +workbook.getSheet("Sayfa1").getLastRowNum());
        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(" *** 3- Fiziki olarak kullanılan Satır Sayısı: " +(workbook.getSheet("Sayfa1").getLastRowNum())+1);
        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<Cell, Cell> ulkeIsimleriveBaskentler=new HashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            ulkeIsimleriveBaskentler.put(workbook.getSheet("Sayfa1").getRow(i).getCell(0),workbook.getSheet("Sayfa1").getRow(i).getCell(1));
        }
        System.out.println(ulkeIsimleriveBaskentler);

    }


}
