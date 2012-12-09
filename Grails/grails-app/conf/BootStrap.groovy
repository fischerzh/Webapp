import org.example.demo.*

class BootStrap {

    def init = { servletContext ->
		
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
		
		def user1 = User.findByUsername('marco') ?: new User(username: 'marco', enabled:true, password: 'pass', firstName: 'Marco', lastName: 'Fischer').save(failOnError: true)
		def user2 = User.findByUsername('admin') ?: new User(username: 'admin', enabled:true, password: 'pass', firstName: 'Admin', lastName: 'Admin').save(failOnError: true)
		def user3 = User.findByUsername('rdewor') ?: new User(username: 'rdewor', enabled:true, password: 'pass', firstName: 'Robert', lastName: 'Dewor').save(failOnError: true)
						
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
    	
		def land1 = new Land(name:'Schweiz')
		land1.save(failOnError:true)
		def land2 = new Land(name:'Deutschland')
		land2.save(failOnError:true)
		
		def ort1 = new Ort(name: 'Zuerich', zip:'8000', landList:land1)
		ort1.save(failOnError:true)
		def ort2 = new Ort(name:'Bern', zip:'9000', landList:land1)
		ort2.save(failOnError:true)
		
		def sprache1 = new Sprachen(name:'Deutsch', sprachcode:'de')
		sprache1.save(failOnError:true)
		def sprache2 = new Sprachen(name:'Englisch', sprachcode:'en')	
		sprache2.save(failOnError:true)
		
		def gemeinde1 = new Gemeinde(name:'Oerlikon', rabbinat:'Rabbinat Oerlikon', ortList:ort1)
		gemeinde1.save(failOnError:true)
		def gemeinde2 = new Gemeinde(name:'Wipkingen', rabbinat:'Rabbinat Wipkingen', ortList:ort1)
		gemeinde2.save(failOnError:true)
		
		def verkaeufer1 = new Verkaeufer(name:'test Verkaeufer', ortList:ort1)
		verkaeufer1.save(failOnError:true)
		def verkaeufer2 = new Verkaeufer(name:'test Verkaeufer2', ortList:ort1)
		verkaeufer2.save(failOnError:true)
		
		def verpackungswert1 = new Verpackung_werte(verpackung:'kg')
		verpackungswert1.save(failOnError:true)
		
		def verpackung1 = new Verpackung(wert:1, verpackung_werte:verpackungswert1)
		verpackung1.save(failOnError:true)
		def verpackung2 = new Verpackung(wert:2, verpackung_werte:verpackungswert1)
		verpackung2.save(failOnError:true)
		
		def inhaltsstoff1 = new Inhaltsstoffe(name:'Kohlenhydrahte')
		inhaltsstoff1.save(failOnError:true)
		def inhaltsstoff2 = new Inhaltsstoffe(name:'Zucker')
		inhaltsstoff2.save(failOnError:true)
		
		def hersteller1 = new Hersteller(name:'Nestle', ort:ort1)
		hersteller1.save(failOnError:true)
		def hersteller2 = new Hersteller(name:'Migros', ort:ort1)
		hersteller2.save(failOnError:true)
		
		def verteiler1 = new Verteiler(name:'Coop', ort:ort1)
		verteiler1.save(failOnError:true)
		def verteiler2 = new Verteiler(name:'Migros', ort:ort1)
		verteiler2.save(failOnError:true)
		
		def typ1 = new KontrollTyp(typ:'Mensch')
		typ1.save(failOnError:true)
		
		def kontrolleur1 = new Kontrolleur(name:'test Kontrolleur', istKontrolleur:true, istAktiv:true, istGemeinde:false, istRabbi:true, typ:typ1)
		kontrolleur1.save(failOnError:true)
		def kontrolleur2 = new Kontrolleur(name:'test Kontrolleur 2', istKontrolleur:true, istAktiv:true, istGemeinde:false, istRabbi:false, typ:typ1)
		kontrolleur2.save(failOnError:true)
		
		def familiem = new ProduktFamilie_msprache(name:'Milch')
		familiem.save(failOnError:true)
		def familiem2 = new ProduktFamilie_msprache(name:'Brot')
		familiem2.save(failOnError:true)
		
		def produktfamilie1 = new ProduktFamilie(name:'Milch', produktfamilie_msprache:familiem)
		produktfamilie1.save(failOnError:true)
		def produktfamilie2 = new ProduktFamilie(name:'Brot', produktfamilie_msprache:familiem2)
		produktfamilie2.save(failOnError:true)
		
		def filter1 = new Filter(name:'Milch',gemeinde:gemeinde1, produktfamilie:produktfamilie1 )
		filter1.save(failOnError:true)
		def filter2 = new Filter(name:'Brot', gemeinde:gemeinde1, produktfamilie:produktfamilie2 )
		filter2.save(FailOnError:true)
		
		def produkt1 = new Produkt(name:'Fettfreie Milch', ean:'1', istKoscher:true, istVegan:false,
								istVegetarisch:false, istBischulak:false, istBliothlssur:false,
								istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
								pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
								parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
								kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
								hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie1,
								inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt1.save(failOnError:true)
		def produkt2 = new Produkt(name:'Bio Milch', ean:'2', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie1,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt2.save(failOnError:true)
		def produkt3 = new Produkt(name:'Milch Shake', ean:'3', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie1,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt3.save(failOnError:true)
		def produkt4 = new Produkt(name:'Milch Pulver', ean:'4', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie1,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt4.save(failOnError:true)
		def produkt5 = new Produkt(name:'Vollkorn Brot', ean:'5', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie2,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt5.save(failOnError:true)
		def produkt6 = new Produkt(name:'Weiss Brot', ean:'6', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie2,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt6.save(failOnError:true)
		def produkt7 = new Produkt(name:'Roggen Brot', ean:'7', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie2,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt7.save(failOnError:true)
		def produkt8 = new Produkt(name:'Weizen Brot', ean:'8', istKoscher:true, istVegan:false,
			istVegetarisch:false, istBischulak:false, istBliothlssur:false,
			istChalavakum:false, istIsraelischesProdukt:false, istTarovetlssur:false,
			pasPalter:false, istIGFLProdukt:true, istMp:true, externeKontrolle:false,
			parve:'parve', tolaim:'tolaim', erstellung: new Date(), veroeffentlichung: new Date(),
			kontrolle: new Date(), geaendert: new Date(), naechsteKontrolle: new Date(),
			hersteller:hersteller1, verteiler:verteiler1, verpackung:verpackung1, produktfamilie:produktfamilie2,
			inhaltsstoffe:inhaltsstoff1, verkaeufer:verkaeufer1, kontrolleur:kontrolleur1 )
		produkt8.save(failOnError:true)
		
		
	}
    def destroy = { }
}
