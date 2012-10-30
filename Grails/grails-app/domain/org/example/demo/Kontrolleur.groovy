package org.example.demo

class Kontrolleur {

	String name
	String type
	
	//static belongsTo = [rabbinat:Rabbinat, person:Person]
	//static hasMany = [produkt:Produkt]
	
    static constraints = {
		name blank:false, unique:true
    }
	String toString()  {
		return name? name: ""
	}
	
}
