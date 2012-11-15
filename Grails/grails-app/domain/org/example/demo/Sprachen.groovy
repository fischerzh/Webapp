package org.example.demo

class Sprachen {
	
	static searchable = true
	String name
	String sprachcode

    static constraints = {
		name blank:false, unique:true
		sprachcode blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
