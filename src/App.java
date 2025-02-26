import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
       ///////// CREAZIONE EVENTO CON PARAMETRI INSERITI DA SCANNER DA QUI 
       Scanner scan = new Scanner(System.in);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       try{
          System.out.println("CREAZIONE EVENTO");
          System.out.print("Inserisci il titolo dell'evento: ");
          while(scan.hasNextLine()){
            String titoloConcerto = scan.nextLine();
            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy) ");
            String dataInput = scan.nextLine();
            LocalDate dataEvento = LocalDate.parse(dataInput, formatter);
            System.out.print("Inserisci l'ora dell'evento h");
            DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
            String oraInput = scan.next(); // con nextLine non funziona
            LocalTime oraEvento = LocalTime.parse(oraInput, formatterOra);
            System.out.println("Quanti posti mette a disposizione l'evento? ");
            int paxADisposizione = scan.nextInt();
            Evento evento = new Evento(titoloConcerto, dataEvento, paxADisposizione);
            System.out.println("Quante prenotazioni vuoi effettuare? ");
            int prenotazioni = scan.nextInt();
            System.out.println("Per quante pax vuoi prenotare? ");
            int numPaxdaPrenotare = scan.nextInt();
            for (int i = 0; i < prenotazioni; i++) {
            try{
                evento.prenota(numPaxdaPrenotare);
            }catch(IllegalStateException e) {
                System.out.println("Deve esserci un errore "+e.getMessage());
            }
            }
          if (evento.getNumPaxPrenotati() > 0){
            System.out.println("Posti prenotati: "+evento.getNumPaxPrenotati());
          }else{
            System.out.println("Non è possibile effettuare prenotazione");
          }    
          System.out.println("Vuoi disdire qualche pax? Y/N ");
          String disdiciEvento = scan.next();
          for (int i = 0; i < prenotazioni; i++) {
            try{
            if(disdiciEvento.equals("Y")){
                System.out.println("Quante pax vuoi disdire? ");
                int numPaxDaDisdire = scan.nextInt();
                evento.disdici(numPaxDaDisdire);
            }
            if(!disdiciEvento.equals("N") && !disdiciEvento.equals("Y")) {
                System.out.println("Valore inserito non valido: devi inserire Y oppure N");
                return;
            }
            }catch(IllegalStateException e) {
                System.out.println("Deve esserci un errore "+e.getMessage());     
             }        
            }
            int paxPrenotati = (evento.getNumPaxTotali() - evento.getNumPaxPrenotati());
            System.out.println("Posti disponibili: "+ ((paxPrenotati > 0) ? paxPrenotati : 0));
            System.out.println(evento.toString());
        /////// A QUI
        
        ////// DA QUI CERCO DI PRENOTARE PER DEGLI EVENTI CHE FANNO RIFERIMENTO A CLASSI CON ATTRIBUTI DI TITOLO, DATA, ORA, POSTI A DISPOSIZIONE 
        ///// FISSI E GIA' VALORIZZATI 
        /// DA QUI PER CLASSE GIORGIA (CONCERTO DI GIORGIA) 
            System.out.println("EVENTO CONCERTO DI GIORGIA");
            System.out.println("Quante prenotazioni vuoi effettuare? ");
            int prenotazioniGiorgia = scan.nextInt();
            System.out.println("Per quante pax vuoi prenotare? ");
            int numPaxdaPrenotareGiorgia = scan.nextInt(); 
            Giorgia giorgia = new Giorgia(titoloConcerto, dataEvento, prenotazioniGiorgia, oraEvento, numPaxdaPrenotareGiorgia);
            for (int i = 0; i < prenotazioniGiorgia; i++) {
            try{
                giorgia.prenota(numPaxdaPrenotareGiorgia);
            }catch (IllegalStateException e) {
                System.out.println("Deve esserci un errore "+e.getMessage());
             }
            }
            System.out.println(giorgia.toString());
            if (giorgia.getNumPaxPrenotati() > 0){
                System.out.println("Posti prenotati: "+giorgia.getNumPaxPrenotati());
            }else{
                System.out.println("Non è possibile effettuare prenotazione");
            }
            System.out.println("Vuoi disdire qualche pax? Y/N ");
            String disdiciGiorgia = scan.next();
            for (int i = 0; i < prenotazioniGiorgia; i++) {
            try{
            if(disdiciGiorgia.equals("Y")){
                System.out.println("Quante pax vuoi disdire? ");
                int numPaxDaDisdireGiorgia = scan.nextInt();
                giorgia.disdici(numPaxDaDisdireGiorgia);
            }
            if(!disdiciGiorgia.equals("N") && !disdiciGiorgia.equals("Y")) {
                System.out.println("Valore inserito non valido: devi inserire Y oppure N");
                return;
            }
            }catch (IllegalStateException e){
                System.out.println("Deve esserci un errore "+e.getMessage());
              }  
            } 
            int paxPrenotatiGiorgia = (giorgia.getNumPaxTotali() - giorgia.getNumPaxPrenotati());
            System.out.println("Posti disponibili: "+ ((paxPrenotatiGiorgia > 0) ? paxPrenotatiGiorgia: 0));
            System.out.println(giorgia.toString());
        /////// A QUI
        
        /////// DA QUI PER MENGONI (CONCERTO DI MENGONI)
            System.out.println("EVENTO CONCERTO DI MENGONI");
            System.out.println("Quante prenotazioni vuoi effettuare? ");
            int prenotazioniMengoni= scan.nextInt();
            System.out.println("Per quante pax vuoi prenotare? ");
            int numPaxdaPrenotareMengoni = scan.nextInt(); 
            Mengoni mengoni = new Mengoni(titoloConcerto, dataEvento, prenotazioniMengoni, oraEvento, numPaxdaPrenotareMengoni);
            for (int i = 0; i < prenotazioniMengoni; i++) {
            try{
                mengoni.prenota(numPaxdaPrenotareMengoni);
            } catch (IllegalStateException e) {
                System.out.println("Deve esserci un errore "+e.getMessage());
              }
            }
            System.out.println(mengoni.toString());
            if (mengoni.getNumPaxPrenotati() > 0){
                System.out.println("Posti prenotati: "+mengoni.getNumPaxPrenotati());
            }else{
                System.out.println("Non è possibile effettuare prenotazione");
            }
            System.out.println("Vuoi disdire qualche pax? Y/N ");
            String disdiciMengoni = scan.next();
            for (int i = 0; i < prenotazioniMengoni; i++) {
                try{
                if(disdiciMengoni.equals("Y")){
                    System.out.println("Quante pax vuoi disdire? ");
                    int numPaxDaDisdireMengoni = scan.nextInt();
                    mengoni.disdici(numPaxDaDisdireMengoni);
                }
                if(!disdiciMengoni.equals("N") && !disdiciMengoni.equals("Y")) {
                    System.out.println("Valore inserito non valido: devi inserire Y oppure N");
                    return;
                }
                } catch (IllegalStateException e) {
                    System.out.println("Deve esserci un errore "+e.getMessage());
                  }
                }    
            int paxPrenotatiMengoni = (mengoni.getNumPaxTotali() - mengoni.getNumPaxPrenotati());
            System.out.println("Posti disponibili: "+ ((paxPrenotatiMengoni > 0) ? paxPrenotatiMengoni: 0));
            System.out.println(mengoni.toString());
            /////// A QUI

            //////////////////////// CERCO SE ESISTE UN EVENTO PER CUI PRENOTARE 
            /// DA QUI
            Concerto concert = null;
            System.out.println("PER IL CONCERTO DI CHI VUOI PRENOTARE? ");
            String scelta = scan.next();
            if(scelta.equals("Giorgia")){
                System.out.println("EVENTO CONCERTO DI GIORGIA");
                System.out.println("Quante prenotazioni vuoi effettuare? ");
                int prenotazioniConcert = scan.nextInt();
                System.out.println("Per quante pax vuoi prenotare? ");
                int numPaxdaPrenotareConcert = scan.nextInt(); 
                concert = new Giorgia(titoloConcerto, dataEvento, prenotazioniConcert, oraEvento, numPaxdaPrenotareConcert);
                for (int i = 0; i < prenotazioniConcert; i++) {
                    try{
                        concert.prenota(numPaxdaPrenotareConcert);
                    } catch (IllegalStateException e) {
                        System.out.println("Deve esserci un errore "+e.getMessage());
                      }
                    }
                System.out.println(concert.toString());
                if (concert.getNumPaxPrenotati() > 0){
                    System.out.println("Posti prenotati: "+concert.getNumPaxPrenotati());
                }else{
                    System.out.println("Non è possibile effettuare prenotazione");
                }
                System.out.println("Vuoi disdire qualche pax? Y/N ");
                String disdiciConcert = scan.next();
                for (int i = 0; i < prenotazioniConcert; i++) {
                    try{
                    if(disdiciConcert.equals("Y")){
                        System.out.println("Quante pax vuoi disdire? ");
                        int numPaxDaDisdireConcert = scan.nextInt();
                        concert.disdici(numPaxDaDisdireConcert);
                    }
                    if(!disdiciConcert.equals("N") && !disdiciConcert.equals("Y")) {
                        System.out.println("Valore inserito non valido: devi inserire Y oppure N");
                        return;
                    }
                    }catch(IllegalStateException e) {
                        System.out.println("Deve esserci un errore "+e.getMessage());           
                      }
                    } 
                int paxPrenotatiConcert = (concert.getNumPaxTotali() - concert.getNumPaxPrenotati());
                System.out.println("Posti disponibili: "+ ((paxPrenotatiConcert > 0) ? paxPrenotatiConcert: 0));
                System.out.println(concert.toString());
                
            }
            else if(scelta.equals("Mengoni")){
                System.out.println("EVENTO CONCERTO DI MENGONI");
                System.out.println("Quante prenotazioni vuoi effettuare? ");
                int prenotazioniConcert = scan.nextInt();
                System.out.println("Per quante pax vuoi prenotare? ");
                int numPaxdaPrenotareConcert = scan.nextInt(); 
                concert =  new Mengoni(titoloConcerto, dataEvento, prenotazioniConcert, oraEvento, numPaxdaPrenotareConcert);
                for (int i = 0; i < prenotazioniConcert; i++) {
                    try{
                        concert.prenota(numPaxdaPrenotareConcert);
                    }catch(IllegalStateException e) {
                        System.out.println("Deve esserci un errore "+e.getMessage());                       
                     }
                    }
                System.out.println(concert.toString());
                if (concert.getNumPaxPrenotati() > 0){
                    System.out.println("Posti prenotati: "+concert.getNumPaxPrenotati());
                }else{
                    System.out.println("Non è possibile effettuare prenotazione");
                }
                System.out.println("Vuoi disdire qualche pax? Y/N ");
                String disdiciConcert = scan.next();
                for (int i = 0; i < prenotazioniConcert; i++) {
                    try{
                    if(disdiciConcert.equals("Y")){
                        System.out.println("Quante pax vuoi disdire? ");
                        int numPaxDaDisdireConcert = scan.nextInt();
                        concert.disdici(numPaxDaDisdireConcert);
                    }
                    } catch (IllegalStateException e) {
                        System.out.println("Deve esserci un errore "+e.getMessage());                     
                      }
                    } 
                int paxPrenotatiConcert = (concert.getNumPaxTotali() - concert.getNumPaxPrenotati());
                System.out.println("Posti disponibili: "+ ((paxPrenotatiConcert > 0) ? paxPrenotatiConcert: 0));
                System.out.println(concert.toString());

            }else{
                System.out.println("Nessun evento corrispondente alla richiesta");
            }
            //////// A QUI.
            
            /////// TEST DELLO STEP 4 (BONUS OPZIONALE)  DA QUI
            ProgrammaEventi events = new ProgrammaEventi("concerto Artisti Vari");
            LocalDate unaDataDiversa = LocalDate.of(2027, 4, 07);
            Evento evento2 = new Evento("concerto Ligabue", dataEvento, paxADisposizione);
            Evento evento3 = new Evento("concerto Irene Grandi", unaDataDiversa, paxADisposizione);
            Evento evento4 = new Evento("concerto Diodato", unaDataDiversa, paxADisposizione);
            events.addEvento(evento);   
            events.addEvento(evento2);
            events.addEvento(evento3); 
            events.addEvento(evento4);
            System.out.println(events.eventiInUnaStessaData(dataEvento));
            System.out.println(events.eventiInUnaStessaData(unaDataDiversa)); 
            System.out.println(events.quantiEventi());
            System.out.println(events.toString());
            /////// A QUI
        }
        System.out.println("CREAZIONE EVENTO");
        System.out.println("Inserisci il titolo dell'evento: ");  
       }catch(Exception e){
          System.out.println("Ci deve essere un errore: " + e.getMessage());
       }finally{
          scan.close();
       }
    }
}
