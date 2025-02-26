import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    private LocalTime ora;

    private float prezzo;

    public Concerto(String titolo, LocalDate dataEvento, int numPaxTotali, LocalTime ora, float prezzo){
        super(titolo, dataEvento, numPaxTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getDataOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return getData().format(formatter) + " " + ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " +getPrezzo();
    }

}
