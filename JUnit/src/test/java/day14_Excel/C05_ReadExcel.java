package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //1. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //4. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // sayfa 2'ye gidip satır sayısının 24 kullanılan satır sayısının 17 olduğunu test edin
        int sonSatir=workbook.getSheet("Sayfa2").getLastRowNum()+1;
        int expectedSatirSayisi=24;

        Assert.assertEquals(expectedSatirSayisi,sonSatir);

        int kullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=17;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);
    }
}
