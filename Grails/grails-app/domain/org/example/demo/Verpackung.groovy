package org.example.demo

class Verpackung {
	
	float wert
	
	static belongsTo = [verpackung_werte:Verpackung_werte]
	
    static constraints = {
    }
	String toString()  {
		return verpackung_werte.verpackung + wert? wert: ""
	}
}
