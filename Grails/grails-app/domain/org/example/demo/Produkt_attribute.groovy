
package org.example.demo

class Produkt_attribute {

	boolean ist_Koscher
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
	
	//static belongsTo = [land:Land]
	
    static constraints = {
    }
}
