package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;
// GUI

public class Demo7 {
	// Listado de TODOS los Usuarios, registrando el tipo de usuario
	
	public static void main(String[] args) {
		// 1. obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		// mostrar el contenido del listado
		for(Producto p : lstProductos){
			System.out.println("Codigo....: " + p.getId_prod());
			System.out.println("Nombre....: " + p.getDes_prod());
			System.out.println("Tipo......: " + p.getObjCategoria().getDescripcion());
			System.out.println("Tipo......: " + p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------------");
		}
		
		em.close();
	}
}
