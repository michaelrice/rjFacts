package com.toastcoders.rjfacts

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class FactService {

    Random random

    def getRandomFact() {
        random = new Random()
        def facts = Fact.findAll()
        int max = facts.size()
        if(max < 1) {
            throw new DomainObjectNotFoundException(Fact.class,1)
        }
        return facts.get(random.nextInt(max))
    }

    def getTaskById(int id) {
        def fact = Fact.findById(id)
        if(!fact) {
            throw new DomainObjectNotFoundException(Fact.class, id)
        }
        return fact
    }

    def createNewFact(Fact fact) {
        def newfact = fact.save(flush: true)
        return newfact
    }

    def deleteFact(int id) {
        def fact = Fact.get(id)
        if(!fact) {
            throw new DomainObjectNotFoundException(Fact.class,id)
        }
        fact.delete(flush: true)
    }
}