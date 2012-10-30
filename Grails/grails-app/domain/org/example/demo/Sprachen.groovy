package org.example.demo

class Sprachen {
	
	String name
	String Sprach_Code

    static constraints = {
		name blank:false, unique:true
    }
	
	String toString()  {
		return name? name: ""
	}
}
