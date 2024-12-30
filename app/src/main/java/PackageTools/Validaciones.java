package PackageTools;

import java.util.regex.Pattern;


public class Validaciones {
    
    
    // METODO PARA VALIDAR LOS CAMPOS DE CORREO Y CONTRASEÑA DEL LOGIN
    public static boolean validarLogin(String correo, String contraseña) {
        return Pattern.matches("^.{1,25}$", correo) && 
               Pattern.matches("^.{1,25}$", contraseña);
        
    }
    
    // METODO PARA VALIDAR EL NOMBRE DEL SEGURO
    public static boolean validarSeguro(String nombre) {
        return Pattern.matches("^.{1,25}$", nombre);
        
    }    
    
    // METODO PARA VALIDAR LOS CAMPOS DE ID-EMP , NOMBRE Y CIUDAD DE LA EMPRESA
    public static boolean validarEmpresa(String idEmp, String nombre, String ciudad) {
        return Pattern.matches("^.{1,25}$", idEmp) && 
               Pattern.matches("^.{1,25}$", nombre)&& 
               Pattern.matches("^.{1,25}$", ciudad);
        
    }    
    
    // METODO PARA VALIDAR LOS CAMPOS DE DNI, NOMBRE Y TELEFONO DEL EMPLEADO
    public static boolean validarEmpleado(String dni, String nombre, String telefono) {
        return Pattern.matches("^[0-9]{8}[A-Za-z]$", dni) && 
               Pattern.matches("^.{1,25}$", nombre) &&
               Pattern.matches("^[0-9]{9}$", telefono);
    }
    
    // METODO PARA VALIDAR LOS CAMPOS DE IDENTIFICADOR , NOMBRE Y CATEGORIA DEL PRODUCTO
    public static boolean validarProducto(String identificador, String nombre, String categoria) {
        return Pattern.matches("^.{1,25}$", identificador) && 
               Pattern.matches("^.{1,25}$", nombre)&& 
               !categoria.equals("--- SELECCIONAR ---");
        
    }

}
