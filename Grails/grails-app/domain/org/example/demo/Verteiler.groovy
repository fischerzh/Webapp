package org.example.demo

class Verteiler {
	
	static searchable = true
	String name
	
	static belongsTo = [ort:Ort]

    static constraints = {
		name blank:false, unique:true
    }
	String toString()  {
		return name? name: ""
	}
}
