public class Audio extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int durata;

	public Audio(String titolo, int volume, int durata) {
		super(titolo);
		this.volume = volume;
		this.durata = durata;
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}

	@Override
	public void play() {

		for (int i = 0; i < durata; i++) {
			System.out.println(titolo);
			for (int j = 0; j < volume; j++) {
				System.out.print("!");
			}
			System.out.println();
		}

	}
}
