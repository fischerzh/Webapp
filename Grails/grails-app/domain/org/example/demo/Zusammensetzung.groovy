package org.example.demo

class Zusammensetzung {

	String name
	
	static hasMany = [inhaltsstoffe:Inhaltsstoffe]
	
    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
