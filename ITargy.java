import java.io.IOException;

/**
 * ITagy interfesz
 * Eszkozok es Alkatreszek szarmaznak le belole
 */
public interface ITargy {
	/**
	 * ITargy felvesz fuggvenye, a tobbi leszarmazott osztaly valostija meg
	 * @param sz Szereplo
	 * @throws IOException
	 */
	void felvesz(Szereplo sz) throws IOException;
	String getNev();
}
