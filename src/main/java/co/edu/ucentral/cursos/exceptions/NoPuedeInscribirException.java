package co.edu.ucentral.cursos.exceptions;

public class NoPuedeInscribirException extends Exception{

    public NoPuedeInscribirException(String no_puede_incribir_mas_cursos_ya_registra_) {
        super(no_puede_incribir_mas_cursos_ya_registra_);
    }
}
