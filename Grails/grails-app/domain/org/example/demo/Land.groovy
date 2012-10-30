package org.example.demo

class Land {
	
	String name

    static constraints = {
		name blank:false
    }
	
	String toString()  {
		return name? name: ""
	}
}
