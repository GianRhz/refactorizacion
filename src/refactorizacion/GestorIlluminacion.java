package refactorizacion;

import java.util.List;

public class GestorIlluminacion {
	/**
	 * atributo lista reservas
	 */
	public List<reservas> reservas;
	public boolean[] iluminacion;

	public GestorIlluminacion() {
	}

	/**
	 * Activa la iluminacion de la pista
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista id de la pista 
	 * @return true si ha activado la iluminacion y false si no
	 */
	public boolean EncenderLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = true;
	    return true;
	}

	/**
	 * desactiva la iluminacion de la pista
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista id de la pista 
	 * @return true si ha desactivado la iluminacion y false si no
	 */
	public boolean apagarLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = false;
	    return true;
	}
}