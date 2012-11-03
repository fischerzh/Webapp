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
		
    		
	}
    def destroy = { }
}
