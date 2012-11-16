package org.example.demo

class Produkt_msprache {
	
	static searchable = true
	String name
	String Beschreibung
	
	static belongsTo = [produkt:Produkt, sprachen:Sprachen]

    static constraints = {
    }
}
