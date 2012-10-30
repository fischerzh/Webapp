package org.example.demo

class Gemeinde {
	
	String name

	//static belongsTo = [ort:Ort, rabbinat:Rabbinat]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
