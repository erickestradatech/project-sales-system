package interfaces;

import java.util.List;
import modelo.*;

public interface INterfac {

    public List<Artefacto> listArtefac();

    public int registrarVenta(Ventas ep);

    public List<Artefacto_Venta> listVentas(String nro1, String nro2);

    public List<Artefacto> devolvercodArt(String nom);

}
