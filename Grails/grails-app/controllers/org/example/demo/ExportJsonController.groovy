package org.example.demo

class ExportJsonController {

	def exportService
	def grailsApplication
	
	
	def index() {
		
		if(!params.max) params.max = 10
		if(params?.format && params.format != "html"){
		response.contentType = grailsApplication.config.grails.mime.types[params.format]
		response.setHeader("Content-disposition", "attachment; filename=land.${params.extension}")
		
		response.outputStream << Land.list(params)
	}
	   [ objInstanceList: Land.list( params ), objInstanceTotal: Land.count() ]
	}
}
