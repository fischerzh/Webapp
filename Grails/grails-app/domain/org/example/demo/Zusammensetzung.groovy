package org.example.demo

class Zusammensetzung {

	String name
	
    static constraints = {
    }
	
	String toString()  {
		return name? name: ""
	}
}
