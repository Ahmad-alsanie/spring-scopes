## Prototype
For beans defined with prototype scope, the Spring container creates a new instance each time a request for that bean is made. 
Unlike singleton beans, prototype beans are not stored in a cache, and the container does not manage the complete lifecycle of a prototype bean; the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance

### Use case
Prototype scope is useful when each consumer needs a unique instance of a bean.

### Example
Take a look at ```ReportGenerator``` class