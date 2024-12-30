package PackageEmpresas;

import PackageEmpleados.Empleados_Object;
import PackageProductos.Productos_Object;
import Proyecto_Java.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Empresas_Controlador {

    // MODELO-EMPRESA
    private final Empresas_Modelo modeloEmpresas = new Empresas_Modelo(HibernateUtil.getSessionFactory());

    // CONSTRUCTOR
    public Empresas_Controlador() {
    }

    // METODO PARA OBTENER TODOS LAS EMPRESAS (CONTROLADOR)
    public CompletableFuture<List<Empresas_Object>> obtenerTodasEmpresas_C() {
        return CompletableFuture.supplyAsync(() -> this.modeloEmpresas.obtenerTodasEmpresas_M());
    }

    // METODO PARA GUARDAR LA EMPRESA (CONTROLADOR)
    public CompletableFuture<Void> guardarEmpresa_C(Empresas_Object empresa) {
        return CompletableFuture.runAsync(() -> this.modeloEmpresas.guardarEmpresa_M(empresa));
    }

    // METODO PARA ELIMINAR UNA EMPRESA (CONTROLADOR)
    public CompletableFuture<Void> eliminarEmpresa_C(int idEmpresa) {
        return CompletableFuture.runAsync(() -> this.modeloEmpresas.eliminarEmpresa_M(idEmpresa));
    }

    // METODO PARA OBTENER UNA EMPRESA (CONTROLADOR)
    public CompletableFuture<Empresas_Object> obtenerEmpresa_C(int idEmpresa) {
        return CompletableFuture.supplyAsync(() -> this.modeloEmpresas.obtenerEmpresa_M(idEmpresa));
    }

    // METODO PARA ACTUALIZAR LA EMPRESA (CONTROLADOR)
    public CompletableFuture<Void> actualizarEmpresa_C(Empresas_Object empresa) {
        return CompletableFuture.runAsync(() -> this.modeloEmpresas.actualizarEmpresa_M(empresa));
    }
    
    // METODO PARA OBTENER LOS EMPLEADOS (CONTROLADOR)
    public CompletableFuture<List<Empleados_Object>> obtenerEmpleadosDeEmpresa_C(int idEmpresa){
       return CompletableFuture.supplyAsync(() -> this.modeloEmpresas.obtenerEmpleadosDeEmpresa_M(idEmpresa));
    }
    
    // METODO PARA OBTENER LOS PRODUCTOS (CONTROLADOR)
    public CompletableFuture<List<Productos_Object>> obtenerProductosDeEmpresa_C(int idEmpresa){
        return CompletableFuture.supplyAsync(() -> this.modeloEmpresas.obtenerProductosDeEmpresa_M(idEmpresa));
    }
    
    // METODO PARA OBTENER EL TOTAL DE EMPRESAS (CONTROLADOR)
    public CompletableFuture<Integer> totalEmpresas(){
        return CompletableFuture.supplyAsync(() -> this.modeloEmpresas.obtenerTotalEmpresas_M());
    }

    // METODO PARA COMPROBAR LA EXISTENCIA DEL ID-EMPRESARIAL
    public CompletableFuture<Boolean> idEmpresarialExistente(String idEmp) {
        
            return obtenerTodasEmpresas_C().thenApply(empresas -> {           
                for(Empresas_Object aux : empresas){              
                    if (aux.getId_empresarial().equals(idEmp)) {
                        return true;
                    }                   
                }               
                return false;                              
            }).exceptionally(ex -> {
                return false;
            });       
    }

    // METODO PARA OBTENER FILA SELECCIONADA DE LA TABLA
    public CompletableFuture<Integer> obtenerFilaTabla(Empresas_Object empresa) {
        if (empresa != null) {
            
            return obtenerTodasEmpresas_C().thenApply(empresas -> {           
                for (Empresas_Object aux : empresas) {
                    if (aux.getId_empresa() == empresa.getId_empresa()) {
                        return empresas.indexOf(aux);
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
