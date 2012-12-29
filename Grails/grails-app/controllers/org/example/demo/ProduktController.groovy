package org.example.demo

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ProduktController {
    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
		def objList
		def objCount
		def verwalterList = Kontrolleur.list()
		if(params.q) {
			objList = Produkt.search(params.q + "*").results
			objCount = objList.size()
		}
		else {
			objList = Produkt.list(params)
			objCount = Produkt.count()
		}
		 
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[objInstanceList: objList, objInstanceTotal: objCount, verwalterList: verwalterList]		
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[productInstance: new Produkt(params)]
			
			break
		case 'POST':
	        def productInstance = new Produkt()
			
			productInstance.name = params.name
			productInstance.ean = params.ean
			productInstance.parve = params.parve
			productInstance.tolaim = params.tolaim			
			
			productInstance.istKoscher = params.istKoscher
			productInstance.istBischulak = params.istBischulak
			productInstance.istBliothlssur = params.istBliothlssur
			productInstance.istChalavakum = params.istChalavakum
			productInstance.istIsraelischesProdukt = params.istIsraelischesProdukt
			productInstance.istTarovetlssur = params.istTarovetlssur
			productInstance.pasPalter = params.pasPalter
			productInstance.istIGFLProdukt = params.istIGFLProdukt
			productInstance.istMp = params.istMp
			productInstance.externeKontrolle = params.externeKontrolle
			productInstance.erstellung = params.erstellung
			productInstance.veroeffentlichung = params.veroeffentlichung
			productInstance.geaendert = params.geaendert
			productInstance.naechsteKontrolle = params.naechsteKontrolle
			productInstance.kontrolle = params.kontrolle
						
			if(params.kontrolleur.id) {
				def kontrolleur = Kontrolleur.get(params.kontrolleur.id)
				productInstance.kontrolleur = kontrolleur
			}
			if(params.verpackung.id) {
				def verpackung = Verpackung.get(params.verpackung.id)
				productInstance.verpackung = verpackung
			}
			if(params.hersteller.id) {
				def hersteller = Hersteller.get(params.hersteller.id)
				productInstance.hersteller = hersteller
			}
			if(params.verteiler.id) {
				def verteiler = Verteiler.get(params.verteiler.id)
				productInstance.verteiler = verteiler
			}
			if(params.produktfamilie.id) {
				def produktfamilie = ProduktFamilie.get(params.produktfamilie.id)
				productInstance.produktfamilie = produktfamilie
			}
			if(params.verkaeufer.id) {
				def verkaeufer = Verkaeufer.get(params.verkaeufer.id)
				productInstance.verkaeufer = verkaeufer
			}
			
			if(params.selectedValue) {
				def inhaltsstoff = Inhaltsstoffe.get(params.selectedValue)
				productInstance.addToInhaltsstoffe(inhaltsstoff)
			}
			
	        if (!productInstance.save(flush: true)) {
	            render view: 'create', model: [productInstance: productInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
	        redirect action: 'show', id: productInstance.id
			break
		}
    }

    def show() {
        def productInstance = Produkt.get(params.id)
        if (!productInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
            redirect action: 'index'
            return
        }

        [productInstance: productInstance]
    }


    def edit() {
		switch (request.method) {
		case 'GET':
	        def productInstance = Produkt.get(params.id)
	        if (!productInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
	            redirect action: 'index'
	            return
	        }

	        [productInstance: productInstance]
			break
		case 'POST':
	        def productInstance = Produkt.get(params.id)
	        if (!productInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
	            redirect action: 'index'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (productInstance.version > version) {
	                productInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'product.label', default: 'Product')] as Object[],
	                          "Another user has updated this Product while you were editing")
	                render view: 'edit', model: [productInstance: productInstance]
	                return
	            }
	        }

	        productInstance.properties = params

	        if (!productInstance.save(flush: true)) {
	            render view: 'edit', model: [productInstance: productInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
	        redirect action: 'show', id: productInstance.id
			break
		}
    }

    def delete() {
        def productInstance = Produkt.get(params.id)
        if (!productInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
            redirect action: 'index'
            return
        }

        try {
            productInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'product.label', default: 'Product'), params.id])
            redirect action: 'index'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'product.label', default: 'Product'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
