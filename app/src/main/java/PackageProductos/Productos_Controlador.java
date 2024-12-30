package PackageProductos;

import Proyecto_Java.HibernateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Productos_Controlador {

    // MODELO-PRODUCTOS
    private final Productos_Modelo modeloProducto = new Productos_Modelo(HibernateUtil.getSessionFactory());

    // CONSTRUCTOR
    public Productos_Controlador() {
    }

    // METODO PARA OBTENER TODOS LOS PRODUCTOS (CONTROLADOR)
    public CompletableFuture<List<Productos_Object>> obtenerTodosProductos_C() {
        return CompletableFuture.supplyAsync(() -> this.modeloProducto.obtenerTodosProductos_M());
    }

    // METODO PARA GUARDAR EL PRODUCTO (CONTROLADOR)
    public CompletableFuture<Void> guardarProducto_C(Productos_Object producto) {
        return CompletableFuture.runAsync(() -> this.modeloProducto.guardarProducto_M(producto));
    }

    // METODO PARA ELIMINAR UN PRODUCTO (CONTROLADOR)
    public CompletableFuture<Void> eliminarProducto_C(int idProducto) {
        return CompletableFuture.runAsync(() -> this.modeloProducto.eliminarProducto_M(idProducto));
    }

    // METODO PARA ACTUALIZAR EL PRODUCTO (CONTROLADOR)
    public CompletableFuture<Void> actualizarProducto_C(Productos_Object producto) {
        return CompletableFuture.runAsync(() -> this.modeloProducto.actualizarProducto_M(producto));
    }

    // METODO PARA OBTENER UN PRODUCTO (CONTROLADOR)
    public CompletableFuture<Productos_Object> obtenerProducto_C(int idProducto) {
        return CompletableFuture.supplyAsync(() -> this.modeloProducto.obtenerProducto_M(idProducto));
    }
    
    // METODO PARA OBTENER EL TOTAL DE PRODUCTOS (CONTROLADOR)
    public CompletableFuture<Integer> totalProductos(){
        return CompletableFuture.supplyAsync(() -> this.modeloProducto.obtenerTotalProductos_M());
    }

    // METODO PARA COMPROBAR LA EXISTENCIA DEL IDENTIFICADOR
    public CompletableFuture<Boolean> identificadorExistente(String identificador) {
        
        return obtenerTodosProductos_C().thenApply(productos -> {      
            for(Productos_Object aux : productos){
                if(aux.getIdentificador().equals(identificador)){
                    return true;
                }
            }
            return false;            
        }).exceptionally(ex -> {
            return false;
        });
        
    }

    // METODO PARA OBTENER INDICE SELECCIONADO DEL COMBO
    public int obtenerIndiceCombo(String categoria) {
        List<String> categorias = new ArrayList<>(Arrays.asList("--- SELECCIONAR ---", "ALIMENTACION", "ROPA", "DEPORTES", "VIDEOJUEGOS" , "COSAS VARIAS"));
        return categorias.indexOf(categoria);
    }

}
