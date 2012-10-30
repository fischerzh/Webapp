package org.example.demo

class Produkt {
	
	String name
	String ean
	
	//static hasOne= [kontrolleur:Kontrolleur]
	
	static belongsTo = [hersteller:Hersteller, verteiler:Verteiler, verpackung:Verpackung, produktfamilie:ProduktFamilie,
					    inhaltsstoffe:Inhaltsstoffe, zusammensetzung:Zusammensetzung]
	
    static constraints = {
		name blank:false, unique:true
		ean blank:false, unique:true
    }
}
