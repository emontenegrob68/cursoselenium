package codigo.unidad2.pages;

import codigo.unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class BEmpresaPage extends ClaseBase {
    //CENTRALIZAR LOCALIZADORES

    //By locatorEmpresasHC = By.id("widgetNavbar/banca-empresas/hazte-cliente");
    By locatorHazteClienteE = By.linkText("Hazte Cliente");
    //By locatorRutE = By.xpath("RUT Empresa");
    //By locatorRutE = By.xpath("RUT Empresa");
    By locatorRutE = By.cssSelector("rut");

    //By locatorHeader = By.cssSelector("new-header");

    //constructor

    public BEmpresaPage(WebDriver driver) { super(driver); }

    public void irHazteClienteE() {
        System.out.println(" linkEmpresasHC : "+locatorHazteClienteE);

        //click(esperarPorElementoAClickear(buscarElementoWebEnShadowDOM(obtenerShadowDOM(locatorHeader), locatorHazteClienteE)));
        click(esperarPorElementoAClickear(locatorHazteClienteE));
        click(locatorHazteClienteE);
    }

    //ACCIONES
    public void ingresarRutE(String rutE){
        agregarTexto(esperarPorElementoVisible(buscarElementoWeb(locatorRutE)),rutE);
    }

}
