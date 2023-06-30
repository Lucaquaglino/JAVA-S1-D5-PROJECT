public class Immagine extends ElementoMultimediale implements InterfacciaImmagine {
	private int luminosita;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public void aumentaLuminosita() {
		luminosita++;
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}
	}

	@Override
	public void show() {
		System.out.println(titolo);
		for (int i = 0; i < luminosita; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
