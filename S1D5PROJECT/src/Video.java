public class Video extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int luminosita;
	private int durata;

	public Video(String titolo, int volume, int luminosita, int durata) {
		super(titolo);
		this.volume = volume;
		this.luminosita = luminosita;
		this.durata = durata;
	}

	public void aumentaLuminosita() {
		luminosita++;
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}
	}

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.println(titolo);
			for (int j = 0; j < volume; j++) {
				System.out.print("!");
			}
			System.out.println();
			for (int j = 0; j < luminosita; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
