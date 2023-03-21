package com.mycompany.adexameneje2.controller;

import com.mycompany.adexameneje2.models.Comentario;
import com.mycompany.adexameneje2.models.Entrada;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BlogDAO {
    private SessionFactory sessionFactory;

    public BlogDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardar(Entrada e) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(e); // guarda la entrada y sus comentarios
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void portada() {
        Session session = sessionFactory.openSession();
        try {
            // consulta las 3 últimas entradas
            List<Entrada> entradas = session.createQuery("FROM Entrada e ORDER BY e.fechaCreacion DESC", Entrada.class)
                    .setMaxResults(3)
                    .list();
            for (Entrada e : entradas) {
                System.out.println("Titulo: " + e.getTitulo());
                System.out.println("Contenido: " + e.getContenido());
                System.out.println("Enlace: " + e.getEnlace());
                System.out.println("Fecha de creación: " + e.getFechaCreacion());
                // consulta los comentarios aprobados de la entrada
                List<Comentario> comentarios = session.createQuery("FROM Comentario c WHERE c.entrada = :entrada AND c.aprobado = true", Comentario.class)
                        .setParameter("entrada", e)
                        .list();
                for (Comentario c : comentarios) {
                    System.out.println("Email del usuario: " + c.getEmailUsuario());
                    System.out.println("Comentario: " + c.getComentario());
                    System.out.println("Fecha de creación: " + c.getFechaCreacion());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
