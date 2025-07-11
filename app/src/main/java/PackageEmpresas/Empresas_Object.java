package PackageEmpresas;

import PackageEmpleados.Empleados_Object;
import PackageProductos.Productos_Object;
import PackageSeguros.Seguros_Object;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Empresas_Object implements Serializable {

    // ATRIBUTOS
    private int id_empresa;
    private String id_empresarial;
    private String nombre;
    private String ciudad;
    private Date f_alta;
    private Seguros_Object seguros_id_seguro;
    
    // RELACION 1 A MUCHOS CON EMPLEADOS
    @OneToMany(mappedBy = "empresas_id_empresa", cascade = CascadeType.PERSIST)
    private List<Empleados_Object> empleados;
    
    // RELACION 1 A MUCHOS CON PRODUCTOS
    @OneToMany(mappedBy = "empresas_id_empresa_p", cascade = CascadeType.REMOVE)
    private List<Productos_Object> productos;

    // CONSTRUCTOR
    public Empresas_Object() {
    }

    // CONSTRUCTOR
    public Empresas_Object(int id_empresa, String id_empresarial, String nombre, String ciudad, Date f_alta, Seguros_Object seguros_id_seguro) {
        this.id_empresa = id_empresa;
        this.id_empresarial = id_empresarial;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.f_alta = f_alta;
        this.seguros_id_seguro = seguros_id_seguro;
    }    

    // CONSTRUCTOR
    public Empresas_Object(String id_empresarial, String nombre, String ciudad, Date f_alta, Seguros_Object seguros_id_seguro) {    
        this.id_empresarial = id_empresarial;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.f_alta = f_alta;
        this.seguros_id_seguro = seguros_id_seguro;
    }

    // GETTERS AND SETTERS
    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getId_empresarial() {
        return id_empresarial;
    }

    public void setId_empresarial(String id_empresarial) {
        this.id_empresarial = id_empresarial;
    }   

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_alta() {
        return f_alta;
    }

    public void setF_alta(Date f_alta) {
        this.f_alta = f_alta;
    }

    public Seguros_Object getSeguros_id_seguro() {
        return seguros_id_seguro;
    }

    public void setSeguros_id_seguro(Seguros_Object seguros_id_seguro) {
        this.seguros_id_seguro = seguros_id_seguro;
    }

    public List<Empleados_Object> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados_Object> empleados) {
        this.empleados = empleados;
    }

    public List<Productos_Object> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos_Object> productos) {
        this.productos = productos;
    }    

    // TO STRING
    @Override
    public String toString() {
        return "Empresas_Object{" + "id_empresa=" + id_empresa + ", id_empresarial=" + id_empresarial + ", nombre=" + nombre + ", ciudad=" + ciudad + ", f_alta=" + f_alta + ", seguros_id_seguro=" + seguros_id_seguro + ", empleados=" + empleados + '}';
    }
    

}
