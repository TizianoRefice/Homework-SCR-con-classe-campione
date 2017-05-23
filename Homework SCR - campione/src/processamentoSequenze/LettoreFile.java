package processamentoSequenze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import model.Campione;

public class LettoreFile {
	
	private LineNumberReader reader;
	private Campione[] sequenza;

	//legge il segnale dal file selezionato
	public void apriStreamDati(double valoreSNR, int sequenzaScelta) {
		File file = null;
		//per cambiare il file di input modificare qui
		try {
			String indirizzo = null;	
			switch(sequenzaScelta) {
				//caso in cui la sequenza scelta sia la numero 1
				case 1: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_4.dat"; }  //in base all'SNR scelto cambiano i valori dell'indirizzo 
						if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_3.dat"; }
						if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_1.dat"; }
						if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_1/output_2.dat"; }
						break;
				//caso in cui la sequenza scelta sia la numero 2		
				case 2: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_4.dat"; } 
						if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_3.dat"; }
						if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_1.dat"; }
						if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_2/output_2.dat"; }
						break;
						//caso in cui la sequenza scelta sia la numero 3		
				case 3: if(valoreSNR == -13) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_4.dat"; } 
						if(valoreSNR == -8) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_3.dat"; }
						if(valoreSNR == -5) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_1.dat"; }
						if(valoreSNR == +2) { indirizzo = "C:/Users/trefi/Desktop/SCR/Sequenza_3/output_2.dat"; }
						break;
			}	
			file = new File(indirizzo);
			this.reader = new LineNumberReader(new FileReader(file));
		} catch (IOException exc) {
			System.out.println("FILE ASSENTE!");
		}
	}
	
	//
	public void leggi() throws IOException, FileNotFoundException {
		this.sequenza = new Campione[1000];
		BufferedReader br = new BufferedReader(reader);
		int i = 0;
		String line = br.readLine();
		while(line != null) {
			sequenza[i] = this.leggiECreaCampione(line);
			System.out.println("this.leggiECreaCampione(line) invocato");
			i++;
			line = br.readLine();
		}
		br.close();
	}
	
	private Campione leggiECreaCampione(String valoriCampione) {
		Campione campione = new Campione();
		double[] valori = this.separaStringhe(valoriCampione);
		System.out.println("this.separaStringhe(valoriCampione) invocato");
		if(valori != null) {
			campione.setParteReale(valori[0]);
			campione.setParteImmaginaria(valori[1]);
			System.out.println("metodi per settare parte reale e immaginaria del campione invocati");
		}
		return campione;
	}

	private double[] separaStringhe(String campioneCompleto) {
		double[] risultato = new double[2];
		if(campioneCompleto != null) {
			Scanner scanner = new Scanner(campioneCompleto);
			risultato[0] = Double.parseDouble(scanner.next());
			risultato[1] = Double.parseDouble(scanner.next());
			scanner.close();
		}
		return risultato;
	}

	public Campione[] getSequenzaSegnale() {
		return this.sequenza;
	}
}

//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13
//creiamo 1000 sequenze da 1000