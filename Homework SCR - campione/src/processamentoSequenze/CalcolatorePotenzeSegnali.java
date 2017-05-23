package processamentoSequenze;

import model.Campione;

public class CalcolatorePotenzeSegnali {

	public CalcolatorePotenzeSegnali() {}
	
	public double calcolaPotenzaSegnale(Campione[] sequenza) {
		double potenza, prodottoReale, prodottoImmaginario, sommaProdotti = 0;
		int lunghezza = sequenza.length; 		// stesso discorso del noiseGenerator, le due sequenze 
		double normalizzatore = 1/lunghezza;	// hanno lunghezza uguale
		for(int i = 0; i< lunghezza; i++) {
			prodottoReale = Math.pow(sequenza[i].getParteReale(), 2);
			prodottoImmaginario = Math.pow(sequenza[i].getParteImmaginaria(), 2);
			sommaProdotti = prodottoReale + prodottoImmaginario;
		}
		potenza = normalizzatore * sommaProdotti;
		return potenza;
	}
	
}
