package org.example.demo

import java.util.Date;

class Produkt {
	
	static searchable = true
	String name
	String ean
	boolean ist_Koscher
	boolean ist_Vegan
	boolean ist_Vegetarisch
	boolean ist_Bischulak
	boolean ist_Bliothlssur
	boolean ist_Chalavakum
	boolean ist_Israelisches_Produkt
	boolean ist_Tarovetlssur
	boolean pas_Palter
	boolean ist_IGFL_Produkt
	boolean ist_Mp
	boolean Kontrolliert_durch_Extern
	String parve
	String tolaim
	Date Erstellungsdatum
	Date Veroeffentlichungsdatum
	Date Zuletzt_kontrolliert
	Date Zuletzt_veraendert
	Date Als_naechstes_kontrolliert_am
	
	static belongsTo = [hersteller:Hersteller, verteiler:Verteiler, verpackung:Verpackung, produktfamilie:ProduktFamilie,
					    inhaltsstoffe:Inhaltsstoffe, verkaeufer:Verkaeufer, kontrolleur:Kontrolleur]
	
    static constraints = {
		name blank:false, unique:true
		ean blank:false, unique:true
    }
	String toString()  {
		return name? name: ""
	}
	
}
