package Steps;

import com.company.Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");

        DRIVER = new ChromeDriver(options);
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(){
        DRIVER.quit();
    }
}
