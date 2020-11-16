#Solution
Thank you for using the beta version of the mars rover control, to teach english to our alien neighbors on Mars.

This API allows to send commands to the mars rover from ground control with four endpoints.

The Mars Rover could perform three actions:

· To move in any direction

· To stand still charging its batteries

· To transmit texts in English

#Technology
- We decide to use Java 11 because it's a very known version and it looks like could be enough to this test project.
- Java Spring boot 2.4.0 is now released but we decided to use the 2.3.3 version because I'm very familiarizated with it. 

#Repository
I've decided to use H2 in memory DB to store data to test the beta version. It's easy to change to a phisical h2 storage version when this beta will be released.

#### Init Data
As a resource, there is a data.sql file that inits DB with our Mars Rover and several texts to transmit.


#Endpoints
· To charge our mars Rover batteries, we can use this endpoint

_PUT_
`v1/mars-rover/{id}/charge`

---
· To transmit any text in english, we can use this endpoint with the parameter _text_ with the text we would to transmit

_PUT_  
`v1/mars-rover/{id}/transmit?text=test`

· _text_: Text that we want to transmit

--- 
·To move the mars Rover we can use this endpoint passing as parameters the distance in meters and the angle in degrees.
 
_PUT_
`v1/mars-rover/{id}/move?distance=1&angle=90`

· _distance_: Distance in meters that we want to move the mars rover

· _angle_: Angle in degrees of the direction in which we want to move the mars rover with respect to an initial coordinate axis.

---
· We can re-transmit randomly any sentence that we've transmitted before, using this endpoint

_GET_ `v1/mars-rover/{id}/transmit-random`


#Considerations
· This is the beta version with MVP features. We can add more features as log all the text we send, or draw the route that our mars rover do, but this will be implemented on next versions.

· I've created a branch to work on it (`feature/beta-version`) and finally I merged it on master.

· The first thing I would do as a next feature will be implement security, but I've no time for this beta version.

· We start writting this project thinking on another kind of vehicles, but for this MVP there are only this mars rover.

· I've supposed for the movement that Mars acts as flat map, using a two dimensions axis. In other versions we can use 3D coordinates or longitude and latitude. 

#Test
I've used jUnit4, because I'm familiarizated with this version.
I've tried to use TDD but in  some part of the process that I've not used it. 

#Documentation
We can use Swagger for document the endpoints but I finally decide for the MVP, java docs.

##Some libraries
· I've used Lombok for getter and setters and some constructors.

· I've used mapstruct for the mars rover mapper. 
