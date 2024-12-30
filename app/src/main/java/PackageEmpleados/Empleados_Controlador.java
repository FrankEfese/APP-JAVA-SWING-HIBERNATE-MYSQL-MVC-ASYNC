package PackageEmpleados;

import Proyecto_Java.HibernateUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Empleados_Controlador {

    // MODELO-EMPLEADOS
    private final Empleados_Modelo modeloEmpleados = new Empleados_Modelo(HibernateUtil.getSessionFactory());

    // CONSTRUCTOR
    public Empleados_Controlador() {
    }

    // METODO PARA OBTENER TODOS LOS EMPLEADOS (CONTROLADOR)
    public CompletableFuture<List<Empleados_Object>> obtenerTodosEmpleados_C() {
        return CompletableFuture.supplyAsync(() -> this.modeloEmpleados.obtenerTodosEmpleados_M());
    }
    
    // METODO PARA OBTENER UN EMPLEADO (CONTROLADOR)
    public CompletableFuture<Empleados_Object> obtenerEmpleado_C(int idEmpleado){
        return CompletableFuture.supplyAsync(() -> this.modeloEmpleados.obtenerEmpleado_M(idEmpleado));
    }
    
    // METODO PARA GUARDAR EL EMPLEADO (CONTROLADOR)
    public CompletableFuture<Void> guardarEmpleado_C(Empleados_Object empleado){
        return CompletableFuture.runAsync(() -> this.modeloEmpleados.guardarEmpleado_M(empleado));
    }

    // METODO PARA ELIMINAR UN EMPLEADO (CONTROLADOR)
    public CompletableFuture<Void> eliminarEmpleado_C(int idEmpleado) {
        return CompletableFuture.runAsync(() -> this.modeloEmpleados.eliminarEmpleado_M(idEmpleado));
    }
    
    // METODO PARA ACTUALIZAR AL EMPLEADO (CONTROLADOR)
    public CompletableFuture<Void> actualizarEmpleado_C(Empleados_Object empleado){
        return CompletableFuture.runAsync(() -> this.modeloEmpleados.actualizarEmpleado_M(empleado));
    }
    
    // METODO PARA OBTENER EL TOTAL DE EMPLEADOS (CONTROLADOR)
    public CompletableFuture<Integer> totalEmpleados(){
        return CompletableFuture.supplyAsync(() -> this.modeloEmpleados.obtenerTotalEmpleados_M());
    }

    // METODO PARA COMPROBAR LA EXISTENCIA DE DNI Y TELEFONO
    public CompletableFuture<boolean[]> verificarDniYTelefono(String dni, String telefono) {
        return obtenerTodosEmpleados_C().thenApply(empleados -> {
            boolean dniExiste = false;
            boolean telefonoExiste = false;

            for (Empleados_Object aux : empleados) {
                if (aux.getDni().equals(dni)) {
                    dniExiste = true;
                }
                if (String.valueOf(aux.getTelefono()).equals(telefono)) {
                    telefonoExiste = true;
                }

                if (dniExiste && telefonoExiste) {
                    break;
                }
            }
            return new boolean[]{dniExiste, telefonoExiste};
        }).exceptionally(ex -> {
            return new boolean[]{false, false};
        });
    }
    
}
