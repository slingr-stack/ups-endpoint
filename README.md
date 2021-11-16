---
title: UPS endpoint
keywords: 
last_updated: October 3, 2019
tags: []
summary: "Detailed description of the API of the UPS endpoint."
---

## Overview

The UPS endpoint make easy to interact with UPS Developer Kit APIs.

Some of the features are:

- Track packages

In most cases you will be using the provided shortcuts to access the API. For example, you could use the REST API
directly by doing an HTTP request like this:

```js
var res = app.endpoints.ups.post('/Track', {
 "TrackRequest": {
   "Request": {
     "RequestOption": "1",
     "TransactionReference": {
       "CustomerContext": "Your Test Case Summary Description"
     }
   },
   "InquiryNumber": "YourTrackingNumber"
 }
});
```

However you probably want to use the shortcuts:

```js
var res = app.endpoints.ups.track.post({
 "TrackRequest": {
   "Request": {
     "RequestOption": "1",
     "TransactionReference": {
       "CustomerContext": "Your Test Case Summary Description"
     }
   },
   "InquiryNumber": "YourTrackingNumber"
 }
});
```

These shortcuts are based on the [UPS REST API](https://www.ups.com/upsdeveloperkit).
You can see more information about that in the [shortcuts section](#shortcuts).


## Configuration

### Customer Integration Environment
Environment to be used

### User Name
User name to access to UPS service

### Password
Password to access to UPS service

### Api Key
The API key of the application needed to validate requests.

## Javascript API

The Javascript API of the UPS endpoint has three pieces:

- **HTTP request**: this allows to make regular HTTP requests. In case of UPS `POST` to the API. All request are signed.
- **Shortcuts**: these are helpers to make HTTP request to the API in a more convenient way.

### HTTP requests

You can make `POST` request to the [UPS API](https://www.ups.com/upsdeveloperkit) like this:

```js
var res = app.endpoints.ups.post('/Track', {
"TrackRequest": {
   ...
 }
});
```

### Shortcuts

Instead of having to use the generic HTTP methods, you can make use of the shortcuts provided in the endpoint. These
shortcuts follow these rules:

- **Path sections get converted to namespaces**: for example `~/Track` 
  it is converted to `app.endpoints.ups.track.post({...})`. 

| URL  | Namespace  |
|---|---|
| ~/Track  | `app.endpoints.ups.track.post(...)`  |
| ~/Pickup  | `app.endpoints.ups.pickUp.post(...)`  | 
| ~/Rate  | `app.endpoints.ups.rate.post(...)`  | 
| ~/Ship  | `app.endpoints.ups.ship.post(...)`  | 
| ~/Void  | `app.endpoints.ups.void.post(...)`  | 
| ~/LBRecovery  | `app.endpoints.ups.lbRecovery.post(...)`  | 
| ~/TimeInTransit  | `app.endpoints.ups.timeInTransit.post(...)`  | 
| ~/AV  | `app.endpoints.ups.av.post(...)`  | 
  
  
Additionally there are a helper to track a package by 

`app.endpoints.ups.track.trackByInquiryNumber(inquiryNumber) {...}`

## About SLINGR

SLINGR is a low-code rapid application development platform that accelerates development, with robust architecture for integrations and executing custom workflows and automation.

[More info about SLINGR](https://slingr.io)

## License

This endpoint is licensed under the Apache License 2.0. See the `LICENSE` file for more details.

