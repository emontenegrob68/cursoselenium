package codigo.unidad2.pages;

import codigo.unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class HomePage extends ClaseBase {
    //CENTRALIZAR LOCALIZADORES
    By localorHazteCliente = By.linkText("Hazte Cliente");
    By locatorBancaEmpresas = By.linkText("Banca Empresas");
    By locatorSegurosEmpresas = By.linkText("Seguros Empresas");
    By locatorIntermediarios = By.id("dropdown-intermediarios");

    By locatorHeader = By.cssSelector("new-header");
    //constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //la homepage no tiene un driver...dicho driver se obtendra de la base...a traves del constructor de la superclase
    //2) Atributos (Caracteristicas)

    //3) Mètodos (Acciones)

    //DEFINIR ACCIONES
    public void irHazteCliente(){
        click(esperarPorElementoAClickear(buscarElementoWebEnShadowDOM(obtenerShadowDOM(locatorHeader),localorHazteCliente)));
        //click(esperarPorElementoAClickear(localorHazteCliente));
        //click(localorHazteCliente);
    }




    public void BancaEmpresas(){
        //By locatorBancaEmpresas = By.linkText("Banca Empresas");
        //click(esperarPorElementoAClickear(locatorBancaEmpresas));
        SearchContext shadowa = driver.findElement(By.cssSelector("new-header")).getShadowRoot();

        shadowa.findElement(locatorBancaEmpresas).click();

        System.out.println(" linkBancaEmpresas : "+locatorBancaEmpresas);

    }

    public void SegurosEmpresas(){
        //By locatorSegurosEmpresas = By.linkText("Seguros Empresas");
        SearchContext shadowb = driver.findElement(By.cssSelector("new-header")).getShadowRoot();

        shadowb.findElement(locatorSegurosEmpresas).click();

        System.out.println(" linkSegurosEmpresas : "+locatorSegurosEmpresas);

        //Thread.sleep(20000);
    }

    public void Intermediarios(){
        //By locatorIntermediarios = By.linkText("Intermediarios");
        SearchContext shadowc = driver.findElement(By.cssSelector("new-header")).getShadowRoot();

        shadowc.findElement(locatorIntermediarios).click();

        System.out.println(" linkIntermediarios : "+locatorIntermediarios);

    }



}
