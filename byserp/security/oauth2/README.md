## Oauth2 guidelines

#### How to get access token by grant types

##### Password grant type
``
localhost:9000/oauth/token?grant_type=password&client_secret=secret&client_id=client&username=user&password=user
``

#### authorization_code
``
http://localhost:9000/oauth/authorize?client_id=client&response_type=code&state=5ca75bd30&redirect_uri=http://localhost:8080
``