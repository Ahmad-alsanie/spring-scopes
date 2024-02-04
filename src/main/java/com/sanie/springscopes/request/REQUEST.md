## Request Scope
This scope is valid in the context of a web-aware Spring ApplicationContext. 
For beans defined with request scope, a new instance is created for each HTTP request. 
That is, each HTTP request will have its own instance of a bean created off the back of the classes defined with this scope.

### Use case
It's useful for managing bean state within the lifecycle of an HTTP request. 
specially for web applications where you need to maintain state across the processing of a request.

### Example
Take a look at ```RequestCounter``` class