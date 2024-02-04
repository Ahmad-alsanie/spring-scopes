## Session Scope
Similar to request scope, but broader, session scope in a web-aware context means that a bean defined with this scope is created once per HTTP session.
Each session will have its own instance of a bean, shared across multiple requests in the same session.

### Use case
It is suitable for cases where you want to maintain user state across multiple interactions with a web application during the lifetime of an HTTP session.

### Example
Take a look at ```UserPreferences``` class
