package org.example.demo

class Gemeinde {
	
	String name
	String rabbinat

	static belongsTo = [ort:Ort]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
