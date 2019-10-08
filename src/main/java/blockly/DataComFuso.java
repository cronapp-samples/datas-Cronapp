package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DataComFuso {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// DataSimples
public static Var mostrar() throws Exception {
 return new Callable<Var>() {

   private Var dataServidorOrigemTela = Var.VAR_NULL;
   private Var dataServidorOrigemBanco = Var.VAR_NULL;

   public Var call() throws Exception {
    dataServidorOrigemTela = cronapi.screen.Operations.getValueOfField(Var.valueOf("Noticia.active.publicadaEm"));
    dataServidorOrigemBanco = cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("app.entity.Noticia"),Var.valueOf("select n from Noticia n where n.id = :id"),Var.valueOf("id",cronapi.screen.Operations.getValueOfField(Var.valueOf("Noticia.active.id")))), Var.valueOf("this[0].publicadaEm"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), dataServidorOrigemBanco);
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), dataServidorOrigemTela);
    System.out.println(dataServidorOrigemBanco.getObjectAsString());
    System.out.println(dataServidorOrigemTela.getObjectAsString());
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), cronapi.dateTime.Operations.formatDateTime(dataServidorOrigemBanco, Var.valueOf("dd/MM/yyyy")));
    System.out.println(cronapi.dateTime.Operations.formatDateTime(dataServidorOrigemBanco, Var.valueOf("dd/MM/yyyy")).getObjectAsString());
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), cronapi.dateTime.Operations.formatDateTime(dataServidorOrigemBanco, Var.valueOf("dd/MM/yyyy"), Var.valueOf(-3)));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void criaData() throws Exception {
  new Callable<Var>() {

   private Var novaData = Var.VAR_NULL;

   public Var call() throws Exception {
    novaData = cronapi.conversion.Operations.stringToDate(Var.valueOf("2012-01-31 23:59:59"), Var.valueOf("yyyy-MM-dd HH:mm:ss"));
    System.out.println(novaData.getObjectAsString());
    novaData = cronapi.conversion.Operations.stringToDate(Var.valueOf("2012-01-31 23:59:59"), Var.valueOf("yyyy-MM-dd HH:mm:ss"), Var.valueOf(-3));
    System.out.println(novaData.getObjectAsString());
   return Var.VAR_NULL;
   }
 }.call();
}

}

