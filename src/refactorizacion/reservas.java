package refactorizacion;

import java.time.LocalDate;

/**
 * @author Gian Calso
 */
public class reservas {
	/**
	 * atributos de la clase
	 */
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * constructor de la clase reservas
     * @param idPista id de la pista
     * @param fecha fecha de alquiler
     * @param duracion duracion del alquiler
     */
    public reservas(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * devuelve el id de la pista
     * @return id de la pista
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * devuelve la fecha del alquiler
     * @return fecha del alquiler
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * devuelve la duracion del alquiler
     * @return duracion del alquiler
     */
    public int getDuracion() {
        return duracion;
    }
}