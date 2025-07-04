package PackageSeguros;

import PackageEmpresas.Empresas_Object;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Seguros_Modelo {

    private final SessionFactory sessionFactory;

    // CONSTRUCTOR
    public Seguros_Modelo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // METODO PARA OBTENER TODOS LOS SEGUROS (MODELO)
    public List<Seguros_Object> obtenerTodosSeguros_M() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Seguros_Object", Seguros_Object.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS SEGUROS", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    // METODO PARA GUARDAR EL SEGURO (MODELO)
    public void guardarSeguro_M(Seguros_Object seguro) {

        try {

            Session sesion = sessionFactory.openSession();
            Transaction transaccion = sesion.beginTransaction();

            sesion.save(seguro);
            JOptionPane.showMessageDialog(null, "SEGURO AGREGADO", "SEGUROS-M", JOptionPane.INFORMATION_MESSAGE);
            transaccion.commit();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR EL SEGURO", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
        }

    }

    // METODO PARA OBTENER UN SEGURO (MODELO)
    public Seguros_Object obtenerSeguro_M(int idSeguro) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Seguros_Object.class, idSeguro);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL SEGURO", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // METODO PARA ACTUALIZAR EL SEGURO (MODELO)
    public void actualizarSeguro_M(Seguros_Object seguro) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(seguro);
            JOptionPane.showMessageDialog(null, "SEGURO ACTUALIZADO", "SEGUROS-M", JOptionPane.INFORMATION_MESSAGE);
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR EL SEGURO", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO PARA ELIMINAR UN SEGURO (MODELO)
    public void eliminarSeguro_M(int idSeguro) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Seguros_Object seguro = session.get(Seguros_Object.class, idSeguro);
            if (seguro != null) {
                session.delete(seguro);
                JOptionPane.showMessageDialog(null, "SEGURO ELIMINADO CORRECTAMENTE", "SEGUROS-M", JOptionPane.INFORMATION_MESSAGE);
            }
            transaction.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL SEGURO", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO PARA OBTENER LAS EMPRESAS ASEGURADAS (MODELO)
    public List<Empresas_Object> obtenerEmpresasPorSeguro_M(int idSeguro) {
        try (Session session = sessionFactory.openSession()) {
            String jpql = "SELECT em FROM Empresas_Object em WHERE em.seguros_id_seguro.id_seguro = :id_Seguro";
            return session.createQuery(jpql, Empresas_Object.class)
                    .setParameter("id_Seguro", idSeguro)
                    .getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LAS EMPRESAS ASEGURADAS", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
    
    // METODO PARA OBTENER EL TOTAL DE SEGUROS (MODELO)
    public int obtenerTotalSeguros_M() {
        try (Session session = sessionFactory.openSession()) {
            Long total = session.createQuery("SELECT COUNT(*) FROM Seguros_Object", Long.class).uniqueResult();
            return total != null ? total.intValue() : 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER EL TOTAL DE SEGUROS", "SEGUROS-M", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }


}
