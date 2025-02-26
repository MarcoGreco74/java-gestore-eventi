import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi{
    
    private String titolo;

    private List<Evento> eventi;

    public ProgrammaEventi(String titolo){
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
 
//un metodo che aggiunge alla lista un Evento, passato come parametro
    public void addEvento(Evento evento){
        eventi.add(evento);
    }
// un metodo che restituisce una lista con tutti gli eventi presenti in una certa data 
    public List<Evento> eventiInUnaStessaData(LocalDate data){
        List<Evento> eventiNellaStessaData = new ArrayList<>();
        for(Evento eve : eventi){
            if(eve.getData().equals(data)){
                eventiNellaStessaData.add(eve);
            }
        }
        return eventiNellaStessaData;
    }
//un metodo che restituisce quanti eventi sono presenti nel programma 
    public int quantiEventi(){
        int numEventi = eventi.size();
        return numEventi;
    }
//un metodo che svuota la lista di eventi
    public void svuotaListaEventi(){
        eventi.clear();
    }
/*
un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli 
eventi ordinati per data nella forma:  - 
data1 - titolo1 
data2 - titolo2 
*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(titolo + "\n");  // stanza di StringBuilder che è una classe utilizzata per creare stringhe di caratteri modificabili o modificabili
        eventi.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
        for (Evento evento : eventi) {
            sb.append(evento.toString()).append("\n");      
        }
        return sb.toString();
    }

}
