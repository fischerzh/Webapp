package org.example.demo

class Filter {
	
	String name
	boolean koscher = true
	
	static belongsTo = [gemeinde:Gemeinde, produktfamilie:ProduktFamilie]

    static constraints = {
    }
}
