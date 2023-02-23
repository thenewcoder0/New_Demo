package base.com;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Demo {
	static WebDriver driver;
	
	public static WebDriver browser_launch() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static void url(String s) {
		driver.get(s);
	}
	public static void sendkeys(WebElement w, String s) {
		w.sendKeys(s);
	}
	public static void click(WebElement w) {
		w.click();
	}
	
	public static void clear(WebElement c) {
		c.clear();

	}
	public static void selectByIndex(WebElement e, int i) {
		Select s=new Select(e);
		s.selectByIndex(i);
	}
	public static void selectByValue(WebElement w, String i) {
		Select s=new Select(w);
		s.selectByValue(i);
	}
	public static void selectbyVisible(WebElement w, String j) {
		Select s=new Select(w);
		s.selectByVisibleText(j);
		
	}
	public static void screenshot(String s) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f=new File("C:\\Users\\haria\\eclipse-workspace\\Project\\Screenshot"+s+".png");
		FileUtils.copyFile(screenshotAs, f);
	}
	public static void action( WebElement s) {
		Actions a= new Actions(driver);
		a.contextClick(s);
		a.build().perform();
	}
	public static void robot( int i,int j) throws Throwable {
		Robot r=new Robot();
		r.keyPress(i);
		r.keyRelease(j);
	}
	public static void alert(String s) {
		Alert alert = driver.switchTo().alert();
		if (s.equalsIgnoreCase("accept")) {
			alert.accept();
			
		} else {
			alert.dismiss();
		}}
	
	public static void implicitWait(int s) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
		}
	public static void quit() {
			driver.quit();
		}
	public static String values;
	
	public static String Read_data(int r, int c) throws Throwable {
		File f=new File("C:\\Users\\haria\\eclipse-workspace\\Maven\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w =new XSSFWorkbook(fi);
		Sheet sheetAt = w.getSheet("Sheet5");
		Row row = sheetAt.getRow(r);
		Cell cell = row.getCell(c);
		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {
			values = cell.getStringCellValue();
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int value1=(int) numericCellValue;
			values = String.valueOf(value1);
		}
		return values; 

	}


}




