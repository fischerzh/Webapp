package org.example.demo

class Filter {
	
	static searchable = true
	String name
	boolean koscher = true
	boolean istAktiv = false
	
	static belongsTo = [gemeinde:Gemeinde, produktfamilie:ProduktFamilie]

    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
