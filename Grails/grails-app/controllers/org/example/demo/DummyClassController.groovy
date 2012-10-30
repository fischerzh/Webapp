package org.example.demo

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class DummyClassController {
    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

	def index() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [objInstanceList: DummyClass.list(params), objInstanceTotal: DummyClass.count()]
	}

     def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [objInstanceList: DummyClass.list(params), objInstanceTotal: DummyClass.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[objInstance: new DummyClass(params)]
			
			break
		case 'POST':
	        def objInstance = new DummyClass(params)
	        if (!objInstance.save(flush: true)) {
	            render view: 'create', model: [objInstance: objInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), objInstance.id])
	        redirect action: 'show', id: objInstance.id
			break
		}
    }

    def show() {
        def objInstance = DummyClass.get(params.id)
        if (!objInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'Verwalter.label', default: 'Verwalter'), params.id])
            redirect action: 'index'
            return
        }

        [objInstance: objInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def objInstance = DummyClass.get(params.id)
	        if (!objInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), params.id])
	            redirect action: 'index'
	            return
	        }

	        [objInstance: objInstance]
			break
		case 'POST':
	        def objInstance = DummyClass.get(params.id)
	        if (!objInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'verwalter.label', default: 'verwalter'), params.id])
	            redirect action: 'index'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (objInstance.version > version) {
	                objInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'verwalter.label', default: 'Verwalter')] as Object[],
	                          "Another user has updated this Object while you were editing")
	                render view: 'edit', model: [objInstance: objInstance]
	                return
	            }
	        }

	        objInstance.properties = params

	        if (!objInstance.save(flush: true)) {
	            render view: 'edit', model: [objInstance: objInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), objInstance.id])
	        redirect action: 'show', id: objInstance.id
			break
		}
    }

    def delete() {
        def objInstance = DummyClass.get(params.id)
        if (!objInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), params.id])
            redirect action: 'index'
            return
        }

        try {
            objInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), params.id])
            redirect action: 'index'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'verwalter.label', default: 'Verwalter'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
