package org.example.demo

class Verpackung {
	
	int wert
	
	static belongsTo = [verpackung_werte:Verpackung_werte]
	
	String name
	
    static constraints = {
    }
	String toString()  {
		return name? name: ""
	}
}
