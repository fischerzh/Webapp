package org.example.demo

class Person {
	
	String name
	boolean ist_Kontrolleur
	boolean ist_Rabbi
	boolean ist_Aktiv
	
	//static belongsTo = [rabbinat:Rabbinat, gemeinde:Gemeinde]

    static constraints = {
		name blank:false, unique:true
		ist_Kontrolleur blank:false
		ist_Rabbi blank:false
		ist_Aktiv blank:false
    }
	
	String toString()  {
		return name? name: ""
	}
}
