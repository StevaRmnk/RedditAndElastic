package NoviStevinRedit.NoviStevinRedit.DTO;

public class ReactionDTO2 {

    private int idReakcije;

    private String tipReakcije;

    private String datumReakcije;

    private String autorReakcije;

    private int objava;

    public ReactionDTO2(){

    }

    public ReactionDTO2(int idReakcije, String tipReakcije, String datumReakcije, String autorReakcije, int objava) {
        this.idReakcije = idReakcije;
        this.tipReakcije = tipReakcije;
        this.datumReakcije = datumReakcije;
        this.autorReakcije = autorReakcije;
        this.objava = objava;
    }

    public int getIdReakcije() {
        return idReakcije;
    }

    public void setIdReakcije(int idReakcije) {
        this.idReakcije = idReakcije;
    }

    public String getTipReakcije() {
        return tipReakcije;
    }

    public void setTipReakcije(String tipReakcije) {
        this.tipReakcije = tipReakcije;
    }

    public String getDatumReakcije() {
        return datumReakcije;
    }

    public void setDatumReakcije(String datumReakcije) {
        this.datumReakcije = datumReakcije;
    }

    public String getAutorReakcije() {
        return autorReakcije;
    }

    public void setAutorReakcije(String autorReakcije) {
        this.autorReakcije = autorReakcije;
    }

    public int getObjava() {
        return objava;
    }

    public void setObjava(int objava) {
        this.objava = objava;
    }
}
