package org.example.demo

class Gemeinde {
	
	static searchable = true
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
