package org.example.demo

class Verkaeufer {

	String name
	
	//static belongsTo = [ort:Ort]
	
    static constraints = {
		name blank:false, unique:true
    }
}
