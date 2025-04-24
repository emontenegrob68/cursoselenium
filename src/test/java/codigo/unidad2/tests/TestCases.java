package codigo.unidad2.tests;

import codigo.unidad2.pages.BEmpresaPage;
import codigo.unidad2.pages.HomePage;
import codigo.unidad2.pages.RegisterPage;
import org.apache.commons.math3.stat.inference.GTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TestCases {
    //Definir Atributos
    private WebDriver driver; //NULL

    //Pages
    private HomePage home; //NULL
    private RegisterPage register; //NULL
    private BEmpresaPage hcempresa;
    private static String browser;
    private static String ruta;
    private static String property;

    @BeforeAll
    public static void preparacionSuite(){
        System.out.println("Preparando suite de pruebas...");
        System.out.println("seteando properties del driver");
        browser = "chrome";
        ruta = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        property = "webdriver.chrome.driver";
    }

    @BeforeEach
    public void preparacionTests(){
        home = new HomePage(driver);
        home.conexionDriver(browser,ruta,property);
        register = new RegisterPage(home.getDriver());
        hcempresa = new BEmpresaPage(home.getDriver());
        home.prepararEsperas(Duration.ofSeconds(20));
        home.cargarSitio("https://sitio.consorcio.cl/"); //NO DEBERIAMOS DEJAR EN DURO PARAMETROS DE CONFIGURACIÒN
        home.maximizarBrowser();
    }

    @AfterEach
    public void posTests(){

    }

    @Test
    public void TC001_ErrorCreacionCta(){
        home.irHazteCliente();
        register.ingresarRut("123456778"); //NO DEBERIAMOS PASAR DATA EN DURO
        register.seleccionarNacionalidadChilena();
        Assertions.assertEquals("El Rut ingresado no es válido",register.obtenerMensajeError()); //NO DEBERIAMOS PASAR DATA EN DURO
    }

    // prueba 1
    @Test
    public void TC001_MenuBancaEmpresas(){
        home.BancaEmpresas();
        hcempresa.irHazteClienteE();
        hcempresa.ingresarRutE("123456778");
        //Assertions.assertEquals("El Rut xx ingresado no es válido",register.obtenerMensajeError());
    }

    // prueba 2
    @Test
    public void TC002_MenuSegurosEmpresas(){
        home.SegurosEmpresas();
        //Assertions.assertEquals("El Rut xx ingresado no es válido",register.obtenerMensajeError());
    }

    // prueba 3
    @Test
    public void TC003_MenuIntermediarios(){
        home.Intermediarios();
        //Assertions.assertEquals("El Rut xx ingresado no es válido",register.obtenerMensajeError());
    }

}
