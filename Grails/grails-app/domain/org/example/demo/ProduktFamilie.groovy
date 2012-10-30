package org.example.demo

class ProduktFamilie {
	
	//static belongsTo = [produktfamilie_msprache:ProduktFamilie_msprache]
	//static hasMany = [inhaltsstoffe:Inhaltsstoffe]
	
	String name
	
	String toString()  {
		return name? name: ""
	}

    static constraints = {
    }
}
