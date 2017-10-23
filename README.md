REST API in JAVA using JAX-RS implementation on Jersey.

So far the API consists of Models (Profile, Messages, Comments) with CRUD capabilities on each model as per HTTP requests.

Relationships between models:
* One-Many <-]
* One-One <->


The relationships are:
Message <-] Comments
Profile <-]

So for each profile, N message 'boxes' exists with M comments.

Additionally, a mock-up database class (name- DatabaseClass) is used to simulate the model database.


