package org.example.demo

class ExportJsonController {

def exportService
	def grailsApplication
	List<Produkt> objList = Produkt.list()
	HashMap jsonMap = new HashMap()
	
	def index() {
		
		jsonMap.produkte = objList.collect {prod ->
			return [id: prod.id, name: prod.name, chalavakum: prod.istChalavakum, parve: prod.parve, verpackung: prod.verpackung, kontrolleur: prod.kontrolleur, hersteller: prod.hersteller, inhaltsstoffe: prod.inhaltsstoffe ]
		}
		
		if(!params.max) params.max = 10
		if(params?.format && params.format != "html"){
		response.contentType = grailsApplication.config.grails.mime.types[params.format]
		response.setHeader("Content-disposition", "attachment; filename=land.${params.extension}")
		
		response.outputStream << jsonMap
	}
	   [ objInstanceList: objList, objInstanceTotal: objList.size() ]
	}
}
