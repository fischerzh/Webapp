package org.example.demo

class Gemeinde {
	
	String nam

	//static belongsTo = [ort:Ort]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
