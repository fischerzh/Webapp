package org.example.demo

class Filter {
	
	static searchable = true
	String name
	boolean koscher = true
	
	static belongsTo = [gemeinde:Gemeinde, produktfamilie:ProduktFamilie]

    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
