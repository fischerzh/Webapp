package org.example.demo

class Inhaltsstoffe_msprache {
	
	static searchable = true
	String name

	static belongsTo = [inhaltsstoffe:Inhaltsstoffe, sprachen:Sprachen]
	
    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
