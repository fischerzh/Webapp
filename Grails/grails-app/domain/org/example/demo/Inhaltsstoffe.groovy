package org.example.demo

class Inhaltsstoffe {
	
	static searchable = true
	String name
	
    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
