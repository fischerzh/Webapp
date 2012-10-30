package org.example.demo

class Hersteller {
	
	String name
	
	//static belongsTo = [ort:Ort]
	
    static constraints = {

    }
	
	String toString()  {
		return name? name: ""
	}
}
