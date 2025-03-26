package refactorizacion;
import java.time.LocalDate;
/**
 * @author Gian Caser
 */
import java.util.ArrayList;

public class SistemaReservasDeportivas {

	GestorIlluminacion data = new GestorIlluminacion();
	static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     *  iniciar los atributos
     */
    public SistemaReservasDeportivas() {
        data.reservas = new ArrayList<>();
        data.iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Reserva una pista 
     * @param idPista id de la pista
     * @param fecha fecha de reserva
     * @param duracion duracion del reserva
     * @return devuelve true si ha reservado la pista y false en caso contrario
     */
    public boolean reservarPista(reservas reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (reservas r : data.reservas) {
            LocalDate fecha = null;
			if (r.getIdPista() == reserva.getIdPista() && esFechaDisponible(fecha, r)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        data.reservas.add(reserva);
        return true;
    }

    /**
     * cancela una reserva
     * @param idReserva id del reserva
     * @return
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < data.reservas.size(); i++) {
            if (data.reservas.get(i).getIdPista() == idReserva) {
                data.reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
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
        for (reservas r : data.reservas) {
            if (r.getIdPista() == idPista && esFechaDisponible(fecha, r)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

	private boolean esFechaDisponible(LocalDate fecha, reservas r) {
		return r.getFecha().equals(fecha);
	}
}
