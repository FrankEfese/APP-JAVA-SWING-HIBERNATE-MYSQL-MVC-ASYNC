package PackageSeguros;

import PackageEmpresas.Empresas_Object;
import Proyecto_Java.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Seguros_Controlador {

    // MODELO-SEGURO
    Seguros_Modelo modeloSeguro = new Seguros_Modelo(HibernateUtil.getSessionFactory());

    // CONSTRUCTOR
    public Seguros_Controlador() {
    }

    // METODO PARA OBTENER TODOS LOS SEGUROS (CONTROLADOR)
    public CompletableFuture<List<Seguros_Object>> obtenerTodosSeguros_C() {
        return CompletableFuture.supplyAsync(() -> this.modeloSeguro.obtenerTodosSeguros_M());
    }

    // METODO PARA GUARDAR EL SEGURO (CONTROLADOR)
    public CompletableFuture<Void> guardarSeguro_C(Seguros_Object seguro) {
        return CompletableFuture.runAsync(() -> this.modeloSeguro.guardarSeguro_M(seguro));
    }

    // METODO PARA OBTENER UN SEGURO (CONTROLADOR)
    public CompletableFuture<Seguros_Object> obtenerSeguro_C(int idSeguro) {
        return CompletableFuture.supplyAsync(() -> this.modeloSeguro.obtenerSeguro_M(idSeguro));
    }

    // METODO PARA ACTUALIZAR EL SEGURO (CONTROLADOR)
    public CompletableFuture<Void> actualizarSeguro_C(Seguros_Object seguro) {
        return CompletableFuture.runAsync(() -> this.modeloSeguro.actualizarSeguro_M(seguro));
    }

    // METODO PARA ELIMINAR UN SEGURO (CONTROLADOR)
    public CompletableFuture<Void> eliminarSeguro_C(int idSeguro) {
        return CompletableFuture.runAsync(() -> this.modeloSeguro.eliminarSeguro_M(idSeguro));
    }

    // METODO PARA OBTENER LAS EMPRESAS ASEGURADAS (CONTROLADOR)
    public CompletableFuture<List<Empresas_Object>> obtenerEmpresasPorSeguro_C(int idSeguro) {
        return CompletableFuture.supplyAsync(() -> this.modeloSeguro.obtenerEmpresasPorSeguro_M(idSeguro));
    }
    
    // METODO PARA OBTENER EL TOTAL DE SEGUROS (CONTROLADOR)
    public CompletableFuture<Integer> totalSeguros_C(){
        return CompletableFuture.supplyAsync(() -> this.modeloSeguro.obtenerTotalSeguros_M());
    }

    // METODO PARA COMPROBAR LA EXISTENCIA DEL NOMBRE DEL SEGURO
    public CompletableFuture<Boolean> nombreExistente(String nombre) {
        
        return obtenerTodosSeguros_C().thenApply(seguros -> {
            for (Seguros_Object aux : seguros) {
                if (aux.getNombre().equals(nombre)) {
                    return true;
                }
            }
            return false;
        }).exceptionally(ex -> {
            return false;          
        });
    }

    // METODO PARA OBTENER FILA SELECCIONADA DE LA TABLA
    public CompletableFuture<Integer> obtenerFilaTabla(Seguros_Object seguro) {
        if (seguro != null) {
            
            return obtenerTodosSeguros_C().thenApply(seguros -> {           
                for (Seguros_Object aux : seguros) {
                    if (aux.getId_seguro() == seguro.getId_seguro()) {
                        return seguros.indexOf(aux);
                    }
                }               
                return -1;            
            }).exceptionally(ex -> {
                return -1;
            });
            
        } else {
            return CompletableFuture.completedFuture(-1);
        }
    }

}
