package energyDetector;

import java.io.FileNotFoundException;
import java.io.IOException;

import calcoloSoglia.CalcolatoreSoglia;
import model.Campione;
import processamentoSequenze.CalcolatorePotenzeSegnali;
import processamentoSequenze.LettoreFile;


public class EnergyDetector {
	
	public static void esegui(double valoreSNR, int sequenzaScelta) throws FileNotFoundException, IOException{
		
		//calcolo soglia in H0
		CalcolatoreSoglia cs = new CalcolatoreSoglia();
		double soglia = cs.calcolaSoglia(valoreSNR);
		
		//prendo la sequenza da file
		Campione[] sequenza;
		LettoreFile lf = new LettoreFile();
		lf.apriStreamDati(valoreSNR, sequenzaScelta);
		sequenza = lf.leggi();
		
		//calcolo la potenza del segnale ricevuto
		CalcolatorePotenzeSegnali cps = new CalcolatorePotenzeSegnali();
		double potenza = cps.calcolaPotenzaSegnale(lf.getParteRealeSequenza(sequenza), lf.getParteImmaginariaSequenza(sequenza));
		
		//confronto soglia e potenza
		if(potenza > soglia)
			System.out.println("il PU è presente");
		else
			System.out.println("il PU non è presente");
	}
}

//creare 1000 sequenze da 1000
//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13