import grails.util.Environment

class ApiKeyFilters {

    def filters = {
        apiKeyCheck(controller: 'jaxrs', action: '*') {
            before = {
                // Allow dev through
                if (Environment.isDevelopmentMode()) {
                    return true
                }
                // Get the api key from the headers
                def key = request?.getHeader("X-RJF-Apikey") ?: null

                if(!key) {
                    render(status: 401, text: "API key required")
                    return false
                }

                // Determine if the key is valid
                def allowed = grailsApplication.getClassForName("com.toastcoders.rjfacts.User").findByApiKey(key)

                // Check the result, redirect if necessary
                if (allowed instanceof com.toastcoders.rjfacts.User) {
                    return true
                }

                // Api key is bad
                render(status: 401, text: 'API key is invalid')
                return false
            }
        }
    }
}
