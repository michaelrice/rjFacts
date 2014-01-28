#RJFacts

## Info
RJ Facts is a simple grails app that powers a site where you can find facts about RJ. These facts are internet facts. Much like Chuck Norris or Mr T facts.

## Usage
This app can be deployed directly as is and will create a user via the Bootstrap.groovy file named "hero" with an Apikey of ""

Currently the application only supports usage via the API which can be accessed at:

    localhost:8080/rjFacts/api/

The API only support JSON at this time, and there are no plans to support XML.

In development mode (grails run-app) you do not need an API Key.
In production mode (deployed to tomcat for example) you will need to access using the apikey

###Examples
This will fetch a random RJ fact from the database

    curl -v -k -H "X-RJF-Apikey: 123456qwerty" https://site.com/api/fact

You can also POST (using above URL) to add new facts. A json body of:

    {
        "class":"com.toastcoders.rjfacts.Fact",
        "createdBy":{
            "class":"User",
            "id":1
        },
        "factoid":"thinking of facts is hard"
    }

You will get a JSON response of your new factoid with an id. The id can be used below.

You can also get a specific fact if you know its id:

    curl -v -k -H "X-RJF-Apikey: 1234456qwerty" https://site.com/api/fact/11

If you get tired of a fact it can be deleted like so:

    curl -v -k -H "X-RJF-Apikey: 123456qwerty" -XDELETE https://site.com/api/fact/11

###TODO
The fact has a notion of karma, would be good to add a way to raise and lower that value. It should also support neg numbers.
