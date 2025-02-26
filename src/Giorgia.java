import java.time.LocalDate;
import java.time.LocalTime;

public class Giorgia extends Concerto{

    final float prezzo;

    final int numPaxTotali;

    final String titolo;

    final LocalDate dataEvento;

    final LocalTime ora;

    public Giorgia(String titolo, LocalDate dataEvento, int numPaxTotali, LocalTime ora, float prezzo) {
        super(titolo, dataEvento, numPaxTotali, ora, prezzo);
        this.prezzo = 150.00F;
        this.numPaxTotali = 5000;
        this.titolo = "Giorgia in concert";
        this.dataEvento = LocalDate.of(2026, 9, 07);
        this.ora = LocalTime.of(21, 30, 00);
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getNumPaxTotali() {
        return numPaxTotali;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public LocalTime getOra() {
        return ora;
    }

    @Override
    public String toString(){
        return "Evento: "+getTitolo()+" per la data "+getData()+" inizio ore "+getOra()+" costo biglietto di €"+getPrezzo();
    }
    
}
