package org.example.demo

class ProduktFamilie_msprache {

	static searchable = true
	String name
	
	static hasMany = [produktFamilie:ProduktFamilie]
	
    static constraints = {
		name blank:false, unique:true
    }
}
