package org.example.demo

class Kontrolleur {

	static searchable = true
	String name
	
	boolean istKontrolleur
	boolean istRabbi
	boolean istAktiv
	boolean istGemeinde
	
	static belongsTo = [typ:KontrollTyp]

	
   	static constraints = {
		name blank:false, unique:true
		istKontrolleur blank:false
		istRabbi blank:false
		istAktiv blank:false
	}
	   String toString()  {
		   return name? name: ""
	   }
	   
}
