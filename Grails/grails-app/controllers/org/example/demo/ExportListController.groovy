package org.example.demo
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.servlet.tags.form.SelectedValueComparator;

import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ExportListController {
	static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

	def exportService
	def grailsApplication
	
	def objList
	def objTotal

	def filter
	
	def index() {
		
		if(params.selectedValue) {	
			
			Filter.list().each { it.istAktiv = false }
						
			filter = Filter.get(params.selectedValue)		
			filter.istAktiv = true	
			def f = Produkt.createCriteria()
			objList = f.list {
					like('produktfamilie', filter.produktfamilie)
			}
			objTotal = objList.size()						
		}
		else {			
				objList = Produkt.list()
				objTotal = Produkt.count()
			}
		
		  render (view:'index', model: [ objInstanceList : objList, objInstanceTotal : objTotal])
	}
	
	def export() {
		
		def c = Filter.createCriteria()
		def results = c.list {
			like('istAktiv', true)
		}
		
		if(results) {
			filter = results.first()
			
			def f = Produkt.createCriteria()
			def filterList = f.list {
					like('produktfamilie', filter.produktfamilie)
			}	
			
			if(filter) {
				objList = Produkt.search(filter.name).results
				
				if(!params.max) params.max = 10
				
					response.contentType = grailsApplication.config.grails.mime.types["excel"]
					response.setHeader("Content-disposition", "attachment; filename=Produkt.xls")
									
					exportService.export("excel", response.outputStream, objList, [:], [:])
				filter.istAktiv = false
			}
		}
		else {
			redirect(action:'index')
		}
	}
	
}
