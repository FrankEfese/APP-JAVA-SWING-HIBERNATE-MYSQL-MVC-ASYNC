package PackageEmpleados;

import PackageEmpresas.Empresas_Object;
import java.io.Serializable;
import java.util.Date;

public class Empleados_Object implements Serializable {

    // ATRIBUTOS
    private int id_empleado;
    private String dni;
    private String nombre;
    private int edad;
    private int telefono;
    private Date f_alta;
    private Empresas_Object empresas_id_empresa;

    // CONSTRUCTOR
    public Empleados_Object() {
    }

    // CONSTRUCTOR
    public Empleados_Object(int id_empleado, String dni, String nombre, int edad, int telefono, Date f_alta, Empresas_Object empresas_id_empresa) {
        this.id_empleado = id_empleado;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.f_alta = f_alta;
        this.empresas_id_empresa = empresas_id_empresa;
    }

    // CONSTRUCTOR
    public Empleados_Object(String dni, String nombre, int edad, int telefono, Date f_alta, Empresas_Object empresas_id_empresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.f_alta = f_alta;
        this.empresas_id_empresa = empresas_id_empresa;
    }

    // GETTERS AND SETTERS
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getF_alta() {
        return f_alta;
    }

    public void setF_alta(Date f_alta) {
        this.f_alta = f_alta;
    }

    public Empresas_Object getEmpresas_id_empresa() {
        return empresas_id_empresa;
    }

    public void setEmpresas_id_empresa(Empresas_Object empresas_id_empresa) {
        this.empresas_id_empresa = empresas_id_empresa;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Empleados_Object{" + "id_empleado=" + id_empleado + ", dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + ", f_alta=" + f_alta + ", empresas_id_empresa=" + empresas_id_empresa + '}';
    }

}
