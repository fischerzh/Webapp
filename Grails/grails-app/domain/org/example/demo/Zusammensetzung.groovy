package org.example.demo

class Zusammensetzung {

	static searchable = true
	String name
	
	static hasMany = [inhaltsstoffe:Inhaltsstoffe]
	
    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
