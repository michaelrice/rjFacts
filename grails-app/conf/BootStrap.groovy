import com.toastcoders.rjfacts.User

class BootStrap {

    def init = { servletContext ->
        def admin = User.findById(1) ?: new User(username: "hero", apiKey: "c25ff106-e7e2-4d82-86b0-e7b530881617").save(flush: true)
    }
    def destroy = {
    }
}
