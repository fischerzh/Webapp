package org.example.demo

class Gemeinde {
	
	static searchable = true
	String name
	String rabbinat

	static belongsTo = [ortList:Ort]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
