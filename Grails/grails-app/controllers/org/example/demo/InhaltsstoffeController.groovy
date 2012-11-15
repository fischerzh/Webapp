package org.example.demo

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured


@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class InhaltsstoffeController {
    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

	def index() {
		def objList
		def objCount
		if(params.q) {
			objList = Inhaltsstoffe.search(params.q + "*").results
			objCount = objList.size()
		}
		else {
			objList = Inhaltsstoffe.list(params)
			objCount = Inhaltsstoffe.count()
		}
		 
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [objInstanceList: objList, objInstanceTotal: objCount]
	}

     def list() {
        def objList
		def objCount
		if(params.q) {
			objList = Inhaltsstoffe.search(params.q + "*").results
			objCount = objList.size()
		}
		else {
			objList = Inhaltsstoffe.list(params)
			objCount = Inhaltsstoffe.count()
		}
		 
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [objInstanceList: objList, objInstanceTotal: objCount]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[objInstance: new Inhaltsstoffe(params)]
			
			break
		case 'POST':
	        def objInstance = new Inhaltsstoffe(params)
	        if (!objInstance.save(flush: true)) {
	            render view: 'create', model: [objInstance: objInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), objInstance.id])
	        redirect action: 'show', id: objInstance.id
			break
		}
    }

    def show() {
        def objInstance = Inhaltsstoffe.get(params.id)
        if (!objInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), params.id])
            redirect action: 'index'
            return
        }

        [objInstance: objInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def objInstance = Inhaltsstoffe.get(params.id)
	        if (!objInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), params.id])
	            redirect action: 'index'
	            return
	        }

	        [objInstance: objInstance]
			break
		case 'POST':
	        def objInstance = Inhaltsstoffe.get(params.id)
	        if (!objInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), params.id])
	            redirect action: 'index'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (objInstance.version > version) {
	                objInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff')] as Object[],
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

			flash.message = message(code: 'default.updated.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), objInstance.id])
	        redirect action: 'show', id: objInstance.id
			break
		}
    }

    def delete() {
        def objInstance = DummyClass.get(params.id)
        if (!objInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoffe'), params.id])
            redirect action: 'index'
            return
        }

        try {
            objInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), params.id])
            redirect action: 'index'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'Inhaltsstoffe.label', default: 'Inhaltsstoff'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
