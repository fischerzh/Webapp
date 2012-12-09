package org.example.demo

class Verkaeufer {

	static searchable = true
	String name
	
	static belongsTo = [ortList:Ort]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
