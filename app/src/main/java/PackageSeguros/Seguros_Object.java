package PackageSeguros;

import PackageEmpresas.Empresas_Object;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Seguros_Object implements Serializable {

    // ATRIBUTOS
    private int id_seguro;
    private String nombre;
    private double precio;
    private Date f_alta;
    
    // RELACION 1 A MUCHOS CON EMPRESAS
    @OneToMany(mappedBy = "seguros_id_seguro", cascade = CascadeType.PERSIST)
    private List<Empresas_Object> empresas;

    // CONSTRUCTOR
    public Seguros_Object() {
    }

    // CONSTRUCTOR
    public Seguros_Object(int id_seguro, String nombre, double precio, Date f_alta) {
        this.id_seguro = id_seguro;
        this.nombre = nombre;
        this.precio = precio;
        this.f_alta = f_alta;
    }

    // CONSTRUCTOR
    public Seguros_Object(String nombre, double precio, Date f_alta) {
        this.nombre = nombre;
        this.precio = precio;
        this.f_alta = f_alta;
    }

    // GETTERS AND SETTERS
    public int getId_seguro() {
        return id_seguro;
    }

    public void setId_seguro(int id_seguro) {
        this.id_seguro = id_seguro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getF_alta() {
        return f_alta;
    }

    public void setF_alta(Date f_alta) {
        this.f_alta = f_alta;
    }

    public List<Empresas_Object> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresas_Object> empresas) {
        this.empresas = empresas;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Seguros_Object{" + "id_seguro=" + id_seguro + ", nombre=" + nombre + ", precio=" + precio + ", f_alta=" + f_alta + ", empresas=" + empresas + '}';
    }

}
