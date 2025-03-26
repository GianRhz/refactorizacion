package refactorizacion;
import java.time.LocalDate;
/**
 * @author Gian Caser
 */
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

	/**
	 * atributo lista reservas
	 */
    private List<reservas> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     *  iniciar los atributos
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Reserva una pista 
     * @param idPista id de la pista
     * @param fecha fecha de reserva
     * @param duracion duracion del reserva
     * @return devuelve true si ha reservado la pista y false en caso contrario
     */
    public boolean reservarPista(int idPista, LocalDate fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new reservas(idPista, fecha, duracion));
        return true;
    }

    /**
     * cancela una reserva
     * @param idReserva id del reserva
     * @return
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Activa la iluminacion de la pista
     * @param idPista id de la pista 
     * @return true si ha activado la iluminacion y false si no
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * desactiva la iluminacion de la pista
     * @param idPista id de la pista 
     * @return true si ha desactivado la iluminacion y false si no
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * verifica si esta disponible una pista
     * @param idPista id de la pista
     * @param fecha fecha a verificar
     * @param hora hora a verificar
     * @return true si esta disponible la pista y false si no
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}
