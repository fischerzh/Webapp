package org.example.demo

class Ort {

	String name
	String zip
	
	//static hasMany = [hersteller:Hersteller, verteiler:Verteiler, verkaeufer:Verkaeufer, gemeinde:Gemeinde ]
	static belongsTo = [land:Land]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
