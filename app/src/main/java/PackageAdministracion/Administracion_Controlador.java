package PackageAdministracion;

import PackageLogin.Login_Object;
import Proyecto_Java.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Administracion_Controlador {

    // MODELO-ADMINISTRACION
    private final Administracion_Modelo modeloAdmin = new Administracion_Modelo(HibernateUtil.getSessionFactory());

    // CONSTRUCTOR
    public Administracion_Controlador() {
    }    
    
    // METODO PARA OBTENER TODOS LOS ADMIN (CONTROLADOR)
    public CompletableFuture<List<Login_Object>> obtenerTodosLogin_C() {
        return CompletableFuture.supplyAsync(() -> this.modeloAdmin.obtenerTodosLogin_M());
    }   
    
    // METODO PARA OBTENER UN ADMIN (CONTROLADOR)
    public CompletableFuture<Login_Object> obtenerAdmin_C(int idAdmin){
        return CompletableFuture.supplyAsync(() -> this.modeloAdmin.obtenerAdmin_M(idAdmin));
    }    
    
    // METODO PARA GUARDAR EL ADMIN (CONTROLADOR)
    public CompletableFuture<Void> guardarAdmin_C(Login_Object admin){
        return CompletableFuture.runAsync(() -> this.modeloAdmin.guardarAdmin_M(admin));
    }   
    
    // METODO PARA ACTUALIZAR EL ADMIN (CONTROLADOR)
    public CompletableFuture<Void> actualizarAdmin_C(Login_Object admin){
        return CompletableFuture.runAsync(() -> this.modeloAdmin.actualizarAdmin_M(admin));
    }    
    
    // METODO PARA ELIMINAR UN ADMIN (CONTROLADOR)
    public CompletableFuture<Void> eliminarAdmin_C(int idAdmin){
        return CompletableFuture.runAsync(() -> this.modeloAdmin.eliminarAdmin_M(idAdmin));
    }
    
    // METODO PARA OBTENER EL TOTAL DE ADMINS (CONTROLADOR)
    public CompletableFuture<Integer> totalAdmin(){
        return CompletableFuture.supplyAsync(() -> this.modeloAdmin.obtenerTotalAdministradores_M());
    }

    // METODO PARA COMPROBAR LA EXISTENCIA DEL CORREO DEL ADMIN
    public CompletableFuture<Boolean> correoExistente(String correo) {
        
        return obtenerTodosLogin_C().thenApply(administradores -> {       
            for(Login_Object aux : administradores){
                if(aux.getCorreo().equals(correo)){
                    return true;
                }
            }
            return false;
        }).exceptionally(ex -> {
            return false;
        });
    }

}
