package org.example.demo

class ProduktFamilie_msprache {

	static searchable = true
	String name
	
    static constraints = {
		name blank:false, unique:true
    }
}
