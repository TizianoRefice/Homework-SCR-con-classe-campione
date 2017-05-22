package calcoloSoglia;

import java.util.Random;

public class NoiseGenerator {

	private int length;
	private double[] parteReale;
	private double[] parteImmaginaria;
	private double potRumore;

	protected NoiseGenerator() {}

	//genera una sequenza randomica di campioni
	public void noise(double snr, int length) {
		Random campione = null;
		double snrLinearizzato = Math.pow(10, snr/10);
		this.potRumore = 1/snrLinearizzato;
		this.length = length;

		this.parteReale = new double[length];
		for(int i = 0; i < this.length; i++) {
			campione = new Random();
			parteReale[i] = campione.nextGaussian() * Math.sqrt(potRumore/2);
		}

		this.parteImmaginaria = new double[length];
		for(int j = 0; j < this.length; j++) {
			campione = new Random();
			parteImmaginaria[j] = campione.nextGaussian() * Math.sqrt(potRumore/2);
		}
	}
	
	//metodo che calcola potenza della sequenza di rumore generata casualmente
	public double getPotenzaRumore(double[] parteReale, double[] parteImmaginaria) {
		double potenza, prodottoReale, prodottoImmaginario, sommaProdotti = 0;
		int lunghezza = parteReale.length; 									//indifferente dove la prendo, tanto hanno la stessa lunghezza
		double normalizzatore = 1/lunghezza;
		for(int i = 0; i < lunghezza; i++) {								//sarebbe 1/N * sommatoria (da 1 a n) del modulo quadro di R(i)
			prodottoReale = Math.pow(parteReale[i], 2);						//
			prodottoImmaginario = Math.pow(parteImmaginaria[i], 2);			//
			sommaProdotti = prodottoReale + prodottoImmaginario;			//
		}																	//
		potenza = normalizzatore * sommaProdotti;							//
		return potenza;														//
	}

	public double[] getParteReale() {
		return this.parteReale;
	}
	
	public double[] getPerteImmaginaria() {
		return this.parteImmaginaria;
	}
}
