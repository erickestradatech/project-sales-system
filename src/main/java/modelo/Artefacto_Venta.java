package modelo;

import java.text.DecimalFormat;

public class Artefacto_Venta {

    private int nroventa;
    private int codart;
    private String nomcli;
    private int meses;
    private int precio;
    private String nomart;

    DecimalFormat df = new DecimalFormat("#.00");

    public String interes() {

        double interes = ((2 * precio * getMeses()) / 1200) * getMeses();

        return (df.format(interes));
    }

    public String total() {

        double total = precio + (2 * precio * getMeses()) / 1200;

        return (df.format(total));
    }

    public int getNroventa() {
        return nroventa;
    }

    public void setNroventa(int nroventa) {
        this.nroventa = nroventa;
    }

    public int getCodart() {
        return codart;
    }

    public void setCodart(int codart) {
        this.codart = codart;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }
}
