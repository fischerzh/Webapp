package org.example.demo

class Inhaltsstoffe_msprache {
	
	String name

	//static belongsTo = [inhaltsstoffe:Inhaltsstoffe, sprachen:Sprachen]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
