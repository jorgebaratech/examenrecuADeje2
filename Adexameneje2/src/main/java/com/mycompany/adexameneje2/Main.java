package com.mycompany.adexameneje2;

import com.example.orderhibfx.utils.HibernateUtil;
import com.mycompany.adexameneje2.controller.BlogDAO;
import com.mycompany.adexameneje2.models.Comentario;
import com.mycompany.adexameneje2.models.Entrada;

public class Main {

    public static void main(String[] args) {
        Entrada entrada1 = new Entrada("Título de la entrada 1", "Contenido de la entrada 1", "https://www.entrada1.com");
        entrada1.addComentario(new Comentario("email1@example.com", "Comentario de la entrada 1"));
        entrada1.addComentario(new Comentario("email2@example.com", "Otro comentario de la entrada 1"));

        Entrada entrada2 = new Entrada("Título de la entrada 2", "Contenido de la entrada 2", "https://www.entrada2.com");
        entrada2.addComentario(new Comentario("email3@example.com", "Comentario de la entrada 2"));

        Entrada entrada3 = new Entrada("Título de la entrada 3", "Contenido de la entrada 3", "https://www.entrada3.com");
        entrada3.addComentario(new Comentario("email4@example.com", "Comentario de la entrada 3"));

        Entrada entrada4 = new Entrada("Título de la entrada 4", "Contenido de la entrada 4", "https://www.entrada4.com");
        entrada4.addComentario(new Comentario("email5@example.com", "Comentario de la entrada 4"));
        entrada4.addComentario(new Comentario("email6@example.com", "Otro comentario de la entrada 4"));
        entrada4.addComentario(new Comentario("email7@example.com", "Otro comentario más de la entrada 4"));

        Entrada entrada5 = new Entrada("Título de la entrada 5", "Contenido de la entrada 5", "https://www.entrada5.com");
        entrada5.addComentario(new Comentario("email8@example.com", "Comentario de la entrada 5"));
        entrada5.addComentario(new Comentario("email9@example.com", "Otro comentario de la entrada 5"));

        BlogDAO blogDAO = new BlogDAO(HibernateUtil.getSessionFactory());
        blogDAO.guardar(entrada1);
        blogDAO.guardar(entrada2);
        blogDAO.guardar(entrada3);
        blogDAO.guardar(entrada4);
        blogDAO.guardar(entrada5);

        blogDAO.portada();
    }
}
