package processamentoSequenze;

public class CalcolatorePotenzeSegnali {

	public CalcolatorePotenzeSegnali() {}
	
	public double calcolaPotenzaSegnale(double[] parteReale, double[] parteImmaginaria) {
		double potenza, prodottoReale, prodottoImmaginario, sommaProdotti = 0;
		int lunghezza = parteReale.length; 		// stesso discorso del noiseGenerator, le due sequenze 
		double normalizzatore = 1/lunghezza;	// hanno lunghezza uguale
		for(int i = 0; i< lunghezza; i++) {
			prodottoReale = Math.pow(parteReale[i], 2);
			prodottoImmaginario = Math.pow(parteImmaginaria[i], 2);
			sommaProdotti = prodottoReale + prodottoImmaginario;
		}
		potenza = normalizzatore * sommaProdotti;
		return potenza;
	}
	
}
