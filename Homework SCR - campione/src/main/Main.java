package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import energyDetector.EnergyDetector;

public class Main {

	//NB: probabilità di falso allarme pari a 10/1000, per cambiarla vedere CalcolatoreSoglia
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// valori SNR disponibili -13, -8, -5, +2
		//prendo da tastiera il valore dell'SNR selezionato
		System.out.println("Inserire un valore per l'SNR, scegliendo fra: -13, -8, -5, -2");
		Scanner scannerSNR = new Scanner(System.in); 
		double valoreSNR = scannerSNR.nextDouble();
		
		//prendo da tastiera la sequenza selezionata
		System.out.println("Selezionare la sequenza, scegliendo fra: 1, 2, 3");
		Scanner scannerSequenza = new Scanner(System.in);
		int sequenzaScelta = scannerSequenza.nextInt();
		
		EnergyDetector.esegui(valoreSNR, sequenzaScelta);
		
		scannerSNR.close();
		scannerSequenza.close();
	}

} 

//out 1 = -3, out 2 = 2, out 3 = -8,  out 4 = -13

// ISTRUZIONI: 
// - PER CAMBIARE IL PERCORSO DEI FILE: andare nella classe LettoreFile,
//										e sostituire le stringhe nel blocco switch
// - PER CAMBIAE LA PROBABILITA' DI DETECTION: andare nella classe CalcolatoreSoglia, e sostituire il valore
//											   dell'attributo soglia