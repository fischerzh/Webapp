package org.example.demo

class Verpackung_werte_msprache {
	
	static searchable = true
	String verpackung
	
	static belongsTo = [sprachen:Sprachen, verpackung_werte:Verpackung_werte]

    static constraints = {
    }
}
