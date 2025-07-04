package PackageProductos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Productos_Modelo {
    
    private final SessionFactory sessionFactory;
   
    // CONSTRUCTOR
    public Productos_Modelo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }   
    
    // METODO PARA OBTENER TODOS LOS PRODUCTOS (MODELO)
    public List<Productos_Object> obtenerTodosProductos_M() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Productos_Object", Productos_Object.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS PRODUCTOS", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }    
    
    // METODO PARA GUARDAR EL PRODUCTO (MODELO)
    public void guardarProducto_M(Productos_Object producto) {

        try {

            Session sesion = sessionFactory.openSession();
            Transaction transaccion = sesion.beginTransaction();

            sesion.save(producto);
            JOptionPane.showMessageDialog(null, "PRODUCTO AGREGADO", "PRODUCTOS-M", JOptionPane.INFORMATION_MESSAGE);
            transaccion.commit();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR EL PRODUCTO", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
        }

    }   
    
    // METODO PARA ELIMINAR UN PRODUCTO (MODELO)
    public void eliminarProducto_M(int idProducto) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Productos_Object producto = session.get(Productos_Object.class, idProducto);
            if (producto != null) {
                session.delete(producto);
                JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE", "PRODUCTOS-M", JOptionPane.INFORMATION_MESSAGE);
            }
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL PRODUCTO", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    // METODO PARA ACTUALIZAR EL PRODUCTO (MODELO)
    public void actualizarProducto_M(Productos_Object producto) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(producto);
            JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO", "PRODUCTOS-M", JOptionPane.INFORMATION_MESSAGE);
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR EL PRODUCTO", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    // METODO PARA OBTENER UN PRODUCTO (MODELO)
    public Productos_Object obtenerProducto_M(int idProducto) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Productos_Object.class, idProducto);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL PRODUCTO", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // METODO PARA OBTENER EL TOTAL DE PRODUCTOS (MODELO)
    public int obtenerTotalProductos_M() {
        try (Session session = sessionFactory.openSession()) {
            Long total = session.createQuery("SELECT COUNT(*) FROM Productos_Object", Long.class).uniqueResult();
            return total != null ? total.intValue() : 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL TOTAL DE PRODUCTOS", "PRODUCTOS-M", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
