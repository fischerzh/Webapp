package org.example.demo

class Produkt {
	
	String name
	String ean
	
	static hasMany= [kontrolleur:Kontrolleur]
	
	static belongsTo = [hersteller:Hersteller, verteiler:Verteiler, verpackung:Verpackung, produktfamilie:ProduktFamilie,
					    inhaltsstoffe:Inhaltsstoffe, zusammensetzung:Zusammensetzung, verkaeufer:Verkaeufer, attribte:Produkt_attribute]
	
    static constraints = {
		name blank:false, unique:true
		ean blank:false, unique:true
    }
	String toString()  {
		return name? name: ""
	}
	
}
