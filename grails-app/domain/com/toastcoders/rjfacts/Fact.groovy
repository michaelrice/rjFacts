package com.toastcoders.rjfacts

class Fact {

    String factoid
    Date dateCreated
    Date lastUpdated
    User createdBy
    int karma

    static constraints = {
    }

    static mapping = {
        factoid type: 'text'
    }
}
