package org.example.demo

import java.util.Date;

class Produkt {
	
	static searchable = true
	String name
	String ean
	boolean aktiv = true
	boolean istKoscher = false
	boolean istVegan= false
	boolean istVegetarisch = false
	boolean istBischulak = false
	boolean istBliothlssur = false
	boolean istChalavakum = false
	boolean istIsraelischesProdukt = false
	boolean istTarovetlssur = false
	boolean pasPalter = false
	boolean istIGFLProdukt = false
	boolean istMp = false
	boolean externeKontrolle = false
	String parve
	String tolaim
	Date erstellung
	Date veroeffentlichung
	Date kontrolle
	Date geaendert
	Date naechsteKontrolle
	
	static belongsTo = [hersteller:Hersteller, verteiler:Verteiler, verpackung:Verpackung, produktfamilie:ProduktFamilie,
					     verkaeufer:Verkaeufer, kontrolleur:Kontrolleur]
	
	static hasMany = [inhaltsstoffe:Inhaltsstoffe]
			
    static constraints = {
		name blank:false, unique:true
		ean blank:false, unique:true
    }
	String toString()  {
		return name? name: ""
	}
	static mapping = {
		autoTimestamp true
		inhaltsstoffe cascade: "all-delete-orphan"
}
	
}
