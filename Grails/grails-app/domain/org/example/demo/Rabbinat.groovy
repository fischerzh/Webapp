package org.example.demo

class Rabbinat {
	
	String name

    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
