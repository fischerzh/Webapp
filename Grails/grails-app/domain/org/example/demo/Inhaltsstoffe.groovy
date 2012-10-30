package org.example.demo

class Inhaltsstoffe {
	
	String name
	
    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
