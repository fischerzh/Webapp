package org.example.demo

class Land {
	
	static searchable = true
	String name

    static constraints = {
		name blank:false
    }
	
	String toString()  {
		return name? name: ""
	}
}
