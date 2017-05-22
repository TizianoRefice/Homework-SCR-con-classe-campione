package calcoloSoglia;

import java.util.Arrays;

public class CalcolatoreSoglia {

	private double soglia;
	private double[] potenzeRumore;

	public CalcolatoreSoglia() {
		this.potenzeRumore = new double[1000];
	}

	//calcola la soglia usando le potenze delle sequenze generate in NoiseGenerator
	public double calcolaSoglia(double valoreSNR) { 	
		this.potenzeRumore = getSequenzePotenzeRumoreOrdinate(valoreSNR); 		//comando di calcolare l'array di potenze
		soglia = this.potenzeRumore[989];										//prendo il 990° valore (probFA = 10/1000) <-- CAMBIARE QUESTO VALORE PER ALTERARE LA Pfa DEL NOISE GENERATOR 
		System.out.println("Valore della soglia a " + valoreSNR + "dB: " + soglia );	//ordine SNR: -13, -8, -5, +2 --> CONTROLLARE SE CORRISPONDE																
		return soglia;
	}

	//fa generare le potenze a NoiseGenerator e poi le ordina
	public double[] getSequenzePotenzeRumoreOrdinate(double valoreSNR) {
		int j = 1;
		double potenzaRumore;									//per salvare il valore di una singola potenza
		NoiseGenerator generator = new NoiseGenerator();
		while(j <= 1000) { 										//mi servono 1000 sequenze per ogni SNR
			generator.noise(valoreSNR, 1000); 					//genero la sequenza
			potenzaRumore = generator.getPotenzaRumore(generator.getParteReale(), generator.getPerteImmaginaria()); //ne calcolo la potenza
			this.potenzeRumore[j] = potenzaRumore; 				//salvo la potenza calcolata dentro l'array di potenze;
		}
		Arrays.sort(this.potenzeRumore); 						//le ordino
		return this.potenzeRumore;
	}

}
