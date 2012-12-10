package org.example.demo

class Verpackung_werte {

	static searchable = true
	String verpackung
	
    static constraints = {
    }
	
	String toString()  {
		return verpackung? verpackung: ""
	}
}
