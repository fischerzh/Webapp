package org.example.demo

class ProduktFamilie {
	
	static belongsTo = [produktfamilie_msprache:ProduktFamilie_msprache]
	
	
	String name
	
	String toString()  {
		return name? name: ""
	}

    static constraints = {
    }
}
