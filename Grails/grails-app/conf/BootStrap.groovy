import org.example.demo.*

class BootStrap {

    def init = { servletContext ->
		
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
		
		def user1 = User.findByUsername('marco') ?: new User(username: 'marco', enabled:true, password: 'pass', firstName: 'Marco', lastName: 'Fischer').save(failOnError: true)
		def user2 = User.findByUsername('admin') ?: new User(username: 'admin', enabled:true, password: 'pass', firstName: 'Admin', lastName: 'Admin').save(failOnError: true)
		def user3 = User.findByUsername('rdewor') ?: new User(username: 'rdewor', enabled:true, password: 'pass', firstName: 'Robert', lastName: 'Dewor').save(failOnError: true)
		
		def land = new Land(name:'Schweiz').save(failOnError:true)
		def ort = new Ort(name: 'Zuerich', zip:'8037').save(failOnError:true)
		
		def sprache = new Sprachen(name:'deutsch', Sprach_Code:'DE').save(failOnError:true)
		def rabbinat = new Rabbinat(name:'testRabbinat').save(failOnError:true)
		
		def gemeinde = new Gemeinde(name:'oerlikon').save(failOnError:true)
		
		def hersteller = new Hersteller(name: 'nestle').save(failOnError:true)
		
		def person = new Person(name:'admin', ist_Kontrolleur:true, ist_Rabbi:true, ist_Aktiv:true).save(failOnError:true)
				
		def kontrolleur = new Kontrolleur(name:'TestKontrolleur', type:'testType').save(failOnError:true)
		
		def produktfamilie_msprache = new ProduktFamilie_msprache(name:'getränk').save(failOnError:true)		
		def produktfamilie = new ProduktFamilie(name:'testFamilie').save(failOnError:true)

		def verkaeufer = new Verkaeufer(name:'Migros').save(failOnError:true)
		
		def verpackung_werte = new Verpackung_werte(verpackung:'kunststoff').save(failOnError:true)
		
		def verpackung_werte_msprache = new Verpackung_werte_msprache(verpackung:'kunststoff').save(failOnError:true)
		
		def verpackung = new Verpackung(name:'kunststoff').save(failOnError:true)
		
		def verteiler = new Verteiler(name:'Verteiler').save(failOnError:true)
		
		def inhaltsstoffe = new Inhaltsstoffe(name:'testInhalt').save(failOnError:true)
		
		def inhaltsstoffe_msprache = new Inhaltsstoffe_msprache(name:'cola').save(failOnError:true)
		
		def zusammensetzung = new Zusammensetzung(name:'testZusammensetzung').save(failOnError:true)
		
		
				
		if (!user1.authorities.contains(userRole)) {
			UserRole.create user1, userRole, true
		}
		
		if (!user2.authorities.contains(adminRole)) {
			UserRole.create user2, adminRole, true
		}
		
		if (!user3.authorities.contains(adminRole)) {
			UserRole.create user3, adminRole, true
		}
		
		assert User.count == 3
		assert Role.count == 2
		
    		
	}
    def destroy = { }
}
