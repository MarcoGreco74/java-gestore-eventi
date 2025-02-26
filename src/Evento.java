import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;

    private LocalDate data;

    private final int numPaxTotali;

    private int numPaxPrenotati;

    
    public Evento(String titolo, LocalDate dataEvento, int numPaxTotali) throws IllegalArgumentException {
        //Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. 
        //In caso contrario il programma deve lanciare una eccezione. 
        if (dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (numPaxTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = dataEvento;
        this.numPaxTotali = numPaxTotali;
        this.numPaxPrenotati = 0;
    }
    /*
    prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve restituire un’eccezione. 
    disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce un’eccezione. 
    */
    public void prenota(int numPaxDaPrenotare)throws IllegalStateException{
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Non è possibile prenotare per una data già passata.");
        }
        else if (getNumPaxPrenotati() >= getNumPaxTotali() || numPaxDaPrenotare >= getNumPaxTotali()) {
            throw new IllegalStateException("Posti disponibili esauriti.");
        }else{
            this.numPaxPrenotati = this.numPaxPrenotati+numPaxDaPrenotare;
        }
    }

    public void disdici(int numPaxDaDisdire)throws IllegalStateException{
        if (data.isBefore(LocalDate.now())) {
              throw new IllegalStateException("Non è possibile disdire per una data passata" );
        }
        else if (numPaxPrenotati <= 0) {
            throw new IllegalStateException("Nessuna prenotazione da disdire");
        }else{
            this.numPaxPrenotati = this.numPaxPrenotati-numPaxDaDisdire;
        }
    }
    /*
    Aggiungere metodi getter e setter in modo che: 
    titolo sia in lettura e in scrittura 
    data sia in lettura e scrittura 
    numero di posti totale sia solo in lettura
    numero di posti prenotati sia solo in lettura
    */
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }
    //controllo sulla data anche nel metodo setter
    public void setData(LocalDate data)throws IllegalArgumentException{
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La nuova data dell'evento non può essere nel passato.");
        }
        this.data = data; 
    }

    public int getNumPaxTotali() {
        return numPaxTotali;
    }

    public int getNumPaxPrenotati() {
        return numPaxPrenotati;
    }
    /*
    l’override del metodo toString() in modo che venga restituita una stringa contenente: 
    data formattata - titolo
    */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }

}
