package org.example.demo
import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ExportListController {
	static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

	def exportService
	def grailsApplication
	
	def index() {
		
		def objList
		def objTotal
		
		if(params.id) {
			objList = Produkt.search("Milch").results
			objTotal = objList.size()
		}
		else {
			objList = Produkt.list()
			objTotal = Produkt.count()
		}		
		
		if(!params.max) params.max = 10
		if(params?.format && params.format != "html"){
		response.contentType = grailsApplication.config.grails.mime.types[params.format]
		response.setHeader("Content-disposition", "attachment; filename=Produkt.${params.extension}")
				
		exportService.export(params.format, response.outputStream, objList, [:], [:])
		}
		   [ objInstanceList : objList, objInstanceTotal : objTotal]
	}
		
}
