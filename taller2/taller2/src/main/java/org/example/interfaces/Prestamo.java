package org.example.interfaces;

import org.example.entities.Usuario;
import org.example.entities.Libro;

import java.util.Date;

public interface Prestamo {
  Usuario getIdUsuario();
  void setIdUsuario(Usuario idUsuario);

  Libro getIdLibro();
  void setIdLibro(Libro idLibro);

  Date getFechaPrestamo();
  void setFechaPrestamo(Date fechaPrestamo);

  Date getFechaDevolucion();
  void setFechaDevolucion(Date fechaDevolucion);

  boolean isActivo();
  void setActivo(boolean activo);
}