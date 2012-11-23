package org.example.demo

class ExportListController {

	def exportService
	def grailsApplication
	
	
	def index() {
		if(!params.max) params.max = 10	
			if(params?.format && params.format != "html"){
			response.contentType = grailsApplication.config.grails.mime.types[params.format]
			response.setHeader("Content-disposition", "attachment; filename=land.${params.extension}")
			
			exportService.export(params.format, response.outputStream,Land.list(params), [:], [:])
		}     
		   [ objInstanceList: Land.list( params ), objInstanceTotal: Land.count() ]

	}
}
