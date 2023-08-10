# Spring-Boot-REST-API-Consumer
It is a sample spring boot application which demonstrates the implementation and working behind consuming a REST API

---
## Appraoch 1: Using RestTemplate getForOjbect() or getForEntity() object

Both getForObject() and getForEntity() methods present in RestTemplate are used to send a GET request to an HTTP endpoint.

**The difference is that getForEntity() provides a more granular level of control to us as it returns a ResponseEntity object which contains the status code, headers, and the response body. We then have the flexibility to extract information from the ResponseEntity as needed.**

**But, in case of getForObject(), it directly returns a deserialized object as the result which is more concise and straightforward. If the response cannot be deserialized into the specified class, an exception will be thrown.**

In a standard HTTP GET request, headers are usually not used to send data in the request body. Headers are typically used to provide metadata about the request, such as authentication tokens, content type preferences, etc.

If you're working with a situation where you need to send both headers and a request body, it might be more appropriate to use an HTTP method like POST or PUT, which support sending data in the request body along with headers.

The following is how we can use the getForEntity() method
```
ResponseEntity<List> response = restTemplate.getForEntity(wsUrl, List.class, queryParams)
```

---
## Approach 2: Using RestTemplate exchange() method

The exchange() method is a more flexible option that allows you to perform any HTTP method (GET, POST, PUT, DELETE, etc.) and provides full control over the request and response. It returns a ResponseEntity object.

The following is how we make use of exchange() method in general
```
HttpEntity<RequestType> requestEntity = new HttpEntity<>(request, headers);
ResponseEntity<ResponseType> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
```


