## Singleton Scope
This is the default scope in Spring. For a bean defined with singleton scope, the Spring IoC (Inversion of Control) container creates a single instance of the bean. 
This single instance is stored in a cache of such singleton beans, and all subsequent requests and references for that bean will return the cached object.

### Use case
It is suitable for stateless beans where the same instance can be shared across the application.

### Example
Take a look at ```ConfigurationService``` class
