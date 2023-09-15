package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Producto;
import model.Usuario;
// GUI

public class Demo9 {
	// Listado de TODOS los Usuarios, registrando el tipo de usuario
	public static void main(String[] args) {
		String usuario =JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave =JOptionPane.showInputDialog("Ingrese clave: ");

		// 1. obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		int xtipo = 1;
		String jpql = "select u from Usuario u where u.usr_usua = :xsur and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).setParameter("xsur", usuario).setParameter("xcla", clave).getSingleResult();
			
			// mostrar el contenido del usuario
			JOptionPane.showMessageDialog(null, "Bienvenido" + u.getNom_usua());
			// abrir la ventana principal 
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: usuario o clave incorrecto");
		}
		
		em.close();
	}
}
//a ya vi
