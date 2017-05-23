package calcoloSoglia;

import java.util.Random;

import model.Campione;

public class NoiseGenerator {

	private int length;
	private Campione[] sequenzaRumore;
	private double potRumore;

	protected NoiseGenerator() {}

	//genera una sequenza randomica di campioni
	public void noise(double snr, int length) {
		Campione campioneCompleto = new Campione();
		Random campione = null;
		double snrLinearizzato = Math.pow(10, snr/10);
		this.potRumore = 1/snrLinearizzato;
		this.length = length;

		this.sequenzaRumore = new Campione[length];
		for(int i = 0; i < this.length; i++) {
			campione = new Random();
			campioneCompleto.setParteReale(campione.nextGaussian() * Math.sqrt(potRumore/2));
			campione = new Random();
			campioneCompleto.setParteImmaginaria(campione.nextGaussian() * Math.sqrt(potRumore/2));
			sequenzaRumore[i] = campioneCompleto;
		}
	}
	
	//metodo che calcola potenza della sequenza di rumore generata casualmente
	public double getPotenzaRumore(Campione[] sequenza) {
		double potenza, prodottoReale, prodottoImmaginario, sommaProdotti = 0;
		int lunghezza = sequenza.length; 									//indifferente dove la prendo, tanto hanno la stessa lunghezza
		double normalizzatore = 1/lunghezza;
		for(int i = 0; i < lunghezza; i++) {												//sarebbe 1/N * sommatoria (da 1 a n) del modulo quadro di R(i)
			prodottoReale = Math.pow(sequenza[i].getParteReale(), 2);						//
			prodottoImmaginario = Math.pow(sequenza[i].getParteImmaginaria(), 2);			//
			sommaProdotti = prodottoReale + prodottoImmaginario;							//
		}																					//
		potenza = normalizzatore * sommaProdotti;											//
		return potenza;																		//
	}

	public Campione[] getSequenza() {
		return this.sequenzaRumore;
	}
}
