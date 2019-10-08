package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DataSimples {

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
    dataServidorOrigemTela = cronapi.screen.Operations.getValueOfField(Var.valueOf("Cartorio.active.data"));
    dataServidorOrigemBanco = cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("app.entity.Cartorio"),Var.valueOf("select c from Cartorio c where c.id = :id"),Var.valueOf("id",cronapi.screen.Operations.getValueOfField(Var.valueOf("Cartorio.active.id")))), Var.valueOf("this[0].data"));
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

}

