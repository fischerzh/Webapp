package org.example.demo

class Hersteller {
	
	static searchable = true
	String name
	
	static belongsTo = [ort:Ort]
	
    static constraints = {

    }
	
	String toString()  {
		return name? name: ""
	}
}
