package energyDetector;

import java.io.FileNotFoundException;
import java.io.IOException;

import calcoloSoglia.CalcolatoreSoglia;
import processamentoSequenze.CalcolatorePotenzeSegnali;
import processamentoSequenze.LettoreFile;


public class EnergyDetector {
	
	public static void esegui(double valoreSNR, int sequenzaScelta) throws FileNotFoundException, IOException{
		
		double[] potenze = new double[1000];
		double probabilita = 0;
		
		//calcolo soglia in H0
		CalcolatoreSoglia cs = new CalcolatoreSoglia();
		double soglia = cs.calcolaSoglia(valoreSNR);
		
		//prendo la sequenza da file e ne calcolo la potenza
		double potenza = 0;
		LettoreFile lf = new LettoreFile();
		CalcolatorePotenzeSegnali cps = new CalcolatorePotenzeSegnali();
		lf.apriStreamDati(valoreSNR, sequenzaScelta);
		for(int i = 0; i < 1000; i++) {
			lf.leggi();
			potenza = cps.calcolaPotenzaSegnale(lf.getSequenzaSegnale());
			potenze[i] = potenza;
		}
		
		//calcolo la probabilita che ci sia il segnale
		double contatore = 0;
		for(int j = 0; j < potenze.length; j++) {
			if(potenze[j] < soglia)
				contatore++;
		}
		probabilita = (contatore/1000) * 100;
		System.out.println("Percentuale di detection: " + probabilita + "%");
		//verifico la presenza del PU
		if(probabilita >= 50) {
			System.out.println("Non è presente il Primary User, possiamo trasmettere!");
		} else {
			System.out.println("E' presente il Primary User, non possiamo trasmettere!");
		}
			
		
	}
}

//creare 1000 sequenze da 1000
//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13