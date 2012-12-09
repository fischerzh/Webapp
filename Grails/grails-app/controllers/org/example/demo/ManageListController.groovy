package org.example.demo
import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ManageListController {
	static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']
	
	def index() {
		
		def objList
		def objTotal
		
		if(params.q) {
			objList = Produkt.search(params.q + "*").results
			objTotal = objList.size()
		}
		else {
			objList = Produkt.list()
			objTotal = Produkt.count()
		}
		   [ objInstanceList : objList, objInstanceTotal : objTotal]
	}
	
	def deactivate() {
		def objInstance = Produkt.get(params.id)
		objInstance?.aktiv = false
		redirect action: 'index'
	}
	
	def activate() {
		def objInstance = Produkt.get(params.id)
		objInstance?.aktiv = true
		redirect action: 'index'
	}
	
}
