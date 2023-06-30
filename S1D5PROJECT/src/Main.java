import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ElementoMultimediale[] elementi = new ElementoMultimediale[5];

		// Creo elementi multimediali

		for (int i = 0; i < elementi.length; i++) {
			System.out.print("Inserisci il titolo dell'elemento multimediale " + (i + 1) + ": ");
			String titolo = scanner.nextLine();
			System.out.print("Inserisci il tipo (1 = Audio, 2 = Video, 3 = Immagine): ");
			int tipo = Integer.parseInt(scanner.nextLine());

			switch (tipo) {
			case 1:
				System.out.print("Inserisci il volume: ");
				int volumeAudio = Integer.parseInt(scanner.nextLine());
				System.out.print("Inserisci la durata: ");
				int durataAudio = Integer.parseInt(scanner.nextLine());
				elementi[i] = new Audio(titolo, volumeAudio, durataAudio);
				break;
			case 2:
				System.out.print("Inserisci il volume: ");
				int volumeVideo = Integer.parseInt(scanner.nextLine());
				System.out.print("Inserisci la durata: ");
				int durataVideo = Integer.parseInt(scanner.nextLine());
				System.out.print("Inserisci la luminosita: ");
				int luminosita = Integer.parseInt(scanner.nextLine());
				elementi[i] = new Video(titolo, volumeVideo, durataVideo, luminosita);
				break;
			case 3:
				System.out.print("Inserisci la luminosita: ");
				int luminositaImmagine = Integer.parseInt(scanner.nextLine());
				elementi[i] = new Immagine(titolo, luminositaImmagine);
				break;
			default:
				System.out.println("Tipo non valido. Inserisci un valore valido.");
				i--;
				break;
			}
		}

		// Eseguo elementi multimediali

		int scelta;
		do {
			System.out
					.println("Scegli un elemento multimediale da eseguire (1-" + elementi.length + ") o 0 per uscire:");
			scelta = Integer.parseInt(scanner.nextLine());

			if (scelta >= 1 && scelta <= elementi.length) {
				ElementoMultimediale elemento = elementi[scelta - 1];
				if (elemento instanceof Riproducibile) {
					((Riproducibile) elemento).play();
				} else if (elemento instanceof InterfacciaImmagine) {
					((InterfacciaImmagine) elemento).show();
				}

				System.out.println(
						"Vuoi aumentare o abbassare la luminosità o il volume? (1 = Aumenta luminosità, 2 = Abbassa luminosità, 3 = Aumenta volume, 4 = Abbassa volume, 5 = Esci)");
				int opzione = Integer.parseInt(scanner.nextLine());
				switch (opzione) {
				case 1:
					if (elemento instanceof Video) {
						((Video) elemento).aumentaLuminosita();
					} else if (elemento instanceof Immagine) {
						((Immagine) elemento).aumentaLuminosita();
					}
					break;
				case 2:
					if (elemento instanceof Video) {
						((Video) elemento).diminuisciLuminosita();
					} else if (elemento instanceof Immagine) {
						((Immagine) elemento).diminuisciLuminosita();
					}
					break;
				case 3:
					if (elemento instanceof Video) {
						((Video) elemento).alzaVolume();
					} else if (elemento instanceof Audio) {
						((Audio) elemento).alzaVolume();
					}
					break;
				case 4:
					if (elemento instanceof Video) {
						((Video) elemento).abbassaVolume();
					} else if (elemento instanceof Audio) {
						((Audio) elemento).abbassaVolume();
					}
					break;
				case 5:
					break;
				default:
					System.out.println("Opzione non valida. Riprova.");
					break;
				}
			} else if (scelta != 0) {
				System.out.println("Scelta non valida. Inserisci un valore valido.");
			}
		} while (scelta != 0);

		scanner.close();
	}
}
