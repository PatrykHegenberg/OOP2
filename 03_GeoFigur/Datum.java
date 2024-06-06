package fuhrpark;

public class Datum {
	// Attribute
	private int tag;
	private int monat;
	private int jahr;

	// Konstruktoren - noch keine
	public Datum() {
		setDatum(1980, 1, 1);
	}

	public Datum(int tag, int monat, int jahr) {
		setDatum(jahr, monat, tag);
	}

	// Methoden
	public int getTag() {
		return tag;
	}

	public int getMonat() {
		return monat;
	}

	public int getJahr() {
		return jahr;
	}

	private void setTag(int tag) {
		this.tag = tag;
	}

	private void setMonat(int monat) {
		this.monat = monat;
	}

	private void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public void setDatum(int jahr, int monat, int tag) {
		String errorText = "";
		if (jahr < 1900)
			errorText = "Jahreszahl nicht erlaubt, muss >= 1900 sein";
		else if (monat < 1 | monat > 13)
			errorText = "Monatszahl nicht erlaubt";
		else if (tag < 1 | tag > maxTageImMonat(jahr, monat))
			errorText = "Tageszahl nicht erlaubt";

		if (errorText == "") {
			setTag(tag);
			setMonat(monat);
			setJahr(jahr);
		} else
			System.out.println(errorText);

	}

	private int maxTageImMonat(int jahr, int monat) {
		// Methode anlegen --> Aufgabe A.1
		int maxTage = 0;
		switch (monat) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxTage = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxTage = 30;
			break;
		case 2:
			maxTage = istSchaltjahr(jahr) ? 29 : 28;
			break;
		}
		return maxTage;
	}

	private boolean istSchaltjahr(int jahr) {
		// diese Methode liefert true, falls das Jahr jahr ein Schaltjahr ist
		if (jahr % 4 != 0)
			return false;
		else if (jahr % 100 == 0 & jahr % 400 != 0)
			return false;
		else
			return true;

	}

	public String datumZuString(boolean langFormat) {
		String returnString = "";
		if (langFormat) { // true bedeutet: Langformat, d.h. false: Kurzformat
			returnString = getWochenTag() + ", ";
			if (this.tag < 10)
				returnString += "0";
			returnString += this.tag;
			returnString += ".";
			if (this.monat < 10)
				returnString += "0";
			returnString += this.monat;
			returnString += ".";
			returnString += " im Jahr ";
			returnString += this.jahr;
		} else { // d.h. Kurzformat ist gewünscht
			returnString += this.tag;
			returnString += ".";
			returnString += this.monat;
			returnString += ".";
			returnString += this.jahr % 2000;
		}
		return returnString;
	}

	public Datum getFolgeTag() {
		int fJahr, fMonat, fTag; // Variablen für Tag, Monat und Jahr des Folgetags

		// wenn es nicht der letzte Tage im Monat ist: Tag "hochzählen",
		// Monat und Jahr unverändert lassen
		if (this.tag < maxTageImMonat(this.jahr, this.monat)) {
			fTag = this.tag + 1;
			fMonat = this.monat;
			fJahr = this.jahr;
		} else { // d.h.: es ist der letzte Tag im Monat
			fTag = 1; // Folgetag ist somit "der nächste 1."
			// wenn es nicht Dezember ist: Monat hochzählen, Jahr unverändert lassen
			if (this.monat < 12) {
				fMonat = this.monat + 1;
				fJahr = this.jahr;
			} else { // d.h.: es ist der 31.12.
				fMonat = 1; // Folgemonat: Januar
				fJahr = this.jahr + 1; // d.h.: das nächste Jahr
			}
		}
		// ein Datumsobjekt zu den ermittelten Werten erzeugen und zurückgeben
		Datum returnDatum = new Datum();
		returnDatum.setDatum(fJahr, fMonat, fTag);
		return returnDatum;
	}

	private String getWochenTag() {
		int wochenTagAlsInt = datumZuInt() % 7;
		String wochenTagAlsString = "";
		switch (wochenTagAlsInt) {
		case 1:
			wochenTagAlsString = "Montag";
			break;
		case 2:
			wochenTagAlsString = "Dienstag";
			break;
		case 3:
			wochenTagAlsString = "Mittwoch";
			break;
		case 4:
			wochenTagAlsString = "Donnerstag";
			break;
		case 5:
			wochenTagAlsString = "Freitag";
			break;
		case 6:
			wochenTagAlsString = "Samstag";
			break;
		case 0:
			wochenTagAlsString = "Sonntag";
			break;
		}
		return wochenTagAlsString;

	}

	public int datumZuInt() {
		int returnAnzahlTage = 0;

		// Berechne Anzahl der "vollen Jahre"
		int j = 1900;
		while (j < this.jahr) {
			if (istSchaltjahr(j))
				returnAnzahlTage += 366;
			else
				returnAnzahlTage += 365;
			j++;
		}

		// Berechne die Anzahl der Tage im letzten Jahr
		returnAnzahlTage += this.tag;
		int m = 1;
		while (m < this.monat) {
			returnAnzahlTage += maxTageImMonat(this.jahr, m);
			m++;
		}

		return returnAnzahlTage;
	}
}
