package org.example.demo

class Kontrolleur {

	String name
	
	boolean ist_Kontrolleur
	boolean ist_Rabbi
	boolean ist_Aktiv
	boolean ist_Gemeinde
	
	static belongsTo = [typ:KontrollTyp]

	
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
